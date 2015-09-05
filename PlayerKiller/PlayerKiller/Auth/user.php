<?php

include 'head.php';
include 'ip_functions.php';
if($_GET['act'] == 'add' && isset($_POST['form_sent']))
{
	$new_username = strtolower(trim(stripslashes($_POST['form_username'])));
	$new_password = strtolower(trim(stripslashes($_POST['form_password'])));
	$new_email = strtolower(trim($_POST['form_email']));
	$new_comment = trim(stripslashes($_POST['form_comment']));
	
	$new_comment = ($new_comment == '' ? '-' : $new_comment);
	
	if(strlen($new_username) < 4 || strlen($new_username) > 20)
		fuck('Username invalid length', true);
	elseif(strlen($new_password) < 4 || strlen($new_password) > 20)
		fuck('Password invalid length', true);
	elseif(!is_valid_email($new_email))
		fuck('Invalid email address', true);
	elseif(strpos($new_username,' ') ||strpos($new_username,'_') || strpos($new_username,'\'') || strpos($new_username,'\\') || strpos($new_username,'?'))
		fuck('Username contains invalid characters', true);
	elseif(strpos($new_password,' ') ||strpos($new_password,'_') || strpos($new_password,'\'') || strpos($new_password,'\\') || strpos($new_password,'?'))
		fuck('Password contains invalid characters', true);

	$result = $db->query('SELECT * FROM '.$bot_name.'_users WHERE username=\''.addslashes($username).'\' OR username=\''.addslashes(preg_replace('/[^\w]/', '', $username)).'\' OR email=\''.$new_email.'\'') or fuck('Unable to fetch user info', true);
	if($db->num_rows($result))
		fuck('Username and/or email address already exists', true);


	$db->query('INSERT INTO '.$bot_name.'_users (username, password, email, comment, date, suspend) VALUES(\''.addslashes($new_username).'\', \''.addslashes($new_password).'\', \''.addslashes($new_email).'\', \''.addslashes($new_comment).'\', '.time().', 0)') or fuck('Unable to add user', true);
	
	alert($new_username.' added with password '.$new_password.'.');	
	redirect('user.php');
	fuck($new_username.' added with password '.$new_password.'.', false);
}
elseif($_GET['act'] == 'del')
{
	$db->query('DELETE FROM '.$bot_name.'_users WHERE id='.$_GET['id']) or fuck('Unable to delete user', true);
	alert('User successfully deleted');	
	redirect('list.php');
	fuck('User successfully deleted', false);
}
elseif($_GET['act'] == 'edit')
{
	$id = $_GET['id'];
	$result = $db->query('SELECT * FROM '.$bot_name.'_users WHERE id='.$id) or fuck('Unable to fetch user info', true);
	$user = $db->fetch_assoc($result);
	
?>
<table border="0">
<form method="post" action="user.php?act=submitedit" name="Edit">
	<input type="hidden" name="form_sent" value="1">
	<input type="hidden" name="form_id" value="<?php echo $user['id']; ?>">
	<tr>
		<td align="right">Username:</td>
		<td><input type="text" name="form_username" value="<?php echo $user['username']; ?>"></td>
	</tr>
	<tr>
		<td align="right">Password:</td>
		<td><input type="text" name="form_password" value="<?php echo $user['password']; ?>"></td>
	</tr>
	<tr>
		<td align="right">Email:</td>
		<td><input type="text" name="form_email" value="<?php echo $user['email']; ?>"></td>
	</tr>
	<tr>
		<td align="right">Comment:</td>
		<td><textarea name="form_comment" cols="15" rows="3"><?php echo $user['comment']; ?></textarea></td>
	</tr>
	<tr align="center"><td colspan="2">Suspended: <input type="checkbox" name="form_suspend" value="1"<?php if($user['suspend'] == '1') echo ' checked'; ?>></td></tr>
	<tr align="center"><td colspan="2"><input type="submit" name="submit" value="Edit User"></td></tr>
</form>	
</table>
<br><br>
<table border="0" width="15%">
	<tr align="center">
		<td>IP</td>
		<td>Date last used</td>
	</tr>
	<?php
	$result = $db->query('SELECT * FROM '.$bot_name.'_ips WHERE id='.$id) or fuck('Unable to fetch user IPs', true);
	while($ips = $db->fetch_assoc($result))
	{
	?>
	<tr align="center">
		<td><?php echo $ips['ip'].' ('.IPtoCountry($ips['ip']).')'; ?></td>
		<td><?php echo date($date_format, $ips['date']); ?></td>
	</tr>
	<?php
	}
	?>
</table>
<?php
}
elseif($_GET['act'] == 'submitedit' && isset($_POST['form_sent']))
{
	$new_id = $_POST['form_id'];
	$new_username = strtolower(trim(stripslashes($_POST['form_username'])));
	$new_password = strtolower(trim(stripslashes($_POST['form_password'])));
	$new_email = strtolower(trim($_POST['form_email']));
	$new_comment = trim(stripslashes($_POST['form_comment']));
	$new_suspend = ($_POST['form_suspend'] == 1 ? 1 : 0);
	
	$new_comment = ($new_comment == '' ? '-' : $new_comment);
	
	if(strlen($new_username) < 4 || strlen($new_username) > 20)
		fuck('Username invalid length', true);
	elseif(strlen($new_password) < 4 || strlen($new_password) > 20)
		fuck('Password invalid length', true);
	elseif(!is_valid_email($new_email))
		fuck('Invalid email address', true);
	elseif(strpos($new_username,' ') ||strpos($new_username,'_') || strpos($new_username,'\'') || strpos($new_username,'\\') || strpos($new_username,'?'))
		fuck('Username contains invalid characters', true);
	elseif(strpos($new_password,' ') ||strpos($new_password,'_') || strpos($new_password,'\'') || strpos($new_password,'\\') || strpos($new_password,'?'))
		fuck('Password contains invalid characters', true);

	$db->query('UPDATE '.$bot_name.'_users SET username=\''.addslashes($new_username).'\', password=\''.addslashes($new_password).'\', email=\''.addslashes($new_email).'\', comment=\''.addslashes($new_comment).'\', suspend=\''.$new_suspend.'\' WHERE id='.$new_id) or fuck('Unable to update user', true);
	
	alert('Details of '.$new_username.' updated.');	
	redirect('list.php');
	fuck('Details of '.$new_username.' updated.', false);
}
else
{
?>
<table border="0">
<form method="post" action="user.php?act=add" name="Add">
	<input type="hidden" name="form_sent" value="1">
	<tr>
		<td align="right">Username:</td>
		<td><input type="text" name="form_username"></td>
	</tr>
	<tr>
		<td align="right">Password:</td>
		<td><input type="text" name="form_password"></td>
	</tr>
	<tr>
		<td align="right">Email:</td>
		<td><input type="text" name="form_email"></td>
	</tr>
	<tr>
		<td align="right">Comment:</td>
		<td><textarea name="form_comment" cols="15" rows="3"></textarea></td>
	</tr>
	<tr align="center"><td colspan="2"><input type="submit" name="submit" value="Add User"></td></tr>
</form>	
</table>
<?php
}
include 'end.php';

?>