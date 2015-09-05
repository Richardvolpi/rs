<?php

define('PUN_ROOT', './');
require PUN_ROOT.'include/common.php';

$page_title = pun_htmlspecialchars($pun_config['o_board_title'].' / Statistics');
require PUN_ROOT.'header.php';

$result = $db->query('SELECT * FROM '.$db->prefix.'stats ORDER BY `date` DESC LIMIT 1') or error('Unable to fetch stats', __FILE__, __LINE__, $db->error());
$stats = $db->fetch_assoc($result);

?>
<div class="block">
	<h2><span>General Statistics</span></h2>
	<div class="box">
		<div class="inbox" style="text-align:center">
			<em>Stats are updated daily at midnight, last updated <?php echo date($pun_config['o_date_format'], $stats['date']); ?>.</em><br />
			Post Count: <?php echo number_format($stats['posts']); ?><br />
			Topic Count: <?php echo number_format($stats['topics']); ?><br />
			User Count: <?php echo number_format($stats['users']); ?><br />
			Player Count: <?php echo number_format($stats['players']); ?><br />
			Active users in past 24h: <?php echo number_format($stats['active_users']); ?><br />
			Active players in past 24h: <?php echo number_format($stats['active_players']); ?><br />
			<img src="img/stats/posts.png" alt="" style="margin:10px" /><br />
			<img src="img/stats/topics.png" alt="" style="margin:10px" /><br />
			<img src="img/stats/users.png" alt="" style="margin:10px" /><br />
			<img src="img/stats/players.png" alt="" style="margin:10px" /><br />
			<img src="img/stats/active_users.png" alt="" style="margin:10px" /><br />
			<img src="img/stats/active_players.png" alt="" style="margin:10px" /><br />
		</div>
	</div>
</div>
<?php

require PUN_ROOT.'footer.php';
exit;
