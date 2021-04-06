package sist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 회원 번호:");
		String num = sc.nextLine();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			String sql = "delete from member10 where num =?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, Integer.parseInt(num));
			
			int res = pstmt.executeUpdate();
			
			if(res > 0) {
				System.out.println("데이터 삭제 성공!");
			} else {
				System.out.println("데이터 삭제 실패!");
			}
			
			pstmt.close(); con.close(); sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
