package inner;

/*
 * 중첩 클래스(inner class)
 * 1. 클래스 내부에 또 다른 클래스 선언
 *    ==> 두 클래스가 서로 긴밀한 관계로 연결되어 있는 경우 사용.
 *        두 클래스 멤버 간에 서로 쉽게 접근할 수 있다는 장점이 있음.
 * 2. 내부 클래스를 하나의 멤버로 사용할 수 있음.
 * 3. 클래스 멤버 : 멤버 변수, 멤버 메소드, 외부 클래스, 내부 클래스
 * 4. 내부 클래스 객체 생성 방법
 *    형식) 외부클래스명.내부클래스명 참조변수 = 외부클래스의 참조변수.new 내부클래스 생성자();
 *    
 * [내부 클래스의 특징]
 * - 내부 클래스는 외부 클래스의 멤버를 마치 자기 자신처럼 사용 가능함.
 *   외부 클래스 멤버의 접근 지정자가 private 접근 지정자일지라도 접근 가능.
 * - 내부 클래스의 접근은 반드시 외부 클래스를 통하여 접근해야 함.
 */

class Outer { //외부 클래스
	
	int su1 = 50;
	private int su2 = 36;
	
	class Inner { // 내부 클래스
		
		void output() {
			su1 = 178;
			System.out.println("su1 >>> " + su1);
			System.out.println("su1 >>> " + su2);
		}
	}
}

public class Ex02 {

	public static void main(String[] args) {
		
		// 중첩 클래스 객체 생성 방법
		// 1. 먼저 외부(Outer) 클래스 객체 생성
		Outer outer = new Outer();
		
		// 2. 내부(Inner) 클래스 객체 생성
		Outer.Inner inner = outer.new Inner();
		
		inner.output();
	}

}
