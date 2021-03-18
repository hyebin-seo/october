package sist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 파일 복사
 * - Koala.jpg : 원본 이미지 파일
 * - Copied.jpg : 복사 이미지 파일
 * - 원본 이미지 파일은 읽어들이고, 읽어 들인 데이터를 파일로 출력
 */

public class Ex09 {

	public static void main(String[] args) {
		
		// 원본 이미지 파일
		try {
			FileInputStream fis = new FileInputStream("C:/hyebin/test/Koala.jpg");
			
			//원본 이미지 파일이 복사되어 저장될 파일
			FileOutputStream fos = new FileOutputStream("C:/hyebin/test/Copied.jpg");
		
			int readByte;
			
			while(true) {
				readByte = fis.read();
				
				if(readByte == -1) {
					break;
				}
				
				// int값이 옆으로 한byte씩 출력이 되어 파일을 완성한다.
				fos.write(readByte);
			} // while end
			
			// 입출력 객체 닫기
			fos.close();
			fis.close();
			
			System.out.println("복사 완료!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
