package com.board.model;

// DB 상의 board 테이블의 컬럼과 동일하게 멤버변수 구성

public class BoardDTO {
  
	private int board_no;               // 게시글 글번호
	private String board_writer;        // 게시글 작성자
	private String board_title;         // 게시글 글제목
	private String board_cont;          // 게시글 글내용
	private String board_pwd;           // 게시글 비밀번호
	private int board_hit;              // 게시글 조회수
	private String board_regdate;       // 게시글 작성일자
	
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_cont() {
		return board_cont;
	}
	public void setBoard_cont(String board_cont) {
		this.board_cont = board_cont;
	}
	public String getBoard_pwd() {
		return board_pwd;
	}
	public void setBoard_pwd(String board_pwd) {
		this.board_pwd = board_pwd;
	}
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public String getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}
	
	
} 
