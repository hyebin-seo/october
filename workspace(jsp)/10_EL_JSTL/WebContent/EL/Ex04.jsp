<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>표현식으로 scope 내용 출력</h2>
	page >>> <%=pageContext.getAttribute("K") %> <br>
	request >>> <%=request.getAttribute("r") %> <br>
	session >>> <%=session.getAttribute("s") %> <br>
	application >>> <%=application.getAttribute("a") %>
	
	<h2>표현언어로 내용 출력</h2>
	page >>> ${pageScope.K } == ${K } <br>
	request >>> ${requestScope.r } == ${r } <br>
	session >>> ${sessionScope.s } == ${s } <br>
	application >>> ${applicationScope.a } == ${a } <br>
	
	<script type="text/javascript">
		
		location.href="Ex05.jsp";
	
	</script>
</body>
</html>