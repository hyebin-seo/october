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
		<form method="post" action="Ex07.jsp">
			<table border="1" cellspacing="0" width="300">
				<tr>
					<th>아이디</th>
					<td> <input type="text" name="id"> </td>
				</tr>
				
				<tr>
					<th>이 름</th>
					<td> <input type="text" name="name"> </td>
				</tr>
				
				<tr>
					<th>나이</th>
					<td> <input type="text" name="age"> </td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="전송">
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>