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
		<h2>학생 정보 입력 화면</h2>
		<form action="student" method="post">
			<table border="1" cellspacing="0">
				<tr>
					<th>학 번</th>
					<td> <input type="text" name="hakbun"></td>
				</tr>
				<tr>
					<th>이 름</th>
					<td> <input type="text" name="name"></td>
				</tr>
				<tr>
					<th>전공과목</th>
					<td> <input type="checkbox" name="major" value="java">Java
						 <input type="checkbox" name="major" value="C언어">C언어
						 <input type="checkbox" name="major" value="JSP">JSP
						 <input type="checkbox" name="major" value="Spring">Spring
						 <input type="checkbox" name="major" value="PHP">PHP
					</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td> <input type="text" name="phone"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록"> 
						<input type="reset" value="취소"> 
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>