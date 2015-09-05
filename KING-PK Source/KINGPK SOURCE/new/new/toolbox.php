<?php
	
	define('VERSION', '0.2');
	
	define('NOW', time());
	define('THIS', basename($_SERVER['PHP_SELF']));
	
	if(isset($_GET['show'])) {
		$show = trim($_GET['show']);
		switch($show) {
			case 'phpinfo':
				phpinfo();
				exit;
		}
		header('Location: '.THIS);
	}
	
	if(!function_exists('file_get_contents')) {
		function file_get_contents($filename) {
			return implode("\n", file($filename));
		}
	}
	
	function message($string) {
		echo '<pre>'."\n";
		echo $string."\n";
		echo '</pre>'."\n";
		echo "\t\t".'<p><a href="javascript:history.go(-1);">Go Back</a></p>'."\n";
		echo "\t".'</body>'>"\n";
		echo '</html>'."\n";
		exit;
	}

?>
<?php echo '<?xml version="1.0" encoding="UTF-8" ?>'."\n"; ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Toolbox</title>
		<style type="text/css"><!--
			html, body, div, p {
				margin:0px;
				padding:0px;
			}
			
			body {
				color:#FFFFFF;
				text-align:center;
				padding-top:20px;
				font-family:arial;
				font-size:12px;
				background-color:#262626;
			}
			
			a {
				text-decoration:none;
				color:#FF7F14;
			}
			
			a:hover {
				color:#D96B11;
			}
			
			fieldset, pre {
				border:1px dotted #FFFFFF;
				margin:10px auto 10px auto;
				width:600px;
				background-color:#000000;
			}
			
			pre {
				padding:10px;
				text-align:left;
			}
			
			input, select, textarea {
				width:130px;
				background-color:#262626;
				border:1px solid #FFFFFF;
				color:#FFFFFF;
			}
			
			br {
				display:block;
				clear:both;
				margin-bottom:4px;
			}
			
			.button {
				color:#FF7F14;
				width:160px;
			}
			
			input.big, select.big {
				width:240px;
			}
			
			textarea.big {
				width:100%;
				height:200px;
			}
			
			.small {
				width:60px;
			}
		--></style>
	</head>
	<body>
		<p>Toolbox v<?php echo VERSION; ?> by <a href="mailto:reines@gmail.com">Reines</a>, running on <?php echo php_uname(); ?> (<a href="<?php echo THIS; ?>?show=phpinfo">PHP v<?php echo phpversion(); ?></a>)</p>
<?php

	if(isset($_GET['hash'])) {
		$word = trim($_GET['word']);
		if(empty($word)) {
			message('No word specified');
		}
		$alg = trim($_GET['alg']);
		switch($alg) {
			case 'md5':
				$hash = md5($word);
				break;
			case 'sha1':
				$hash = sha1($word);
				break;
		}
		if(isset($hash)) {
			message($alg.' hash for \''.$word.'\' is \''.strtoupper($hash).'\'');
		}
		message('Error: Unknown algorithm');
	}
	else if(isset($_GET['time'])) {
		$time = intval($_GET['time']);
		if(empty($time)) {
			message('No timestamp specified');
		}
		$format = isset($_GET['format']) ? trim($_GET['format']) : 'r';
		message('Timestamp is '.@date($format, $time).' (Timestamp: '.$time.')');
	}
	else if(isset($_GET['host'])) {
		$host = trim($_GET['host']);
		if(empty($host)) {
			message('No IP or Hostname specified');
		}
		if(@preg_match('/[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}/', $host)) {
			$rdns = gethostbyaddr($host);
			if($rdns == $host) {
				message('There is no reverse DNS set for '.htmlspecialchars($host));
			}
			message(htmlspecialchars($host).' resolves to '.htmlspecialchars($rdns));
		}
		else {
			$ip = gethostbyname($host);
			if($ip == $host) {
				message(htmlspecialchars($host).' did not resolve to any IP');
			}
			message(htmlspecialchars($host).' resolves to '.htmlspecialchars($ip));
		}
	}
	else if(isset($_GET['unserialize'])) {
		$serialized = trim($_GET['unserialize']);
		if(empty($serialized)) {
			message('No data to unserialize');
		}
		$string = @unserialize($serialized);
		if($string === false) {
			message('Un-Serialization failed');
		}
		ob_start();
		
		echo 'Un-Serialized data: '."\n";
		print_r($string);
		
		$contents = ob_get_contents();
		ob_end_clean();
		message($contents);
	}
	else if(isset($_GET['site'])) {
		$site = trim($_GET['site']);
		if(isset($_GET['getindexes'])) {
			function countIndexes($url, $regex) {
				$page = @file_get_contents($url);
				if($page === false) {
					return 'N/A';
				}
				if(@preg_match($regex, $page, $matches)) {
					return trim($matches[1]);
				}
				return 0;
			}
			$hits = array();
			
			$hits[] = 'Google: '.countIndexes('http://www.google.co.uk/search?safe=off&q=site:'.$site, '/of about <b>(.+?)</');
			$hits[] = 'Yahoo: '.countIndexes('http://search.yahoo.com/search?p=site:'.$site, '/of about <strong>(.+?) </');
			$hits[] = 'MSN: '.countIndexes('http://search.msn.co.uk/results.aspx?q=site:'.$site, '/Page 1 of (.+?)results/');
			$hits[] = 'AllTheWeb: '.countIndexes('http://www.alltheweb.com/search?cat=web&&q=site:'.$site, '/<span class=\"ofSoMany\">(.+?)</');
			$hits[] = 'AltaVista: '.countIndexes('http://www.altavista.com/web/results?q=site:'.$site, '/AltaVista found (.+?) results/');
			
			message(implode("\n", $hits));
		}
		else {
			message('Unknown method');
		}
	}
	
?>
		<fieldset>
			<legend>Time Functions</legend>
			<form action="<?php echo THIS; ?>" method="GET">
				<div class="inform">
					<input type="text" name="time" value="<?php echo time(); ?>" />
					<input type="text" name="format" value="r" class="small" />
					<br />
					<input type="submit" name="gettime" value="Convert Timestamp" class="button" />
				</div>
			</form>
		</fieldset>
		<fieldset>
			<legend>Hashing Functions</legend>
			<form action="<?php echo THIS; ?>" method="GET">
				<div class="inform">
					<input type="text" name="word" value="" />
					<select name="alg" class="small">
						<option value="md5">MD5</option>
						<option value="sha1">SHA-1</option>
					</select>
					<br />
					<input type="submit" name="hash" value="Get Hash" class="button" />
				</div>
			</form>
		</fieldset>
		<fieldset>
			<legend>DNS Functions</legend>
			<form action="<?php echo THIS; ?>" method="GET">
				<div class="inform">
					<input type="text" name="host" value="" />
					<br />
					<input type="submit" name="gethost" value="DNS Lookup" class="button" />
				</div>
			</form>
		</fieldset>
		<fieldset>
			<legend>String Functions</legend>
			<form action="<?php echo THIS; ?>" method="GET">
				<div class="inform">
					<input type="text" name="unserialize" value="" class="big" />
					<br />
					<input type="submit" name="dounserialize" value="Un-Serialize" class="button" />
				</div>
			</form>
		</fieldset>
		<fieldset>
			<legend>SEO Functions</legend>
			<form action="<?php echo THIS; ?>" method="GET">
				<div class="inform">
					<input type="text" name="site" value="" class="big" />
					<br />
					<input type="submit" name="getindexes" value="Count Search Indexes" class="button" />
				</div>
			</form>
		</fieldset>
		<p><a href="javascript:window.location.reload(true);">Refresh</a></p>
	</body>
</html>