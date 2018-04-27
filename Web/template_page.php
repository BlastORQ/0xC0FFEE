<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="%ASSETS%/style.css?<?php echo rand();?>" />
	<link rel="stylesheet" type="text/css" href="%ASSETS%/style-page.css?<?php echo rand();?>" />
	<link rel="stylesheet" type="text/css" href="%ASSETS%/fonts/lato.css?<?php echo rand();?>" />
	<script>function headerBg(src){if(!src)return;document.querySelector("#bg_img").style.backgroundImage="url("+src+")";document.querySelector("#bg_img").style.boxShadow="0 0 0 200vmax rgba(0, 0, 0, 0."+(src.indexOf("?dark")>-1?7:3)+") inset";}</script>
	<meta name="theme-color" content="#000000">
	<meta name="msapplication-navbutton-color" content="#000000">
	<meta name="apple-mobile-web-app-status-bar-style" content="#000000">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="HandheldFriendly" content="True">
	<meta charset="UTF-8" >
	<title><?php echo isset($title) ? $title : "Давид Манжула";?></title>
</head>
<body>
<a href="%SITEDIR%">
<div class="header" id="top">
	<div class="bg_wrapper" id="bg_wrapper">
		<div class="bg_img" id="bg_img"></div>
	</div>
	<div class="inner">
		<h1>Давид Манжула</h1>
		<h2>Web-developer</h2>
	</div>
</div>
</a>

<div class="main">
<?php
	if(isset($title))echo "<h1>{$title}</h1>";
	echo $innerHTML;
	if(isset($bgimg))echo "<script>headerBg('{$bgimg}')</script>";
?>
</div>
</body>
<script src="%ASSETS%/script.js?<?php echo rand();?>"></script>
</html>