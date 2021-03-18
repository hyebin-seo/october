package sist;

import java.io.IOException;

public class Ex03 {

	public static void main(String[] args) {
		
		System.out.println("한 줄을 입력하세요.....");

		int readByte;
		
		
		try {
			while(true) {
				readByte = System.in.read();
				if(readByte == '\n') {
					break;
				}
				
				System.out.print((char)readByte);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
