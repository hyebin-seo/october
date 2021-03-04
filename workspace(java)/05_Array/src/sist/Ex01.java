package sist;

/*
 * 배열(Array)?
 * - 하나의 이름으로 동일한 자료형의 데이터를 여러 개
 *   연속적으로 저장할 수 있는 메모리 공간을 할당 받는 것을 말함.
 * - 변수는 하나의 값만을 저장하지만, 배열은 여러 개의 값을
 *   저장할 수 있음. - 같은 자료형의 데이터들이 순차적으로 저장됨.
 * - 배열은 선언과 동시에 저장할 수 있는 데이터 타입이 결정이 됨.
 *   만약 다른 타입의 데이터를 저장하려면 타입 불일치 컴파일 오류가 발생함.
 * - 배열의 방의 이름은 0이라는 인덱스부터 시작함.
 * - 배열의 단점 : 배열은 한 번 크기가 정해지면 크기를 늘리거나 줄일 수 없음.
 * 
 * [배열 사용하는 방법]
 * - 1단계 : 배열 선언(자료형[] 배열명, 자료형 배열명[])
 * - 2단계 : 배열 메모리 생성(메모리 할당 : 배열명 = new 자료형[배열의 크기])
 * - 3단계 : 배열 초기화(할당된 메모리 영역에 데이터를 저장)
 * - 4단계 : 배열을 이용(데이터 처리 => 연산, 출력 등)
 * 
 * [배열의 생성 방법 - 2가지]
 * 1. new 키워드를 사용하여 배열 생성.
 * 2. 배열의 초기값을 이용하여 배열 생성.
 */

public class Ex01 {

	public static void main(String[] args) {
		
		// 1단계 : 배열 선언(형식 - 자료형[] 배열명, 자료형 배열명[])
		// int[] score;
		
		// 2단계 : 배열 메모리 생성(메모리 할당 : 배열명 = new 자료형[배열의 크기])
		// score = new int[5];
		
		// 1단계 + 2단계 : 배열 선언 및 배열 메모리 생성
		int[] score = new int[5];
		
		System.out.println(score);
		
		// 3단계 : 배열 초기화(할당된 메모리 영역에 데이터를 저장)
		score[0] = 10;
		score[1] = 20;
		score[2] = 30;    // 130
 		score[3] = 40;    // 120
		score[4] = 50;
		
		// 4단계 : 배열을 이용(데이터 처리 => 연산, 출력 등)
		score[2] += 100;    // score[2] = score[2] + 100;
		score[3] *= 3;      // score[3] = score[3] * 3;
		
		// score 배열에 들어가 있는 데이터들을 출력해 보자.
		System.out.println("score[0] >>> " + score[0]);
		System.out.println("score[1] >>> " + score[1]);
		System.out.println("score[2] >>> " + score[2]);
		System.out.println("score[3] >>> " + score[3]);
		System.out.println("score[4] >>> " + score[4]);
		System.out.println();
		
		// 반복문을 이용하여 출력해 보자.
		for(int i=0; i<5; i++) {
			System.out.println("score["+i+"] >>> "+score[i]);
		}

	}

}
