package com.board.model;

import java.util.List;

public interface BoardDAO {
	public int getListCount(); 							// 전체 게시물 수 확인 추상메서드
	public List<BoardDTO> getBoardList(PageDTO dto);	// 전체 리스트를 호출하는 추상메서드
	public int insertBoard(BoardDTO dto);				// 게시물 추가 추상 메서드
	public void readCount(int no);						// 조회수 증가 추상 메서드
	public BoardDTO boardCont(int no);					// 게시물 상세 내역 추상 메서드
	public void updateBoard(BoardDTO dto);				// 게시물 수청 추상 메서드
	public int deleteBoard(int no);					// 게시물 삭제 추상 메서드
	public void reSequence(int no);						// 게시물 삭제 시 번호 재정렬 추상 메서드
	public int searchBoardCount(String field, String key); // 검색된 게시물 총 갯수 추상 메서드
	public List<BoardDTO> searchBoardList(PageDTO dto); // 게시물 검색 추상 메서드

}
