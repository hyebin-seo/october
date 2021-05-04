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
	<jsp:forward page="Ex02_1.jsp">
		<jsp:param value="hong" name="id"/>
		<jsp:param value="1234" name="pwd"/>
	</jsp:forward>
</div>
</body>
</html>