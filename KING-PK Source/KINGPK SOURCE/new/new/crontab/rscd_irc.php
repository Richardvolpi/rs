<?php

define('PUN_ROOT', '/home/rscd/public_html/');
include PUN_ROOT.'include/base.php';

$user_file = 'http://irc.rscdaemon.org/users/rscd.txt';

$result = $db->query('TRUNCATE TABLE '.$db->prefix.'online_irc') or error('Unable to empty table', __FILE__, __LINE__, $db->error());

$lines = @file($user_file);
if(!$lines) {
	$db->close();
	exit('Failed to fetch lines'."\n");
}
list($lastmodified, $interval) = explode(' ', array_shift($lines));

foreach($lines as $line) {
	$details = explode(' ', $line);
	$details[5] = isset($details[5]) ? $details[5] : '';
	
	$db->query('INSERT INTO '.$db->prefix.'online_irc(`nick`, `ident`, `host`, `logged`, `idle`) VALUES(\''.$db->escape($details[0]).'\', \''.$db->escape($details[1]).'\', \''.$db->escape($details[2]).'\', '.intval($details[3]).', '.intval($details[4]).')') or error('Unable to insert user data', __FILE__, __LINE__, $db->error());
}

$db->close();
exit('Completed'."\n");
