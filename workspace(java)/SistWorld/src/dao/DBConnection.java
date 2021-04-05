package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Member;

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
				member.setHome_title(rs.getString("home_title"));
				member.setHome_skin(rs.getString("home_skin"));
				member.setHome_miniroom(rs.getString("home_miniroom"));
				member.setHome_profile_pic(rs.getString("home_profile_pic"));
				member.setHome_profile_msg(rs.getString("home_profile_msg"));
				member.setHome_music(rs.getString("home_music"));
				
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
				System.out.println("[dbc]:"+member);
				System.out.println("[dbc-id]:"+member.getMember_id());
				System.out.println("[dbc-pw]:"+member.getMember_pw());
				System.out.println("[dbc-name]:"+member.getMember_name());
				System.out.println("[dbc-birth]:"+member.getMember_birth());
				System.out.println("[dbc-gender]:"+member.getMember_gender());
				System.out.println("[dbc-email]:"+member.getMember_email());
				System.out.println("[dbc-title]:"+member.getHome_title());
				System.out.println("[dbc-skin]:"+member.getHome_skin());
				System.out.println("[dbc-room]:"+member.getHome_miniroom());
				System.out.println("[dbc-pic]:"+member.getHome_profile_pic());
				System.out.println("[dbc-msg]:"+member.getHome_profile_msg());
				System.out.println("[dbc-music]:"+member.getHome_music());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}
	
	public int join(Member member) {
		// 회원가입이므로 Default값 설정
		int result = 0;
		String sql = 
				"INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,1,1,1,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, member.getMember_id()); //아이디
			pstmt.setString(2, member.getMember_pw()); //비밀번호
			pstmt.setString(3, member.getMember_name()); //이름
			pstmt.setString(4, member.getMember_birth()); //생년월일
			pstmt.setString(5, member.getMember_gender()); //성별
			pstmt.setString(6, member.getMember_email()); //이메일
			pstmt.setString(7, "쌍용월드에 오신 것을 환영합니다."); //홈페이지 제목
			pstmt.setString(8, "../images/back.jpg"); //스킨
			pstmt.setString(9, "../images/home.JPG"); //미니룸
			pstmt.setString(10, "../images/profile.JPG"); //프로필 사진
			pstmt.setString(11, "쌍용월드에 오신 것을 환영합니다."); //프로필 상태 메시지
			pstmt.setString(12, "../user/admin/adminmusic/buskerbusker_blossom_ending.mp3"); //음악
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				JOptionPane.showMessageDialog(null, member.getMember_id()+"님! 회원가입이 완료 되었습니다.");
			} else {
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.","회원가입", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
