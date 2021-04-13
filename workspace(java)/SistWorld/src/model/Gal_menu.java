package model;

import java.util.Date;

public class Gal_menu {
	int menu_id;
	String menu_name;
	Date menu_regdate;
	String member_id;
	
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public Date getMenu_regdate() {
		return menu_regdate;
	}
	public void setMenu_regdate(Date menu_regdate) {
		this.menu_regdate = menu_regdate;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
}
