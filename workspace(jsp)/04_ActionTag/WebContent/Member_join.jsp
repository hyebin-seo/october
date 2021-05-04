<%@page import="com.sist.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//한글 깨짐 방지 설정
	request.setCharacterEncoding("UTF-8");
	String memid = request.getParameter("memid");
	String memname = request.getParameter("memname");
	String pwd = request.getParameter("pwd");
	int age = Integer.parseInt(request.getParameter("age"));
	int mileage = Integer.parseInt(request.getParameter("mileage"));
	String job = request.getParameter("job");
	String addr = request.getParameter("addr");
	
	MemberDTO dto = new MemberDTO();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>