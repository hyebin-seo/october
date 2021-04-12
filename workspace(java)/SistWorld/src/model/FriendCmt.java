package model;

import javax.swing.table.DefaultTableModel;

public class FriendCmt extends DefaultTableModel{

	private String nick;
	private String name;
	private String comment;
	private String freind_id;
	private String member_id;
	
	public FriendCmt(String cmt) {
	}
	
	public FriendCmt(String freind_id, String nick, String name, String comment) {
		this.nick = nick;
		this.name = name;
		this.comment = comment;
		this.freind_id = freind_id;
	}
	

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getFreind_id() {
		return freind_id;
	}

	public void setFreind_id(String freind_id) {
		this.freind_id = freind_id;
	}

	public String getNick() {
		return nick;
	}
	public void setNick(String nickname) {
		this.nick = nickname;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getcomment() {
		return comment;
	}
	public void setcomment(String comment) {
		this.comment = comment;
	}
	
	
}
