
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>RSC Dump</title>
<style>
* {
	font-family:	verdana, sans-serif;
	font-size:	10px;
	color:		white;
	font-weight:	bold;
}

body {
	background-color: black;
}

h1,h2 {
	text-align:	center;
	margin:		0px;
}
	h1	{font-size:	15px;}

.box {
	width:		300px;
	margin: 	15px auto;
	border: 	1px solid green;
	padding:	15px;
	text-align:	center;
}

table {
	width: 100%
}

tr {
	text-align:	left;
	background:	#222;
}
	tr.alt		{background:	#444;}
	td:first-child	{width:		90%;}
	tr:hover	{background:	green;}
	tr:hover td, tr:hover td *	{color:	black;}

a {
	display:	block;
	text-decoration:	none;
}

input, textarea {
	margin:		2px auto;
	background:	green;
	border:		1px solid white;
}
	textarea	{width:	100%;}

#adm {
	position: absolute;
	top: 0px;
	right: 0px;
}
	#adm *		{ color: black }
	#adm:hover *	{ color: white }

#pwd {
	position:	absolute;
	top:		0px;
	right:		0px;
	padding:	5px;
	background:	#777;
	border:		white;
	z-index:	2;
	text-align:	center;
}

#pbg {
	position:	absolute;
	top:		0px;
	left:		0px;
	width:		100%;
	height:		100%;
	background:	white;
	z-index:	1;
	opacity:	.75
	filter:		alpha(opacity=75);
	-moz-opacity:	.75
}
</style>
<script type="text/javascript" language="javascript">
var jlist = new Array();
jlist[3] = "3rxBot.rar";jlist[4] = "Acebot.rar";jlist[5] = "AkBot.rar";jlist[6] = "AllInOne.rar";jlist[7] = "Anarchist-Sprite-editor.zip";jlist[8] = "AreaEditor.7z";jlist[9] = "Aut0-T201H.rar";jlist[10] = "AutoRune.rar";jlist[11] = "BeyondRSCv9.rar";jlist[12] = "Bobbybot.rar";jlist[13] = "Canibalistic_Pk.rar";jlist[14] = "Canibalistic_Scriptable.rar";jlist[15] = "ColdFeet.rar";jlist[16] = "DBoT.rar";jlist[17] = "DeathAura.rar";jlist[18] = "HeadAche.rar";jlist[19] = "IT1.rar";jlist[20] = "InfiniTBoT.rar";jlist[21] = "KING-PK Source.rar";jlist[22] = "Landscape Editor.rar";jlist[23] = "LeadingBot.rar";jlist[24] = "LeoSleep.zip";jlist[25] = "Model Editor.rar";jlist[26] = "MoparClassic.zip";jlist[27] = "NattawatScriptPack.rar";jlist[28] = "OCR1.1.rar";jlist[29] = "PlayerKiller.rar";jlist[30] = "PruneBot.7z";jlist[31] = "RSC Map Generator.zip";jlist[32] = "RSCA Bot.rar";jlist[33] = "RSCAngelDrop.exe";jlist[34] = "RSCBot(t_x).rar";jlist[35] = "RSCD Sprite Editor.rar";jlist[36] = "RSCE_AC.rar";jlist[37] = "RandomRune(source).rar";jlist[38] = "Rsca Bot.7z";jlist[39] = "SBMRune.rar";jlist[40] = "SBot.rar";jlist[41] = "SGTBOT.rar";jlist[42] = "STS-Shell-src.tar.gz";jlist[43] = "Scripts.rar";jlist[44] = "SkullTorcha.rar";jlist[45] = "SkullTorchaScriptable.rar";jlist[46] = "TBoT.rar";jlist[47] = "TRuneXP.rar";jlist[48] = "TheLoveMachine.rar";jlist[49] = "Ultimate by goat.rar";jlist[50] = "Vee's Runebot.rar";jlist[51] = "WUSS121a.rar";jlist[52] = "WasteDBoT1.1-198.rar";jlist[53] = "XML-editor.rar";jlist[54] = "abot.rar";jlist[55] = "analects.txt";jlist[56] = "apello.rar";jlist[57] = "ausbot-source.rar";jlist[59] = "deob106.rar";jlist[60] = "deob192.rar";jlist[61] = "deob194.rar";jlist[62] = "deob196.rar";jlist[63] = "deob198.rar";jlist[64] = "deob199.rar";jlist[65] = "eXemplar's-collection.rar";jlist[66] = "eggsampler-rsc-204-d223fc6b77db.rar";jlist[67] = "error_log";jlist[68] = "index.php";jlist[69] = "items.rar";jlist[70] = "moparclassic-client.zip";jlist[71] = "mudclient101.jar";jlist[72] = "mudclient102.jar";jlist[73] = "mudclient103.jar";jlist[74] = "mudclient105.jar";jlist[75] = "mudclient106.jar";jlist[76] = "mudclient111.jar";jlist[77] = "mudclient113.jar";jlist[78] = "mudclient115.jar";jlist[79] = "mudclient127.rar";jlist[80] = "mudclient130.jar";jlist[81] = "mudclient134.jar";jlist[82] = "mudclient135.jar";jlist[83] = "mudclient136.jar";jlist[84] = "mudclient149.jar";jlist[85] = "mudclient175.jar";jlist[86] = "mudclient187.jar";jlist[87] = "mudclient188.jar";jlist[88] = "mudclient189.jar";jlist[89] = "mudclient190.jar";jlist[90] = "mudclient191.jar";jlist[91] = "mudclient193.jar";jlist[92] = "mudclient196.jar";jlist[93] = "mudclient197.jar";jlist[94] = "mudclient198.jar";jlist[95] = "mudclient199.jar";jlist[96] = "mudclient201.jar";jlist[97] = "mudclient39.jar";jlist[98] = "mudclient40.jar";jlist[99] = "mudclient61.jar";jlist[100] = "mudclient63.jar";jlist[101] = "mudclient69.jar";jlist[102] = "mudclient70.jar";jlist[103] = "mudclient72.jar";jlist[104] = "mudclient74.jar";jlist[105] = "mudclient75.jar";jlist[106] = "mudclient93.jar";jlist[107] = "mudclient95.jar";jlist[108] = "mudclient96.jar";jlist[109] = "n0obbot.rar";jlist[110] = "piv.rar";jlist[111] = "rs1.7z";jlist[112] = "rsc.zip";jlist[113] = "rscebotv1.rar";jlist[114] = "scar,scriptpack,by,super.rar";jlist[115] = "skeetbot.rar";jlist[117] = "timb.rar";
function fltr() {
	txt = document.getElementById('fltr').value.toLowerCase();
	for ( f in jlist ) {
		if ( !jlist[f].match(txt) )	{ document.getElementById("f"+f).style.display = 'none'; }
		else				{ document.getElementById("f"+f).style.display = '';     }
	}
}

function pwd() {
	if ( document.getElementById('pwd').style.display == "none" )	{ val = 'block'	}
	else								{ val = 'none'	}

	document.getElementById('pwd').style.display = val;
	document.getElementById('pbg').style.display = val;
}


</script>
</head>

<body onload="fltr();">
	<h1>RSC File Dump</h1>
	<h2>	

<p style="text-align:center">	Page generated in 0.002 seconds.<br/>
			
</p>
		<a href="http://autobots.biz">Autobots</a>
	</h2>

	<div id="adm">
		<a href="#" onclick="pwd();document.getElementById('pass').focus();">adm</a>
	</div>
	
	<div id="pwd" style="display: none">
		<form name="admin" method="post" action="index.php">
			<input type="password" name="pass" id="pass" />
			<input type="submit" name="go" value="&raquo;" />
		</form>
	</div>
	<div id="pbg" style="display: none" onclick="pwd();"></div>


	<div id="main" class="box">
		<input type="text" name="fltr" id="fltr" value="" onmouseover="this.focus();" onclick="this.select();" onkeyup="fltr();" />
		<input type="button" name="fbtn" id="fbtn" value="clear" onclick="document.getElementById('fltr').value=''; fltr();" />
		<div id="fbox">
			<table id="flst" name="flst">
				<th>File Name</th>
				<th>File</th>
				<th>Size</th>
				<tr id="f3" class="alt"><td><a href="3rxBot.rar">3rxBot.rar</a></td><td>282.23</td><td>KiB</td></tr><tr id="f4"><td><a href="Acebot.rar">Acebot.rar</a></td><td>145.55</td><td>KiB</td></tr><tr id="f5" class="alt"><td><a href="AkBot.rar">AkBot.rar</a></td><td>105.98</td><td>KiB</td></tr><tr id="f6"><td><a href="AllInOne.rar">AllInOne.rar</a></td><td>31.69</td><td>KiB</td></tr><tr id="f7" class="alt"><td><a href="Anarchist-Sprite-editor.zip">Anarchist-Sprite-editor.zip</a></td><td>832.56</td><td>KiB</td></tr><tr id="f8"><td><a href="AreaEditor.7z">AreaEditor.7z</a></td><td>208.29</td><td>KiB</td></tr><tr id="f9" class="alt"><td><a href="Aut0-T201H.rar">Aut0-T201H.rar</a></td><td>1.71</td><td>MiB</td></tr><tr id="f10"><td><a href="AutoRune.rar">AutoRune.rar</a></td><td>1.85</td><td>MiB</td></tr><tr id="f11" class="alt"><td><a href="BeyondRSCv9.rar">BeyondRSCv9.rar</a></td><td>4.97</td><td>MiB</td></tr><tr id="f12"><td><a href="Bobbybot.rar">Bobbybot.rar</a></td><td>122.41</td><td>KiB</td></tr><tr id="f13" class="alt"><td><a href="Canibalistic_Pk.rar">Canibalistic_Pk.rar</a></td><td>188.07</td><td>KiB</td></tr><tr id="f14"><td><a href="Canibalistic_Scriptable.rar">Canibalistic_Scriptable.rar</a></td><td>176.65</td><td>KiB</td></tr><tr id="f15" class="alt"><td><a href="ColdFeet.rar">ColdFeet.rar</a></td><td>636.72</td><td>KiB</td></tr><tr id="f16"><td><a href="DBoT.rar">DBoT.rar</a></td><td>106.5</td><td>KiB</td></tr><tr id="f17" class="alt"><td><a href="DeathAura.rar">DeathAura.rar</a></td><td>107.61</td><td>KiB</td></tr><tr id="f18"><td><a href="HeadAche.rar">HeadAche.rar</a></td><td>127.18</td><td>KiB</td></tr><tr id="f19" class="alt"><td><a href="IT1.rar">IT1.rar</a></td><td>117</td><td>KiB</td></tr><tr id="f20"><td><a href="InfiniTBoT.rar">InfiniTBoT.rar</a></td><td>108.27</td><td>KiB</td></tr><tr id="f21" class="alt"><td><a href="KING-PK Source.rar">KING-PK Source.rar</a></td><td>24.6</td><td>MiB</td></tr><tr id="f22"><td><a href="Landscape Editor.rar">Landscape Editor.rar</a></td><td>3.68</td><td>MiB</td></tr><tr id="f23" class="alt"><td><a href="LeadingBot.rar">LeadingBot.rar</a></td><td>109.12</td><td>KiB</td></tr><tr id="f24"><td><a href="LeoSleep.zip">LeoSleep.zip</a></td><td>1.23</td><td>MiB</td></tr><tr id="f25" class="alt"><td><a href="Model Editor.rar">Model Editor.rar</a></td><td>378.11</td><td>KiB</td></tr><tr id="f26"><td><a href="MoparClassic.zip">MoparClassic.zip</a></td><td>4.19</td><td>MiB</td></tr><tr id="f27" class="alt"><td><a href="NattawatScriptPack.rar">NattawatScriptPack.rar</a></td><td>83.36</td><td>KiB</td></tr><tr id="f28"><td><a href="OCR1.1.rar">OCR1.1.rar</a></td><td>22.91</td><td>KiB</td></tr><tr id="f29" class="alt"><td><a href="PlayerKiller.rar">PlayerKiller.rar</a></td><td>1.97</td><td>MiB</td></tr><tr id="f30"><td><a href="PruneBot.7z">PruneBot.7z</a></td><td>4</td><td>MiB</td></tr><tr id="f31" class="alt"><td><a href="RSC Map Generator.zip">RSC Map Generator.zip</a></td><td>400.95</td><td>KiB</td></tr><tr id="f32"><td><a href="RSCA Bot.rar">RSCA Bot.rar</a></td><td>30.75</td><td>KiB</td></tr><tr id="f33" class="alt"><td><a href="RSCAngelDrop.exe">RSCAngelDrop.exe</a></td><td>65</td><td>KiB</td></tr><tr id="f34"><td><a href="RSCBot(t_x).rar">RSCBot(t_x).rar</a></td><td>659.28</td><td>KiB</td></tr><tr id="f35" class="alt"><td><a href="RSCD Sprite Editor.rar">RSCD Sprite Editor.rar</a></td><td>3.38</td><td>MiB</td></tr><tr id="f36"><td><a href="RSCE_AC.rar">RSCE_AC.rar</a></td><td>5.69</td><td>MiB</td></tr><tr id="f37" class="alt"><td><a href="RandomRune(source).rar">RandomRune(source).rar</a></td><td>92.46</td><td>KiB</td></tr><tr id="f38"><td><a href="Rsca Bot.7z">Rsca Bot.7z</a></td><td>6.31</td><td>MiB</td></tr><tr id="f39" class="alt"><td><a href="SBMRune.rar">SBMRune.rar</a></td><td>701.71</td><td>KiB</td></tr><tr id="f40"><td><a href="SBot.rar">SBot.rar</a></td><td>123.18</td><td>KiB</td></tr><tr id="f41" class="alt"><td><a href="SGTBOT.rar">SGTBOT.rar</a></td><td>184.74</td><td>KiB</td></tr><tr id="f42"><td><a href="STS-Shell-src.tar.gz">STS-Shell-src.tar.gz</a></td><td>47.04</td><td>KiB</td></tr><tr id="f43" class="alt"><td><a href="Scripts.rar">Scripts.rar</a></td><td>989.55</td><td>KiB</td></tr><tr id="f44"><td><a href="SkullTorcha.rar">SkullTorcha.rar</a></td><td>208.29</td><td>KiB</td></tr><tr id="f45" class="alt"><td><a href="SkullTorchaScriptable.rar">SkullTorchaScriptable.rar</a></td><td>135.94</td><td>KiB</td></tr><tr id="f46"><td><a href="TBoT.rar">TBoT.rar</a></td><td>122.08</td><td>KiB</td></tr><tr id="f47" class="alt"><td><a href="TRuneXP.rar">TRuneXP.rar</a></td><td>109.06</td><td>KiB</td></tr><tr id="f48"><td><a href="TheLoveMachine.rar">TheLoveMachine.rar</a></td><td>121.63</td><td>KiB</td></tr><tr id="f49" class="alt"><td><a href="Ultimate by goat.rar">Ultimate by goat.rar</a></td><td>16.98</td><td>KiB</td></tr><tr id="f50"><td><a href="Vee's Runebot.rar">Vee's Runebot.rar</a></td><td>1.03</td><td>MiB</td></tr><tr id="f51" class="alt"><td><a href="WUSS121a.rar">WUSS121a.rar</a></td><td>1.23</td><td>MiB</td></tr><tr id="f52"><td><a href="WasteDBoT1.1-198.rar">WasteDBoT1.1-198.rar</a></td><td>2.76</td><td>MiB</td></tr><tr id="f53" class="alt"><td><a href="XML-editor.rar">XML-editor.rar</a></td><td>716.81</td><td>KiB</td></tr><tr id="f54"><td><a href="abot.rar">abot.rar</a></td><td>616.18</td><td>KiB</td></tr><tr id="f55" class="alt"><td><a href="analects.txt">analects.txt</a></td><td>154.04</td><td>KiB</td></tr><tr id="f56"><td><a href="apello.rar">apello.rar</a></td><td>78.61</td><td>KiB</td></tr><tr id="f57" class="alt"><td><a href="ausbot-source.rar">ausbot-source.rar</a></td><td>177.13</td><td>KiB</td></tr><tr id="f59"><td><a href="deob106.rar">deob106.rar</a></td><td>93.83</td><td>KiB</td></tr><tr id="f60" class="alt"><td><a href="deob192.rar">deob192.rar</a></td><td>182.21</td><td>KiB</td></tr><tr id="f61"><td><a href="deob194.rar">deob194.rar</a></td><td>103.6</td><td>KiB</td></tr><tr id="f62" class="alt"><td><a href="deob196.rar">deob196.rar</a></td><td>143.16</td><td>KiB</td></tr><tr id="f63"><td><a href="deob198.rar">deob198.rar</a></td><td>116.18</td><td>KiB</td></tr><tr id="f64" class="alt"><td><a href="deob199.rar">deob199.rar</a></td><td>103.42</td><td>KiB</td></tr><tr id="f65"><td><a href="eXemplar's-collection.rar">eXemplar's-collection.rar</a></td><td>124.84</td><td>MiB</td></tr><tr id="f66" class="alt"><td><a href="eggsampler-rsc-204-d223fc6b77db.rar">eggsampler-rsc-204-d223fc6b77db.rar</a></td><td>1.74</td><td>MiB</td></tr><tr id="f67"><td><a href="error_log">error_log</a></td><td>775</td><td>B</td></tr><tr id="f68" class="alt"><td><a href="index.php">index.php</a></td><td>8.6</td><td>KiB</td></tr><tr id="f69"><td><a href="items.rar">items.rar</a></td><td>1.01</td><td>MiB</td></tr><tr id="f70" class="alt"><td><a href="moparclassic-client.zip">moparclassic-client.zip</a></td><td>1.4</td><td>MiB</td></tr><tr id="f71"><td><a href="mudclient101.jar">mudclient101.jar</a></td><td>107.57</td><td>KiB</td></tr><tr id="f72" class="alt"><td><a href="mudclient102.jar">mudclient102.jar</a></td><td>107.71</td><td>KiB</td></tr><tr id="f73"><td><a href="mudclient103.jar">mudclient103.jar</a></td><td>107.79</td><td>KiB</td></tr><tr id="f74" class="alt"><td><a href="mudclient105.jar">mudclient105.jar</a></td><td>108.68</td><td>KiB</td></tr><tr id="f75"><td><a href="mudclient106.jar">mudclient106.jar</a></td><td>109.45</td><td>KiB</td></tr><tr id="f76" class="alt"><td><a href="mudclient111.jar">mudclient111.jar</a></td><td>112.21</td><td>KiB</td></tr><tr id="f77"><td><a href="mudclient113.jar">mudclient113.jar</a></td><td>112.24</td><td>KiB</td></tr><tr id="f78" class="alt"><td><a href="mudclient115.jar">mudclient115.jar</a></td><td>107.79</td><td>KiB</td></tr><tr id="f79"><td><a href="mudclient127.rar">mudclient127.rar</a></td><td>843.44</td><td>KiB</td></tr><tr id="f80" class="alt"><td><a href="mudclient130.jar">mudclient130.jar</a></td><td>112.26</td><td>KiB</td></tr><tr id="f81"><td><a href="mudclient134.jar">mudclient134.jar</a></td><td>112.62</td><td>KiB</td></tr><tr id="f82" class="alt"><td><a href="mudclient135.jar">mudclient135.jar</a></td><td>112.94</td><td>KiB</td></tr><tr id="f83"><td><a href="mudclient136.jar">mudclient136.jar</a></td><td>112.95</td><td>KiB</td></tr><tr id="f84" class="alt"><td><a href="mudclient149.jar">mudclient149.jar</a></td><td>114.03</td><td>KiB</td></tr><tr id="f85"><td><a href="mudclient175.jar">mudclient175.jar</a></td><td>117.51</td><td>KiB</td></tr><tr id="f86" class="alt"><td><a href="mudclient187.jar">mudclient187.jar</a></td><td>115.11</td><td>KiB</td></tr><tr id="f87"><td><a href="mudclient188.jar">mudclient188.jar</a></td><td>114.61</td><td>KiB</td></tr><tr id="f88" class="alt"><td><a href="mudclient189.jar">mudclient189.jar</a></td><td>115.7</td><td>KiB</td></tr><tr id="f89"><td><a href="mudclient190.jar">mudclient190.jar</a></td><td>115.74</td><td>KiB</td></tr><tr id="f90" class="alt"><td><a href="mudclient191.jar">mudclient191.jar</a></td><td>115.24</td><td>KiB</td></tr><tr id="f91"><td><a href="mudclient193.jar">mudclient193.jar</a></td><td>116.09</td><td>KiB</td></tr><tr id="f92" class="alt"><td><a href="mudclient196.jar">mudclient196.jar</a></td><td>115.35</td><td>KiB</td></tr><tr id="f93"><td><a href="mudclient197.jar">mudclient197.jar</a></td><td>115.74</td><td>KiB</td></tr><tr id="f94" class="alt"><td><a href="mudclient198.jar">mudclient198.jar</a></td><td>116.01</td><td>KiB</td></tr><tr id="f95"><td><a href="mudclient199.jar">mudclient199.jar</a></td><td>8.4</td><td>KiB</td></tr><tr id="f96" class="alt"><td><a href="mudclient201.jar">mudclient201.jar</a></td><td>115.9</td><td>KiB</td></tr><tr id="f97"><td><a href="mudclient39.jar">mudclient39.jar</a></td><td>100.5</td><td>KiB</td></tr><tr id="f98" class="alt"><td><a href="mudclient40.jar">mudclient40.jar</a></td><td>100.67</td><td>KiB</td></tr><tr id="f99"><td><a href="mudclient61.jar">mudclient61.jar</a></td><td>110.76</td><td>KiB</td></tr><tr id="f100" class="alt"><td><a href="mudclient63.jar">mudclient63.jar</a></td><td>111.04</td><td>KiB</td></tr><tr id="f101"><td><a href="mudclient69.jar">mudclient69.jar</a></td><td>111.12</td><td>KiB</td></tr><tr id="f102" class="alt"><td><a href="mudclient70.jar">mudclient70.jar</a></td><td>110.99</td><td>KiB</td></tr><tr id="f103"><td><a href="mudclient72.jar">mudclient72.jar</a></td><td>112.32</td><td>KiB</td></tr><tr id="f104" class="alt"><td><a href="mudclient74.jar">mudclient74.jar</a></td><td>112.95</td><td>KiB</td></tr><tr id="f105"><td><a href="mudclient75.jar">mudclient75.jar</a></td><td>113.11</td><td>KiB</td></tr><tr id="f106" class="alt"><td><a href="mudclient93.jar">mudclient93.jar</a></td><td>107.84</td><td>KiB</td></tr><tr id="f107"><td><a href="mudclient95.jar">mudclient95.jar</a></td><td>4.28</td><td>KiB</td></tr><tr id="f108" class="alt"><td><a href="mudclient96.jar">mudclient96.jar</a></td><td>108.67</td><td>KiB</td></tr><tr id="f109"><td><a href="n0obbot.rar">n0obbot.rar</a></td><td>106.13</td><td>KiB</td></tr><tr id="f110" class="alt"><td><a href="piv.rar">piv.rar</a></td><td>105.43</td><td>KiB</td></tr><tr id="f111"><td><a href="rs1.7z">rs1.7z</a></td><td>42.99</td><td>MiB</td></tr><tr id="f112" class="alt"><td><a href="rsc.zip">rsc.zip</a></td><td>57.11</td><td>MiB</td></tr><tr id="f113"><td><a href="rscebotv1.rar">rscebotv1.rar</a></td><td>3.44</td><td>MiB</td></tr><tr id="f114" class="alt"><td><a href="scar,scriptpack,by,super.rar">scar,scriptpack,by,super.rar</a></td><td>153.58</td><td>KiB</td></tr><tr id="f115"><td><a href="skeetbot.rar">skeetbot.rar</a></td><td>109.89</td><td>KiB</td></tr><tr id="f117" class="alt"><td><a href="timb.rar">timb.rar</a></td><td>112.27</td><td>KiB</td></tr>			</table>
		</div>
	</div>
</body>