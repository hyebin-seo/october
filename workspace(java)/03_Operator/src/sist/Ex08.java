package sist;

public class Ex08 {

	public static void main(String[] args) {
		
		// 키보드로 두 개의 숫자를 입력을 받아 보자.
		String su1 = args[0];
		String su2 = args[1];
		
		System.out.println("su1 + su2 >>> " + (su1 + su2));
		System.out.println();
		
		int num1 = Integer.parseInt(su1);
		int num2 = Integer.parseInt(su2);
		
		System.out.println("num1 + num2 >>> " + (num1 + num2));
		System.out.println();

	}

}
