<?php
/***********************************************************************

  Copyright (C) 2005  Connor Dunn (Connorhd@mypunbb.com)

  This software is free software; you can redistribute it and/or modify it
  under the terms of the GNU General Public License as published
  by the Free Software Foundation; either version 2 of the License,
  or (at your option) any later version.

  This software is distributed in the hope that it will be useful, but
  WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 59 Temple Place, Suite 330, Boston,
  MA  02111-1307  USA

************************************************************************/
// Make sure no one attempts to run this script "directly"
if (!defined('PUN'))
    exit;

// Tell admin_loader.php that this is indeed a plugin and that it is loaded
define('PUN_PLUGIN_LOADED', 1);
define('PLUGIN_VERSION',1.3);

if (isset($_POST['add_user']))
{
	require PUN_ROOT.'lang/'.$pun_user['language'].'/prof_reg.php';
	require PUN_ROOT.'lang/'.$pun_user['language'].'/register.php';
	$username = pun_trim($_POST['username']);
	$email1 = strtolower(trim($_POST['email']));
	$email2 = strtolower(trim($_POST['email']));

	if ($_POST['random_pass'] == '1')
	{
		$password1 = random_pass(8);
		$password2 = $password1;
	}
	else
	{
		$password1 = trim($_POST['password']);
		$password2 = trim($_POST['password']);
	}

	// Convert multiple whitespace characters into one (to prevent people from registering with indistinguishable usernames)
	$username = preg_replace('#\s+#s', ' ', $username);

	// Validate username and passwords
	if (strlen($username) < 2)
		message($lang_prof_reg['Username too short']);
	else if (pun_strlen($username) > 25)	// This usually doesn't happen since the form element only accepts 25 characters
	    message($lang_common['Bad request']);
	else if (strlen($password1) < 4)
		message($lang_prof_reg['Pass too short']);
	else if ($password1 != $password2)
		message($lang_prof_reg['Pass not match']);
	else if (!strcasecmp($username, 'Guest') || !strcasecmp($username, $lang_common['Guest']))
		message($lang_prof_reg['Username guest']);
	else if (preg_match('/[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}/', $username))
		message($lang_prof_reg['Username IP']);
	else if ((strpos($username, '[') !== false || strpos($username, ']') !== false) && strpos($username, '\'') !== false && strpos($username, '"') !== false)
		message($lang_prof_reg['Username reserved chars']);
	else if (preg_match('#\[b\]|\[/b\]|\[u\]|\[/u\]|\[i\]|\[/i\]|\[color|\[/color\]|\[quote\]|\[quote=|\[/quote\]|\[code\]|\[/code\]|\[img\]|\[/img\]|\[url|\[/url\]|\[email|\[/email\]#i', $username))
		message($lang_prof_reg['Username BBCode']);

	// Check username for any censored words
	if ($pun_config['o_censoring'] == '1')
	{
		// If the censored username differs from the username
		if (censor_words($username) != $username)
			message($lang_register['Username censor']);
	}

	// Check that the username (or a too similar username) is not already registered
	$result = $db->query('SELECT username FROM '.$db->prefix.'users WHERE username=\''.$db->escape($username).'\' OR username=\''.$db->escape(preg_replace('/[^\w]/', '', $username)).'\'') or error('Unable to fetch user info', __FILE__, __LINE__, $db->error());

	if ($db->num_rows($result))
	{
		$busy = $db->result($result);
		message($lang_register['Username dupe 1'].' '.pun_htmlspecialchars($busy).'. '.$lang_register['Username dupe 2']);
	}


	// Validate e-mail
	require PUN_ROOT.'include/email.php';

	if (!is_valid_email($email1))
		message($lang_common['Invalid e-mail']);

	// Check if someone else already has registered with that e-mail address
	$dupe_list = array();

	$result = $db->query('SELECT username FROM '.$db->prefix.'users WHERE email=\''.$email1.'\'') or error('Unable to fetch user info', __FILE__, __LINE__, $db->error());
	if ($db->num_rows($result))
	{
		while ($cur_dupe = $db->fetch_assoc($result))
			$dupe_list[] = $cur_dupe['username'];
	}

	$timezone = '0';

	$email_setting = intval(1);

	// Insert the new user into the database. We do this now to get the last inserted id for later use.
	$now = time();

	$intial_group_id = ($_POST['random_pass'] == '0') ? $pun_config['o_default_user_group'] : PUN_UNVERIFIED;
	$password_hash = pun_hash($password1);

	// Add the user
	$db->query('INSERT INTO '.$db->prefix.'users (username, group_id, password, email, email_setting, save_pass, timezone, language, style, registered, registration_ip, last_visit) VALUES(\''.$db->escape($username).'\', '.$intial_group_id.', \''.$password_hash.'\', \''.$email1.'\', '.$email_setting.', 1, '.$timezone.' , \''.$pun_config['o_default_lang'].'\', \''.$pun_config['o_default_style'].'\', '.$now.', \''.get_remote_address().'\', '.$now.')') or error('Unable to create user', __FILE__, __LINE__, $db->error());
	$new_uid = $db->insert_id();

	// Should we alert people on the admin mailing list that a new user has registered?
	if ($pun_config['o_regs_report'] == '1')
	{
		$mail_subject = 'Alert - New registration';
		$mail_message = 'User \''.$username.'\' registered in the forums at '.$pun_config['o_base_url']."\n\n".'User profile: '.$pun_config['o_base_url'].'/profile.php?id='.$new_uid."\n\n".'-- '."\n".'Forum Mailer'."\n".'(Do not reply to this message)';

		pun_mail($pun_config['o_mailing_list'], $mail_subject, $mail_message);
	}

	// Must the user verify the registration or do we log him/her in right now?
	if ($_POST['random_pass'] == '1')
	{
		// Load the "welcome" template
		$mail_tpl = trim(file_get_contents(PUN_ROOT.'lang/'.$pun_user['language'].'/mail_templates/welcome.tpl'));

		// The first row contains the subject
		$first_crlf = strpos($mail_tpl, "\n");
		$mail_subject = trim(substr($mail_tpl, 8, $first_crlf-8));
		$mail_message = trim(substr($mail_tpl, $first_crlf));
		$mail_subject = str_replace('<board_title>', $pun_config['o_board_title'], $mail_subject);
		$mail_message = str_replace('<base_url>', $pun_config['o_base_url'].'/', $mail_message);
		$mail_message = str_replace('<username>', $username, $mail_message);
		$mail_message = str_replace('<password>', $password1, $mail_message);
		$mail_message = str_replace('<login_url>', $pun_config['o_base_url'].'/login.php', $mail_message);
		$mail_message = str_replace('<board_mailer>', $pun_config['o_board_title'].' '.$lang_common['Mailer'], $mail_message);
		pun_mail($email1, $mail_subject, $mail_message);
	}

	message('User Created');
}
else
{
	// Display the admin navigation menu
	generate_admin_menu($plugin);

?>
	<div class="block">
		<h2><span>User management - v<?php echo PLUGIN_VERSION ?></span></h2>
		<div class="box">
			<div class="inbox">
				<p>This Plugin allows you to manually add users, this is useful for closed forum e.g. if you have disabled user registration in options.</p>
			</div>
		</div>
	</div>
	<div class="blockform">
		<h2 class="block2"><span>Add user</span></h2>
		<div class="box">
			<form id="example" method="post" action="<?php echo $_SERVER['REQUEST_URI'] ?>">
				<div class="inform">
					<fieldset>
						<legend>Settings</legend>
						<div class="infldset">
						<table class="aligntop" cellspacing="0">
							<tr>
								<th scope="row">Username</th>
								<td>
									<input type="text" name="username" size="25" tabindex="3" />
								</td>
							</tr>
							<tr>
								<th scope="row">Email</th>
								<td>
									<input type="text" name="email" size="50" tabindex="3" />
								</td>
							</tr>
							<tr>
								<th scope="row">Generate random password?</th>
								<td>
									<input type="radio" name="random_pass" value="1" />&nbsp;<strong>Yes</strong>&nbsp;&nbsp;&nbsp;<input type="radio" name="random_pass" value="0" checked="checked" />&nbsp;<strong>No</strong>
									<span>If Yes a random password will be generated and emailed to the above address.</span>
								</td>
							</tr>
							<tr>
								<th scope="row">Password</th>
								<td>
									<input type="text" name="password" size="25" tabindex="3" />
									<span>If you don't want a random password.</span>
								</td>
							</tr>
						</table>
						</div>
					</fieldset>
				</div>
				<p class="submitend"><input type="submit" name="add_user" value="Go!" tabindex="4" /></p>
			</form>
		</div>
	</div>

<?php
}
?>