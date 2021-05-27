<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%

	String imgPath = request.getContextPath()+"/upload/";

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	td {
		text-align: center;
	}

</style>
</head>
<body>

	<jsp:include page="../include/admin_top.jsp" />
	
	<div align="center">
	   <hr width="65%" color="red">
	      <h3>상품(제품) 리스트</h3>
	   <hr width="65%" color="red">
	   <br>
	   
	   <table border="1" cellspacing="0" width="65%">
	      <tr bgcolor="#ffcc00">
	         <th>상품 번호</th> <th>카테고리 코드</th> <th>상 품 명</th>
	   	     <th>이 미 지</th> <th>상품 가격</th> <th>수 량</th>
	   	     <th>제 조 사</th> <th>상품 입고일</th> <th>수 정 | 삭 제</th>
	      </tr>
	      
	      <c:set var="list" value="${productList }" />
	      <c:if test="${!empty list }">
	         <c:forEach items="${list }" var="dto">
	            <tr>
	               <td> ${dto.getPnum() } </td>
	               <td> ${dto.getPcategory() } </td>
	               <td> ${dto.getPname() } </td>
	               <td> <img src="<%=imgPath %>${dto.getPimage() }"
	                        width="60" height="60"> </td>
	               <td> <fmt:formatNumber value="${dto.getPrice() }" /> 원 </td>
	               <td> ${dto.getPqty() } </td>
	               <td> ${dto.getPcompany() } </td>
	               <td> ${dto.getPinputdate().substring(0,10) } </td>
	               <td>
	                  <a href="<%=request.getContextPath() %>/admin_prod_edit.do?pnum=${dto.getPnum() }">수정</a> | 
	                  <a href="<%=request.getContextPath() %>/admin_prod_del.do?pnum=${dto.getPnum() }">삭제</a>
	               </td>
                   </tr>
	         </c:forEach>
	      </c:if>
	      
	      <c:if test="${empty list }">
	         <tr>
	            <td colspan="9" align="center">
	               <h3>등록된 상품 리스트가 없습니다.</h3>
	            </td>
	         </tr>
	      </c:if>
	   </table>

	</div>
		
	<jsp:include page="../include/admin_bottom.jsp" />

</body>
</html>