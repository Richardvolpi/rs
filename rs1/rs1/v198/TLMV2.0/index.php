<html>
<head>
<title>RSUnknown</title>
</head>
<body>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<a href='TLMV2.0.zip'>The Love Machine v2.0</a><br/>
<a href='../forums'>Forums</a>
<?php
//simple counter example v1.0
//open the counter file in read only mode
$counterfile = "./counter1.dat";
if(!($fp = fopen($counterfile,"r"))) die ("cannot open counter file");
//read the value stored in the file
$thecount = (int) fread($fp, 20);
//close the file
fclose($fp);
//increment the count
$thecount++;
//display the count
echo "visitor no : $thecount";
//open the file again in write mode and store
// the new count
$fp = fopen($counterfile, "w");
fwrite($fp , $thecount);
//close the file
fclose($fp);
?>
</body>
</html>