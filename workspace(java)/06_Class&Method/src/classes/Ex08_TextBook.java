package classes;

public class Ex08_TextBook {

	public static void main(String[] args) {
		
		// 기본 생성자로 객체 생성
		TextBook book1 = new TextBook();
		book1.title = "Java의 정석";
		book1.author = "남궁 원";
		book1.price = 30000;
		book1.getBookInfo();
		System.out.println();
		
		// 인자 생성자(인자 1개)로 객체 생성
		TextBook book2 = new TextBook("데이터베이스");
		book2.author = "김갑순";
		book2.price = 25000;
		book2.getBookInfo();
		System.out.println();
		
		// 인자 생성자(인자 2개)로 객체 생성
		TextBook book3 = new TextBook("JSP", "최범균");
		book3.price = 28000;
		book3.getBookInfo();
		System.out.println();
		
		// 인자 생성자(인자 3개)로 객체 생성
		TextBook book4 = new TextBook("Spring", "AAA", 38000);
		book4.getBookInfo();
		System.out.println();

	}

}
