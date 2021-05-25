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
	   <hr width="50%" color="red">
	      <h3>JSP_BBS 게시판 게시글 상세 내역</h3>
	   <hr width="50%" color="red">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="400">
	      <c:set var="dto" value="${cont }" />
	      <c:if test="${!empty dto }">
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
	         	<td> 
	         	  <textarea rows="7" cols="30">${dto.getBoard_cont() }</textarea>
	         	</td>
	         </tr>
	         
	         <tr>
	            <th>조회수</th>
	         	<td> ${dto.getBoard_hit() } </td>
	         </tr>
	         
	         <tr>
	            <th>작성일자</th>
	         	<td> ${dto.getBoard_date() } </td>
	         </tr>
	      </c:if>
	      
	      <c:if test="${empty dto }">
	         <tr>
	            <td colspan="2" align="center"> 
	               <h3>검색된 데이터가 없습니다.</h3>
	            </td>
	         </tr>
	      </c:if>
	      
	      <tr>
	         <td colspan="2" align="center">
	            <input type="button" value="글수정"
	               onclick="location.href='bbs_update.do?no=${dto.getBoard_no() }&page=${page }'">
	            <input type="button" value="글삭제"
	               onclick="location.href='bbs_delete.do?no=${dto.getBoard_no() }&page=${page }'">
	            <input type="button" value="글답변"
	               onclick="location.href='bbs_reply.do?no=${dto.getBoard_no() }&page=${page }'">
	            <input type="button" value="전체목록"
	               onclick="location.href='bbs_list.do?page=${page }'">
	         </td>
	      </tr>
	   </table>
	
	</div>
</body>
</html>