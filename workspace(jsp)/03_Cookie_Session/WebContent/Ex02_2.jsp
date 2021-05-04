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
	String userId = (String)request.getAttribute("id");
	String userPwd = (String)request.getAttribute("pwd");
	
	out.println("session id >>> " + userId + "<br>");
	out.println("session pwd >>> " + userPwd + "<br>");
	
	session.setAttribute("id", userId);
	session.setAttribute("pwd", userPwd);
	
%>

<script type="text/javascript">
	location.href="Ex02_3.jsp";
</script>
</body>
</html>