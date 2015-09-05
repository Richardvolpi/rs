<?php
// Connecting, selecting database
$link = mysql_connect('localhost', 'exbotauth', 'almond')
   or die('Could not connect: ' . mysql_error());
mysql_select_db('auth') or die('Could not select database');

// Performing SQL query
$botinput = $_GET['bot'];
$logininput = $_GET['login'];
$passinput = $_GET['pass'];

$showmessage = $_GET['showmessage'];

$query = "SELECT * FROM auths WHERE bot='$botinput' AND login='$logininput' AND password='$passinput'";

$result = mysql_query($query) or die('Query failed: ' . mysql_error());
if(mysql_affected_rows() == 0) die("failed\nAuth Invalid");
$echostring = mysql_result($result, 0, 'status') . "\n" . mysql_result($result, 0, 'message');
echo "$echostring";

// Printing results in HTML
//echo "<table>\n";
//while ($line = mysql_fetch_array($result, MYSQL_ASSOC)) {
//   echo "\t<tr>\n";
//   foreach ($line as $col_value) {
//       echo "\t\t<td>$col_value</td>\n";
//   }
//   echo "\t</tr>\n";
//}
//echo "</table>\n";
//
// Free resultset
mysql_free_result($result);
//
// Closing connection
mysql_close($link);
//?>