package classes;

public class Ex06_Member {

	public static void main(String[] args) {
		
		// 기본 생성자로 객체 생성.
		Member member1 = new Member();
		member1.name = "김말똥";
		member1.age = 28;
		member1.phone = "010-1111-1234";
		member1.job = "학생";
		
		member1.getMemberInfo();
		System.out.println();
		
		Member member2 = new Member("김유신",25,"010-2222-2345","화랑도");
		member2.getMemberInfo();

	}

}
