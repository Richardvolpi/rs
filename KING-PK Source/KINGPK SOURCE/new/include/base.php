<?php

// Load the functions script
require PUN_ROOT.'include/functions.php';

// Reverse the effect of register_globals
unregister_globals();

@include PUN_ROOT.'config.php';

// If PUN isn't defined, config.php is missing or corrupt
if (!defined('PUN'))
	exit('The file \'config.php\' doesn\'t exist or is corrupt. Please run <a href="install.php">install.php</a> to install PunBB first.');

// Record the start time (will be used to calculate the generation time for the page)
list($usec, $sec) = explode(' ', microtime());
$pun_start = ((float)$usec + (float)$sec);

// Make sure PHP reports all errors except E_NOTICE. PunBB supports E_ALL, but a lot of scripts it may interact with, do not.
error_reporting(E_ALL ^ E_NOTICE);

// Turn off magic_quotes_runtime
set_magic_quotes_runtime(0);

// Strip slashes from GET/POST/COOKIE (if magic_quotes_gpc is enabled)
if (get_magic_quotes_gpc())
{
	function stripslashes_array($array)
	{
		return is_array($array) ? array_map('stripslashes_array', $array) : stripslashes($array);
	}

	$_GET = stripslashes_array($_GET);
	$_POST = stripslashes_array($_POST);
	$_COOKIE = stripslashes_array($_COOKIE);
}

// Seed the random number generator
mt_srand((double)microtime()*1000000);

// If a cookie name is not specified in config.php, we use the default (punbb_cookie)
if (empty($cookie_name))
	$cookie_name = 'punbb_cookie';

// Define a few commonly used constants
define('PUN_UNVERIFIED', 32000);
define('PUN_ADMIN', 1);
define('PUN_MOD', 2);
define('PUN_GUEST', 3);
define('PUN_MEMBER', 4);

define('RSCD_PMOD', 6);


// Load DB abstraction layer and connect
require PUN_ROOT.'include/dblayer/common_db.php';

// Start a transaction
$db->start_transaction();

// Load cached config
@include PUN_ROOT.'cache/cache_config.php';
if (!defined('PUN_CONFIG_LOADED'))
{
	require PUN_ROOT.'include/cache.php';
	generate_config_cache();
	require PUN_ROOT.'cache/cache_config.php';
}
