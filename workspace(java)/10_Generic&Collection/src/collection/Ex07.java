package collection;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Queue 인터페이스(자료구조)
 * - 인터페이스이므로 자식클래스로 객체 생성하여 사용.
 * - 대표적인 자식클래스는  LinkedList임.
 * - 특징 : 선입선출(FIFO : First In First Out) 구조임.
 */

public class Ex07 {

	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		
		// 1. offer() : 큐에 저장하는 메서드.
		queue.offer("100번 손님");
		queue.offer("101번 손님");
		queue.offer("102번 손님");
		queue.offer("103번 손님");
		queue.offer("104번 손님");
		queue.offer("105번 손님");
		
		// 2. peek() : 큐에 저장된 데이터를 가져오는 메서드.(데이터 제거X)
		System.out.println("처음 호출한 번호 >>> " + queue.peek());
		System.out.println();
		
		// 3. poll() : 큐에 저장된 데이터를 가져오는 메서드.(데이터 제거O)
		while(!queue.isEmpty()) {
			System.out.println("호출한 번호 >>> " + queue.poll());
		}
		
		

	}

}
