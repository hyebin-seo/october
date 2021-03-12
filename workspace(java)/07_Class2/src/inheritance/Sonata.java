package inheritance;

public class Sonata extends Car {

	// 멤버 변수
	// int cc;           // 부모클래스의 멤버가 생략
	// int door;         // 부모클래스의 멤버가 생략
	String model;        // 차량 모델명
	
	// 멤버 메서드
	void output() {
		System.out.println("모델명 : " + model);
		System.out.println("배기량 : " + cc);
		System.out.println("문짝 수 : " + door);
	}
	
}
