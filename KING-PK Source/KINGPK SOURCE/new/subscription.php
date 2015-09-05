<?php

define('PUN_ROOT', './');
require PUN_ROOT.'include/common.php';

if($pun_config['s_enabled'] != '0') {
	message('Subscriptions are currently disabled.');
}

$user_id = isset($_GET['user']) ? intval($_GET['user']) : $pun_user['id'];

$result = $db->query('SELECT * FROM '.$db->prefix.'users WHERE id='.$user_id) or error('Unable to get user info', __FILE__, __LINE__, $db->error());
$sub_user = $db->fetch_assoc($result);

if($sub_user['group_id'] != PUN_MEMBER && $sub_user['group_id'] != $pun_config['s_new_gid']) {
	message('Only members are allowed to subscribe.');
}

if(isset($_GET['tx'])) {
	$tx_token = trim($_GET['tx']);
	$req = 'cmd=_notify-synch&tx='.$tx_token.'&at='.$pun_config['s_auth_token'];
	
	$ctx = stream_context_create(array('http' => array(
		'method' => 'POST',
		'header' => 'Content-Type: application/x-www-form-urlencoded'."\r\n".'Content-Length: '.strlen($req)."\r\n",
		'content' => $req
	)));
	$lines = file('http://www.paypal.com/cgi-bin/webscr', FILE_IGNORE_NEW_LINES, $ctx);
	if(array_shift($lines) != 'SUCCESS') {
		message('Unknown tx_id. Please contact an admin.');
	}
	$ppresult = array();
	foreach($lines as $line) {
		list($key, $value) = explode('=', $line);
		$ppresult[urldecode($key)] = urldecode($value);
	}
	
	$result = $db->query('SELECT * FROM '.$db->prefix.'paypal_subscriptions WHERE txn_id=\''.$db->escape($ppresult['txn_id']).'\'') or error('Unable to fetch paypal subscription info', __FILE__, __LINE__, $db->error());
	if($db->num_rows($result)) {
		message('This txn_id has already been processed. Please contact an admin.');
	}
	
	$db->query('INSERT INTO '.$db->prefix.'paypal_subscriptions(txn_id, receiver_email, payer_email, payment_status, payment_amount, payment_currency, time, user_id, payer_ip) VALUES(\''.$db->escape($ppresult['txn_id']).'\', \''.$db->escape($ppresult['receiver_email']).'\', \''.$db->escape($ppresult['payer_email']).'\', \''.$db->escape($ppresult['payment_status']).'\', \''.$db->escape($ppresult['payment_gross']).'\', \''.$db->escape($ppresult['mc_currency']).'\', '.time().', '.intval($sub_user['id']).', \''.get_remote_address().'\')') or error('Unable to insert paypal subscription info', __FILE__, __LINE__, $db->error());
	
	if($ppresult['receiver_email'] != $pun_config['s_paypal_email']) {
		message('The email the payment was sent to did not match. Please contact an admin.');
	}
	if($ppresult['payment_status'] != 'Completed') {
		message('The payment was not fully completed. If you payed using e-Cheque rather than instant payment it can take up to 9 days to clear. Please wait for the payment to clear, then if you are not upgraded contact an admin.');
	}
	if($ppresult['payment_gross'] < $pun_config['s_price']) {
		message('The wrong amount was payed. Please contact an admin.');
	}
	if($ppresult['mc_currency'] != $pun_config['s_currency']) {
		message('An invalid currency was used. Please contact an admin.');
	}
	
	$length = $pun_config['s_length'] * 86400;
	
	if($sub_user['group_id'] == $pun_config['s_new_gid']) {
		$db->query('UPDATE '.$db->prefix.'users SET sub_expires=sub_expires+'.$length.' WHERE id='.intval($sub_user['id'])) or error('Unable to update subscription expire time', __FILE__, __LINE__, $db->error());
	}
	else {
		$db->query('UPDATE '.$db->prefix.'users SET group_id='.intval($pun_config['s_new_gid']).', invites=2, sub_expires='.($pun_config['s_length'] > 0 ? (time() + $length) : '0').' WHERE id='.intval($sub_user['id'])) or error('Unable to update group id', __FILE__, __LINE__, $db->error());
	}
	
	redirect('index.php', 'Payment successful. Thank you');

}
else {
	$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Subscription';
	require PUN_ROOT.'header.php';
	
	?>
<div class="block">
	<h2><span>Subscribe to <?php echo pun_htmlspecialchars($pun_config['o_board_title']); ?></span></h2>
	<div class="box">
		<div class="inbox" style="text-align:center">
			<div><b>This subscription is for <a href="profile.php?id=<?php echo $sub_user['id']; ?>"><?php echo pun_htmlspecialchars($sub_user['username']); ?></a>.</b></div>
			<div><?php echo $sub_user['group_id'] == $pun_config['s_new_gid'] ? '<p>This will allow you to extend your subscription for another '.$pun_config['s_length'].' days.' : $pun_config['s_description']; ?></div>
			<!-- START PAYPAL PAYMENT FORM -->
			<form action="https://www.paypal.com/cgi-bin/webscr" method="post">
				<div class="inform" style="margin-top:10px">
					<input type="hidden" name="cmd" value="_xclick">
					<input type="hidden" name="business" value="<?php echo pun_htmlspecialchars($pun_config['s_paypal_email']); ?>">
					<input type="hidden" name="item_name" value="<?php echo pun_htmlspecialchars($pun_config['o_board_title']); ?> Subscription">
					<input type="hidden" name="amount" value="<?php echo pun_htmlspecialchars($pun_config['s_price']); ?>">
					<input type="hidden" name="no_shipping" value="1">
					<input type="hidden" name="return" value="<?php echo pun_htmlspecialchars('http://'.$_SERVER['HTTP_HOST'].$_SERVER['PHP_SELF'].'?user='.$sub_user['id']); ?>">
					<input type="hidden" name="no_note" value="1">
					<input type="hidden" name="currency_code" value="<?php echo pun_htmlspecialchars($pun_config['s_currency']); ?>">
					<input type="hidden" name="bn" value="PP-BuyNowBF">
					<input type="image" src="img/paypal.gif" name="submit" alt="Make payments with PayPal - it's fast, free and secure!">
					<p><b>Note</b>: After payment please let paypal redirect you back here, otherwise your status will not automatically get updated.</p>
				</div>
			</form>
			<!-- END PAYPAL PAYMENT FORM -->
<?php

	if($pun_config['s_length'] > 0 && $sub_user['group_id'] != $pun_config['s_new_gid']) {
		echo "\t\t\t".'<p>This subscription will last for '.$pun_config['s_length'].' days, then you will be returned to the member usergroup.</p>'."\n";
	}

?>
		</div>
	</div>
</div>
	<?php
	
	require PUN_ROOT.'footer.php';
}
