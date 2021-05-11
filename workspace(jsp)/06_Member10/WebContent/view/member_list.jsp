<%@page import="com.sist.model.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	List<MemberDTO> member = 
				(List<MemberDTO>)request.getAttribute("List");

%>

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
	      
	      <%
	         if(member.size() != 0) {
	        	 // 검색된 레코드가 존재하는 경우
	        	 // 검색된 레코드만큼 반복해서 웹 브라우저에 출력
	        	 for(int i=0; i<member.size(); i++) {
	        		 MemberDTO dto = member.get(i);
	      %>
	      			<tr>
	      			   <td> <%=dto.getNum() %> </td>
	      			   <td> <%=dto.getMemid() %> </td>
	      			   <td> 
	      			      <a href="<%=request.getContextPath() %>/content.do?num=<%=dto.getNum() %>">
	      			   			<%=dto.getMemname() %> </a></td>
	      			   <td> <%=dto.getRegdate().substring(0,10) %> </td>
	      			</tr>
	      <%     }  // for문 end
	         }else {
	        	 // 검색된 회원 목록이 없는 경우
	      %>
	      		<tr>
	      		   <td colspan="4" align="center">
	      		      <h3>검색된 레코드가 없습니다.</h3>
	      		   </td>
	      		</tr>
	      <% } %>
	      
	      <tr>
	         <td colspan="4" align="right">
	            <input type="button" value="회원등록"
	            	onclick="location.href='view/member_write.jsp'">
	         </td>
	      </tr>
	   </table>
	</div>

</body>
</html>





