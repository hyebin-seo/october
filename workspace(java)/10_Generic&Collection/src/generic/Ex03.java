package generic;

// Object 타입을 사용하면 모든 객체를 저장할 수 있는 장점이 있지만,
// 저장할 때 타입 변환이 발생하고, 읽어 올때에도 타입 변환이 발생한다.
// 이는 프로그램 성능 저하의 원인이 된다.

class Generic<T>  { // T라는 타입명으로 Generic을 선언하겠다.
	
	T[] str;
	T var;
	
	void setStr(T[] str) {
		this.str = str;
	}
	
	void setVar(T var) {
		this.var = var;
	}
	
	void output() {
		for(T k : str) {
			System.out.println("str 배열 요소 >>> " + k);
		}
		System.out.println("var >>> " + var);
	}
}

public class Ex03 {

	public static void main(String[] args) {
		
		// String 타입의 객체 생성
		Generic<String> st = new Generic<String>();
		
		String[] str = {"홍길동", "이순신", "유관순"};
		String var = "김연아";
		
		st.setStr(str);
		st.setVar(var);
		st.output();
		
		// Integer 타입의 클래스 객체 생성
		Generic<Integer> it = new Generic<Integer>();
		Integer[] iarr = {100, 200, 300};
		Integer ivar = 500;
		
		it.setStr(iarr);
		it.setVar(ivar);
		it.output();

	}

}
