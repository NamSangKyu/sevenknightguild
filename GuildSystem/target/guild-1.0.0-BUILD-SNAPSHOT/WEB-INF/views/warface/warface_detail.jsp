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
</style>
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
			<c:forEach var="m" items="${requestScope.list }">
				<tr>
					<td>${m.nick }</td>
					<td>${m.score }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>