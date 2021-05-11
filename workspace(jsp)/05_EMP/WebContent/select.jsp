<%@page import="com.sist.model.EmpDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	List<EmpDTO> emp = (List<EmpDTO>)request.getAttribute("List");

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
	      <h3>EMP 테이블 전체 레코드 리스트</h3>
	   <hr width="50%" color="red">
	   <br> <br>
	   
	   <table border="1" cellspacing="0" width="650">
	      <tr>
	         <th>사 번</th> <th>이 름</th> <th>담당업무</th> 
	         <th>관리자No.</th> <th>급 여</th> <th>보너스</th> 
	         <th>부서번호</th> <th>입사일자</th> <th>삭 제</th>
	      </tr>
	      <%
	         if(emp.size() != 0) {  // 데이터가 있다면
	        	 // 데이터 수만큼 반복해서 출력
	        	 for(int i=0; i<emp.size(); i++) {
	        		 EmpDTO dto = emp.get(i);
	        		 // System.out.println("dto >>> " + dto);
	        	 %>
		        	 <tr>
		        	    <td> <%=dto.getEmpno() %> </td>
		        	 	<td> <%=dto.getEname() %> </td>
		        	 	<td> <%=dto.getJob() %> </td>
		        	 	<td> <%=dto.getMgr() %> </td>
		        	 	<td> <%=dto.getSal() %> </td>
		        	 	<td> <%=dto.getComm() %> </td>
		        	 	<td> <%=dto.getDeptno() %> </td>
		        	 	<td> <%=dto.getHiredate().substring(0, 10) %> </td>
		        	 	<td>
		        	 	   <a href="<%=request.getContextPath() %>/delete?no=<%=dto.getEmpno() %>">삭 제</a>
		        	 	</td>
		        	 </tr>
	        	 <% }  // for문 end
	         }else {
	        	 // 데이터가 없는 경우
	        	 %>
	        	 <tr>
	        	    <td colspan="9" align="center">
	        	       <h3>검색된 레코드가 없습니다.</h3>
	        	    </td>
	        	 </tr>
	         <% } %>
	   </table>
	   <br>
	   <hr width="50%" color="red">
	   <br>
	   <a href="<%=request.getContextPath() %>/insert">[사원 추가]</a>
	</div>
	
</body>
</html>