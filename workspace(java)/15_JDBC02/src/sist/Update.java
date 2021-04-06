package sist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 회원 번호:");
		String num = sc.nextLine();
		
		System.out.print("수정할 나이:");
		String age = sc.nextLine();
		
		System.out.print("수정할 마일리지:");
		String mileage = sc.nextLine();
		
		System.out.print("수정할 직업:");
		String job = sc.nextLine();
		
		System.out.print("수정할 주소:");
		String addr = sc.nextLine();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			String sql = "update member10 "
					+ "set age= ?,mileage= ?,job= ?,addr= ? where num = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(age));
			pstmt.setInt(2, Integer.parseInt(mileage));
			pstmt.setString(3, job);
			pstmt.setString(4, addr);
			pstmt.setInt(5, Integer.parseInt(num));
			
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				System.out.println("데이터 수정 성공!");
			} else {
				System.out.println("데이터 수정 실패!");
			}
			
			pstmt.close(); con.close(); sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
