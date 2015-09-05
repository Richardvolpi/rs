<?php

include 'head.php';

$result = $db->query('SELECT COUNT(id) FROM '.$bot_name.'_users') or fuck('Unable to count users', true);
$num_users = $db->result($result, 0);

?>

Welcome to the <?php echo $bot_name; ?> administration panel <?php echo $admin_username; ?>.<br>
You currently have <?php echo $num_users.' '.$bot_name; ?> users.

<?php

include 'end.php';

?>