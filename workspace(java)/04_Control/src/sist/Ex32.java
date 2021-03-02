package sist;

/*
 *  [문제] for문을 이용하여 1~100까지의 홀수이 합과 짝수의 합을 구해 보세요.
 */

public class Ex32 {

	public static void main(String[] args) {
		int odd = 0, even = 0; // 전역변수
		
		for(int i=0; i<=100; i++) {
			if(i%2==1) {
				odd += i;
			} else {
				even += i;
			}
		}
		
		System.out.println("1부터 100까지");
		System.out.println("홀수의 합 >>> " + odd);
		System.out.println("짝수의 합 >>> " + even);

	}

}
