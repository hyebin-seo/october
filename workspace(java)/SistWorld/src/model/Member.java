package model;

public class Member {

	String member_id;			//회원 아이디
	String member_pw; 			//회원 비밀번호
	String member_name; 		//회원 이름
	String member_birth; 		//회원 생년월일
	String member_gender; 		//회원 성별
	String member_email; 		//회원 이메일
	String member_regdate;		//회원 가입일
	String home_title; 			//홈페이지 제목
    boolean home_diary; 		//홈 메뉴:다이어리 체크
    boolean home_gallery; 		//홈 메뉴:사진첩 체크
    boolean home_book; 			//홈 메뉴:방명록체크
    String home_skin; 			//스킨 이미지 경로
    String home_miniroom; 		//홈 미니룸 이미지 경로
    String home_profile_pic; 	//홈 프로필 이미지 경로
    String home_profile_msg; 	//홈 프로필 상태메시지
    String home_music; 			//홈 음악 파일 경로
	
    public Member() { }
    
//    public static synchronized Member getInstance() {
//
//		if(member == null) {
//			member = new Member();
//		}
//
//		return member;
//	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	
	public String getMember_regdate() {
		return member_regdate;
	}

	public void setMember_regdate(String member_regdate) {
		this.member_regdate = member_regdate;
	}


	public String getHome_title() {
		return home_title;
	}

	public void setHome_title(String home_title) {
		this.home_title = home_title;
	}

	public boolean isHome_diary() {
		return home_diary;
	}

	public void setHome_diary(boolean home_diary) {
		this.home_diary = home_diary;
	}

	public boolean isHome_gallery() {
		return home_gallery;
	}

	public void setHome_gallery(boolean home_gallery) {
		this.home_gallery = home_gallery;
	}

	public boolean isHome_book() {
		return home_book;
	}

	public void setHome_book(boolean home_book) {
		this.home_book = home_book;
	}

	public String getHome_skin() {
		return home_skin;
	}

	public void setHome_skin(String home_skin) {
		this.home_skin = home_skin;
	}

	public String getHome_miniroom() {
		return home_miniroom;
	}

	public void setHome_miniroom(String home_miniroom) {
		this.home_miniroom = home_miniroom;
	}

	public String getHome_profile_pic() {
		return home_profile_pic;
	}

	public void setHome_profile_pic(String home_profile_pic) {
		this.home_profile_pic = home_profile_pic;
	}

	public String getHome_profile_msg() {
		return home_profile_msg;
	}

	public void setHome_profile_msg(String home_profile_msg) {
		this.home_profile_msg = home_profile_msg;
	}

	public String getHome_music() {
		return home_music;
	}

	public void setHome_music(String home_music) {
		this.home_music = home_music;
	}
    
    

}
