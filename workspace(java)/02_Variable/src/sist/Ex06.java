package sist;


// [문제] 두 수를 서로 교환하여 보자.

public class Ex06 {

	public static void main(String[] args) {
		
		int x = 47;
		int y = 81;
		
		//int temp = 0;
		
		System.out.println("변경하기 전 >>> x: " + x + " / y: " + y);
		
		int temp = x;
		x= y;
		y = temp;
		
		System.out.println("변경 후 >>> x: " + x + " / y: " + y);

	}

}
