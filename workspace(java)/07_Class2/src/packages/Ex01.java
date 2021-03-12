package packages;

import model.MemberDTO;

/*
 * 패키지(package)?
 * - 서로 연관성이 있는 클래스들과 인터페이스들의 묶음을 말함.
 * - 패키지는 물리적으로 폴더 개념과 유사함.
 * - 패키지는 서브패키지를 가질 수 있으며 "."으로 구분함.
 * - import 키워드 : 현재 패키지의 클래스에서 다른 패키지에 있는
 *                다른 클래스를 사용하고 싶은 경우 import를 해야한다.
 *                (단, 동일한 패키지에 있는 다른 클래스를 사용시에는 생략 가능)
 *   형식) import 패키지명.서브패키지명.클래스명;
 */

public class Ex01 {

	public static void main(String[] args) {
		
		// model 패키지에 있는 MemberDTO 클래스를 사용하고 싶은 경우
		MemberDTO dto = new MemberDTO();
		
		dto.setId("hong");
		dto.setPwd("1234");
		dto.setName("홍길동");
		dto.setAddress("서울시 마포구");
		dto.setAge(27);
		
		// 화면에 출력해보자
		System.out.println("회원 아이디 >>> " + dto.getId());
		System.out.println("회원 비밀번호 >>> " + dto.getPwd());
		System.out.println("회원 이름 >>> " + dto.getName());
		System.out.println("회원 나이 >>> " + dto.getAge());
		System.out.println("회원 주소 >>> " + dto.getAddress());

	}

}
