package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;


public class GalleryPane extends JPanel{

	private JFrame frame;
	
	//사진첩 목록 패널
	private JPanel photoSidelist;
	
	//사진첩 목록 버튼 
	private JButton allBtn;
	private RoundedButton firstBtn;
	private RoundedButton SecondBtn;
	private RoundedButton ThirdBtn;
	private RoundedButton handleBtn;
	
	//사진첩메인 패널 
	private JPanel photoMain;
	
	//사진첩메인 라벨 및 check box
	private  JLabel showDialog; 
	private JCheckBox Checkbox1;
	private JCheckBox Checkbox2;
	private JCheckBox Checkbox3;
	private ButtonGroup bg;
	
	// 사진 업로드 하는 버튼 
	private JButton uploadBtn;
	
	// 사진 업로드되는 패널
	private JPanel photoPanel;
	
	//사진 댓글 라벨 및 댓글 텍스트필드 및 텍스트area
	private JLabel commentLable;
	private JTextField commentTextField;
	private JTextArea commentTextArea;
	private JPanel commentPanel;
	private JScrollBar commentScroll;
	private JPanel uploadPanel;
	private JButton savePhoto;

	public GalleryPane() {

		this.setBounds(40, 40, 910, 600);
		setLayout(null);

		//사진첩  패널 및 목록 버튼 
		photoSidelist = new JPanel();
		photoSidelist.setBounds(0, 0, 260, 600);
		photoSidelist.setBackground(Color.PINK);
		photoSidelist.setForeground(Color.BLACK);
		this.add(photoSidelist);
		photoSidelist.setLayout(null);
		
		allBtn = new RoundedButton("전체보기");
		allBtn.setBounds(73, 10, 99, 23);
		photoSidelist.add(allBtn);
		
		firstBtn = new RoundedButton("♥ 일촌공개 ♥");
		firstBtn.setBounds(73, 57, 112, 23);
		photoSidelist.add(firstBtn);
		
		SecondBtn = new RoundedButton("♥ 일촌공개 ♥");
		SecondBtn.setText("「 우리 아이들 ♥」");
		SecondBtn.setBounds(73, 106, 112, 23);
		photoSidelist.add(SecondBtn);
		
		ThirdBtn = new RoundedButton("♥ 일촌공개 ♥");
		ThirdBtn.setText("「 우리 남편♥」");
		ThirdBtn.setBounds(73, 171, 112, 23);
		photoSidelist.add(ThirdBtn);
		
        handleBtn = new  RoundedButton("폴더관리하기 >>");
        handleBtn.setBounds(62, 529, 136, 49);
		photoSidelist.add(handleBtn);
		
		//사진첩 메인 패널 및 라벨,checkbox
		photoMain= new JPanel();
		photoMain.setBounds(260, 0, 650, 600);
		photoMain.setBackground(Color.PINK);
		this.add(photoMain);
		photoMain.setLayout(null);
		
		showDialog = new JLabel("전체보기입니다.");
		showDialog.setBounds(12, 5, 93, 15);
		photoMain.add(showDialog);
		
		Checkbox1 = new JCheckBox("펼쳐보기");
		Checkbox1.setBounds(12, 23, 73, 23);
        Checkbox1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showDialog.setText(Checkbox1.getText());
				
			}
		});
		photoMain.add(Checkbox1);
		
		Checkbox2 = new JCheckBox("작게보기");
		Checkbox2.setBounds(88, 23, 73, 23);
        Checkbox2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showDialog.setText(Checkbox2.getText());
				
			}
		});
		photoMain.add(Checkbox2);
		
		Checkbox3 = new JCheckBox("슬라이드");
		Checkbox3.setBounds(160, 23, 73, 23);
        Checkbox3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showDialog.setText(Checkbox3.getText());
				
			}
		});
		photoMain.add(Checkbox3);
		
		bg = new ButtonGroup();
		bg.add(Checkbox1);
		bg.add(Checkbox2);
		bg.add(Checkbox3);
		
		//사진 업로드 패널
		
		photoPanel = new JPanel();
		photoPanel.setBounds(53, 80, 530, 358);
		photoMain.add(photoPanel);
		photoPanel.setLayout(null);
		
        //사진 업로드 버튼
		
		uploadPanel = new JPanel();
		uploadPanel.setBackground(Color.YELLOW);
		uploadPanel.setBounds(260, 73, 650, 368);
		add(uploadPanel);
		uploadPanel.setLayout(null);
		uploadPanel.setVisible(false);
		
		uploadBtn = new JButton("업로드");
		uploadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uploadPanel.setVisible(true);
				photoMain.setVisible(false); 
			}
		});
		uploadBtn.setBounds(218, 142, 91, 55);
		photoPanel.add(uploadBtn);
		
		commentPanel = new JPanel();
		commentPanel.setBounds(53, 443, 530, 157);
		photoMain.add(commentPanel);
		commentPanel.setBackground(Color.GRAY);
		commentPanel.setLayout(null);
		
	    //사진 댓글 라벨 및 댓글 텍스트필드 및 텍스트Area
		commentLable = new JLabel("댓    글 : ");
		commentLable.setBounds(32, 37, 63, 17);
		commentPanel.add(commentLable);
		commentLable.setFont(new Font("굴림", Font.PLAIN, 14));
		
		commentTextField = new JTextField();
		commentTextField.setBounds(107, 36, 337, 21);
		commentPanel.add(commentTextField);
		commentTextField.setColumns(10);
		
		commentTextArea = new JTextArea();
		commentTextArea.setBounds(107, 62, 337, 85);
		commentPanel.add(commentTextArea);
		
		commentScroll = new JScrollBar();
		commentScroll.setBounds(427, 67, 17, 80);
		commentPanel.add(commentScroll);
		
		
		
		savePhoto = new JButton("불러오기");
		savePhoto.setBounds(0, 0, 91, 23);
		savePhoto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				uploadPanel.setVisible(false);
				photoMain.setVisible(true); 
			}
		});
		uploadPanel.add(savePhoto);
		savePhoto.addActionListener(new OpenActionListner());
	
	}
}