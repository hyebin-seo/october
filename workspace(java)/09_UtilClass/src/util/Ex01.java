package util;

import java.util.Random;

/*
 * Util 패키지의 주요 클래스
 * 1. Random 클래스
 *    - 임의의 난수를 발생시키는 클래스.
 * 2. Math 클래스
 *    - 수학과 관련된 메서드를 제공해 주는 클래스.
 *    - 유일하게 java.lang 패키지에 있는 클래스임.
 * 3. Calendar 클래스
 *    - 날짜 / 시간 관련 정보를 제공해 주는 클래스.
 * 4. Arrays 클래스
 *    - 배열 객체를 처리해 주는 클래스.
 */

/*
 * 1. Random 클래스
 *    - 지정된 범위 내에서 임의의 난수를 발생시키는 클래스.
 *    - 활용 분야 : 게임, 확률 등에서 사용.
 *    - 형식) nextInt(가장 큰 수) + 시작 수
 */

public class Ex01 {

	public static void main(String[] args) {
		
		// 로또 번호를 만들어 보자.
		Random random = new Random();
		
		int num = 0;
		
		// 중복이 발생되는 코드
		for(int i=1; i<7; i++) {
			num = random.nextInt(45) + 1;
			System.out.print(num + "\t");
		}
		
		System.out.println();
		System.out.println();
		
		// 중복이 발생되지 않게 로또 만들자.
		int[] lotto = new int[6];  // 로또 배열
		
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = random.nextInt(45) + 1;
			
			if(i > 0) {
				for(int j=0; j<i; j++) {
					if(lotto[i] == lotto[j]) {  // 중복인 경우
						lotto[i] = random.nextInt(45) + 1;
						j = -1;
					}
				}
			}  // if문 end
			
			System.out.print(lotto[i] + "\t");
			
		}
		
		System.out.println();
		

	}

}
