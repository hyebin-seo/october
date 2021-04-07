package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;

public class GalleryPane extends JPanel {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String filepath;

	int flag = 0; //버튼을 만들기 위한 변수 
	
	
	private JFrame frame;
	
	
	
	// 사진첩 목록 패널
	private JPanel photoSidelist;

	// 사진첩 목록 버튼
	private RoundedButton allBtn;
	private RoundedButton firstBtn = null;
	private RoundedButton SecondBtn = null;
	private RoundedButton ThirdBtn = null;
	private RoundedButton handleBtn = null;

	// 사진첩메인 패널
	private JPanel photoMain;
	private JLabel lblNoexist;

	// 사진첩메인 라벨 및 check box
	private JLabel showDialog;
	private JCheckBox Checkbox1;
	private JCheckBox Checkbox2;
	private JCheckBox Checkbox3;
	private ButtonGroup bg;

	// 사진 업로드 하는 버튼
	private RoundedButton uploadBtn;
	private JLabel preLabel;
	private RoundedButton finalUpload;
	private JTextArea uploadText;
	private RoundedButton cancelBtn;

	// 사진 댓글 라벨 및 댓글 텍스트필드 및 텍스트area
	private JLabel commentLable;
	private JTextField commentTextField;
	private JTextArea commentTextArea;
	private JPanel commentPanel;
	private JScrollBar commentScroll;
	private JPanel uploadPanel;
	private RoundedButton savePhoto;
	private JPanel prepanel;

	public GalleryPane() {

		this.setBounds(40, 40, 910, 600);
		setLayout(null);

		// 사진 업로드 버튼

		uploadPanel = new JPanel();
		uploadPanel.setBounds(260, 0, 650, 600);
		uploadPanel.setBackground(Color.white);
		add(uploadPanel);
		uploadPanel.setLayout(null);
		uploadPanel.setVisible(false);

		prepanel = new JPanel();
		prepanel.setBounds(12, 10, 626, 414);
		uploadPanel.add(prepanel);
		prepanel.setLayout(null);

		savePhoto = new RoundedButton("Click!!!");
		savePhoto.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		savePhoto.setBounds(0, 0, 77, 23);
		prepanel.add(savePhoto);

		preLabel = new JLabel("");
		preLabel.setBounds(12, 44, 602, 360);
		prepanel.add(preLabel);

		finalUpload = new RoundedButton("저장");
		finalUpload.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		finalUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblNoexist.setVisible(false);
				uploadPanel.setVisible(false);
				photoMain.setVisible(true);
				
			}
		});
		finalUpload.setBounds(431, 0, 91, 23);
		prepanel.add(finalUpload);

		cancelBtn = new RoundedButton("취소");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				photoMain.setVisible(true);
				uploadPanel.setVisible(false);
				preLabel.setIcon(null);
				uploadText.setText(null);
				
			}
		});
		cancelBtn.setBounds(534, 0, 91, 23);
		prepanel.add(cancelBtn);

		uploadText = new JTextArea();
		uploadText.setBorder(new LineBorder(Color.gray, 1));
		uploadText.setLineWrap(true);
		uploadText.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		uploadText.setForeground(Color.LIGHT_GRAY);
		uploadText.setBounds(12, 431, 626, 159);
		uploadPanel.add(uploadText);
		savePhoto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // 사진 이미지 불러오는 메서드
				JFileChooser chooser = new JFileChooser();
				JLabel imageLabel = new JLabel();

				FileNameExtensionFilter filter = new FileNameExtensionFilter("Images File", "jpg", "jpeg", "gif",
						"png");
				chooser.setFileFilter(filter);

				int ret = chooser.showOpenDialog(null);
				if (ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				} else {
					System.out.println(chooser.getSelectedFile().getPath());
					File f = chooser.getSelectedFile();
//					fileSave(f, "C:\\NCS\\workspace(java)\\Project\\img2", f.getName());

				}

				String filePath = chooser.getSelectedFile().getPath();
				preLabel.setIcon(new ImageIcon(filePath));

			}
		});

		// 사진첩 패널 및 목록 버튼
		photoSidelist = new JPanel();
		photoSidelist.setBounds(0, 0, 259, 600);
		photoSidelist.setBorder(new LineBorder(Color.gray, 1));
		photoSidelist.setBackground(Color.white);
		photoSidelist.setForeground(Color.BLACK);
		this.add(photoSidelist);
		photoSidelist.setLayout(null);

		// sidepanel 버튼(전체보기, Add앨범, firstBtn, SecondBtn, ThirdBtn 이벤트 및 속성)

		allBtn = new RoundedButton("전체보기");
		allBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		allBtn.setBounds(0, 51, 260, 23);
		photoSidelist.add(allBtn);

		RoundedButton AddBtn = new RoundedButton("Add 앨범");
		AddBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println(flag);

				// sidepanel 버튼 생성 이벤트 작업
				if (flag <= 0) {

					firstBtn = new RoundedButton(JOptionPane.showInputDialog("원하신는 이름을 적어주세요"));
					if (firstBtn != null) {
						firstBtn.setBounds(18, 102, 99, 61);
						firstBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
						photoSidelist.add(firstBtn);
						firstBtn.setVisible(false);
						firstBtn.setVisible(true);
						flag++;
					} else {
					}

				} else if (flag > 0 && flag <= 1) {
					ThirdBtn = new RoundedButton(JOptionPane.showInputDialog("원하신는 이름을 적어주세요"));
					ThirdBtn.setBounds(140, 102, 99, 61);
					ThirdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
					photoSidelist.add(ThirdBtn);
					ThirdBtn.setVisible(false);
					ThirdBtn.setVisible(true);
					flag++;

				} else if (flag > 1 && flag <= 2) {
					SecondBtn = new RoundedButton(JOptionPane.showInputDialog("원하신는 이름을 적어주세요"));
					SecondBtn.setBounds(18, 193, 99, 61);
					SecondBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
					photoSidelist.add(SecondBtn);
					SecondBtn.setVisible(false);
					SecondBtn.setVisible(true);
					flag++;

				} else if (flag == 3) {

					JOptionPane.showMessageDialog(null, "더이상 사진첩 메뉴를 만들 수 없습니다.");

				}

			}
		});

		handleBtn = new RoundedButton("폴더관리하기 >>");
		handleBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		handleBtn.setBounds(0, 551, 260, 45);
		photoSidelist.add(handleBtn);

		// sidepanel에서 생성된 버튼을 블러처리하는 이벤트
		handleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = null;
				name = JOptionPane.showInputDialog("삭제할 폴더의 이름을 작성해주세요");

				System.out.println(firstBtn.getText());
				System.out.println(name);
				System.out.println(flag);
				if (name.equals(firstBtn.getText())) {
					System.out.println(name);
					System.out.println(firstBtn.getText());
					firstBtn.setVisible(false);
					flag--;
				} else if (name.equals(SecondBtn.getText())) {
					System.out.println(name);
					System.out.println(SecondBtn.getText());
					SecondBtn.setVisible(false);
					flag--;
				} else if (name.equals(ThirdBtn.getText())) {
					System.out.println(name);
					System.out.println(ThirdBtn.getText());
					ThirdBtn.setVisible(false);
					flag--;
				} else if (name.equals(null)) {
					System.out.println(name);
					System.out.println("실수햇지롱~");
				}
			}
		});

		AddBtn.setBounds(0, 0, 91, 23);
		photoSidelist.add(AddBtn);

		// 사진첩 메인 패널 및 라벨,checkbox
		photoMain = new JPanel();
		photoMain.setBorder(new LineBorder(Color.gray, 1));
		photoMain.setBounds(260, 0, 650, 600);
		photoMain.setBackground(Color.WHITE);
		this.add(photoMain);
		photoMain.setLayout(null);

		showDialog = new JLabel("전체보기입니다.");
		showDialog.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		showDialog.setBounds(12, 5, 93, 15);
		photoMain.add(showDialog);

		Checkbox1 = new JCheckBox("펼쳐보기");
		Checkbox1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		Checkbox1.setBounds(12, 23, 73, 23);
		Checkbox1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showDialog.setText(Checkbox1.getText());

			}
		});
		photoMain.add(Checkbox1);

		Checkbox2 = new JCheckBox("작게보기");
		Checkbox2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		Checkbox2.setBounds(88, 23, 73, 23);
		Checkbox2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showDialog.setText(Checkbox2.getText());

			}
		});
		photoMain.add(Checkbox2);

		Checkbox3 = new JCheckBox("슬라이드");
		Checkbox3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
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

		commentPanel = new JPanel();
		commentPanel.setBounds(53, 443, 530, 157);
		photoMain.add(commentPanel);
		commentPanel.setBackground(Color.GRAY);
		commentPanel.setLayout(null);

		// 사진 댓글 라벨 및 댓글 텍스트필드 및 텍스트Area
		commentLable = new JLabel("댓    글 : ");
		commentLable.setBounds(32, 37, 63, 17);
		commentPanel.add(commentLable);
		commentLable.setFont(new Font("굴림", Font.PLAIN, 14));

		commentTextField = new JTextField();
		commentTextField.setBounds(107, 36, 337, 21);
		commentPanel.add(commentTextField);
		commentTextField.setColumns(10);

		commentTextArea = new JTextArea();
		commentTextArea.setLineWrap(true);
		commentTextArea.setBorder(new LineBorder(Color.gray, 1));
		commentTextArea.setBounds(107, 62, 337, 85);
		commentPanel.add(commentTextArea);

		commentScroll = new JScrollBar();
		commentScroll.setBounds(427, 67, 17, 80);
		commentPanel.add(commentScroll);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(427, 63, 17, 84);
		commentPanel.add(scrollBar);

		uploadBtn = new RoundedButton("업로드");
		uploadBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		uploadBtn.setBounds(559, 47, 91, 23);
		photoMain.add(uploadBtn);

		lblNoexist = new JLabel("등록된 게시물이 없습니다!!");
		lblNoexist.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNoexist.setBounds(197, 226, 265, 65);
		lblNoexist.setFont(new Font("굴림", Font.PLAIN, 20));
		photoMain.add(lblNoexist);
		uploadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uploadPanel.setVisible(true);
				photoMain.setVisible(false);
			}
		});

	}

	// DB연동하는 메서드

	private void connect() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String password = "1234";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//
	public void insert() {

		try {
			String sql = "insert into sidepanel values(?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, firstBtn.getText());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}