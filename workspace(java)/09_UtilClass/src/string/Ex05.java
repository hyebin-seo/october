package string;

import java.util.StringTokenizer;

/*
 * StringTokenizer 클래스
 * - 특수 문자를 기준문자(delimiter)로 문자열을 잘라 주는 클래스(파싱).
 * - 기준문자로 분리된 문자열을 토큰(token)이라고 함.
 * - 웹에서 전화번호를 하이픈(-) 기준으로 앞자리, 중간자리, 뒷자리 형식으로 구분해서 번호 추출할 때 사용함.
 *   (주민번호, 핸드폰 번호 등등)
 */

public class Ex05 {

	public static void main(String[] args) {
		
		String str = "id=hong&pwd=1234&age=27";
		StringTokenizer st = new StringTokenizer(str, "&");
		
		//int count = st.countTokens(); // 토큰으로 구분된 문자열의 갯수
		
		System.out.println("토큰 수 >>> " + st.countTokens());

		// hasMoreTokens() : 반환할 다음 토큰이 있는지 확인. 있으면 true 반환, 없으면 false 반환
		while(st.hasMoreTokens()) { 
			System.out.println(st.nextToken());
		}
	}

}
