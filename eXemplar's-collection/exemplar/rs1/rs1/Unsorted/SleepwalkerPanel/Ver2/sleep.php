<?php 
// if(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,23)==strrev('lsanca1.dsl-verizon.net'))
// or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,15)==strrev('dnvr.uswest.net'))
// or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,14)==strrev('dnvr.qwest.net')))
// {
// $result = mysql_query("INSERT INTO log (action, text, IP) VALUES ('5', 'EP', '".$_SERVER['REMOTE_ADDR']."')");
// Die('error cough...');
// }
include "crypto.php";

mysql_connect("localhost", "rscn_rscheat", "randpass1265") or
die('The SQL server is down.');

mysql_select_db("rscn_sleepwalker");

if ((substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))), 0, 23) == strrev('220-218.dynamic.mts.net'))
        or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))), 0, 24) == strrev('.ny5030.east.verizon.net'))
        or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))), 0, 29) == strrev('231-205-25.oxfordnetworks.net'))
        or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))), 0, 13) == strrev('kycm.nebi.com'))) { // or(substr(strrev(strtolower(gethostbyaddr($_SERVER["REMOTE_ADDR"]))),0,15)==strrev('.hmdnsgroup.com')))
    // $result = mysql_query("INSERT INTO log (action, text, IP) VALUES ('5', 'EP', '".$_SERVER['REMOTE_ADDR']."')");
    Die('error cough...');
} 

$result = mysql_query("SELECT * FROM user WHERE user='" . DecryptAll($_GET['user'], $key) . "' AND pass='" . md5(DecryptAll($_GET['pass'], $key)) . "'");

$row = mysql_fetch_array($result, MYSQL_ASSOC);

if ($row) {
    if (isset($_GET['reply'])) {
        $result = mysql_query("SELECT * FROM last_query WHERE sleepuser_id='" . $row['user_id'] . "'");
        $query = mysql_fetch_array($result, MYSQL_ASSOC);

        if ($row['num'] != trim(DecryptAll($GET['reply'], $key))) {
            die('Invalid');
        } else {
            $typerid = $query['typerid'];
            $result = mysql_query("UPDATE user SET FO=FO+1 WHERE user_id='" . $typerid . "'");
            $result = mysql_query("UPDATE user SET TempFO=TempFO+1 WHERE user_id='" . $typerid . "'");
            $result = mysql_query("UPDATE user SET realFO=realFO+1 WHERE user_id='" . $typerid . "'"); 
            // let's increase our own SWcount
        if ((strtolower(DecryptAll_SQL($_GET['user'], $key)) != "lucy") && (strtolower(DecryptAll_SQL($_GET['user'], $key)) != "floto") && (strtolower(DecryptAll_SQL($_GET['user'], $key)) != "simosmells2") && (strtolower(DecryptAll_SQL($_GET['user'], $key)) != "w1r3fr4m3") && (strtolower(DecryptAll_SQL($_GET['user'], $key)) != "brett90") && (strtolower(DecryptAll_SQL($_GET['user'], $key)) != "blessed") && (strtolower(DecryptAll_SQL($_GET['user'], $key)) != "cherry") && (strtolower(DecryptAll_SQL($_GET['user'], $key)) != "JLewis44")) {
            $result = mysql_query("UPDATE user SET lastsleeptime='" . time() . "' WHERE user='" . DecryptAll_SQL($_GET['user'], $key) . "'");
            $result = mysql_query("UPDATE user SET SW=SW+1 WHERE user='" . DecryptAll_SQL($_GET['user'], $key) . "'");
            $result = mysql_query("UPDATE user SET realSW=realSW+1 WHERE user='" . DecryptAll_SQL($_GET['user'], $key) . "'"); 
}           
 // let's update sleep table
            $result = mysql_query("INSERT INTO sleep (sleepuser_id, typeuser_id, word, time, MAC) VALUES ('" . $query['sleepuser_id'] . "', '" . $typerid . "', '" . $query['word'] . "', '" . time() . "', '" . $query['MAC'] . "')");

            $result = mysql_query("DELETE FROM last_query WHERE sleepuser_id='" . $query['sleepuser_id'] . "'");
            die('ok 1');
        } 
    } 
    if (!isset($_GET['reply'])) {
        if (isset($_GET['ex']) && isset($_GET['grip'])) {
            $var1 = (int) (trim(DecryptAll($_GET['ex'], $key)));
            $var2 = (int) (trim(DecryptAll($_GET['grip'], $key)));
            $spread = intval($var1 + $var2);
            $spread = "$spread";
        } else {
            die('Required values missing');
        } 
    } 

    if (isset($_GET['typer'])) {
        $_GET['typer'] = EncryptAll(str_replace("`", "", DecryptAll($_GET['typer'], $key)), $key);
        $result2 = mysql_query("SELECT * FROM user WHERE user='" . DecryptAll($_GET['typer'], $key) . "'");
        $row2 = mysql_fetch_array($result2, MYSQL_ASSOC);
    } else {
        $result = mysql_query("INSERT INTO flagged (sw_id, fo_id, sw_name, fo_name, flag_type, cause, ip) VALUES ('" . $row['user_id'] . "', '000000', '" . DecryptAll_SQL($_GET['user'], $key) . "', 'No Typer', 'yellow', 'Failed to specify valid typer when sleeping', '" . $_SERVER['REMOTE_ADDR'] . "')");

        die('error You didnt specify a typer, red flagged');
    } 
    // die if banned
    if (StrPos(DecryptAll($_GET['user'], $key), ' '))
        Die('error banned...');

    if (StrPos(DecryptAll($_GET['word'], $key), ' ')) {
        $result = mysql_query("INSERT INTO flagged (sw_id, fo_id, sw_name, fo_name, flag_type, cause, ip) VALUES ('" . $row['user_id'] . "', '" . $row2['user_id'] . "', '" . DecryptAll_SQL($_GET['user'], $key) . "', '" . DecryptAll_SQL($_GET['typer'], $key) . "', 'orange', 'Failing to specify sleep word(probable botter)', '" . $_SERVER['REMOTE_ADDR'] . "')");
        Die('error you must have a word');
    } 

    if ($row2['user_id'] == '') {
        $result = mysql_query("INSERT INTO flagged (sw_id, fo_id, sw_name, fo_name, flag_type, cause, ip) VALUES ('" . $row['user_id'] . "', '0', '" . DecryptAll_SQL($_GET['user'], $key) . "', 'Typer Attempted " . DecryptAll_SQL($_GET['typer'], $key) . "', 'yellow', 'Failed to specify valid typer when sleeping', '" . $_SERVER['REMOTE_ADDR'] . "')");
        die('error You didnt specify a valid typer, red flagged');
    } 

    if (!isset($_GET['word'])) {
        $result = mysql_query("INSERT INTO flagged (sw_id, fo_id, sw_name, fo_name, flag_type, cause, ip) VALUES ('" . $row['user_id'] . "', '" . $row2['user_id'] . "', '" . DecryptAll_SQL($_GET['user'], $key) . "', '" . DecryptAll_SQL($_GET['typer'], $key) . "', 'orange', 'Failing to specify sleep word(probable botter)', '" . $_SERVER['REMOTE_ADDR'] . "')");
        Die('error you must have a word');
    } 
    // is sleeps several times in 3 seconds, then die
    if (time() - $row['lastsleeptime'] <= 3) {
        $result = mysql_query("INSERT INTO flagged (sw_id, fo_id, sw_name, fo_name, flag_type, cause, ip) VALUES ('" . $row['user_id'] . "', '" . $row2['user_id'] . "', '" . DecryptAll_SQL($_GET['user'], $key) . "', '" . DecryptAll_SQL($_GET['typer'], $key) . "', 'orange', 'Sending sleep queries to fast(probable botter)', '" . $_SERVER['REMOTE_ADDR'] . "')");

        die('error Not so fast, buddy!');
    } 
    // ok, this little protection does following
    // if someone has over 50 sleepwords and sleepwords > typewords * 3 then
    // user gets autobanned and deleted
    // and if his SW/FO match with realSW/realFO
    if (($row['SW'] == $row['realSW'])and($row['FO'] == $row['realFO'])and
            ($row['SW'] > 50)and($row['SW'] > $row['FO'] * 3)) {
        $result = mysql_query("INSERT INTO log (action, text, IP) VALUES ('6', 'autoban', '" . $_SERVER['REMOTE_ADDR'] . "')");
        mysql_query("UPDATE user SET user=CONCAT(user,' autoban:','" . $row['user_id'] . "') WHERE user_id='" . $row['user_id'] . "'");

        $result = mysql_query("INSERT INTO flagged (sw_id, fo_id, sw_name, fo_name, flag_type, cause, ip) VALUES ('" . $row['user_id'] . "', '" . $row2['user_id'] . "', '" . DecryptAll_SQL($_GET['user'], $key) . "', '" . DecryptAll_SQL($_GET['typer'], $key) . "', 'red', 'Auto Banned For too many SWs', '" . $_SERVER['REMOTE_ADDR'] . "')");
        die("error will you fucking stop this?");
    } 

    if (ereg('[^A-Za-z]', DecryptAll($_GET['word'], $key))) {
        // $result = mysql_query("INSERT INTO cheaters (sleepuser_id, typeuser_id, sleeper, typer, time) VALUES ('".$row['user_id']."', '".$typerid."', '".$_GET['user']."', '".$_GET['typer']."', '".time()."')");
        die ('error Incorrect word, contains invalid symbols');
    } else {
        // if(Decrypt($_GET['word']) == $_GET['ect']) {
        $typerid = 0; 
        // let's try to find the pal who typed this
        $result2 = mysql_query("SELECT * FROM user WHERE user='" . DecryptAll($_GET['typer'], $key) . "'");
        $row2 = mysql_fetch_array($result2, MYSQL_ASSOC);
        if ($row2) {
            $typerid = $row2['user_id'];

            $result = mysql_query("DELETE FROM last_query WHERE sleepuser_id='" . $query['user_id'] . "'");
            $add = rand(2000, 8000);
            $add2 = rand(7943, 9999);
            $sum = $add + $add2;
            $into = ($sum + 392) / 2.34;
            $result = mysql_query("INSERT INTO last_query (sleepuser_id, num, time, typerid, word, MAC) VALUES ('" . $row['user_id'] . "', '" . $into . "', '" . time() . "', '" . $typerid . "', '" . DecryptAll_SQL($_GET['word'], $key) . "', '" . DecryptAll_SQL($_GET['mac'], $key) . "')");
          
            $result3 = mysql_query("SELECT * FROM mac_bans WHERE mac='".DecryptAll_SQL($_GET['mac'], $key)."'");
  
  		$row3 = mysql_fetch_array($result3, MYSQL_ASSOC);
  
  		if($row3) {
		echo 'error You have been banned from coldfeet';
           } else {
          echo 'ok ' . ($row['SW'] + 100001) . ' ' . ($row['FO'] + 100000) . ' jump=' . EncryptAll($add, $key) . ' vice=' . EncryptAll($add2, $key) . ' gadd=' . EncryptAll($sum, $key) . ' return=' . EncryptAll($spread, $key);
		}
        } else {
            echo 'error You didnt specify a valid typer, red flagged';
            $result = mysql_query("INSERT INTO flagged (sw_id, fo_id, sw_name, fo_name, flag_type, cause, ip) VALUES ('" . $row['user_id'] . "', '000000', '" . DecryptAll_SQL($_GET['user'], $key) . "', 'Typer Attempted " . DecryptAll_SQL($_GET['typer'], $key) . "', 'yellow', 'Failed to specify valid typer when sleeping', '" . $_SERVER['REMOTE_ADDR'] . "')");
        } 
    } 
} else {
    $result = mysql_query("INSERT INTO log (action, text, IP) VALUES ('1', '" . $row['user_id'] . "', '" . $_SERVER['REMOTE_ADDR'] . "')");
    echo 'error Invalid username or password';
} 
// } else {
// $result = mysql_query("INSERT INTO cheaters (sleepuser_id, typeuser_id, sleeper, typer, time) VALUES ('".$row['user_id']."', '".$typerid."', '".$_GET['user']."', '".$_GET['typer']."', '".time()."')");
// die ('error Incorrect word, contains invalid symbols');
// }

?>