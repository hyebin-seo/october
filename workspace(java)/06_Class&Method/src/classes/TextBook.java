package classes;

public class TextBook {

	// 멤버변수
	String title;  // 책 제목
	String author; // 책 저자
	int price;     // 책 가격
	
	public TextBook() { } // 기본생성자
	
	public TextBook(String t) {
		title = t;
	}
	
	public TextBook(String t, String a) {
		title = t;
		author = a;
	}
	
	public TextBook(String t, String a, int p) {
		title = t;
		author = a;
		price = p;
	}
	
	void getBookInfo() {
		System.out.println("책 제목 >>> " + title);
		System.out.println("책 저자 >>> " + author);
		System.out.println("책 가격 >>> " + price);
	}
}
