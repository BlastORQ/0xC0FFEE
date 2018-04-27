<?php

if(isset($_GET["method"])){
	$method = $_GET["method"];
	$method = preg_replace('/([^0-9a-zA-Z|\.]+)/', "", $method);
	$method = str_replace("..", "", $method);
}
$params = json_decode(file_get_contents('php://input'));

$include = str_replace(".", "/", $method) . ".php";
if(file_exists($include)){
	include $include;
}else{
	$response = [
		"error" => [
			"code" => 404,
			"title" => "Method not found"
		]
	];
}

$response = json_encode($response);
echo $response;