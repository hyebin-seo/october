package sist;

/*
 * 3. 기타(보조 제어문)
 *    - continue 명령어
 *    - 반복문에서만 사용하는 명령어
 *    - 반복문을 탈출하는 것이 아니라, 다음 증감식으로 가는 명령어.
 */

public class Ex39 {

	public static void main(String[] args) {
		
		for(int i=1; i<=10; i++) {
			
			if(i % 2 == 1) {
				continue;
			}
			System.out.println("i >>> " + i);
		}
		
		System.out.println();
		
		int sum = 0;
		for(int i=1; i<=100; i++) {
			
			if(i % 2 == 1) { // 홀수인 경우
				continue;
			}
			sum = sum + i;
		}
		
		System.out.println("sum >>> " + sum);

	}

}
