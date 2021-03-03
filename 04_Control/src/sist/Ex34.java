package sist;

/*
 * 다중 for문
 * - 반복문 안에 또다른 반복문을 포함하는 문장.
 * - 반복문이 중첩되어 사용되는 경우.
 * - 외부 반복문과 내부 반복문 간의 변수 값 변화에 유의해야 함.
 *   형식) for(초기식1;조건식1;증감식1) {
 *             반복실행문1;
 *             for(초기식2; 조건식2;증감식2;) {
 *                  반복실행문2;
 *             }
 *        }
 */

public class Ex34 {

	public static void main(String[] args) {
		
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=3; j++) {
				System.out.println("("+i+", "+j+")");
			}
			System.out.println("======================");
		}

	}

}
