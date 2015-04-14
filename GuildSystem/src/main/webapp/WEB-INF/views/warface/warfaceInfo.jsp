<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>공성전</title>
<link rel="stylesheet" href="resources/main.css" >
<meta name="viewport" 
		content="width=device-width
                , user-scalable=no
                , initial-scale=1.0
                , maximum-scale=1.0" />
<style type="text/css">
header{
	font-size: 1.5em;
	padding-bottom:10px;
	border-bottom-color: black;
	border-bottom-style: solid;
	border-bottom-width: 1px;
}
article{
	padding-bottom:10px;
	padding-top:10px;
	border-bottom-color: black;
	border-bottom-style: solid;
	border-bottom-width: 1px;
}
#warfaceinfo{
	width: 100%;
	height:300px;
}
#warfaceresult{
	width: 100%;
	height:100px;
}
footer{
	background-color: white; 
}

</style>
<script type="text/javascript">
	function mainPage() {
		location.href = "/guild/";
	}
	function loadDate() {
		var datePicker = document.getElementById("datevalue");
		//location.href = "warfaceInfo.do?date="+datePicker.value;
		var infoView = document.getElementById("warfaceinfo");
		infoView.src = "warfaceInfo.do?date="+datePicker.value;
		var resultView = document.getElementById("warfaceresult");
		resultView.src = "warfaceResult.do?date="+datePicker.value;
	}
</script>
</head>
<body onload="">
<div id="container">
		<header>
			조회할 날짜 : <input type="date" id="datevalue" onchange="loadDate()" value="${requestScope.date }" style="font-size: 0.8em;">
		</header>
		<section class="guildInfo">
			<article>
			<div align="center">
			<iframe src="warfaceInfo.do?date=${date }" id="warfaceinfo" scrolling="yes">
			
			</iframe>
			<iframe src="warfaceResult.do?date=${date }" id="warfaceresult" scrolling="yes">
			
			</iframe>
			</div>
			</article>
		</section>
		<footer>
		<input type="button" value="메인화면" onclick="mainPage()">
		</footer>
	</div>
</body>
</html>