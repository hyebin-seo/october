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
	   <hr width="50%" color="blue">
	      <h3>JSP_BBS 테이블 게시물 답변 글 폼</h3>
	   <hr width="50%" color="blue">
	   <br> <br>
	   
	   <form method="post"
	      action="<%=request.getContextPath() %>/bbs_reply_ok.do">
	      <c:set var="dto" value="${reply }" />
	      <input type="hidden" name="bbs_no" value="${dto.getBoard_no() }">
	      <input type="hidden" name="bbs_group" value="${dto.getBoard_group() }"> 
	      <input type="hidden" name="bbs_step" value="${dto.getBoard_step() }"> 
	      <input type="hidden" name="bbs_indent" value="${dto.getBoard_indent() }"> 
	      <input type="hidden" name="page" value="${page }"> 
	      
	      <table border="1" cellspacing="0" width="350">
	         <tr>
	            <th>작성자</th>
	         	<td> <input type="text" name="reply_writer"
	         	         value="${dto.getBoard_writer() }"> </td>
	         </tr>
	         
	         <tr>
	         	<th>글제목</th>
	         	<td> <input type="text" name="reply_title"
	         	         value="${dto.getBoard_title() }"> </td>
	         </tr>
	         
	         <tr>
	            <th>글내용</th>
	         	<td>
	         	   <textarea rows="7" cols="30" name="reply_content">${dto.getBoard_cont() }</textarea>
	         	</td>
	         </tr>
	         
	         <tr>
	         	<th>비밀번호</th>
	         	<td> <input type="password" name="reply_pwd"> </td>
	         </tr>
	         
	         <tr>
	            <td colspan="2" align="center">
	               <input type="submit" value="답변글">
	         	        &nbsp;&nbsp;&nbsp;
	         	   <input type="reset" value="다시작성">
	            </td>
	         </tr>
	      
	      </table>
	   
	   </form>
	
	</div>
</body>
</html>