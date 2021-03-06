<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>길드전 관리 메뉴</title>
<link rel="stylesheet" href="resources/main.css" >
<meta name="viewport" 
		content="width=device-width
                , user-scalable=no
                , initial-scale=1.0
                , maximum-scale=1.0" />
                
<script type="text/javascript">
function loadDate() {
	var datePicker = document.getElementById("datevalue");
	var infoView = document.getElementById("warfaceinfo");
	infoView.src = "guildwardetail.do?date="+datePicker.value;
}
</script>
<style type="text/css">
table{
	width: 100%;
}
td{
	text-align: center;
}
iframe{
	width: 100%;
	height: 95%;
}
#container{
}
#container input
{
	font-size:1.0em;
	font-weight:bold;
	height:2.0em;
	width:49%;
	margin: 0px;
}

.section{
	margin-top: 5px;
	width: 100%;
	height: 400px;
	font-size: 1.3em;
}
</style>

<script src="http://code.jquery.com/jquery-1.11.1.min.js">
</script>
<script type="text/javascript">
$(document).ready(function(){
	var control = $('#container');
	var scoreInput = control.find('#scoreInput');
	var scoreView = control.find('#scoreView');
	var section1 = $('#section1');
	var section2 = $('#section2');
	section2.slideUp(0);
	section1.slideUp(0);
	scoreInput.click(function(){
		section1.show(600);
		section2.hide(600);
	});
	
	scoreView.click(function(){
		section1.hide(600);
		section2.show(600);
		loadDate();
	});
});
</script>
</head>
<body>
<c:if test="${sessionScope.login !='access' }">
<form name="login" action="login.do" method="post">
<script type="text/javascript">
	document.login.submit();
</script>
</form>
</c:if>
<div id="container">
<header>길드전 관리메뉴</header>
<input type="button" value="길드전 참여 입력" id="scoreInput">
<input type="button" value="길드전 미참석자 조회" id="scoreView">
<div id="section1" class="section">
<iframe src="guildwarInput.do" id="warfaceInput" scrolling="auto" style="border: none;">
</iframe>
</div>
<div id="section2" class="section">
<table>
	<tr>
		<td width="40%">조회할 날짜 : </td>
		<td><input type="date" id="datevalue" onchange="loadDate()" value="${requestScope.date }" style="font-size: 0.8em;width:100%;"></td>
	</tr>
</table>

<iframe src="guildwardetail.do?date=${date }" id="warfaceinfo" scrolling="auto">
</iframe>
</div>
</div>
</body>
</html>