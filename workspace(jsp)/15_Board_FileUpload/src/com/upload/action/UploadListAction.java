package com.upload.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upload.model.UploadDAO;
import com.upload.model.UploadDTO;

public class UploadListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// upload 테이블에 있는 전체 레코드를 조회하는 클래스
		
		UploadDAO dao = UploadDAO.getInstance();
		
		List<UploadDTO> list = dao.getUploadList();
		
		// list 데이터를 키로 저장하여 view page로 이동시키자.
		request.setAttribute("upList", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("view/upload_list.jsp");
		
		
		return forward;
		
	}

}
