<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="orange">
			<h2>페이지 이동</h2>
		<hr width="50%" color="orange">
		
		<h3>페이지이동(forward)</h3>
		<form method="post" action="Ex06_01.jsp">
			<p>아이디:<input type="text" name="id"> </p>
			<p>비밀번호:<input type="password" name="pwd"> </p>
			<input type="submit" value="로그인">
		</form>
		
		<hr width="50%" color="orange">
		
		<h3>페이지이동(redirect)</h3>
		<form method="post" action="Ex06_02.jsp">
			<p>아이디:<input type="text" name="id"> </p>
			<p>비밀번호:<input type="password" name="pwd"> </p>
			<input type="submit" value="로그인">
		</form>
	</div>
</body>
</html>