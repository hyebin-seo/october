package com.reply.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;

public class BbsDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String board_pwd = request.getParameter("pwd").trim();

		int no = Integer.parseInt(request.getParameter("no").trim());
		int nowPage = Integer.parseInt(request.getParameter("page").trim());

		BbsDAO dao = BbsDAO.getInstance();

		int res = dao.deleteBoard(no, board_pwd);
		//board 테이블의 글 번호를 수정하는 메서드
		dao.updateNo(no);

		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();

		if (res > 0) {
			out.println("<script>");
			out.println("alert('게시물 삭제 성공! 첫페이지로 돌아갑니다.')");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("bbs_list.do");
		} else if (res == -1) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다. 확인해 주세요!')");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("bbs_delete.do?no="+no+"&page="+nowPage);
		} else {
			out.println("<script>");
			out.println("alert('게시물 삭제 실패!')");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("bbs_delete.do?no="+no+"&page="+nowPage);
		}
		
		return forward;
	}

}
