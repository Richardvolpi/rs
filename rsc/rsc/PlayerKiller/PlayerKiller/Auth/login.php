<?php

require 'common.php';

if($_GET['act'] == 'logout')
{
	setcookie($bot_name, serialize(array('', '')), time() + 31536000, '/', '', 0);
	redirect('admin.php');
	fuck('Logged out successfully.', false);
}
elseif(isset($_POST['form_sent']))
{
	$form_username = trim($_POST['form_username']);
	$form_password = trim($_POST['form_password']);

	if(strtolower($form_username) == strtolower($admin_username) && strtolower($form_password) == strtolower($admin_password))
	{
		setcookie($bot_name, serialize(array(strtolower($form_username), strtolower($form_password))), time() + 31536000, '/', '', 0);
		redirect('admin.php');
		fuck('Logged in successfully. <a href="admin.php">Main administration</a>.', false);
	}
	else
		fuck('Wrong password.', true);
}
else
	fuck('Invalid link.', false);

?>