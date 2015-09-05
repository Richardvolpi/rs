<?php
function rot13($text) { 
    for ($i = 0, $len = strlen($text); $i < $len; $i++)
        $text[$i] = chr(ord($text[$i]) + 13);
    return $text;
    }
$prefix = strrev(rot13('#test'));
$admin = strrev(rot13('admin'));
$type = strrev(rot13('fo'));
$sleep = strrev(rot13('sw'));
$key = strrev(rot13('34sc3ta'));
/*
echo "$prefix <br>";
echo "$admin <br>";
echo "$type <br>";
echo "$sleep <br>";
*/

echo "ok Server=irc.rscheatnet.org Prefix=$prefix Admin=$admin Type=$type Sleep=$sleep Key=$key!";
?>

