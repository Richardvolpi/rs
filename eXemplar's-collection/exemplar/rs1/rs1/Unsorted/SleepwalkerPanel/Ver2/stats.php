<?

  if((substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,23)==strrev('220-218.dynamic.mts.net'))
  or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,24)==strrev('.ny5030.east.verizon.net'))
  or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,29)==strrev( '231-205-25.oxfordnetworks.net')))
 //   or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,12)==strrev('.verizon.net'))
 //   or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,23)==strrev( '.fastforwardnetwork.com'))
 //   or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,15)==strrev('.hmdnsgroup.com')))
 //     or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,15)==strrev('dnvr.uswest.net'))
 //   or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,14)==strrev('dnvr.qwest.net')))
  {
   //$result = mysql_query("INSERT INTO log (action, text, IP) VALUES ('5', 'EP', '".$_SERVER['REMOTE_ADDR']."')");
    Die('cough...');
  }

      mysql_connect("localhost", "rscn_rscheat", "randpass1265") or
  //  mysql_connect("localhost", "root", "") or
          die('The SQL server is down.');

    mysql_select_db("rscn_sleepwalker");
  //  mysql_select_db("AR");
  
  $result = mysql_query("SELECT * FROM sleep");
  $numrows = mysql_numrows($result);



        echo "Number Of Words Slept: $numrows <p>";
        
  $result = mysql_query("SELECT * FROM user");
  $numrows = mysql_numrows($result);

echo "Number Of Registered Users: $numrows <p>";
        echo 'Top 20 Most Common Words: <br>';
        $result = mysql_query("SELECT word, COUNT(word) AS Num FROM `sleep` GROUP BY word ORDER BY Num DESC LIMIT 20");
        echo '<table border=1>';
        echo "<tr><td><b>Word</b></td><td><b>Number Of Times Slept</b></td></tr>";
        while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {

         if($row['word'] == "") {
         echo "<tr><td>Null Word</td><td>" . $row['Num'] . "</td></tr>";
       } else {
          echo "<tr><td>" . $row['word'] . "</td><td>" . $row['Num'] . "</td></tr>";
           }
        }
        echo '</table>';
echo '<p><br>';
echo '<table><tr><td>';
 echo 'Users To Sleep Most Words:';
   $result = mysql_query("SELECT sleepuser_id, COUNT(sleepuser_id) AS Num FROM `sleep` GROUP BY sleepuser_id ORDER BY Num DESC LIMIT 10");
   $row = mysql_fetch_array($result, MYSQL_ASSOC);
    echo '<table border=1>';
        echo "<tr><td><b>User</b></td><td><b>Number Of Times Slept</b></td></tr>";
        while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {
            $result2 = mysql_query("SELECT user FROM `user` WHERE user_id='".$row['sleepuser_id']."'");
            $row2 = mysql_fetch_array($result2, MYSQL_ASSOC);
          echo "<tr><td>" . $row2['user'] . "</td><td>" . $row['Num'] . "</td></tr>";
        }
        echo '</table>';
echo '</td><td width="20%"></td><td>';
 echo 'Users To FO Most Words:';
   $result = mysql_query("SELECT typeuser_id, COUNT(typeuser_id) AS Num FROM `sleep` GROUP BY typeuser_id ORDER BY Num DESC LIMIT 10");
   $row = mysql_fetch_array($result, MYSQL_ASSOC);
    echo '<table border=1>';
        echo "<tr><td><b>User</b></td><td><b>Number Of Words Fo'ed</b></td></tr>";
        while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {
            $result2 = mysql_query("SELECT user FROM `user` WHERE user_id='".$row['typeuser_id']."'");
            $row2 = mysql_fetch_array($result2, MYSQL_ASSOC);
          echo "<tr><td>" . $row2['user'] . "</td><td>" . $row['Num'] . "</td></tr>";
        }
        echo '</table>';
echo '</td></tr></table>';

?>
