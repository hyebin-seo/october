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
		
		ImageIcon icon = new ImageIcon("images/home3.jpg");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		
		// 첫번째 방명록 사진 라벨
		
		ImageIcon icon1 = new ImageIcon("images/profile.jpg");
		Image img2 = icon1.getImage();
		Image changeImg2 = img2.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImg2);
		
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(631, 10, 17, 578);
		guestBookPane.add(scrollBar);
		
		// 방명록 기본 패널
		JPanel guestBookInfoPane = new JPanel();
		guestBookInfoPane.setBounds(12, 0, 611, 305);
		guestBookPane.add(guestBookInfoPane);
		guestBookInfoPane.setLayout(null);
		
		// 첫번째 방명록 정보 및 메뉴 패널
		JPanel guestBookInfoMenu_1 = new JPanel();
		guestBookInfoMenu_1.setBounds(12, 20, 604, 37);
		guestBookInfoPane.add(guestBookInfoMenu_1);
		guestBookInfoMenu_1.setLayout(null);
		
		// 첫번째 방명록 정보 라벨
		JLabel guestBookNo = new JLabel("no 12345");
		guestBookNo.setBounds(12, 10, 57, 15);
		guestBookInfoMenu_1.add(guestBookNo);
		
		JButton guestBookName = new JButton("문형준");
		guestBookName.setBounds(71, 6, 71, 27);
		guestBookInfoMenu_1.add(guestBookName);
		
		JLabel guestBookWriteTime = new JLabel("2021.03.26 00:29");
		guestBookWriteTime.setBounds(173, 10, 117, 15);
		guestBookInfoMenu_1.add(guestBookWriteTime);
		
		
		// 첫번째 방명록 메뉴 버튼
		JButton guestBookSecretBt = new JButton("비밀로 하기");
		guestBookSecretBt.setBounds(356, 7, 102, 23);
		guestBookInfoMenu_1.add(guestBookSecretBt);
		
		JButton guestBookDeleteBt = new JButton("삭제");
		guestBookDeleteBt.setBounds(459, 7, 57, 23);
		guestBookInfoMenu_1.add(guestBookDeleteBt);
		
		JButton guestBookMoveBt = new JButton(changeIcon);
		
		guestBookMoveBt.setBounds(142, 6, 26, 27);
		guestBookInfoMenu_1.add(guestBookMoveBt);
		
		// 첫번째 방명록 내용
		JTextArea guestBookContent = new JTextArea();
		guestBookContent.setBounds(189, 66, 387, 134);
		guestBookInfoPane.add(guestBookContent);
		
		JLabel guestBookPhoto = new JLabel(changeIcon2);
		guestBookPhoto.setBounds(35, 66, 134, 134);
		guestBookInfoPane.add(guestBookPhoto);
			
				
				// 첫번째 방명록 댓글 패널
				JPanel guestBookCommentWritePane = new JPanel();
				guestBookCommentWritePane.setBounds(12, 259, 587, 46);
				guestBookInfoPane.add(guestBookCommentWritePane);
				guestBookCommentWritePane.setLayout(null);
				
				// 첫번째 방명록 댓글
				JTextPane guestBookCommentWrite = new JTextPane();
				guestBookCommentWrite.setBounds(12, 6, 492, 34);
				guestBookCommentWritePane.add(guestBookCommentWrite);
				
				// 첫번째 방명록 확인버튼
				JButton guestBookCommentWriteBt = new JButton("쓰기");
				guestBookCommentWriteBt.setBounds(516, 6, 65, 34);
				guestBookCommentWritePane.add(guestBookCommentWriteBt);
				
				JPanel guestBookCommentbackPane = new JPanel();
				guestBookCommentbackPane.setBounds(0, 198, 607, 61);
				guestBookInfoPane.add(guestBookCommentbackPane);
				guestBookCommentbackPane.setLayout(null);
				
				
				JPanel guestBookCommentInfoPane = new JPanel();
				guestBookCommentInfoPane.setBounds(12, 10, 587, 47);
				guestBookCommentbackPane.add(guestBookCommentInfoPane);
				guestBookCommentInfoPane.setLayout(null);
				
				JButton guestBookCommentWriterBt = new JButton("작성자1");
				guestBookCommentWriterBt.setBounds(12, 10, 89, 23);
				guestBookCommentInfoPane.add(guestBookCommentWriterBt);
				
				JTextArea guestBookCommentContent = new JTextArea();
				guestBookCommentContent.setBounds(107, 0, 480, 47);
				guestBookCommentInfoPane.add(guestBookCommentContent);
		
		
		
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
