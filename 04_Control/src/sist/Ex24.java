package sist;

public class Ex24 {

	public static void main(String[] args) {
		
		// while 반복문을 이용하여 1 ~ 10까지의 합을 구해 보자.
		int su = 1;  // 반복문에서 초기식
		int sum = 0; // 합을 저장하는 변수
		
		while(su <= 100) { // 반복문에서 조건식
			sum += su;
			su++; // 반복문에서 증감식
		}
		
		System.out.println("sum >>> " + sum);

	}

}
