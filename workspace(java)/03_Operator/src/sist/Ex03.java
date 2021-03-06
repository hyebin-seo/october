package sist;

/*
 * 3. 논리 연산자
 *    - 논리곱(&&) : 주어진 조건이 모두 참일 때 결과가 true가 됨.
 *                 그 나머지는 모두 false가 됨.
 *    - 논리합(||) : 주어진 조건 중 하나라도 참이면 결과는 true가 됨.
 *                 그 나머지는 모두 false가 됨.
 *    - 부   정(!) : true -> false가 되고 false -> true가 됨.
 *    - 논리연산자는 우선적으로 관계연산자를 실행한 후에 그 결과값을 가지고 논리연산을 수행하게 됨.
 */

public class Ex03 {

	public static void main(String[] args) {
		
		int su1 = 10, su2 = 7;
		
		// 논리곱 처리
		
		//true && true ==> true
		boolean test = (su1 >= su2) && (su2 >= 5);
		System.out.println("test >>> " + test);
		
		//true && false ==> false
		test = (su1 >= su2) && (su2 <= 5);
		System.out.println("test >>> " + test);
		
		//false && true ==> false
		test = (su1 <= su2) && (su2 >= 5);
		System.out.println("test >>> " + test);
		
		//false && false ==> false
		test = (su1 <= su2) && (su2 <= 5);
		System.out.println("test >>> " + test);
		
		// 논리합 처리
		
		//true || true ==> true
		boolean test1 = (su1 >= su2) || (su2 >= 5);
		System.out.println("test1 >>> " + test1);
				
		//true || false ==> true
		test1 = (su1 >= su2) || (su2 <= 5);
		System.out.println("test1 >>> " + test1);
				
		//false || true ==> true
		test1 = (su1 <= su2) || (su2 >= 5);
		System.out.println("test1 >>> " + test1);
				
		//false || false ==> false
		test1 = (su1 <= su2) || (su2 <= 5);
		System.out.println("test1 >>> " + test1);
		

	}

}
