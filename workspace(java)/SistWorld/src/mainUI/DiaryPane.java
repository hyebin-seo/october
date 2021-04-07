package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class DiaryPane extends JPanel {

	// 다이어리 메인 화면
	private JPanel diaryListPane, diaryContPane;
	// 다이어리 메인화면 - 세부 내용 컨테이너
	private JPanel mainDiaryWrap;

	// 다이어리 상단 패널
	private JPanel titlePane;
	// 상단 패널 - 다이어리 작성 날짜, 제목, 날씨 컴포넌트
	private JLabel dateCont, titleCont, weatherCont;

	// 다이어리 중앙 패널
	private JPanel contPane, contSubPane;
	// 중앙 패널 - 다이어리 작성 내용
	private JTextArea txtBoard;
	// 중앙 패널 - 다이어리 작성 날짜, 기분 컴포넌트
	private JLabel boardDate, mood;

	// 다이어리 게시글 상호작용 버튼
	private JPanel boardBtnPane;
	// 게시글 버튼 패널 - 글 추가, 글 수정, 글 삭제 버튼
	private RoundedButton addBtn, upBtn, delBtn;

	// 다이어리 하단 패널
	private JPanel commentPane;
	// 댓글 작성자, 댓글 내용 작성, 댓글 입력 버튼
	private JLabel commName;
	private JTextField commBoard;
	private RoundedButton commBtn;

	// 다이어리 서브화면 - 내용 작성 컨테이너
	private JPanel subDiaryWrap;

	// 서브 다이어리 상단 패널
	private JPanel titleSubPane;
	// 서브 상단 패널 - 제목 작성 컴포넌트, 다이어리 작성 날짜
	private JTextField titleWrite;
	private JLabel dateSubCont, weatherSubCont;
	// 서브 상단 패널 - 날씨 체크 박스
	private JComboBox comboBox;
	private String[] weather = { "맑음", "흐림", "강풍", "비", "번개", "안개" };
	private ImageIcon[] weatherIcon =
		{ new ImageIcon("../images/sunny.png"),
			new ImageIcon("../images/cloud.png"),
			new ImageIcon("../images/wind.png"),
			new ImageIcon("../images/rain.png"),
			new ImageIcon("../images/lightning.png"),
			new ImageIcon("../images/fog.png"), };

	// 서브 다이어리 중앙 패널
	private JPanel contWritePane;
	// 서브 다이어리 중앙 - 글 작성 컴포넌트
	private JTextArea txtWriteBoard;
	// 서브 다이어리 중앙 - 오늘의 기분 버튼
	private JPanel moodBtnPane;
	private JLabel moodDay;
	private JRadioButton happtBtn, smileBtn, soBtn, sadBtn, angryBtn;

	// 서브 다이어리 하단 - 글 작성 확인 버튼
	private JPanel boardBtnSubPane;
	private RoundedButton entBtn;
	private ButtonGroup groupRd;

	public DiaryPane() {

		this.setBounds(40, 40, 910, 600);
		this.setBackground(Color.BLACK);
		setLayout(null);

		diaryListPane = new JPanel();
		diaryListPane.setLayout(null);
		diaryListPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		diaryListPane.setBackground(Color.WHITE);
		diaryListPane.setBounds(0, 0, 260, 600);
		add(diaryListPane);

		diaryContPane = new JPanel();
		diaryContPane.setLayout(null);
		diaryContPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		diaryContPane.setBackground(Color.WHITE);
		diaryContPane.setBounds(260, 0, 650, 600);
		add(diaryContPane);

		mainDiaryWrap = new JPanel();
		mainDiaryWrap.setBackground(Color.WHITE);
		mainDiaryWrap.setBounds(25, 45, 600, 535);
		diaryContPane.add(mainDiaryWrap);
		mainDiaryWrap.setLayout(null);
		mainDiaryWrap.setVisible(true);

		titlePane = new JPanel();
		titlePane.setBorder(new LineBorder(new Color(192, 192, 192)));
		titlePane.setBackground(Color.WHITE);
		titlePane.setBounds(0, 0, 600, 75);
		mainDiaryWrap.add(titlePane);
		titlePane.setLayout(null);

		weatherCont = new JLabel("날씨 아이콘");
		weatherCont.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		weatherCont.setBorder(new LineBorder(new Color(192, 192, 192)));
		weatherCont.setBounds(500, 0, 100, 75);
		weatherCont.setHorizontalAlignment(SwingConstants.CENTER);
		titlePane.add(weatherCont);

		dateCont = new JLabel("04.01");
		dateCont.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		dateCont.setBorder(new LineBorder(new Color(192, 192, 192)));
		dateCont.setBounds(0, 0, 100, 75);
		dateCont.setHorizontalAlignment(SwingConstants.CENTER);
		titlePane.add(dateCont);

		titleCont = new JLabel("글의 제목이 나타나는 곳입니다.");
		titleCont.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		titleCont.setBounds(112, 10, 377, 55);
		titlePane.add(titleCont);

		contPane = new JPanel();
		contPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		contPane.setBackground(Color.WHITE);
		contPane.setBounds(0, 98, 600, 243);
		mainDiaryWrap.add(contPane);
		contPane.setLayout(null);

		txtBoard = new JTextArea();
		txtBoard.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtBoard.setText("내용이 아직 없어요~");
		txtBoard.setLineWrap(true);
		// txtBoard.setEnabled(false); // 비활성화 + 희미하게 처리
		txtBoard.setEditable(false); // 편집기능만 비활성화(드래그,복사 가능)
		txtBoard.setBounds(46, 61, 508, 158);
		contPane.add(txtBoard);

		contSubPane = new JPanel();
		contSubPane.setBackground(Color.WHITE);
		contSubPane.setBounds(12, 10, 576, 30);
		contPane.add(contSubPane);
		contSubPane.setLayout(null);

		boardDate = new JLabel("2021.04.01 목 12:12");
		boardDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		boardDate.setBounds(12, 8, 120, 15);
		contSubPane.add(boardDate);

		mood = new JLabel("행복");
		mood.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		mood.setBounds(144, 8, 39, 15);
		contSubPane.add(mood);

		boardBtnPane = new JPanel();
		boardBtnPane.setBackground(Color.WHITE);
		boardBtnPane.setBounds(0, 345, 600, 40);
		mainDiaryWrap.add(boardBtnPane);
		boardBtnPane.setLayout(null);

		addBtn = new RoundedButton("글쓰기");
		addBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		addBtn.setBounds(384, 11, 60, 25);
		addBtn.setBorderPainted(true); // 버튼 테두리 설정
		addBtn.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		boardBtnPane.add(addBtn);

		upBtn = new RoundedButton("수정");
		upBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		upBtn.setBounds(456, 10, 60, 25);
		upBtn.setBorderPainted(true); // 버튼 테두리 설정
		upBtn.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		boardBtnPane.add(upBtn);

		delBtn = new RoundedButton("삭제");
		delBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		delBtn.setBounds(528, 10, 60, 25);
		delBtn.setBorderPainted(true); // 버튼 테두리 설정
		delBtn.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		boardBtnPane.add(delBtn);

		commentPane = new JPanel();
		commentPane.setBackground(Color.WHITE);
		commentPane.setBounds(0, 391, 600, 144);
		mainDiaryWrap.add(commentPane);
		commentPane.setLayout(null);

		commBoard = new JTextField();
		commBoard.setBounds(62, 45, 420, 25);
		commentPane.add(commBoard);
		commBoard.setColumns(10);

		commBtn = new RoundedButton("입력");
		commBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		commBtn.setBounds(494, 45, 60, 25);
		commBtn.setBorderPainted(true); // 버튼 테두리 설정
		commBtn.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		commentPane.add(commBtn);

		commName = new JLabel("쌍쌍용"); //
		commName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		commName.setHorizontalAlignment(JLabel.RIGHT);
		commName.setBounds(12, 51, 50, 15);
		commentPane.add(commName);

		// --------------------------------------------------------------mainPane

		subDiaryWrap = new JPanel();
		subDiaryWrap.setLayout(null);
		subDiaryWrap.setBackground(Color.WHITE);
		subDiaryWrap.setBounds(25, 45, 600, 535);
		diaryContPane.add(subDiaryWrap);
		subDiaryWrap.setVisible(false);

		titleSubPane = new JPanel();
		titleSubPane.setLayout(null);
		titleSubPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		titleSubPane.setBackground(Color.WHITE);
		titleSubPane.setBounds(0, 0, 600, 75);
		subDiaryWrap.add(titleSubPane);

		comboBox = new JComboBox(weather);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox.setBounds(511, 27, 77, 21);
		titleSubPane.add(comboBox);

		weatherSubCont = new JLabel("");
		weatherSubCont.setHorizontalAlignment(SwingConstants.CENTER);
		weatherSubCont.setBorder(new LineBorder(new Color(192, 192, 192)));
		weatherSubCont.setBounds(500, 0, 100, 75);
		titleSubPane.add(weatherSubCont);

		dateSubCont = new JLabel("04.01");
		dateSubCont.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		dateSubCont.setHorizontalAlignment(SwingConstants.CENTER);
		dateSubCont.setBorder(new LineBorder(new Color(192, 192, 192)));
		dateSubCont.setBounds(0, 0, 100, 75);
		titleSubPane.add(dateSubCont);

		titleWrite = new JTextField("제목을 입력하세요.");
		titleWrite.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		titleWrite.setBounds(112, 27, 376, 21);
		titleSubPane.add(titleWrite);
		titleWrite.setColumns(10);

		contWritePane = new JPanel();
		contWritePane.setLayout(null);
		contWritePane.setBorder(new LineBorder(new Color(192, 192, 192)));
		contWritePane.setBackground(Color.WHITE);
		contWritePane.setBounds(0, 98, 600, 243);
		subDiaryWrap.add(contWritePane);

		txtWriteBoard = new JTextArea();
		txtWriteBoard.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		txtWriteBoard.setText("내용을 입력하세요.");
		txtWriteBoard.setBounds(46, 61, 508, 158);
		contWritePane.add(txtWriteBoard);

		moodBtnPane = new JPanel();
		moodBtnPane.setLayout(null);
		moodBtnPane.setBackground(Color.WHITE);
		moodBtnPane.setBounds(12, 10, 576, 30);
		contWritePane.add(moodBtnPane);

		moodDay = new JLabel("오늘의 기분");
		moodDay.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		moodDay.setBounds(12, 7, 70, 15);
		moodBtnPane.add(moodDay);

		happtBtn = new JRadioButton("행복");
		happtBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		happtBtn.setBackground(Color.WHITE);
		happtBtn.setBounds(90, 3, 60, 23);
		moodBtnPane.add(happtBtn);

		smileBtn = new JRadioButton("웃김");
		smileBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		smileBtn.setBackground(Color.WHITE);
		smileBtn.setBounds(154, 3, 60, 23);
		moodBtnPane.add(smileBtn);

		soBtn = new JRadioButton("보통");
		soBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		soBtn.setBackground(Color.WHITE);
		soBtn.setBounds(218, 3, 60, 23);
		moodBtnPane.add(soBtn);
		soBtn.setSelected(true);

		sadBtn = new JRadioButton("슬픔");
		sadBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		sadBtn.setBackground(Color.WHITE);
		sadBtn.setBounds(282, 3, 60, 23);
		moodBtnPane.add(sadBtn);

		angryBtn = new JRadioButton("화남");
		angryBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		angryBtn.setBackground(Color.WHITE);	
		angryBtn.setBounds(346, 3, 60, 23);
		moodBtnPane.add(angryBtn);

		groupRd = new ButtonGroup();
		groupRd.add(happtBtn);
		groupRd.add(smileBtn);
		groupRd.add(soBtn);
		groupRd.add(sadBtn);
		groupRd.add(angryBtn);

		boardBtnSubPane = new JPanel();
		boardBtnSubPane.setLayout(null);
		boardBtnSubPane.setBackground(Color.WHITE);
		boardBtnSubPane.setBounds(0, 345, 600, 40);
		subDiaryWrap.add(boardBtnSubPane);

		entBtn = new RoundedButton("확인");
		entBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		entBtn.setBounds(528, 10, 60, 25);
		entBtn.setBorderPainted(true); // 버튼 테두리 설정
		entBtn.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		boardBtnSubPane.add(entBtn);

		// --------------------------------------------------------------subPane

		// 새 글 추가 버튼
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainDiaryWrap.setVisible(false); // 창이 안보이게
				subDiaryWrap.setVisible(true); // 창이 보이게
			}
		});

		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 날씨 선택
				JComboBox wcb = (JComboBox) e.getSource(); // 동작이 일어날 소스를 JComboBox 형태로 받음.
				int weather_index = wcb.getSelectedIndex(); //콤보박스에서 선택된 번호 값으로 저장함.
				weatherCont.setIcon(weatherIcon[weather_index]);
				
			}
		});
		
		
		

		
		
		// 새 글 작성 후 완료 버튼
		entBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// 제목 작성
				String title_data = titleWrite.getText();
				titleCont.setText(title_data);

				// 본문 작성
				String board_data = txtWriteBoard.getText();
				txtBoard.setText(board_data);


				mainDiaryWrap.setVisible(true);// 창이 다시 보이게
				subDiaryWrap.setVisible(false); // 창이 안보이게

			}
		});

	}
}
