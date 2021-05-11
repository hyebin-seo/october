<%@page import="com.product.model.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	ProductDTO dto = 
			(ProductDTO)request.getAttribute("cont");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
	   <hr width="50%" color="tomato">
	      <h3>PRODUCTS 테이블 제품 상세 정보</h3>
	   <hr width="50%" color="tomato">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="400">
	      <%
	         if(dto != null) {
	        	 // 검색된 레코드가 있는 경우 웹 브라우저에 출력
	      %>  	 
	        	 <tr>
	        	    <th>제품번호</th>
	        	    <td> <%=dto.getPnum() %> </td>
	        	 </tr>
	        	 
	        	 <tr>
	        	    <th>제품 카테고리</th>
	        	    <td> <%=dto.getCategory_fk() %> </td>
	        	 </tr>
	        	 
	        	 <tr>
	        	    <th>제품명</th>
	        	    <td> <%=dto.getProducts_name() %> </td>
	        	 </tr>
	        	 
	        	 <tr>
	        	    <th>제품코드</th>
	        	    <td> <%=dto.getEp_code_fk() %> </td>
	        	 </tr>
	        	 
	        	 <tr>
	        	    <th>제품 입고가</th>
	        	    <td> <%=dto.getInput_price() %> </td>
	        	 </tr>
	        	 
	        	 <tr>
	        	    <th>제품 출고가</th>
	        	    <td> <%=dto.getOutput_price() %> </td>
	        	 </tr>
	        	 
	        	 <tr>
	        	    <th>배송 비용</th>
	        	    <td> <%=dto.getTrans_cost() %> </td>
	        	 </tr>
	        	 
	        	 <tr>
	        	    <th>마일리지</th>
	        	    <td> <%=dto.getMileage() %> </td>
	        	 </tr>
	        	 
	        	 <tr>
	        	    <th>제조사</th>
	        	    <td> <%=dto.getCompany() %> </td>
	        	 </tr>
	        	 
	        <% }else {  // 검색돤 레코드가 없는 경우
	        %>
	             <tr>
	                <td colspan="2" align="center">
	                   <h3>검색된 제품이 없습니다.</h3>
	                </td>
	             </tr>
	        	
	        <% }  %>
	   			
	   			<tr>
	   			   <td colspan="2" align="center">
	   			      <input type="button" value="제품수정"
	   			         onclick="location.href='update.do?num=<%=dto.getPnum() %>'">
	   			      <input type="button" value="제품삭제"
	   			         onclick="if(confirm('삭제 하시겠습니까?')) {
	   			         		location.href='delete.do?num=<%=dto.getPnum() %>'
	   			         	}else {return;}">
	   			      
	   			      <%-- 자바스크립트에서 window 객체 하위의 confirm() 메서드는
	   			                      확인 / 취소 버튼을 가진 경고창을 만들어 줌. 확인 버튼을 클릭하면 반환값으로
	   			           true를 리턴하고, 취소 버튼을 누르면 반환값으로 false를 리턴함.
	   			                      즉, 삭제 유무를 다시 한 번 확인하기 위해서 주로 사용됨.
	   			                      확인 버튼을 클릭하면 delete.do라는 서블릿으로 이동을 하고, 취소 버튼을 
	   			                      클릭하면 삭제를 안 하고 그대로 현재 창에 있게 되는 코드 --%>
	   			
	   			</tr>
	   </table>
	
	</div>
</body>
</html>