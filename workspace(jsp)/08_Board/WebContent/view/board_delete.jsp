<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int board_no = Integer.parseInt(request.getParameter("no"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="gray">
			<h3>board 테이블 게시물 삭제 폼</h3>
		<hr width="50%" color="gray">
		<br> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/deleteOk.do">
			<input type="hidden" name="board_no" value="<%=board_no%>">
			<table border="1" cellspacing="0" width="350">
				<tr>
					<th>게시글 비밀번호</th>
					<td> <input type="password" name="pwd"> </td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글 삭제">
					</td>
				</tr>
			
			</table>
		</form>
	</div>
</body>
</html>