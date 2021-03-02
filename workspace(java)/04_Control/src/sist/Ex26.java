package sist;

// 1~100까지의 홀수의 합과 짝수의 합을 구해 보자

public class Ex26 {

	public static void main(String[] args) {
		
		int su = 1; // 반복문에서 초기식
		
		// 홀수의 합 누적변수, 짝수의 합 누적 변수
		int odd = 0, even = 0;
		
		while(su <= 100) {
			if(su % 2 == 1) {
				odd += su;
			} else {
				even += su;
			}
			su++;
		}
		
		System.out.println("홀수의 합 >>> " + odd);
		System.out.println("짝수의 합 >>> " + even);

	}

}
