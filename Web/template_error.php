<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="%ASSETS%/style.css?<?php echo rand();?>" />
	<link rel="stylesheet" type="text/css" href="%ASSETS%/fonts/lato.css?<?php echo rand();?>" />
	<meta name="theme-color" content="#1fd8eb">
	<meta name="msapplication-navbutton-color" content="#1fd8eb">
	<meta name="apple-mobile-web-app-status-bar-style" content="#1fd8eb">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="HandheldFriendly" content="True">
	<meta charset="UTF-8" >
	<title><?php echo isset($title) ? $title : "Давид Манжула";?></title>
</head>
<body>
<div class="header" id="top">
	<div class="bg_wrapper" id="bg_wrapper">
		<div class="bg_img" id="bg_img"></div>
	</div>
	<div class="inner">
		<h1><?php echo isset($title) ? $title : "Давид Манжула";?></h1>
		<h2><?php echo $innerHTML; ?></h2>
		<nav id="nav">
			<a href="/" data-ga-event="contacts:home">
				<div class="icon"><img src="%ASSETS%/images/icon/home.svg"></div>
				<span class="text">Головна</span>
			</a>
			<a href="https://telegram.me/da411d" target="_blank" data-ga-event="contacts:telegram">
				<div class="icon"><img src="%ASSETS%/images/icon/tg.svg"></div>
				<span class="text">Telegram</span>
			</a>
			<a href="https://github.com/da411d" target="_blank" data-ga-event="contacts:github">
				<div class="icon"><img src="%ASSETS%/images/icon/gh.svg"></div>
				<span class="text">GitHub</span>
			</a>
			<a href="https://freelancehunt.com/freelancer/da411d.html?r=njz4e" target="_blank" data-ga-event="contacts:freelancehunt">
				<div class="icon"><img src="%ASSETS%/images/icon/freelancehunt.png"></div>
				<span class="text">Freelance­​hunt</span>
			</a>
		</nav>
	</div>
</div>
</body>
<script src="%ASSETS%/script.js?<?php echo rand();?>"></script>
<script>
	function rppl(){
		addRippleEffect(new Date() % window.innerWidth, new Date() % window.innerHeight);
		setTimeout(rppl, Math.random()*3000+2000);
	}
	setTimeout(rppl, Math.random()*5000+5000);
</script>
</html>