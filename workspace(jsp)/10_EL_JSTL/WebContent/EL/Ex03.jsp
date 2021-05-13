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
	int k = 45 + 71;

	pageContext.setAttribute("K", k);
	
	request.setAttribute("r", 1000);
	
	session.setAttribute("s", 10000);
	
	application.setAttribute("a", 100000);
	
	RequestDispatcher rd =
	request.getRequestDispatcher("Ex04.jsp");
	
	rd.forward(request, response);

%>

	결과 >>> <%=k %> <br>
	결과(EL) >>> ${K } <br>
</body>
</html>