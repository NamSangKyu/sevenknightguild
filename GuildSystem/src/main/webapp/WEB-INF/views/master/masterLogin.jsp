<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<style type="text/css">
    	footer{
    	background-color: white;
    	}             
    </style>
</head>
<body>
<div id="container">
<form action="login.do" method="post">
		<header>관리자접속페이지</header>
		<section class="masterInfo">
			<article>
				<input type="password" id="pass" name="password"><br>
			</article>
		</section>
		<footer>
		 	<input type="submit" value="Access">
		</footer>
</form>
	</div>
</body>
</html>