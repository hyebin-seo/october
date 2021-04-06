package sist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 아이디:");
		String id = sc.nextLine();
		
		System.out.print("회원 이름:");
		String name = sc.nextLine();
		
		System.out.print("회원 비밀번호:");
		String pwd = sc.nextLine();
		
//		System.out.print("회원 나이:");
//		String age = sc.nextLine();
		
		System.out.print("회원 마일리지:");
		String mileage = sc.nextLine();
		
//		System.out.print("회원 직업:");
//		String job = sc.nextLine();
//		
//		System.out.print("회원 주소:");
//		String addr = sc.nextLine();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			String sql = "insert into member10(num, memid, memname, pwd, mileage, regdate)"
					+ "values(member10_seq.nextval, ?, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.setInt(4, Integer.parseInt(mileage));
			
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				System.out.println("데이터 추가 성공!");
			} else {
				System.out.println("데이터 추가 실패!");
			}
			
			pstmt.close(); con.close(); sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
