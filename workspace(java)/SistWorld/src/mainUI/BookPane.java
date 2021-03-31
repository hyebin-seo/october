package mainUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;

public class BookPane extends JPanel{

	public BookPane() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 1280, 720);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		
		this.setBounds(40, 40, 910, 600);
		this.setLayout(null);
		
		// 방명록 스크롤 뒷 패널
		JScrollPane guestBookScrollPane = new JScrollPane();
		guestBookScrollPane.setBounds(260, 0, 650, 600);
//		frame.getContentPane().add(guestBookScrollPane);
		this.add(guestBookScrollPane);
		
		// 방명록 레이아웃 패널
		JPanel guestBookPane = new JPanel();
		guestBookScrollPane.setViewportView(guestBookPane);
		guestBookPane.setLayout(null);
		
		// 첫번째 방명록 정보 및 메뉴 패널
		JPanel guestBookInfoMenu_1 = new JPanel();
		guestBookInfoMenu_1.setBounds(22, 22, 604, 37);
		guestBookPane.add(guestBookInfoMenu_1);
		guestBookInfoMenu_1.setLayout(null);
		
		// 첫번째 방명록 정보 라벨
		JLabel guestBookNo_1 = new JLabel("no 12345");
		guestBookNo_1.setBounds(12, 10, 57, 15);
		guestBookInfoMenu_1.add(guestBookNo_1);
		
		JButton guestBookName_1 = new JButton("문형준");
		guestBookName_1.setBounds(71, 6, 71, 27);
		guestBookInfoMenu_1.add(guestBookName_1);
		
		JLabel guestBookWriteTime_1 = new JLabel("2021.03.26 00:29");
		guestBookWriteTime_1.setBounds(173, 10, 117, 15);
		guestBookInfoMenu_1.add(guestBookWriteTime_1);
		
		
		// 첫번째 방명록 메뉴 버튼
		JButton guestBookSecretBt_1 = new JButton("비밀로 하기");
		guestBookSecretBt_1.setBounds(356, 7, 102, 23);
		guestBookInfoMenu_1.add(guestBookSecretBt_1);
		
		JButton guestBookDeleteBt_1 = new JButton("삭제");
		guestBookDeleteBt_1.setBounds(459, 7, 57, 23);
		guestBookInfoMenu_1.add(guestBookDeleteBt_1);
		
		JButton guestBookReportBt_1 = new JButton("신고");
		guestBookReportBt_1.setBounds(518, 6, 65, 23);
		guestBookInfoMenu_1.add(guestBookReportBt_1);
		
		ImageIcon icon = new ImageIcon("images/home3.jpg");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JButton guestBookMoveBt_1 = new JButton(changeIcon);
		
		guestBookMoveBt_1.setBounds(142, 6, 26, 27);
		guestBookInfoMenu_1.add(guestBookMoveBt_1);
		
		
		// 첫번째 방명록 사진 라벨
		
		ImageIcon icon1 = new ImageIcon("images/profile.jpg");
		Image img2 = icon1.getImage();
		Image changeImg2 = img2.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImg2);
		
		JLabel guestBookPhoto_1 = new JLabel(changeIcon2);
		guestBookPhoto_1.setBounds(32, 69, 161, 159);
		guestBookPane.add(guestBookPhoto_1);
		
		// 첫번째 방명록 내용
		JTextArea guestBookContent_1 = new JTextArea();
		guestBookContent_1.setBounds(217, 69, 394, 159);
		guestBookPane.add(guestBookContent_1);
	
		
		// 첫번째 방명록 댓글 패널
		JPanel guestBookCommentPane_1 = new JPanel();
		guestBookCommentPane_1.setBounds(22, 241, 587, 61);
		guestBookPane.add(guestBookCommentPane_1);
		guestBookCommentPane_1.setLayout(null);
		
		// 첫번째 방명록 댓글
		JTextPane guestBookCommentContent_1 = new JTextPane();
		guestBookCommentContent_1.setBounds(12, 0, 492, 61);
		guestBookCommentPane_1.add(guestBookCommentContent_1);
		
		// 첫번째 방명록 확인버튼
		JButton guestBookCommentCheackBt_1 = new JButton("확인");
		guestBookCommentCheackBt_1.setBounds(516, 10, 71, 41);
		guestBookCommentPane_1.add(guestBookCommentCheackBt_1);
		
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(631, 10, 17, 578);
		guestBookPane.add(scrollBar);
		
		
		// 두번째 방명록 정보 및 메뉴 패널
		JPanel guestBookInfoMenu_2 = new JPanel();
		guestBookInfoMenu_2.setLayout(null);
		guestBookInfoMenu_2.setBounds(22, 312, 604, 37);
		guestBookPane.add(guestBookInfoMenu_2);
		
		
		// 두번째 방명록 정보 라벨
		JLabel guestBookNo_2 = new JLabel("no 12345");
		guestBookNo_2.setBounds(12, 10, 57, 15);
		guestBookInfoMenu_2.add(guestBookNo_2);
		
		JButton guestBookName_2 = new JButton("문형준");
		guestBookName_2.setBounds(71, 6, 71, 27);
		guestBookInfoMenu_2.add(guestBookName_2);
		
		JLabel guestBookWriteTime_2 = new JLabel("2021.03.26 00:29");
		guestBookWriteTime_2.setBounds(173, 10, 117, 15);
		guestBookInfoMenu_2.add(guestBookWriteTime_2);
		
		JButton guestBookSecretBt_2 = new JButton("비밀로 하기");
		guestBookSecretBt_2.setBounds(356, 7, 102, 23);
		guestBookInfoMenu_2.add(guestBookSecretBt_2);
		
		JButton guestBookDeleteBt_2 = new JButton("삭제");
		guestBookDeleteBt_2.setBounds(459, 7, 57, 23);
		guestBookInfoMenu_2.add(guestBookDeleteBt_2);
		
		JButton guestBookReportBt_2 = new JButton("신고");
		guestBookReportBt_2.setBounds(518, 6, 65, 23);
		guestBookInfoMenu_2.add(guestBookReportBt_2);
		
		JButton guestBookMoveBt_2 = new JButton((Icon) null);
		guestBookMoveBt_2.setBounds(142, 6, 26, 27);
		guestBookInfoMenu_2.add(guestBookMoveBt_2);
		
	
		// 두번째 방명록 사진 및 내용 라벨
		
		JLabel guestBookPhoto_2 = new JLabel((Icon) null);
		guestBookPhoto_2.setBounds(32, 358, 161, 159);
		guestBookPane.add(guestBookPhoto_2);
		
		JTextArea guestBookContent_2 = new JTextArea();
		guestBookContent_2.setBounds(215, 358, 394, 159);
		guestBookPane.add(guestBookContent_2);
		
		// 두번째 방명록 댓글 패널
		JPanel guestBookCommentPane_2 = new JPanel();
		guestBookCommentPane_2.setLayout(null);
		guestBookCommentPane_2.setBounds(22, 527, 587, 61);
		guestBookPane.add(guestBookCommentPane_2);
		
		// 두번째 방명록 댓글내용
		JTextPane guestBookCommentContent_2 = new JTextPane();
		guestBookCommentContent_2.setBounds(12, 0, 492, 61);
		guestBookCommentPane_2.add(guestBookCommentContent_2);
		
		
		// 두번째 방명록 댓글내용 확인
		JButton guestBookCommentCheckBt_2 = new JButton("확인");
		guestBookCommentCheckBt_2.setBounds(516, 10, 71, 41);
		guestBookCommentPane_2.add(guestBookCommentCheckBt_2);
		
		
		
		// 메인기능 메뉴버튼 패널
//		JPanel guestBookMenuPane = new JPanel();
//		guestBookMenuPane.setBounds(985, 110, 80, 250);
//		frame.getContentPane().add(guestBookMenuPane);
//		this.add(guestBookMenuPane);
//		guestBookMenuPane.setLayout(null);
		
		
//		// 메인기능 메뉴버튼 
//		JButton homeBt = new JButton("홈");
//		homeBt.setBounds(0, 0, 80, 50);
//		guestBookMenuPane.add(homeBt);
//		
//		JButton diaryBt	 = new JButton("다이어리");
//		diaryBt.setBounds(0, 48, 80, 50);
//		guestBookMenuPane.add(diaryBt);
//		
//		JButton galleryBt = new JButton("사진첩");
//		galleryBt.setBounds(0, 99, 80, 50);
//		guestBookMenuPane.add(galleryBt);
//		
//		JButton visitorBt = new JButton("방명록");
//		visitorBt.setBounds(0, 150, 80, 50);
//		guestBookMenuPane.add(visitorBt);
//		
//		JButton settingBt = new JButton("관리");
//		settingBt.setBounds(0, 200, 80, 50);
//		guestBookMenuPane.add(settingBt);
		
//		// 배경색 기본패널
//		JPanel backgroundPane = new JPanel();
//		backgroundPane.setBounds(1085, 41, 160, 200);
//		frame.getContentPane().add(backgroundPane);
//		backgroundPane.setLayout(null);
		
//		// 배경색 변경 라벨 및 버튼
//		JLabel BackgroundColorChange = new JLabel("배경색 변경");
//		BackgroundColorChange.setBounds(0, 0, 160, 34);
//		backgroundPane.add(BackgroundColorChange);
//		
//		JButton BackgroundColorBt_1 = new JButton("New button");
//		BackgroundColorBt_1.setBounds(22, 44, 51, 51);
//		backgroundPane.add(BackgroundColorBt_1);
//		
//		JButton BackgroundColorBt_2 = new JButton("New button");
//		BackgroundColorBt_2.setBounds(85, 44, 51, 51);
//		backgroundPane.add(BackgroundColorBt_2);
//		
//		JButton BackgroundColorBt_3 = new JButton("New button");
//		BackgroundColorBt_3.setBounds(22, 100, 51, 51);
//		backgroundPane.add(BackgroundColorBt_3);
//		
//		JButton BackgroundColorBt_4 = new JButton("New button");
//		BackgroundColorBt_4.setBounds(85, 100, 51, 51);
//		backgroundPane.add(BackgroundColorBt_4);
//		
//		JLabel musicPlaying = new JLabel("플레이 중인 노래");
//		musicPlaying.setBounds(0, 166, 160, 34);
//		backgroundPane.add(musicPlaying);
//		
//		JButton logoutBt = new JButton("로그아웃/종료");
//		logoutBt.setBounds(1155, 264, 90, 30);
//		frame.getContentPane().add(logoutBt);
		
		// 프로필 기본 패널
		JPanel profilePane = new JPanel();
		profilePane.setBounds(0, 0, 260, 600);
//		frame.getContentPane().add(profilePane);
		profilePane.setLayout(null);
		this.add(profilePane);
		
		// today 조회수 라벨
		JLabel todayLabel = new JLabel("Today");
		todayLabel.setBounds(29, 29, 42, 15);
		profilePane.add(todayLabel);
		
		JLabel todayNo = new JLabel("1234");
		todayNo.setBounds(75, 29, 42, 15);
		profilePane.add(todayNo);
		
		
		// total 전체 조회수 라벨
		JLabel totalLabel = new JLabel("Total");
		totalLabel.setBounds(120, 29, 42, 15);
		profilePane.add(totalLabel);
		
		JLabel totalNo = new JLabel("1234");
		totalNo.setBounds(168, 29, 42, 15);
		profilePane.add(totalNo);
		
		JLabel profilePhoto = new JLabel("프로필 사진");
		profilePhoto.setBounds(19, 74, 220, 170);
		profilePane.add(profilePhoto);
		
		// 프로필 내용
		JScrollPane profileScrollPane = new JScrollPane();
		profileScrollPane.setBounds(19, 260, 220, 170);
		profilePane.add(profileScrollPane);
		
		JTextArea profileContent = new JTextArea();
		profileContent.setText("프로필 설명");
		profileScrollPane.setViewportView(profileContent);
		JPanel panel_7 = new JPanel();

		// 프로필 메뉴 버튼
		JButton profileEditBt = new JButton("EDIT");
		profileEditBt.setBounds(19, 465, 66, 23);
		profilePane.add(profileEditBt);
		
		JButton profileHistoryBt = new JButton("HISTORY");
		profileHistoryBt.setBounds(86, 465, 87, 23);
		profilePane.add(profileHistoryBt);
		
		
		// 유저 정보 패널
		JPanel UserInfoPane = new JPanel();
		UserInfoPane.setBounds(19, 496, 220, 68);
		profilePane.add(UserInfoPane);
		UserInfoPane.setLayout(null);
		
		JLabel UserName = new JLabel("이름");
		UserName.setBounds(12, 10, 52, 15);
		UserInfoPane.add(UserName);
		
		JLabel UserSexbirth = new JLabel("(성별) 생년월일");
		UserSexbirth.setBounds(74, 10, 52, 15);
		UserInfoPane.add(UserSexbirth);
		
		JLabel UserCyworldAddr = new JLabel("싸이월드 주소");
		UserCyworldAddr.setBounds(12, 35, 196, 15);
		UserInfoPane.add(UserCyworldAddr);
		

	}
}
