package abstracts;

/*
 * 추상클래스(abstract class)?
 * 1. 추상 메서드를 포함하는 클래스.
 * 2. 추상 메서드는  본체(body)가 없는 메서드.
 *    예) void display(); // {} 가 없다.
 * 3. 클래스 앞에 abstract 키워드가 온다.
 * 4. 추상메서드를 재정의하지 않으면 error 발생.
 *    ==> 추상메서드 재정의 강제성.
 * 5. 추상  클래스는 객체 생성이 불가능.
 *    ==> 자식 클래스를 대상으로 객체 생성.
 * 6. 클래스는 메서드를  가진 클래스를 말함.
 * 7. 물론 일반 멤버(멤버변수, 멤버메서드)를 가질  수 있음.
 * 8. 그러나 한 개 이상의 추상메서드는 반드시 존재해야 함.
 *    형식)  [접근제한] abstract class 클래스명 { }
 * 9. 용도   : 응용프로그램에서 설계와 구현 부분을 분리해서 작업 시 사용됨.
 */

/*
 * 추상클래스에서 error 발생 ==> 해결방법 2가지
 * 1. 자식클래스에서 추상메서드를  재정의(O)
 * 2. 자식클래스에서 재정의하지 않는 경우 
 *    ==> 자식 클래스 이름 앞에 abstract 키워드를 붙여야 함.
 */

public abstract class Super { // 부모 클래스 - 추상 클래스
	
	int num1; // 인스턴스 멤버변수
	
	int calc() { // 인스턴스 멤버메서드
		int sum = num1 + 150;
		return sum;
	}
	
	abstract void output(); // 추상 메서드

}
