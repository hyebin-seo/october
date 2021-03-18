package sist;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 1. FileInputStream / FileOutputStream
 *    - 1바이트 단위로 파일을 처리하는 바이트 기반 입출력 스트림
 *    - 그림(이미지), 오디오 파일 등 모든 종류의 파일 처리가 가능.
 * 2. FileReader / FileWriter
 *    - 2바이트 단위로 파일을 처리하는 문자 기반 입출력 스트림
 *    - 문자 단위로 처리를 하기 때문에 그림, 오디오 파일들은 처리가 불가능.
 */

public class Ex08 {

	public static void main(String[] args) {
		
		long start, end;
		
		// 1. 바이트 기반 스트림을 사용한 경우
		try {
			FileInputStream fis = new FileInputStream("C:/hyebin/test/Koala.jpg");
			
			start = System.currentTimeMillis();
			
			while(fis.read() != -1) { }
			
			end = System.currentTimeMillis();
			
			System.out.println("바이트 스트림을 사용한 경우 >>> "+(end-start)+"ms");
			
			fis.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 2. 보조스트림을 사용한 경우
		try {
			FileInputStream fis1 = new FileInputStream("C:/hyebin/test/Koala.jpg");
			BufferedInputStream bis = new BufferedInputStream(fis1);
			
			start = System.currentTimeMillis();
			
			while(fis1.read() != -1) { }
			
			end = System.currentTimeMillis();
			
			System.out.println("보조 스트림을 사용한 경우 >>> "+(end-start)+"ms");
			
			bis.close();
			fis1.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
