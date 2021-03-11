package abstracts;

public class Ex01_Super {

	public static void main(String[] args) {
		 
		//추상클래스이기 때문에 객체 생성이 불가능
		//Super super = new Super();

		//자식클래스로 객체 생성
		Sub sub = new Sub();
		sub.num1 = 133;
		System.out.println("calc() 메서드 호출 >>> " + sub.calc());
		
		sub.output();
	}

}
