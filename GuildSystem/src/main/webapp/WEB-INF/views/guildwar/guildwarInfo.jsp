<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>길드전 참여현황</title>
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
#warfaceDetail{
	width: 100%;
	height:300px;
}
#warfaceResult{
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
		var detailView = document.getElementById("warfaceDetail");
		detailView.src = "guildwardetail.do?date="+datePicker.value;
		var resultView = document.getElementById("warfaceResult");
		resultView.src = "guildwarresult.do?date="+datePicker.value;
		
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
			<iframe src="guildwardetail.do?date=${date }" id="warfaceDetail" scrolling="yes">
			
			</iframe>
			<iframe src="guildwarresult.do?date=${date }" id="warfaceResult" scrolling="yes">
			
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