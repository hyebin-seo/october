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
	   <hr width="50%" color="blue">
	      <h3>EMP 테이블 메인 페이지</h3>
	   <hr width="50%" color="blue">
	   <br> <br>
	   
	   <%-- request.getContextPath() : 현재 프로젝트명을 반환해 주는 메서드 --%>
	   <a href="<%=request.getContextPath() %>/select">[전체 레코드]</a>
	</div>
	
</body>
</html>