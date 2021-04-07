package mainUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.DBConnection;
import model.Member;
import model.Skin;

public class SettingPane extends JPanel implements ActionListener{

	// 넘겨받은 백 팬(카드레이아웃), 메뉴 팬, 배경스킨 라벨, 멤버객체
	private Member member;
	private String member_id;
	private JFrame homeFrame;
	private JPanel backPane;
	private MenuPane menuPane;
	private BackSkinLabel backSkinLb;
	
	// 관리 메뉴 - 세부 패널을 담는 패널
	private JPanel settingDetailPane;
	
	// 관리 메뉴 - 세부 카테고리 패널
	private JPanel settingCategoryPane;
	
	// 관리 메뉴 - 세부 카테고리 버튼
	private JLabel settingTitle;
	private RoundedButton myInfoBt;
	private RoundedButton customBt;
	private RoundedButton friendBt;

	// 관리 메뉴 - 세부 패널
	private JPanel myInfoPane;
	private JPanel customPane;
	private JPanel friendPane;
	
	// 관리 메뉴 - 세부 디테일 패널 컴포넌트
	// 내정보 컴포넌트
	private JLabel myInfoLb;
	private JLabel idLb;
	private JLabel idLb2;
	private JLabel birthLb;
	private JLabel birthLb2;
	private JLabel regdateLb;
	private JTextField emailTf;
	private RoundedButton modifyBt;
	private RoundedButton modifyConfirmBt;

	// 메뉴 설정 컴포넌트
	private JLabel menuTitleLb;
	private JCheckBox menuPicture;
	private JCheckBox menuDiary;
	private JCheckBox menuVisitor;
	
	// 스킨 설정 컴포넌트
	private JList skinJList;
	private DefaultListModel skinModel;
	private JLabel skinTitleLb;
	private String SKIN_PATH = "../user/admin/adminimg/";

	// 음악 설정 컴포넌트
	private JLabel musicTitleLb;
	private JList musicJList;
	private DefaultListModel musicModel;
	
	// 적용하기 컴포넌트
	private JButton customOkBt;

	// 일촌 설정 컴포넌트
	private JLabel existFriendLb;
	private JLabel waitingFriendLb;
	private JLabel friendLb;
	private JList friendJl;
	private JList friendWaitingJl;
	private JLabel lblNewLabel_1;
	private JLabel emailLb;
	
//	public SettingPane() { }
	
	public SettingPane(Member member, JPanel backPane, MenuPane menuPane, BackSkinLabel backSkinLb, JFrame homeFrame) {
		this.member = member;
		member_id = member.getMember_id();
		this.backPane = backPane;
		this.menuPane = menuPane;
		this.backSkinLb = backSkinLb;
		this.homeFrame = homeFrame;
		
		this.setBounds(40, 40, 910, 600);
		this.setLayout(null);
		
		// 관리 메뉴 센터 패널
		settingDetailPane = new JPanel();

		// 관리 메뉴 - 카테고리 패널 선언
		myInfoPane = new JPanel();
		myInfoPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		customPane = new JPanel();
		friendPane = new JPanel();
		
		// 관리 메뉴 - 카테고리 목록, 디테일 패널
		settingCategoryPane = new JPanel();
		settingCategoryPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		settingCategoryPane.setBounds(0, 0, 260, 600);
		this.add(settingCategoryPane);
		settingDetailPane.setBounds(260, 0, 650, 600);
		this.add(settingDetailPane);
		settingCategoryPane.setBackground(Color.WHITE);
		settingCategoryPane.setLayout(null);
		
		// 관리 메뉴 - 세부 카테고리 버튼
		settingTitle = new JLabel("미니홈피 관리");
		settingTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		settingTitle.setForeground(new Color(9,131,178));
		settingTitle.setHorizontalAlignment(SwingConstants.CENTER);
		settingTitle.setBounds(-19, 54, 299, 59);
		settingCategoryPane.add(settingTitle);
		
		myInfoBt = new RoundedButton("기본 정보");
		myInfoBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		myInfoBt.setBounds(65, 123, 130, 50);
		myInfoBt.setContentAreaFilled(false); //배경 표시
		myInfoBt.setFocusPainted(false);
		settingCategoryPane.add(myInfoBt);
		
		customBt = new RoundedButton("개인 설정"); // 메뉴 셋팅, 스킨, 음악
		customBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		customBt.setBounds(65, 183, 130, 50);
		customBt.setContentAreaFilled(false); //배경 표시
		customBt.setFocusPainted(false);
		settingCategoryPane.add(customBt);
		
		friendBt = new RoundedButton("일촌 관리");
		friendBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		friendBt.setBounds(65, 243, 130, 50);
		friendBt.setContentAreaFilled(false); //배경 표시
		friendBt.setFocusPainted(false);
		settingCategoryPane.add(friendBt);
		
		friendBt.addActionListener(this);
		customBt.addActionListener(this);
		myInfoBt.addActionListener(this);
		
		// 관리 세부 패널 배경 설정
		settingDetailPane.setLayout(new CardLayout(0, 0));
		myInfoPane.setBackground(Color.WHITE);
		customPane.setBackground(Color.WHITE);
		friendPane.setBackground(Color.WHITE);
		
		// 관리 세부 패널에 카드 패널 추가
		settingDetailPane.add(myInfoPane, "myInfo"); 
		settingDetailPane.add(customPane, "setMenu");
		settingDetailPane.add(friendPane, "friend");

		// 관리 메뉴 - 내정보 패널
		myInfoPane.setLayout(null);
		myInfoLb = new JLabel("내정보");
		myInfoLb.setBorder(new LineBorder(new Color(9, 131, 178), 3, true));
		myInfoLb.setHorizontalAlignment(SwingConstants.CENTER);
		myInfoLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		myInfoLb.setForeground(new Color(9,131,178));
		myInfoLb.setBounds(60, 38, 530, 30);
		myInfoPane.add(myInfoLb);
		
		idLb = new JLabel("아이디 :");
		idLb.setHorizontalAlignment(SwingConstants.RIGHT);
		idLb.setBounds(43, 114, 100, 26);
		idLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		idLb.setForeground(new Color(9,131,178));
		myInfoPane.add(idLb);
		
		idLb2 = new JLabel(member.getMember_id());
		idLb2.setHorizontalAlignment(SwingConstants.LEFT);
		idLb2.setBounds(155, 114, 333, 26);
		idLb2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		idLb2.setForeground(new Color(9,131,178));
		myInfoPane.add(idLb2);
		
		birthLb = new JLabel("생년월일 :");
		birthLb.setHorizontalAlignment(SwingConstants.RIGHT);
		birthLb.setBounds(43, 186, 100, 26);
		myInfoPane.add(birthLb);
		birthLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		birthLb.setForeground(new Color(9,131,178));
		
		birthLb2 = new JLabel(member.getMember_birth());
		birthLb2.setBounds(155, 186, 346, 26);
		birthLb2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		birthLb2.setBackground(Color.WHITE);
		birthLb2.setForeground(new Color(9,131,178));
		myInfoPane.add(birthLb2);

		//가입일 구하기
		Calendar getToday = Calendar.getInstance();
		getToday.setTime(new Date()); //오늘 날짜
		String s_date = member.getMember_regdate().substring(0,10);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(s_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cmpDate = Calendar.getInstance();
		cmpDate.setTime(date); //특정 일자
		long diffSec = (getToday.getTimeInMillis() - cmpDate.getTimeInMillis()) / 1000;
		long diffDays = diffSec / (24*60*60); //일자수 차이

		regdateLb = new JLabel("가입한 지 "+diffDays+"일 되었습니다!");
		regdateLb.setHorizontalAlignment(SwingConstants.RIGHT);
		regdateLb.setBounds(287, 78, 300, 26);
		regdateLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		regdateLb.setForeground(new Color(9,131,178));
		myInfoPane.add(regdateLb);
		
		JLabel nameLb = new JLabel("이름 :");
		nameLb.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		nameLb.setForeground(new Color(9,131,178));
		nameLb.setBounds(43, 150, 100, 26);
		myInfoPane.add(nameLb);
		
		JLabel nameLb2 = new JLabel(member.getMember_name());
		nameLb2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		nameLb2.setForeground(new Color(9,131,178));
		nameLb2.setBounds(155, 150, 346, 26);
		myInfoPane.add(nameLb2);
		
		emailLb = new JLabel("이메일 :");
		emailLb.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		emailLb.setBounds(43, 222, 100, 26);
		emailLb.setForeground(new Color(9,131,178));
		myInfoPane.add(emailLb);
		
		emailTf = new JTextField(member.getMember_email());
		emailTf.setBounds(155, 222, 333, 26);
		emailTf.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		emailTf.setBackground(Color.WHITE);
		emailTf.setForeground(new Color(9,131,178));
		emailTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		emailTf.setEditable(false);
		myInfoPane.add(emailTf);
		
		modifyBt = new RoundedButton("내정보 수정하기");
		modifyBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		modifyBt.setBounds(249, 328, 152, 30);
		modifyBt.setContentAreaFilled(false); //배경 표시
		modifyBt.setFocusPainted(false);
		myInfoPane.add(modifyBt);
		modifyBt.addActionListener(this);
		
		modifyConfirmBt = new RoundedButton("정보 수정 완료");
		modifyConfirmBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		modifyConfirmBt.setBounds(249, 328, 152, 30);
		modifyConfirmBt.setContentAreaFilled(false); //배경 표시
		modifyConfirmBt.setFocusPainted(false);
		modifyConfirmBt.setVisible(false);
		myInfoPane.add(modifyConfirmBt);
		
		JmodifyHandler ihandler = new JmodifyHandler();
		modifyConfirmBt.addActionListener(ihandler);
		
		// 관리 메뉴 - 개인 설정 패널
		// 체크박스 DB값으로 셀렉트 설정할 것
		menuTitleLb = new JLabel("메뉴 설정");
		menuTitleLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		menuTitleLb.setBorder(new LineBorder(new Color(9, 131, 178), 3, true));
		menuTitleLb.setForeground(new Color(9, 131, 178));
		menuTitleLb.setHorizontalAlignment(SwingConstants.CENTER);
		menuTitleLb.setBounds(40, 43, 530, 30);
		customPane.add(menuTitleLb);
		
		customPane.setLayout(null);
		menuPicture = new JCheckBox("사진첩");
		menuPicture.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		menuPicture.setForeground(new Color(9, 131, 178));
		if (member.isHome_gallery()) {
			menuPicture.setSelected(true);
		} else {
			menuPicture.setSelected(false);
		}
		menuPicture.setOpaque(false);
		menuPicture.setBounds(67, 89, 100, 23);
		customPane.add(menuPicture);
		
		menuDiary = new JCheckBox("다이어리");
		menuDiary.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		menuDiary.setForeground(new Color(9, 131, 178));
		if (member.isHome_diary()) {
			menuDiary.setSelected(true);
		} else {
			menuDiary.setSelected(false);
		}
		menuDiary.setOpaque(false);
		menuDiary.setBounds(171, 89, 100, 23);
		customPane.add(menuDiary);
		
		menuVisitor = new JCheckBox("방명록");
		menuVisitor.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		menuVisitor.setForeground(new Color(9, 131, 178));
		if (member.isHome_book()) {
			menuVisitor.setSelected(true);
		} else {
			menuVisitor.setSelected(false);
		}
		menuVisitor.setOpaque(false);
		menuVisitor.setBounds(275, 89, 100, 23);
		customPane.add(menuVisitor);
		
		customOkBt = new RoundedButton("적용");
		customOkBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		customOkBt.setBounds(487, 129, 81, 23);
		customOkBt.setContentAreaFilled(false);
		customOkBt.setFocusPainted(false);
		menuHandler menu = new menuHandler();
		customOkBt.addActionListener(menu);
		customPane.add(customOkBt);
		
		// 관리 메뉴 - 개인 설정 - 스킨 설정
		skinTitleLb = new JLabel("스킨 설정");
		skinTitleLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		skinTitleLb.setHorizontalAlignment(SwingConstants.CENTER);
		skinTitleLb.setBorder(new LineBorder(new Color(9, 131, 178), 3, true));
		skinTitleLb.setForeground(new Color(9, 131, 178));
		skinTitleLb.setBounds(40, 180, 530, 30);
		customPane.add(skinTitleLb);
		
		JLabel lblNewLabel = new JLabel("원하는 스킨을 선택하세요.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		lblNewLabel.setForeground(new Color(9, 131, 178));
		lblNewLabel.setBounds(370, 345, 200, 15);
		customPane.add(lblNewLabel);
		
		skinModel = new DefaultListModel();
		// 임시 데이터
		// DB에서 파일명 가져오면 for문으로 돌려서 객체 생성 후 삽입할 것
//		for(int i=0; i<10; i++) {
		
		
		Image img = new ImageIcon(getClass().getResource(SKIN_PATH+"admin1.jpg")).getImage();
		Image imgResize = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);

		skinModel.addElement(new Skin(imgResize, "admin1.jpg"));
		
		img = new ImageIcon(getClass().getResource(SKIN_PATH+"admin2.jpg")).getImage();
		imgResize = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);

		skinModel.addElement(new Skin(imgResize, "admin2.jpg"));

//		}
		skinJList = new JList();
		
		JListHandler shandler = new JListHandler();
		skinJList.addListSelectionListener(shandler);
		
		skinJList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		skinJList.setModel(skinModel);
		skinJList.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		skinJList.setVisibleRowCount (-1); // 가로줄 제한
		skinJList.setLayoutOrientation (JList.HORIZONTAL_WRAP); // 리스트 가로 배열
		skinJList.setCellRenderer(new CustomListRenderer("skin"));

		JScrollPane skinSp = new JScrollPane
				(skinJList,
				//수직 스크롤바 설치 여부
				ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
				//수평 스크롤바 설치 여부
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		skinSp.setSize(530, 110);
		skinSp.setLocation(40, 230);
		customPane.add(skinSp);
		
		// 관리메뉴 - 개인 설정 - 음악 설정
		musicTitleLb = new JLabel("음악 설정");
		musicTitleLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		musicTitleLb.setHorizontalAlignment(SwingConstants.CENTER);
		musicTitleLb.setForeground(new Color(9, 131, 178));
		musicTitleLb.setBorder(new LineBorder(new Color(9, 131, 178), 3, true));
		musicTitleLb.setBounds(40, 390, 530, 30);
		customPane.add(musicTitleLb);
		
		musicModel = new DefaultListModel();
		
		// 음악 객체 삽입할 것
		
		musicJList = new JList();
		
		JListHandler mhandler = new JListHandler();
		musicJList.addListSelectionListener(mhandler);
		
		musicJList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		musicJList.setModel(musicModel);
		musicJList.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		musicJList.setVisibleRowCount (-1); // 가로줄 제한
		musicJList.setLayoutOrientation (JList.HORIZONTAL_WRAP); // 리스트 가로 배열
		musicJList.setCellRenderer(new CustomListRenderer("music"));

		JScrollPane musicSp = new JScrollPane
				(musicJList,
				//수직 스크롤바 설치 여부
				ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
				//수평 스크롤바 설치 여부
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		musicSp.setSize(530, 110);
		musicSp.setLocation(40, 440);
		customPane.add(musicSp);
		
		lblNewLabel_1 = new JLabel("원하는 음악을 선택하세요.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(9, 131, 178));
		lblNewLabel_1.setBounds(370, 555, 200, 15);
		customPane.add(lblNewLabel_1);
		
		
		// 관리 메뉴 - 개인 설정 - 일촌 관리
		friendPane.setLayout(null);
		friendLb = new JLabel("나의 일촌 현황");
		friendLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		friendLb.setForeground(new Color(9, 131, 178));
		friendLb.setBorder(new LineBorder(new Color(9, 131, 178), 3, true));
		friendLb.setHorizontalAlignment(SwingConstants.CENTER);
		friendLb.setBounds(60, 20, 530, 30);
		friendPane.add(friendLb);
		friendLb.setBackground(Color.WHITE);
		
		friendJl = new JList(); // 현재 일촌 목록
		friendJl.setBorder(new LineBorder(new Color(0, 0, 0)));
		friendJl.setBounds(60, 359, 530, 200);
		friendPane.add(friendJl);
		
		friendWaitingJl = new JList(); // 삭제할 일촌 목록
		friendWaitingJl.setBorder(new LineBorder(Color.LIGHT_GRAY));
		friendWaitingJl.setBounds(60, 108, 530, 200);
		friendPane.add(friendWaitingJl);
		
		existFriendLb = new JLabel("일촌 목록");
		existFriendLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		existFriendLb.setForeground(new Color(9, 131, 178));
		existFriendLb.setBounds(296, 334, 57, 15);
		friendPane.add(existFriendLb);
		
		waitingFriendLb = new JLabel("대기중인 일촌 신청");
		waitingFriendLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		waitingFriendLb.setForeground(new Color(9, 131, 178));
		waitingFriendLb.setHorizontalAlignment(SwingConstants.CENTER);
		waitingFriendLb.setBounds(260, 83, 130, 15);
		friendPane.add(waitingFriendLb);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout c1 = (CardLayout)settingDetailPane.getLayout();
		String btName = e.getActionCommand();

		switch (btName) {
			case "기본 정보":
				c1.show(settingDetailPane,"myInfo");
				break;
				
			case "개인 설정":
				c1.show(settingDetailPane,"setMenu");		
				break;
				
			case "일촌 관리":
				c1.show(settingDetailPane,"friend");
				break;
			case "내정보 수정하기":
				emailTf.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
				emailTf.setEditable(true);
				modifyConfirmBt.setVisible(true);
				modifyBt.setVisible(false);
			default:
				break;
		}

	}
	
	//메뉴 설정
	private class menuHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(menuPicture.isSelected()) {
				member.setHome_gallery(true);
			} else {
				member.setHome_gallery(false);
			}
			
			if(menuDiary.isSelected()) {
				member.setHome_diary(true);
			} else {
				member.setHome_diary(false);
			}
			
			if(menuVisitor.isSelected()) {
				member.setHome_book(true);
			} else {
				member.setHome_book(false);
			}
			
			DBConnection dbc = DBConnection.getInstance();
			int result = dbc.modifyMyMenu(member);
			
			if(result > 0) {
				new HomeFrame(member_id);
				homeFrame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "알 수 없는 오류로 수정 실패","메뉴 수정 실패", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	
	}
	
	//내정보 수정
	private class JmodifyHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			member.setMember_email(emailTf.getText());
			
			DBConnection dbc = DBConnection.getInstance();
			int result = dbc.modifyMyInfo(member);
			
			if(result > 0) {
				new HomeFrame(member_id);
				homeFrame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "알 수 없는 오류로 수정 실패","내정보 수정 실패", JOptionPane.ERROR_MESSAGE);
			}

			
		}
		
	}
	
	//스킨 선택 액션
	private class JListHandler implements ListSelectionListener
	{
		// 리스트의 항목이 선택이 되면
		public void valueChanged(ListSelectionEvent event)
		{
			//skinJList에서 선택된 아이템의 인덱스를 가져온다.
			//인덱스를 가지고 skinModel에 저장된 객체를 가져온다.
			//해당 객체를 skinDTO객체로 캐스팅한다.(skinModel에 넣을 때 skinDTO로 삽입했음)
			//skinDTO에 저장된 파일명을 가져온다.
			Skin skd = (Skin) skinModel.getElementAt(skinJList.getSelectedIndex());
			String fileName = skd.getSelectSkin();
			
			int result = JOptionPane.showConfirmDialog(skinJList, fileName+"이 스킨으로 설정하시겠습니까?",
					"스킨 설정", JOptionPane.YES_NO_OPTION);
			
			if(result == JOptionPane.CLOSED_OPTION) {
				// 창의 X를 눌렀을때
			} else if(result == JOptionPane.YES_OPTION) {
				// 확인 눌렀을때
				System.out.println("[SettingPane-Select Skin]: " + SKIN_PATH+fileName);
				// 메인 프레임에 얹어진 스킨 라벨 설정 메소드
				backSkinLb.skinSetting(SKIN_PATH+fileName);

			} else {
				// 취소 눌렀을때
			}
		}
	}
}
