package mainUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import db.DBConnection;
import model.GuestBookCommDTO;
import model.GuestBookDTO;
import model.Member;
import service.ImageResizeUpload;
import service.MasterSession;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

public class Gbpane extends JPanel{
	
	private Member member;
	DBConnection dbc = DBConnection.getInstance();
	MasterSession ms = MasterSession.getInstance();
	ArrayList<GuestBookDTO> gbList = dbc.guestbookselect(member);
	
	
	JLabel guestBookNo;
	RoundedButton guestBookName;
	JLabel guestBookWriteTime;
	JLabel guestBookPhoto;
	JTextArea guestBookContent;
	RoundedButton guestBookModifyBt;
	
	JTextPane guestBookCommentWrite;
	JPanel guestBookCommentbackPane;
	JScrollPane gbcommScrollPane;

	public Gbpane(Member gbmember, GuestBookDTO gbd) {
		
		// 첫번째 방명록 정보 및 메뉴 패널
		
//		// 방명록 기본 패널
		this.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(150, 150, 150)));
//		this.setBounds(12, 238, 611, 319);
		this.setPreferredSize(new Dimension(630, 319)); //#수정
		this.setBackground(new Color(255, 255, 255));
		this.setLayout(null);
		this.member = gbmember;
	
		JPanel guestBookInfoMenu_1 = new JPanel();
		guestBookInfoMenu_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		guestBookInfoMenu_1.setBackground(new Color(255, 255, 255));
		guestBookInfoMenu_1.setForeground(SystemColor.control);

		guestBookInfoMenu_1.setBounds(13, 19, 604, 37);
		add(guestBookInfoMenu_1);
		guestBookInfoMenu_1.setLayout(null);

		// 첫번째 방명록 정보 라벨
		guestBookNo = new JLabel("no "+gbd.getGb_id());
		guestBookNo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		guestBookNo.setBounds(12, 10, 57, 15);
		guestBookInfoMenu_1.add(guestBookNo);

		guestBookName = new RoundedButton(gbd.getHost_id());
		guestBookName.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		guestBookName.setBounds(71, 6, 71, 27);
		guestBookInfoMenu_1.add(guestBookName);

		guestBookWriteTime = new JLabel(gbd.getCreate_date().substring(0, 16));
		guestBookWriteTime.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		guestBookWriteTime.setBounds(173, 10, 117, 15);
		guestBookInfoMenu_1.add(guestBookWriteTime);

		// 첫번째 방명록 메뉴 버튼
		guestBookModifyBt = new RoundedButton("수정");
		guestBookModifyBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		guestBookModifyBt.setBounds(470, 7, 63, 23);
		guestBookModifyBt.setVisible(false);
		guestBookInfoMenu_1.add(guestBookModifyBt);

		RoundedButton guestBookDeleteBt = new RoundedButton("삭제");
		guestBookDeleteBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		guestBookDeleteBt.setBounds(534, 7, 57, 23);
		guestBookDeleteBt.setVisible(false);
		guestBookInfoMenu_1.add(guestBookDeleteBt);
		
		if(ms.getMaster_id().equals(gbd.getHost_id())) {
			guestBookModifyBt.setVisible(true);
			guestBookDeleteBt.setVisible(true);
			}
		
		// 방명록 사진 및 내용
		//#수정 : 방명록 남긴 사람의 사진이 떠야하므로 현재 member값을 가져오면 안됩니다.
		String filePath = dbc.guestbookImage(gbd.getHost_id());
		ImageResizeUpload iru = new ImageResizeUpload(filePath, 134, 134);
		guestBookPhoto = new JLabel();
		guestBookPhoto.setOpaque(false);
		guestBookPhoto.setIcon(iru.getResizeIcon());
		guestBookPhoto.setBounds(35, 63, 134, 134);
		add(guestBookPhoto);

		guestBookContent = new JTextArea(gbd.getContent());
		guestBookContent.setBackground(new Color(255, 255, 255));
		guestBookContent.setEditable(false);
		guestBookContent.setBounds(189, 63, 387, 134);
		add(guestBookContent);

		// 방명록 댓글 패널
		JPanel guestBookCommentWritePane = new JPanel();
		guestBookCommentWritePane.setBorder(null);
		guestBookCommentWritePane.setBackground(Color.WHITE);
		guestBookCommentWritePane.setBounds(13, 259, 604, 46);
		add(guestBookCommentWritePane);
		guestBookCommentWritePane.setLayout(null);

		// 방명록 댓글
		guestBookCommentWrite = new JTextPane();
		guestBookCommentWrite.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		guestBookCommentWrite.setBounds(0, 8, 527, 30);
		guestBookCommentWritePane.add(guestBookCommentWrite);

		// 방명록 댓글 쓰기 버튼
		RoundedButton guestBookCommentWriteBt = new RoundedButton("쓰기");
		guestBookCommentWriteBt.setBounds(539, 8, 65, 30);
		guestBookCommentWriteBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		guestBookCommentWritePane.add(guestBookCommentWriteBt);
		
		guestBookCommentbackPane = new JPanel();
		guestBookCommentbackPane.setBorder(null);
		
		guestBookCommentbackPane.setBackground(new Color(255, 255, 255));
		guestBookCommentbackPane.setLayout(new BoxLayout(guestBookCommentbackPane, BoxLayout.Y_AXIS));
		
		gbcommScrollPane = new JScrollPane(guestBookCommentbackPane,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		gbcommScrollPane.setBackground(new Color(255, 255, 255));
		gbcommScrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		gbcommScrollPane.setBounds(13, 205, 604, 52);
		gbcommScrollPane.getVerticalScrollBar().setUnitIncrement(16);
		this.add(gbcommScrollPane);
		
		
		
		
		Dimension size = new Dimension();
		
		size.setSize(611, 60);
		
		guestBookCommentbackPane.setPreferredSize(size); // #수정
		// gbcommScrollPane.setViewportView(guestBookCommentbackPane);
	      guestBookCommentbackPane.setMinimumSize(new Dimension(611, 70));
	      
	      guestBookCommentbackPane.setMaximumSize
	      (new Dimension(Integer.MAX_VALUE, guestBookCommentbackPane.getMinimumSize().height));
		
		
		
		
		ArrayList<GuestBookCommDTO> gbcList = dbc.guestbookcommselect(gbd.getGb_id());
		
		try {
			if (gbcList.size() > 0) {
				for (int i = 0; i < gbcList.size(); i++) {
					JPanel gbcpane = new Gbcommpane(gbmember, gbcList.get(i));
					size.setSize(650, 60*gbcList.size());
					//size.setSize(650, 60+(60*gbcList.size()));
					guestBookCommentbackPane.setPreferredSize(size);
					guestBookCommentbackPane.add(gbcpane);
				}
				
				Runnable doScroll = new Runnable() {
					   public void run() {
						   gbcommScrollPane.getVerticalScrollBar().setValue(0);
					   }
					  };
					  SwingUtilities.invokeLater(doScroll);
			}
			
			
		} catch (Exception e) {
			System.out.println("[BookPane]: 남겨진 댓글 없음");
		}
		
		// 이벤트 처리
		
		// 쓰기 버튼
		guestBookCommentWriteBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			int guestBookNo = gbd.getGb_id();
			String commContent = guestBookCommentWrite.getText();
			String memberId = member.getMember_id();
			
			
			if (commContent.equals("")) {
				JOptionPane.showMessageDialog(null, "내용을 입력해주세요.", "글쓰기", JOptionPane.ERROR_MESSAGE);
			} else {
			//#수정
			dbc.guestbookcommwrite(guestBookNo, commContent, ms.getMaster_id());
			
			guestBookCommentWrite.setText(null);
			
			ArrayList<GuestBookCommDTO> gbcList = dbc.gbcommwriteopen(guestBookNo);
			
			ArrayList<GuestBookCommDTO> gbcList2 = dbc.guestbookcommselect(gbd.getGb_id());
			// guestbookno랑 gbcomm_시퀀스현재값-1 두개를 인자로 해서 보낸 다음에 그것을 where로 해서 select로 부른 다음에
			// 그 rs값에서 content값만 가져와서
			// 여기서 더해주면?
			
			
			size.setSize(650, 60*gbcList2.size() );
			guestBookCommentbackPane.setPreferredSize(size);
			
			JPanel gbcpane = new Gbcommpane(gbmember, gbcList.get((gbcList.size() - 1)));
			guestBookCommentbackPane.add(gbcpane);
			gbcommScrollPane.setViewportView(guestBookCommentbackPane);
			
			Runnable doScroll = new Runnable() {
				   public void run() {
					   gbcommScrollPane.getVerticalScrollBar().setValue((60*(gbcList2.size()-1)));
				   }
				  };
				  SwingUtilities.invokeLater(doScroll);
			
//			for (int i = 0; i < gbcList.size(); i++) {
//				JPanel gbcpane = new Gbcommpane(gbmember, gbcList.get(i));
//				size.setSize(650, 60+(60*(gbcList.size())));
//				guestBookCommentbackPane.setPreferredSize(size);
//				guestBookCommentbackPane.add(gbcpane);
//			}
			
			
			//guestBookCommentbackPane.setPreferredSize(new Dimension(611, 60+(70*(gbcList.size()-1)))); // #수정
			//230+(340*(gbList.size()-1))
			
			
			}
			
			}
		});
		
		// 삭제 버튼
		guestBookDeleteBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DBConnection dbc = DBConnection.getInstance();
				dbc.guestbookdelete(gbd.getGb_id());
				setVisible(false);
				guestBookCommentbackPane.setVisible(false);
				
			}
		});
		
		// 수정 버튼
		guestBookModifyBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == guestBookModifyBt) {

					if (guestBookModifyBt.getText().equals("수정")) {
						guestBookModifyBt.setText("수정완료");
						guestBookContent.setEditable(true);
					}
					else if (guestBookModifyBt.getText().equals("수정완료")) {
						guestBookModifyBt.setText("수정");
						guestBookContent.setEditable(false);
					}
	
				}

				guestBookModifyBt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String content = guestBookContent.getText();
						guestBookContent.setText(content);
						DBConnection dbc = DBConnection.getInstance();
						String result= dbc.guestbookmodify(content,gbd.getGb_id());
						
					}
				});
			}
		});
		
		
		//이동 버튼
		
		guestBookName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new HomeFrame(gbd.getHost_id());
			}
		});
		
		
		
				
	}
}

