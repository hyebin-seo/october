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

	<c:set var="dto" value="${edit }" />
	
	<div align="center">
	   <hr width="50%" color="blue">
	      <h3>${dto.getMemname() } 회원 정보 수정 폼</h3>
	   <hr width="50%" color="blue">
	   <br> <br>
	   
	   <form method="post"
	      action="<%=request.getContextPath() %>/updateOk.do">
	      
	      <input type="hidden" name="mem_num" value="${dto.getNum() }">
	      <table border="1" cellspacing="0" width="350">
	         <tr>
	            <th>회원 ID</th>
	         	<td> <input type="text" name="mem_id"
	         			value="${dto.getMemid() }" readonly> </td>
	         </tr>
	         
	         <tr>
	         	<th>회원 이름</th>
	         	<td> <input type="text" name="mem_name"
	         	        value="${dto.getMemname() }" readonly> </td>
	         </tr>
	         
	         <tr>
	         	<th>회원 비밀번호</th>
	         	<td> <input type="password" name="mem_pwd"> </td>
	         </tr>
	         
	         <tr>
	         	<th>회원 나이</th>
	         	<td> <input type="text" name="mem_age"
	         			value="${dto.getAge() }"> </td>
	         </tr>
	         
	         <tr>
	         	<th>회원 마일리지</th>
	         	<td> <input type="text" name="mem_mileage"
	         			value="${dto.getMileage() }"> </td>
	         </tr>
	         
	         <tr>
	         	<th>회원 직업</th>
	         	<td> <input type="text" name="mem_job"
	         			value="${dto.getJob() }"> </td>
	         </tr>
	      
	      	 <tr>
	      	 	<th>회원 주소</th>
	      	 	<td> <input type="text" name="mem_addr"
	      	 			value="${dto.getAddr() }"> </td>
	      	 </tr>
	      	 
	      	 <tr>
	      	 	<td colspan="2" align="center">
	      	 	   <input type="submit" value="회원수정">
	      	 	        &nbsp;&nbsp;&nbsp;
	      	 	   <input type="reset" value="다시작성">
	      	 	</td>
	      	 </tr>
	      </table>
	   
	   </form>
	
	</div>
	
</body>
</html>