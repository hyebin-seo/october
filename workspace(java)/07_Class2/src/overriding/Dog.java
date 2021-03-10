package overriding;

/*
 * 메서드 재정의(method overriding)?
 * - 부모 클래스에서 정의한 메서드를 자식클래스에서 다시 작성(재정의)하는 것을 말함
 * 
 * [메서드 재정의 특징]
 * 1. 반드시 상속관계에서만 발생함.
 *    (<-> 메서드 다중정의 - 동일한 클래스에서 발생)
 * 2. 부모 클래스의 원형 메서드를 자식 클래스에서 재정의(다시 작성).
 * 
 * [메서드 재정의 조건]
 * 1. 반드시 접근 지정자, 리턴타입(반환형), 매개변수 모두 일치해야 함.
 *    (<-> 메서드 다중정의 - 매개변수의 갯수가 다르든지, 자료형이 다르든지 해야함.)
 * 2. 접근지정자는 확장은 가능, 축소는 불가능. 
 */

public class Dog extends Animal {

	// void sound() { //부모의 원형 메서드를 자식클래스에서 재정의.
	//	System.out.println("멍멍멍");
	// }
	
	@Override // 이 표시가 있으면 오타 방지를 해준다. 부모클래스에 있는 메소드를 감지해줌.
	void sound() {
		// super.sound();
		System.out.println("멍멍멍~");
	}
	
	@Override
	void color() {
		//super.color();
		System.out.println("하얀색입니다.");
	}
}
