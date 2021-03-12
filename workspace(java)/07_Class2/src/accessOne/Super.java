package accessOne;

/*
 * 접근지정자(접근제어자)권한
 * - 접근지정자는 클래스, 멤버변수, 멤버메서드 앞에 사용됨.
 * - 외부로부터 접근을 제어한다는 의미를 가지고 있음.
 * - 접근 지정자가 사용될 수 있는 곳 : 클래스, 멤버변수, 멤버메서드, 생성자
 * - 이들 접근지정자 중 protected, private 접근지정자는 클래스 앞에 사용을 못함.
 *   단, Inner Class 앞에는 사용 가능.
 * 
 * 1. private : - 동일한 클래스에서만 사용이 가능.
 *              - 외부에서 인스턴스 변수를 바로 접근이 가능하게 제어를 하면 잘못된 데이터를 저장할 수 있는 문제 발생.
 *              - 따라서 직접 접근을 못하게 제어하고 메서드(setter() / getter())를 사용하여 접근.
 * 2. default : - 동일한 패키지에서만 접근이 가능. 생략 가능.
 *              - 같은 클래스의 멤버, 같은 패키지 안의 다른 클래스의 멤버까지만 접근이 가능.
 *              - 다른 패키지의 상속 관계에 있는 클래스라도 접근 불가.
 * 3. protected : - 같은 클래스의 멤버, 같은 패키지 안의 다른 클래스의 멤버, 다른 패키지의 상속 관계에 있는 멤버까지 접근 가능.
 * 4. public : - 모든 클래스에서 접근이 가능함.
 *             - 같은 클래스의 멤버, 같은 패키지 안의 다른 클래스의 멤버, 
 *               다른 패키지의 상속 관계에 있는 멤버, 다른 패키지의 클래스의 멤버까지 접근 가능.
 *               
 * - 접근 범위(scope) : public > protected > default > private
 */
public class Super {
	
	// 멤버변수
	private int num1 = 10;   // 접근지정자 : private
	int num2 = 20;           // 접근지정자 : default
	protected int num3 = 30; // 접근지정자 : protected
	public int num4 = 40;    // 접근지정자 : public

}
