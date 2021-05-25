package com.upload.model;

// upload 테이블의 컬럼과 동일하게 멤버 구성

public class UploadDTO {

	private int upload_no;
	private String upload_writer;
	private String upload_title;
	private String upload_cont;
	private String upload_pwd;
	private String upload_file;
	private int upload_hit;
	private String upload_date;
	
	
	
	public int getUpload_no() {
		return upload_no;
	}
	public void setUpload_no(int upload_no) {
		this.upload_no = upload_no;
	}
	public String getUpload_writer() {
		return upload_writer;
	}
	public void setUpload_writer(String upload_writer) {
		this.upload_writer = upload_writer;
	}
	public String getUpload_title() {
		return upload_title;
	}
	public void setUpload_title(String upload_title) {
		this.upload_title = upload_title;
	}
	public String getUpload_cont() {
		return upload_cont;
	}
	public void setUpload_cont(String upload_cont) {
		this.upload_cont = upload_cont;
	}
	public String getUpload_pwd() {
		return upload_pwd;
	}
	public void setUpload_pwd(String upload_pwd) {
		this.upload_pwd = upload_pwd;
	}
	public String getUpload_file() {
		return upload_file;
	}
	public void setUpload_file(String upload_file) {
		this.upload_file = upload_file;
	}
	public int getUpload_hit() {
		return upload_hit;
	}
	public void setUpload_hit(int upload_hit) {
		this.upload_hit = upload_hit;
	}
	public String getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(String upload_date) {
		this.upload_date = upload_date;
	}
	
	
	
}
