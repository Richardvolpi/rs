<?

	class securitygraph {

		var $mysql = array();
		
		var $conn;
		
		function securitygraph($mysql_host="",$mysql_user="",$mysql_pass="",$mysql_db=""){
			
			$this->mysql = array( "host"=>$mysql_host,"user"=>$mysql_user,"pass"=>$mysql_pass,"db"=>$mysql_db );
			
			$this->conn = @mysql_connect($this->mysql['host'],$this->mysql['user'],$this->mysql['pass']) or die("<b>MySQL Error:</b> ". mysql_error());
			
			@mysql_select_db($this->mysql['db'],$this->conn) or die("<b>MySQL Error:</b> Error selecting database '" . $this->mysql['db'] . "'");
			
			$expiretime = Time() - (60 * 10); // All codes that are still in the database after 10 minutes are removed
			
			// get rid of the un-used codes
			@mysql_query("DELETE FROM hashcodes WHERE timestamp < $expiretime",$this->conn) or die("<b>MySQL Error:</b> " . mysql_error());
		}
		
		function generate(){
		
			$code = base64_encode( chr( Rand(48, 57) ) . chr( Rand(65, 90) ) . chr( Rand(97,122) ) . chr( Rand(48, 57) ) . chr( Rand(65, 90) ) . chr( Rand(97,122) ) );
			
			mysql_query("INSERT INTO hashcodes (hashcode,timestamp) VALUES('$code','" . time() . "')",$this->conn);
			
			$results = mysql_query("SELECT autoid FROM hashcodes WHERE hashcode = '$code' LIMIT 0,1");
			
			$autoid = mysql_fetch_array($results);
			
			return( $autoid['autoid'] );
				
		}
		
		function remove($id){
			
			$id = (int)$id;
			
			mysql_query("DELETE FROM hashcodes WHERE autoid = $id",$this->conn);
			
		}
		
		function verify($id,$code){
		
			$id = (int)$id;
			
			$results = mysql_query("SELECT autoid FROM hashcodes WHERE autoid = $id and hashcode = '" . base64_encode($code) . "' LIMIT 0,1");
			$results = mysql_fetch_array($results);
			
			if (is_array($results)){
			
				return(true);
					
			} else {
			
				return(false);
					
			}
			
		}
		
		function showimage($id){
			
			$id = (int)$id;
			
			$results = mysql_query("SELECT hashcode FROM hashcodes WHERE autoid = $id LIMIT 0,1");
			
			$hashcode = mysql_fetch_array($results);
			$hashcode = base64_decode($hashcode['hashcode']);
			
			$i = 0;
			
			$displaycode = "";
			
			for(;;){
				
				$displaycode .= substr($hashcode,$i,1) . " ";
				
				if ($i == strlen($hashcode)){break;}
				$i++;
				
			}
			
			header("Content-Type: image/jpeg\n");
			header("Cache-Control: no-cache");
			
			$im = imagecreate(100,35);
			
			$black = imagecolorallocate($im,0,0,0);
			$white = imagecolorallocate($im,255,255,255);
			
			imagefilledrectangle($im,1,1,98,33,$white);
			
			imagestring($im,4,7,11.5,$displaycode,$black);
			echo imagejpeg($im,null,100);
			
		}
		
	}

?>