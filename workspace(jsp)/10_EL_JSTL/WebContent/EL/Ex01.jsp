<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int su = 150;
	pageContext.setAttribute("SU", su);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>표현언어로 여러가지 데이터를 출력하기</h2>
	<h3>
		${100 }<br>
		<%=su %><br>
		EL >>> ${SU }<br>
		${"안녕하세요?" }<br>
		${10+1 }<br>
		<!-- 문자열과 숫자가 더해질 때는 결합이 아니라,문자열을 우선 숫자로 변환 후 산술 -->
		${"10"+1 }<br>
	</h3>
	
</body>
</html>