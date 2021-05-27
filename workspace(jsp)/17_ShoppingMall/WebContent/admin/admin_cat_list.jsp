<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function check(num) {
		let del = confirm("정말로 삭제 하시겠습니까?");
		
		if(del) {
			location.href="admin_cat_del.do?cnum="+num;
		}
	}


</script>
<style type="text/css">

	td {
		text-align: center;
	}

</style>
</head>
<body>

	<jsp:include page="../include/admin_top.jsp" />
	
	<div align="center">
	   <hr width="65%" color="maroon">
	      <h3>카테고리 전체 리스트</h3>
	   <hr width="65%" color="maroon">
	   <br>
	   
	   <table border="1" cellspacing="0" width="500">
	      <tr bgcolor="#eeffee">
	         <th>카테고리 번호</th> <th>카테고리 코드</th>
	         <th>카테고리 이름</th> <th>카테고리 삭제</th>
	      </tr>
	      
	      <c:set var="list" value="${categoryList }" />
	      <c:if test="${!empty list }">
	         <c:forEach items="${list }" var="dto">
	            <tr>
	               <td> ${dto.getCategory_num() } </td>
	               <td> ${dto.getCategory_code() } </td>
	               <td> ${dto.getCategory_name() } </td>
	               <td> <input type="button" value="삭제"
	                      onclick="check(${dto.getCategory_num()})"> </td>
	            </tr>
	         </c:forEach>
	      </c:if>
	      
	      <c:if test="${empty list }">
	         <tr>
	            <td colspan="4" align="center">
	               <h3>검색된 카테고리가 없습니다.</h3>
	            </td>
	         </tr>
	      </c:if>
	   </table>
	
	</div>
	
	
	<jsp:include page="../include/admin_bottom.jsp" />
</body>
</html>