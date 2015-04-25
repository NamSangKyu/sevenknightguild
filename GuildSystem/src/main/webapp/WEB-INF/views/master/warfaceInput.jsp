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
	width: 90%;
	font-size: 0.8em;
	height: 2em;
}

tbody {
	border-bottom-width: 2px;
	border-bottom-color: black;
	border-bottom-style: solid;
}
table {
	border-width: 2px;
	border-color: black;
	border-style: solid;
}
</style>
<script src="http://code.jquery.com/jquery-1.11.1.min.js">
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#input").click(function(){
	/* 	alert("start ajax~");
		alert($('#code').val());
		alert($('#score').val());
		alert($('#datevalue').val()); */
		$.ajax({
			type:"GET",
			url:"insertWarfaceScore.do",
			data:"code="+$('#code').val()+"&score="+$('#score').val()+"&date="+$('#datevalue').val(),
			success:function(data){
				//alert("전송성공"+data);
				$('#score').val("");								
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
	<table align="center"
		style="width: 100%; text-align: center; table-layout: fixed; border-collapse: collapse;"
		border="1">
		<thead style="border-bottom: 2px black solid">
			<tr>
				<th align="center" style="width: 50%">닉네임</th>
				<th align="center">점수</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>
						<select id="code" >
							<c:forEach var="m" items="${sessionScope.list }">
								<option value="${m.code }">${m.nick }</option>
							</c:forEach>
						</select>					
					</td>
					<td>
						<input type="text" id="score"> 
					</td>
				</tr>
				<tr>
					<td>
						날짜
					</td>
					<td>
						<input type="date" id="datevalue" value="${requestScope.date }">					
					</td>
				</tr>
		</tbody>
		<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" value="입력" id="input">
					</td>
				</tr>
		</tfoot>
	</table>
</body>
</html>