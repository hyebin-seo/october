package interfaces;

public class Sub implements Inter {

	@Override
	public void output1() {
		System.out.println("인터페이스 output1() 메서드 재정의");
	}

	@Override
	public void output2() {
		System.out.println("인터페이스 output2() 메서드 재정의");
	}

}
