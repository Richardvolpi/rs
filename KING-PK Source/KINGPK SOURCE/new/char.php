<?php

define('PUN_ROOT', './');
require PUN_ROOT.'include/common.php';

$xml = isset($_GET['display']) && trim($_GET['display']) == 'xml';

// Show IP statistics for a certain user ID
if (isset($_GET['ip_stats']) && $pun_user['g_id'] < PUN_GUEST)
{
	$ip_stats = trim($_GET['ip_stats']);

	$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / IP Stats';
	require PUN_ROOT.'header.php';

?>
<div class="linkst">
	<div class="inbox">
		<div><a href="javascript:history.go(-1)">Go back</a></div>
	</div>
</div>

<div id="users1" class="blocktable">
	<h2><span>Users</span></h2>
	<div class="box">
		<div class="inbox">
			<table cellspacing="0">
			<thead>
				<tr>
					<th class="tcl" scope="col">IP address</th>
					<th class="tc2" scope="col">Last used</th>
					<th class="tc3" scope="col">Times found</th>
					<th class="tcr" scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
<?php

	$result = $db->query('SELECT ip, MAX(time) AS last_used, COUNT(user) AS used_times FROM '.$db->prefix.'rscd_logins WHERE user='.$db->escape($ip_stats).' GROUP BY ip ORDER BY last_used DESC') or error('Unable to fetch post info', __FILE__, __LINE__, $db->error());
	if ($db->num_rows($result))
	{
		while ($cur_ip = $db->fetch_assoc($result))
		{

?>
				<tr>
					<td class="tcl"><a href="moderate.php?get_host=<?php echo $cur_ip['ip'] ?>"><?php echo $cur_ip['ip'] ?></a></td>
					<td class="tc2"><?php echo format_time($cur_ip['last_used']) ?></td>
					<td class="tc3"><?php echo $cur_ip['used_times'] ?></td>
					<td class="tcr"><a href="admin_users.php?show_users=<?php echo $cur_ip['ip'] ?>">Find more users for this ip</a></td>
				</tr>
<?php

		}
	}
	else
		echo "\t\t\t\t".'<tr><td class="tcl" colspan="4">There are currently no logins by that player.</td></tr>'."\n";

?>
			</tbody>
			</table>
		</div>
	</div>
</div>

<div class="linksb">
	<div class="inbox">
		<div><a href="javascript:history.go(-1)">Go back</a></div>
	</div>
</div>
<?php

	require PUN_ROOT.'footer.php';
}

if ($pun_user['g_read_board'] == '0' && !$xml)
	guest_page();

$id = trim($_GET['user']);

$result = $db->query('SELECT r.*, e.*, u.username AS owner_username, u.country_code AS owner_cc, u.group_id, g.g_title, b.id AS b_id FROM '.$db->prefix.'rscd_players AS r INNER JOIN '.$db->prefix.'users AS u ON u.id=r.owner LEFT JOIN '.$db->prefix.'rscd_experience AS e ON e.user=r.user LEFT JOIN '.$db->prefix.'groups AS g ON g.g_id=u.group_id LEFT JOIN '.$db->prefix.'bans AS b ON b.username LIKE u.username WHERE r.user='.$id) or error('Unable to fetch character info', __FILE__, __LINE__, $db->error());
if(!$db->num_rows($result))
	message($lang_common['Bad request']);

$user = $db->fetch_assoc($result);

if(isset($_POST['form_sent'])) {
	if($pun_user['g_id'] > PUN_MOD)
		message($lang_common['No permission']);
	
	if(isset($_POST['logout'])) {
		logoutuser($id);
		redirect('char.php?user='.$id, 'Player logged out');
	}
	if(isset($_POST['promotepmod'])) {
		if($pun_user['g_id'] != PUN_ADMIN || $user['group_id'] <= PUN_MOD) {
			message($lang_common['No permission']);
		}
		$db->query('UPDATE '.$db->prefix.'rscd_players SET `playermod`=1 WHERE `user`='.$db->escape($id)) or error('Unable to promote player', __FILE__, __LINE__, $db->error());
		logoutuser($id);
		redirect('char.php?user='.$id, 'Player promoted');
	}
	elseif(isset($_POST['demotepmod'])) {
		if($pun_user['g_id'] != PUN_ADMIN || $user['group_id'] <= PUN_MOD) {
			message($lang_common['No permission']);
		}
		$db->query('UPDATE '.$db->prefix.'rscd_players SET `playermod`=0 WHERE `user`='.$db->escape($id)) or error('Unable to demote player', __FILE__, __LINE__, $db->error());
		logoutuser($id);
		redirect('char.php?user='.$id, 'Player demoted');
	}
	elseif(isset($_POST['ban'])) {
		if($user['banned'] || $user['group_id'] <= PUN_MOD) {
			message($lang_common['Bad request']);
		}
		$db->query('UPDATE '.$db->prefix.'rscd_players SET `banned`=1 WHERE `user`='.$db->escape($id)) or error('Unable to ban player', __FILE__, __LINE__, $db->error());
		logoutuser($id);
		redirect('char.php?user='.$id, 'Player banned');
	}
	else if(isset($_POST['unban'])) {
		if(!$user['banned'] || $user['group_id'] <= PUN_MOD) {
			message($lang_common['Bad request']);
		}
		$db->query('UPDATE '.$db->prefix.'rscd_players SET `banned`=0 WHERE `user`='.$db->escape($id)) or error('Unable to unban player', __FILE__, __LINE__, $db->error());
		logoutuser($id);
		redirect('char.php?user='.$id, 'Player unbanned');
	}
	else
		message($lang_common['Bad request']);
}

$rank = $user['g_title'];

if($user['banned'] == '1' || isset($user['b_id']))
	$rank = 'Banned';
elseif($user['playermod'] == '1')
	$rank = 'Player Mod';

$result = $db->query('SELECT COUNT(DISTINCT `killed`) FROM '.$db->prefix.'rscd_kills WHERE user='.$id) or error('Unable to count kills', __FILE__, __LINE__, $db->error());
$kills = $db->result($result);

if($xml) {
	header('Content-type: text/xml; charset: UTF-8');
	echo '<?xml version="1.0" encoding="utf-8"?>'."\n";
?>
<!-- Character profile for: <?php echo pun_htmlspecialchars($user['username']); ?> -->
<character>
	<username><?php echo pun_htmlspecialchars($user['username']); ?></username>
	<registered><?php echo $user['creation_date']; ?></registered>
	<lastLogin><?php echo $user['login_date']; ?></lastLogin>
	<owner><?php echo pun_htmlspecialchars($user['owner_username']); ?></owner>
	<status><?php echo pun_htmlspecialchars($rank); ?></status>
	<combat><?php echo pun_htmlspecialchars($user['combat']); ?></combat>
	<skillTotal><?php echo pun_htmlspecialchars($user['skill_total']); ?></skillTotal>
	<kills><?php echo pun_htmlspecialchars($kills); ?></kills>
	<stats>
<?php

	foreach($skills as $skill) {
		if(in_array($skill, $blocked)) {
			continue;
		}
		echo "\t\t".'<'.$skill.'>'.experience_to_level($user['exp_'.$skill]).'</'.$skill.'>'."\n";
	}

?>
	</stats>
</character>
<?php
	$db->close();
	exit;
}

$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Character Profile';
require PUN_ROOT.'header.php';
	
?>
<div class="blockform">
	<h2><span>Character Profile for <?php echo pun_htmlspecialchars($user['username']); ?></span></h2>
	<div class="box">
      		<div class="inbox" style="padding:15px">
      			<fieldset>
      				<legend><?php echo '<a href="highscores.php?country='.pun_htmlspecialchars($user['owner_cc']).'"><img src="img/flags/'.pun_htmlspecialchars($user['owner_cc']).'.gif" alt="" /></a>'; ?>&nbsp; Overall Details</legend>
      				<div class="infldset">
	    				<table cellspacing="0" class="invisible tdleft">
	    					<tr>
	    						<th scope="row">Username:</th>
	    						<td><?php echo pun_htmlspecialchars($user['username']); ?></td>
							<th scope="row">Registered:</th>
	    						<td><?php echo format_time($user['creation_date'], true); ?></td>
	    						<th scope="row">Last Login:</th>
	    						<td><?php echo format_time($user['login_date'], true); ?></td>
	    						<th scope="row">Status:</th>
	    						<td><?php echo pun_htmlspecialchars($rank); ?></td>
	    					</tr>
	    					<tr>
	    						<th scope="row">Owner:</th>
	    						<td><?php echo '<a href="profile.php?id='.$user['owner'].'">'.pun_htmlspecialchars($user['owner_username']); ?></a></td>
	    						<th scope="row">Combat:</th>
	    						<td><?php echo pun_htmlspecialchars($user['combat']); ?></td>
	    						<th scope="row">Skill Total:</th>
	    						<td><?php echo pun_htmlspecialchars($user['skill_total']); ?></td>
	    						<th scope="row">Kills (unique):</th>
	    						<td><?php echo pun_htmlspecialchars($kills); ?></td>
	    					</tr>
	    				</table>
      				</div>
      			</fieldset>
      			<br />
      			<fieldset>
      				<legend>Skill Levels</legend>
      				<div class="infldset">
	    				<table cellspacing="0" class="invisible">
	    					<tr>
	    						<th scope="col" class="tcl" colspan="2">Skill Name</th>
	    						<th scope="col" class="tc2">Level</th>
	    						<th scope="col" class="tcr">Experience</th>
	    					</tr>
<?php
	foreach($skills as $skill) {
		$is_blocked = in_array($skill, $blocked);
		if($is_blocked && $pun_user['g_id'] > PUN_MOD) {
			continue;
		}
		
?>
	    					<tr<?php echo $is_blocked ? ' style="font-style:italic;font-size:0.8em"' : ''; ?>>
	    						<td><img src="img/skills/<?php echo $skill; ?>.png" alt="" /></td>
	    						<td class="tcl"><?php echo ucwords($skill); ?></td>
	    						<td class="tc2"><?php echo experience_to_level($user['exp_'.$skill]); ?></td>
	    						<td class="tcr"><?php echo $user['exp_'.$skill]; ?></td>
	    					</tr>
<?php } ?>
	    				</table>
      				</div>
      			</fieldset>
      			<br />
      		</div>
	</div>
</div>
<?php if($pun_user['g_id'] < PUN_GUEST): ?>
<div class="blockform">
	<h2><span>Admin Control</span></h2>
	<div class="box">
		<form action="char.php?user=<?php echo pun_htmlspecialchars($id); ?>" method="POST">
			<div class="inform">
				<fieldset>
					<input type="hidden" name="form_sent" value="1" />
					<legend>Admin Options</legend>
					<div class="infldset">
      						<table class="aligntop invisible" cellspacing="0">
      							<tr>
      								<td>
      									<a href="char.php?ip_stats=<?php echo pun_htmlspecialchars($user['user']); ?>">View Ip stats</a>
      								</td>
      							</tr>
<?php if($user['group_id'] > PUN_MOD): ?>
      							<tr>
      								<td style="text-align:center">
      									<input type="submit" name="<?php echo $user['banned'] ? 'unban' : 'ban'; ?>" value="<?php echo $user['banned'] ? 'Unban' : 'Ban'; ?> Player" style="width:200px" /><br />
      									<span>Allows mods & admins to ban/unban a specific player, without affecting the main account or their other players.</span>
      								</td>
      							</tr>
<?php if($pun_user['g_id'] == PUN_ADMIN): ?>
      							<tr>
      								<td style="text-align:center">
      									<input type="submit" name="<?php echo $user['playermod'] ? 'demotepmod' : 'promotepmod'; ?>" value="<?php echo $user['playermod'] ? 'Demote from PMod' : 'Promote to PMod'; ?>" style="width:200px" /><br />
      									<span>Allows admins to promote/demote a specific player to/from player mod, without affecting the main account or their other players.</span>
      								</td>
      							</tr>
<?php endif; ?><?php endif; ?>      							<tr>
      								<td style="text-align:center">
      									<input type="submit" name="logout" value="Force Logout" style="width:200px" /><br />
      									<span>Allows mods/admins to force a user to logout.</span>
      								</td>
      							</tr>
		    				</table>
					</div>
				</fieldset>
			</div>
		</form>
	</div>
</div>
<?php

endif;

require PUN_ROOT.'footer.php';
