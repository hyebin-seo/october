package wrapper;

/*
 * wrapper class
 * - wrap : 감싸다, 포장하다.
 * - 기본자료형을 클래스 타입으로 포장해 놓은 클래스.
 * - 기본자료형보다 객체로 저장하기 때문에 좀 더 다양한 기능을 제공하기 위해 사용함.
 * - 기본 타입의 값을 내부에 두고 포장하기 때문에 포장(wrapper) 객체라고 함.
 * - 기본 자료형 : byte, short, long, float, double, boolean
 * - wrapper class : Byte, short, Long, Float, Double, Boolean
 *                   Character, Integer
 * 
 * - wrapper class 사용 이유
 *   1. 매개 변수로 객체가 요구할 때
 *   2. 기본형 값이 아닌 객체로 저장해야 할 때
 *   3. 객체간 비교가 필요할 때
 * 
 *   ***** wrapper class 사용하는 더 중요한 이유 : 형변환이 자유롭다는 특징이 있음.
 */

public class Ex01 {

	public static void main(String[] args) {
		
		// 기본자료형은 단순한 연산을 하기 위한 용도로 사용됨.
		int su1 = 100, su2 = 46;
		System.out.println("더하기 >>> " +(su1+su2));
		System.out.println();
		
		// 클래스 자료형
		// 박싱(boxing) : 기본자료형 -> 클래스형
		// 언박싱(unboxing) : 클래스형 -> 기본자료형
		Integer in = new Integer(su1);  // 박싱
		Integer in2 = new Integer(su2); // 박싱
		
		System.out.println(in + in2);
		System.out.println();
		
		Integer in3 = new Integer(100);
		System.out.println("in.equals(in3) >>> " + in.equals(in3));
		System.out.println();
		
		//형변환이 자유롭다.
		System.out.println("int형 >>> " + in3.intValue());
		System.out.println("float형 >>> " + in3.floatValue());
		System.out.println();
		
		// toString() : 숫자 -> 문자열
		// String.valueOf(숫자) : 숫자 -> 문자열
		System.out.println("숫자 -> 문자열 >>> " +(in3.toString()+34));
		System.out.println("숫자 -> 문자열 >>> " +(String.valueOf(in3)+34));
		
		// parseInt() : 문자열 -> 숫자
		System.out.println("문자열 -> 숫자 >>> " + (Integer.parseInt(in3.toString())+34));
	}

}
