<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	String req_param = request.getParameter("param");
	
	System.out.println("요청한 param >>> " + req_param);
	
	// Ajax 호출에 응답
	out.println("Ajax 호출 완료");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">


</script>
</head>
<body>

</body>
</html>