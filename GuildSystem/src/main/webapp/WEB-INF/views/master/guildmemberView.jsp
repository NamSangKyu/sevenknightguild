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
<script type="text/javascript">
	function backPage() {
		history.back();
	}
</script>
</head>
<body>
<div id="container">
	<header>길드원 리스트</header>
	<section>
		<article>
			<iframe src="guildmemberlist.do" scrolling="yes" style="width: 100%;">
			</iframe>
		</article>
	</section>
	<footer>
		<input type="button" value="이전페이지" onclick="backPage()">
	</footer>
</div>
</body>
</html>