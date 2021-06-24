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
	   <hr width="50%" color="gray">
	      <h3>로그인 입력 폼</h3>
	   <hr width="50%" color="gray">
	   <br> <br>
	   
	   <form method="post"
	      action="<%=request.getContextPath() %>/insertOk">
	      <table border="1" cellspacing="0" width="300">
	         <tr>
	            <th>아이디</th>
	            <td> <input type="text" name="id" > </td>
	         </tr>
	         
	         <tr>
	            <th>비밀번호</th>
	            <td> <input type="password" name="pwd" > </td>
	         </tr>
	      
	         <tr>
	            <td colspan="2" align="center">
	               <input type="submit" value="전송">
	                    &nbsp;&nbsp;&nbsp;
	               <input type="reset" value="취소">
	            </td>
	         </tr>
	      </table>
	   
	   </form>
	</div>
</body>
</html>