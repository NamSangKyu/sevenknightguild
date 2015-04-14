<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>길드가입신청서</title>
<meta name="viewport" 
		content="width=device-width
                , user-scalable=no
                , initial-scale=1.0
                , maximum-scale=1.0" />
<link rel="stylesheet" href="resources/main.css" >
<script type="text/javascript">
	function backPage() {
		history.back();
	}
</script>
<style type="text/css">
footer{
background-color: white;
}
</style>
</head>
<body>
<div id="container">
	<form action="guildInsertMessage.do" method="post">
		<header>길드가입신청</header>
		<section class="guildInfo">
			<article>
			<table style="width: 100%">
			<tr>
				<td style="width: 40%" align="right">
					<label for="nick">세나닉네임 : </label>
				</td>
				<td style="width: 60%">
					<input type="text" id="nick" name="nick" required="required">
				</td>
			</tr>
			<tr>
			<td align="right">
				<label for="kakao">카톡아이디 : </label>
			</td>
			<td>
				<input type="text" id="kakao" name="kakao" required="required">
			</td>
			</tr>
			<tr>
				<td align="center">메세지</td><td></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<textarea rows="10" cols="30" name="message" maxlength="100" placeholder="100자이내로 작성하세요, 덱 확인후 카카오톡으로 연락드립니다." style="width: 90%"></textarea>
				</td>
			</tr>
				</table>
			</article>
		</section>
		<footer>
			<input type="submit" value="가입신청" style="width: 100%"><br>
			<input type="button" value="이전페이지" onclick="backPage()" style="width: 100%">
		</footer>
	</form>
</div>
	
</body>
</html>