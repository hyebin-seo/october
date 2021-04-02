package mainUI;

import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

public class DiaryPane extends JPanel {
	private JTextField txtComm;

	public DiaryPane() {

		this.setBounds(40, 40, 910, 600);
		this.setBackground(Color.BLACK);
		setLayout(null);

		JPanel subDiaryPane = new JPanel();
		subDiaryPane.setLayout(null);
		subDiaryPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		subDiaryPane.setBackground(Color.WHITE);
		subDiaryPane.setBounds(0, 0, 260, 600);
		add(subDiaryPane);

		JPanel mainDiaryPane = new JPanel();
		mainDiaryPane.setLayout(null);
		mainDiaryPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		mainDiaryPane.setBackground(Color.WHITE);
		mainDiaryPane.setBounds(260, 0, 650, 600);
		add(mainDiaryPane);

		JPanel diaryWrap = new JPanel();
		diaryWrap.setBounds(58, 57, 485, 455);
		mainDiaryPane.add(diaryWrap);
		diaryWrap.setLayout(null);
		
		JPanel datePane = new JPanel();
		datePane.setBounds(0, 0, 485, 75);
		diaryWrap.add(datePane);
		datePane.setLayout(null);
		
		JPanel today = new JPanel();
		today.setBounds(0, 0, 100, 75);
		datePane.add(today);
		today.setLayout(null);
		
		JLabel toDate = new JLabel("04.01");
		toDate.setHorizontalAlignment(SwingConstants.CENTER);
		toDate.setBounds(12, 10, 76, 30);
		today.add(toDate);
		
		JLabel week = new JLabel("목요일");
		week.setHorizontalAlignment(SwingConstants.CENTER);
		week.setBounds(12, 45, 76, 20);
		today.add(week);
		
		JPanel calendar = new JPanel();
		calendar.setLayout(null);
		calendar.setBounds(100, 0, 385, 75);
		datePane.add(calendar);
		
//		JLabel label = new JLabel("달력 넣으려고 했는데 실패");
//		label.setBounds(125, 32, 57, 15);
//		calendar.add(label);
		
		JPanel boardPane = new JPanel();
		boardPane.setBounds(0, 101, 485, 200);
		diaryWrap.add(boardPane);
		boardPane.setLayout(null);
		
		JPanel txtDate = new JPanel(); // 글의 날짜 
		txtDate.setBounds(0, 0, 485, 30);
		boardPane.add(txtDate);
		txtDate.setLayout(null);
		
		JLabel boardDate = new JLabel("2021.04.01 목 12:12");
		boardDate.setBounds(12, 7, 120, 15);
		txtDate.add(boardDate);
		
		JLabel weather = new JLabel("맑음");
		weather.setBounds(125, 7, 50, 15);
		txtDate.add(weather);
		
		JLabel mood = new JLabel("행복");
		mood.setBounds(434, 7, 39, 15);
		txtDate.add(mood);
		
		JPanel boardBtn = new JPanel();
		boardBtn.setBounds(0, 160, 485, 40);
		boardPane.add(boardBtn);
		boardBtn.setLayout(null);
		
		JButton delBtn = new JButton("삭제");
		delBtn.setBounds(413, 7, 60, 25);
		boardBtn.add(delBtn);
		
		JButton reBtn = new JButton("수정");
		reBtn.setBounds(341, 7, 60, 25);
		boardBtn.add(reBtn);
		
		JTextArea txtBoard = new JTextArea();
		txtBoard.setText("글이 없습니다.");
		txtBoard.setLineWrap(true);
		txtBoard.setEnabled(false);
		txtBoard.setEditable(false);
		txtBoard.setBounds(10, 30, 463, 130);
		boardPane.add(txtBoard);
		
		JPanel schedulePane = new JPanel();
		schedulePane.setBounds(0, 74, 485, 28);
		diaryWrap.add(schedulePane);
		schedulePane.setLayout(null);
		
		JLabel txtSh = new JLabel("일정/기념일을 나타내는 칸");
		txtSh.setBounds(52, 6, 400, 15);
		txtSh.setHorizontalAlignment(JLabel.LEFT);
		schedulePane.add(txtSh);
		
		//Font font = new Font("맑은고딕",Font.BOLD,13);
		JLabel shTitle = new JLabel("일정");
		shTitle.setBounds(12, 6, 30, 15);
		schedulePane.add(shTitle);
		
		JPanel commentPane = new JPanel();
		commentPane.setBounds(0, 301, 485, 154);
		diaryWrap.add(commentPane);
		commentPane.setLayout(null);
		
		txtComm = new JTextField();
		txtComm.setBounds(72, 45, 330, 25);
		commentPane.add(txtComm);
		txtComm.setColumns(10);
		
		JButton txtCommEnt = new JButton("수정");
		txtCommEnt.setBounds(413, 44, 60, 25);
		commentPane.add(txtCommEnt);
		
		JLabel commName = new JLabel("쌍쌍용");
		// commName.setHorizontalAlignment(JLabel.RIGHT);
		commName.setBounds(22, 51, 50, 15);
		commentPane.add(commName);

		// JTextArea textBoard = new JTextArea(); // 글의 내용을 작성하는곳 
		// textBoard.setBounds(0, 29, 485, 130);
		// boardPane.add(textBoard);
		

	}
}
