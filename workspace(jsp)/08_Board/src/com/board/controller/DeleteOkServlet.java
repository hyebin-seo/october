package com.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAO;

@WebServlet("/deleteOk.do")
public class DeleteOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteOkServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String pwd = request.getParameter("pwd").trim();
		
		BoardDAO dao = BoardDAO.getInstance();
		int res = dao.deleteBoard(board_no, pwd); //글 삭제
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(res > 0) { //성공
			out.println("<script>");
			out.println("alert('게시물 삭제 성공!!!')");
			out.println("location.href='select.do'"); //성공 후 글목록으로
			out.println("</script>");
		} else if(res < 0){ //비밀번호 틀림
			out.println("<script>");
			out.println("alert('비밀번호가 틀렸습니다.')");
			out.println("history.back()"); //실패했으니 뒤로 돌아가기
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('존재하지 않는 게시글입니다.')");
			out.println("history.back()"); //실패했으니 뒤로 돌아가기
			out.println("</script>");
		}
	}

}
