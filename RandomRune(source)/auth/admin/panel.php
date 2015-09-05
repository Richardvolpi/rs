<?php
  include("../config.php");
  echo '<html>';
  echo '<head>';
  echo '<title>Admin Panel</title>';
  echo '</head>';
  echo '<body>';
  echo '<center>';
  echo '<form action=user.php method=post>';
  echo '<table border=1>';
  echo '<tr>';
  echo '<td colspan=2 bgcolor="#666666"><center><b>Auth Control</b></center></td>';
  echo "</tr><tr>";
  echo '<td width=100><center>Name:</center></td>';
  echo '<td><center><input type=text name=user></center></td>';
  echo '</tr><tr>';
  echo '<td width=100><center>Pass:</center></td>';
  echo '<td><center><input type=text name=pass></center></td>';
  echo '</tr><tr>';
  echo '<td width=100><center>Comments:</center></td>';
  echo '<td><center><input type=text name=comments></center></td>';
  echo '</tr><tr>';
  echo '<td colspan=2><center><input type=submit name=authadd value=Add auth></center></td>';
  echo '</form>';
  echo '</tr>';
  echo '</table><br><br>';
  if($con = mysql_connect($dbhost,$dbuser,$dbpass))
  {
    mysql_select_db($dbname);
    $query = mysql_query('SELECT * FROM users');
    echo '<table border=1>';
    echo '<tr>';
    echo '<td colspan=4 bgcolor="#666666"><b><center>Current users</center></b></td>';
    echo '</tr><tr>';
    echo '<td><b><center>Auth Name</center></b></td>';
    echo '<td><b><center>Auth Pass</center></b></td>';
    echo '<td><b><center>Day, Date, Time, GMT offset</center></b></td>';
    echo '<td width=400><b><center>Comments</center></b></td>';
    echo '</tr>';
    while($array = MySQL_fetch_array($query))
    {
      echo '<tr>';
      echo '<td><center><a href=user.php?user='.$array[username].'>'.$array[username].'</a></center></td>';
      echo '<td><center>'.$array[password].'</center></td>';
      echo '<td><center>'.$array[rdate].'</center></td>';
      echo '<td><center>'.$array[comments].'</center></td>';
      echo '</tr>';
    }
    echo '</table>';
  }
  else
    echo 'Error!' ;
  echo "<br>";
  echo '</center>';
  echo '</body>';
  echo '</html>';
?>