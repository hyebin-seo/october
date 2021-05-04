<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("id").trim();
	String userPwd = request.getParameter("pwd").trim();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>현재 페이지는 Ex02_1.jsp 페이지입니다....</p>
	
	아이디:<%=userId %> <br>
	비밀번호:<%=userPwd %> <br>
</body>
</html>