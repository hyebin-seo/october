package model;

public class GuestBookDTO {

	private int gb_id;
	private String screat_at;
	private String member_id;
	private String host_id;
	private String content;
	private String create_date;
	
	public int getGb_id() {
		return gb_id;
	}
	public void setGb_id(int gb_id) {
		this.gb_id = gb_id;
	}
	public String getScreat_at() {
		return screat_at;
	}
	public void setScreat_at(String screat_at) {
		this.screat_at = screat_at;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getHost_id() {
		return host_id;
	}
	public void setHost_id(String host_id) {
		this.host_id = host_id;
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
		return "GuestBookDTO [gb_id=" + gb_id + ", screat_at=" + screat_at + ", member_id=" + member_id + ", host_id="
				+ host_id + ", content=" + content + ", create_date=" + create_date + "]";
	}
	
	
	
	
}
