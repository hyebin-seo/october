package service;

import db.DBConnection;
import mainUI.HomeFrame;
import model.Member;

public class OwnerCheck {
	
	Member member;
	
	public OwnerCheck() { }
	
	public OwnerCheck(String master_id, String member_id) {
		MasterSession ms = MasterSession.getInstance();
		
		if(master_id.equals(member_id)) {
			this.member = ms.getMaster_member();
		} else {
			DBConnection dbc = DBConnection.getInstance();
			this.member = dbc.dataOpen(member_id);
		}
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}


}
