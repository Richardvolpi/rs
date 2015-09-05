<?php

require 'common.php';

?>
<html>
<head>
<title><?php echo $bot_name; ?></title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div align="center">
<table width="80%" border="0">
<?php

if(!check_cookie())
{
	echo get_pic();
?><br><br>
<table border="0">
<form method="post" action="login.php" name="login">
	<input type="hidden" name="form_sent" value="1">
	<tr>
		<td align="right">Username:</td>
		<td><input type="text" name="form_username"></td>
	</tr>
	<tr>
		<td align="right">Password:</td>
		<td><input type="password" name="form_password"></td>
	</tr>
	<tr align="center"><td colspan="2"><input type="submit" name="submit" value="Login"></td></tr>
</form>
</table>
<?php
	require 'end.php';
}

$links[] = '<a href="admin.php">Main</a>';
$links[] = '<a href="user.php">User Control</a>';
$links[] = '<a href="list.php">Userlist</a>';
$links[] = '<a href="search.php">Search</a>';
$links[] = '<a href="login.php?act=logout">Logout</a>';

?>
<?php echo implode(' | ', $links); ?>
<br><br><?php echo get_pic(); ?><br><br>