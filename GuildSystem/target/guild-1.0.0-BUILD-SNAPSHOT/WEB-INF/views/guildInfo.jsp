<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>길드 정보</title>
<link rel="stylesheet" href="resources/main.css" >
<style type="text/css">

ul{
	padding-top:0px;
	padding-left: 30px;
}
li{
	padding-top: 5px;
	padding-bottom: 0px;
	list-style-image: none;
	list-style-type: none;
}

footer{
	background-color: white;
}

p{
	padding-left: 70px;
	padding-top: 0px;
}
</style>
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
		<header>길드정보</header>
		<section class="guildInfo">
			<article>
			<table border="0" align="center">
				<tr>
					<td align="right">길드명 : </td>
					<td>역시역시Clan</td>
				</tr>
				<tr>
					<td align="right">창단일 : </td>
					<td>2015. 02. 17</td>
				</tr>
				<tr>
					<td align="right">길드마스터 : </td>
					<td>역시역시Master</td>
				</tr>
				<tr>
					<td align="center" colspan="2">창단멤버</td>
				</tr>
				<tr align="center">
					<td>역시Master</td>
					<td>역시상타규</td>
				</tr>
				<tr align="center">
						<td>역시벌크</td>
						<td>역시귀족</td>
				</tr>
				<tr align="center">
						<td>역시Coakin</td>
						<td></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						현재 길드 인원수 : ${requestScope.memberCount }
					</td>
				</tr>
			</table>
			</article>
		</section>
		<footer>
		 	<input type="button" value="이전페이지" onclick="backPage()">
		</footer>
	</div>
</body>
</html>