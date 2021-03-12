package inheritance;

/*
 * 1. super 키워드
 *    - 부모의 멤버를 호출하는 명령어.
 *      형식) super.부모클래스멤버(멤버변수, 멤버메서드)
 * 2. this 키워드
 *    - 현재 클래스에 소속된 멤버를 호출하는 명령어.
 *    - this 키워드는 현재 객체 자기 자신을 의미함.
 *      형식) this.현재클래스멤버(멤버변수, 멤버메서드)
 */

public class Avante extends Car2 {

	// int cc;
	// int door;
	// String color = "검정색";
	String color = "흰색";
	
	// 멤버 메서드
	void output() {
		System.out.println
			("엔진 : "+cc+", 문짝 수 : "+door+", 색상 : "+color);
		System.out.println
		("엔진 : "+cc+", 문짝 수 : "+door+", 색상 : "+super.color);
		System.out.println
		("엔진 : "+cc+", 문짝 수 : "+door+", 색상 : "+this.color);
	}
}
