<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<c:set var="dto" value="${edit }" />
		<hr width="50%" color="red">
			<h3>${dto.getBoard_writer() }님 게시물 상세 내역 수정</h3>
		<hr width="50%" color="red">
		
		<form method="post" action="<%=request.getContextPath() %>/board_update_ok.do">
		<input type="hidden" name="no" value="${dto.getBoard_no() }">
		<input type="hidden" name="db_pwd" value="${dto.getBoard_pwd() }">
		<table border="1" cellspacing="0" width="400">
			<tr>
				<th>작성자</th>
				<td> ${dto.getBoard_writer() } </td>
			</tr>
			<tr>
				<th>글제목</th>
				<td> <input type="text" name="title" value="${dto.getBoard_title() }"> </td>
			</tr>
			<tr>
				<th>글내용</th>
				<td> <textarea rows="7" cols="30" name="content">${dto.getBoard_cont() }</textarea> </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td> <input type="password" name="pwd"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글수정">
					<input type="reset" value="취소">
					<input type="button" value="글목록" onclick="location.href='board_list.do'">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>