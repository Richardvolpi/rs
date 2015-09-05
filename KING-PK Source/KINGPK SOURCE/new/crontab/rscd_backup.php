<?php

define('PUN_ROOT', '/home/rscd/public_html/');
include PUN_ROOT.'include/base.php';

$backup_dir = '/home/rscd/backup/';

$result = shell_exec('mysqldump -u'.$db_username.' -p'.$db_password.' rscd_database | gzip > '.$backup_dir.time().'.sql.gz');

$db->close();
exit('Finished'."\n");
