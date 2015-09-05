<?
  $id = $_GET['id']+0;
  mysql_connect("localhost", "mediator_rscheat", "adpass123") or
  //  mysql_connect("localhost", "root", "") or
          die('The SQL server is down.');

    mysql_select_db("mediator_sleepwalker");
  //  mysql_select_db("AR");
  
  $result = mysql_query("SELECT * FROM sleep WHERE sleepuser_id='$id'");
  
  while($row = mysql_fetch_array($result, MYSQL_ASSOC))
  {
    mysql_Query("UPDATE user SET FO=FO-1, realFO=realFO-1 WHERE user_id='".$row['typeuser_id']."'");
    mysql_Query("DELETE FROM sleep WHERE sleep_id='".$row['sleep_id']."'");
//    echo "a";
  }
  echo "Finished!";
  
  
?>
