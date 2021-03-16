package string;

/*
 * String 클래스의 단점
 * - 빈번한 문자열 연산을 실행할 경우 메모리(heap)를 많이 차지하게 됨.
 * - 매번 연산 시마다 새로운 객체를 생성.
 *   ==> 힙(heap) 영역의 과부하가 발생할 가능성이 많음.
 * - 이러한 단점을 개선한 클래스가 등장 : StringBuffer 클래스
 */

public class Ex04 {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("java ");
		
		// 1. append() : 문자열을 추가하는 메서드.
		System.out.println("문자열 추가 후 >>> " + sb.append("program"));
		System.out.println();
		
		// 2. replace() : 문자열을 교체하는 메서드
		//    형식) replace(시작 index, 끝 index+1, 교체할 문자열)
		sb.replace(0, 4, "spring");
		System.out.println("문자열 교체 후 >>> " + sb);
		System.out.println();
		
		// 3. substring() : 문자열을 추출하는 메서드
		//    형식1) substring(시작 index, 끝 index+1)
		//    형식2) substring(시작 index) => 시작 index부터 끝까지
		StringBuffer sb1 = new StringBuffer("2021/03/16 11:09:10");
		
		System.out.println("오늘 날짜 >>> " + sb1.substring(0,10) );
		System.out.println("현재 시간 >>> " + sb1.substring(11));

	}

}
