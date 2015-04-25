<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>길드원 등록페이지</title>
<script type="text/javascript">
	function checkSubmit() {
		var level= document.insert.level;
		if(!isNaN(level.value)){
			document.insert.submit();				
		}		
	}

</script>
<link rel="stylesheet" href="resources/main.css" >
<meta name="viewport" 
		content="width=device-width
                , user-scalable=no
                , initial-scale=1.0
                , maximum-scale=1.0" />
                
<style type="text/css">
	table {
		width: 100%;
		border-width:0px; 
	}
	td input {
		width: 100%;
		height: 100%;
		font-size: 1.1em;
	}
</style>
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
	<form action="memberInsert.do" method="post" name="insert">
	<header>길드원 등록페이지</header>
	<section>
		<article>
			<table>
				<tr>
					<td align="right" width="15%"><label for="nick">닉네임</td>
					<td width="90%"><input type="text" id="nick" name="nick" required="required" placeholder="닉네임"></td>
				</tr>
				<tr>
					<td align="right"><label for="level">플레이어렙</td>
					<td><input type="text" id="level" name="level" required="required" placeholder="플레이어렙"></td>
				</tr>
			</table>
		</article>
	</section>
	<footer>
		<input type="button" value="길드원등록" onclick="checkSubmit()">
	</footer>
	</form>
</div>


</body>
</html>