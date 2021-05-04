<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 한글 깨짐 방지 처리
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");

	// Ex05.jsp 페이지에서 넘어온 데이터를 처리해주면 됨.
	// trim() : 맨 앞이나 맨 뒤에 발생한 공백을 제거해주는 메서드.
	//String userId = request.getParameter("id").trim();
	String userPwd = request.getParameter("pwd");
	String userName = request.getParameter("name");
	String userGender = request.getParameter("gender");
	String userAddr = request.getParameter("addr");
	String userPhone = request.getParameter("phone");
	String userEmail = request.getParameter("email");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<hr width="50%" color="tomato">
		<h2>가입 회원 정보</h2>
	<hr width="50%" color="tomato">
	<table border="1" cellspacing="0" width="350">
		<tr>
			<th>아이디</th>
			<td><%=request.getParameter("id").trim() %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=userPwd %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=userName %></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%=userGender %></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=userAddr %></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><%=userPhone %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=userEmail %></td>
		</tr>
	</table>
	</div>
</body>
</html>