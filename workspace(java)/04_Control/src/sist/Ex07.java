package sist;

public class Ex07 {

	public static void main(String[] args) {
		
		System.out.println("1. 아침에 일찍 일어납니다.");
		System.out.println("2. 세수를 합니다.");

		String breakfast = args[0];
		
		// 문자열끼리 비교할때는 equals() 메서드 사용. 같으면 참, 틀리면 거짓 반환
		if(breakfast.equals("밥")) {
			System.out.println("3. 밥을 먹습니다.");
		} else {
			System.out.println("3. 빵을 먹습니다.");
		}
		
		System.out.println("4. 국기 수업을 받으러 학원에 갑니다.");
	}

}
