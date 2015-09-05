<?php

$skills = array('attack', 'defense', 'strength', 'hits', 'ranged', 'prayer', 'magic', 'cooking', 'woodcut', 'fletching', 'fishing', 'firemaking', 'crafting', 'smithing', 'mining', 'herblaw', 'agility', 'thieving');

$exps = array(83, 174, 276, 388, 512, 650, 801, 969, 1154, 1358, 1584, 1833, 2107, 2411, 2746, 3115, 3523, 3973, 4470, 5018, 5624, 6291, 7028, 7842, 8740, 9730, 10824, 12031, 13363, 14833, 16456, 18247, 20224, 22406, 24815, 27473, 30408, 33648, 37224, 41171, 45529, 50339, 55649, 61512, 67983, 75127, 83014, 91721, 101333, 111945, 123660, 136594, 150872, 166636, 184040, 203254, 224466, 247886, 273742, 302288, 333804, 368599, 407015, 449428, 496254, 547953, 605032, 668051, 737627, 814445, 899257, 992895, 1096278, 1210421, 1336443, 1475581, 1629200, 1798808, 1986068, 2192818, 2421087, 2673114,2951373, 3258594, 3597792, 3972294, 4385776, 4842295, 5346332, 5902831, 6517253, 7195629, 7944614, 8771558, 9684577, 10692629, 11805606, 13034431, 14391160);

$blocked = array('attack', 'defense', 'strength');

function coords_to_image($x, $y) {
	$x = 2152 - (($x - 50) * 3);
	$y = ($y - 432) * 3;
	if($x < 0 || $x > 2152 || $y < 0 || $y > 1007) {
		return false;
	}
	return array('x' => $x, 'y' => $y);
}

function experience_to_level($exp) {
	global $exps;

	for($level = 0;$level < 98;$level++) {
		if($exp >= $exps[$level]) {
			continue;
		}
		return ($level + 1);
	}
	return 99;
}

function encode_username($username) {
	$username = strtolower($username);
	$clean = '';
	for($i = 0;$i < strlen($username);$i++) {
		$c = ord($username{$i});
		if($c >= 97 && $c <= 122) {
			$clean .= chr($c);
		}
		else if($c >= 48 && $c <= 57) {
			$clean .= chr($c);
		}
		else {
			$clean .= ' ';
		}
	}
	$clean = trim($clean);
	if(strlen($clean) > 12) {
		$clean = substr($clean, 0, 12);
	}
	$hash = '0';
	for($i = 0;$i < strlen($clean);$i++) {
		$c = ord($clean{$i});
		$hash = bcmul($hash, 37);
		if($c >= 97 && $c <= 122) {
			$hash = bcadd($hash, (1 + $c) - 97);
		}
		else if($c >= 48 && $c <= 57) {
			$hash = bcadd($hash, (27 + $c) - 48);
		}
	}
	return $hash;
}

function decode_username($hash) {
	if(!$hash) {
		return 'invalid_name';
	}
	$username = '';
	while($hash) {
		$i = bcmod($hash, 37);
		$hash = bcdiv($hash, 37);
		if($i == '0') {
			$username = ' '.$username;
		}
		else if($i < 27) {
			if(bcmod($hash, 37) == '0') {
				$username = chr(($i + 65) - 1).$username;
			}
			else {
				$username = chr(($i + 97) - 1).$username;
			}
		}
		else {
			$username = chr(($i + 48) - 27).$username;
		}
	}
	return $username;
}

function writeData($pid) {
	$params = func_get_args();
	array_shift($params);
	foreach($params as $param) {
		$param = urlencode(trim($param));
	}
	
	$socket = @fsockopen('localhost', 8181, $errno, $errstr, 10);
	if(!$socket) {
		return false;
	}
	
	$buffer = '';
	@fwrite($socket, $pid.($params ? ' '.implode(' ', $params) : ''));
	while(!@feof($socket)) {
		$buffer .= @fread($socket, 1024);
	}
	@fclose($socket);
	
	return urldecode($buffer);
}

define('F_LOGOUT', 1);
define('F_SHUTDOWN', 2);
define('F_UPDATE', 3);
define('F_GLOBAL', 5);
define('F_ALERT', 6);
define('F_LIST_PLAYERS', 7);

function logoutuser($user) {
	$result = writeData(F_LOGOUT, $user);
	return $result == '1';
}

function shutdownworld($world = 0) {
	$result = writeData(F_SHUTDOWN, $world);
	return $result == '1';
}

function updateworld($message = '') {
	$result = writeData(F_UPDATE, $message);
	return $result == '1';
}

function sendglobal($message) {
	$result = writeData(F_GLOBAL, $message);
	return $result == '1';
}

function alertplayer($user, $message) {
	$result = writeData(F_ALERT, $user, $message);
	return $result == '1';
}

function getplayers() {
	global $db;
	
	$players = array();
	
	$result = $db->query('SELECT id FROM '.$db->prefix.'rscd_worlds ORDER BY id ASC') or error('Unable to fetch world list', __FILE__, __LINE__, $db->error());
	while($world = $db->fetch_assoc($result)) {
		$data = writeData(F_LIST_PLAYERS, $world['id']);
		if(!$data || ($delim = strpos($data, ' ')) < 0) {
			continue;
		}
		$id = substr($data, 0, $delim);
		$data = substr($data, $delim + 1);
		if($id != 1) {
			continue;
		}
		$players = array_merge($players, extractplayers($data));
	}
	
	return $players;
}

function extractplayers($result) {
	$players = array();
	
	$lines = explode(' ', $result);
	foreach($lines as $line) {
		list($user, $x, $y, $world) = explode(',', $line);
		$players[] = array(
			'user'		=>	$user,
			'username'	=>	decode_username($user),
			'x'		=>	$x,
			'y'		=>	$y,
			'world'		=>	$world
		);
	}
	
	return $players;
}
