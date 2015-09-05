<?php


define('PUN_ROOT', './');
require PUN_ROOT.'include/common.php';

$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / IRC';
require PUN_ROOT.'header.php';

$irc_nick = $pun_user['is_guest'] ? 'Guest'.mt_rand(1000, 9999) : str_replace(' ', '_', $pun_user['username']);
	
?>
<div class="block">
	<h2><span>IRC Server Details</span></h2>
	<div class="box" style="padding:4px">
		<p>If you wish to connect using <a href="http://www.mirc.com">mIRC</a> or <a href="http://www.xchat.org">xChat</a> then please use <a href="irc://irc.rscdaemon.org">irc://irc.rscdaemon.org:6667</a> and join #rscd.</p>
	</div>
</div>
<div style="text-align:center;margin-bottom:20px;">
	<applet codebase="include/pjirc/" code="IRCApplet.class" archive="irc.jar,pixx.jar" width="700" height="400">
		<param name="CABINETS" value="irc.cab,securedirc.cab,pixx.cab" />
		<param name="nick" value="<?php echo $irc_nick; ?>" />
		<param name="alternatenick" value="`<?php echo $irc_nick; ?>" />
		<param name="name" value="pjirc" />
		<param name="host" value="irc.rscdaemon.org" />
		<param name="gui" value="pixx" />
		<param name="command1" value="join #rscd" />
	</applet>
</div>
<?php
	
require PUN_ROOT.'footer.php';
$db->close();
exit;
