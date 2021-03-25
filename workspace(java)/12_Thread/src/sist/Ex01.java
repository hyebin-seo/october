package sist;

/*
 * 프로세스(process)?
 * - 현재 CPU에 의해서 처리되는 프로그램.
 * - 운영체제로부터 메모리를 할당을 받음.
 * - 자바에서는 하나의 클래스를 의미함.
 */

/*
 * - 무한반복을 가진 프로세스를 실행할 경우
 *   CPU가 해당 프로세스를 놓지 않기 때문에
 *   다음 프로세스를 실행할 수가 없게 됨.
 * - 이러한 문제점을 개성하기 위해서
 *   Thread 개념이 도입이 되었음.
 */
class Process1 {
	
	void go() {
		int i = 1;
		while(true) {
			System.out.println("i >>> " + i);
			i++;
		}
	}
}

class Process2 {
	
	void go() {
		int j = 1;
		while(true) {
			System.out.println("j >>> " + j);
			j++;
		}
	}
}

public class Ex01 {

	public static void main(String[] args) {
	
		//프로세스 객체 생성
		Process1 p1 = new Process1();
		Process2 p2 = new Process2();
		
		p1.go(); p2.go();

	}

}
