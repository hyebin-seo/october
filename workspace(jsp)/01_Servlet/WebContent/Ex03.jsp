<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- form 태그의 속성 중에 method 속성이 안 나타나면 디폴트로 method="get" 방식이 됨. --%>
	<div align="center">
		<form action="profile">
			<p> 이 름 : <input type="text" name="name"> </p>
			<p> 나 이 : <input type="text" name="age"> </p>
			<input type="submit" value="전송">
		</form>
	</div>
</body>
</html>