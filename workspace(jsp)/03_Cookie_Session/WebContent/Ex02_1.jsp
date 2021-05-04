<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>id와 세션 설정 완료</title>
</head>
<body>
    
<%
	String userId = request.getParameter("id").trim();
	String userPwd = request.getParameter("pwd").trim();
	
	String db_id="hong";
	String db_pwd="1234";
	
	if(userId.equals(db_id)) {
		if(userPwd.equals(db_pwd)) {
			//회원인 경우
			//메인으로 이동
			//세션설정
			session.setAttribute("id", userId);
			session.setAttribute("pwd", userPwd);
%>
		<script type="text/javascript">
			location.href="Ex02_2.jsp";
		</script>
<%	
		}
	}

%>
</body>
</html>