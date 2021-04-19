package mainUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import db.DBConnection;
import model.DiaryDTO;
import model.Member;
import service.MasterSession;

public class DiaryPane extends JPanel implements ActionListener, MouseListener {

	DBConnection dbc = DBConnection.getInstance();
	Member member;
	DiaryDTO diarydto;

	// 다이어리 메인 화면
	private JPanel diaryListPane, diaryContPane;

	// 다이어리 카테고리 - 글 리스트
	private DefaultTableModel model;
	private JTable jTable;

	// 다이어리 메인화면 - 세부 내용 컨테이너
	private JPanel mainDiaryWrap;

	// 다이어리 상단 패널
	private JPanel titlePane;
	// 상단 패널 - 다이어리 작성 날짜, 제목, 날씨 컴포넌트
	private JLabel indexCont, titleCont, weatherCont;

	// 다이어리 중앙 패널
	private JPanel contPane, contSubPane;
	// 중앙 패널 - 다이어리 작성 내용
	private JTextArea txtBoard;
	// 중앙 패널 - 다이어리 작성 날짜, 기분 컴포넌트
	private JLabel boardDate, boardDate2, moodCont, boardWeek;

	// 다이어리 게시글 상호작용 버튼
	private JPanel boardBtnPane;
	// 게시글 버튼 패널 - 글 추가, 글 수정, 글 삭제 버튼
	private RoundedButton addBtn, upBtn, delBtn;

	// 다이어리 서브화면 - 내용 작성 컨테이너
	private JPanel subDiaryWrap;

	// 서브 다이어리 상단 패널
	private JPanel titleSubPane;

	// 서브 상단 패널 - 제목 작성 컴포넌트, 다이어리 작성 날짜
	private JTextField titleWrite;
	private JLabel dateSubCont, weatherSubCont;

	// 서브 상단 패널 - 날씨 체크 박스
	private JComboBox comboBox;
	private String[] weather = { "맑음", "흐림", "강풍", "비", "번개", "안개", "눈" };
	private ImageIcon[] weatherIcon = { new ImageIcon("data/images/sunny.png"), new ImageIcon("data/images/cloud.png"),
			new ImageIcon("data/images/wind.png"), new ImageIcon("data/images/rain.png"),
			new ImageIcon("data/images/lightning.png"), new ImageIcon("data/images/fog.png"),
			new ImageIcon("data/images/snow.png") };

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
	private RoundedButton entBtn, updBtn, cnlBtn;
	private ButtonGroup groupRd;

	// 사용 설명 버튼
	private JLabel manuPane;
	private RoundedButton manuBtn, manuBtn2;

	public DiaryPane(Member member) {
		this.member = member;

		this.setBounds(40, 40, 910, 600);
		this.setBackground(Color.BLACK);
		setLayout(null);

		diaryListPane = new JPanel();
		diaryListPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		diaryListPane.setBackground(Color.WHITE);
		diaryListPane.setBounds(0, 0, 260, 600);
		add(diaryListPane);
		diaryListPane.setLayout(null);

		model = dbc.getDiaryList(member.getMember_id());
		jTable = new CustomJTable(model);
		JScrollPane jsp = new CustomJsp(jTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setSize(260, 600);
		jsp.setLocation(0, 0);
		diaryListPane.add(jsp);
		jTable.addMouseListener(this); // 리스너 등록

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

		manuPane = new JLabel();
		manuPane.setBounds(0, 0, 600, 436);
		mainDiaryWrap.add(manuPane);
		manuPane.setVisible(false);
		manuPane.setIcon(new ImageIcon("data/images/diary_img.jpg"));

		titlePane = new JPanel();
		titlePane.setBorder(new LineBorder(new Color(192, 192, 192)));
		titlePane.setBackground(Color.WHITE);
		titlePane.setBounds(0, 0, 600, 75);
		mainDiaryWrap.add(titlePane);
		titlePane.setLayout(null);

		weatherCont = new JLabel();
		weatherCont.setBorder(new LineBorder(new Color(192, 192, 192)));
		weatherCont.setBounds(500, 0, 100, 75);
		weatherCont.setHorizontalAlignment(SwingConstants.CENTER);
		titlePane.add(weatherCont);

		indexCont = new JLabel("");
		indexCont.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		indexCont.setBorder(new LineBorder(new Color(192, 192, 192)));
		indexCont.setBounds(0, 0, 100, 75);
		indexCont.setHorizontalAlignment(SwingConstants.CENTER);
		titlePane.add(indexCont);

		titleCont = new JLabel("");
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
		txtBoard.setText("목록에서 글을 선택해주세요!\n글이 없다면 하단의 '글쓰기' 버튼을 이용하여 첫 글을 작성해 보아요 :)");
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

		boardDate = new JLabel("");
		boardDate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		boardDate.setBounds(12, 8, 67, 15);
		contSubPane.add(boardDate);

		boardWeek = new JLabel("");
		boardWeek.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		boardWeek.setBounds(85, 8, 25, 15);
		contSubPane.add(boardWeek);

		moodCont = new JLabel("");
		moodCont.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		moodCont.setBounds(158, 8, 49, 15);
		contSubPane.add(moodCont);

		boardDate2 = new JLabel("");
		boardDate2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		boardDate2.setBounds(107, 8, 39, 15);
		contSubPane.add(boardDate2);

		boardBtnPane = new JPanel();
		boardBtnPane.setBackground(Color.WHITE);
		boardBtnPane.setBounds(0, 345, 600, 40);
		boardBtnPane.setVisible(true);
		mainDiaryWrap.add(boardBtnPane);
		boardBtnPane.setLayout(null);

		addBtn = new RoundedButton("글쓰기");
		addBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		addBtn.setBounds(384, 11, 60, 25);
		boardBtnPane.add(addBtn);

		upBtn = new RoundedButton("수정");
		upBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		upBtn.setBounds(456, 10, 60, 25);
		upBtn.setEnabled(false); // 버튼 비활성화
		boardBtnPane.add(upBtn);

		delBtn = new RoundedButton("삭제");
		delBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		delBtn.setBounds(528, 10, 60, 25);
		delBtn.setEnabled(false); // 버튼 비활성화
		boardBtnPane.add(delBtn);

		manuBtn = new RoundedButton("다이어리 사용법");
		manuBtn.setBounds(488, 515, 100, 20);
		mainDiaryWrap.add(manuBtn);
		manuBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		manuBtn2 = new RoundedButton("사용법 끄기");
		manuBtn2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		manuBtn2.setBounds(488, 515, 100, 20);
		manuBtn2.setVisible(false);
		mainDiaryWrap.add(manuBtn2);

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

		dateSubCont = new JLabel("");
		dateSubCont.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		dateSubCont.setHorizontalAlignment(SwingConstants.CENTER);
		dateSubCont.setBorder(new LineBorder(new Color(192, 192, 192)));
		dateSubCont.setBounds(0, 0, 100, 75);
		titleSubPane.add(dateSubCont);

		titleWrite = new JTextField("제목을 입력해주세요.");
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
		txtWriteBoard.setText("내용을 입력해주세요.");
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
		happtBtn.setActionCommand("행복"); // 버튼 값을 반환
		happtBtn.setBounds(90, 3, 60, 23);
		moodBtnPane.add(happtBtn);

		smileBtn = new JRadioButton("웃김");
		smileBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		smileBtn.setBackground(Color.WHITE);
		smileBtn.setActionCommand("웃김"); // 버튼 값을 반환
		smileBtn.setBounds(154, 3, 60, 23);
		moodBtnPane.add(smileBtn);

		soBtn = new JRadioButton("보통");
		soBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		soBtn.setBackground(Color.WHITE);
		soBtn.setActionCommand("보통"); // 버튼 값을 반환
		soBtn.setBounds(218, 3, 60, 23);
		moodBtnPane.add(soBtn);
		soBtn.setSelected(true);

		sadBtn = new JRadioButton("슬픔");
		sadBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		sadBtn.setBackground(Color.WHITE);
		sadBtn.setActionCommand("슬픔"); // 버튼 값을 반환
		sadBtn.setBounds(282, 3, 60, 23);
		moodBtnPane.add(sadBtn);

		angryBtn = new JRadioButton("화남");
		angryBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		angryBtn.setBackground(Color.WHITE);
		angryBtn.setActionCommand("화남"); // 버튼 값을 반환
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
		boardBtnSubPane.setVisible(true);
		subDiaryWrap.add(boardBtnSubPane);

		entBtn = new RoundedButton("확인");
		entBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		entBtn.setBounds(528, 10, 60, 25);
		boardBtnSubPane.add(entBtn);

		updBtn = new RoundedButton("수정완료");
		updBtn.setBounds(528, 10, 60, 25);
		boardBtnSubPane.add(updBtn);
		updBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

		cnlBtn = new RoundedButton("취소");
		cnlBtn.setBounds(456, 10, 60, 25);
		boardBtnSubPane.add(cnlBtn);
		cnlBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		updBtn.setVisible(false);

		addBtn.addActionListener(this); // 새 글 추가 버튼 (글쓰기)
		entBtn.addActionListener(this); // 새 글 작성 후 완료 버튼 (확인)
		upBtn.addActionListener(this); // 글 수정 버튼 (수정)
		updBtn.addActionListener(this); // 글 수정 완료 버튼 (수정완료)
		delBtn.addActionListener(this); // 글 삭제 버튼 (삭제)
		cnlBtn.addActionListener(this); // 뒤로가기 버튼 (취소)
		manuBtn.addActionListener(this); // 다이어리 설명 (다이어리 사용법)
		manuBtn2.addActionListener(this); // 다이어리 설명  (사용법 끄기)

	/*	if (indexCont.getText()) == null) {
			upBtn.setEnabled(false); // 수정 버튼 비활성화
			delBtn.setEnabled(false);// 삭제 버튼 비활성화
		} else {
			upBtn.setEnabled(true); // 수정 버튼 활성화
			delBtn.setEnabled(true);// 삭제 버튼 활성화
		}*/

		MasterSession ms = MasterSession.getInstance();
		if (!ms.getMaster_id().equals(member.getMember_id())) {
			// 로그인한 사람의 홈페이지가 아닐 경우 코딩
			boardBtnPane.setVisible(false);
			boardBtnSubPane.setVisible(false);
		}
		try {

		} catch (Exception e) {
			System.out.println("[DiaryPane]: 작성한 다이어리 없음");
		}

	}
	// --------------------------------------------------------------subPane

	@Override
	public void actionPerformed(ActionEvent e) {
		String btName = e.getActionCommand();
		if (btName.equals("글쓰기")) {
			titleWrite.setText("제목을 입력해주세요."); // 제목 창을 초기화함
			txtWriteBoard.setText("내용을 입력해주세요."); // 글쓰기 창을 초기화함
			mainDiaryWrap.setVisible(false); // 창이 안보이게
			subDiaryWrap.setVisible(true); // 창이 보이게
			entBtn.setVisible(true); // 확인 버튼 보이게
			updBtn.setVisible(false); // 수정 확인 버튼 안보이게
		}
		if (btName.equals("확인")) {
			mainDiaryWrap.setVisible(true);// 창이 다시 보이게
			subDiaryWrap.setVisible(false); // 창이 안보이게
			diaryInsert(); // 새 글 등록
			diarySelect(); // 리스트 새로고침
		}
		if (btName.equals("수정")) {

			mainDiaryWrap.setVisible(false);
			subDiaryWrap.setVisible(true);
			updBtn.setVisible(true); // 수정 확인 버튼 보이게
			entBtn.setVisible(false); // 확인 버튼 안보이게
			DiaryDTO updto = dbc.getDiaryDTO(Integer.valueOf(indexCont.getText()));
			viewUpdateData(updto); // 수정하고자 하는 글의 정보를 불러옴

		}
		if (btName.equals("수정완료")) {
			mainDiaryWrap.setVisible(true);// 창이 다시 보이게
			subDiaryWrap.setVisible(false); // 창이 안보이게
			updBtn.setVisible(false); // 수정 확인 버튼 다시 안보이게
			entBtn.setVisible(true); // 확인 버튼 보이게
			DiaryUpdate(); // 글 수정 및 수정된 정보 띄움
			diarySelect(); // 리스트 새로고침
		}
		if (btName.equals("삭제")) {
			int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.CLOSED_OPTION) {

				JOptionPane.showMessageDialog(null, "취소를 클릭하였습니다");

			} else if (result == JOptionPane.YES_OPTION) {
				DiaryDelete(); // 글 정보 삭제 및 화면 비우기
				diarySelect(); // 리스트 새로고침
			}
		}

		if (btName.equals("취소")) {
			mainDiaryWrap.setVisible(true);// 창이 다시 보이게
			subDiaryWrap.setVisible(false); // 창이 안보이게
		}
		if (btName.equals("다이어리 사용법")) {
			manuPane.setVisible(true);
			manuBtn.setVisible(false);
			manuBtn2.setVisible(true);
		}
		if (btName.equals("사용법 끄기")) {
			manuPane.setVisible(false);
			manuBtn.setVisible(true);
			manuBtn2.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// mouseClicked 만 사용
		mainDiaryWrap.setVisible(true);// 창이 다시 보이게
		subDiaryWrap.setVisible(false); // 창이 안보이게
		upBtn.setEnabled(true); // 버튼 활성화
		delBtn.setEnabled(true); // 버튼 활성화
		int r = jTable.getSelectedRow();
		int index = (int) jTable.getValueAt(r, 0); // 테이블의 r,0 는 diary_index = 글번호
		viewData(index); // 현재 번호에 맞는 글 보여주기
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	// --------------------------------------------------------------BtnAction

	// DB에 저장된 정보를 화면에 보여주는 메서드
	private void viewData(int index) {

		DiaryDTO dto = dbc.getDiaryDTO(index);

		int diary_index = dto.getDiary_index();
		String diary_title = dto.getDiary_title();
		String diary_cont = dto.getDiary_cont();
		String diary_date = dto.getDiary_date().substring(0, 10).replace("-", ".");
		String diary_date2 = dto.getDiary_date().substring(11, 16);
		String diary_week = dto.getDiary_week();
		String diary_mood = dto.getDiary_mood();
		String diary_weather = dto.getDiary_weather();

		// 화면에 세팅
		indexCont.setText(String.valueOf(diary_index));
		titleCont.setText(diary_title);
		txtBoard.setText(diary_cont);
		boardDate.setText(diary_date);
		boardDate2.setText(diary_date2);
		boardWeek.setText(diary_week);
		moodCont.setText(diary_mood);

		// 날씨에 맞는 이미지를 찾아 띄우는 조건문, switch/case문으로 작성
		switch (diary_weather) {
		case "맑음":
			int wx = 0;
			weatherCont.setIcon(weatherIcon[wx]);
			break;
		case "흐림":
			int wx1 = 1;
			weatherCont.setIcon(weatherIcon[wx1]);
			break;
		case "강풍":
			int wx2 = 2;
			weatherCont.setIcon(weatherIcon[wx2]);
			break;
		case "비":
			int wx3 = 3;
			weatherCont.setIcon(weatherIcon[wx3]);
			break;
		case "번개":
			int wx4 = 4;
			weatherCont.setIcon(weatherIcon[wx4]);
			break;
		case "안개":
			int wx5 = 5;
			weatherCont.setIcon(weatherIcon[wx5]);
			break;
		case "눈":
			int wx6 = 6;
			weatherCont.setIcon(weatherIcon[wx6]);
			break;
		}
	}// viewData end

	// JTable의 컬럼
	public Vector<Object> getColumn() {
		Vector<Object> col = new Vector<Object>();
		col.add("글 번호");
		col.add("글 제목");

		return col;
	}// getColumn

	// Jtable 새로고침 메서드
	public void diarySelect() {
		model = new DefaultTableModel(dbc.getVectorList(member.getMember_id()), getColumn());
		jTable.setModel(model);
	}

	// 수정할 글의 정보를 화면에 보여주는 메서드
	private void viewUpdateData(DiaryDTO updto) {

		String diary_title = updto.getDiary_title();
		String diary_cont = updto.getDiary_cont();
		String diary_mood = updto.getDiary_mood();
		String diary_weather = updto.getDiary_weather();

		// 화면에 세팅
		titleWrite.setText(diary_title);
		txtWriteBoard.setText(diary_cont);
		comboBox.setSelectedItem(diary_weather);

		if (diary_mood.equals("기분")) {
			happtBtn.setSelected(true);
		} else if (diary_mood.equals("웃김")) {
			smileBtn.setSelected(true);
		} else if (diary_mood.equals("보통")) {
			soBtn.setSelected(true);
		} else if (diary_mood.equals("슬픔")) {
			sadBtn.setSelected(true);
		} else if (diary_mood.equals("화남")) {
			angryBtn.setSelected(true);
		}

	}// viewUpdateData end

	// 새 글 등록 메서드
	private void diaryInsert() {
		DiaryDTO dto = getViewData();
		int index = dbc.diaryInsert(dto);
		viewData(index);
	} // diaryInsert end

	// 입력한 정보를 얻는 메서드
	public DiaryDTO getViewData() {

		// 화면에서 사용자가 입력한 정보를 얻음
		DiaryDTO dto = new DiaryDTO();
		String diary_title = titleWrite.getText();
		String diary_cont = txtWriteBoard.getText();
		String diary_mood = groupRd.getSelection().getActionCommand();
		String diary_weather = comboBox.getSelectedItem().toString();

		// 입력한 정보를 dto에 담음
		dto.setDiary_title(diary_title);
		dto.setDiary_cont(diary_cont);
		dto.setDiary_mood(diary_mood);
		dto.setDiary_weather(diary_weather);
		dto.setMemeber_id(member.getMember_id());

		return dto;
	} // getViewData end

	// 수정할때 입력한 정보를 얻는 메서드
	public DiaryDTO getViewUpdateData() {

		// 화면에서 사용자가 입력한 정보를 얻음
		DiaryDTO dto = new DiaryDTO();
		String diary_title = titleWrite.getText();
		String diary_cont = txtWriteBoard.getText();
		String diary_mood = groupRd.getSelection().getActionCommand();
		String diary_weather = comboBox.getSelectedItem().toString();
		int diary_index = Integer.parseInt(indexCont.getText());

		// 입력한 정보를 dto에 담음
		dto.setDiary_title(diary_title);
		dto.setDiary_cont(diary_cont);
		dto.setDiary_mood(diary_mood);
		dto.setDiary_weather(diary_weather);
		dto.setDiary_index(diary_index);
		dto.setMemeber_id(member.getMember_id());

		return dto;
	} // getViewData end

	// 글 수정 메서드
	private void DiaryUpdate() {
		DiaryDTO dto = getViewUpdateData();
		int index = dbc.DiaryUpdate(dto);
		viewData(index);
	} // DiaryUpdate end

	// 글 삭제 메서드
	private void DiaryDelete() {

		int diary_index = Integer.parseInt(indexCont.getText());
		boolean ok = dbc.DiaryDelete(diary_index);

		if (ok) {

			String diary_cont = diary_index + "번 글을 삭제하였습니다 ! \n다른 글이 보고싶다면 목록에서 리스트를 선택해주세요:)";
			indexCont.setText("");
			titleCont.setText(null);
			txtBoard.setText(diary_cont);
			boardDate.setText(null);
			boardDate2.setText(null);
			boardWeek.setText(null);
			moodCont.setText(null);
			weatherCont.setIcon(new ImageIcon("data/images/null.png"));

		}

	}// DiaryDelete end
}// end
