<?php

include 'head.php';
$act = $_GET['act'];

if(($act == 'username' || $act == 'email') && isset($_POST['form_sent']))
{
	$find = strtolower(trim(stripslashes($_POST['find_'.$act])));
	$result = $db->query('SELECT id FROM '.$bot_name.'_users WHERE '.$act.'=\''.addslashes($find).'\'') or fuck('Unable to find user info', true);
	if(!$db->num_rows($result))
	{
		alert('Cannot be found');
		redirect('search.php');
		fuck('Cannot be found', false);
	}
	$userid = $db->fetch_assoc($result);
	redirect('user.php?act=edit&id='.$userid['id']);
	fuck('<a href="user.php?act=edit&id='.$userid.'">Click here to view info.</a>', false);
}
elseif($act == 'ip' && isset($_POST['form_sent']))
{
	$find = trim($_POST['find_ip']);
	$result = $db->query('SELECT id FROM '.$bot_name.'_ips WHERE ip=\''.$find.'\'') or fuck('Unable to find IP info', true);
	if(!$db->num_rows($result))
	{
		alert('Cannot be found');
		redirect('search.php');
		fuck('Cannot be found', false);
	}
	$userid = $db->fetch_assoc($result);
	redirect('user.php?act=edit&id='.$userid['id']);
	fuck('<a href="user.php?act=edit&id='.$userid.'">Click here to view info.</a>', false);	
}
else
{
?>
<table border="0">
<form method="post" action="search.php?act=username" name="Find">
	<input type="hidden" name="form_sent" value="1">
	<tr>
		<td align="right">Username:</td>
		<td><input type="text" name="find_username"></td>
		<td><input type="submit" name="submit" value="Find by Username"></td>
	</tr>
</form>
<form method="post" action="search.php?act=email" name="Find">
	<input type="hidden" name="form_sent" value="1">
	<tr>
		<td align="right">Email:</td>
		<td><input type="text" name="find_email"></td>
		<td><input type="submit" name="submit" value="Find by Email"></td>
	</tr>
</form>
<form method="post" action="search.php?act=ip" name="Find">
	<input type="hidden" name="form_sent" value="1">
	<tr>
		<td align="right">IP:</td>
		<td><input type="text" name="find_ip"></td>
		<td><input type="submit" name="submit" value="Find by IP"></td>
	</tr>
</form>	
</table>
<?
}

include 'end.php';

?>