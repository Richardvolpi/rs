<?php

include 'head.php';

?>
<table cellspacing="1" cellpadding="4" border="0" width="70%">
	<tr>
		<td style="width: 10%">Username</td>
		<td style="width: 55%">Comment</td>
		<td style="width: 20%">Date</td>
		<td style="width: 5%" align="center">Suspended?</td>
		<td style="width: 10%" align="center">Delete?</td>
	</tr>
<?php

	$result = $db->query('SELECT * FROM '.$bot_name.'_users ORDER BY date') or fuck('Unable to fetch user list', true);
	while($user = $db->fetch_assoc($result))
	{
?>
		<tr>
			<td><?php echo '<a href="user.php?act=edit&id='.$user['id'].'">'.$user['username'].'</a>'; ?></td>
			<td><?php echo $user['comment']; ?></td>
			<td><?php echo date($date_format, $user['date']); ?></td>
			<td align="center"><?php echo ($user['suspend'] == 1 ? '<font color="#FF0000">Yes</font>' : 'No'); ?></td>
			<td align="center"><?php echo '<a href="user.php?act=del&id='.$user['id'].'">Delete</a>'; ?></td>
		</tr>
<?php
	}
?>
</table>
<?php

include 'end.php';

?>