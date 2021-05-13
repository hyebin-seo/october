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
	      <h3>MEMBER10 테이블 회원 목록</h3>
	   <hr width="50%" color="gray">
	   <br> <br>

	   <table border="1" cellspacing="0" width="400">
	      <tr>
	         <th>회원번호</th> <th>회원 ID</th>
	      	 <th>회원명</th> <th>가입일자</th>
	      </tr>
	      
	      <c:set var="list" value="${list }"/>
	      <c:if test="${!empty list }">
	      	<c:forEach items="${list }" var="dto">
     			<tr>
     			   <td> ${dto.getNum()} </td>
     			   <td> ${dto.getMemid()} </td>
     			   <td> <a href="<%=request.getContextPath() %>/content.do?num=${dto.getNum()}">
     			   			${dto.getMemname()}</a> </td>
     			   <td> ${dto.getRegdate().substring(0,10)} </td>
     			</tr>
     		</c:forEach>
	      </c:if>
	      
	      <c:if test="${empty list }">
      		<tr>
      		   <td colspan="4" align="center">
      		      <h3>검색된 회원이 없습니다.</h3>
      		   </td>
      		</tr>
	      </c:if>
	   </table>
	</div>
</body>
</html>