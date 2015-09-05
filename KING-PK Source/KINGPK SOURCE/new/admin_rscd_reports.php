<?php

// Tell header.php to use the admin template
define('PUN_ADMIN_CONSOLE', 1);

define('PUN_ROOT', './');
require PUN_ROOT.'include/common.php';
require PUN_ROOT.'include/common_admin.php';


if ($pun_user['g_id'] > PUN_MOD)
	message($lang_common['No permission']);

function get_reason($id) {
	switch($id) {
		case 1:
			return 'Offensive language';
		case 2:
			return 'Item scamming';
		case 3:
			return 'Password scamming';
		case 4:
			return 'Bug abuse';
		case 5:
			return 'RSCDaemon Staff impersonation';
		case 6:
			return 'Account sharing/trading';
		case 7:
			return 'Macroing';
		case 8:
			return 'Mutiple logging in';
		case 9:
			return 'Encouraging others to break rules';
		case 10:
			return 'Misuse of customer support';
		case 11:
			return 'Advertising / website';
		case 12:
			return 'Real world item trading';
		default:
			return 'Unknown (ID: '.$id.')';
	}
}

if (isset($_POST['zap_id'])) {
	confirm_referrer('admin_rscd_reports.php');

	$db->query('UPDATE '.$db->prefix.'rscd_reports SET zapped='.time().', zapped_by='.$pun_user['id'].' WHERE id='.intval(key($_POST['zap_id']))) or error('Unable to zap report', __FILE__, __LINE__, $db->error());

	redirect('admin_rscd_reports.php', 'Report zapped. Redirecting &hellip;');
}
else if(isset($_GET['zap_all'])) {
	confirm_referrer('admin_rscd_reports.php');
	
	$user = trim($_GET['zap_all']);
	
	if(isset($_POST['confirm'])) {
		$db->query('UPDATE '.$db->prefix.'rscd_reports SET zapped='.time().', zapped_by='.$pun_user['id'].' WHERE about='.$user) or error('Unable to zap report', __FILE__, __LINE__, $db->error());
	
		redirect('admin_rscd_reports.php', 'Report zapped. Redirecting &hellip;');
	}
	
	$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Admin / RSCD Reports';
	require PUN_ROOT.'header.php';
	
	generate_admin_menu('rscd_reports');
	
?>
	<div class="blockform">
		<h2><span>Confirm Clear</span></h2>
		<div class="box">
			<form action="admin_rscd_reports.php?zap_all=<?php echo pun_htmlspecialchars($user); ?>" method="POST">
				<div class="inform">
					<fieldset>
						<input type="hidden" name="form_sent" value="1" />
						<legend>Clear Players Reports</legend>
						<div class="infldset" style="text-align:center">
			    				<p><input type="submit" name="confirm" value="Confirm Clear" style="width:200px" /></p>
			    				<p>Please confirm you wish to clear all the reports for this player.</p>
						</div>
					</fieldset>
				</div>
			</form>
		</div>
	</div>
<?php
	
}
else if(isset($_GET['details'])) {
	$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Admin / RSCD Reports';
	require PUN_ROOT.'header.php';
	
	generate_admin_menu('rscd_reports');
	
?>
	<div class="blockform">
		<h2><span>New reports</span></h2>
		<div class="box">
			<form method="post" action="admin_rscd_reports.php?action=zap">
<?php

$result = $db->query('SELECT r.*, a.username AS about_username, f.username AS from_username, u.id AS user_id, u.username AS user_username FROM '.$db->prefix.'rscd_reports AS r INNER JOIN '.$db->prefix.'rscd_players AS a ON a.user=r.about LEFT JOIN '.$db->prefix.'rscd_players AS f ON f.user=r.from LEFT JOIN '.$db->prefix.'users AS u ON u.id=a.owner WHERE r.zapped IS NULL AND r.about='.trim($_GET['details']).' ORDER BY r.time DESC') or error('Unable to fetch report list', __FILE__, __LINE__, $db->error());

if ($db->num_rows($result))
{
	while ($cur_report = $db->fetch_assoc($result))
	{

?>
				<div class="inform">
					<fieldset>
						<legend>Reported <?php echo format_time($cur_report['time']) ?></legend>
						<div class="infldset">
							<table cellspacing="0">
								<tr>
									<th scope="row">Reported Character:</th>
									<td><a href="char.php?user=<?php echo $cur_report['about']; ?>"><?php echo pun_htmlspecialchars($cur_report['about_username']); ?></a> owned by <a href="profile.php?id=<?php echo $cur_report['user_id']; ?>"><?php echo pun_htmlspecialchars($cur_report['user_username']); ?></a></td>
								</tr>
								<tr>
									<th scope="row">Report by <a href="char.php?user=<?php echo $cur_report['from']; ?>"><?php echo pun_htmlspecialchars($cur_report['from_username']); ?></a><div><input type="submit" name="zap_id[<?php echo $cur_report['id'] ?>]" value=" Zap " /></div></th>
									<td>
<?php if(isset($cur_report['status'])):	?>									<p><?php echo 'Reported at ('.$cur_report['x'].', '.$cur_report['y'].') while: '.pun_htmlspecialchars($cur_report['status']); ?></p>
<?php endif; ?>										<p><?php echo get_reason($cur_report['reason']); ?></p>
									</td>
								</tr>
<?php if(!empty($cur_report['packets'])): ?>
								<tr>
                                	<th scope="col" colspan="2" style="text-align:center">Recent packets</th>
                                </tr>
                                <tr>
                                	<td colspan="2">
<textarea style="width:100%;height:100px" readonly="readonly">
<?php echo pun_htmlspecialchars($cur_report['packets']); ?>
</textarea>
									</td>
                                </tr>
<?php endif; ?>
							</table>
						</div>
					</fieldset>
				</div>
<?php

	}
}
else
	echo "\t\t\t\t".'<p>There are no new reports.</p>'."\n";

?>
			</form>
		</div>
	</div>
<?php
}
else {
	$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Admin / RSCD Reports';
	require PUN_ROOT.'header.php';
	
	generate_admin_menu('rscd_reports');

?>
	<div class="blockform">
		<h2><span>New reports</span></h2>
		<div class="box">
			<div class="inbox">
				<table cellspacing="0">
					<thead>
						<tr>
							<th class="tc3" scope="col"><a href="admin_rscd_reports.php?order=username"><u>Username</u></a></th>
							<th class="tc3" scope="col"><a href="admin_rscd_reports.php?order=owner_username"><u>Owner</u></a></th>
							<th class="tc3" scope="col"><a href="admin_rscd_reports.php?order=offences"><u>Offences (New/Total)</u></a></th>
							<th class="tc3" scope="col"><a href="admin_rscd_reports.php?order=g_title"><u>Status</u></a></th>
							<th class="tc3" scope="col"><a href="admin_rscd_reports.php?order=last_time"><u>Last Reported</u></a></th>
							<th class="tcr" scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
<?php

	$order = isset($_GET['order']) ? trim($_GET['order']) : 'last_time';
	$result = $db->query('SELECT p.user, p.username, p.banned, p.owner, u.username AS owner_username, b.id AS b_id, COUNT(r.id) AS offences, MAX(time) AS last_time, g.g_title, o.ip AS o_ip FROM '.$db->prefix.'rscd_reports AS r INNER JOIN '.$db->prefix.'rscd_players AS p ON p.user=r.about LEFT JOIN '.$db->prefix.'users AS u ON u.id=p.owner LEFT JOIN '.$db->prefix.'bans AS b ON b.username LIKE u.username LEFT JOIN '.$db->prefix.'groups AS g ON g.g_id=u.group_id LEFT JOIN '.$db->prefix.'rscd_online AS o ON o.user=r.about WHERE r.zapped IS NULL GROUP BY r.about ORDER BY '.$db->escape($order).' DESC') or error('Unable to fetch report list', __FILE__, __LINE__, $db->error());
	while($report = $db->fetch_assoc($result)) {
		if($report['banned'] == '1' || isset($report['b_id']))
			$class = ' class="banned"';
		elseif(isset($report['o_ip']))
			$class = ' class="online"';
		else
			$class = '';
?>
						<tr<?php echo $class; ?>>
							<td class="tc3"><?php echo '<a href="char.php?user='.pun_htmlspecialchars($report['user']).'">'.pun_htmlspecialchars($report['username']).'</a>'; ?></td>
							<td class="tc3"><?php echo '<a href="profile.php?id='.$report['owner'].'">'.pun_htmlspecialchars($report['owner_username']).'</a>'; ?></td>
							<td class="tc3"><?php echo $report['offences'].'/-'; ?></td>
							<td class="tc3"><?php echo pun_htmlspecialchars($report['g_title']); ?></td>
							<td class="tc3"><?php echo format_time($report['last_time'], true); ?></td>
							<td class="tcr"><a href="admin_rscd_reports.php?zap_all=<?php echo pun_htmlspecialchars($report['user']); ?>">Clear</a> - <a href="admin_rscd_reports.php?details=<?php echo pun_htmlspecialchars($report['user']); ?>">Details</a></td>
						</tr>
<?php
	}

?>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<?php

}

echo "\t".'<div class="clearer"></div>'."\n";
echo '</div>'."\n";

require PUN_ROOT.'footer.php';
