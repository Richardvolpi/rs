<?php

define('PUN_ROOT', './');
require PUN_ROOT.'include/common.php';

if($pun_user['is_guest'])
	message($lang_common['No permission']);

// Load the register.php language file
require PUN_ROOT.'lang/'.$pun_user['language'].'/register.php';

// Load the register.php/profile.php language file
require PUN_ROOT.'lang/'.$pun_user['language'].'/prof_reg.php';

$action = isset($_GET['action']) ? $_GET['action'] : null;

if ($action == 'delete') {
	$id = trim($_GET['user']);
	
	$result = $db->query('SELECT * FROM '.$db->prefix.'rscd_players WHERE `user`='.$id) or error('Unable to fetch player info', __FILE__, __LINE__, $db->error());
	if(!$db->num_rows($result))
		message($lang_common['Bad request']);
	
	$user = $db->fetch_assoc($result);
	
	if($pun_user['g_id'] != PUN_ADMIN)
		message($lang_common['No permission']);
	
	if(isset($_POST['form_sent'])) {
	      	$db->query('DELETE FROM '.$db->prefix.'rscd_curstats WHERE `user`=\''.$db->escape($id).'\'') or error('Unable to delete rscd_curstats', __FILE__, __LINE__, $db->error());
	      	$db->query('DELETE FROM '.$db->prefix.'rscd_experience WHERE `user`=\''.$db->escape($id).'\'') or error('Unable to delete rscd_experience', __FILE__, __LINE__, $db->error());
	      	$db->query('DELETE FROM '.$db->prefix.'rscd_friends WHERE `user`=\''.$db->escape($id).'\' OR `friend`=\''.$db->escape($id).'\'') or error('Unable to delete rscd_friends', __FILE__, __LINE__, $db->error());
	      	$db->query('DELETE FROM '.$db->prefix.'rscd_ignores WHERE `user`=\''.$db->escape($id).'\' OR `ignore`=\''.$db->escape($id).'\'') or error('Unable to delete rscd_ignores', __FILE__, __LINE__, $db->error());
	      	$db->query('DELETE FROM '.$db->prefix.'rscd_invitems WHERE `user`=\''.$db->escape($id).'\'') or error('Unable to delete rscd_invitems', __FILE__, __LINE__, $db->error());
	      	$db->query('DELETE FROM '.$db->prefix.'rscd_players WHERE `user`=\''.$db->escape($id).'\'') or error('Unable to delete rscd_players', __FILE__, __LINE__, $db->error());
	      	$db->query('DELETE FROM '.$db->prefix.'rscd_reports WHERE `from`=\''.$db->escape($id).'\' OR `about`=\''.$db->escape($id).'\'') or error('Unable to delete rscd_reports', __FILE__, __LINE__, $db->error());
	      	
	      	logoutuser($id);
	      	
	      	redirect('profile.php?section=rscd&id='.$user['owner'], 'Player deleted');
      	}
      	
	$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Confirm Delete';
	require PUN_ROOT.'header.php';
?>
<div class="blockform">
	<h2><span>Confirm Delete</span></h2>
	<div class="box">
		<form action="rscd.php?action=delete&user=<?php echo pun_htmlspecialchars($id); ?>" method="POST">
			<div class="inform">
				<fieldset>
					<input type="hidden" name="form_sent" value="1" />
					<legend>Delete Player</legend>
					<div class="infldset" style="text-align:center">
	    				<p><input type="submit" name="delete" value="Confirm Delete" style="width:200px" /></p>
		    				<p>Please confirm you wish to delete the player "<?php echo pun_htmlspecialchars($user['username']); ?>". <b>This action is not reversible!</b></p>
					</div>
				</fieldset>
			</div>
		</form>
	</div>
</div>
<?php
	require PUN_ROOT.'footer.php';
      	
}
else if ($action == 'change_pass') {
	$id = trim($_GET['user']);
	
	$result = $db->query('SELECT * FROM '.$db->prefix.'rscd_players WHERE `user`='.$id) or error('Unable to fetch player info', __FILE__, __LINE__, $db->error());
	if(!$db->num_rows($result))
		message($lang_common['Bad request']);
	
	$user = $db->fetch_assoc($result);
	
	if($user['owner'] != $pun_user['id'] && $pun_user['g_id'] != PUN_ADMIN)
		message($lang_common['No permission']);
	
	if(isset($_POST['form_sent'])) {
		$password1 = trim($_POST['req_password1']);
		$password2 = trim($_POST['req_password2']);
		
		if (strlen($password1) < 4)
			message($lang_prof_reg['Pass too short']);
		else if ($password1 != $password2)
			message($lang_prof_reg['Pass not match']);
		
		if($pun_user['g_id'] != PUN_ADMIN) {
			$old_password = md5(pun_trim($_POST['old_password']));
			
			$result = $db->query('SELECT 1 FROM '.$db->prefix.'rscd_players WHERE `user`=\''.$id.'\' AND `pass`=\''.$old_password.'\'') or error('Unable to fetch player info', __FILE__, __LINE__, $db->error());
			if(!$db->num_rows($result)) {
				message('The provided password does not match!');
			}
		}
		
		$db->query('UPDATE '.$db->prefix.'rscd_players SET pass=\''.md5($password1).'\' WHERE user=\''.$id.'\'') or error('Unable to update players password', __FILE__, __LINE__, $db->error());
		
		redirect('profile.php?section=rscd&id='.$user['owner'], 'Password updated');
	}
	
	$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Change Password';
	$required_fields = array('req_password1' => $lang_common['Password'], 'req_password2' => $lang_prof_reg['Confirm pass']);
	$focus_element = array('register', 'req_password1');
	require PUN_ROOT.'header.php';

?>
<div class="blockform">
	<h2><span>Change Password</span></h2>
	<div class="box">
		<form id="register" method="post" action="rscd.php?action=change_pass&amp;user=<?php echo $id; ?>" onsubmit="this.register.disabled=true;if(process_form(this)){return true;}else{this.register.disabled=false;return false;}">
			<div class="inform">
				<fieldset>
					<legend>Please enter and confirm your new password</legend>
					<div class="infldset">
						<input type="hidden" name="form_sent" value="1" />
<?php if($pun_user['g_id'] != PUN_ADMIN): ?>						<label class="conl"><strong>Old Password</strong><br /><input type="password" name="old_password" size="16" maxlength="16" /><br /></label>
<?php endif; ?>						<label class="conl"><strong>New Password</strong><br /><input type="password" name="req_password1" size="16" maxlength="16" /><br /></label>
						<label class="conl"><strong><?php echo $lang_prof_reg['Confirm pass'] ?></strong><br /><input type="password" name="req_password2" size="16" maxlength="16" /><br /></label>
						<p class="clearb">Passwords can be between 4 and 16 characters long. Passwords are case sensitive.</p>
					</div>
				</fieldset>
			</div>
			<p><input type="submit" name="change_pass" value="Change Password" /></p>
		</form>
	</div>
</div>
<?php

	require PUN_ROOT.'footer.php';
	
}
else if ($action == 'register') {
	// Load the register.php language file
	require PUN_ROOT.'lang/'.$pun_user['language'].'/register.php';
	
	if(isset($_GET['cancel']))
		redirect('index.php', $lang_register['Reg cancel redirect']);
	else if($pun_config['o_rscd_rules'] == '1' && !isset($_GET['agree']) && !isset($_POST['form_sent'])) {
		
		$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / '.$lang_common['Register'];
		require PUN_ROOT.'header.php';
		
	
?>
<div class="blockform">
	<h2><span>RSCD Rules</span></h2>
	<div class="box">
		<form method="get" action="rscd.php">
			<div class="inform">
				<input type="hidden" name="action" value="register" />
				<fieldset>
					<legend><?php echo $lang_register['Rules legend'] ?></legend>
					<div class="infldset">
						<p><?php echo $pun_config['o_rscd_rules_message'] ?></p>
					</div>
				</fieldset>
			</div>
			<p><input type="submit" name="agree" value="<?php echo $lang_register['Agree'] ?>" /><input type="submit" name="cancel" value="<?php echo $lang_register['Cancel'] ?>" /></p>
		</form>
	</div>
</div>
<?php

		require PUN_ROOT.'footer.php';
	}
	else if (isset($_POST['form_sent'])) {
		$username = pun_trim($_POST['req_username']);
		$password1 = trim($_POST['req_password1']);
		$password2 = trim($_POST['req_password2']);
		
		$username_hash = encode_username($username);
		$username = decode_username($username_hash);
		
		// Validate username and passwords
		if (!$username_hash)
			message('Invalid username');
		else if (strlen($username) < 2)
			message($lang_prof_reg['Username too short']);
		else if (pun_strlen($username) > 12)	// This usually doesn't happen since the form element only accepts 12 characters
			message($lang_common['Bad request']);
		else if (strlen($password1) < 4)
			message($lang_prof_reg['Pass too short']);
		else if (pun_strlen($password1) > 16)	// This usually doesn't happen since the form element only accepts 16 characters
			message($lang_common['Bad request']);
		else if ($password1 != $password2)
			message($lang_prof_reg['Pass not match']);
		else if (preg_match('/^Mod\s+/i', $username) || preg_match('/^Admin\s+/i', $username))
			message('Usernames may not start with "Mod " or "Admin ". Please choose another username.');
		
		// Check that the username (or a too similar username) is not already registered
		$result = $db->query('SELECT username FROM '.$db->prefix.'rscd_players WHERE UPPER(username)=UPPER(\''.$db->escape($username).'\') OR UPPER(username)=UPPER(\''.$db->escape(preg_replace('/[^\w]/', '', $username)).'\') OR UPPER(username)=UPPER(\''.$db->escape(preg_replace('/\s\s+/', ' ', $username)).'\')') or error('Unable to fetch user info', __FILE__, __LINE__, $db->error());
	
		if ($db->num_rows($result))
		{
			$busy = $db->result($result);
			message($lang_register['Username dupe 1'].' '.pun_htmlspecialchars($busy).'. '.$lang_register['Username dupe 2']);
		}
		
		$db->query('INSERT INTO '.$db->prefix.'rscd_curstats(`user`) VALUES(\''.$db->escape($username_hash).'\')') or error('Unable to fill curstats', __FILE__, __LINE__, $db->error());
		$db->query('INSERT INTO '.$db->prefix.'rscd_experience(`user`) VALUES(\''.$db->escape($username_hash).'\')') or error('Unable to fill experience', __FILE__, __LINE__, $db->error());
		$db->query('INSERT INTO '.$db->prefix.'rscd_players(`user`, `username`, `owner`, `pass`, `creation_date`, `creation_ip`) VALUES(\''.$db->escape($username_hash).'\', \''.$db->escape($username).'\', \''.intval($pun_user['id']).'\', \''.md5($password1).'\', \''.time().'\', \''.get_remote_address().'\')') or error('Unable to fill players', __FILE__, __LINE__, $db->error());
		$db->query('INSERT INTO '.$db->prefix."rscd_invitems(`user`, `id`, `amount`, `wielded`, `slot`) VALUES
			('".$db->escape($username_hash)."', '10', '1000', '0', '0'),
			('".$db->escape($username_hash)."', '1263', '1', '0', '1'),
			('".$db->escape($username_hash)."', '77', '1', '0', '2')
			") or error('Unable to fill curstats', __FILE__, __LINE__, $db->error());
		
		redirect('profile.php?section=rscd&id='.$pun_user['id'], 'Your The-Pkz account has been created.');
	}
	
	$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / '.$lang_register['Register'];
	$required_fields = array('req_username' => $lang_common['Username'], 'req_password1' => $lang_common['Password'], 'req_password2' => $lang_prof_reg['Confirm pass']);
	$focus_element = array('register', 'req_username');
	require PUN_ROOT.'header.php';

?>
<div class="blockform">
	<h2><span><?php echo $lang_register['Register'] ?></span></h2>
	<div class="box">
		<form id="register" method="post" action="rscd.php?action=register" onsubmit="return process_form(this);">
			<div class="inform">
				<fieldset>
					<legend>Please enter a username between 2 and 12 characters long</legend>
					<div class="infldset">
						<input type="hidden" name="form_sent" value="1" />
						<label><strong><?php echo $lang_common['Username'] ?></strong><br /><input type="text" name="req_username" size="20" maxlength="12" /><br /></label>
					</div>
				</fieldset>
			</div>
			<div class="inform">
				<fieldset>
					<legend>Please enter and confirm your chosen password</legend>
					<div class="infldset">
						<label class="conl"><strong><?php echo $lang_common['Password'] ?></strong><br /><input type="password" name="req_password1" size="20" maxlength="16" /><br /></label>
						<label class="conl"><strong><?php echo $lang_prof_reg['Confirm pass'] ?></strong><br /><input type="password" name="req_password2" size="20" maxlength="16" /><br /></label>
						<p class="clearb">Passwords can be between 4 and 16 characters long. Passwords are case sensitive.</p>
					</div>
				</fieldset>
			</div>
			<p><input type="submit" name="register" value="<?php echo $lang_register['Register'] ?>" /></p>
		</form>
	</div>
</div>
<?php

	require PUN_ROOT.'footer.php';
	
}
else
	message($lang_common['Bad request']);
