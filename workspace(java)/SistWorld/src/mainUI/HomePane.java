package mainUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import db.DBConnection;
import model.Member;
import service.FileAllDelete;
import service.FriendCheck;
import service.ImageResizeUpload;
import service.MasterSession;
public class HomePane extends JPanel{
	
	DBConnection dbc = DBConnection.getInstance();
	MasterSession ms = MasterSession.getInstance();

	// 멤버정보
	Member member;

	// 홈 메뉴 - 세부 메인 패널
	private JPanel mainDetailPane;
	
	// 홈 메뉴 - 세부 프로필 패널
	private ProfilePane mainProfilePane;

	// 홈 메뉴 - 세부 메인 컴포넌트
	private JLabel homeImgLb;
	private JButton homeImgModifyBt;
	private JLabel friendLb;
	private JTextField friendTf;
	private RoundedButton freindBt;
	
	// 홈 - 일촌평관련
	DefaultTableModel model;
	JTable cmtTb;
	
	public void subSetting() {
		homeImgModifyBt.setVisible(false);
		//일촌 여부
		int friend = new FriendCheck(member.getMember_id(), ms.getMaster_id()).FriendCheckR();
		if(friend > 0) {
			friendTf.setVisible(true);
			freindBt.setVisible(true);
		}
	}

	public HomePane(Member member) {
		MasterSession ms = MasterSession.getInstance();
		this.member = member;
		
		// 세부 메인, 세부 프로필을 담는 패널
		this.setBounds(40, 40, 910, 600);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		// 홈 메뉴 - 세부 프로필 패널
		this.add(new ProfilePane(ms.getMaster_id(), member));

		// 홈 메뉴 - 세부 메인 패널
		mainDetailPane = new JPanel();
		mainDetailPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		mainDetailPane.setBounds(260, 0, 650, 600);
		mainDetailPane.setBackground(Color.WHITE);
		mainDetailPane.setLayout(null);

		// 홈 메뉴 - 미니룸 사진(라벨에 맞게 사이즈 재설정)
		homeImgLb = new JLabel();
		Image homeImg = new ImageIcon
				(member.getHome_miniroom()).getImage();
		Image homeImgResize = homeImg.getScaledInstance(530, 310, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizeIcon = new ImageIcon(homeImgResize);
		
		// 홈 메뉴 - 미니룸 사진 수정 버튼
		homeImgModifyBt = new JButton();
		homeImgModifyBt.setForeground(Color.GRAY);
		homeImgModifyBt.setText("Edit");
		homeImgModifyBt.setOpaque(false);
		homeImgModifyBt.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		homeImgModifyBt.setContentAreaFilled(false);
		homeImgModifyBt.setBorder(null);
		homeImgModifyBt.setBackground(Color.GRAY);
		homeImgModifyBt.setBounds(60, 340, 42, 20);
		mainDetailPane.add(homeImgModifyBt);
		
		imgHandler ihandler = new imgHandler();
		homeImgModifyBt.addActionListener(ihandler);

		homeImgLb.setIcon(resizeIcon);
		homeImgLb.setBounds(60, 30, 530, 310);
		mainDetailPane.add(homeImgLb);

		this.add(mainDetailPane, "mainDetail");
		
		friendLb = new JLabel("일촌평");
		friendLb.setHorizontalAlignment(SwingConstants.LEFT);
		friendLb.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		friendLb.setForeground(new Color(9, 131, 178));
		friendLb.setBounds(60, 370, 40, 20);
		mainDetailPane.add(friendLb);
		
		friendTf = new JTextField();
		friendTf.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		friendTf.setBounds(101, 372, 430, 20);
		mainDetailPane.add(friendTf);
		friendTf.setColumns(10);
		friendTf.setVisible(false);
		
		freindBt = new RoundedButton("남기기");
		freindBt.setOpaque(false);
		freindBt.setHorizontalAlignment(SwingConstants.LEFT);
		freindBt.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		freindBt.setBounds(535, 372, 55, 20);
		freindBt.setVisible(false);
		mainDetailPane.add(freindBt);
		freindBt.addActionListener(new cmtHandler());

		// 일촌평
		model = dbc.friendCmt(member.getMember_id());

		// 일촌평 헤더 "friend_id","cmt","nick","name"
		cmtTb = new CustomJTable(model);
		cmtTb.getColumnModel().getColumn(1).setPreferredWidth(300); //셀크기 조정
		cmtTb.getColumnModel().getColumn(2).setPreferredWidth(40); //셀크기 조정
		cmtTb.getColumnModel().getColumn(3).setPreferredWidth(20); //셀크기 조정
		cmtTb.getColumnModel().getColumn(0).setWidth(0); //친구아이디 숨김
		cmtTb.getColumnModel().getColumn(0).setMinWidth(0); //친구아이디 숨김
		cmtTb.getColumnModel().getColumn(0).setMaxWidth(0); //친구아이디 숨김
		cmtTb.setTableHeader(null);
		cmtTb.addMouseListener(new tableListener());

		JScrollPane jsp = new CustomJsp
				(cmtTb,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.addMouseListener(new tableListener());
		jsp.setBorder(new EmptyBorder(0, 0, 0, 0));
		jsp.setSize(530, 170);
		jsp.setLocation(60, 400);
		mainDetailPane.add(jsp);
		
		if(!ms.getMaster_id().equals(member.getMember_id())) {
			subSetting();
		}

	}
	
	//일촌평 추가
	public class cmtHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int result = dbc.addFreindCmt
			(member.getMember_id(), ms.getMaster_id(), friendTf.getText());
			
			if(result > 0) {
				friendTf.setText("");
				friendTf.requestFocus(); //커서이동
				
				model.setRowCount(0); //전체 화면 지워줌
				model = dbc.friendCmt(member.getMember_id());
				cmtTb.setModel(model);
				cmtTb.getColumnModel().getColumn(1).setPreferredWidth(300); //셀크기 조정
				cmtTb.getColumnModel().getColumn(2).setPreferredWidth(40); //셀크기 조정
				cmtTb.getColumnModel().getColumn(3).setPreferredWidth(20); //셀크기 조정
				cmtTb.getColumnModel().getColumn(0).setWidth(0); //친구아이디 숨김
				cmtTb.getColumnModel().getColumn(0).setMinWidth(0); //친구아이디 숨김
				cmtTb.getColumnModel().getColumn(0).setMaxWidth(0); //친구아이디 숨김
				
			} else {
				
			}
			
		}
		
	}
	//미니룸 사진 변경
	public class imgHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ImageResizeUpload iru = 
				new ImageResizeUpload("img", member.getMember_id(), 530, 310);
			
			if(!iru.getUserImgPath().equals("NotExistFile")) {
				homeImgLb.setIcon(iru.getResizeIcon());
				
				//이전 미니룸 사진 삭제
				File file = new File(member.getHome_miniroom());
				if(!file.getName().equals("home.JPG")) {
					file.delete();
				}
				member.setHome_miniroom(iru.getUserImgPath());
				member = dbc.modifyMySetting("miniroom", member);
			}
	
		}
		
	}
	
	//일촌평 파도타기 액션
	private class tableListener extends MouseAdapter {

	    @Override
	    public void mouseClicked(MouseEvent e) {

		    try {
		    	if (e.getClickCount() == 1) {
			    	int row = cmtTb.getSelectedRow();
			    	System.out.println("[HomePane-friend]:"+cmtTb.getModel().getValueAt(row,0)); //가로, 세로
			    	String friend_id = (String) cmtTb.getModel().getValueAt(row,0);
			    	String friend_name = (String) cmtTb.getModel().getValueAt(row,3);
			    	
			    	int rs = JOptionPane.showConfirmDialog
							(null, friend_name+"에게 파도 탈까요?","파도타기",JOptionPane.YES_NO_OPTION);
			        if(rs == JOptionPane.YES_OPTION) {
				    	boolean memberCheck = dbc.memberCheck(friend_id);
				    	if(memberCheck) {
				    		new HomeFrame(friend_id);
				    	} else {
				    		JOptionPane.showMessageDialog
							(null, "이런... 탈퇴한 회원입니다!X_X","파도타기 실패", JOptionPane.ERROR_MESSAGE);
				    	}
			        }
		
			    }
	    	} catch (Exception eee) {
				System.out.println("선택된 일촌평 없음");
			}
	    }
	}

}
