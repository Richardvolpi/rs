<?

 if(isset($_GET['user']))
  {

 //add user to db
        mysql_connect("localhost", "mediator_rscheat", "adpass123") or
        die('The SQL server is down.');

        mysql_select_db("mediator_sleepwalker");
$usrname = $_GET['user'];
$nnum = $_GET['gid'];
$usernum = mysql_result(mysql_query("SELECT usernum FROM temp_user WHERE user='$usrname'"), 0, 0);
$pass = mysql_result(mysql_query("SELECT pass FROM temp_user WHERE user='$usrname'"), 0, 0);
$email = mysql_result(mysql_query("SELECT email FROM temp_user WHERE user='$usrname'"), 0, 0);
$message = mysql_result(mysql_query("SELECT message FROM temp_user WHERE user='$usrname'"), 0, 0);

if ($usernum == $nnum) {

     $result = mysql_query("INSERT INTO user (user, pass, email, message)
                               VALUES ('$usrname', '$pass', '$email', '$message')");
     

echo "Account Confirmed you may now use sleepwalker";

}
 
}



?>
