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
	<hr width="50%" color="orange">
			<h2>MEMBER 테이블 회원 가입 폼</h2>
		<hr width="50%" color="orange">
		<br>
		<form method="post" action="Member_join.jsp">
			<table border="1" cellspacing="0" width="400">
				<tr>
					<th>아이디</th>
					<td> <input type="text" name="memid"> </td>
				</tr>
				<tr>
					<th>이 름</th>
					<td> <input type="text" name="memname"> </td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td> <input type="password" name="pwd"> </td>
				</tr>
				<tr>
					<th>나이</th>
					<td> <input type="text" name="age"> </td>
				</tr>
				<tr>
					<th>마일리지</th>
					<td> <input type="text" name="mileage"> </td>
				</tr>
				<tr>
					<th>직업</th>
					<td> <input type="text" name="job"> </td>
				</tr>
				<tr>
					<th>주소</th>
					<td> <input type="text" name="addr"> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="가입하기">
						<input type="reset" value="취소">	
					 </td>
				</tr>
			</table>
		</form>
</div>
</body>
</html>