package service;

import model.Member;

public class MasterSession {
	private static MasterSession MasterSession;
	
	private String master_id;
	private Member master_member;
	
	private MasterSession() { } ;

	public static MasterSession getInstance() {
		try {
			if(MasterSession == null) {
				MasterSession = new MasterSession();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MasterSession;
	}

	public String getMaster_id() {
		return master_id;
	}

	public void setMaster_id(String master_id) {
		this.master_id = master_id;
	}

	public Member getMaster_member() {
		return master_member;
	}

	public void setMaster_member(Member master_member) {
		this.master_member = master_member;
	}

}
