<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>표현언어로(EL)로 scope 내용 출력</h2>
	page >>> ${pageScope.K } == ${K } <br>
	request >>> ${requestScope.r } == ${r } <br>
	session >>> ${sessionScope.s } == ${s } <br>
	application >>> ${applicationScope.a } == ${a } <br>
</body>
</html>