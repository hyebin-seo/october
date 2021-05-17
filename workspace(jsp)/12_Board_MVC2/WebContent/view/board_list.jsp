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
	      <h3>BOARD 테이블 전체 게시물 리스트</h3>
	   <hr width="50%" color="red">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="400">
	      <tr>
	         <th>글번호</th> <th>글제목</th>
	      	 <th>조회수</th> <th>작성일자</th>
	      </tr>
	      
	      <c:set var="list" value="${List }" />
	      <c:if test="${!empty list }">
	         <c:forEach items="${list }" var="dto">
	            <tr>
	               <td> ${dto.getBoard_no() } </td>
	               <td> <a href="<%=request.getContextPath() %>/board_cont.do?no=${dto.getBoard_no() }">
	               ${dto.getBoard_title() } </a></td>
	               <td> ${dto.getBoard_hit() } </td>
	               <td> ${dto.getBoard_regdate().substring(0,10) } </td>
	            </tr>
	         </c:forEach>
	      </c:if>
	      
	      <c:if test="${empty list }">
	         <tr>
	            <td colspan="4" align="center">
	               <h3>검색된 게시물이 없습니다...</h3>
	            </td>
	         </tr>
	      </c:if>
	   
	   	  <tr>
	   	     <td colspan="4" align="right">
	   	        <input type="button" value="글쓰기"
	   	           onclick="location.href='<%=request.getContextPath() %>/board_write.do'">
	   	     </td>
	   	  </tr>
	   </table>
	   <br> <br>
	   
	   <form method="post" action="<%=request.getContextPath() %>/board_search.do">
			
			<select name="search_field">
				<option value="title">제목</option>			
				<option value="content">내용</option>			
				<option value="title_content">제목+내용</option>		
				<option value="writer">작성자</option>		
			</select>
			
			<input type="text" name="search_name" size="15">
			<input type="submit" value="검색">
	   </form>
	</div>

</body>
</html>