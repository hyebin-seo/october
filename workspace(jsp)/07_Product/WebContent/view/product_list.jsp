<%@page import="com.product.model.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	List<ProductDTO> list = 
			(List<ProductDTO>)request.getAttribute("List");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
	   <hr width="50%" color="red">
	      <h3>PRODUCTS 테이블 제품 전체 목록</h3>
	   <hr width="50%" color="red">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="400">
	      <tr>
	         <th>제품번호</th> <th>카테고리</th>
	      	 <th>제품명</th> <th>제조사</th>
	      </tr>
	      
	      <%
	         if(list.size() != 0) {
	        	 // 검색된 레코드가 있는 경우
	        	 // 검색된 레코드만큼 반복해서 웹 브라우저에 출력
	        	 for(int i=0; i<list.size(); i++) {
	        		 ProductDTO dto = list.get(i);
	      %>
	      			<tr>
	      			   <td> <%=dto.getPnum() %> </td>
	      			   <td> <%=dto.getCategory_fk() %> </td>
	      			   <td> <a href="<%=request.getContextPath() %>/content.do?num=<%=dto.getPnum() %>">
	      			   			<%=dto.getProducts_name() %> </a></td>
	      			   
	      			   <%
	      			      if(dto.getCompany() == null) {
	      			   %>
	      			   		<td> </td> 	  
	      			   <% }else {
	      			   %>
	      				    <td> <%=dto.getCompany() %> </td>  
	      			   <% } %>
	      			</tr>
	      <%   	 }  // for문 end
	         }else {  // 검색된 레코드가 없는 경우
	      %>
	      	  <tr>
	      	     <td colspan="4" align="center">
	      	        <h3>검색된 제품 목록이 없습니다.</h3>
	      	     </td>
	      	  </tr>
	        	 
	      <% } %>
	          
	          <tr>
	             <td colspan="4" align="right">
	          	    <input type="button" value="제품등록"
	          	        onclick="location.href='insert.do'">
	             </td>
	          </tr>
	   
	   </table>
	</div>

</body>
</html>