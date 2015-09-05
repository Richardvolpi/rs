<?php

define('PUN_ROOT', '/home/rscd/public_html/');
include PUN_ROOT.'include/base.php';

$db->query('UPDATE '.$db->prefix.'users SET invites=1 WHERE group_id='.PUN_MEMBER.' AND invites<1') or error('Unable to give members invites', __FILE__, __LINE__, $db->error());
$db->query('UPDATE '.$db->prefix.'users SET invites=2 WHERE (group_id='.$pun_config['s_new_gid'].' OR group_id='.PUN_MOD.') AND invites<2') or error('Unable to give subscribers and mods invites', __FILE__, __LINE__, $db->error());

$db->close();
exit('Finished'."\n");
