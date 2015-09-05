<?


  if((substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,23)==strrev('220-218.dynamic.mts.net'))
  or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,24)==strrev('.ny5030.east.verizon.net'))
  or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,29)==strrev( '231-205-25.oxfordnetworks.net')))
  {
   //$result = mysql_query("INSERT INTO log (action, text, IP) VALUES ('5', 'EP', '".$_SERVER['REMOTE_ADDR']."')");
    Die('cough...');
  }


  session_start();
  if(isset($_GET['login']))
  {
    $_SESSION['username'] = $_POST['username'];
    $_SESSION['pass'] = md5($_POST['pass']);
    Header('Location: panel.php');
  }
  
  if(isset($_GET['logout']))
  {
    unset($_SESSION['username']);
  }
  if(!isset($_SESSION['username']))
  {
    echo '<form action="?login=1" method="POST">
          User: <input type="text" name="username"><br>
          Pass: <input type="password" name="pass"><br>
          <input type="submit" name="submit" value="Log In">
          </form>
          <a href="http://www.rscheatnet.com/sw/users.php">Create account</a><br>
          <a href="http://www.rscheatnet.com/sw/top.php">Top Typers</a><br>
          <a href="http://www.poonscape.com/Coldfeet7.0.zip">Download</a><br>
          <br>
          ';
  }else
  {


    mysql_connect("localhost", "rscn_rscheat", "randpass1265") or
  //  mysql_connect("localhost", "root", "") or
          die('The SQL server is down.');

    mysql_select_db("rscn_sleepwalker");
  //  mysql_select_db("AR");
        $result = mysql_query("SELECT * FROM user WHERE user='".$_SESSION['username']."' AND  pass='".$_SESSION['pass']."'");
    $loggedrow = mysql_fetch_array($result, MYSQL_ASSOC);
    
    if(!$loggedrow)
    {
      unset($_SESSION['username']);
      die('Invalid username or password');
    }
    
    echo '<a href="?logout=1">Log out</a><br><br>';
    if(!$loggedrow['isadmin'])
{
      if(isset($_POST['action']))
      {
        if($_POST['action'] == 'changepass')
        {
          if(md5($_POST['password'])!=$loggedrow['pass'])
          {
            echo 'Incorrect password!<br><br>';

          }
        else if($_POST['password1']!=$_POST['password2'])
          {
            echo 'Passwords don\'t match!<br><br>';
          }else
          {
		$result = mysql_query("SELECT * FROM user WHERE user='" . $_SESSION['username'] . "'");

		$row = mysql_fetch_array($result, MYSQL_ASSOC);

		if ($row) {
				if (time() - $row['lastsleeptime'] <= 1500) {
					die("You have slept within the last 25 minutes, your password cannot be changed");
					}
				if (time() - $row['lastlogintime'] <= 21600) {
					die("You have logged into SW within the last 6 hours, your password cannot be changed");
					}
				if (time() - $row['lastpasschange'] <= 604800) {
					die("You have already changed your pass this week, you cannot change it again");
					}
				}
            $result = mysql_query("UPDATE user SET pass='" . md5($_POST['password1']) . "',lastpasschange='" . time() . "' WHERE user='".$_SESSION['username']."' AND  pass='".$_SESSION['pass']."'");
            echo 'Password changed successfully!<br><br>';
          }
        }
      }

      echo "Hello.<br>";
      echo "You are logged in as <b>" . $loggedrow['user'] . "</b><br>";
      echo "Words typed (FO count): <b>" . $loggedrow['FO'] . "</b><br>";
      echo "Words sleepwalked (SW count): <b>" . $loggedrow['SW'] . "</b><br>";
      
      echo '<br>Change password<br>
            <form action="" method="POST">
            <input type="hidden" name="action" value="changepass">
            Old password: <input name="password" type="password"><br>
            New password: <input name="password1" type="password"><br>
            Repeat new password: <input name="password2" type="password"><br>
            <input type="submit" name="submit" value="Update">
            </form>';

    }else
    {
echo '<a href="panel.php?order=FO">Order by FO</a><br>';
echo '<a href="panel.php?order=SW">Order by SW</a><br>';
echo '<a href="panel.php">Order normally</a><br>';
echo '<a href="panel.php?view=flags">View Flagged Users</a><br><br>';
//      session_start();
      if(isset($_GET['page']))
        $_SESSION['page'] = $_GET['page'];



if($_GET['view'] == "flags")
        {
 echo '<table>';
          $result = mysql_query("SELECT * FROM flagged");
          //$userrow = mysql_fetch_array($result, MYSQL_ASSOC);
          echo "<tr><td><b>SW User ID</b></td><td><b>FO User ID</b></td><td><b>SW User</b></td> <td><b>FO User</b></td><td><b>Flag Type</b></td><td><b>Cause</b></td><td><b>IP</b></td><td></td><td></td></tr>";
    
    while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {
           if($row['flag_type'] == "red") {  $col = '#E36666';
           
          echo "<tr><td bgcolor=\"$col\">" . $row['sw_id'] . "</td><td bgcolor=\"$col\">" . $row['fo_id'] . "</td><td bgcolor=\"$col\">" . $row['sw_name'] . "</td> <td bgcolor=\"$col\">" . $row['fo_name'] . "</td> <td bgcolor=\"$col\">" . $row['flag_type'] . "</td> <td bgcolor=\"$col\">" . $row['cause'] . "</td> <td bgcolor=\"$col\">" . $row['ip'] . "</td> <td bgcolor=\"$col\">"
             .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="viewuser">
               <input type="hidden" name="id" value="'.$row['sw_id'].'">
               <input type="submit" name="subm" value="View SW">
               </form>'
               ."</td><td bgcolor=\"$col\">"
               .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="viewuser">
               <input type="hidden" name="id" value="'.$row['fo_id'].'">
               <input type="submit" name="subm" value="View FO">
               </form>'
               ."</td><td bgcolor=\"$col\">"
             .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="deluser">
               <input type="hidden" name="id" value="'.$row['sw_id'].'">
               <input type="submit" name="subm" value="Del SW">
               </form>'
                 ."</td><td bgcolor=\"$col\">"
                .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="deluser">
               <input type="hidden" name="id" value="'.$row['fo_id'].'">
               <input type="submit" name="subm" value="Del FO">
               </form>'
                  ."</td><td bgcolor=\"$col\">"
                .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="flogdel">
               <input type="hidden" name="id" value="'.$row['id'].'">
               <input type="submit" name="subm" value="Del Flag">
               </form>'
              ."</td></tr>";
                 }
}
$result = mysql_query("SELECT * FROM flagged");
        while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {
        
           if($row['flag_type'] == "orange") {  $col = '#CD9B9B';
           
          echo "<tr><td bgcolor=\"$col\">" . $row['sw_id'] . "</td><td bgcolor=\"$col\">" . $row['fo_id'] . "</td><td bgcolor=\"$col\">" . $row['sw_name'] . "</td> <td bgcolor=\"$col\">" . $row['fo_name'] . "</td> <td bgcolor=\"$col\">" . $row['flag_type'] . "</td> <td bgcolor=\"$col\">" . $row['cause'] . "</td> <td bgcolor=\"$col\">" . $row['ip'] . "</td> <td bgcolor=\"$col\">"
             .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="viewuser">
               <input type="hidden" name="id" value="'.$row['sw_id'].'">
               <input type="submit" name="subm" value="View SW">
               </form>'
               ."</td><td bgcolor=\"$col\">"
               .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="viewuser">
               <input type="hidden" name="id" value="'.$row['fo_id'].'">
               <input type="submit" name="subm" value="View FO">
               </form>'
               ."</td><td bgcolor=\"$col\">"
             .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="deluser">
               <input type="hidden" name="id" value="'.$row['sw_id'].'">
               <input type="submit" name="subm" value="Del SW">
               </form>'
                 ."</td><td bgcolor=\"$col\">"
                .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="deluser">
               <input type="hidden" name="id" value="'.$row['fo_id'].'">
               <input type="submit" name="subm" value="Del FO">
               </form>'
                   ."</td><td bgcolor=\"$col\">"
                .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="flogdel">
               <input type="hidden" name="id" value="'.$row['id'].'">
               <input type="submit" name="subm" value="Del Flag">
               </form>'
              ."</td></tr>";
                 }
}
$result = mysql_query("SELECT * FROM flagged");
 while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {
           if($row['flag_type'] == "yellow") {  $col = '#EEE685';
           
          echo "<tr><td bgcolor=\"$col\">" . $row['sw_id'] . "</td><td bgcolor=\"$col\">" . $row['fo_id'] . "</td><td bgcolor=\"$col\">" . $row['sw_name'] . "</td> <td bgcolor=\"$col\">" . $row['fo_name'] . "</td> <td bgcolor=\"$col\">" . $row['flag_type'] . "</td> <td bgcolor=\"$col\">" . $row['cause'] . "</td> <td bgcolor=\"$col\">" . $row['ip'] . "</td> <td bgcolor=\"$col\">"
             .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="viewuser">
               <input type="hidden" name="id" value="'.$row['sw_id'].'">
               <input type="submit" name="subm" value="View SW">
               </form>'
               ."</td><td bgcolor=\"$col\">"
               .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="viewuser">
               <input type="hidden" name="id" value="'.$row['fo_id'].'">
               <input type="submit" name="subm" value="View FO">
               </form>'
                 ."</td><td bgcolor=\"$col\">"
             .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="deluser">
               <input type="hidden" name="id" value="'.$row['sw_id'].'">
               <input type="submit" name="subm" value="Del SW">
               </form>'
                 ."</td><td bgcolor=\"$col\">"
                .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="deluser">
               <input type="hidden" name="id" value="'.$row['fo_id'].'">
               <input type="submit" name="subm" value="Del FO">
               </form>'
               ."</td><td bgcolor=\"$col\">"
               .'<form action="panel.php" method="POST">
               <input type="hidden" name="action" value="flogdel">
               <input type="hidden" name="id" value="'.$row['id'].'">
               <input type="submit" name="subm" value="Del Flag">
               </form>'
                 ."</td></tr>";
                 }
}

       echo '</table><p><br>';

 echo '
                <form action="panel.php" method="POST">
                <input type="hidden" name="action" value="delflags_sw">
                Del All Flags from SW User:<input name="id"><br>
                <input type="submit" name="subm" value="Del Flags">
<br>';

 echo '
                <form action="panel.php" method="POST">
                <input type="hidden" name="action" value="delflags_fo">
                Del All Flags from FO User:<input name="id"><br>
                <input type="submit" name="subm" value="Del Flags">
<p>';

echo '<br><a href="panel.php">back</a><hr>';
echo '</body></html>';  
die();      
} 

      if(isset($_POST['action']))
      {
        echo '<a href="panel.php">back</a><br>';

        if($_POST['action'] == 'changeuser')
        {
          if((isset($_POST['isadmin']))and($_POST['isadmin']))
          {
            $adm = 1;
          }else
          {
            $adm = 0;
          }
          $result = mysql_query("UPDATE user SET
                              user = '".$_POST['username']."',
                              email = '".$_POST['email']."',
                              message = '".$_POST['message']."',
                              SW = '".$_POST['SW']."',
                              FO = '".$_POST['FO']."',
                              isadmin = '".$adm."'
                              WHERE user_id = '".$_POST['id']."'");
          if($_POST['password'])
          {
            $result = mysql_query("UPDATE user SET
                              pass = '".md5($_POST['password'])."'
                              WHERE user_id = '".$_POST['id']."'");
            echo "Password changed<br>";
          }
          if($result) echo "User updated<br>";
          else        echo "Failed to update user: " . mysql_error() . "<br>";
        }
        if($_POST['action'] == 'deluser')
        {
          $result = mysql_query("DELETE FROM user WHERE user_id='".$_POST['id']."'");
          echo "User deleted";
        }
        if($_POST['action'] == 'delflags_sw')
        {
          $result = mysql_query("DELETE FROM flagged WHERE sw_name='".$_POST['id']."'");
          echo "Flags deleted";
        }
        if($_POST['action'] == 'delflags_fo')
        {
          $result = mysql_query("DELETE FROM flagged WHERE fo_name='".$_POST['id']."'");
          echo "Flags deleted";
        }
        if($_POST['action'] == 'flogdel')
        {
          $result = mysql_query("DELETE FROM flagged WHERE id='".$_POST['id']."'");
          echo "Record deleted<br>";
        }

        if($_POST['action'] == 'macsearch')
        {
        $result = mysql_query("SELECT * FROM macs WHERE username LIKE '%".$_POST['macname']."%'");
        echo '<table border="1">';
        echo "<tr><td><b>User</b></td><td><b>MAC</b></td><td>Action</td></tr>";
        while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {
          echo "<tr><td>" . $row['username'] . "</td><td>" . $row['mac'] . "</td><td><form name=\"macyban\" action=\"\" method=\"POST\"> <input type=\"hidden\" name=\"action\" value=\"macban\">
<input type=\"hidden\" name=\"macaddress\" value=\"".$row['mac']."\">             
 <input type=\"submit\" name=\"submac\" value=\"Ban Address\">
              </form></td></tr>";
         }
        echo '</table>';
        }
 
        if($_POST['action'] == 'macban')
        {
        $result = mysql_query("INSERT INTO mac_bans(mac) VALUES('".$_POST['macaddress']."')");
 	  echo "Address Banned";
        }

        if($_POST['action'] == 'viewuser')
        {
          $result = mysql_query("SELECT * FROM user WHERE user_id='".$_POST['id']."'");
          $userrow = mysql_fetch_array($result, MYSQL_ASSOC);
          echo '
                <form action="" method="POST">
                <table>
                <input type="hidden" name="action" value="changeuser">
                <input type="hidden" name="id" value="'.$userrow['user_id'].'">
                <tr><td>Username:</td><td><input name="username" value="'.$userrow['user'].'"></td></tr>
                <tr><td>Password:</td><td><input name="password" value=""></td></tr>
                <tr><td>E-mail:</td><td><input name="email" value="'.$userrow['email'].'"></td></tr>
                <tr><td>Message:</td><td><input name="message" value="'.$userrow['message'].'"></td></tr>
                <tr><td>SW:</td><td><input name="SW" value="'.$userrow['SW'].'"></td></tr>
                <tr><td>FO:</td><td><input name="FO" value="'.$userrow['FO'].'"></td></tr>
                <tr><td>Is Admin:</td><td><input type="checkbox" name="isadmin"';
          if($userrow['isadmin']) echo ' checked="checked"';
          echo  '></td></tr>
                <tr><td colspan="2" align="center"><input type="submit" name="submit" value="Update"></td><td></td></tr>
                </table>
                </form>';
          echo '<br><table width=100%><tr><td width=50% valign=top>';
          echo 'Last words typed: <br>';
          $result = mysql_query("SELECT sleep_id, B.user AS sleeper, word, FROM_UNIXTIME(time) AS date FROM sleep LEFT JOIN user AS B ON B.user_id=sleepuser_id WHERE typeuser_id='".$_POST['id']."' ORDER BY date DESC LIMIT 100");
          echo '<table border="1" cellspacing="0">';
          echo '<tr><td><b>Sleeper</b></td><td><b>Word</b></td><td><b>Date</b></td></tr>';
          while($row = mysql_fetch_array($result, MYSQL_ASSOC))
          {
            echo '<tr><td>'.$row['sleeper'].'</td><td>'.$row['word'].'</td><td>'.$row['date'].'</td></tr>';
          }
          echo '</table></td><td width=50% valign=top>';
          echo 'Last words slept: <br>';
          $result = mysql_query("SELECT sleep_id, B.user AS typer, word, FROM_UNIXTIME(time) AS date FROM sleep LEFT JOIN user AS B ON B.user_id=typeuser_id WHERE sleepuser_id='".$_POST['id']."' ORDER BY date DESC LIMIT 100");
          echo '<table border="1" cellspacing="0">';
          echo '<tr><td><b>Typer</b></td><td><b>Word</b></td><td><b>Date</b></td></tr>';
          while($row = mysql_fetch_array($result, MYSQL_ASSOC))
          {
            echo '<tr><td>'.$row['typer'].'</td><td>'.$row['word'].'</td><td>'.$row['date'].'</td></tr>';
          }
          echo '</td></tr></table>';
        }
        echo '<br><a href="panel.php">back</a>';
        echo '<br><a href="panel.php?view=flags">View Flags</a>';
       
      }else
      {
	  $ORDER = $_GET['order'];
        $searchquery = '(1=1)';
        if($_GET['searchname'])
        {
          $searchquery .= " AND user LIKE '%".$_GET['searchname']."%'";
        }
        $result = mysql_query("SELECT Count(1) AS c FROM user WHERE $searchquery");
        $row = mysql_fetch_array($result, MYSQL_ASSOC);
        $c = $row['c'];
        $pagelen = 20;

        $firstrow = $_SESSION['page'] * $pagelen;
        if($firstrow > $c)
        {
          $firstrow = 1;
        }

        if($_SESSION['page'] == 'nopages')
        {
          $result = mysql_query("SELECT * FROM user WHERE $searchquery");
        }
       else if ($ORDER == "") {
          $result = mysql_query("SELECT * FROM user WHERE $searchquery LIMIT $firstrow,$pagelen");
        }
      else if ($ORDER == "FO") {
          $result = mysql_query("SELECT * FROM user WHERE $searchquery ORDER By FO LIMIT $firstrow,$pagelen");
        }
        else if ($ORDER == "SW") {
        $result = mysql_query("SELECT * FROM user WHERE $searchquery ORDER By SW LIMIT $firstrow,$pagelen");
        }

        $county = 0;
        echo '<table>';
        echo "<tr><td><b>User</b></td><td><b>FO</b></td><td><b>SW</b></td><td><b>Message</b></td><td></td><td></td></tr>";
        while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {
          $col = '#CBD2DA';
          if($row['SW'] > $row['FO'])
            $col = '#AA98B1';
          if(!(strpos($row['user'], ' ') === false))
            $col = '#E36666';
          echo "<tr><td bgcolor=\"$col\">" . $row['user'] . "</td><td bgcolor=\"$col\">" . $row['FO'] . "</td><td bgcolor=\"$col\">" . $row['SW'] . "</td><td bgcolor=\"$col\">" . $row['message'] . "</td><td bgcolor=\"$col\">"
             .'<form action="" method="POST">
               <input type="hidden" name="action" value="viewuser">
               <input type="hidden" name="id" value="'.$row['user_id'].'">
               <input type="submit" name="subm" value="View">
               </form>'
               ."</td><td bgcolor=\"$col\">"
             .'<form action="" method="POST" name="DELFORM'.$row['user_id'].'">
               <input type="hidden" name="action" value="deluser">
               <input type="hidden" name="id" value="'.$row['user_id'].'">
               <input type="button" name="subm" value="Del" OnClick="if (!confirm(\'Really delete it?\')) return; window.document.DELFORM'.$row['user_id'].'.submit();">
               </form>'
                       ."</td></tr>";
         }
        echo '</table>';
        for($f=1;$f-1<=$c/$pagelen;$f++)
        {
          if($f-1 == $_SESSION['page'])
            echo '<b>'.$f.'</b> ';
          else
            echo '<a href="?order='.$ORDER.'&page='.($f-1).'">'.$f.'</a> ';
        }
        echo '<a href="?page=nopages">All</a> ';
        echo '<br><br>
              <form name="searchform" action="" method="GET">
              Search for user: <input name="searchname"><input type="submit" name="subm" value="Search">
              </form> <hr>';
       echo '<br> <form name="searchmac" action="" method="POST"><input type="hidden" name="action" value="macsearch">
              Search for user: <input name="macname"><input type="submit" name="submac" value="Get Mac Address">
              </form> ';
      }
    }
  }

?>
