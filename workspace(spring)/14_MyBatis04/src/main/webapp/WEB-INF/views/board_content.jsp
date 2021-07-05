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
	   <hr width="50%" color="tomato">
	      <h3>BOARD 테이블 게시글 상세 내역</h3>
	   <hr width="50%" color="tomato">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="350">
	      <c:set var="dto" value="${cont }" />
	      <c:if test="${!empty dto }">
		     <tr>
		        <th>글번호</th>
		      	<td> ${dto.getBoard_no() } </td>
		     </tr>
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
		      	   <textarea rows="7" cols="30" readonly>${dto.getBoard_cont() }</textarea>  
		      	</td>
		     </tr>
		     <tr>
		        <th>비밀번호</th>
		        <c:if test="${empty dto.getBoard_pwd() }">
		           <td></td>
		        </c:if>
		        <c:if test="${!empty dto.getBoard_pwd() }">
		           <td>
			           <c:forEach begin="1" end="${dto.getBoard_pwd().length() }">
			                * 
			           </c:forEach>
		           </td>
		        </c:if>
		     </tr>
		     <tr>
		        <th>조회수</th>
		        <td> ${dto.getBoard_hit() } </td>
		     </tr>
		     <tr>
		        <th>작성일자</th>
		        <td> <fmt:formatDate value="${dto.getBoard_regdate() }" pattern="yyyy-MM-dd HH:mm"/>
		        </td>
		     </tr>
	      </c:if>
	      
	      <c:if test="${empty dto }">
	         <tr>
	            <td colspan="2" align="center">
	               <h3>검색된 레코드가 없습니다.....</h3>
	            </td>
	         </tr>
	      </c:if>
	      
	      <tr>
	         <td colspan="2" align="center">
	            <input type="button" value="글수정"
	               onclick="location.href='board_update.do?no=${dto.getBoard_no() }&page=${page }'">
	            <input type="button" value="글삭제"
	               onclick="if(confirm('게시글을 삭제 하시겠습니까?')){
	            	            location.href='board_delete.do?no=${dto.getBoard_no() }&page=${page }'
	                        }else {return; }">
	            <input type="button" value="전체목록"
	               onclick="location.href='board_list.do?page=${page }'">
	      
	         </td>
	      </tr>
	   </table>
	
	</div>
</body>
</html>