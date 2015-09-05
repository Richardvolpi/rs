<?

//for checking FO cheaters
mysql_connect("localhost", "rscheat_mediator", "adpass123") or
  //  mysql_connect("localhost", "root", "") or
          die('The SQL server is down.');

    mysql_select_db("rscheat_sleepwalker");
  //  mysql_select_db("AR");


  $result = mysql_query("SELECT * FROM user WHERE fo>10");


        while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {
          //select equal words
          $result2 = mysql_query("SELECT time AS date, word, count(*) AS c FROM sleep WHERE typeuser_id='".$row['user_id']."' GROUP BY date ORDER BY c DESC");
          // $result2 =  mysql_query("SELECT word, date FROM typed WHERE  user_id='".$row['user_id']."'");
           while($row2 = mysql_fetch_array($result2, MYSQL_ASSOC))
           {
             if($row2['c'] > 2)
             {
               $result3 = mysql_query("SELECT time AS date, word FROM sleep WHERE typeuser_id='".$row['user_id']."' AND date='".$row2['date']."' LIMIT 5");
               while($row3 = mysql_fetch_array($result3, MYSQL_ASSOC))
               {
                 //echo "<b>".$row2['date']."</b> <b>".$row['user']."</b>: Word <b>".$row2['word']."</b> repeated <b>".$row2['c']."</b> times.<br>";
                 echo "<b>".$row3['date']."</b> <b>".$row['user']."</b>: Word <b>".$row3['word']."</b>.<br>";
               }
             }
           }

//          $row['user'] $row['FO']  $row['SW']  $row['message'] $row['user_id']
        }


?>
