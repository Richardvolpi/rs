<?php
function redirect($url)
{
?>
	<script language="JavaScript">
	window.location="<?php echo $url; ?>";
	</script>
<?php
}

redirect('http://www.landofklown.org');
?>