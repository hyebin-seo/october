package interfaces;

interface Inter1 {
	
	void aa();
	
}

interface Inter2 {
	
	void bb();
}

// 인터페이스들끼리 상속을 받을 때는 extends 키워드를 사용함.
// 일반 클래스에서 상속은 단일 상속만 가능함.
// 인터페이스에서는 다중 상속이 가능함.
interface Inter3 extends Inter1, Inter2 {
	
	void cc();
	
}

class Total implements Inter3 {

	@Override
	public void aa() {
		System.out.println("aa() 메서드 재정의");
	}

	@Override
	public void bb() {
		System.out.println("bb() 메서드 재정의");
	}

	@Override
	public void cc() {
		System.out.println("cc() 메서드 재정의");
	}
	
}

public class Ex03_Main {

	public static void main(String[] args) {
		
		Total total = new Total();
		
		total.aa(); total.bb(); total.cc();

	}

}
