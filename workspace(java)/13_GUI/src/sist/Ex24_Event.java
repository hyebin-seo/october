package sist;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * Event Handler(이벤트 핸들러)?
 * - 각 컴포넌트에 대하여 특정 행위를 하였을 때 그 행위에 대한 작업을 처리할 수 있도록 하는 것
 *   사용자 또는 프로그램에 의해 발생할 수 있는 하나의 사건.
 * - 이벤트를 처리하는 자바 프로그램 코드로서 클래스를 만듦.
 *   이벤트 리스너는 인터페이스를 제공하며, 개발자는 이 인터페이스를 상속 받고
 *   추상 메서드를 구현하여 이벤트 리스너를 작성한다.
 * - 현재 발생한 이벤트에 관한 정보를 가진 객체를 의미.
 *   이벤트 리스너에게 전달 됨.
 *   ==> 예를 든다면 버튼을 눌렀다던지, 리스트 메뉴를 선택하였을 때 등등.
 * - 이벤트 발생 : ActionEvent 클래스
 * - ActionListener : ActionEvent를 감지하는 인터페이스.
 * - 이벤트 리스너는 모두가 다 인터페이스임(xxxListener).
 *   이벤트 리스너는 이벤트를 처리하는 프로그램 코드를 말함.
 *   이벤트 리스너는 컴포넌트에 연결되어 있어야 작동함.
 *   즉, 화면에 구성된 컴포넌트들은 이벤트 리스너를 하나씩 가지고 있음.
 * - 컴포넌트의 리스너를 연결시키는 메서드 : addXXXXListener() ==> XXXX는 리스너 이름
 * - 이벤트 리스너 작성 과정.
 *   1) 이벤트와 이벤트 리스너 선택 : 목적에 적합한 이벤트와 리스너 인터페이스 선택.
 *   2) 이벤트 리스너 클래스 작성 : 리스너 인터페이스를 상속받은 클래스를 작성하고 추상 메서드 모두 구현
 *   3) 이벤트 리스너 등록 : 이벤트를 받을 컴포넌트에 이벤트 리스너 등록.
 *   
 * [이벤트 동작 과정]
 * - 예를 들어 버튼을 클릭했을 떄
 *   1) 사용자가 마우스로 버튼을 클릭한다.
 *   2) 버튼 클릭은 운영체제의 마우스 드라이버를 거쳐 자바 가상기계(JVM)에 전달 된다.
 *   3) 자바가상기계는 이벤트 분해 스레드에게 마우스 클릭에 관한 정보를 전달한다.
 *   4) 이벤트 분배 스레드는 이벤트(ActionEvent) 객체를 생성함.
 *      이벤트 객체는 이벤트에 관련된 여러 정보를 담고 있는 객체.
 *      이벤트 객체 내에 저장되는 정보 중에 특별히 이벤트를 발생시킨 컴포넌트를 이벤트 소스라고 한다.
 *      이벤트 소스는 버튼에 글자가 새겨진 JButton 컴포넌트.
 *   5) 이벤트 분배 스레드는 JButton에 연결된 버튼 컴포넌트와 관련된 이벤트 리스너를 찾아서 호출
 *   6) 이벤트 분배 스레드는 다음 이벤트를 기다림.
 *   
 * [이벤트 관련 용어]
 * - 이벤트 소스 : 이벤트를 발생시킨 GUI 컴포넌트
 * - 이벤트 객체 : 발생한 이벤트에 대한 정보(이벤트 종류, 이벤트 소스, 화면 좌표, 버튼의 종류, 눌린 키 등)를
 *             담는 개체로서 이벤트에 따라 서로 다른 정보가 저장됨.
 * - 이벤트 리스너(Event Listener) : - 이벤트를 처리하는 코드로서 컴포넌트에 등록되어야 작동 가능
 *                               - 이벤트 소스와 이벤트 핸들러를 연결
 * - 이벤트 분배 스레드 : 이벤트 기반 프로그래밍의 핵심 요소로서 무한 루프를 실행하는 스레드.
 *                 자바 가상 기계로부터 이벤트 발생의 통지를 받아 이벤트 소스와 이벤트 종류를 결정하고
 *                 이에 따라 적절한 이벤트 객체를 생성하여 이벤트 리스너를 찾아 호출.
 */

/*
 * 이벤트 처리 방법 - 첫번째
 * - 이벤트와 이벤트 리스너(ActionListener)선택
 * - 이벤트 리스너(인터페이스)를 상속 받음.
 * - 이벤트에 맞게 추상메서드 재정의.
 * - 이벤트 리스너 등록 : 이벤트를 받을 컴포넌트에 이벤트 리스너 등록.
 */

public class Ex24_Event extends JFrame implements ActionListener{
	
	JLabel result;
	
	public Ex24_Event() {
		setTitle("이벤트 테스트");
		
		JPanel panel = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자.
		JButton male = new JButton("남자");
		JButton female = new JButton("여자");
		JLabel label = new JLabel("당신의 성별은 ?");
		result = new JLabel(""); // 결과가 출력될 컴포넌트
		result.setForeground(new Color(219,85,0));
		
		// 2. 컴포넌트를 컨테이너에 올려야한다.
		panel.add(male); panel.add(female);
		panel.add(label); panel.add(result);
		
		// 3. 컨테이너를 프레임에 올린다.
		add(panel);
		
		// 이벤트 리스너 등록
		male.addActionListener(this);
		female.addActionListener(this);
		
		setBounds(200,200,300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	// 이벤트가 발생했을 때 처리할 내용을 작성할 메서드.
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// getActionCommand()
		// 이벤트를 처리한 컴포넌트(버튼)의 타이틀(문자열)을 가져오는 메서드
		String str = e.getActionCommand();
		result.setText(str);
	}

	public static void main(String[] args) {
		
		new Ex24_Event();

	}

	

}
