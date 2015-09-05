<?php

require 'config.php';
require 'functions.php';

require 'mysql.php';

$db = new DBLayer($db_host, $db_username, $db_password, $db_name, '', false);

?>