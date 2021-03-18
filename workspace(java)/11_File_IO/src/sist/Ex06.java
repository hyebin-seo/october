package sist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// Ex04 예제 파일을 읽어 들여서 콘솔에 출력해 보자.

public class Ex06 {

	public static void main(String[] args) {
		
		Reader reader = null;
		
		int readByte;
		
		try {
			reader = new FileReader("C:\\hyebin\\workspace(java)\\11_File_IO\\src\\sist\\Ex04.java");
		
			while(true) {

				readByte = reader.read();
				if(readByte == -1) {
					break;
				}
				System.out.print((char)readByte);
			}
			
			reader.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
