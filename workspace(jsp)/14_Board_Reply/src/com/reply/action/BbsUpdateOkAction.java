package com.reply.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;
import com.reply.model.BbsDTO;

public class BbsUpdateOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 수정폼 페이지에서 넘어온 데이터들을 가지고 DB에서 수정하는 클래스
		
		String bbs_writer = request.getParameter("writer").trim();
		String bbs_title = request.getParameter("title").trim();
		String bbs_content = request.getParameter("content").trim();
		String bbs_pwd = request.getParameter("pwd").trim();
		
		// 히든으로 넘어온 데이터들도 받아 주어야 한다.
		int bbs_no = 
			Integer.parseInt(request.getParameter("bbs_no").trim());
		String db_pwd = request.getParameter("db_pwd").trim();
		int nowPage = 
			Integer.parseInt(request.getParameter("page").trim());
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		
		if(bbs_pwd.equals(db_pwd)) {
			BbsDTO dto = new BbsDTO();
			dto.setBoard_no(bbs_no);
			dto.setBoard_writer(bbs_writer);
			dto.setBoard_title(bbs_title);
			dto.setBoard_cont(bbs_content);
			dto.setBoard_pwd(bbs_pwd);
			
			BbsDAO dao = BbsDAO.getInstance();
			int res = dao.updateBbs(dto);
			
			if(res > 0) {
				out.println("<script>");
				out.println("alert('게시물 수정 성공!!!')");
				out.println("</script>");
				forward.setRedirect(true);
				forward.setPath("bbs_cont.do?no="+bbs_no+"&page="+nowPage);
			}else {
				out.println("<script>");
				out.println("alert('게시물 수정 실패!!!')");
				out.println("history.back()");
				out.println("</script>");
			}
		}else {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다. 확인해 주세요~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
