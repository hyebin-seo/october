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
			<h2>로그인 페이지</h2>
		<hr width="50%" color="blue">
		
		<form action="Ex04_01.jsp">
			<table border="1" cellspacing="0" width="300">
				<tr>
					<th>아이디</th>
					<td> <input type="text" name="id"> </td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td> <input type="password" name="pwd"> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="로그인">
						<input type="reset" value="취소">	
					 </td>
				</tr>
			</table>
		
		</form>
	</div>
</body>
</html>