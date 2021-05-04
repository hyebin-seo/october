<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("-----getAttribute() 메서드 사용 결과 -----");
	String userId = (String)request.getAttribute("id");
	String userPwd = (String)request.getAttribute("pwd");
	
	out.println("session id >>> " + userId + "<br>");
	out.println("session pwd >>> " + userPwd + "<br>");
	
	out.println("-----Session 유효시간 사용 결과 -----");
	//세션의 유효 시간을 얻어올때 사용하는 메서드
	out.println("session 유효 시간 >>>" + session.getMaxInactiveInterval() + "<br>");
	
%>

<script type="text/javascript">
	location.href="Ex02_3.jsp";
</script>
</body>
</html>