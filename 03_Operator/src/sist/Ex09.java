package sist;

public class Ex09 {

	public static void main(String[] args) {
		
		// 1. 키보드로부터 두 개의 숫자를 입력받는다.
		//    입력받은 두 수를 숫자로 변환시키자.
		int su1 = Integer.parseInt(args[0]);
		int su2 = Integer.parseInt(args[1]);
		
		// 2. 두 수를 가지고 산술연산을 진행해 보자.
		System.out.println("덧셈 >>> " + (su1 + su2));
		System.out.println("뺄셈 >>> " + (su1 - su2));
		System.out.println("곱셈 >>> " + (su1 * su2));
		System.out.println("나눗셈 >>> " + (su1 / su2));
		System.out.println("나머지 >>> " + (su1 % su2));
		

	}

}
