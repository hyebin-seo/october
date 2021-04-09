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
import db.MemberDAO;
import model.Member;
import service.ImageResizeUpload;
public class HomePane extends JPanel{
	
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
	private JTextField frienTf;
	private RoundedButton freindBt;
	
	// 홈 - 일촌평관련
	DefaultTableModel model;
	JTable cmtTb;

	public HomePane(String memeber_id) {
		System.out.println("[HomePane]:"+memeber_id);
		MemberDAO md = MemberDAO.getInstance();
		member = md.get(memeber_id);
		
		// 세부 메인, 세부 프로필을 담는 패널
		this.setBounds(40, 40, 910, 600);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		// 홈 메뉴 - 세부 프로필 패널
		this.add(new ProfilePane(member));

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
		friendLb.setBounds(58, 365, 40, 20);
		mainDetailPane.add(friendLb);
		
		frienTf = new JTextField();
		frienTf.setBounds(99, 367, 430, 20);
		mainDetailPane.add(frienTf);
		frienTf.setColumns(10);
		
		freindBt = new RoundedButton("확인");
		freindBt.setOpaque(false);
		freindBt.setHorizontalAlignment(SwingConstants.LEFT);
		freindBt.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		freindBt.setBounds(533, 367, 55, 20);
		mainDetailPane.add(freindBt);

		// 일촌평
		DBConnection dbc = DBConnection.getInstance();
		model = dbc.friendCmt(member.getMember_id());
		// 일촌평 헤더 "index","cmt","nick","name"
		cmtTb = new JTable(model);
		cmtTb.setRowHeight(25);
		cmtTb.setRowMargin(0);
		cmtTb.setIntercellSpacing(new Dimension(0, 0));
		cmtTb.setGridColor(Color.WHITE);
		cmtTb.setForeground(Color.DARK_GRAY);
		cmtTb.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cmtTb.setShowVerticalLines(false);
		cmtTb.setShowHorizontalLines(false);
		cmtTb.setShowGrid(false);
		cmtTb.setOpaque(false);
		cmtTb.setBorder(new EmptyBorder(0, 0, 0, 0));
		cmtTb.setBackground(Color.WHITE);
		cmtTb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cmtTb.getColumnModel().getColumn(1).setPreferredWidth(300);
		cmtTb.getColumnModel().getColumn(2).setPreferredWidth(20);
		cmtTb.getColumnModel().getColumn(3).setPreferredWidth(20);
		cmtTb.getColumnModel().getColumn(0).setWidth(0);
		cmtTb.getColumnModel().getColumn(0).setMinWidth(0);
		cmtTb.getColumnModel().getColumn(0).setMaxWidth(0);
		cmtTb.setTableHeader(null);
		cmtTb.addMouseListener(new tableListener());

		// 테이블 셀 정렬 렌더러
		DefaultTableCellRenderer dtcr = 
				new DefaultTableCellRenderer();

		dtcr.setHorizontalAlignment(SwingConstants.RIGHT);

		for (int i = 0; i < model.getColumnCount(); i++) {
			cmtTb.getColumn("name").setCellRenderer(dtcr);
		}
		
		JScrollPane jsp = new JScrollPane
				(cmtTb,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setForeground(Color.GRAY);
		jsp.setBorder(new EmptyBorder(0, 0, 0, 0));
		jsp.setOpaque(false);
		jsp.getViewport().setBackground(Color.WHITE);
		jsp.setEnabled(false);
		jsp.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jsp.addMouseListener(new tableListener());
		jsp.setSize(530, 170);
		jsp.setLocation(60, 397);
		mainDetailPane.add(jsp);

	}
	
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
				DBConnection dbc = DBConnection.getInstance();
				member = dbc.modifyMySetting("miniroom", member);
			}
	
		}
		
	}
	
	private class tableListener extends MouseAdapter {

	    @Override
	    public void mouseClicked(MouseEvent e) {

	    if (e.getClickCount() == 1) {
	    	int row = cmtTb.getSelectedRow();
	    	int col = cmtTb.getSelectedColumn();
	    	System.out.print(cmtTb.getModel().getValueAt(row,col));
	    }


	    }
	}
}
