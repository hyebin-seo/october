package collection;

import java.util.Stack;

/*
 * Stack 클래스(자료 구조)
 * - 후입선출(LIFO : Last In First Out) 구조임.
 */

public class Ex06 {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		// 1.push() : stack에 저장시키는 메서드.
		stack.push("강감찬");
		stack.push("세종대왕");
		stack.push("김 구");
		stack.push("윤봉길");
		stack.push("광개토태왕");
		
		// 2. peek() : stack 맨위에 저장된 데이터를 가져오는 메서드.
		//             데이터를 stack에서 제거하는 것은 아님.
		System.out.println("stack peek() >>> " + stack.peek());
		System.out.println();
		
		// 3. pop() : stack 맨위에 저장된 데이터를 가져오는 메서드.
		//            데이터를 stack에서 제거함.
		
		while(!stack.isEmpty()) {
			System.out.println("이 름 >>> "+ stack.pop());
		}

		
	}

}
