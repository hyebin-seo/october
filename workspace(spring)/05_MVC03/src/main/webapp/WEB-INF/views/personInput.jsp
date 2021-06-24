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
	   <hr width="50%" color="skyblue">
	      <h3>개인 정보 입력 폼 페이지</h3>
	   <hr width="50%" color="skyblue">
	   <br> <br>
	   
	   <form method="post"
	      action="<%=request.getContextPath() %>/insert_ok">
	      <table border="1" cellspacing="0" width="400">
	         <tr>
	            <th>이  름</th>
	            <td> <input type="text" name="name" > </td>
	         </tr>
	         <tr>
	            <th>아이디</th>
	            <td> <input type="text" name="id" > </td>
	         </tr>
	         <tr>
	            <th>비밀번호</th>
	            <td> <input type="password" name="pwd" > </td>
	         </tr>
	         <tr>
	            <th>나  이</th>
	            <td> <input type="text" name="age" > </td>
	         </tr>
	         <tr>
	            <th>주  소</th>
	            <td> <input type="text" name="addr" > </td>
	         </tr>
	         <tr>
	            <th>이메일</th>
	            <td> <input type="text" name="email" > </td>
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