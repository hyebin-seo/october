package polymorphism;

/*
 * instanceof 연산자
 * - 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보는 연산자.
 * - 연산결과로  boolean 값(true / false)를 반환.
 *   예) 참조변수 instanceof 클래스명(타입)
 *      if(a instanceof Car) : 참조변수 a의 타입이 Car 클래스 타입인지 체크함.
 *      ==> true이면 Car 인스턴스 타입이고  false이면 Car 인스턴스 타입이 아니다.
 */

public class Ex04_Game2 {

	public static void main(String[] args) {
		
		Gengi gengi = new Gengi();
		
		if(gengi instanceof Gengi) {
			System.out.println("Gengi 클래스 타입입니다.");
		}
		
		if(gengi instanceof OverWatch) {
			// 상속받았기 때문에 같은 타입 취급한다.
			System.out.println("조상 클래스 타입입니다.");
		}

	}

}
