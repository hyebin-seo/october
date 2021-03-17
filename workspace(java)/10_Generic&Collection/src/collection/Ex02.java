package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex02 {

	public static void main(String[] args) {
		
		// 다형성 : 부모의 참조변수를 이용해서 자식 객체를 생성하는 방법
		// List를 상속 받은 ArrayList
		List<String> list = new ArrayList<String>();

		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		// Iterator
		// 자바의 컬렉션 프레임워크에서 컬렉션에 저장되어 있는 
		// 요소들을 읽어오는 방법을 표준화 해놓은 객체
		
		Iterator<String> it = list.iterator();
		
		// hasNext() : 읽어올 요소가 있는 지 확인하는 메서드. - boolean형
		// 가져올 값이 있으면 true 값 반환, 없으면 false 값 반환.
		while(it.hasNext()) {
			// next() : 다음 요소를 가져오는 메서드
			System.out.println(it.next());
		}
	}

}
