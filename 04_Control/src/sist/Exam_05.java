package sist;

/*
 * [문제5] 1~100까지의 숫자 중 홀수는 더하고 짝수는 뺀 결과값을 출력해보자.
 */

public class Exam_05 {

	public static void main(String[] args) {
		int hap = 0;
		
		for(int i=1; i<=100; i++) {
			System.out.println("i >>> " + i);
			if(i % 2 == 1) {
				System.out.println("홀수>> "+hap+"+"+i+"="+(hap+i));
				hap += i;
			} else {
				System.out.println("짝수>> "+hap+"-"+i+"="+(hap-i));
				hap -= i;
			}
			System.out.println("-----------------");
		}
		
		System.out.println("결과 >>> " + hap);

	}

}
