package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.FriendCmt;
public class HomePane extends JPanel{

	// 홈 메뉴 - 세부 메인 패널
	private JPanel mainDetailPane;
	
	// 홈 메뉴 - 세부 프로필 패널
	private JPanel mainProfilePane;

	// 홈 메뉴 - 세부 프로필 컴포넌트
	private JLabel profilePicLb;
	private JTextArea profileStatusTa;
	private JLabel profileInfoLb;
	
	// 홈 메뉴 - 세부 메인 컴포넌트
	private String FILE_PATH_HOME = "../images/home.JPG";
	private String FILE_PATH_PROF = "../images/profile.JPG";
	private JLabel homeImgLb;
	private JLabel friendLb;
	private JTextField frienTf;
//	private JTable freinTb;
	private JButton freindBt;
	

	public HomePane() {
		
		//super();
		
		// 세부 메인, 세부 프로필을 담는 패널
		this.setBounds(40, 40, 910, 600);
		this.setLayout(null);

		// 홈 메뉴 - 세부 메인 패널
		mainDetailPane = new JPanel();
		mainDetailPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		mainDetailPane.setBounds(260, 0, 650, 600);
		mainDetailPane.setBackground(Color.WHITE);
		mainDetailPane.setLayout(null);

		// 홈 메뉴 - 세부 프로필 패널
		mainProfilePane = new JPanel();
		mainProfilePane.setBorder(new LineBorder(new Color(192, 192, 192)));
		mainProfilePane.setBounds(0, 0, 260, 600);
		mainProfilePane.setBackground(Color.WHITE);
		mainProfilePane.setLayout(null);

		// 홈 메뉴 - 프로필 사진
		profilePicLb = new JLabel("");
		profilePicLb.setIcon(new ImageIcon(HomePane.class.getResource(FILE_PATH_PROF)));
		profilePicLb.setHorizontalAlignment(SwingConstants.CENTER);
		profilePicLb.setBounds(20, 70, 220, 170);
		mainProfilePane.add(profilePicLb);
		
		// 홈 메뉴 - 프로필 상태
		profileStatusTa = new JTextArea(5,30);
		profileStatusTa.setLineWrap(true);
		profileStatusTa.setEnabled(false);
		profileStatusTa.setEditable(false);
		profileStatusTa.setText("안녕하세요. 프로필 상태메세지입니다.안녕하세요.");
		profileStatusTa.setBounds(20, 250, 220, 170);
		JScrollPane profilestatusJs = new JScrollPane(
				profileStatusTa,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		profilestatusJs.setSize(220, 170);
		profilestatusJs.setLocation(20, 270);
		mainProfilePane.add(profilestatusJs);
		
		// 홈 메뉴 - 프로필 정보
		profileInfoLb = new JLabel("김쌍용 | 여 | 1990.01.01");
		profileInfoLb.setHorizontalAlignment(SwingConstants.CENTER);
		profileInfoLb.setBounds(20, 470, 220, 50);
		mainProfilePane.add(profileInfoLb);
		
		// 홈 메뉴 - 배경 사진(라벨에 맞게 사이즈 재설정)
		homeImgLb = new JLabel();
		Image homeImg = new ImageIcon(HomePane.class.getResource(FILE_PATH_HOME)).getImage();
		Image homeImgResize = homeImg.getScaledInstance(530, 310, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizeIcon = new ImageIcon(homeImgResize);
		homeImgLb.setIcon(resizeIcon);
		homeImgLb.setBounds(60, 40, 530, 310);
		mainDetailPane.add(homeImgLb);

		this.add(mainDetailPane, "mainDetail");
		
		friendLb = new JLabel("일촌평");
		friendLb.setHorizontalAlignment(SwingConstants.LEFT);
		friendLb.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		friendLb.setBounds(58, 370, 40, 20);
		mainDetailPane.add(friendLb);
		
		frienTf = new JTextField();
		frienTf.setBounds(99, 370, 430, 20);
		mainDetailPane.add(frienTf);
		frienTf.setColumns(10);
		
		freindBt = new JButton("확인");
		freindBt.setHorizontalAlignment(SwingConstants.LEFT);
		freindBt.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		freindBt.setBounds(533, 370, 55, 20);
		mainDetailPane.add(freindBt);


		// 일촌평 구현 - DB데이터 넣고 다시 할 것
//		DefaultListModel<FriendCmtDTO> listModel = new DefaultListModel<FriendCmtDTO>();
		DefaultListModel listModel = new DefaultListModel();
		// 임시 데이터
		for(int i=0; i<10; i++) {
			FriendCmt fcd = new FriendCmt();

			fcd.setNickname((i+1)+"번째 친구");
			fcd.setName((i+1)+"사람");
			fcd.setFriendcomment("일촌평 테스트 중입니다. 이 일촌평은 "+(i+1)
								+"번째 일촌평. 일촌평 테스트 중입니다. 일촌평 테스트 중입니다.");
			
			String fcmt = fcd.getFriendcomment()
							+"  |  "+fcd.getNickname()
							+"  |  "+fcd.getName();
			
//			listModel.addElement(fcd);
			listModel.addElement(fcmt);

		}
//		JList<FriendCmtDTO> friendCmtJList = new JList<FriendCmtDTO>();
		JList friendCmtJList = new JList();
		friendCmtJList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		friendCmtJList.setModel(listModel);
		friendCmtJList.setCellRenderer(new CustomListRenderer("cmt"));

		JScrollPane friendSp = new JScrollPane
				(friendCmtJList,
				//수직 스크롤바 설치 여부
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				//수평 스크롤바 설치 여부
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		friendSp.setSize(530, 170);
		friendSp.setLocation(60, 400);
		mainDetailPane.add(friendSp);
		
		
		this.add(mainProfilePane, "mainProfile");
		this.setBackground(Color.BLACK);

	}
}
