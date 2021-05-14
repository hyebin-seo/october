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
	   <hr width="50%" color="tomato">
	      <h3>MEMBER10 테이블 회원 상세 정보</h3>
	   <hr width="50%" color="tomato">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="400">
	      <c:set var="cont" value="${cont }"/>
	      <c:if test="${!empty cont }">
	      	 <tr>
	      	    <th>회원 번호</th>
	      	 	<td> ${cont.getNum()} </td>
	      	 </tr>
	      	 
	      	 <tr>
	      	    <th>회원 ID</th>
	      	 	<td> ${cont.getMemid()} </td>
	      	 </tr>
	      	 
	      	 <tr>
	      	    <th>회원 이름</th>
	      	 	<td> ${cont.getMemname()}</td>
	      	 </tr>
	      	 
	      	 <tr>
	      	    <th>회원 비밀번호</th>
	      	 	<td> 
	      	 		<c:if test="${dto.getPwd().length() != 0 }">
						<c:forEach begin="1" end="${dto.getPwd().length()" var="i" }>
					   	*
					   	</c:forEach>
					 </c:if>
 				</td>
	      	 </tr>
	      	 
	      	 <tr>
	      	    <th>회원 나이</th>
	      	 	<td> ${cont.getAge()} </td>
	      	 </tr>
	      	 
	      	 <tr>
	      	    <th>회원 마일리지</th>
	      	 	<td> ${cont.getMileage()} </td>
	      	 </tr>
	      	 
	      	 <tr>
	      	    <th>회원 직업</th>
	      	 	<td> ${cont.getJob()} </td>
	      	 </tr>
	      	 
	      	 <tr>
	      	    <th>회원 주소</th>
	      	 	<td> ${cont.getAddr()} </td>
	      	 </tr>
	      	 
	      	 <tr>
	      	    <th>회원 가입일</th>
	      	 	<td> ${cont.getRegdate()} </td>
	      	 </tr>
	        </c:if>
	         
	         <c:if test="${empty cont }">
		         <tr>
		            <td colspan="2" align="center">
		               <h3>검색된 레코드가 없습니다.</h3>
		         	</td>
		         </tr> 
	         </c:if>
	   		 
	   		 <tr>
	   		    <td colspan="2" align="center">
	   		       <input type="button" value="회원수정"
	   		          onclick="location.href='update.do?num=${cont.getNum()}'">
	   		       <input type="button" value="회원삭제"
	   		          onclick="if(confirm('삭제 하시겠습니까?')) {
	   		        	         location.href='delete.do?num=${cont.getNum()}'
	   		          		   }else {return; }">  

	   		    </td>
	   		 </tr>
	   </table>
	
	</div>
	
</body>
</html>