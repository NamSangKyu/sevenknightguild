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
</head>
<body>
<form action="deleteMember.do" method="get">
<table style="width: 100%;" border="1">
	<thead>
		<tr>
			<th>선택</th>
			<th>닉네임</th>
			<th>플렙</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="m" items="${requestScope.list }">
			<tr>
				<td><input type="checkbox" name="code" value="${m.code }"></td>
				<td>${m.nick }</td>
				<td>${m.joinDate }</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr><td colspan="3"><input type="submit" value="선택한 길드원 정리"></td></tr>
	</tfoot>
</table>
</form>
</body>
</html>