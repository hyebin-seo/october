package inheritance;

public class Ex01_Car {

	public static void main(String[] args) {
		
		// Sonata 클래스의 객체 생성
		
		/*
		 * Sonata 클래스의 객체 생성 과정
		 * Sonata 클래스의 객체 생성 시 JVM이
		 * 우선적으로 Car 부모 클래스를 객체 생성한 후에
		 * Sonata 클래스의 객체를 생성한다.
		 */
		Sonata sonata = new Sonata();
		sonata.model = "소나타";
		sonata.cc = 2000;
		sonata.door = 4;
		
		sonata.output();

	}

}
