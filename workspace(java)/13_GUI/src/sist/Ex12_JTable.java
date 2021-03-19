package sist;

import javax.swing.*;

public class Ex12_JTable extends JFrame {

	public Ex12_JTable() {
		String[] header = {"학생이름","국어점수","영어점수","수학점수","JAVA점수"};
		
		String[][] contents = {
				{"홍길동","94","88","90","90"},
				{"이순신","90","55","77","99"},
				{"유관순","77","76","99","67"},
				{"김유신","66","98","99","98"},
				{"김연아","54","85","96","78"},
				{"강감찬","87","34","78","98"},
				{"세종대왕","100","100","100","89"},
				{"백종원","67","66","78","78"},
				{"유재석","87","87","87","89"},
				{"강호동","90","76","67","99"},
		};
		// JTable 컴포넌트는 컨테이너에 올리지 않고 바로 JFrame에 올려주면 된다.
		JTable table = new JTable(contents, header);
		
		// 1-1. 스크롤 기능을 추가해 보자.
		JScrollPane jsp = new JScrollPane
				(table,      //스크롤바가 보여질 컴포넌트 
				//수직 스크롤바 설치 여부
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,   
				//수평 스크롤바 설치 여부
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// 2. JTable은 바로 프레임에 올려주면 된다.
		// Table이 아닌 스크롤바가 포함된 Pane을 올려주어야 한다.
		add(jsp);
		setBounds(100,100,250,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Ex12_JTable();
	}

}
