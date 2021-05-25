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
	   <hr width="50%" color="gray">
	      <h3>JSP_BBS 테이블 게시글 삭제 폼</h3>
	   <hr width="50%" color="gray">
	   <br> <br>
	   
	   <form method="post"
	      action="<%=request.getContextPath() %>/bbs_delete_ok.do">
	      <c:set var="dto" value="${Cont }" />
	      <input type="hidden" name="bbs_no" value="${bunho }">
	      <input type="hidden" name="page" value="${page }">
	      <input type="hidden" name="group" value="${dto.getBoard_group() }">
	      <input type="hidden" name="step" value="${dto.getBoard_step() }">
	      <table border="1" cellspacing="0" width="350">
	         <tr>
	            <th>삭제할 비밀번호</th>
	            <td> <input type="password" name="pwd"> </td>
	         </tr>
	         
	         <tr>
	            <td colspan="2" align="center">
	               <input type="submit" value="글삭제">
	                    &nbsp;&nbsp;&nbsp;
	               <input type="reset" value="다시작성">
	            </td>
	         </tr>
	      </table>
	   </form>
	
	</div>
	
</body>
</html>