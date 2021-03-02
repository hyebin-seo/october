package sist;

/*
 * 3. 기타(보조제어문)
 *   - break 명령어
 *   - 현재의 제어문을 빠져나가는 명령어.
 *   - 보통 switch~case문과 반복문에서 사용됨.
 *   - if문 블럭을 제외한 첫번째 블럭에서 빠져나오는 명령어.
 */

public class Ex37 {

	public static void main(String[] args) {
		
		// 반복문에서 break 명령어 예제
		for(int i=1; i<=100; i++) {
			if(i > 50) { // 51이 되었을 때
				break;
			}
			System.out.println("i >>> " + i);
		}

	}

}
