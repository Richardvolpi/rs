<?php
session_start();
require_once('ran.class.php');
$im=&new ran;

/* 
  * want to use a different font ?? uncomment the line below and make sure it's the exact path.  
  * will return false on failure (couldn't find image)
  */
// $im->setFont('arial.ttf');

/* 
  *returns the random string placed on the image, this needs to then be placed into a session for comparison when the form is submitted 
  *
  * if you change the font, you may also need to width & height of the image, you can do this by supplying the two arguements to createImage() - createImage(500,50);
  */
$_SESSION['text']=$im->createImage();
?>