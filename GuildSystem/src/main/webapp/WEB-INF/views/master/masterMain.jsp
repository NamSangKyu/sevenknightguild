<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
<link rel="stylesheet" href="resources/main.css" >
<meta name="viewport" 
		content="width=device-width
                , user-scalable=no
                , initial-scale=1.0
                , maximum-scale=1.0" />
	<script type="text/javascript">
		function guildMemberList() {
			location.href = "guildmemberView.do";
		}
		
		function guildMemberInsert() {
			location.href = "guildmemberInsert.do";
			
		}
	
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
		<header>관리자페이지</header>
		<section class="masterInfo">
			<article>
				<input type="button" value="길드원 리스트" onclick="guildMemberList()">
				<input type="button" value="길드원 등록" onclick="guildMemberInsert()">
				<input type="button" value="공성전 관리" onclick="">
				<input type="button" value="길드전 관리" onclick="">
				<input type="button" value="경고 리스트" onclick="">
			</article>
		</section>
		<footer>
		<form action="logout.do">
			<input type="submit" value="로그아웃">
		</form>
		</footer>
	</div>
</body>
</html>