<?php

define('PUN_ROOT', '/home/rscd/public_html/');
include PUN_ROOT.'include/base.php';

if($pun_config['s_length'] < 1) {
	$db->close();
	exit('No subscription length'."\n");
}

$db->query('UPDATE '.$db->prefix.'users SET group_id='.PUN_MEMBER.', sub_expires=0 WHERE group_id='.$pun_config['s_new_gid'].' AND sub_expires<'.time()) or error('Unable to update expired subscriptions', __FILE__, __LINE__, $db->error());
$num = $db->affected_rows($result);

$db->close();
exit('Finished: Demoted '.$num.' users'."\n");
