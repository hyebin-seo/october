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
		<c:set var="dto" value="${Cont }" />
		<hr width="50%" color="red">
			<h3>${dto.getBoard_writer() }님 게시물 상세 내역</h3>
		<hr width="50%" color="red">
		
		<table border="1" cellspacing="0" width="400">
			<tr>
				<th>작성자</th>
				<td> ${dto.getBoard_writer() } </td>
			</tr>
			<tr>
				<th>글제목</th>
				<td> ${dto.getBoard_title() } </td>
			</tr>
			<tr>
				<th>글내용</th>
				<td> <textarea rows="7" cols="30" readonly="readonly">${dto.getBoard_cont() }</textarea> </td>
			</tr>
			<tr>
				<th>조회수</th>
				<td> ${dto.getBoard_hit() } </td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td> ${dto.getBoard_regdate() } </td>
			</tr>
			<c:if test="${empty dto }">
				<tr>
					<td colspan="2" align="center">
						<h3>검색된 게시물이 없습니다.</h3>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글수정" onclick="location.href='board_update.do?no=${dto.getBoard_no() }'">
					<input type="button" value="글삭제" onclick="location.href='board_delete.do?no=${dto.getBoard_no() }'">
					<input type="button" value="글목록" onclick="location.href='board_list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>