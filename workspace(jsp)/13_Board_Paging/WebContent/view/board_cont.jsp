<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:set var="dto" value="${cont }"/>
		<hr width="50%" color="tomato">
			<h3>${dto.getBoard_writer() }님 게시물 상세내역</h3>
		<hr width="50%" color="tomato">
		<br> <br>
		
		<table border="1" cellspacing="0" width="500">
			<c:if test="${!empty dto }">
				<tr>
					<th>작성자</th>
					<td>${dto.getBoard_writer() }</td>
				</tr>

				<tr>
					<th>글제목</th>
					<td>${dto.getBoard_title() }</td>
				</tr>

				<tr>
					<th>글내용</th>
					<td><textarea rows="7" cols="30" readonly>${dto.getBoard_cont() }</textarea>
					</td>
				</tr>

				<tr>
					<th>비밀번호</th>
					<td>
						<c:forEach begin="1" end="${dto.getBoard_pwd().length() }">*</c:forEach>
					</td>
				</tr>

				<tr>
					<th>조회수</th>
					<td>${dto.getBoard_hit() }</td>
				</tr>

				<tr>
					<th>작성일자</th>
					<td>${dto.getBoard_regdate() }</td>
				</tr>
			</c:if>
			
			<c:if test="${empty dto }">
				<tr>
					<td colspan="2" align="center">
						<h3>검색된 게시물이 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글 수정"
					onclick="location.href='board_update.do?no=${dto.getBoard_no() }&page=${page}'">
					
					<input type="button" value="글 삭제"
					onclick="location.href='board_delete.do?no=${dto.getBoard_no() }&page=${page}'">
					
					<input type="button" value="목록으로"
					onclick="location.href='board_list.do?&page=${page}'"></td>
			</tr>
		
		</table>
	</div>
</body>
</html>