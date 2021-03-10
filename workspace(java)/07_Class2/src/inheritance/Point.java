package inheritance;

/*
 * 1. super() 키워드
 *    - 자식클래스에서 부모클래스의 생성자를 호출하는 명령어.
 *      형식) super(인자); //인자는 생략도 가능.
 * 2. this() 키워드
 *    - 현재 클래스에서 다른 생성자를 호출하는 명령어.
 *      형식) this(인자);
 *      주의) 생성자 첫 문장에 와야한다. 그렇지 않으면 error 발생.
 */

public class Point { //부모클래스

	// 멤버변수
	int x;
	int y;
	
	public Point() {}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	} // 인자 생성자
}
