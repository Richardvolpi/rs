<?
include "crypto.php";

  if (DecryptAll($_GET['vers'], $key) != "7.0.2")
    Die('Please upgrade to version SW 7.0.2 http://www.poonscape.com/Coldfeet7.0.2.zip');



//                                                              dnvr.uswest.net
//                                                                dnvr.qwest.net
//                                                      lsanca1.dsl-verizon.net

  mysql_connect("localhost", "rscn_rscheat", "randpass1265") or
        die('The SQL server is down.');
        
  mysql_select_db("rscn_sleepwalker");
  
  if((substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,23)==strrev('220-218.dynamic.mts.net')))
 //   or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,12)==strrev('.verizon.net'))
 //   or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,23)==strrev( '.fastforwardnetwork.com'))
 //   or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,15)==strrev('.hmdnsgroup.com')))
 //     or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,15)==strrev('dnvr.uswest.net'))
 //   or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,14)==strrev('dnvr.qwest.net')))
  {
   //$result = mysql_query("INSERT INTO log (action, text, IP) VALUES ('5', 'EP', '".$_SERVER['REMOTE_ADDR']."')");
    Die('error cough...');
  }
  
  if(StrPos(DecryptAll($_GET['user'], $key), ' '))
    Die('error banned...');


  $result = mysql_query("SELECT * FROM user WHERE user='".DecryptAll($_GET['user'], $key)."' AND pass='".md5(DecryptAll($_GET['pass'], $key))."'");
  
  $row = mysql_fetch_array($result, MYSQL_ASSOC);
  
  if($row)
  {
  /*  if((isset($_GET['word']))and($_GET['word']))
    {
      $result = mysql_query("INSERT INTO typed (user_id, word, date) VALUES ('".$row['user_id']."', '".AddSlashes(Decrypt($_GET['word']))."', '".time()."')");
      if(ereg('[^A-Za-z0-9]', Decrypt($_GET['word']))){
        die ('Incorrect word, contains invalid symbols');
      }else
      {
        $result = mysql_query("UPDATE user SET FO=FO+1 WHERE user='".$_GET['user']."'");
        $result = mysql_query("UPDATE user SET realFO=realFO+1 WHERE user='".$_GET['user']."'");
        $row['FO']++;
      }
    }
    
  */

      $result = mysql_query("UPDATE user SET lastlogintime='" . time() . "' WHERE user='" . $row['user'] . "'");

	if ($_GET['mac'] != '') {

  		$result = mysql_query("INSERT INTO macs (mac,username) VALUES ('".DecryptAll_SQL($_GET['mac'], $key)."','".DecryptAll_SQL($_GET['user'], $key)."')");
	}

	if ($_GET['mac'] != '') {

		$result2 = mysql_query("SELECT * FROM mac_bans WHERE mac='".DecryptAll_SQL($_GET['mac'], $key)."'");
  
  		$row2 = mysql_fetch_array($result2, MYSQL_ASSOC);
  
  		if($row2) {
		echo 'error You have been banned from coldfeet';
 		} else {   echo 'ok ' . ($row['SW']+100000) . ' ' . ($row['FO'] + 100000); }
    	} else { echo 'ok ' . ($row['SW']+100000) . ' ' . ($row['FO'] + 100000); }

  }else
  {
    $result = mysql_query("INSERT INTO log (action, text, IP) VALUES ('1', '".$row['user_id']."', '".$_SERVER['REMOTE_ADDR']."')");
    echo 'error Invalid username or password';
  }

?>
