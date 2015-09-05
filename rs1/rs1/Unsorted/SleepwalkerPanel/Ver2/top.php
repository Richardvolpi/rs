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
  
  $result = mysql_query("SELECT user, SW, FO, realFO, realSW FROM user ORDER BY realFO DESC, realSW DESC LIMIT 20");

        echo '<table>';
        echo "<tr><td><b>User</b></td><td><b>FO</b></td><td><b>SW</b></td><td><b>realFO</b></td><td><b>realSW</b></td></tr>";
        while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {
          $col = '#CBD2DA';
          if($row['SW'] > $row['FO'])
            $col = '#AA98B1';
          if(!(strpos($row['user'], ' ') === false))
            $col = '#E36666';
          echo "<tr><td bgcolor=\"$col\">" . $row['user'] . "</td><td bgcolor=\"$col\">" . $row['FO'] . "</td><td bgcolor=\"$col\">" . $row['SW'] . "</td><td bgcolor=\"$col\">" . $row['realFO'] . "</td><td bgcolor=\"$col\">" . $row['realSW'] . "</td></tr>";
        }
        echo '</table>';



echo '<br><p><br>';

echo 'Monthly Highest FO Counts:';
echo '<br>';
 $result = mysql_query("SELECT user, TempFO FROM user ORDER BY TempFO DESC LIMIT 20");

        echo '<table>';
        echo "<tr><td><b>User</b></td><td><b>FO</b></td></tr>";
        while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {
          $col = '#CBD2DA';
          if($row['SW'] > $row['FO'])
            $col = '#AA98B1';
          if(!(strpos($row['user'], ' ') === false))
            $col = '#E36666';
          echo "<tr><td bgcolor=\"$col\">" . $row['user'] . "</td><td bgcolor=\"$col\">" . $row['TempFO'] . "</td></tr>";
        }
        echo '</table>';



?>
