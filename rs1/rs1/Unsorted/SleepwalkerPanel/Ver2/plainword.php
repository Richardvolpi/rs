<?


//                                                              dnvr.uswest.net


  mysql_connect("localhost", "rscheat_mediator", "adpass123") or
        die('The SQL server is down.');

  mysql_select_db("rscheat_sleepwalker");



  $result = mysql_query("SELECT * FROM user WHERE user='".$_GET['user']."'");

  $row = mysql_fetch_array($result, MYSQL_ASSOC);

  if($row)
  {
    echo '[SERVER] SW: ' . ($row['SW']) . ', FO: ' . ($row['FO']);
    //get last few words
    $result = mysql_query("SELECT word, B.user AS sleeper FROM sleep LEFT JOIN user AS B ON B.user_id=sleepuser_id WHERE typeuser_id='".$row['user_id']."' ORDER BY time DESC LIMIT 10");
    echo mysql_error();
    echo ' (';
    while($r2 = mysql_fetch_array($result, MYSQL_ASSOC))
    {
      echo $r2['word'] . ':'.$r2['sleeper'].' ';
    }
    echo ')';
    

  }else
  {
    $result = mysql_query("INSERT INTO log (action, text, IP) VALUES ('1', '".$row['user_id']."', '".$_SERVER['REMOTE_ADDR']."')");
    echo 'Invalid username '.$_GET['user'];
  }

?>
