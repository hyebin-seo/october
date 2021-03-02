package sist;

public class Ex02 {

	public static void main(String[] args) {
		
		//변수 선언 및 변수 초기화
		byte su1 = 127;
		
		System.out.println("su1 >>> "+ su1);
		
		//자료형의 형변환
		int num1 = su1;
		
		System.out.println("num1 >>> "+ num1);

		int num2 = 150;
		
		//자료형의 형변환(명시적 형변환)
		byte su2 = (byte)num2;
		
		// -106이 나온 이유: byte 범위(-128 ~ 127)를 초과했기  때문에 쓰레기 값이 나옴.
		System.out.println("su2 >>> "+ su2);
		
		/*
		 * 형변환(Casting - 해당 데이터 값의 자료형을 다른 타입의 자료형으로 변환하는 것을 말함
		 * - boolean형을 제외한 7개의 기본 자료형은 서로 형변환이 가능함.
		 * - 1. 묵시적 형변환
		 *      => 자료형의 크기가 작은 데이터를 큰 자료형의 데이터에 저장.
		 *         형변환 작업을 안 해 주어도 된다.
		 * - 2. 명시적 형변환
		 *      => 큰 자료형의 데이터를 작은 자료형의 데이터에 저장.
		 *         형변환 작업을 반드시 해주어야 한다.
		 *         자료의 손실이 발생할 수 있음.
		 */
		
		int num3 = 2147483647;
		
		System.out.println("num3 >>> " + num3);
		
		// 출력 양식을 지정하는 메소드 %,d => 천단위 콤마표시 해라.
		System.out.printf("num3 >>> %,d\n", num3);
		
		double avg = 91.3466666666666666;
		
		System.out.println("avg >>> " + avg);
		
		System.out.printf("avg >>> %.3f\n", avg);
		
		/*
		 * 출력 양식(printf() 메서드)
		 * - %d : 정수값 출력
		 * - %f : 실수값 출력
		 */
	}
		 

}
