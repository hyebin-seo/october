package inheritance;

public class Sonata extends Car{
	
	// 멤버변수
	// int cc;   // 부모 클래스의 멤버가 생략됨
	// int door; // 부모 클래스의 멤버가 생략됨
	String model; // 차량 모델명
	
	// 멤버 메서드
	void output() {
		System.out.println("모델명 : " + model);
		System.out.println("배기량 : " + cc);
		System.out.println("문짝수 : " + door);
	}

}
