<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function guildInfo() {
		location.href = "guildInfo.do";
	}
	
	function warfaceInfo() {
		location.href = "warfaceView.do";
	}
	function guildwarInfo() {
		location.href = "guildwarinfo.do";
	}
	function memberInsert() {
		location.href = "memberInsertView.do";
	}
</script>
<link rel="stylesheet" href="resources/main.css" >
<meta name="viewport" 
		content="width=device-width
                , user-scalable=no
                , initial-scale=1.0
                , maximum-scale=1.0" />
</head>
<body>
	<div id="container">
		<header>역시역시Clan</header>
		<section>
			<article>
				<input type="button" value="길드정보" onclick="guildInfo()">
				<input type="button" value="공성전 참여현황" onclick="warfaceInfo()">
				<input type="button" value="길드전 참여현황" onclick="guildwarInfo()">
				<input type="button" value="세나Tip">
				<input type="button" value="가입신청" onclick="memberInsert()">
			</article>
		</section>
		<footer>
		 	제작자 : 남상규
			<address>nam2626@gmail.com</address>
		</footer>
	</div>
</body>
</html>