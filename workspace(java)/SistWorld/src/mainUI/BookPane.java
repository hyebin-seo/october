package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import db.DBConnection;
import model.GuestBookDTO;
import model.Member;
import service.ImageResizeUpload;
import service.MasterSession;
import javax.swing.border.LineBorder;

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
	JScrollPane guestBookScrollPane;

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

//		JPanel profilePane = new ProfilePane(ms.getMaster_id(), member);
//		this.add(profilePane);
		
//		this.setBounds(40, 40, 910, 600);
		this.setBounds(0, 0, 650, 600);
		this.setLayout(null);

		// 방명록 레이아웃 패널
		JPanel guestBookPane = new JPanel();
		guestBookPane.setBorder(null);
		guestBookPane.setBackground(new Color(251,251,251));
		// guestBookScrollPane.setViewportView(guestBookPane);
		// #수정
		guestBookPane.setLayout(new BoxLayout(guestBookPane, BoxLayout.Y_AXIS));

		// 방명록 스크롤 뒷 패널
		guestBookScrollPane = new JScrollPane(guestBookPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // #수정
		guestBookScrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		guestBookScrollPane.setBackground(new Color(251,251,251));
		guestBookScrollPane.setBounds(0, 201, 651, 399);
		guestBookScrollPane.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 속도 조정
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
		ImageResizeUpload iru = new ImageResizeUpload(ms.getMaster_member().getHome_profile_pic(), 134, 134);

		// 방명록 쓰기
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
//		panel.setPreferredSize(new Dimension(611, 210)); // #수정
//		panel.setMinimumSize(new Dimension(611, 210));
//		panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getMinimumSize().height));
		panel.setBounds(0, 0, 650, 201);
		panel.setBackground(Color.WHITE);
		this.add(panel);
		panel.setLayout(null);

		// #수정
		JLabel guestBookMyPhoto = new JLabel("");
		guestBookMyPhoto.setBounds(35, 17, 134, 134);
		guestBookMyPhoto.setIcon(iru.getResizeIcon());
		panel.add(guestBookMyPhoto);

		guestBookMyContent = new JTextArea();
		guestBookMyContent.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		guestBookMyContent.setBackground(new Color(251, 251, 251));
		guestBookMyContent.setBounds(181, 17, 446, 134);
		guestBookMyContent.setLineWrap(true); // #수정
		panel.add(guestBookMyContent);
		
		JButton reBt = new JButton("Re");
		reBt.setOpaque(false);
		reBt.setForeground(Color.GRAY);
		reBt.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		reBt.setContentAreaFilled(false);
		reBt.setBorder(null);
		reBt.setFocusPainted(false);
		reBt.setBounds(135, 161, 26, 20);
		panel.add(reBt);
		reBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageResizeUpload iru = 
						new ImageResizeUpload(ms.getMaster_member().getHome_profile_pic(), 134, 134);
						guestBookMyPhoto.setIcon(iru.getResizeIcon());
				
			}
		});

		// #수정 : 저장된 방명록 불러오기
		ArrayList<GuestBookDTO> gblist = dbc.guestbookOpen(member.getMember_id());
		try {
			if (gblist.size() > 0) {
				for (int i = 0; i < gblist.size(); i++) {
					JPanel gbPane = new Gbpane(member, gblist.get(i));
					guestBookPane.add(gbPane);
				}
				Runnable doScroll = new Runnable() {
					   public void run() {
						   guestBookScrollPane.getVerticalScrollBar().setValue(0);
					   }
					  };
					  SwingUtilities.invokeLater(doScroll);

			}
		} catch (Exception e) {
			System.out.println("[BookPane]: 남겨진 방명록 없음");
		}

		// 글쓰기

		RoundedButton guestBookMyWriteBt = new RoundedButton("글쓰기");
		guestBookMyWriteBt.setBounds(562, 159, 65, 34);
		guestBookMyWriteBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		panel.add(guestBookMyWriteBt);

		if (member.getMember_id().equals(ms.getMaster_id())) {
			guestBookMyWriteBt.setVisible(false);
		}

		guestBookMyWriteBt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String content = guestBookMyContent.getText();
				String Member_id = member.getMember_id();

				if (content.equals("")) {
					JOptionPane.showMessageDialog(null, "내용을 입력해주세요.", "글쓰기", JOptionPane.ERROR_MESSAGE);
				} else {

					dbc.guestbookwrite(content, Member_id, ms.getMaster_id());

					guestBookMyContent.setText(null);

					dbc.guestbookWriteOpen(member.getMember_id());

					guestBookPane.removeAll();
					ArrayList<GuestBookDTO> gblist = dbc.guestbookOpen(member.getMember_id());
					try {
						if (gblist.size() > 0) {
							for (int i = 0; i < gblist.size(); i++) {
								JPanel gbPane = new Gbpane(member, gblist.get(i));
								guestBookPane.add(gbPane);
							}

						}
					} catch (Exception e) {
						System.out.println("[BookPane]: 남겨진 방명록 없음");
					}

					Runnable doScroll = new Runnable() {
						   public void run() {
							   guestBookScrollPane.getVerticalScrollBar().setValue(0);
						   }
						  };
						  SwingUtilities.invokeLater(doScroll);

						

//					for (int i = 0; i < gbList.size(); i++) {
//						JPanel gbPane = new Gbpane(member, gbList.get(i));
//						//gbPane.setBounds(3, 19, 604, 37*(i+1));
//						guestBookPane.add(gbPane);
//					}

				}

			}
		});

	}
}