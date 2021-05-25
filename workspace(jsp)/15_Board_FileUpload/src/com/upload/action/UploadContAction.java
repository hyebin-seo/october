package com.upload.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upload.model.UploadDAO;
import com.upload.model.UploadDTO;

public class UploadContAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get방식으로 넘어온 글번호에 해당하는 글의 상세내역을 조회하는 클래스
		
		int upload_no = 
			Integer.parseInt(request.getParameter("no").trim());
		
		UploadDAO dao = UploadDAO.getInstance();
		
		dao.uploadHit(upload_no);  // 조회수를 증가시켜 주는 메서드 호출
		
		// 글번호에 해당하는 상세내역을 조회하는 메서드 호출
		UploadDTO dto = dao.uploadContent(upload_no);
		
		// 글번호에 해당하는 상세내역을 view page로 이동시켜야 함.
		request.setAttribute("upCont", dto);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("view/upload_content.jsp");
		
		return forward;
		
	}

}
