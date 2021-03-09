package classes;

/*
 * 캡슐화(Encapsulation)?
 * - 객체지향 프로그램의 4대 특징 중 하나.
 * - 데이터를 감추기, 데이터를 외부에서 함부로 변경하지 못 하도록
 *   외부의 접근을 제한하는 것을 말함.
 * - 정보 은닉 : 클래스 멤버 접근 제어 기법
 *   * private : 외부에서 직접 접근  차단 
 *   * public : 모든 클래스에서 접근 가능
 * - setter() / getter() 메서드로 접근 가능.
 *   ==> setter() : 지정자 메서드
 *   ==> getter() : 획득자 메서드
 *   
 *   <getter와 setter 자동 만들기>
 *   상단 메뉴바(or 소스파일에 오른쪽 클릭)
 *   Source-Generate Getters and Setters...
 *   
 *   this : 객체(클래스) 자기 자신을 의미함.
 *   - 주로 멤버변수와 메서드 또는 생성자의 매개변수 이름이 동일할 때
 *     객체의 멤버임을 명확하게 하기 위하여 사용되는 키워드.
 *   - 매개변수(지역변수)의 이름과 멤버변수(전역변수)의 이름이 동일할 때
 *     멤버변수(전역변수) 앞에 this 라는 키워드를 붙여서 구분할 때 사용함.
 */

public class Number {
	// 멤버변수
	private int num1; 
	private int num2;
	
	/*
	 * setter() 메서드로 초기값을 설정
	 * - private 멤버 변수에 값을 지정(초기값 설정)하는 역할
	 * 형식) public void set멤버변수명(자료형 매개변수) {
	 * 				멤버변수 = 매개변수;
	 * 		}
	 * 
	 */
	
	public void setNum1(int n1) {
		num1 = n1;
	}
	
	public void setNum2(int n2) {
		num1 = n2;
	}
	
	/*
	 * getter() 메서드로 멤버변수에 할당된 값을  가져오기
	 * - private 메버변수에 할당된  값을 가져오는 역할
	 *   형식) public 반환형 get멤버변수명() {
	 *   				return 멤버변수명;
	 *   	  }
	 */
	
	public int getNum1() {
		return num1;
	}
	
	public int getNum2() {
		return num2;
	}
}
