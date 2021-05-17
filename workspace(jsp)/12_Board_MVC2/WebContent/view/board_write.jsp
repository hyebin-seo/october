<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
	   <hr width="50%" color="orange">
	      <h3>BOARD 테이블 게시판 글쓰기 폼</h3>
	   <hr width="50%" color="orange">
	   <br> <br>
	   
	   <form method="post"
	      action="<%=request.getContextPath() %>/board_write_ok.do">
	      <table border="1" cellspacing="0" width="350">
	         <tr>
	            <th>작성자</th>
	         	<td> <input type="text" name="writer"> </td>
	         </tr>
	         
	         <tr>
	         	<th>글제목</th>
	         	<td> <input type="text" name="title"> </td>
	         </tr>
	         
	         <tr>
	         	<th>글내용</th>
	         	<td>
	         	   <textarea rows="7" cols="30" name="content"></textarea>
	         	</td>
	         </tr>
	         
	         <tr>
	         	<th>비밀번호</th>
	         	<td> <input type="password" name="pwd"> </td>
	         </tr>
	         
	         <tr>
	            <td colspan="2" align="center">
	               <input type="submit" value="글쓰기">
	         	        &nbsp;&nbsp;&nbsp;
	         	   <input type="reset" value="다시작성">
	            </td>
	         </tr>      
	      </table>
	   
	   </form>
	
	</div>
	
</body>
</html>