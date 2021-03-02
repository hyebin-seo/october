package sist;

/*
 * 실수형 : 소숫점이 존재함 - float < double (기본형)
 * - float : 소숫점 이하 7(6)자리까지 표현이 가능함.
 * - double : 소숫점 이하 15~16 자리까지 표현이 가능함.
 * - float 자료형의 변수에 실수 값을 저장 시에는 반드시 실수 값 뒤에 f를 붙여 주어야 함(생략하면 error).
 * - 데이터의 맨 뒤에 f를 붙이거나 데이터의 앞에 (float) 명시를 안 하면 오류가 발생하는 이유
 *   ==> 실수형의 기본자료형은 double형이기 때문임.
 * - 실수 자료형에서 명시적 형변환을 진행하게 되면 자료의 손실이 거의 발생하지 않음.
 */

public class Ex03 {

	public static void main(String[] args) {
		
		double dNum = 123.45666;
		
		System.out.println("dNum >>> " + dNum);
		
		float fNum = (float)dNum;
		
		System.out.println("fNum >>> " + fNum);
		
		float fNum1 = 120.4567f;
		
		System.out.println("fNum1 >>> " + fNum1);

	}

}
