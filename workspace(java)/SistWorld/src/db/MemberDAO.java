package db;

import java.util.HashMap;

import model.Member;

public class MemberDAO extends HashMap<String, Member>{
	
	private static MemberDAO MemberDAO;
	
	private MemberDAO() { } ;
	
//	private MemberDAO() throws Exception {
//		init();
//	}
	
	public static MemberDAO getInstance() {
		try {
			if(MemberDAO == null) {
				MemberDAO = new MemberDAO();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MemberDAO;
	}
}
