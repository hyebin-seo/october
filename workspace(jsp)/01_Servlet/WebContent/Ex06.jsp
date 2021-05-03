<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 성적 처리 폼 만들기(이름, 국어, 영어, 수학, 총점, 평균, 학점 --%>
<div align="center">
		<h2>학생 정보 입력 화면</h2>
		<form action="grade" method="post">
			<table border="1" cellspacing="0">
				<tr>
					<th>이 름</th>
					<td> <input type="text" name="name"></td>
				</tr>
				<tr>
					<th>국어</th>
					<td> <input type="text" name="kor"></td>
				</tr>
				<tr>
					<th>영어</th>
					<td> <input type="text" name="eng"></td>
				</tr>
				<tr>
					<th>수학</th>
					<td> <input type="text" name="mat"></td>
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