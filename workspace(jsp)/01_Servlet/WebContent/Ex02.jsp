<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML 주석 -->
<%-- JSP 주석 --%>

<h2>두 수 더하기(에노테이션(1:1) 등록)</h2>
<%-- 입력된 데이터를 서블릿 매핑 이름이 adder인 서블릿으로 전송하라는 의미 --%>
<form action="adder" method="get">
	<%-- 텍스트 박스에 입력된 첫번째 숫자를 num1이라는 변수에 저장하여 서블릿으로 전송하라는 의미 --%>
	<p>첫번째 수 : <input type="text" name="num1"></p> 
	<p>두번째 수 : <input type="text" name="num2"></p>
	<input type="submit" value="계산">
</form>

<hr>

<h2>두 수 더하기(web.xml 파일에 등록)</h2>
<form action="adder1" method="post">
	<%-- 텍스트 박스에 입력된 첫번째 숫자를 num1이라는 변수에 저장하여 서블릿으로 전송하라는 의미 --%>
	<p>첫번째 수 : <input type="text" name="num1"></p> 
	<p>두번째 수 : <input type="text" name="num2"></p>
	<input type="submit" value="계산">
</form>
</body>
</html>