<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${param.name}님 환영합니다.</h2>
	<h2>${param.msg} 정보를 주셨네요.....</h2>
	<h3>요청 시간 : <%=new Date().toLocaleString() %></h3>
</body>
</html>