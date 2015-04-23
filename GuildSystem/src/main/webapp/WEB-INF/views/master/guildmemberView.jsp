<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>길드원 리스트</title>
<link rel="stylesheet" href="resources/main.css" >
<meta name="viewport" 
		content="width=device-width
                , user-scalable=no
                , initial-scale=1.0
                , maximum-scale=1.0" />
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
	<header>길드원 리스트</header>
	<section>
		<article>
			<iframe src="guildmemberlist.do" scrolling="yes" style="width: 100%;">
			</iframe>
		</article>
	</section>
	<footer>
	<form action="login.do" method="post">
		<input type="submit" value="관리자메인">
	</form>
	</footer>
</div>
</body>
</html>