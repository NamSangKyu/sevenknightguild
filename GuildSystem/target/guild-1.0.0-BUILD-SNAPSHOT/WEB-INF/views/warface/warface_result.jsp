<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>공성 미참 리스트</title>
<style type="text/css">

@media screen and (max-width:600px) {
	#container{
		padding-top:0px;
		font-size: 1.5em;
	}
}

@media screen and (min-width:601px) {
	#container{
		padding-top:0px;
		font-size: 3em;
	}
}

h5{
margin-top:0px;
}
</style>
</head>
<body>
<div id="container">
	<h5>공성전 미참 리스트</h5>
	<c:forEach var="m" items="${requestScope.mlist }">
			${m} 
	</c:forEach>
</div>
</body>
</html>