package com.sist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ��û�� ���õ� API : javax.servlet.http.HttpServletRequest �������̽�
 * ����� ���õ� API : javax.servlet.http.HttpServletResponse �������̽�
 * 1. Ŭ���̾�Ʈ�� ������ ��û�� �ϸ� ���� ��Ĺ ������ �ش� ��û�� ����.
 * 2. �׷� ���� ������� ��û�̳� ���信 ���� HttpServletRequest ��ü��
 *    HttpServletResponse ��ü�� ����� ��.
 * 3. �׸��� �� �� Servlet�� doGet() �޼��峪 doPost() �޼��带 ȣ��
 *    �ϸ鼭 �� ��ü���� ������.
 * 4. ��Ĺ�� ������� ��û�� ���� ������ ��� HttpServletRequest ��ü��
 *    �Ӽ����� ��� �޼���� ������. ���� �� HttpServletRequest����
 *    �����ϴ� �޼������ �Ű������� �Ѿ�� ��ü���� �̿��Ͽ� ����ڰ� ������
 *    �����͸� �޾ƿ��ų� ������ �� �� �ִ� ����.
 * 
 * �������� Ŭ���̾�Ʈ�� ��û�� ��� ���
 * - HttpServletRequest Ŭ�������� <form> �±׷� ���۵� �����͸�  �޾�
 *   ���µ� ���Ǵ� �޼���
 *   * getParameter(String name) => <form> �±��� name �Ӽ���
 *          �� �������� �޾Ƽ� ����� ��. ��ȯ���� String Ÿ����.
 *   * getParameterValues(String name) ==> <form> �±��� ����
 *           name�� ���Ͽ� ���� ���� ���� ���� �� �����.
 *           ��ȯ���� String[] �迭 Ÿ����.
 *           
 * �������� ��û ���� ������ ó���Ͽ� Ŭ���̾�Ʈ�� ������ ���.
 * 1. HttpServletResponse ��ü�� �̿��Ͽ� ������ ��.
 * 2. doGet()�̳� doPost() �޼��� �ȿ��� ó����.
 * 3. javax.servlet.http.HttpServletResponse ��ü�� �̿���.
 * 4. setContentType() �޼��带 �̿��Ͽ� Ŭ���̾�Ʈ���� ������
 *    �������� ����(MIME-TYPE)�� ������.
 * 5. Ŭ���̾�Ʈ(�� ������)�� ������ ����� �ڹ� I/O�� ��Ʈ���� �̿���.
 * 
 * �� ���������� �������� �����͸� �����ϴ� ��� - 2����
 * 1. get ���
 *    - ������ �����͸� ������ ���� �����Ͱ� url �ڿ� name=value ���·� ������ ��.
 *    - ���� ���� �����͸� ������ ���� '&'�� �����Ͽ� ������ ��.
 *    - ������ �����.
 *    - ������ �� �ִ� �����ʹ� �ִ� 255��.
 *    - �⺻ ���� ����̰� ����� ����.
 *    - �� �������� ���� �Է��ؼ� ������ ���� ����.
 *    - ���������� doGet() �޼��忡�� ���۵� �����͸� ó����.
 * 2. post ���
 *    - ������ �����͸� ������ ����  TCP/IP �������� �������� head ������
 *      ������ ä ������ ��.
 *    - ���ȿ� ������.
 *    - ���� �������� �뷮�� ��������.
 *    - ó�� �ӵ��� get ��ĺ��� ����.
 *    - ���������� doPost() �޼��忡�� ���۵� �����͸� ó����.
 */

@WebServlet("/adder")
public class AdderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdderServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form �±׿��� method="get"�� ��� ����Ǵ� �޼���
		// request : ù���� �Ű�����
		//           �����(Ŭ���̾�Ʈ)�� ��û�� ���� ������ ó��
		// response : �ι�° �Ű�����
		//            ��û ������ ���� ó�� ����� Ŭ���̾�Ʈ�� ���� ó��
		
		// 1�ܰ� : Ŭ���̾�Ʈ���� �Ѿ�� �����͸� �ޱ� - ����ڰ� ������ �����͸� �ޱ�
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		// ���� �� �ѱ� ó��
		response.setContentType("text/html; charset=UTF-8");
		// 2�ܰ�: ó���� ����� Ŭ���̾�Ʈ �� �������� ����ϴ� �۾�.
		PrintWriter out = response.getWriter(); 
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h1>�� ���� �� >>> " + (num1+num2)+"</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
