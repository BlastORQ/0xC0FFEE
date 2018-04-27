<?php
include "config.php";
header("Cache-Control:public, max-age=86400");
header("Content-Type: text/html; charset=utf-8");

$param = isset($_GET["_"]) ? $_GET["_"] : "";

$param = trim($param, "/");
$param = rtrim($param, "/");
$param = str_replace(array("/", "."), "-", $param);
if($param == ""){
	$param = "index";
}

if(file_exists(strtolower(dirname(__FILE__)."/pages/". $param .".php"))){
	$url = strtolower(dirname(__FILE__)."/pages/". $param .".php");
	$template = strpos($param, "error") === false ? "page" : "error";

}else{
	$url = strtolower(dirname(__FILE__)."/pages/error-404.php");
	$template = "error";
	http_response_code(404);

}
ob_start();
	include ($url);;
	$innerHTML = ob_get_contents();
ob_end_clean();

ob_start();
	include ("template_{$template}.php");
	$outerHTML = ob_get_contents();
ob_end_clean();

foreach($replace_vars as $k => $v){
	$outerHTML = str_ireplace("%{$k}%", $v, $outerHTML);
}
echo $outerHTML;
?>