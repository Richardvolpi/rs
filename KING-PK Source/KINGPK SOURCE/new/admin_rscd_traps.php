<?php

// Tell header.php to use the admin template
define('PUN_ADMIN_CONSOLE', 1);

define('PUN_ROOT', './');
require PUN_ROOT.'include/common.php';
require PUN_ROOT.'include/common_admin.php';


if ($pun_user['g_id'] != PUN_ADMIN)
	message($lang_common['No permission']);

$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Admin / RSCD Traps';
require PUN_ROOT.'header.php';

generate_admin_menu('rscd_traps');

?>
	<div class="blockform">
		<h2><span>Trapped Characters</span></h2>
		<div class="box">
			<div class="inbox">
				<table cellspacing="0">
					<thead>
						<tr>
							<th class="tc3" scope="col">Username</th>
							<th class="tc3" scope="col">Owner</th>
							<th class="tc3" scope="col">Status</th>
							<th class="tc3" scope="col">Time Caught</th>
							<th class="tc3" scope="col">IP Caught</th>
							<th class="tcr" scope="col">Details</th>
						</tr>
					</thead>
					<tbody>
<?php

	$result = $db->query('SELECT p.*, u.username AS owner_username, l.time AS caught_time, l.ip AS caught_ip, l.details, b.id AS b_id, g.g_title FROM '.$db->prefix.'rscd_traps AS l LEFT JOIN '.$db->prefix.'rscd_players AS p ON p.user=l.user LEFT JOIN '.$db->prefix.'users AS u ON u.id=p.owner LEFT JOIN '.$db->prefix.'bans AS b ON b.username LIKE u.username LEFT JOIN '.$db->prefix.'groups AS g ON g.g_id=u.group_id WHERE l.zapped=0 GROUP BY p.user ORDER BY caught_time DESC') or error('Unable to fetch report list', __FILE__, __LINE__, $db->error());
	if($db->num_rows($result)) {
		while($char = $db->fetch_assoc($result)) {
?>
						<tr<?php echo ($char['banned'] == '1' || isset($char['b_id'])) ? ' class="banned"' : ''; ?>>
							<td class="tc3"><?php echo '<a href="char.php?user='.pun_htmlspecialchars($char['user']).'">'.pun_htmlspecialchars($char['username']).'</a>'; ?></td>
							<td class="tc3"><?php echo '<a href="profile.php?id='.$char['owner'].'">'.pun_htmlspecialchars($char['owner_username']).'</a>'; ?></td>
							<td class="tc3"><?php echo pun_htmlspecialchars($char['g_title']); ?></td>
							<td class="tc3"><?php echo format_time($char['caught_time'], true); ?></td>
							<td class="tc3"><?php echo pun_htmlspecialchars($char['caught_ip']); ?></td>
							<td class="tcr"><?php echo pun_htmlspecialchars($char['details']).'"'; ?></td>
						</tr>
<?php
		}
	}
	else {
?>
						<tr><td colspan="6">No characters</td></tr>
<?php
	}

?>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="clearer"></div>
</div>
<?php

require PUN_ROOT.'footer.php';