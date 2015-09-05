<?php
/***********************************************************************

  Copyright (C) 2002-2005  Jamie Furness (reines@gmail.com)

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

// Tell admin_loader.php that this is indeed a plugin and that it is loaded
define('PUN_PLUGIN_LOADED', 1);

if (isset($_POST['submit'])) {
	$form = array_map('trim', $_POST['form']);
	
	require PUN_ROOT.'include/email.php';
	
	$form['paypal_email'] = strtolower($form['paypal_email']);
	if (!is_valid_email($form['paypal_email']))
		message('The paypal_email e-mail address you entered is invalid.');
	
	$form['currency'] = strtoupper($form['currency']);
	if(strlen($form['currency']) != 3)
		message('The currency you entered is invalid.');
	
	$form['length'] = isset($form['length']) ? intval($form['length']) : '0';
	$form['enabled'] = isset($form['enabled']) ? intval($form['enabled']) : '0';
	
	while(list($key, $input) = @each($form)) {
		// Only update values that have changed
		if(array_key_exists('s_'.$key, $pun_config) && $pun_config['s_'.$key] != $input) {
			if($input != '' || is_int($input)) {
				$value = '\''.$db->escape($input).'\'';
			}
			else {
				$value = 'NULL';
			}
			$db->query('UPDATE '.$db->prefix.'config SET conf_value='.$value.' WHERE conf_name=\'s_'.$db->escape($key).'\'') or error('Unable to update board config', __FILE__, __LINE__, $db->error());
		}
	}

	// Regenerate the config cache
	require_once PUN_ROOT.'include/cache.php';
	generate_config_cache();

	redirect($_SERVER['REQUEST_URI'], 'Settings updated. Redirecting &hellip;');
}
else {
	// Display the admin navigation menu
	generate_admin_menu($plugin);

?>
	<div id="exampleplugin" class="blockform">
		<h2><span>Subscription Plugin</span></h2>
		<div class="box">
			<div class="inbox">
				<p>This plugin allows you to set various settings related to the subscription mod. It also lists all current subscribers.</p>
			</div>
		</div>

		<h2 class="block2"><span>Subscription Settings</span></h2>
		<div class="box">
			<form id="example" method="post" action="<?php echo $_SERVER['REQUEST_URI'] ?>">
				<div class="inform">
					<fieldset>
						<legend>Payment Settings</legend>
						<div class="infldset">
							<table class="aligntop" cellspacing="0">
								<tr>
									<th scope="row">Subscription Enabled</th>
									<td>
										<input type="checkbox" name="form[enabled]" tabindex="1" value="1" <?php echo $pun_config['s_enabled'] == '1' ? ' checked="checked"' : ''; ?>/>
										<span>Enable or disable the subscription system.</span>
									</td>
								</tr>
								<tr>
									<th scope="row">Paypal Email Address</th>
									<td>
										<input type="text" name="form[paypal_email]" style="width:400px" tabindex="2" value="<?php echo pun_htmlspecialchars($pun_config['s_paypal_email']); ?>" />
										<span>This should be your <u>main</u> paypal email. Payments will be sent to this address.</span>
									</td>
								</tr>
								<tr>
									<th scope="row">Paypal Auth Token</th>
									<td>
										<input type="text" name="form[auth_token]" style="width:400px" tabindex="3" value="<?php echo pun_htmlspecialchars($pun_config['s_auth_token']); ?>" />
										<span>The auth token assosiated used to validate payments sent.</span>
									</td>
								</tr>
								<tr>
									<th scope="row">Payment Currency</th>
									<td>
										<input type="text" name="form[currency]" style="width:400px" tabindex="4" value="<?php echo pun_htmlspecialchars($pun_config['s_currency']); ?>" />
										<span>The currency you wish to receive payments in. ie. USD</span>
									</td>
								</tr>
								<tr>
									<th scope="row">Payment Amount</th>
									<td>
										<input type="text" name="form[price]" style="width:400px" tabindex="5" value="<?php echo pun_htmlspecialchars($pun_config['s_price']); ?>" />
										<span>How much it costs to be promoted. ie 5.00</span>
									</td>
								</tr>
							</table>
						</div>
					</fieldset>
					<br />
					<fieldset>
						<legend>Group Settings</legend>
						<div class="infldset">
							<table class="aligntop" cellspacing="0">
								<tr>
									<th scope="row">Subscription Usergroup</th>
									<td>
										
<?php

$result = $db->query('SELECT `g_id`, `g_title` FROM '.$db->prefix.'groups WHERE `g_id` > '.PUN_MEMBER) or error('Unable to fetch group information', __FILE__, __LINE__, $db->error());
if($db->num_rows($result)) {
	echo "\t\t\t\t\t\t\t\t\t\t".'<select name="form[new_gid]" style="width:400px" tabindex="6">'."\n";
	while($group = $db->fetch_assoc($result)) {
		echo "\t\t\t\t\t\t\t\t\t\t\t".'<option value="'.intval($group['g_id']).'"'.($group['g_id'] == $pun_config['s_new_gid'] ? ' selected="selected"' : '').'>'.pun_htmlspecialchars($group['g_title']).'</option>'."\n";
	}
	echo "\t\t\t\t\t\t\t\t\t\t".'</select>'."\n";
}
else {
	echo "\t\t\t\t\t\t\t\t\t\t".'<span>There are currently no valid usergroups. <a href="admin_groups.php">Click here</a> to add one.</span>'."\n";
}

?>
										<span>The usergroup members should be put into after payment.</span>
									</td>
								</tr>
								<tr>
									<th scope="row">Subscription Length</th>
									<td>
										<input type="text" name="form[length]" style="width:400px" tabindex="7" value="<?php echo pun_htmlspecialchars($pun_config['s_length']); ?>" />
										<span>How long (in days) members should remain in this group for. This requires the crontab to be working correctly. Set at 0 to disable.</span>
									</td>
								</tr>
								<tr>
									<th scope="row">Subscription Description</th>
									<td>
										<textarea name="form[description]" style="width:400px;height:100px" tabindex="8" /><?php echo pun_htmlspecialchars($pun_config['s_description']); ?></textarea>
										<span>A description to be shown on the subscribe page. This will not be parsed, and thus may contain html.</span>
									</td>
								</tr>
							</table>
						</div>
					</fieldset>
					<br />
					<div style="text-align:center"><input type="submit" name="submit" value="Update Settings" tabindex="9" /></div>
				</div>
			</form>
		</div>
	</div>
<?php

}

