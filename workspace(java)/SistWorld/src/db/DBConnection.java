package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.DiaryDTO;
import model.FriendAsk;
import model.Gal_1;
import model.Gal_menu;
import model.GuestBookCommDTO;
import model.GuestBookDTO;
import model.Member;
import service.MasterSession;

public class DBConnection {

	private static DBConnection dbc;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "web"; //현재 데이터 베이스 명
	String password = "1234";

	Connection con = null; //DB와 연결 객체
	PreparedStatement pstmt = null; //sql문을 전송하는 객체
	ResultSet rs = null; //sql 실행 결과를 가지고 있는 객체
	
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
	
	public void close() {
		try {
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	//*************************로그인&회원가입 관련 메소드 시작************************
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
	//*************************로그인&회원가입 관련 메소드 종료************************
	
	//*************************메인&디테일 홈패널 관련 메소드 시작************************
	//일촌평 불러오기
	public DefaultTableModel friendCmt(String member_id) {
		String[] header = {"index","friend_id","cmt","nick","name"};
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
				int index = rs.getInt("FRIENDCMT_INDEX");
				String friend_id = rs.getString("friend_id");
				String cmt = rs.getString("FRIEND_CMT");
				String nick = "("+rs.getString("FRIEND_NICK")+")";
				String name = rs.getString("FRIEND_NAME");
				Object[] data = {index, friend_id, cmt, nick, name};
				
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
	
	//일촌평 삭제
	public int delFriendCmt(int index) {
		String sql = 
				"DELETE FROM friendcmt WHERE FRIENDCMT_INDEX =?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, index); //일촌평 인덱스
			
			result = pstmt.executeUpdate();

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//일촌평 클릭으로 파도타기 시 존재하는 회원체크
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
	
	//파도타기
	public String surfer(String member_id) {
		
		// 데이터베이스에 저장된 아이디 무작위 추출
		String sql = 
				"select member_id "
				+ "from (select member_id from member "
				+ "where member_id <> ? and member_id "
				+ "NOT IN (select friend_id from "
				+ member_id + "_friend)"
				+ "order by dbms_random.value"
				+ ") where rownum <= 1";
		String memeber_id = "";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id); //아이디
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
	//*************************메인&디테일 홈패널 관련 메소드 종료************************
	
	//********************설정(내정보,커스텀,일촌)관련 메소드 시작************************
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
		String[] header = {"member_id","나의 이름","나의 일촌명","friend_id","일촌 신청한 사람","일촌명"};
		if(flag.equals("대기")) {
			header[0] = "member_id";
			header[1] = "나의 이름";
			header[2] = "제안한 일촌명";
			header[3] = "friend_id";
			header[4] = "제안한 사람";
			header[5] = "제안한 일촌명";
		} else if(flag.equals("일촌")){
			header[0] = "member_id";
			header[1] = "나의 이름";
			header[2] = "일촌명";
			header[3] = "friend_id";
			header[4] = "일촌";
			header[5] = "일촌명";
		} else if(flag.equals("전송")) {
			header[0] = "member_id";
			header[1] = "나의 이름";
			header[2] = "신청한 일촌명";
			header[3] = "friend_id";
			header[4] = "신청한 일촌";
			header[5] = "신청한 일촌명";
		}
		DefaultTableModel model= new DefaultTableModel(header, 0){  //셀 수정 못하게 하는 부분
			 public boolean isCellEditable(int row, int column){
			    return false;
			 }
		};

		String sql = "";
		
		try {
			
			if(flag.equals("대기")) {
				sql = "select * from friend_waiting where member_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member_id);	
			} else if(flag.equals("일촌")){
				sql = "select * from "+member_id+"_friend";
				pstmt = con.prepareStatement(sql);
			} else if(flag.equals("전송")) {
				sql = "select * from friend_waiting where friend_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member_id);
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
				if(flag.equals("대기")||flag.equals("일촌")) {
					data[0] = mem_id;
					data[1] = member_name;
					data[2] = member_nick;
					data[3] = friend_id;
					data[4] = friend_name;
					data[5] = friend_nick;
				} else if(flag.equals("전송")) {
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
	//********************설정(내정보,커스텀,일촌)관련 메소드 종료************************
	
	//**************************다이어리 관련 메소드 시작******************************
	// DB에서 글 번호에 맞는 정보를 받아오는 메서드
	public DiaryDTO getDiaryDTO(int diary_index) {

		DiaryDTO dto = new DiaryDTO();

		try {
			String sql = "select * from diary where diary_index=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, diary_index);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setDiary_index(rs.getInt("diary_index"));
				dto.setDiary_title(rs.getString("diary_title"));
				dto.setDiary_cont(rs.getString("diary_cont"));
				dto.setDiary_date(rs.getString("diary_date"));
				dto.setDiary_week(rs.getString("diary_week"));
				dto.setDiary_mood(rs.getString("diary_mood"));
				dto.setDiary_weather(rs.getString("diary_weather"));
				dto.setMemeber_id(rs.getString("member_id"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	} // getDiaryDTO end

	// 새로운 글 등록 메서드
	public int diaryInsert(DiaryDTO dto) {

		int index = 0;
		try {
			String sql = "insert into diary values (DIARY_SEQ.NEXTVAL,?,?,sysdate,TO_CHAR(SYSDATE, 'dy'),?,?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, dto.getDiary_title());
			pstmt.setString(2, dto.getDiary_cont());
			pstmt.setString(3, dto.getDiary_mood());
			pstmt.setString(4, dto.getDiary_weather());
			pstmt.setString(5, dto.getMemeber_id());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				JOptionPane.showMessageDialog(null, "글 작성이 성공하였습니다.");
				String sql2 = "select max(diary_index) as diary_index "
						+ "from diary where member_id=?";
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, dto.getMemeber_id());

				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					index = rs.getInt("diary_index");
					return index;
				}
			} else {
				JOptionPane.showMessageDialog(null, "글 작성이 실패하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return index;
	}; // diaryInsert end

	// 글 수정 메서드
	public int DiaryUpdate(DiaryDTO updto) {

		try {
			String sql = "update diary set diary_title=?, diary_cont=?, diary_mood=?, diary_weather=? "
					+ " where diary_index=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updto.getDiary_title());
			pstmt.setString(2, updto.getDiary_cont());
			pstmt.setString(3, updto.getDiary_mood());
			pstmt.setString(4, updto.getDiary_weather());
			pstmt.setInt(5, updto.getDiary_index());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				JOptionPane.showMessageDialog(null, "글 수정이 성공하였습니다.");
				return updto.getDiary_index();
			} else {
				JOptionPane.showMessageDialog(null, "글 수정이 실패하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	} // DiaryUpdate end

	// 글 삭제 메서드
	public boolean DiaryDelete(int diary_index) {

		boolean ok = false;

		try {
			String sql = "delete from diary where diary_index=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, diary_index);
			int result = pstmt.executeUpdate(); // -> 실행 / 삭제

			if (result > 0)
				ok = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	} // DiaryDelete end
	//**************************다이어리 관련 메소드 종료******************************

	//**************************사진첩 관련 메소드 시작******************************
	public int selectMenuCnt(String memberId) {
		int cnt = 0;
		try {
			String sql = "select count(*) as cnt from gal_menu where member_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				cnt = rs.getInt("cnt");
				System.out.println(cnt);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public int uploadMenuCnt(int menuId) {
		int cnt = 0;
		try {
			String sql = "select count(*) as cnt from gal_1 where menu_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, menuId);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				cnt = rs.getInt("cnt");
				System.out.println(cnt);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public int insertGallery(Gal_1 gallery) {
		int result = 0;
		String sql = "INSERT INTO GAL_1 VALUES (MENU1_SEQ.nextval,?,?,?,?,?,sysdate)";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, gallery.getGal_content());
			pstmt.setString(2, gallery.getNew_file_name());
			pstmt.setString(3, gallery.getOld_file_name());
			pstmt.setString(4, gallery.getFile_ext());
			pstmt.setInt(5, gallery.getMenu_id());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Gal_1 selectGallery(int menuId) {
		Gal_1 gal = new Gal_1();
		String sql = "select * from gal_1 WHERE menu_id = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, menuId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// gal.setGal_id(rs.getInt("gal_id"));
				gal.setFile_ext(rs.getString("file_ext"));
				gal.setGal_content(rs.getNString("gal_content"));
				gal.setNew_file_name(rs.getString("new_file_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return gal;
	}

	public int insertMenu(String menuName, String memberId) {
		int result = 0;
		try {
			String sql = "insert into gal_menu(menu_id, menu_name, menu_regdate, member_id)"
					+ " values (menu_seq.nextval, ?, sysdate, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, menuName);
			pstmt.setString(2, memberId);
			result = pstmt.executeUpdate();
			
			if(result>0)
				return result;

		} catch (Exception e) {

		}
		return result;
	}

	public int sideMenuDelete(String menuName, String memberId) {
		int menuId = 0;
		try {
			String sql = "select menu_id from gal_menu where menu_name = ? and member_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, menuName);
			pstmt.setString(2, memberId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				menuId = rs.getInt("menu_id");
			}
			
			if (menuId > 0) {
				sql = "DELETE FROM gal_menu WHERE menu_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, menuId);

				pstmt.executeUpdate();

				return menuId;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuId;
	}

	
	public List<Gal_menu> showSideMenu(String memberId) {
		List<Gal_menu> menuList = new ArrayList<>();

		try {
			String sql = "SELECT menu_id, menu_name FROM gal_menu WHERE member_id = ? ORDER BY menu_regdate";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Gal_menu galMenu = new Gal_menu();
				galMenu.setMenu_id(rs.getInt("menu_id"));
				galMenu.setMenu_name(rs.getString("menu_name"));
				menuList.add(galMenu);
			}
			if (menuList.size() > 0) {
				return menuList;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}

	public List<Gal_1> showGalleryList(int menuId, String memberId) {
		Gal_1 gal = null;
		List<Gal_1> galList = new ArrayList<>();
		String sql = "select * from gal_1 where menu_id = ? order by regdate desc";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, menuId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				gal = new Gal_1();
				gal.setNew_file_name(rs.getString("new_file_name"));
				gal.setGal_content(rs.getString("gal_content"));
				gal.setFile_ext(rs.getString("file_ext"));
				galList.add(gal);
			}

			if (galList.size() > 0) {
				return galList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return galList;
	}
	//**************************사진첩 관련 메소드 종료******************************
	
	//**************************방명록 관련 메소드 시작******************************
	public void guestbookwrite(String content, String member_id, String host_id) {

		try {
			String sql =
					"insert into guestbook values"
					+ "(gb_no.nextval, 'n', ?, ?, ?, sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);
			pstmt.setString(2, host_id);
			pstmt.setString(3, content);
			
			int result = pstmt.executeUpdate();
			if(result >0 ) {
				System.out.println("글쓰기 성공");
			}else {
				System.out.println("글쓰기 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<GuestBookDTO> guestbookWriteOpen(String member_id) {

		try {

			String sql = "select * from guestbook where member_id = ? and gb_id = (select max(gb_id) from guestbook)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);

			rs = pstmt.executeQuery();

			ArrayList<GuestBookDTO> gbList = new ArrayList<>();

			while (rs.next()) {

				GuestBookDTO gbd = new GuestBookDTO();
				
				gbd.setGb_id(rs.getInt("gb_id"));
				gbd.setScreat_at(rs.getString("secret_at"));
				gbd.setCreate_date(rs.getString("create_date"));
				gbd.setHost_id(rs.getString("host_id"));
				gbd.setContent(rs.getString("content"));
				gbd.setMember_id(rs.getString("member_id"));
				gbList.add(gbd);
			}
			
			return gbList;

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	
	public void guestbookcommwrite(int guestBookNo, String commContent, String hostid) {
		
		try {
			String sql = "insert into guestbook_comm values"
					+ "(?, gbcomm_no.nextval, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, guestBookNo);
			pstmt.setString(2, hostid);
			pstmt.setString(3, commContent);
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("댓글쓰기 성공");
			}else {
				System.out.println("댓글쓰기 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<GuestBookCommDTO> gbcommwriteopen(int guestBookNo){
		
		
		try {
			String sql = "select * from guestbook_comm where gb_id = ? and comment_id = (select max(comment_id) from guestbook_comm)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, guestBookNo);
			
			
			rs = pstmt.executeQuery();
			
			ArrayList<GuestBookCommDTO> gbcList = new ArrayList<>();
			
			while(rs.next()) {
				GuestBookCommDTO gbcd = new GuestBookCommDTO();
				
				gbcd.setGb_id(rs.getInt("gb_id"));
				gbcd.setComment_id(rs.getInt("comment_id"));
				gbcd.setWriter(rs.getString("writer"));
				gbcd.setContent(rs.getString("content"));
				gbcd.setCreate_date(rs.getString("create_date"));
				
				gbcList.add(gbcd);
				
				
			}
			
			return gbcList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		
		
		
	}
	
	public ArrayList<GuestBookCommDTO> guestbookcommselect(int guestBookNo) {
		
		try {
			String sql = "select * from guestbook_comm where gb_id = ? order by comment_id desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, guestBookNo);
			rs = pstmt.executeQuery();
			
			ArrayList<GuestBookCommDTO> gbcList = new ArrayList<>();
			
			while(rs.next()) {
				
				GuestBookCommDTO gbcd = new GuestBookCommDTO();
				
				gbcd.setGb_id(rs.getInt("gb_id"));
				gbcd.setComment_id(rs.getInt("comment_id"));
				gbcd.setWriter(rs.getString("writer"));
				gbcd.setContent(rs.getString("content"));
				gbcd.setCreate_date(rs.getString("create_date"));
				
				gbcList.add(gbcd);
				
			}
			
			return gbcList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<GuestBookDTO> guestbookOpen(String member_id) {

		try {

			String sql = "select * from guestbook where member_id = ? order by gb_id desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);

			rs = pstmt.executeQuery();

			ArrayList<GuestBookDTO> gbList = new ArrayList<>();

			while (rs.next()) {

				GuestBookDTO gbd = new GuestBookDTO();
				
				gbd.setGb_id(rs.getInt("gb_id"));
				gbd.setScreat_at(rs.getString("secret_at"));
				gbd.setCreate_date(rs.getString("create_date"));
				gbd.setHost_id(rs.getString("host_id"));
				gbd.setContent(rs.getString("content"));
				gbd.setMember_id(rs.getString("member_id"));
				gbList.add(gbd);
			}
			
			return gbList;

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public ArrayList<GuestBookDTO> guestbookselect(Member member) {

		try {
			//String sql = "select * from guestbook where member_id = ?";
			
			String sql = "select * from guestbook where host_id = ?";
			
			pstmt = con.prepareStatement(sql);
			// psmt.setString(1, "주인장ID");
			pstmt.setString(1, "somebody");

			rs = pstmt.executeQuery();
			// 주인장아이디에 등록된 방명록들의 글들을 받아와서 rs에 저장한다.
			
			ArrayList<GuestBookDTO> gbList = new ArrayList<>();

//			for(int i = 0; i < paneList.size(); i++) {
//				paneList.get(i).setVisible(false);
//			}

			while (rs.next()) {

				/*
				 * String result = rs.getString("content"); guestBookContent.append(result);
				 */
				GuestBookDTO gbd = new GuestBookDTO();
				
				gbd.setGb_id(rs.getInt("gb_id"));
				gbd.setScreat_at(rs.getString("secret_at"));
				gbd.setCreate_date(rs.getString("create_date"));
				gbd.setHost_id(rs.getString("host_id"));
				gbd.setContent(rs.getString("content"));
				gbd.setMember_id(rs.getString("member_id"));
				
				//System.out.println(rs.getString("content"))
				gbList.add(gbd);
//				for (int i = 0; i < gbList.size(); i++) {
//					
//					JPanel gbPane = new Gbpane(member);
//					gbPane
//					
//					GuestBookDTO gbdto = gbList.get(i);
//					
//					//guestBookNo
//					//guestBookName
//					//guestBookWriteTime
//					//guestBookPhoto;
//					//guestBookContent;
//					
//					
//					
//					guestBookName.setText(member.getMember_name());
//					guestBookWriteTime.setText(gbdto.getCreate_date().substring(0, 16));
//					guestBookPhoto.setText(member.getHome_profile_pic());
//					guestBookContent.setText(gbdto.getContent());
//					
//				}
				
			}
			
//			
//			for (int i = 0; i < gbList.size(); i++) {
//				System.out.println(gbList.get(i).getContent());
//			}
			
			
			return gbList;

//            System.out.println(gbList.size());
//            //gbList-5*페이지넘버(-1)
//            for(int  i = 0 ; i<5;i++) {
//            	
//            	guestBookContent.append(gbList.get(i).getContent());
//            	guestBookName.setText(gbList.get(i).getMember_id());
//            	//넣었다?
//            	paneList.get(i).setVisible(true);
//            	
//            }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void guestbookdelete(int gbId) {

		try {
			String sql1 = "delete from guestbook_comm where gb_id=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, gbId);
			pstmt.executeUpdate();
			
			String sql2 = "delete from guestbook where gb_id=?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, gbId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String guestbookmodify(String content, int gbId) {
		
		String result = null; 
		
		try {
			String sql = "update guestbook set content = ? where gb_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, gbId);
			pstmt.executeUpdate();
			
			String sql2 = "select * from guestbook where gb_id = ?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, gbId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getString("content");	
			}

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void gbcommDelete(int comment_id) {

		try {
			String sql1 = "delete from guestbook_comm where comment_id=?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, comment_id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String gbcommModify(String content, int comment_id) {
		
		String result = null; 
		
		try {
			String sql = "update guestbook_comm set content = ? where comment_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, comment_id);
			pstmt.executeUpdate();
			
			String sql2 = "select * from guestbook_comm where comment_id = ?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, comment_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getString("content");	
			}

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String guestbookImage(String member_id) {
			
			String result = null; 
			
			try {
				String sql =
						"select HOME_PROFILE_PIC from member where member_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member_id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					result = rs.getString("HOME_PROFILE_PIC");	
				}
	
				return result;
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
	}
	//**************************방명록 관련 메소드 종료******************************

}
