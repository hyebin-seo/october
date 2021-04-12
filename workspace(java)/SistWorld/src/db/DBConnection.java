package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.FriendAsk;
import model.Member;
import service.MasterSession;

public class DBConnection {

	private static DBConnection dbc;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "web";
	String password = "1234";

	Connection con = null; // DB와 연결 객체
	PreparedStatement pstmt = null; // sql문을 전송하는 객체
	ResultSet rs = null; // sql 실행 결과를 가지고 있는 객체
	
	private DBConnection() {
		init();
	}
	
	public static DBConnection getInstance() {
		try {
			if(dbc == null) {
				dbc = new DBConnection();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dbc;
	}
	
	//드라이버 로딩
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!!");
			
			con = DriverManager.getConnection(url, user, password);
			
			if(con != null) {
				System.out.println("데이터 베이스와 연결 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//비밀번호 일치 체크
	public boolean loginCheck(String member_id, String member_pw) {
		
		String sql = "select * from member where member_id = ? and member_pw = ?";

		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member_id);
			pstmt.setString(2, member_pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //해당 유저가 존재할 때
				return true;
			} else { //유저 존재하지 않을 때
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	
	//멤버 데이터 오픈
	public Member dataOpen(String member_id) {
		String sql = "select * from member where member_id = ?";
		Member member = new Member();
		
		// 5. 데이터를 가져와서 출력
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_birth(rs.getString("member_birth").substring(0, 10));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_email(rs.getString("member_email"));
				member.setMember_regdate(rs.getString("member_regdate"));;
				member.setHome_title(rs.getString("home_title"));
				member.setHome_skin(rs.getString("home_skin"));
				member.setHome_miniroom(rs.getString("home_miniroom"));
				member.setHome_profile_pic(rs.getString("home_profile_pic"));
				member.setHome_profile_msg(rs.getString("home_profile_msg"));

				if(rs.getInt("home_diary") == 1) {
					member.setHome_diary(true);
				} else {
					member.setHome_diary(false);
				}
				
				if(rs.getInt("home_gallery") == 1) {
					member.setHome_gallery(true);
				} else {
					member.setHome_gallery(false);
				}
				
				if(rs.getInt("home_book") == 1) {
					member.setHome_book(true);
				} else {
					member.setHome_book(false);
				}
				
				//객체 생성 데이터 확인
//				System.out.println("[dbc]:"+member);
//				System.out.println("[dbc-id]:"+member.getMember_id());
//				System.out.println("[dbc-pw]:"+member.getMember_pw());
//				System.out.println("[dbc-name]:"+member.getMember_name());
//				System.out.println("[dbc-birth]:"+member.getMember_birth());
//				System.out.println("[dbc-gender]:"+member.getMember_gender());
//				System.out.println("[dbc-email]:"+member.getMember_email());
//				System.out.println("[dbc-regdate]:"+member.getMember_regdate());
//				System.out.println("[dbc-title]:"+member.getHome_title());
//				System.out.println("[dbc-skin]:"+member.getHome_skin());
//				System.out.println("[dbc-room]:"+member.getHome_miniroom());
//				System.out.println("[dbc-pic]:"+member.getHome_profile_pic());
//				System.out.println("[dbc-msg]:"+member.getHome_profile_msg());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}
	
	//회원가입
	public int join(Member member) {
		// 회원가입이므로 Default값 설정
		int result = 0;
		String sql = 
				"INSERT INTO MEMBER(MEMBER_ID,MEMBER_PW,MEMBER_NAME,MEMBER_BIRTH,MEMBER_GENDER,MEMBER_EMAIL)" + 
				"VALUES(?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getMember_id()); //아이디
			pstmt.setString(2, member.getMember_pw()); //비밀번호
			pstmt.setString(3, member.getMember_name()); //이름
			pstmt.setString(4, member.getMember_birth()); //생년월일
			pstmt.setString(5, member.getMember_gender()); //성별
			pstmt.setString(6, member.getMember_email()); //이메일
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				JOptionPane.showMessageDialog(null, member.getMember_name()+"님! 회원가입이 완료 되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.","회원가입", JOptionPane.ERROR_MESSAGE);
			}
			
			String cresql = "CREATE TABLE "+member.getMember_id()+"_FRIEND("+ 
					"FRIEND_INDEX NUMBER(7,0) PRIMARY KEY,"+ 
					"MEMBER_ID VARCHAR2(50) NOT NULL,"+
					"MEMBER_NAME VARCHAR2(50) NOT NULL,"+
					"MEMBER_NICK VARCHAR2(50) NOT NULL,"+ 
					"FRIEND_ID VARCHAR2(50) NOT NULL,"+
					"FRIEND_NAME VARCHAR2(50) NOT NULL,"+ 
					"FRIEND_NICK VARCHAR2(50) NOT NULL,"+
					"FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER(MEMBER_ID) ON DELETE CASCADE)";

			Statement stmt = con.createStatement();
			stmt.execute(cresql);
			
			System.out.println(member.getMember_id()+"_friend 테이블 생성");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//아이디 중복체크
	public int overCheck(String join_id) {
		String sql = 
				"SELECT COUNT(*) cnt FROM MEMBER WHERE MEMBER_ID =?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, join_id); //아이디
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int cnt = rs.getInt("cnt");
				if(cnt > 0) {
					return 2; //중복 아이디
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 1; //사용가능한 아이디
	}
	
	public boolean memberCheck(String friend_id) {
		String sql = 
				"SELECT COUNT(*) cnt FROM MEMBER WHERE MEMBER_ID =?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, friend_id); //아이디
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int cnt = rs.getInt("cnt");
				if(cnt > 0) {
					return true; //존재하는 회원
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false; //존재하지 않는 회원
	}
	
	//회원탈퇴
	public int out(Member member) {
	
		int result = 0;
		String sql = 
				"DELETE FROM MEMBER WHERE MEMBER_ID =?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getMember_id()); //아이디
			
			result = pstmt.executeUpdate();
			
			String dropsql = "DROP TABLE "+member.getMember_id()+"_FRIEND";

			Statement stmt = con.createStatement();
			stmt.execute(dropsql);
			
			System.out.println(member.getMember_id()+"_friend 테이블 삭제");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//일촌평 불러오기
	public DefaultTableModel friendCmt(String member_id) {
		String[] header = {"friend_id","cmt","nick","name"};
		DefaultTableModel cmtModel= new DefaultTableModel(header, 0){  //셀 수정 못하게 하는 부분
			 public boolean isCellEditable(int row, int column){
			    return false;
			 }
		};

		String sql = "select * from friendcmt "
				+ "where member_id = ? order by friendcmt_index desc";
		
		// 5. 데이터를 가져와서 출력
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String friend_id = rs.getString("friend_id");
				String cmt = rs.getString("FREIND_CMT");
				String nick = "("+rs.getString("FRIEND_NICK")+")";
				String name = rs.getString("FRIEND_NAME");
				Object[] data = {friend_id, cmt, nick, name};
				
				cmtModel.addRow(data);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cmtModel;
	}
	
	//일촌평 추가
	public int addFreindCmt(String member_id, String freind_id, String cmt) {
		int result = 0;
		
		try {
			String sql = "select * from "+member_id+"_friend "
					+ "where friend_id = ? and member_id = ?";
			
			System.out.println(sql);
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, freind_id);
			pstmt.setString(2, member_id);
			rs = pstmt.executeQuery();

			String friend_name = "";
			String friend_nick = "";
			
			while(rs.next()) {
				friend_name = rs.getString("friend_name");
				friend_nick = rs.getString("friend_nick");
			}
			
			String sql2 = "insert into friendcmt "
					+ "values(FRIENDCMT_SEQ.nextval,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql2);

			pstmt.setString(1, member_id);
			pstmt.setString(2, freind_id); //세션
			pstmt.setString(3, friend_name);
			pstmt.setString(4, friend_nick);
			pstmt.setString(5, cmt);
			
			result = pstmt.executeUpdate();
			
			if(result>0) {
				return result;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return result;
	}
	
	//내정보수정
	public int modifyMyInfo(Member member) {

		int result = 0;
		String sql = 
				"update member set member_email = ?, member_pw = ? where member_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getMember_email());
			pstmt.setString(2, member.getMember_pw());
			pstmt.setString(3, member.getMember_id());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//스킨 초기화
	public int skinReset(Member member) {

		int result = 0;
		String sql = 
				"update member set home_skin = ? where member_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "../SistWorld/data/images/back.jpg");
			pstmt.setString(2, member.getMember_id());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				MasterSession ms = MasterSession.getInstance();
				ms.setMaster_member(dataOpen(member.getMember_id()));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//메뉴 수정
	public int modifyMyMenu(Member member) {

		int result = 0;
		String sql = 
				"update member set HOME_DIARY =?, HOME_GALLERY =?, HOME_BOOK =? where member_id = ?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, member.isHome_diary() ? 1 : 0); 
			pstmt.setInt(2, member.isHome_gallery() ? 1 : 0); 
			pstmt.setInt(3, member.isHome_book() ? 1 : 0); 
			pstmt.setString(4, member.getMember_id()); 
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				MasterSession ms = MasterSession.getInstance();
				ms.setMaster_member(dataOpen(member.getMember_id()));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//개인 정보 설정
	public Member modifyMySetting(String flag, Member member) {

		int result = 0;
		String sql = "";

		try {

			if(flag.equals("msg")) {
				sql = "update member set HOME_PROFILE_MSG =? where member_id = ?";
			} else if(flag.equals("pic")) {
				sql = "update member set HOME_PROFILE_PIC =? where member_id = ?";
			} else if(flag.equals("miniroom")) {
				sql = "update member set HOME_MINIROOM =? where member_id = ?";
			} else if(flag.equals("skin")) {
				sql = "update member set HOME_SKIN =? where member_id = ?";
			}
			
			pstmt = con.prepareStatement(sql);
			
			if(flag.equals("msg")) {
				pstmt.setString(1, member.getHome_profile_msg()); 
			} else if(flag.equals("pic")) {
				pstmt.setString(1, member.getHome_profile_pic()); 
			} else if(flag.equals("miniroom")) {
				pstmt.setString(1, member.getHome_miniroom()); 
			} else if(flag.equals("skin")) {
				pstmt.setString(1, member.getHome_skin()); 
			}

			pstmt.setString(2, member.getMember_id());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				Member modifyMember = dataOpen(member.getMember_id());
				MasterSession ms = MasterSession.getInstance();
				ms.setMaster_member(modifyMember);
				return modifyMember;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}
	
	//파도타기
	public String surfer() {
		
		// 데이터베이스에 저장된 아이디 무작위 추출
		String sql = 
				"select member_id from"
				+ "(select member_id from member order by dbms_random.value)"
				+ "where rownum <= 1";
		String memeber_id = "";
		
		try {
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memeber_id = rs.getString("member_id");
				return memeber_id;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memeber_id;
	}
	
	// 일촌 여부
	public int friendCheck(String homepage_id, String visitor_id) {
		int result = 0;
		
		try {
			String sql = "select * from "+homepage_id+"_friend where friend_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, visitor_id);

			result = pstmt.executeUpdate();
			
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//일촌 신청
	public int friendAsk(String flag, FriendAsk ask) {
		int result = 0;
		
		try {
			
			if(flag.equals("신청")) {
				String sql = "insert into friend_waiting "
						+ "values(friend_waiting_seq.nextval,?,?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, ask.getMember_id());
				pstmt.setString(2, ask.getMember_name());
				pstmt.setString(3, ask.getMember_nick());
				pstmt.setString(4, ask.getFriend_id());
				pstmt.setString(5, ask.getFriend_name());
				pstmt.setString(6, ask.getFriend_nick());

			} else if(flag.equals("조회")) {
				String sql = "select * from friend_waiting where member_id = ? and friend_id = ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, ask.getMember_id());
				pstmt.setString(2, ask.getFriend_id());
			}
			
			result = pstmt.executeUpdate();
			
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//대기중인 일촌 신청, 현재 일촌 가져오기
	public DefaultTableModel friend(String flag, String member_id) {
		String[] header = {"member_id","나의 이름","나의 일촌명","friend_id","일촌 신청한 사람","신청한 일촌명"};
		DefaultTableModel model= new DefaultTableModel(header, 0){  //셀 수정 못하게 하는 부분
			 public boolean isCellEditable(int row, int column){
			    return false;
			 }
		};

		String sql = "";
		
		try {
			
			if(flag.equals("대기")) {
				sql = "select * from friend_waiting where member_id = ? or friend_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member_id);
				pstmt.setString(2, member_id);
			
			} else if(flag.equals("일촌")){
				sql = "select * from "+member_id+"_friend";
				pstmt = con.prepareStatement(sql);
			}
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String mem_id = rs.getString("member_id");
				String member_name = rs.getString("member_name");
				String member_nick = rs.getString("member_nick");
				String friend_id = rs.getString("friend_id");
				String friend_name = rs.getString("friend_name");
				String friend_nick = rs.getString("friend_nick");
				Object[] data = new Object[6];
				if(mem_id.equals(member_id)) {
					data[0] = mem_id;
					data[1] = member_name;
					data[2] = member_nick;
					data[3] = friend_id;
					data[4] = friend_name;
					data[5] = friend_nick;
				}else {
					data[0] = friend_id;
					data[1] = friend_name;
					data[2] = friend_nick;
					data[3] = mem_id;
					data[4] = member_name;
					data[5] = member_nick;
				}
				
				model.addRow(data);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	//일촌 수락 or 거절
	public int friendAcceptOrDeny(String flag, FriendAsk ask) {
		int result = 0;
		
		try {
			if(flag.equals("수락")) {
				String sql = "insert into "+ask.getMember_id()+"_friend "
						+ "values(FRIEND_SEQ.nextval,?,?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
		
				pstmt.setString(1, ask.getMember_id());
				pstmt.setString(2, ask.getMember_name());
				pstmt.setString(3, ask.getMember_nick());
				pstmt.setString(4, ask.getFriend_id());
				pstmt.setString(5, ask.getFriend_name());
				pstmt.setString(6, ask.getFriend_nick());
				
				result = pstmt.executeUpdate();
				
				String sql2 = "insert into "+ask.getFriend_id()+"_friend "
						+ "values(FRIEND_SEQ.nextval,?,?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql2);
		
				pstmt.setString(1, ask.getFriend_id());
				pstmt.setString(2, ask.getFriend_name());
				pstmt.setString(3, ask.getFriend_nick());
				pstmt.setString(4, ask.getMember_id());
				pstmt.setString(5, ask.getMember_name());
				pstmt.setString(6, ask.getMember_nick());
				
				result = pstmt.executeUpdate();
			
				if(result>0) {
					String delsql = "delete from friend_waiting where member_id = ? and friend_id =?";
					
					pstmt = con.prepareStatement(delsql);
					
					pstmt.setString(1, ask.getMember_id());
					pstmt.setString(2, ask.getFriend_id());
					
					result = pstmt.executeUpdate();
					
					return result;
				}
				
			} else if(flag.equals("거절")) {
				String denysql = "delete from friend_waiting where member_id = ? and friend_id =?";
				
				pstmt = con.prepareStatement(denysql);
				
				pstmt.setString(1, ask.getMember_id());
				pstmt.setString(2, ask.getFriend_id());
				
				result = pstmt.executeUpdate();
				
				return result;
			} else if(flag.equals("삭제")) {
				String delsql = "delete from "+ask.getMember_id()+"_friend where friend_id =?";
				
				pstmt = con.prepareStatement(delsql);

				pstmt.setString(1, ask.getFriend_id());
				
				result = pstmt.executeUpdate();
				
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
