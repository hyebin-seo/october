package model;

public class GuestBookCommDTO {

	private int gb_id;
	private int comment_id;
	private String writer;
	private String content;
	private String create_date;
	public int getGb_id() {
		return gb_id;
	}
	public void setGb_id(int gb_id) {
		this.gb_id = gb_id;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	
	@Override
	public String toString() {
		return "GuestBookCommDTO [gb_id=" + gb_id + ", comment_id=" + comment_id + ", writer=" + writer + ", content="
				+ content + ", create_date=" + create_date + "]";
	}
	
	
	
	
	
	
	
}
