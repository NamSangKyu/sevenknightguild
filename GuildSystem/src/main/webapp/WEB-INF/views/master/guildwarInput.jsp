<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>공성점수 리스트</title>
<style type="text/css">

@media screen and (max-width:600px) {
	table {
		font-size: 1.5em;
	}
th {
	height: 45px;
}

td {
	height: 45px;
}
}
body{
	overflow: scroll;
}
@media screen and (min-width:601px) {
	table {
		font-size: 3em;
	}
	th {
		height: 70px;
	}
	
	td {
		height: 70px;
	}
}
select{
	width: 90%;
	font-size: 0.8em;
	height: 2em;
}
input{
	width: 20%;
	font-size: 0.8em;
	height: 2em;
}
#input{
width: 95%;
}
#datevalue{
width: 90%;
}
tbody {
	border-bottom-width: 2px;
	border-bottom-color: black;
	border-bottom-style: solid;
}
table {
	border-collapse:collapse;
	width:100%;
	text-align:center;
	border-width: 2px;
	border-color: black;
	border-style: solid;
}

.header{
	border-bottom-width: 2px;
	border-bottom-color: black;
	border-bottom-style: solid;
}
</style>
<script src="http://code.jquery.com/jquery-1.11.1.min.js">
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#input").click(function(){
		alert($("#form").serialize());
		$.ajax({
			type:"GET",
			url:"guildwarInsert.do",
			data:$("#form").serialize(),
			success:function(data){
			},
			error:function(data){
				alert("타임아웃 전송실패"+data);
			},
			timeout:3000
		});
	});
});
</script>
</head>
<body>
<div id="#container">
	<form id="form">
	<table border="1">
		<tr class="header">
			<td>
				날짜
			</td>
			<td>
				<input type="date" id="datevalue" name="date" value="${requestScope.date }">		
			</td>
		</tr>
		<tr>
			<td>참여여부</td>
			<td>닉네임</td>
		</tr>
	<c:forEach var="m" items="${sessionScope.list }" varStatus="index">
		<c:if test="${index.count % 2 == 0}">
		<tr>
		</c:if>
		<td><input type="checkbox" name="code" value="${m.code }" id="${m.nick }"></td><td><label for="${m.nick }">${m.nick }</label></td>
		<c:if test="${index.count % 2 == 0}">
		</tr>
		</c:if>
	</c:forEach>
	<tr>
	<td colspan="2">
		<input type="button" value="갱신" id="input">
	</td>
	</tr>
	</table>
						
</form>
</div>
</body>
</html>