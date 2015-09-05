<?php

define('PUN_DEBUG', 1);
define('PUN_SHOW_QUERIES', 1);

define('PUN_ROOT', '/home/rscd/public_html/');
include PUN_ROOT.'include/base.php';

$executable = '/usr/bin/ventrilo_status';
$server = 'vent.rscdaemon.org:4410';

$result = $db->query('TRUNCATE TABLE '.$db->prefix.'online_vent') or error('Unable to empty table', __FILE__, __LINE__, $db->error());

$channels = array();
$output = explode("\n", trim(shell_exec($executable.' -t'.$server.' -c2')));
foreach($output as $line) {
	list($key, $value) = explode(': ', trim($line));
	if($key == 'CHANNEL') {
		$data = array();
		foreach(explode(',', $value) as $item) {
			list($item_key, $item_value) = explode('=', $item);
			$data[strtolower($item_key)] = $item_value;
		}
		$channels[$data['cid']] = $data['name'];
	}
	else if($key == 'CLIENT') {
		$data = array();
		foreach(explode(',', $value) as $item) {
			list($item_key, $item_value) = explode('=', $item);
			$data[strtolower($item_key)] = $item_value;
		}
		$channel = array_key_exists($data['cid'], $channels) ? $channels[$data['cid']] : 'None';
		$db->query('INSERT INTO '.$db->prefix.'online_vent(`name`, `admin`, `sec`, `channel`) VALUES(\''.$db->escape($data['name']).'\', '.intval($data['admin']).', '.intval($data['sec']).', \''.$db->escape($channel).'\')') or error('Unable to insert user data', __FILE__, __LINE__, $db->error());
	}
}

$db->close();
exit('Completed'."\n");
