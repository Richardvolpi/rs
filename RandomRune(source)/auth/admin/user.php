<?php
  if(($username = strtolower($_POST['user'])) == "")
    $username = strtolower($_GET['user']);
  if($username != "")
  {
    include("../config.php");
    $password = strtolower($_POST['pass']);
    $comments = $_POST['comments'];
    echo '<html>';
    echo '<head>';
    echo '<title>'.$username.'\'s stats</title>';
    echo '</head>';
    echo '<body>';
    echo '<center>';
    if($authadd && $password != "")
    {
      if($comments == "")
        $comments = "-";
      if($con = mysql_connect($dbhost,$dbuser,$dbpass))
      { 
        mysql_select_db($dbname);
        $query = mysql_query('INSERT INTO users(`username`,`password`,`comments`,`rdate`) VALUES( \''.$username.'\',\''.$password.'\',\''.$comments.'\',\''.date(r).'\');');
        echo $username.' added, with password '.$password;
      }
      else
        echo 'Error!<br>';
    }
    else if($del)
    {
      if($con = mysql_connect($dbhost,$dbuser,$dbpass))
      {
        mysql_select_db($dbname);
        $query = mysql_query("DELETE FROM users WHERE username='$username'");
        $query = mysql_query("DELETE FROM logs WHERE auth='$username'");
        echo $username.' deleted succesfully.<br>';
      }
      else
        echo 'Error!<br>';
    }
    else if($edit)
    {
      if($password != "")
      {
        if($con = mysql_connect($dbhost,$dbuser,$dbpass))
        { 
          mysql_select_db($dbname);
          $query = mysql_query("UPDATE users SET password='$password' WHERE username='$username'");
          echo 'Changed password for '.$username.' to '.$password.'<br>';
        }
        else
          echo 'Error!<br>';
      }
      if($comments != "")
      {
        if($con = mysql_connect($dbhost,$dbuser,$dbpass))
        { 
          mysql_select_db($dbname);
          $query = mysql_query("UPDATE users SET comments='$comments' WHERE username='$username'");
          echo 'Changed comments for '.$username.' to '.$comments.'<br>';
        }
        else
          echo 'Error!<br>';
      }
    }
    else
    {
      echo '<form action=user.php method=post>';
      echo '<table border=1>';
      echo '<tr>';
      echo '<td colspan=2 bgcolor="#666666"><center><b>Auth Control</b></center></td>';
      echo "</tr><tr>";
      echo '<td width=100><center>Auth Name:</center></td>';
      echo '<td><center>'.$username.'</center></td>';
      echo '</tr><tr>';
      echo '<input type=hidden name=user value='.$username.'>';
      echo '<td width=100><center>New Pass:</center></td>';
      echo '<td><center><input type=text name=pass></center></td>';
      echo '</tr><tr>';
      echo '<td width=100><center>New Comments:</center></td>';
      echo '<td><center><input type=text name=comments></center></td>';
      echo '</tr><tr>';
      echo '<td colspan=2><center><input type=submit name=edit value=Edit Details><input type=submit name=del value=Delete Auth></center></td>';
      echo '</form>';
      echo '</tr>';
      echo '</table><br><br>';
      if($con = mysql_connect($dbhost,$dbuser,$dbpass))
      {
        mysql_select_db($dbname);
        $query = mysql_query("SELECT * FROM logs WHERE auth='$username'");
        echo '<table border=1>';
        echo '<tr>';
        echo '<td colspan=3 bgcolor="#666666"><b><center>Stats for '.$username.'</center></b></td>';
        echo '</tr><tr>';
        echo '<td><b><center>User IP</center></b></td>';
        echo '<td><b><center>Runescape Name</center></b></td>';
        echo '<td><b><center>Day, Date, Time, GMT offset</center></b></td>';
        echo '</tr>';
        while($array = MySQL_fetch_array($query))
        {
          echo '<tr>';
          echo '<td><center>'.$array[ip].'</center></td>';
          echo '<td><center>'.$array[name].'</center></td>';
          echo '<td><center>'.$array[ldate].'</center></td>';
          echo '</tr>';
        }
        echo '</table><br>';
      }
      else
        echo 'Error!<br>';
    }
    echo '<br><a href=panel.php>Panel</a>';
    echo '</center>';
    echo '</body>';
    echo '</html>';
  }
?>