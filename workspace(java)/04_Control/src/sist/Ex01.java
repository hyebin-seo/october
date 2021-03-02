package sist;

/*
 * 제어문(Control)?
 * - 프로그램의 흐름을 제어하는 명령문.
 * - 원래는 main() 메서드의 시작 중괄호([{} 에서부터 끝 중괄호{})까지
 *   위에서 아래로 순차적으로 실행하는 흐름을 가지고 있음.
 * - 제어문은 이러한 흐름을 개발자가 원하는 방향으로 바꿀 수 있도록 해주는 것을 말함.
 * - 모든 제어문의 실행 결과는 boolean형(true/false)로 나옴.
 * 
 * 제어문의 종류
 * 1. 분기문(조건문)
 *    - if문, if~else문, 다중 if~else문, switch~case문
 * 2. 반복문
 *    - while문, do~while문, for문
 * 3. 기타(보조 제어문)
 *    - break, continue 명령어
 */

/*
 * if문 - 분기문(조건문)
 * - 조건을 제시하여 참이면 실행하고, 거짓이면 무시하는 문장.
 * - 조건식의 결과값은 boolean형만 올 수 있음.
 * - 실행문이 한 줄이면 { }(중괄호) 생략가능함.
 * - 실행문이 두 줄 이상이면 반드시 { }(중괄호) 안에 기재해야 함.
 * - 형식)
 *        if(조건식){
 *            조건식이 참인 경우 실행문;
 *        }
 */

public class Ex01 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		int su = 5;
		
		if(su <= 10) {
			System.out.println("조건식이 참입니다.");
		}
		
		System.out.println("프로그램 종료");

	}

}
