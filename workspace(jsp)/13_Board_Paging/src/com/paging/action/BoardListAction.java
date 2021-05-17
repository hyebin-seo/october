package com.paging.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paging.model.BoardDAO;
import com.paging.model.BoardDTO;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//List<BoardDTO> list = dao.getBoardList();
		//request.setAttribute("List", list);
		
		//페이징
		int rowsize = 3;//한 페이지당 보여질 게시물의 수
		int block = 3;//아래에 보여질 페이지의 최대 수
		int totalRecord = 0; //db상의 게시물 전체 수
		int allPage = 0; //전체 페이지수
		
		int page = 0;// 현재 페이지 변수
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		} else {
			page = 1; //처음으로 전체 게시물을 불러왔을때.
		}
		
		// 해당 페이지에서 시작 번호
		int startNo = (page * rowsize) - (rowsize - 1);
		
		// 해달 페이지에서 마지막 번호
		int endNo = (page * rowsize);
		
		// 해당 페이지의 시작 블럭
		int startBlock = (((page - 1) / block) * block) + 1;
		
		// 해당 페이지의 마지막 블럭
		int endBlock = (((page - 1) / block) * block) + block;
		
		// db의 전체 게시물 수 확인
		BoardDAO dao = BoardDAO.getInstance();
		totalRecord = dao.getListCount();
		
		// 전체 게시물의 수를 한 페이지당 보여질 게시물의 수로 나누어 줌-> 전체페이지
		// 나머지가 있으면 무조건 반올림
		allPage = (int)Math.ceil(totalRecord / (double)rowsize);
		
		if(endBlock > allPage) {
			endBlock = allPage;
		} 
		
		// 페이지에 해당하는 게시물을 가져오는 메서드 호출
		List<BoardDTO> pagelist = dao.getBoardList(page, rowsize);
		
		// 지금까지 페이징 처리 시 작업했던 모든 값들을 키로 저장
		request.setAttribute("page", page);
		request.setAttribute("rowsize", rowsize);
		request.setAttribute("block", block);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("allPage", allPage);
		request.setAttribute("startNo", startNo);
		request.setAttribute("endNo", endNo);
		request.setAttribute("startBlock", startBlock);
		request.setAttribute("endBlock", endBlock);
	}

}
