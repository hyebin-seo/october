package generic;

/*
 * 제너릭(generic)?
 * - 포괄적인, 퐁괄적인
 * - 특정한 클래스에 원하는 객체 타입을 지정하여 지정된 객체만 접근하게 하는 자바 문법.
 *   다양한 타입의 객체들을 다루는 메서드나 컬렉션에서 컴파일할 때 타입을 확인해 주는 기능.
 *   ==> 다루어질 객체의 타입을 미리 명시함으로써 번거로운 형변환을 줄여 준다는 장점이 있음.
 * - jdk 1.5 에서부터 추가된 기능.
 * - 클래스 내부에서 사용할 데이터를 외부에서 지정하는 방법.
 * - 데이터의 명확성과 안정성을 보장해 줌.
 *   ==> 다른 데이터 타입의 데이터가 들어올 경우 컴파일 시점에서 error 발생.
 */

class Box {
	private Object obj; //object 타입이기때문에 모든 타입의 자료가 들어올 수 있다.

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}

public class Ex02 {

	public static void main(String[] args) {
		
		Box box = new Box();
		box.setObj("제네릭"); // String 자료형
		
		
		// 형변환 반드시 필요.
		// 그러나 형변환이 자주 일어나게 되면 프로그램 성능이 저하.
		String str = (String) box.getObj();
		
		System.out.println("str >>> " + str);

	}

}
