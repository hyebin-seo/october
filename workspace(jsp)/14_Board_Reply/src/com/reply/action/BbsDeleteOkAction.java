package com.reply.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reply.model.BbsDAO;
import com.reply.model.BbsDTO;

public class BbsDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 삭제폼 페이지에서 넘어온 데이터들을 가지고 DB에서 해당 게시글을 삭제하는 클래스.
		
		String bbs_pwd = request.getParameter("pwd").trim();
		
		// 히든으로 넘어온 데이터들도 처리해 주어야 한다.
		int bbs_no = 
			Integer.parseInt(request.getParameter("bbs_no").trim());
		
		int nowPage = 
			Integer.parseInt(request.getParameter("page").trim());
		int bbs_group =
			Integer.parseInt(request.getParameter("group").trim());
		
		int bbs_step =
				Integer.parseInt(request.getParameter("step").trim());
		
		BbsDTO dto = new BbsDTO();
		dto.setBoard_no(bbs_no);
		dto.setBoard_pwd(bbs_pwd);
		dto.setBoard_group(bbs_group);
		dto.setBoard_step(bbs_step);
		
		BbsDAO dao = BbsDAO.getInstance();
		
		int res = dao.deleteBBs(dto);
		dao.updateNo(bbs_no);
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		
		if(res > 0) {
			forward.setRedirect(true);
			forward.setPath("bbs_list.do?page="+nowPage);
		}else if(res == -1) {  // 비밀번호가 틀린 경우
			out.println("<script>");
			out.println("alert('비밀번호 오류!! 확인해 주세요..')");
			out.println("history.back()");
			out.println("</script>");
		}else if(res == -2) {  // 답글이 있는 경우
			out.println("<script>");
			out.println("alert('답글 삭제 후에 원글을 삭제해 주세요..')");
			out.println("location.href='bbs_cont.do?no="+bbs_no+"&page="+nowPage+"'");
			out.println("</script>");
		}
		else {
			out.println("<script>");
			out.println("alert('게시물 삭제 실패~~~')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
