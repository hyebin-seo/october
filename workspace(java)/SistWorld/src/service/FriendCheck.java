package service;

import db.DBConnection;

public class FriendCheck {
	
	DBConnection dbc = DBConnection.getInstance();
	
	private String homepage_id;
	private String visitor_id;
	
	public FriendCheck(String homepage_id, String visitor_id) {
		this.homepage_id = homepage_id;
		this.visitor_id = visitor_id;
	}
	
	public int FriendCheckR() {
		return dbc.friendCheck(homepage_id, visitor_id);
	}

}
