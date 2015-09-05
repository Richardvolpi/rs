<?php

if(isset($_POST['final']))
{
	if(!file_exists('config.php'))
		die('Config.php is missing!');

	include 'common.php';

?>
<html>
<head>
<title>Install script</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div align="center">
<table width="80%" border="0">
<?php

	$db->query('CREATE TABLE `'.$bot_name.'_users` (`id` INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY ,`username` VARCHAR(20) ,`password` VARCHAR(20) ,`email` VARCHAR(40) ,`comment` VARCHAR(255) ,`date` INT(10) UNSIGNED DEFAULT \'0\' NOT NULL ,`suspend` TINYINT(1) UNSIGNED DEFAULT \'0\' NOT NULL);') or fuck('Unable to create table '.$bot_name.'_users', true);
	
	$db->query('CREATE TABLE `'.$bot_name.'_ips` (`id` INT(4) UNSIGNED,`ip` VARCHAR(50) ,`date` INT(10) UNSIGNED DEFAULT \'0\' NOT NULL);') or fuck('Unable to create table '.$bot_name.'_ips', true);
	
	alert('Installation now complete, for security reasons please now delete install.php');
	redirect('admin.php');
	fuck('Installation now complete, for security reasons please now delete install.php', false);
	
	include 'end.php';
}
elseif(isset($_POST['config']))
{

?>
<html>
<head>
<title>Install script</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div align="center">
<table width="80%" border="0">
<?php

	$bot_name = $_POST['bot_name'];
	$admin_username = strtolower($_POST['admin_username']);
	$admin_password = strtolower($_POST['admin_password']);
	
	$db_host = $_POST['db_host'];
	$db_name = $_POST['db_name'];
	$db_username = $_POST['db_username'];
	$db_password = $_POST['db_password'];
	
	$date_format = $_POST['date_format'];
	
	echo '<textarea name="config" cols="40" rows="15"><?php'."\n".'$bot_name = \''.$bot_name.'\';'."\n".'$admin_username = \''.$admin_username.'\';'."\n".'$admin_password = \''.$admin_password.'\';'."\n\n".'$db_host = \''.$db_host.'\';'."\n".'$db_name = \''.$db_name.'\';'."\n".'$db_username = \''.$db_username.'\';'."\n".'$db_password = \''.$db_password.'\';'."\n\n".'$date_format = \''.$date_format.'\';'."\n".'?></textarea><br>';
	?>
	Please save the above as config.php and upload it before finishing the instalation.
<form method="post" action="install.php" name="confirm">
	<input type="hidden" name="final" value="1">
	<input type="submit" name="submit" value="Finish installation">
</form></table></div></body></html>
	<?php
}
else
{
	?>
<html>
<head>
<title>Install script</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div align="center">
<table width="80%" border="0">
<table border="0">
<form method="post" action="install.php" name="start">
	<input type="hidden" name="config" value="1">
	<tr>
		<td align="right">Bot Name:</td>
		<td><input type="text" name="bot_name"></td>
	</tr>
	<tr>
		<td align="right">Root Username:</td>
		<td><input type="text" name="admin_username"></td>
	</tr>
	<tr>
		<td align="right">Root Password:</td>
		<td><input type="text" name="admin_password"></td>
	</tr>
	<tr>
		<td align="right">MySQL host:</td>
		<td><input type="text" name="db_host" value="localhost"></td>
	</tr>
	<tr>
		<td align="right">MySQL DB name:</td>
		<td><input type="text" name="db_name"></td>
	</tr>
	<tr>
		<td align="right">MySQL Username:</td>
		<td><input type="text" name="db_username"></td>
	</tr>
	<tr>
		<td align="right">MySQL Password:</td>
		<td><input type="text" name="db_password"></td>
	</tr>
	<tr>
		<td align="right">Date format:</td>
		<td><input type="text" name="date_format" value="H:i d-m-Y"></td>
	</tr>
	<tr align="center"><td colspan="2"><input type="submit" name="submit" value="Generate config"></td></tr>
</form>
</table></table></div></body></html>
	<?php
}

?>