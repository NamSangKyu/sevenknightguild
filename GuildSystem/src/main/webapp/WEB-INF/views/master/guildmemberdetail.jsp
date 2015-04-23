<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>길드원 관리페이지</title>
<link rel="stylesheet" href="resources/main.css" >
<meta name="viewport" 
		content="width=device-width
                , user-scalable=no
                , initial-scale=1.0
                , maximum-scale=1.0" />
<script type="text/javascript">
	function backPage() {
		history.back();
	}
</script>
<style type="text/css">
th{
	font-size: 1.5em;
}
td{
	font-size: 1.5em;
}
#code{
	height: 100%;
}
</style>
</head>
<body>
<div id="container">
<form action="deleteMember.do" method="get">
<table style="width: 100%;" border="1">
	<thead>
		<tr>
			<th>선택</th>
			<th>닉네임</th>
			<th>플렙</th>
			<th>가입일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="m" items="${requestScope.list }">
			<tr>
				<td align="center"><input type="checkbox" name="code" value="${m.code }" id="code"></td>
				<td align="center">${m.nick }</td>
				<td align="center">${m.level }</td>
				<td align="center">${m.joinDate }</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr><td colspan="4" align="right"><input type="submit" value="선택한 길드원 정리" style="width: 40%;font-size: 1.2em;"></td></tr>
	</tfoot>
</table>
</form>
</div>
</body>
</html>