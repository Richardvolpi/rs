<?php
function encrypt($s, $key)
{
	$n = 0;
	for($f = 0;$f < strlen($s); $f++)
	{
		if($s[$f] != $key[$n])
			$s[$f]= chr(ord($s[$f]) ^ ord($key[$n]));
	        $n = $n + 1;
		if($n >= strlen($key))
			$n = 0;
	}
	return $s ;
}

function get_ip()
{
	if(isset($_SERVER['HTTP_X_FORWARDED_FOR']))
	{
		if(preg_match('/[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}/', $_SERVER['HTTP_X_FORWARDED_FOR'], $addresses))
			return $addresses[0];
	}
	return(isset($_SERVER['HTTP_CLIENT_IP'])) ? $_SERVER['HTTP_CLIENT_IP'] : $_SERVER['REMOTE_ADDR'];
}

function check_cookie()
{
	global $bot_name, $admin_username, $admin_password;

	if(isset($_COOKIE['filehost']))
	{
		list($cookie['username'], $cookie['password']) = unserialize(stripslashes($_COOKIE[$bot_name]));
		return(strtolower($cookie['username']) == strtolower($admin_username) && strtolower($cookie['password']) == strtolower($admin_password));
	}
	else
		return false;
}

function redirect($url)
{
?>
	<script language="JavaScript">
	window.location="<?php echo $url; ?>";
	</script>
<?php
}

function alert($msg)
{
?>
	<script language="Javascript">
	alert("<?php echo $msg; ?>")
	</script>
<?php
}

function get_pic()
{
	global $bot_name;
	
	if(!file_exists($bot_name.'.gif'))
		return;

	list($width, $height, $type, $attr) = getimagesize($bot_name.'.gif');
	
	return '<img src="'.$bot_name.'.gif" width="'.$width.'" height="'.$height.'" alt="'.$bot_name.'">';
}

function fuck($msg, $alert)
{
	global $db;
	
	$db->close();
	if($alert)
	    alert($msg);
	die($msg);
}

function is_valid_email($email)
{
	return preg_match('/^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/', $email);
}
?>