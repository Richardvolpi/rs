<?

	/**********************************************************
	 
	 The following example will explain how to use the SecurityGraph class.

	 Before we start, make sure you create the following MySQL table:
	 
					CREATE TABLE `hashcodes` (
					  `autoid` int(11) NOT NULL auto_increment,
					  `hashcode` text NOT NULL,
					  `timestamp` int(11) NOT NULL default '0',
					  PRIMARY KEY  (`autoid`)
					) TYPE=MyISAM AUTO_INCREMENT=1 ;	 
					
	And edit the following MySQL Information:
	 
	***********************************************************/
	

	$mysql = array();
	$mysql['HOST'] = "localhost"; // Replace this with your MySQL Host
	$mysql['USER'] = "rscheat_mediator"; // Replace this with your MySQL Username
	$mysql['PASS'] = "adpass123"; // Replace this with your MySQL Password
	$mysql['DB'] = "rscheat_sleepwalker"; // Replace this with your MySQL Database
	

	// The example code starts here:
	
	
	// Let's first include our class file:
	
	include(dirname(__FILE__) . "/securitygraph.php");
	
	// Now let's initiate the class file
	
	$security = new securitygraph($mysql['HOST'],$mysql['USER'],$mysql['PASS'],$mysql['DB']);	
	
	if ( isset($_GET['viewpicture']) ){

		$security->showimage($_GET['viewpicture']);
		exit();
		
	}
	
	if ( isset($_POST['codeid'] ) ){
		
		$codeid = $_POST['codeid'];
		$code = $_POST['code'];
		
		if ($security->verify($codeid,$code)){
			
			$security->remove($codeid);
			
			echo "<center><b>Correct!</b></center>";
			
		} else {
		
			echo "<center><b>Incorrect!</b></center>";
				
		}
		
	} else {
		
		$id = $security->generate();
		
		echo
		'
		<form method="POST" action="#">
  		<p align="center"><font size="3" face="Arial"><b>Security Check</b></font></p>
  		<p align="center"><img src="?viewpicture=' . $id . '"></p>
  		<p align="center"><font face="Arial" size="2">Please re-enter each letter and number you see in the above picture without the spaces (case-sensitive):</font></p>
  		<p align="center"><input type="text" name="code" size="20"></p>
  		<p align="center"><input type="submit" value="Verify Code"></p>
  		<input type="hidden" name="codeid" value="' . $id . '">
		</form>
		';
		
	}
	
?>