package method;

// 메서드 호출 시 반환형

public class Ex07 {

	// 숫자가 반환되는 경우
	public static int method1() {
		
		return 155;
	}
	
	// 변수가 반환되는 경우
	public static int method2(int su1, int su2) {
		
		int sum = (su1 * 2) + (su2 * 2);
		
		return sum;
	}
	
	public static int method3(int a1, int a2) {
		
		return a1 + a2;
	}
	
	public static String method4() {
		
		return "홍길동";
	}
	
	public static String method5(String str1, String str2) {
		String result = str1 + str2;
		return result;
	}
	
	public static String method6(String s1, String s2) {

		return s1 + s2;
	}

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		//int num = method1();
		
		System.out.println("method1() 메서드 호출 후 반환된 값 : " + method1());
		
		System.out.println("method2() 메서드 호출 후 반환된 값 : " + method2(145,200));
		
		System.out.println("method3() 메서드 호출 후 반환된 값 : " + method3(132,55));
		
		System.out.println("method4() 메서드 호출 후 반환된 값 : " + method4());
		
		System.out.println("method5() 메서드 호출 후 반환된 값 : " + method5("대한","민국"));
		
		System.out.println("method6() 메서드 호출 후 반환된 값 : " + method6("유","관순"));
		
		System.out.println("프로그램 종료");

	}

}
