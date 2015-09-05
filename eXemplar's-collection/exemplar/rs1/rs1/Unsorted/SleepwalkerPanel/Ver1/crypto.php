<?php

$key = "34sc3ta";

Function EncryptROT($S) {
$S = strrev($S);
for ($F = 0; $F<StrLen($S); $F++ ){
$res .= chr(ord(substr($S, $F, 1)) + 13);
}
return $res;
}


Function DecryptROT($S) {
$S = strrev($S);
for ($F = 0; $F<StrLen($S); $F++ ){
$res .= chr(ord(substr($S, $F, 1)) - 13);
}
return $res;
}


Function Encrypt($S)

{

$chars = "KECTDPOSWNMFGQHL";

	

	$s1 = "";

	$s2="";

    For ($F = 0; $F<StrLen($S); $F++ ){

        $K = 0;

        

        $ff = ord(substr($S, $F, 1));

	

        $f1 = $ff & 15;

	

        $f2 = $ff & (255-15);

        $f2 = $f2 >> 4;

        $s1 = $s1 . substr($chars, $f1, 1);

        $s2 = $s2 . substr($chars, $f2, 1);

	

    }

    return  Substr($s2, 1, 1) . $s1 . $s2;

}





//Decrypt what is encrypted with Encrypt()

Function Decrypt($S)

{

$chars = "KECTDPOSWNMFGQHL";



    $S = Substr($S, 1);

	$s1 = "";

    For ($F = 0; $F<StrLen($S)/2; $F++ ){

        

        $f1 = StrPos( $chars, substr($S, $F, 1));

        $f2 = StrPos( $chars, substr($S, StrLen($S) / 2 + $F, 1));

	

        $f2 = $f2 << 4;

        $ff = $f1 | $f2;

        $s1 = $s1 . Chr($ff);

	

    }

    return $s1;

}





//Encrypt with key to make life even more complex



Function SaXoro($s, $key ){

    $n = 0;

    For ($f = 0;$f<strlen($s);$f++){

        if($s[$f]!=$key[$n]){

            $s[$f]= Chr(ord($s[$f]) ^ ord($key[$n]));

        }

        $n = $n + 1;

        If ($n >= StrLen($key)) {

             $n = 0;

        }

    }

    return $s ;

}



Function EncryptAll($s, $key) {
$s = Encrypt($s);
$s = SaXoro($s, $key);
$s= EncryptROT($s);
return str_replace("&", "^(**)^", $s);
}

Function DecryptAll($s, $key) {
$s = DecryptROT($s);
$s = SaXoro($s, $key);
$s = Decrypt($s);
return trim(str_replace("^(**)^", "&", $s));
}

Function DecryptAll_SQL($s, $key) {
$s = DecryptROT($s);
$s = SaXoro($s, $key);
$s = Decrypt($s);
return AddSlashes(trim(str_replace("^(**)^", "&", $s)));
}

?>