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
include 'header.php';
    echo '<form action="?login=1" method="POST">
          User: <input type="text" name="username"><br>
          Pass: <input type="password" name="pass"><br>
          <input type="submit" name="submit" value="Log In">
          </form>
          ';
include 'footer.php';
  }else
  {


    mysql_connect("localhost", "rscn_rscheat", "randpass1265") or
  //  mysql_connect("localhost", "root", "") or
          die('The SQL server is down.');

    mysql_select_db("rscn_sleepocr");
  //  mysql_select_db("AR");
        $result = mysql_query("SELECT * FROM user WHERE user='".$_SESSION['username']."' AND  pass='".$_SESSION['pass']."'");
    $loggedrow = mysql_fetch_array($result, MYSQL_ASSOC);
    
    if(!$loggedrow)
    {
      unset($_SESSION['username']);
      die('Invalid username or password');
    }
    

    if(!$loggedrow['isadmin'])
{
include 'header.php';
    echo '<a href="?logout=1">Log out</a><br><br>';
      echo "Hello.<br>";
      echo "You are logged in as <b>" . $loggedrow['user'] . "</b><br>";
      echo "Words Owned : <b>" . $loggedrow['allowed'] . "</b><br>";
      echo "Words sleepwalked (SW count): <b>" . $loggedrow['slept'] . "</b><br>";
      
      include 'footer.php';
    }else
    {
    echo '<a href="?logout=1">Log out</a><br><br>';
echo '<a href="panel.php?order=allowed">Order by words Owned</a><br>';
echo '<a href="panel.php?order=slept">Order by SW</a><br>';
echo '<a href="panel.php?order=mac">Order by most different MAC addresses</a><br>';
echo '<a href="panel.php">Order normally</a><br>';
//      session_start();
      if(isset($_GET['page']))
        $_SESSION['page'] = $_GET['page'];

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
                              Slept = '".$_POST['slept']."',
                              Allowed = '".$_POST['allowed']."',
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
                <tr><td>Slept:</td><td><input name="slept" value="'.$userrow['slept'].'"></td></tr>
                <tr><td>Allowed:</td><td><input name="allowed" value="'.$userrow['allowed'].'"></td></tr>
                <tr><td>Is Admin:</td><td><input type="checkbox" name="isadmin"';
          if($userrow['isadmin']) echo ' checked="checked"';
          
	echo  '></td></tr>
                <tr><td colspan="2" align="center"><input type="submit" name="submit" value="Update"></td><td></td></tr>
                </table>
                </form>';
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
      else if ($ORDER == "slept") {
          $result = mysql_query("SELECT * FROM user WHERE $searchquery ORDER By slept LIMIT $firstrow,$pagelen");
        }
        else if ($ORDER == "allowed") {
        $result = mysql_query("SELECT * FROM user WHERE $searchquery ORDER By allowed LIMIT $firstrow,$pagelen");
        }
        else if ($ORDER == "mac") {
        $result = mysql_query("SELECT *, Count(Distinct macs.mac) as mcount FROM macs, user WHERE $searchquery AND user.user=macs.username GROUP By macs.username ORDER By mcount DESC LIMIT $firstrow,$pagelen");

	}

        $county = 0;
        echo '<table>';
        echo "<tr><td><b>User</b></td><td><b>Slept</b></td><td><b>Allowed</b></td><td><b>Message</b></td><td></td><td></td></tr>";
        while($row = mysql_fetch_array($result, MYSQL_ASSOC))
        {
          $col = '#CBD2DA';
          if($row['slept'] > $row['allowed'])
            $col = '#AA98B1';
          if(!(strpos($row['user'], ' ') === false))
            $col = '#E36666';
          echo "<tr><td bgcolor=\"$col\">" . $row['user'] . "</td><td bgcolor=\"$col\">" . $row['slept'] . "</td><td bgcolor=\"$col\">" . $row['allowed'] . "</td><td bgcolor=\"$col\">" . $row['message'] . "</td><td bgcolor=\"$col\">"
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
include 'footer.php';
?>
