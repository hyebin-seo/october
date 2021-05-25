package com.reply.model;

// jsp_bbs 테이블의 컬럼과 동일하게 멤버 구성

public class BbsDTO {

	private int board_no;
	private String board_writer;
	private String board_title;
	private String board_cont;
	private String board_pwd;
	private int board_hit;
	private String board_date;
	private int board_group;
	private int board_step;
	private int board_indent;
	
	
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
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public int getBoard_group() {
		return board_group;
	}
	public void setBoard_group(int board_group) {
		this.board_group = board_group;
	}
	public int getBoard_step() {
		return board_step;
	}
	public void setBoard_step(int board_step) {
		this.board_step = board_step;
	}
	public int getBoard_indent() {
		return board_indent;
	}
	public void setBoard_indent(int board_indent) {
		this.board_indent = board_indent;
	}
	
	
	
}
