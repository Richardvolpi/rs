<?php

// Tell header.php to use the admin template
define('PUN_ADMIN_CONSOLE', 1);

define('PUN_ROOT', './');
require PUN_ROOT.'include/common.php';
require PUN_ROOT.'include/common_admin.php';

if ($pun_user['g_id'] > PUN_ADMIN)
	message($lang_common['No permission']);

$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Admin / RSCD Control';
require PUN_ROOT.'header.php';

$result = $db->query('SELECT COUNT(user) FROM '.$db->prefix.'rscd_online') or error('Unable to check if server is online', __FILE__, __LINE__, $db->error());
if(!$db->result($result)) {
	redirect(PUN_ROOT.'status.php', 'Server seems to be down!');
}

if(isset($_POST['gracefulstop'])) {
	shutdownworld();
	redirect($_SERVER['REQUEST_URI'], 'Server shutting down. Redirecting &hellip;');
}
elseif(isset($_POST['update'])) {
	$message = trim($_POST['update_message']);
	updateworld($message);
	redirect($_SERVER['REQUEST_URI'], 'The server will shut down in 60 seconds. Redirecting &hellip;');
}
elseif(isset($_POST['global'])) {
	$message = trim($_POST['global_message']);
	if(empty($message)) {
		message('You didn\'t enter a message');
	}
	sendglobal($message);
	redirect($_SERVER['REQUEST_URI'], 'Global message sent. Redirecting &hellip;');
}
elseif(isset($_POST['alert'])) {
	$user = encode_username($_POST['alert_username']);
	$message = trim($_POST['alert_message']);
	if(!$user || empty($message)) {
		message('Invalid username, or no message supplied');
	}
	alertplayer($user, $message);
	redirect($_SERVER['REQUEST_URI'], pun_htmlspecialchars($result).'. Redirecting &hellip;');
}

generate_admin_menu('rscd_control');

?>
	<div class="blockform">
		<h2 class="block2"><span>Server Control</span></h2>
		<div class="box">
			<form method="post" action="admin_rscd_control.php">
				<div class="inform">
<?php if($pun_user['g_id'] == PUN_ADMIN): ?>
					<fieldset>
						<legend>Shutdown the Worlds</legend>
						<div class="infldset">
							<table class="aligntop" cellspacing="0">
								<tr>
									<th scope="row"><input type="submit" name="update" value="Update" /></th>
									<td>
										<input type="text" name="update_message" style="width:400px" value="" />
										<span>This will shut down the server, giving a 60 second warning and alerting all players of the shutdown. Ideally the server should be shut down this way.</span>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<p style="text-align:center"><input type="submit" name="gracefulstop" value="Graceful Shutdown" style="width:200px" /></p>
										<span>This will request that the server saves all accounts and shuts down as soon as possible. If the server has crashed this may not work.</span>
									</td>
								</tr>
							</table>
						</div>
					</fieldset>
					<br />
<?php endif; ?>
					<fieldset>
						<legend>Server Commands</legend>
						<div class="infldset">
							<table class="aligntop" cellspacing="0">
								<tr>
									<th scope="row"><input type="submit" name="global" value="Global Message" /></th>
									<td>
										<input type="text" name="global_message" style="width:400px" value="" />
										<span>This will send out a global message to everyone logged in.</span>
									</td>
								</tr>
								<tr>
									<th scope="row"><input type="submit" name="alert" value="Send Alert" /></th>
									<td>
										<input type="text" name="alert_username" style="width:100px" value="" />
										<input type="text" name="alert_message" style="width:300px" value="" />
										<span>This will send out an alert to the specified user.</span>
									</td>
								</tr>
							</table>
						</div>
					</fieldset>
				</div>
			</form>
		</div>
	</div>
	<div class="clearer"></div>
</div>
<?php

require PUN_ROOT.'footer.php';