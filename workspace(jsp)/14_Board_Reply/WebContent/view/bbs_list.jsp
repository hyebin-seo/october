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
	      <h3>JSP_BBS 테이블 게시판 전체 리스트</h3>
	   <hr width="50%" color="red">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="600">
	      <tr>
	         <th>글번호</th> <th>글제목</th> <th>조회수</th> <th>작성일자</th>
	         <th>Group</th> <th>Step</th> <th>Indent</th>
	      </tr>
	      
	      <c:set var="list" value="${List }" />
	      <c:if test="${!empty list }">
	         <c:forEach items="${list }" var="dto">
	            <tr>
	               <td> ${dto.getBoard_no() } </td>
	               <td> 
	                    <c:forEach begin="1" end="${dto.getBoard_indent() }">
	                       		&nbsp;&nbsp;
	                    </c:forEach>
	                    <a href="<%=request.getContextPath() %>/bbs_cont.do?no=${dto.getBoard_no() }&page=${page }">
	               				${dto.getBoard_title() } </a></td>
	               <td> ${dto.getBoard_hit() } </td>
	               <td> ${dto.getBoard_date().substring(0,10) } </td>
	               <td> ${dto.getBoard_group() } </td>
	               <td> ${dto.getBoard_step() } </td>
	               <td> ${dto.getBoard_indent() } </td>
	            </tr>
	         </c:forEach>
	      </c:if>
	      
	      <c:if test="${empty list }">
	         <tr>
	            <td colspan="7" align="center">
	         	   <h3>검색된 게시물이 없습니다.</h3>
	         	</td>
	         </tr>
	      </c:if>
	   
	      <tr>
	         <td colspan="7" align="right">
	            <input type="button" value="글쓰기"
	               onclick="location.href='bbs_write.do'">
	         </td>
	      </tr>
	   </table>
	   <br>
	   
	   <c:if test="${page > block }">
	      <a href="bbs_list.do?page=1">[맨처음]</a>
	      <a href="bbs_list.do?page=${startBlock - 1 }">◀</a>
	   </c:if>
	   
	   <c:forEach begin="${startBlock }" end="${endBlock }" var="i">
	      <c:if test="${i == page }">
	         <b><a href="bbs_list.do?page=${i }">[${i }]</a></b>
	      </c:if>
	      
	      <c:if test="${i != page }">
	         <a href="bbs_list.do?page=${i }">[${i }]</a>
	      </c:if>
	   </c:forEach>
	   
	   <c:if test="${endBlock < allPage }">
	      <a href="bbs_list.do?page=${endBlock + 1 }">▶</a>
	      <a href="bbs_list.do?page=${allPage }">[마지막]</a>
	   </c:if>
	   <br> <br>
	   
	   <form method="post"
	      action="<%=request.getContextPath() %>/board_search.do">
	   
	   	  <select name="search_field">
	   	     <option value="title">글제목</option>
	   	     <option value="content">글내용</option>
	   	     <option value="title_content">글제목+글내용</option>
	   	     <option value="writer">작성자</option>
	   	  </select>&nbsp;
	   	  
	   	  <input type="text" name="search_name">&nbsp;
	   	  <input type="submit" value="검색">
	  
	   </form>
	
	</div>
	
</body>
</html>