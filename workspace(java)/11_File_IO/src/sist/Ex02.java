package sist;

import java.io.IOException;

public class Ex02 {

	public static void main(String[] args) {
		
		System.out.println("한 줄을 입력하세요.....");
		
		int num;
		
		try {
			while((num = System.in.read()) != '\n') {
				System.out.print((char)num);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
