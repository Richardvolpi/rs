<?php

// Tell header.php to use the admin template
define('PUN_ADMIN_CONSOLE', 1);

define('PUN_ROOT', './');
require PUN_ROOT.'include/common.php';
require PUN_ROOT.'include/common_admin.php';

if ($pun_user['g_id'] > PUN_MOD)
	message($lang_common['No permission']);

define('LOG_DIR', '/home/rscd/server/logs/');

$log_files = array('event', 'error', 'mod');

if(isset($_GET['action']) && trim($_GET['action']) == 'download') {
	$log = trim($_GET['log']);
	if(!in_array($log, $log_files)) {
		message($lang_common['Bad request']);
	}
	
	$fp = fopen(LOG_DIR.$log.'.log', 'rb');
	header('Content-Type: application/octet-stream');
	header('Content-Disposition: attachment; filename="'.$log.'.log"');
	
	fpassthru($fp);
	fclose($fp);
	
	$db->close();
	exit;
}

$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Admin / RSCD Logs';
require PUN_ROOT.'header.php';

generate_admin_menu('rscd_logs');

?>
	<div class="blockform">
		<h2><span><span>Log Files</span></h2>
		<div class="box">
			<div class="inbox" style="padding:15px">
<?php

foreach($log_files as $log_file) {
	if(!file_exists(LOG_DIR.$log_file.'.log')) {
		continue;
	}
	$file_size = filesize(LOG_DIR.$log_file.'.log');
	
	echo "\t\t\t\t".'<fieldset>'."\n";
	echo "\t\t\t\t\t".'<legend>'.ucwords($log_file).' Log</legend>'."\n";
	echo "\t\t\t\t\t".'<div class="infldset">'."\n";
	echo "\t\t\t\t\t\t".'<p>Allows viewing of the latest '.$log_file.' log from the server.</p>'."\n";
	echo "\t\t\t\t\t\t".'<p>Note: <i>This is reset when the server is started.</i></p>'."\n";
	echo "\t\t\t\t\t\t".'<div style="text-align:center">'."\n";
	if($file_size < 1048576) {
		echo '<textarea style="width:100%;height:200px" readonly="readonly">'."\n";
		echo htmlspecialchars(trim(file_get_contents(LOG_DIR.$log_file.'.log')))."\n";
		echo '</textarea>'."\n";
	}
	else {
		echo "\t\t\t\t\t\t\t".'<p>Log omitted because over 1Mb (filesize: '.size_readable($file_size).'), <a href="admin_rscd_logs.php?action=download&log='.$log_file.'">click here to download</a>.</p>'."\n";
	}
	echo "\t\t\t\t\t\t".'</div>'."\n";
	echo "\t\t\t\t\t".'</div>'."\n";
	echo "\t\t\t\t".'</fieldset>'."\n";
	echo "\t\t\t\t".'<br />'."\n";
}

?>
			</div>
		</div>
	</div>
	<div class="clearer"></div>
</div>
<?php

require PUN_ROOT.'footer.php';