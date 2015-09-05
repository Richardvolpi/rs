<?php
/***********************************************************************

  Copyright (C) 2006  Jamie Furness (reines@gmail.com)

  This file is part of PunBB.

  PunBB is free software; you can redistribute it and/or modify it
  under the terms of the GNU General Public License as published
  by the Free Software Foundation; either version 2 of the License,
  or (at your option) any later version.

  PunBB is distributed in the hope that it will be useful, but
  WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 59 Temple Place, Suite 330, Boston,
  MA  02111-1307  USA

************************************************************************/


// Make sure no one attempts to run this script "directly"
if (!defined('PUN'))
	exit;

@set_time_limit(0);

require PUN_ROOT.'include/email.php';

// Tell admin_loader.php that this is indeed a plugin and that it is loaded
define('PUN_PLUGIN_LOADED', 1);

if(isset($_GET['e_per_page']) && isset($_GET['e_start_at']) && isset($_GET['e_subject']) && isset($_GET['e_message'])) {
	$subject = urldecode($_GET['e_subject']);
	$message = urldecode($_GET['e_message'])."\n\n".'----------------------------------'."\n".'Don\'t want to receive emails from '.$pun_config['o_board_title'].'? They can be disabled in your profile.';
	$per_page = intval($_GET['e_per_page']);
	$start_at = intval($_GET['e_start_at']);
	$end_at = $start_at + $per_page;
	
	$result = $db->query('SELECT u.email, b.id AS b_id FROM '.$db->prefix.'users AS u LEFT JOIN '.$db->prefix.'bans AS b ON b.username=u.username WHERE u.id>1 AND u.allow_email=1 LIMIT '.$start_at.','.$per_page) or error('Unable to retrieve users emails', __FILE__, __LINE__, $db->error());
	while($user = $db->fetch_assoc($result)) {
		if(isset($user['b_id'])) {
			continue;
		}
		pun_mail($user['email'], $pun_config['o_board_title'].': '.$subject, $message, $pun_config['o_webmaster_email']);
		echo 'Mail sent to '.$user['email'].'<br />'."\n";
		usleep(250);
	}
	
	// Check if there is more work to do
	$result = $db->query('SELECT id FROM '.$db->prefix.'users WHERE id>'.$end_at) or error('Unable to fetch user info', __FILE__, __LINE__, $db->error());
	$query_str = ($db->num_rows($result)) ? '&e_per_page='.$per_page.'&e_start_at='.$end_at.'&e_subject='.urlencode($subject).'&e_message='.urlencode($message) : '';
	
	$db->end_transaction();
	$db->close();
	
	exit('<script type="text/javascript">window.location="admin_loader.php?plugin='.basename(__FILE__).$query_str.'"</script><br />JavaScript redirect unsuccessful. Click <a href="admin_loader.php?plugin='.basename(__FILE__).$query_str.'">here</a> to continue.');
}

// Display the admin navigation menu
generate_admin_menu($plugin);
?>
	<div id="exampleplugin" class="blockform">
		<h2><span>Mailer Plugin</span></h2>
		<div class="box">
			<div class="inbox">
				<p>This plugin can be used to send out a news letter or announcement to all your forum members.</p>
			</div>
		</div>
		
		<h2 class="block2"><span>Announcement Emailer</span></h2>
		<div class="box">
			<form method="GET" action="admin_loader.php">
				<div class="inform">
					<input type="hidden" name="plugin" value="<?php echo basename(__FILE__); ?>" />
					<input type="hidden" name="e_per_page" value="100" />
					<input type="hidden" name="e_start_at" value="0" />
					<fieldset>
						<legend>Message Contents</legend>
						<div class="infldset">
							<table class="aligntop" cellspacing="0">
								<tr>
									<th scope="row">Subject:</th>
									<td><input type="text" name="e_subject" size="100" /></td>
								</tr>
								<tr>
									<th scope="row">Message:</th>
									<td><textarea name="e_message" rows="20" cols="100"></textarea></td>
								</tr>
							</table>
						</div>
					</fieldset>
				</div>
				<p class="submitend"><input type="submit" name="start_mail" value="Send Mails" /></p>
			</form>
		</div>
	</div>
