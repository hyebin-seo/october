package classes;

import java.util.Scanner;

public class Ex11_Book {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 권의 책을 입력하시나요? :  ");
		
		Book[] books = new Book[sc.nextInt()];
		
		for(int i=0; i<books.length; i++) {
			System.out.println((i+1)+"번째 책 제목, 책 저자, 책 가격을 입력하세요...");
			
			books[i] = new Book(sc.nextLine(), sc.nextLine(),  sc.nextLine());
		}
		
		for(int i=0; i<books.length; i++) {
			System.out.println("<"+books[i].title
					+", "+books[i].author
					+", "+books[i].price+"원>");
		}
		
		sc.close();

	}

}
