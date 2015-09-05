<?php

define('PUN_ROOT', '/home/rscd/public_html/');
include PUN_ROOT.'include/base.php';

$result = $db->query('TRUNCATE TABLE '.$db->prefix.'rscd_online') or error('Unable to empty table', __FILE__, __LINE__, $db->error());

$players = getplayers();
foreach($players as $player) {
	$db->query('INSERT INTO '.$db->prefix.'rscd_online(`user`, `username`, `ip`, `x`, `y`, `world`) VALUES(\''.$db->escape($player['user']).'\', \''.$db->escape($player['username']).'\', \''.$db->escape($player['ip']).'\', \''.intval($player['x']).'\', '.intval($player['y']).', '.intval($player['world']).')') or error('Unable to insert user data', __FILE__, __LINE__, $db->error());
}

$db->close();
exit('Completed'."\n");
