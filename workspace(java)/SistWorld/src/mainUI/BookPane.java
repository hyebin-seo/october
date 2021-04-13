package mainUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import db.DBConnection;
import model.GuestBookDTO;
import model.Member;
import service.ImageResizeUpload;
import service.MasterSession;

public class BookPane extends JPanel {
	
	DBConnection dbc = DBConnection.getInstance();
	MasterSession ms = MasterSession.getInstance();

	DefaultTableModel model;
	JTextArea guestBookMyContent;
	ArrayList<JPanel> paneList = new ArrayList<JPanel>();
	JLabel guestBookNo;
	RoundedButton guestBookName;
	JLabel guestBookWriteTime;
	JLabel guestBookPhoto;
	JTextArea guestBookContent;
	RoundedButton guestBookSecretBt;

	JTextPane guestBookCommentWrite;
	JTextArea guestBookCommentContent;
	

//	JLabel guestBookNo;
//	RoundedButton guestBookName;
//	JLabel guestBookWriteTime;
//	JLabel guestBookPhoto;
//	JTextArea guestBookContent;
//	RoundedButton guestBookSecretBt;

	public BookPane(Member member) {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 1280, 720);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		JPanel profilePane = new ProfilePane(ms.getMaster_id(),member);
		this.add(profilePane);

		this.setBounds(40, 40, 910, 600);
		this.setLayout(null);

		// 방명록 레이아웃 패널
		JPanel guestBookPane = new JPanel();
		guestBookPane.setBackground(Color.WHITE);
		// guestBookScrollPane.setViewportView(guestBookPane);

		// 방명록 스크롤 뒷 패널
		JScrollPane guestBookScrollPane = new JScrollPane(guestBookPane,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
				, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); //#수정
		guestBookScrollPane.setBounds(260, 0, 650, 600);
//		frame.getContentPane().add(guestBookScrollPane);
		this.add(guestBookScrollPane);

		ImageIcon icon = new ImageIcon("images/home3.jpg");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);

		// 첫번째 방명록 사진 라벨
		ImageIcon icon1 = new ImageIcon("images/profile.jpg");
		Image img2 = icon1.getImage();
		Image changeImg2 = img2.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImg2);
		ImageResizeUpload iru = new ImageResizeUpload
		(ms.getMaster_member().getHome_profile_pic(), 134, 134);
		
		//#수정
		guestBookPane.setLayout(new BoxLayout(guestBookPane, BoxLayout.Y_AXIS));

		// 방명록 쓰기
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(611, 210)); //#수정
		panel.setMinimumSize(new Dimension(611, 210));
		panel.setMaximumSize
			(new Dimension(Integer.MAX_VALUE, panel.getMinimumSize().height));
		panel.setBackground(SystemColor.control);
		guestBookPane.add(panel);
		panel.setLayout(null);
		
		//#수정
		JLabel guestBookMyPhoto = new JLabel("");
		guestBookMyPhoto.setBounds(35, 17, 134, 134);
		guestBookMyPhoto.setIcon(iru.getResizeIcon());
		panel.add(guestBookMyPhoto);
		
		guestBookMyContent = new JTextArea();
		guestBookMyContent.setBounds(181, 17, 387, 134);
		guestBookMyContent.setLineWrap(true); //#수정
		panel.add(guestBookMyContent);
		
		//		ArrayList<GuestBookDTO> gbList = dbc.guestbookselect(member);
		//
		//		for (int i = 0; i < gbList.size(); i++) {
		//			JPanel gbPane = new Gbpane(member, gbList.get(i));
		//			guestBookPane.add(gbPane);
		//		}
		
		// 이벤트 처리
		// 눌렀을때 작성한 사람의 방명록 내용이 보이게
		// 이벤트처리

		//

		RoundedButton guestBookMyWriteBt = new RoundedButton("글쓰기");
		guestBookMyWriteBt.setBounds(534, 161, 65, 34);
		guestBookMyWriteBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		panel.add(guestBookMyWriteBt);

		guestBookMyWriteBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String content = guestBookMyContent.getText();
				String Member_id = member.getMember_id();

				dbc.guestbookwrite(content, Member_id, ms.getMaster_id());

				guestBookMyContent.setText(null);

				ArrayList<GuestBookDTO> gbList = dbc.guestbookselect(member);

				for (int i = 0; i < gbList.size(); i++) {
					JPanel gbPane = new Gbpane(member, gbList.get(i));
					//gbPane.setBounds(3, 19, 604, 37*(i+1));
					guestBookPane.add(gbPane);
				}
			}
		});
		
		
		// #수정 : 저장된 방명록 불러오기
		ArrayList<GuestBookDTO> gblist = dbc.guestbookOpen(member.getMember_id());
		try {
			if(gblist.size()>0) {
				for (int i = 0; i < gblist.size(); i++) {
					JPanel gbPane = new Gbpane(member, gblist.get(i));
					guestBookPane.add(gbPane);
				}
			}
		} catch (Exception e) {
			System.out.println("[BookPane]: 남겨진 방명록 없음");
		}
		
		

	}
	
//	private void secret(Member member) {
//		
////		if (member.getMember_id().equals()) {
////			
////		}
//		
//		guestBookSecretBt.setVisible(false);
//		guestBookContent.setText("비밀글입니다");
//	}
}