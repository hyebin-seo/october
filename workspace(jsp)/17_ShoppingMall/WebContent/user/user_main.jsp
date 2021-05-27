<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../include/user_top.jsp" />
	
	<div align="center">
	   <h3>쇼핑몰에 오신 것을 환영합니다.</h3>
	   <c:set var="list" value="${productList }" />
	   <c:if test="${empty list }">
	      <span>상품 목록이 없습니다.</span> <br>
	   </c:if>
	   
	   <c:if test="${!empty list }">
	      <hr width="65%" color="red">
	         <h3>상품 목록 리스트</h3>
	      <hr width="65%" color="red">
	      <br>
	      
	      <table border="1" cellspacing="0" align="center">
	         <tr>
	            <c:forEach items="${list }" var="i">
	               <c:set var="count" value="${count + 1 }" />
	               <td align="center">
	                  <a href="user_product_view.do?pnum=${i.getPnum() }">
	                     <img src="<%=request.getContextPath() %>/upload/${i.getPimage() }"
	                         width="120" height="120" border="0">
	                  </a> <br>
	                  ${i.getPname() } <br>
	                  <fmt:formatNumber value="${i.getPrice() }" /> 원 <br>
	                  <fmt:formatNumber value="${i.getPoint() }" var="commaPoint" />
	                  [${commaPoint }] 포인트
	               </td>
	            
	               <c:if test="${count%3 == 0 }">
	                  </tr>
	                  <tr>
	               </c:if>
	               
	            </c:forEach>

	         </tr>
	      </table>
	   </c:if>
	
	</div>
	
	<jsp:include page="../include/user_bottom.jsp" />
</body>
</html>