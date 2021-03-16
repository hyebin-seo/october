package string;

public class Ex02 {

	public static void main(String[] args) {
		
		String str1 = "abc";
		String str2 = "def";
		
		System.out.println("str1 주소 >>> " + System.identityHashCode(str1));
		System.out.println("str2 주소 >>> " + System.identityHashCode(str2));
		System.out.println();
		
		str1 += str2; // str1 = str1 + st2
		System.out.println("str1 주소 >>> " + System.identityHashCode(str1));
		// 문자열이 결합이 되면 새로운 메모리 공간을 확보한 후,
		// 그 메모리에 str1과 str2가 결합된 문자열이 들어가고 새로운 메모리 주소를 참조하게 된다.

	}

}
