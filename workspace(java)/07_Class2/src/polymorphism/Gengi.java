package polymorphism;

public class Gengi implements OverWatch {

	@Override
	public void name() {
		System.out.println("이 름 : 겐지");

	}

	@Override
	public void leftClick() {
		System.out.println("왼쪽 버튼 : 표창던지기");

	}

	@Override
	public void rightClick() {
		System.out.println("오른쪽 버튼 : 표창 3개 던지기");

	}

	@Override
	public void shiftButton() {
		System.out.println("Shift 버튼 : 돌진");

	}

	@Override
	public void eButton() {
		System.out.println("e 버튼 : 칼로 막기");

	}

	@Override
	public void qButton() {
		System.out.println("q 버튼 : 칼로 썰기(죽이기)");

	}

}
