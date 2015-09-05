<?php

define('PUN_ROOT', '../');
require PUN_ROOT.'include/common.php';

$file = '../files/worldmap.png';

if(!isset($_GET['x']) || !isset($_GET['y'])) {
	header('Location: '.$file);
	exit;
}

$x = explode(',', $_GET['x']);
$y = explode(',', $_GET['y']);

$image = imagecreatefrompng($file);
$colour = imagecolorallocate($image, 255, 0, 0);

for($i = 0;$i < count($x);$i++) {
	imagefilledellipse($image, $x[$i], $y[$i], 4, 4, $colour);
}

header('Content-type: image/png');
imagepng($image);

$db->close();
