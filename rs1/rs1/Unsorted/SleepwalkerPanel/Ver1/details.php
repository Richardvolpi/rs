<?php
function rot13($text) { 
    for ($i = 0, $len = strlen($text); $i < $len; $i++)
        $text[$i] = chr(ord($text[$i]) + 13);
    return $text;
    }
$prefix = strrev(rot13('#sleeping'));
$admin = strrev(rot13('admin'));
$type = strrev(rot13('typey'));
$sleep = strrev(rot13('sleepey'));
$key = strrev(rot13('34sc3ta'));
/*
echo "$prefix <br>";
echo "$admin <br>";
echo "$type <br>";
echo "$sleep <br>";
*/

echo "ok Server=irc.rsunknown.com Prefix=$prefix Admin=$admin Type=$type Sleep=$sleep Key=$key!";
?>

