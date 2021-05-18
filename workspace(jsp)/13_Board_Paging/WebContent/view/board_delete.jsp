<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
	   <hr width="50%" color="blue">
	      <h3>BOARD 테이블 게시글 삭제 폼</h3>
	   <hr width="50%" color="blue">
	   <br> <br>
	   
	   <form method="post" action="<%=request.getContextPath() %>/board_delete_ok.do">
	      <c:set var="num" value="${no }"></c:set>
	      <input type="hidden" name="no" value="${num }">
	      <table border="1" cellspacing="0" width="350">
	         <tr>
	            <th>삭제할 글의 비밀번호</th>
	         	<td> <input type="password" name="pwd"> </td>
	         </tr>
	         
	         <tr>
	         	<td colspan="2" align="center">
	         		<input type="button" value="취소"
					onclick="location.href='board_cont.do?no=${num }&page=${page}'">
					&nbsp;&nbsp;&nbsp;
	         	   <input type="submit" value="글 삭제">
	            </td>
	         </tr>
	      </table>
	   
	   </form>
	
	</div>

</body>
</html>