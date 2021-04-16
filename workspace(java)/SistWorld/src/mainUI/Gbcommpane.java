package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import db.DBConnection;
import model.GuestBookCommDTO;
import model.Member;
import service.MasterSession;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Gbcommpane extends JPanel {

	private Member member;
	JTextArea guestBookCommentContent;
	DBConnection dbc = DBConnection.getInstance();
	MasterSession ms = MasterSession.getInstance();

	public Gbcommpane(Member gbcmember, GuestBookCommDTO gbcd) {

		this.setBackground(new Color(255, 255, 255));
		this.setBounds(12, 10, 587, 52);
		this.setLayout(null);
		this.member = gbcmember;

		RoundedButton guestBookCommentWriterBt = new RoundedButton(gbcd.getWriter());
		guestBookCommentWriterBt.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		guestBookCommentWriterBt.setBounds(12, 13, 89, 23);
		this.add(guestBookCommentWriterBt);

		guestBookCommentContent = new JTextArea(gbcd.getContent());
		guestBookCommentContent.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		guestBookCommentContent.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		guestBookCommentContent.setEditable(false);
		guestBookCommentContent.setBackground(new Color(251, 251, 251));
		guestBookCommentContent.setBounds(107, 13, 370, 23);
		this.add(guestBookCommentContent);

		RoundedButton gbCommModifyBt = new RoundedButton("수정");
		gbCommModifyBt.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		gbCommModifyBt.setVisible(false);
		gbCommModifyBt.setBounds(489, 13, 45, 23);
		add(gbCommModifyBt);

		RoundedButton gbCommDeleteBt = new RoundedButton("삭제");
		gbCommDeleteBt.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		gbCommDeleteBt.setVisible(false);
		gbCommDeleteBt.setBounds(537, 13, 45, 23);
		add(gbCommDeleteBt);
		
		if(ms.getMaster_id().equals(gbcd.getWriter())) {
			gbCommModifyBt.setVisible(true);
			gbCommDeleteBt.setVisible(true);
			}

		guestBookCommentWriterBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new HomeFrame(gbcd.getWriter());
			}
		});

		gbCommDeleteBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dbc.gbcommDelete(gbcd.getComment_id());
				setVisible(false);
				// guestBookCommentbackPane.setVisible(false);

			}
		});


		gbCommModifyBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == gbCommModifyBt) {

					if (gbCommModifyBt.getText().equals("수정")) {
						gbCommModifyBt.setText("수정완료");
						guestBookCommentContent.setEditable(true);
					} else if (gbCommModifyBt.getText().equals("수정완료")) {
						gbCommModifyBt.setText("수정");
						guestBookCommentContent.setEditable(false);
					}

				}
				
				gbCommModifyBt.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String content = guestBookCommentContent.getText();
						guestBookCommentContent.setText(content);
						String result = dbc.gbcommModify(content, gbcd.getComment_id());
					}
				});

			}
		});
	}
}
