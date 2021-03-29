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

	public GalleryPane() {

		this.setBounds(40, 40, 910, 600);
		this.setLayout(null);

		//사진첩  패널 및 목록 버튼 
		photoSidelist = new JPanel();
		photoSidelist.setBackground(Color.PINK);
		photoSidelist.setForeground(Color.BLACK);
		photoSidelist.setBounds(0, 0, 260, 600);
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
		photoMain.setBackground(Color.PINK);
		photoMain.setBounds(260, 0, 650, 600);
		this.add(photoMain);
		photoMain.setLayout(null);
		
		showDialog = new JLabel("전체보기입니다.");
		showDialog.setBounds(12, 5, 93, 15);
		photoMain.add(showDialog);
		
		Checkbox1 = new JCheckBox("펼쳐보기");
		Checkbox1.setBounds(12, 23, 73, 23);
		photoMain.add(Checkbox1);
		
		Checkbox2 = new JCheckBox("작게보기");
		Checkbox2.setBounds(88, 23, 73, 23);
		photoMain.add(Checkbox2);
		
		Checkbox3 = new JCheckBox("슬라이드");
		Checkbox3.setBounds(160, 23, 73, 23);
		photoMain.add(Checkbox3);
		
		bg = new ButtonGroup();
		bg.add(Checkbox1);
		bg.add(Checkbox2);
		bg.add(Checkbox3);
		
        //사진 업로드 버튼
		uploadBtn = new JButton("업로드");
		uploadBtn.setBounds(488, 77, 91, 23);
		photoMain.add(uploadBtn);
		
		//사진 업로드 패널
		
		photoPanel = new JPanel(){
			Image background=new ImageIcon(GalleryPane.class.getResource("../image/image.png")).getImage();
			public void paint(Graphics g) {//그리는 함수
					g.drawImage(background, 0, 0, null);//background를 그려줌
			}
		};
		
		photoPanel.setBounds(51, 100, 530, 310);
		photoMain.add(photoPanel);
		photoPanel.setLayout(null);
			
	    //사진 댓글 라벨 및 댓글 텍스트필드 및 텍스트Area
		commentLable = new JLabel("댓    글 : ");
		commentLable.setFont(new Font("굴림", Font.PLAIN, 14));
		commentLable.setBounds(51, 432, 73, 30);
		photoMain.add(commentLable);
		
		commentTextField = new JTextField();
		commentTextField.setBounds(121, 433, 460, 30);
		photoMain.add(commentTextField);
		commentTextField.setColumns(10);
		
		commentTextArea = new JTextArea();
		commentTextArea.setBounds(51, 474, 530, 73);
		photoMain.add(commentTextArea);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(564, 478, 17, 69);
		photoMain.add(scrollBar_1);
		uploadBtn.addActionListener(new OpenActionListner());
	
	}

}