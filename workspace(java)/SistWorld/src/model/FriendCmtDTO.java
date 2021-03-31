package model;

import java.awt.Component;

import javax.swing.JTextArea;

public class FriendCmtDTO extends JTextArea{

	private String nickname;
	private String name;
	private String friendcomment;
	
	public FriendCmtDTO() {
		this.setText(friendcomment+" "+nickname+" "+name);
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFriendcomment() {
		return friendcomment;
	}
	public void setFriendcomment(String friendcomment) {
		this.friendcomment = friendcomment;
	}
	
	
}
