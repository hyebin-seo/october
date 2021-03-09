package classes;

public class Book {
	//멤버변수
	String title;  //책 제목
	String author; //책 저자
	String price;  //책 가격
	
	public Book() {	} //기본 생성자
	public Book(String t, String a, String p) {	
		title = t;
		author = a;
		price = p;
	}
	
}
