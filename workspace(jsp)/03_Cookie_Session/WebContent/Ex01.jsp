<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String cookieName = "name";
	Cookie cookie = new Cookie(cookieName, "홍길동");
	
	// setMaxAge() : 쿠키의 유효 기간을 설정하는 메서드
	// 유효기간 설정 방법 : 60초 * 30 ==> 30분
	cookie.setMaxAge(60 * 30);
	
	// 쿠키를 클라이언트 컴퓨터에 전송
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키를 생성하는 페이지</h2>
	<p> <%=cookieName %>이라는 쿠키가 생성되었습니다.</p>
	
	<hr>
	<br><br>
	
	<form method="post" action="Ex01_1.jsp">
		<input type="submit" value="생성된 쿠키 확인">
	</form>
</body>
</html>