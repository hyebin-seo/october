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
	      <h3>JSP_BBS 테이블 게시글 삭제 폼</h3>
	   <hr width="50%" color="blue">
	   <br> <br>
	   
	   <form method="post" action="<%=request.getContextPath() %>/bbs_delete_ok.do">
	      <c:set var="num" value="${no }"></c:set>
	      <c:set var="nowPage" value="${page }"></c:set>
	      <input type="hidden" name="no" value="${num }">
	      <input type="hidden" name="page" value="${nowPage }">
	      <table border="1" cellspacing="0" width="350">
	         <tr>
	            <th>삭제할 글의 비밀번호</th>
	         	<td> <input type="password" name="pwd"> </td>
	         </tr>
	         
	         <tr>
	         	<td colspan="2" align="center">
	         		<input type="button" value="취소"
					onclick="location.href='bbs_cont.do?no=${num }&page=${nowPage}'">
					&nbsp;&nbsp;&nbsp;
	         	   <input type="submit" value="글 삭제">
	            </td>
	         </tr>
	      </table>
	   
	   </form>
	
	</div>

</body>
</html>