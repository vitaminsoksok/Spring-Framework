<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
</head>
<body>
	<div>
		<form method="post">
			<div>
				아이디 : 
				<input type="text" name="id">
			</div>
			<div>
				비밀번호 :
				<input type="password" name="pw" id="">
			</div>
			<div>
				비밀번호 확인:
				<input type="password" name="pwConfirm" id="">
			</div>
			<div>
				<label for="male">남성</label>
				<input type="radio" name="gender" id="male"
				checked value="male">
				<label for="female">여성</label>
				<input type="radio" name="gender" id="female"
				value="female">
			</div>
			<div>
				이메일 : 
				<input type="email" name="email" id="">
			</div>
			<button type="submit">제출</button>
		</form>
	</div>
</body>
</html>