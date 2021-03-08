package classes;

/*
 *  생성자 다중정의(Constructor Overloading)
 *  - 동일한 클래스에서 동일한 이름의 생성자를 여러 개 정의하는 문법.
 *  - 조건 : 매개변수의 자료형 또는 매개변수의 갯수가 달라야 함.
 *  
 *  생성자의 역할
 *  1. 객체를 생성하는 역할
 *  2. 멤버변수의 초기값을 할당하는 역할
 *  3. 객체를 생성하는 시점에 자동적으로 처리해야 할 내용을 설정하는 역할.
 */


public class Member {
	
	// 멤버변수
	String name; // 회원 이름
	int age; // 회원 나이
	String phone; // 회원 연락처
	String job; // 회원 직업
	
	public Member() {} // 기본 생성자
	
	public Member(String n, int a, String p, String j) {
		name = n;
		age = a;
		phone = p;
		job = j;
		
	} // 인자 생성자
	
	// 멤버메서드
	void getMemberInfo() {
		System.out.println("회원 이름 >>> " + name);
		System.out.println("회원 나이 >>> " + age);
		System.out.println("회원 연락처 >>> " + phone);
		System.out.println("회원 직업 >>> " + job);
	}
}
