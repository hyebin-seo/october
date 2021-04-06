package model;

import javax.swing.table.DefaultTableModel;

public class FriendCmt extends DefaultTableModel{

	private String nick;
	private String name;
	private String comment;
	
	public FriendCmt(String cmt) {
	}
	
	public FriendCmt(String nick, String name, String comment) {
		this.nick = nick;
		this.name = name;
		this.comment = comment;
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
