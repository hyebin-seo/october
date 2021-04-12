package mainUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import db.DBConnection;
import model.FriendAsk;
import model.Member;
import model.Skin;
import service.FileAllDelete;
import service.ImageResizeUpload;
import service.MasterSession;


public class SettingPane extends JPanel implements ActionListener{

	DBConnection dbc = DBConnection.getInstance();
	
	// 넘겨받은 백 팬(카드레이아웃), 메뉴 팬, 배경스킨 라벨, 멤버객체
	private Member member;
	private JFrame homeFrame;
	private SkinLabel SkinLb;
	
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
	private JLabel pwdLb;
	private JTextField pwdTf;
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
	private JButton skinBt;
	private int skinCount = 0;
	
	// 적용하기 컴포넌트
	private JButton customOkBt;

	// 일촌 설정 컴포넌트
	private JLabel existFriendLb;
	private JLabel waitingFriendLb;
	private JLabel friendLb;
	private JTable friendTb;
	private JTable friendWaitingTb;
	private JLabel emailLb;
	private DefaultTableModel wModel;
	private DefaultTableModel fModel;
	
	MenuPane menuPane;
	
//	public SettingPane() { }
	
	public SettingPane(Member member, SkinLabel SkinLb, JFrame homeFrame, MenuPane menuPane) {
		this.menuPane = menuPane;
		this.member = member;
		this.SkinLb = SkinLb;
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
		myInfoBt.setBounds(65, 123, 130, 30);
		myInfoBt.setContentAreaFilled(false); //배경 표시
		myInfoBt.setFocusPainted(false);
		settingCategoryPane.add(myInfoBt);
		
		customBt = new RoundedButton("개인 설정"); // 메뉴 셋팅, 스킨, 음악
		customBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		customBt.setBounds(65, 163, 130, 30);
		customBt.setContentAreaFilled(false); //배경 표시
		customBt.setFocusPainted(false);
		settingCategoryPane.add(customBt);
		
		friendBt = new RoundedButton("일촌 관리");
		friendBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		friendBt.setBounds(65, 203, 130, 30);
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
		
		pwdLb = new JLabel("비밀번호 :");
		pwdLb.setHorizontalAlignment(SwingConstants.RIGHT);
		pwdLb.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pwdLb.setBounds(43, 258, 100, 26);
		pwdLb.setForeground(new Color(9,131,178));
		myInfoPane.add(pwdLb);
		
		pwdTf = new JTextField("*****************");
		pwdTf.setBounds(155, 258, 333, 26);
		pwdTf.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		pwdTf.setBackground(Color.WHITE);
		pwdTf.setForeground(new Color(9,131,178));
		pwdTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pwdTf.setEditable(false);
		myInfoPane.add(pwdTf);
		
		modifyBt = new RoundedButton("내정보 수정하기");
		modifyBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		modifyBt.setBounds(438, 294, 152, 30);
		modifyBt.setContentAreaFilled(false); //배경 표시
		modifyBt.setFocusPainted(false);
		myInfoPane.add(modifyBt);
		modifyBt.addActionListener(this);
		
		modifyConfirmBt = new RoundedButton("수정 완료");
		modifyConfirmBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		modifyConfirmBt.setBounds(438, 294, 152, 30);
		modifyConfirmBt.setContentAreaFilled(false); //배경 표시
		modifyConfirmBt.setFocusPainted(false);
		modifyConfirmBt.setVisible(false);
		myInfoPane.add(modifyConfirmBt);
		
		JButton withDrawBt = new JButton("탈퇴하기!");
		withDrawBt.setForeground(Color.GRAY);
		withDrawBt.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		withDrawBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		withDrawBt.setFocusPainted(false);
		withDrawBt.setContentAreaFilled(false);
		withDrawBt.setOpaque(false);
		withDrawBt.setBounds(70, 527, 80, 30);
		myInfoPane.add(withDrawBt);
		
		withDrawBt.addActionListener(new OutHandler());
		
		JmodifyHandler ihandler = new JmodifyHandler();
		modifyConfirmBt.addActionListener(ihandler);

		// 관리 메뉴 - 개인 설정 패널
		menuTitleLb = new JLabel("메뉴 설정");
		menuTitleLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		menuTitleLb.setBorder(new LineBorder(new Color(9, 131, 178), 3, true));
		menuTitleLb.setForeground(new Color(9, 131, 178));
		menuTitleLb.setHorizontalAlignment(SwingConstants.CENTER);
		menuTitleLb.setBounds(39, 67, 530, 30);
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
		menuPicture.setBounds(66, 113, 100, 23);
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
		menuDiary.setBounds(170, 113, 100, 23);
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
		menuVisitor.setBounds(274, 113, 100, 23);
		customPane.add(menuVisitor);
		
		customOkBt = new RoundedButton("적용");
		customOkBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		customOkBt.setBounds(486, 153, 81, 23);
		customOkBt.setContentAreaFilled(false);
		customOkBt.setFocusPainted(false);
		menuHandler menu = new menuHandler();
		customOkBt.addActionListener(menu);
		customPane.add(customOkBt);
		
		// 관리 메뉴 - 개인 설정 - 스킨 설정
		skinBt = new JButton();
		skinBt.setForeground(Color.GRAY);
		skinBt.setText("Add");
		skinBt.setOpaque(false);
		skinBt.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		skinBt.setContentAreaFilled(false);
		skinBt.setBorder(null);
		skinBt.setBackground(Color.WHITE);
		skinBt.setBounds(40, 507, 42, 20);
		customPane.add(skinBt);
		skinHandler skinhandler = new skinHandler();
		skinBt.addActionListener(skinhandler);
		
		skinTitleLb = new JLabel("스킨 설정");
		skinTitleLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		skinTitleLb.setHorizontalAlignment(SwingConstants.CENTER);
		skinTitleLb.setBorder(new LineBorder(new Color(9, 131, 178), 3, true));
		skinTitleLb.setForeground(new Color(9, 131, 178));
		skinTitleLb.setBounds(40, 306, 530, 30);
		customPane.add(skinTitleLb);
		
		JLabel lblNewLabel = new JLabel("원하는 스킨을 클릭하세요.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		lblNewLabel.setForeground(new Color(9, 131, 178));
		lblNewLabel.setBounds(369, 511, 200, 15);
		customPane.add(lblNewLabel);
		
		skinModel = new DefaultListModel();

		//유저 개인 스킨 폴더
		try {
			File dir = new File("../SistWorld/data/user/"+member.getMember_id()+"/"+member.getMember_id()+"skin");
			File files[] = dir.listFiles();
			skinCount = files.length;
	
			for (int i = 0; i < files.length; i++) {
				System.out.println("[SettingPane-skinPath]:"+files[i]);
			    Image img = new ImageIcon(files[i].toString()).getImage();
				Image imgResize = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
	
				skinModel.addElement(new Skin(imgResize, files[i].toString()));
			}
		} catch (Exception e) {
			System.out.println("보유한 개인 스킨 없음");
		}


		skinJList = new JList();

		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {
		        	skinAction();
		         }
		    }
		};
		skinJList.addMouseListener(mouseListener);
		
		skinJList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		skinJList.setModel(skinModel);
		skinJList.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		skinJList.setVisibleRowCount (-1); // 가로줄 제한
		skinJList.setLayoutOrientation (JList.HORIZONTAL_WRAP); // 리스트 가로 배열
		skinJList.setCellRenderer(new CustomListRenderer("skin"));

		JScrollPane skinSp = new JScrollPane
				(skinJList,
				//수직 스크롤바 설치 여부
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				//수평 스크롤바 설치 여부
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		skinSp.setSize(530, 150);
		skinSp.setLocation(40, 356);
		customPane.add(skinSp);
		
		JButton resetBt = new JButton();
		resetBt.setText("Reset");
		resetBt.setOpaque(false);
		resetBt.setForeground(Color.GRAY);
		resetBt.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		resetBt.setContentAreaFilled(false);
		resetBt.setBorder(null);
		resetBt.setBackground(Color.WHITE);
		resetBt.setBounds(83, 507, 42, 20);
		customPane.add(resetBt);
		resetBt.addActionListener(new reSkinHandler());
		
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
		
		friendTb = new JTable(); // 현재 일촌 목록
		friendTb.setBorder(new LineBorder(new Color(0, 0, 0)));
		friendTb.setBounds(60, 359, 530, 200);
		fModel = dbc.friend("일촌",member.getMember_id());
		
		friendTb = new JTable(fModel);
		friendTb.setRowHeight(25);
		friendTb.setRowMargin(0);
		friendTb.setIntercellSpacing(new Dimension(0, 0));
		friendTb.setGridColor(Color.WHITE);
		friendTb.setForeground(Color.DARK_GRAY);
		friendTb.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		friendTb.setShowVerticalLines(false);
		friendTb.setShowHorizontalLines(false);
		friendTb.setShowGrid(false);
		friendTb.setOpaque(false);
		friendTb.setBorder(new EmptyBorder(0, 0, 0, 0));
		friendTb.setBackground(Color.WHITE);
		friendTb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		friendTb.getTableHeader().setReorderingAllowed(false); // 셀 좌우 이동 불가
		friendTb.getTableHeader().setResizingAllowed(false); // 크기 조절 불가
//		friendTb.setTableHeader(null);
		friendTb.addMouseListener(new friendListener());
		
		JScrollPane fjsp = new JScrollPane
				(friendTb,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		fjsp.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		fjsp.setForeground(Color.GRAY);
		fjsp.setBorder(new LineBorder(Color.LIGHT_GRAY));
		fjsp.setOpaque(false);
		fjsp.getViewport().setBackground(Color.WHITE);
		fjsp.setEnabled(false);
		fjsp.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		fjsp.setSize(530, 180);
		fjsp.setLocation(60, 371);
		friendPane.add(fjsp);
		
		friendWaitingTb = new JTable(); // 대기중인 일촌 신청 목록
		friendWaitingTb.setBorder(new LineBorder(Color.LIGHT_GRAY));
		friendWaitingTb.setBounds(60, 108, 530, 200);

		wModel = dbc.friend("대기",member.getMember_id());
		
		friendWaitingTb = new JTable(wModel);
		friendWaitingTb.setRowHeight(25);
		friendWaitingTb.setRowMargin(0);
		friendWaitingTb.setIntercellSpacing(new Dimension(0, 0));
		friendWaitingTb.setGridColor(Color.WHITE);
		friendWaitingTb.setForeground(Color.DARK_GRAY);
		friendWaitingTb.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		friendWaitingTb.setShowVerticalLines(false);
		friendWaitingTb.setShowHorizontalLines(false);
		friendWaitingTb.setShowGrid(false);
		friendWaitingTb.setOpaque(false);
		friendWaitingTb.setBorder(new EmptyBorder(0, 0, 0, 0));
		friendWaitingTb.setBackground(Color.WHITE);
		friendWaitingTb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		friendWaitingTb.getTableHeader().setReorderingAllowed(false); // 셀 좌우 이동 불가
		friendWaitingTb.getTableHeader().setResizingAllowed(false); // 크기 조절 불가
//		friendWaitingTb.setTableHeader(null);
		friendWaitingTb.addMouseListener(new WaitingListener());
		
		JScrollPane fwjsp = new JScrollPane
				(friendWaitingTb,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		fwjsp.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		fwjsp.setForeground(Color.GRAY);
		fwjsp.setBorder(new LineBorder(Color.LIGHT_GRAY));
		fwjsp.setOpaque(false);
		fwjsp.getViewport().setBackground(Color.WHITE);
		fwjsp.setEnabled(false);
		fwjsp.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		fwjsp.setSize(530, 180);
		fwjsp.setLocation(60, 121);
		friendPane.add(fwjsp);
		
		columnHide();
	
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
				String pw = JOptionPane.showInputDialog("비밀번호를 입력하세요.");
				
				if(pw.equals(member.getMember_pw())) {
					JOptionPane.showMessageDialog(null, "정보 변경 후 완료 버튼을 눌러주세요.");
					emailTf.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
					emailTf.setEditable(true);
					modifyConfirmBt.setVisible(true);
					modifyBt.setVisible(false);
					pwdTf.setText(member.getMember_pw());
					pwdTf.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
					pwdTf.setEditable(true);
				} else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.","로그인 인증 실패", JOptionPane.ERROR_MESSAGE);
				}
				
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

			int result = dbc.modifyMyMenu(member);
			
			if(result > 0) {
				MasterSession ms = MasterSession.getInstance();
				menuPane.menuSetting(ms.getMaster_member());
				JOptionPane.showMessageDialog(null, "메뉴 수정 완료!");
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
			member.setMember_pw(pwdTf.getText());

			int result = dbc.modifyMyInfo(member);
			
			if(result > 0) {
				JOptionPane.showMessageDialog(null, "내정보 수정 완료!");
				emailTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				emailTf.setEditable(false);
				modifyConfirmBt.setVisible(false);
				modifyBt.setVisible(true);
				pwdTf.setText("*****************");
				pwdTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				pwdTf.setEditable(false);
			} else {
				JOptionPane.showMessageDialog(null, "알 수 없는 오류로 수정 실패","내정보 수정 실패", JOptionPane.ERROR_MESSAGE);
			}

			
		}
		
	}
	
	//스킨 선택 액션
	private void skinAction() {
		//skinJList에서 선택된 아이템의 인덱스를 가져온다.
		//인덱스를 가지고 skinModel에 저장된 객체를 가져온다.
		//해당 객체를 skin객체로 캐스팅한다.(skinModel에 넣을 때 skin객체로 삽입했음)
		//skin에 저장된 파일명을 가져온다.
		
		try {
			Skin skd = (Skin) skinModel.get(skinJList.getSelectedIndex());
			
			String[] buttons = {"스킨 적용", "스킨 삭제", "취소"};
	        int result = JOptionPane.showOptionDialog(null, "해당 스킨으로 어떤 작업을 하시겠습니까?", "스킨 설정",
	                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "두 번째값");
	        
			 if(result == 0) {
				// 스킨 적용을 눌렀을 때
				System.out.println("[SettingPane-Select Skin]: " + skd.getskinPath());
				// 메인 프레임에 얹어진 스킨 라벨 설정 메소드
				SkinLb.skinSetting(skd.getskinPath());
				
				member.setHome_skin(skd.getskinPath());
				member = dbc.modifyMySetting("skin", member);
			} else if(result == 1) {
				// 스킨 삭제를 눌렀을 때
				String selSkin = new File(skd.getskinPath()).getName();
				String curSkin = new File(member.getHome_skin()).getName();

				if(selSkin.equals(curSkin)) {
					JOptionPane.showMessageDialog
					(null, "현재 설정 중인 스킨은 삭제할 수 없습니다!","스킨 삭제 실패", JOptionPane.ERROR_MESSAGE);
				} else {
					System.out.println("[SettingPane-deleteSkin]:"+skd.getskinPath());
					File file = new File(skd.getskinPath());
					file.delete();
					skinCount--;
					skinModel.removeElement(skd);
					skinJList.revalidate();
				}
			}
		} catch (Exception e) {
			System.out.println("skinJList 객체 선택 인덱스 NULL");
		}
	
	}
	
	// 스킨 추가 액션
	private class skinHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(skinCount >= 5) {
				JOptionPane.showMessageDialog
				(null, "스킨은 5개까지만 추가할 수 있습니다.","스킨 추가 실패", JOptionPane.ERROR_MESSAGE);
			} else {
				ImageResizeUpload iru = 
						new ImageResizeUpload("skin", member.getMember_id(), 100, 100);
				
				if(!iru.getUserImgPath().equals("NotExistFile")) {
					skinModel.addElement(new Skin(iru.getImgResize(), iru.getUserImgPath()));
					skinJList.revalidate();
					skinCount++;
				}

			}

		}
		
	}
	
	// 스킨 초기화 액션
	private class reSkinHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int num = JOptionPane.showConfirmDialog
					(null, "스킨을 초기화 하시겠습니까?","스킨 초기화",JOptionPane.YES_NO_OPTION);
	        if(num == JOptionPane.YES_OPTION) {
				int result = dbc.skinReset(member);
				
				if(result > 0) {
					SkinLb.skinSetting("../SistWorld/data/images/back.jpg");
					
					JOptionPane.showMessageDialog(null, "스킨 초기화 완료!");
//					new HomeFrame(member_id);
//					homeFrame.dispose();
				} else {
					JOptionPane.showMessageDialog
					(null, "스킨 초기화 실패하였습니다.\n다시 시도해 주십시오.","실패", JOptionPane.ERROR_MESSAGE);
				}
	        }
			
		}
		
	}
	
	//회원 탈퇴
	private class OutHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String pw = JOptionPane.showInputDialog("비밀번호를 입력하세요.");
			
			try {
				if(pw.equals(member.getMember_pw())) {
					int num = JOptionPane.showConfirmDialog
							(null, "정말 탈퇴하시겠습니까?","탈퇴 확인",JOptionPane.YES_NO_OPTION);
			        if(num == JOptionPane.YES_OPTION) {

						int result = dbc.out(member);
						if(result > 0) {
							JOptionPane.showMessageDialog
							(null, "탈퇴가 완료되었습니다.\n그동안 이용해주셔서 감사합니다.");
							// 해당 유저의 모든 파일 삭제
							new FileAllDelete("../SistWorld/data/user/"+member.getMember_id());
							new LoginFrame();
							homeFrame.dispose();
						} else {
							JOptionPane.showMessageDialog
							(null, "탈퇴에 실패하였습니다.\n다시 시도해 주십시오.","탈퇴 실패", JOptionPane.ERROR_MESSAGE);
						}
			        }
				} else {
					JOptionPane.showMessageDialog
					(null, "비밀번호가 일치하지 않습니다.","로그인 인증 실패", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception ee) {
				System.out.println("탈퇴 취소");
			}
			
		}
		
	}
	
	//일촌 대기자 액션
	private class WaitingListener extends MouseAdapter {

	    @Override
	    public void mouseClicked(MouseEvent e) {
	    	
	    	if (e.getClickCount() == 1) {
	    		
	    		int row = friendWaitingTb.getSelectedRow();
	    		
    			String[] buttons = {"수락", "거절", "취소"};
		        int result = JOptionPane.showOptionDialog
		        		(null, friendWaitingTb.getModel().getValueAt(row,4)+"님의 일촌 신청을 수락하시겠습니까?", "일촌",
		                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "세번째값");
		        
	        	FriendAsk ask = new FriendAsk();
	        	
				//미니홈페이지의 주인
				ask.setMember_id((String)friendWaitingTb.getModel().getValueAt(row,0));
				ask.setMember_name((String)friendWaitingTb.getModel().getValueAt(row,1));
				ask.setMember_nick((String)friendWaitingTb.getModel().getValueAt(row,2));
				
				//일촌 신청한 사람
				ask.setFriend_id((String)friendWaitingTb.getModel().getValueAt(row,3));
				ask.setFriend_name((String)friendWaitingTb.getModel().getValueAt(row,4));
				ask.setFriend_nick((String)friendWaitingTb.getModel().getValueAt(row,5));

		        if(result == 0 ) { //수락

		        	int rs = dbc.friendAcceptOrDeny("수락", ask);

		        	if(rs>0) {
		        		JOptionPane.showMessageDialog
						(null, friendWaitingTb.getModel().getValueAt(row,4)+"님과 일촌이 되었습니다!");
		        		
						wModel.setRowCount(0); //전체 화면 지워줌&새로쓰기
						wModel = dbc.friend("대기",member.getMember_id());
						friendWaitingTb.setModel(wModel);
						
						fModel.setRowCount(0); //전체 화면 지워줌&새로쓰기
						fModel = dbc.friend("일촌",member.getMember_id());
						friendTb.setModel(fModel);
						
						columnHide();
		        	}
		        } else if(result == 1) { //거절
		        	int rs = dbc.friendAcceptOrDeny("거절", ask);

		        	if(rs>0) {
		        		JOptionPane.showMessageDialog
						(null, friendWaitingTb.getModel().getValueAt(row,4)+"님의 일촌 신청을 거절하였습니다!");
		        		
						wModel.setRowCount(0); //전체 화면 지워줌&새로쓰기
						wModel = dbc.friend("대기",member.getMember_id());
						friendWaitingTb.setModel(wModel);
						
						fModel.setRowCount(0); //전체 화면 지워줌&새로쓰기
						fModel = dbc.friend("일촌",member.getMember_id());
						friendTb.setModel(fModel);
						
						columnHide();
		        	}    			
	    		}
	    	}
	    }
	}
	
	public void columnHide() {
		friendTb.getColumnModel().getColumn(0).setWidth(0); //내아이디 숨김
		friendTb.getColumnModel().getColumn(0).setMinWidth(0); //내아이디 숨김
		friendTb.getColumnModel().getColumn(0).setMaxWidth(0); //내아이디 숨김
		
		friendTb.getColumnModel().getColumn(3).setWidth(0); //친구아이디 숨김
		friendTb.getColumnModel().getColumn(3).setMinWidth(0); //친구아이디 숨김
		friendTb.getColumnModel().getColumn(3).setMaxWidth(0); //친구아이디 숨김
		
		friendWaitingTb.getColumnModel().getColumn(0).setWidth(0); //내아이디 숨김
		friendWaitingTb.getColumnModel().getColumn(0).setMinWidth(0); //내아이디 숨김
		friendWaitingTb.getColumnModel().getColumn(0).setMaxWidth(0); //내아이디 숨김
		
		friendWaitingTb.getColumnModel().getColumn(3).setWidth(0); //친구아이디 숨김
		friendWaitingTb.getColumnModel().getColumn(3).setMinWidth(0); //친구아이디 숨김
		friendWaitingTb.getColumnModel().getColumn(3).setMaxWidth(0); //친구아이디 숨김
	}
	
	//일촌 리스트 선택 액션
	private class friendListener extends MouseAdapter {

	    @Override
	    public void mouseClicked(MouseEvent e) {
	    	
	    	if (e.getClickCount() == 1) {
	    		int row = friendTb.getSelectedRow();
		        int result = JOptionPane.showConfirmDialog
				(null, friendTb.getModel().getValueAt(row,4)+"님과 일촌을 끊으시겠습니까?","일촌 추방",JOptionPane.YES_NO_OPTION);
		        
	        	FriendAsk ask = new FriendAsk();
	        	
				//미니홈페이지의 주인
				ask.setMember_id((String)friendTb.getModel().getValueAt(row,0));
				
				//일촌 신청한 사람
				ask.setFriend_id((String)friendTb.getModel().getValueAt(row,3));

		        if(result == JOptionPane.YES_OPTION ) { //수락
		        	
		        	//일촌 삭제
		        	int rs = dbc.friendAcceptOrDeny("삭제", ask);

		        	if(rs>0) {
		        		JOptionPane.showMessageDialog
						(null, friendTb.getModel().getValueAt(row,4)+"님과의 일촌을 끊었습니다!");

						fModel.setRowCount(0); //전체 화면 지워줌&새로쓰기
						fModel = dbc.friend("일촌",member.getMember_id());
						friendTb.setModel(fModel);
		        	}
		        }
	    	}
	    }
	}

}
