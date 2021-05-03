<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
지시어(디렉티브) : JSP 페이지에 대한 설정 정보를 지정하는 공간.
1. <%@ page %> : JSP 페이지에 대한 정보를 지정하는 공간.
- 어떻게 처리해야 하는지, 전달하기 위한 내용도 담고 있는 공간.
- 클라이언트의 요청에 JSP 페이지가 실행될 때 필요한 정보를 JSP 컨테이너(톰캣)에 알려주는 역할을 함.
2. <%@ include %> : 현재 페이지에 다른 문서(JSP, HTML)를 가져와서 내용을 컴파일 할 때 사용되는 디렉티브.
형식) <% include file ="포함할 파일의 url" %>
- include 지시어를 사용한 JSP 페이지가 컴파일 되는 과정에서 include 되는 JSP 페이지의 소스 내용을 그대로 포함해서 컴파일을 진행
- 즉, 복사 & 붙이기 방식으로 두 개의 파일이 하나의 파일로 구성이 된 후 같이 컴파일 됨.
3. <%@ taglib %> ==> 사용할 태그 라이브러리 지정
- EL / JSTL 언어 사용 시 적용되는 디렉티브.

============================================================================================
1. 페이지 지시어
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
- page language="java" : 해당 JSP 페이지에서 사용되는 언어(java).
- contentType : 문서의 타입 ==> JSP 페이지의 내용을 어떤 형태로 출력할지를 웹브라우저에게 알려주는 역할.
- charset : 문자(한글) 설정(UTF-8, EUC-KR)
- import : 다른 패키지에 있는 클래스를 가져다가 사용할 때 지정.
- session : HttpSession 속성의 사용 여부를 지정. 형식)
- isErrorPage : 에러페이지인지의 여부를 지정.
- errorPage : 에러가 발생했을 때 보여줄 에러페이지를 지정.
- page Encoding="UTF-8" : 현재 페이지의 문자(한글) 설정.

JSP 페이지의 구성 요소
1. 스크립틀릿 : 가장 일반적으로 JSP 페이지에서 많이 쓰이는 스크립트 요소 . 주로 프로그래밍의 로직을 기술할 때 많이 사용됨.
JSP 페이지에서 자바코드가 작성되는 공간.
형식) <% 자바 코드; %>

2. 표현식 : 일반적으로 JSP 페이지에서 자바의 System.out.println()과 유사하게 사용됨.
데이터를 출력할 때 주로 사용됨.
형식) <%=변수명, 수식 %>

3. 선언문 : 일반적으로 JSP 페이지에서 자바의 멤버변수 또는 멤버 메서드를 선언할 때 사용됨.
형식) <%! 변수 선언 및 메서드 선언 %>
 --%>
 
 <%-- 스크립틀릿: 자바코드가 작성되는 공간 --%>
 <%
 	int su = 10;
 
 	Calendar cal = Calendar.getInstance();
 	
 	//int year = cal.get(Calendar.YEAR);
 	//int month = cal.get(Calendar.MONTH)+1;
 	//int day = cal.get(Calendar.DAY_OF_MONTH);
 %>
 
 <%-- JSP 표현식 : 변수의 값 또는 메서드의 결과값을 출력하는 공간 --%>
 <%=cal.get(Calendar.YEAR) %>년
 <%=cal.get(Calendar.MONTH)+1 %>월
 <%=cal.get(Calendar.DAY_OF_MONTH) %>일
 
 <hr>
 
 <h2>1부터 100까지의 합을 구해보자.</h2>
 <%
 	int sum=0;
 	for(int i=1; i<=100; i++) {
 		sum = sum + i;
 	}
 %>
 
 <h3>1부터 100까지의 합 >>> <%=sum %></h3>
 
 <hr>
 
 <%!
 	// 자바에서 변수 선언 및 메서드를 선언하는 공간
 	public int plus(int a, int b) {
		return a+b;
 	}
 %>
 
 <h3>7+5 =<%=plus(7, 5) %> </h3>
</body>
</html>