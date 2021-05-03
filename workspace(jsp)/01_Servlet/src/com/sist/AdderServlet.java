package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 요청과 관련된 API : javax.servlet.http.HttpServletRequest 인터페이스
 * 응답과 관련된 API : javax.servlet.http.HttpServletResponse 인터페이스
 * 1. 클라이언트가 서블릿에 요청을 하면 먼저 톰캣 서버가 해당 요청을 받음.
 * 2. 그런 다음 사용자의 요청이나 응답에 대한 HttpServletRequest 객체와
 *    HttpServletResponse 객체를 만들게 됨.
 * 3. 그리고 난 후 Servlet의 doGet() 메서드나 doPost() 메서드를 호출
 *    하면서 이 객체들을 전달함.
 * 4. 톰캣이 사용자의 요청에 대한 정보를 모든 HttpServletRequest 객체의
 *    속성으로 담아 메서드로 전달함. 따라서 각 HttpServletRequest에서
 *    제공하는 메서드들은 매개변수로 넘어온 객체들을 이용하여 사용자가 전송한
 *    데이터를 받아오거나 응답을 할 수 있는 것임.
 * 
 * 서블릿에서 클라이언트의 요청을 얻는 방법
 * - HttpServletRequest 클래스에서 <form> 태그로 전송된 데이터를  받아
 *   오는데 사용되는 메서드
 *   * getParameter(String name) => <form> 태그의 name 속성에
 *          들어간 변수명을 받아서 사용을 함. 반환형은 String 타입임.
 *   * getParameterValues(String name) ==> <form> 태그의 같은
 *           name에 대하여 여러 개의 값을 얻을 때 사용함.
 *           반환형은 String[] 배열 타입임.
 *           
 * 서블릿에서 요청 받은 내용을 처리하여 클라이언트에 보내는 방법.
 * 1. HttpServletResponse 객체를 이용하여 응답을 함.
 * 2. doGet()이나 doPost() 메서드 안에서 처리함.
 * 3. javax.servlet.http.HttpServletResponse 객체를 이용함.
 * 4. setContentType() 메서드를 이용하여 클라이언트에게 전송할
 *    데이터의 종류(MIME-TYPE)를 지정함.
 * 5. 클라이언트(웹 브라우저)와 서블릿의 통신은 자바 I/O의 스트림을 이용함.
 * 
 * 웹 브라우저에서 서블릿으로 데이터를 전송하는 방법 - 2가지
 * 1. get 방식
 *    - 서블릿에 데이터를 전송할 때는 데이터가 url 뒤에 name=value 형태로 전송이 됨.
 *    - 여러 개의 데이터를 전송할 때는 '&'로 구분하여 전송이 됨.
 *    - 보안이 취약함.
 *    - 전송할 수 있는 데이터는 최대 255자.
 *    - 기본 전송 방식이고 사용이 쉬움.
 *    - 웹 브라우저에 직접 입력해서 전송할 수도 있음.
 *    - 서블릿에서는 doGet() 메서드에서 전송된 데이터를 처리함.
 * 2. post 방식
 *    - 서블릿에 데이터를 전송할 때는  TCP/IP 프로토콜 데이터의 head 영역에
 *      숨겨진 채 전송이 됨.
 *    - 보안에 유리함.
 *    - 전송 데이터의 용량이 무제한임.
 *    - 처리 속도가 get 방식보다 느림.
 *    - 서블릿에서는 doPost() 메서드에서 전송된 데이터를 처리함.
 */

@WebServlet("/adder")
public class AdderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdderServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form 태그에서 method="get"인 경우 실행되는 메서드
		// request : 첫번쨰 매개변수
		//           사용자(클라이언트)의 요청에 대한 정보를 처리
		// response : 두번째 매개변수
		//            요청 정보에 대한 처리 결과를 클라이언트에 응답 처리
		
		// 1단계 : 클라이언트에서 넘어온 데이터를 받기 - 사용자가 전송한 데이터를 받기
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		// 응답 시 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		// 2단계: 처리한 결과를 클라이언트 웹 브라우저에 출력하는 작업.
		PrintWriter out = response.getWriter(); 
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h1>두 수의 합 >>> " + (num1+num2)+"</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
