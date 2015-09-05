<?php
header("Content-type: image/jpeg");
$im = imagecreate(400, 30);
$white = imagecolorallocate($im, 255, 255, 255);
$black = imagecolorallocate($im, 0, 0, 0);
// Replace path by your own font path
imagestring($im, 20, 3, 3, "Testy", $black);
//imagettftext($im,22,2,3,35,$black,"adler.ttf","la la");
imagejpeg($im);
imagedestroy($im);

?> 


