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
		<hr width="50%" color="red">
			<h3>게시글 삭제 폼</h3>
		<hr width="50%" color="red">
		<br> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/board_delete_ok.do">
		<input type="hidden" name="board_no" value="${bunho }"> 
			<table border="1" cellspacing="0" width="350">
				<tr>
					<th>삭제할 비밀번호</th>
					<td> <input type ="passwrod" name="pwd"> </td>
				</tr>
			
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글삭제">
					</td>
				</tr>
			
			</table>
		
		
		</form>
</body>
</html>