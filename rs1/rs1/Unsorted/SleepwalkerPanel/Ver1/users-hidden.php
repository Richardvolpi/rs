<?
session_start();
  if((substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,23)==strrev('220-218.dynamic.mts.net'))
  or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,24)==strrev('.ny5030.east.verizon.net'))
  or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,29)==strrev( '231-205-25.oxfordnetworks.net')))
 //   or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,15)==strrev('.hmdnsgroup.com')))
 //     or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,15)==strrev('dnvr.uswest.net'))
 //   or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,14)==strrev('dnvr.qwest.net')))
  {
   //$result = mysql_query("INSERT INTO log (action, text, IP) VALUES ('5', 'EP', '".$_SERVER['REMOTE_ADDR']."')");
    Die('cough...');
  }

 if(!(isset($_GET['banned'])) && (!isset($_GET['getbanned']))) {
	include 'header.php';


  if(isset($_POST['submit']))
  {
    if(($_POST['user'])and($_POST['pass'])and($_POST['email'])and($_POST['comm']))
    {
      if((strpos($_POST['user'], ' ')===false)and(strpos($_POST['pass'], ' ')===false)
        and(strpos($_POST['user'], '_')===false)and(strpos($_POST['user'], '\'')===false)
        and(strpos($_POST['user'], '`')===false))
      {
        //add user to db
        mysql_connect("localhost", "rscn_rscheat", "randpass1265") or
        die('The SQL server is down.');

        mysql_select_db("rscn_sleepocr");


if(isset($_POST['imagetext'])&&strlen($_POST['imagetext'])==7&&isset($_SESSION['text'])&&strtolower($_POST['imagetext'])==$_SESSION['text'])
{

       $result = mysql_query("INSERT INTO user (user, pass, email, message)
                               VALUES ('".$_POST['user']."', '".md5($_POST['pass'])."', '".$_POST['email']."', '".$_POST['comm']."')");
       $result = mysql_query("UPDATE stats SET users=users+1"); 
        $result = mysql_query("INSERT INTO log (action, text, IP) VALUES ('2', '".$_POST['user']."', '".$_SERVER['REMOTE_ADDR']."')");
echo 'User added';
} elseif(isset($_POST['imagetext']))
{
	die('input text doesn\'t match the text on the image');
}
unset($_SESSION['text']);





        



      }else
      {
        echo 'Don\'t use spaces in username and password';
      }
    }else
    {
      echo 'Did you forget to fill any fields?';
    }
  }else
  {



?>
 
  
    Make sure username/password do not contain spaces.<br>
    In comments write who are you in IRC or anywhere, otherwise this user will be removed.<br>
    <form name="Form" action="" method="POST">
    username: <input name="user" size="20" maxlength="40"><br>
    password: <input name="pass" size="20" maxlength="20"><br>
    e-mail: <input name="email" size="20" maxlength="40"><br>
    comments: <input name="comm" size="20" maxlength="200"><br>
    <p>
     copy the text you see in this image into the text box<br>
  <img src=ran.php?<?=SID?>> <br> <input type=text name=imagetext>
    <p>
    <input type="submit" name="submit" value="Create User">
    </form>
    <a href="http://www.rscheatnet.com/sw/panel.php">Log in</a>
    <?php
  }

include 'footer.php';
}
?>
