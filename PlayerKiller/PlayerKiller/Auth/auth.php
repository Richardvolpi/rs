<?php

require 'common.php';

$user = strtolower(trim(stripslashes($_GET['user'])));
$pass = strtolower(trim(stripslashes($_GET['pass'])));

    if($user == '' || $pass == '' || $_GET['version'] == ''){
	fuck('Details not set',false);
    }
    if(trim($_GET['version']) != 'PlayerKiller 1.6'){
        fuck('You are using an old version, Please update',false);
    }	
$result = $db->query('SELECT id, password, suspend FROM '.$bot_name.'_users WHERE username=\''.addslashes($user).'\'') or fuck('Invalid', false);
$user = $db->fetch_assoc($result);

$cur_ip = get_ip();

$result = $db->query('SELECT * FROM '.$bot_name.'_ips WHERE ip=\''.$cur_ip.'\'') or fuck('Invalid', false);
if(!$db->num_rows($result))
{
	$db->query('INSERT INTO '.$bot_name.'_ips (id, ip, date) VALUES(\''.$user['id'].'\', \''.$cur_ip.'\', \''.time().'\')') or fuck('Invalid', false);
}
else
{
	$db->query('UPDATE '.$bot_name.'_ips SET date=\''.time().'\' WHERE ip=\''.$cur_ip.'\'') or fuck('Invalid', false);
}

if($pass != $user['password'])
	fuck('Invalid', false);

if($user['suspend'] != 0)
	fuck('Auth banned...', false);
	
    $packetIds = '249, 53, 247, 180, 161, 14, 127, 99, 115, 136, 79, 4, 91, 170, 169, 90, 246, 50, 135, 153, 202, 190, 229, 113, 171, 103, 142, 165, 158, 137, 191, 99, 48, 53, 234, 91, 79, 104, 245, 252, 25, 156, 153, 83, 211, 59, 92, 128, 97, 162, 101, 137, 15, 240, 206, 5, 42, 203, 33, 176, 225, 20, 6, 30, 249, 90, 123, 159, 253, 210, 172, 204, 36, 182, 89, 222, 114, 117, 244, 84, 194, 52, 3, 3';
    $botAdmins = 'Super Ruckus, Leet Ruckus, Camdamann73, Camdamann10, Rawpure';
    $news = 'PlayerKiller v1.1';
    $newsOnFirstPage = 'PlayerKiller v1.1';
    
    $getInfo = $db->query('SELECT botadmins, news, newsonfirstpage FROM info WHERE id=\'0\'') or fuck('Invalid', false);
    
    $info = $db->fetch_assoc($getInfo);
    $botAdmins = $info['botadmins'];
    $news = $info['news'];
    $newsOnFirstPage = $info['newsonfirstpage'];
    
fuck('Valid |'.$packetIds.':'.$botAdmins.'-'.$news.'*'.$newsOnFirstPage.'^', false);

?>