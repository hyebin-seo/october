<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	.head {
		text-align: right;
		margin-right: 250px;
	}

</style>
</head>
<body>

	<div align="center">
	   <hr width="65%">
	      <h2>관리자 페이지</h2>
	      <h4 class="head">${adminName }님 환영합니다.</h4>
	   <hr width="65%">
	   <br>
	   
	   <table width="800">
	      <tr>
	         <td>
	            <a href="<%=request.getContextPath() %>/admin_main.do">관리자 홈</a>
	         </td>
	         
	         <td>
	            <a href="<%=request.getContextPath() %>/admin_cat_input.do">카테고리 등록</a>
	         </td>
	         
	         <td>
	            <a href="<%=request.getContextPath() %>/admin_cat_list.do">카테고리 목록</a>
	         </td>
	         
	         <td>
	            <a href="<%=request.getContextPath() %>/admin_prod_input.do">상품 등록</a>
	         </td>
	         
	         <td>
	            <a href="<%=request.getContextPath() %>/admin_prod_list.do">상품 목록</a>
	         </td>
	      </tr>
	   </table>
	</div>

</body>
</html>