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
	   <hr width="50%" color="red">
	      <h3>입력된 개인 정보</h3>
	   <hr width="50%" color="red">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="300">
	      <tr>
	         <th>이  름</th>
	         <td> ${userName } </td>
	      </tr>
	      
	      <tr>
	      	 <th>아이디</th>
	         <td> ${userId } </td>
	      </tr>
	   </table>
	   
	</div>
	
</body>
</html>