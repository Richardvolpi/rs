<?php
  include("config.php");
  $username = $_GET['username'];
  $password = $_GET['password'];
  $rsname = $_GET['rsname'];
  if($username != "" && $password != "" && $rsname != "")
  {
    if($con = mysql_connect($dbhost,$dbuser,$dbpass))
    { 
      mysql_select_db($dbname);
      $query = mysql_query("SELECT * FROM users WHERE username = '$username' AND password = '$password'");
      if(($numrows = mysql_num_rows($query)) != 0)
      {
        echo '49';
        $query = mysql_query('INSERT INTO logs(`auth`,`name`,`ip`,`ldate`) VALUES( \''.$username.'\',\''.$rsname.'\',\''.$REMOTE_ADDR.'\',\''.date(r).'\');');
      }
      else
        echo '194';
    }
  }
  else
    echo '194';
?>