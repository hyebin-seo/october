<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
	   <hr width="50%" color="red">
	      <h3>BOARD 테이블 게시판 전체 리스트</h3>
	   <hr width="50%" color="red">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="450">
	      <tr>
	         <th>글번호</th> <th>글제목</th>
	         <th>조회수</th> <th>작성일자</th>
	      </tr>
	      
	      <c:set var="list" value="${List }" />
	      <c:if test="${!empty list }">
	         <c:forEach items="${list }" var="dto">
	            <tr>
	               <td> ${dto.getBoard_no() } </td>
	               <td> <a href="<%=request.getContextPath() %>/board_cont.do?no=${dto.getBoard_no() }&page=${paging.page}">
	                         ${dto.getBoard_title() }</a> </td>
	               <td> ${dto.getBoard_hit() } </td>
	               <td> <fmt:formatDate value="${dto.getBoard_regdate() }" pattern="yyyy-MM-dd"/> </td>
	            </tr>
	         </c:forEach>
	      </c:if>
	      
	      <c:if test="${empty list }">
	         <tr>
	              <td colspan="4" align="center">
	                 <h3>검색된 레코드가 없습니다.....</h3>
	              </td>
	         </tr>
	      </c:if>
	      
	      <tr>
	         <td colspan="4" align="right">
	            <input type="button" value="글쓰기"
	               onclick="location.href='board_write.do'">
	      
	         </td>
	      </tr>
	   
	   </table>
	   <br> <br>
	   
	   <!-- 페이징 처리 부분 -->
	   <c:if test="${paging.page > paging.block }">
	   		<a href="voard_list.do?page=1">◀◀</a>
	   		<a href="voard_list.do?page=${paging.startBlock - 1 }">◀</a>	   
	   </c:if>
	   
	   <c:forEach begin="${paging.startBlock }" end="${paging.endBlock }" var="i">
	   		<c:if test="${i == paging.page }">
				<b><a href="board_list.do?page=${i }">[${i }]</a></b>	   		
	   		</c:if>
	   		
	   		<c:if test="${i != paging.page }">
				<a href="board_list.do?page=${i }">[${i }]</a>		
	   		</c:if>
	   </c:forEach>
	   
	   <c:if test="${paging.endBlock < paing.allPage }">
	   		<a href="board_list.do?page=${paging.endBlock + 1 }">▶</a>
	   		<a href="board_list.do?page=${paging.allPage}">▶▶</a>
	   </c:if>
	   
	   <form method="post"
	      action="<%=request.getContextPath() %>/board_search.do">
	      <input type="hidden" name="page" value="${paging.page }">
	      <select name="field">
	         <option value="title">제목</option>
	         <option value="cont">내용</option>
	         <option value="title_cont">제목+내용</option>
	         <option value="writer">작성자</option>
	      </select>
	    
	      <input type="text" name="keyword">
	      <input type="submit" value="검색">
	   </form>
	</div>
</body>
</html>