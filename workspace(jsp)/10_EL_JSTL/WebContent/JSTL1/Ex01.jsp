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
<%--
	기본적인 JSTL 태그 ==> 출력할 때는 EL언어 사용
	1. 변수 태그(set)
	<c:set var="변수명" value="값"> </c:set>
	
	2. 출력 태그(out)
	<c:out value="변수명"> </c:out>
	
	3. 삭제 태그(remove)
	<c:remove value="변수명"> </c:remove>
	
	4. 조건 처리 태그(if문) ==> else문이 없음
	<c:if test="조건식" var="변수명"> </c:if>
	
	5. 조건 처리 태그(choose문) ==> switch~case문과 유사
	<c:choose>
		<c:when test="조건식1">조건식1이 참인 경우 실행 문장</c:when>
		<c:when test="조건식2">조건식2이 참인 경우 실행 문장</c:when>
		<c:when test="조건식3">조건식3이 참인 경우 실행 문장</c:when>
		<c:otherwise>상기 조건식 이외의 경우 실행 문장</c:otherwise>
	</c:choose>
	
	6. 반복문 태그(forEach문) : for문
	<c:forEach begin="시작값" end="끝값" step="증감값" var="변수명"></c:forEach>
	<c:forEach items="객체명" var="변수명"> : 단축 for문
--%>
 	
 	<h2>JSTL의 기본 태그</h2>
 	<!-- 1. 변수 태그(set) -->
 	<c:set var="test" value="Hello JSTL!!!" />
 	
 	<!-- 2. 출력 태그(out) -->
 	test 변수 값 출력 : <c:out value="test" /> <br> <!-- 틀린 문법 -->
 	test 변수 값 출력 : <c:out value="${test }" /> <br> 
 	
 	<!-- 3. 삭제 태그(remove) -->
 	<c:remove var="test" /> <br> 
 	
 	test 변수 삭제 후 값 출력 : <c:out value="${test }" /> <br> 
 	
 	<hr>
 	
 	<!-- 4. 조건 처리 태그(if문) ==> else문이 없음 -->
 	<c:if test="${10 > 5 }" var="k" /> <!-- k는 boolean형이 됨 -->
 	
 	조건식 결과 : <c:out value="${k }" /> <br> 
 	
 	<hr>
 	
 	<!-- 5. 조건 처리 태그(choose문) ==> switch~case문과 유사 -->
 	<c:set var="grade" value="88" />
 	
 	<c:choose>
 		<c:when test="${grade >= 90 }">결과 : A학점입니다.</c:when>
 		<c:when test="${grade >= 80 }">결과 : B학점입니다.</c:when>
 		<c:when test="${grade >= 70 }">결과 : C학점입니다.</c:when>
 		<c:when test="${grade >= 60 }">결과 : D학점입니다.</c:when>
 		<c:otherwise>결과 : F학점입니다.</c:otherwise>
 	</c:choose>
 	
 	<hr>
 	
 	<!-- 6. 반복문 태그(forEach문) : for문 -->
 	<c:forEach begin="1" end="10" step="1" var="su">
 		${su } &nbsp;
 	</c:forEach>
 	
 	<hr>
 	
 	<!-- 6. 반복문 태그(forEach문) : 단축 for문  -->
	<%
 		String[] str = {"홍길동","이순신","유관순","김유신","김연아"};
 		pageContext.setAttribute("list", str);
 	%>
 	
 	<c:forEach items="${list }" var="i">
 		${i } &nbsp;
 	</c:forEach>
 	

 	
</body>
</html>