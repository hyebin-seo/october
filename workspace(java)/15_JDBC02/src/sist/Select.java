package sist;

import java.sql.*;

public class Select {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			String sql = "select * from member10";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t");
				System.out.print(rs.getString("memid")+"\t");
				System.out.print(rs.getString("memname")+"\t");
				System.out.print(rs.getString("pwd")+"\t");
				System.out.print(rs.getInt("age")+"\t");
				System.out.print(rs.getInt("mileage")+"\t");
				System.out.print(rs.getString("job")+"\t");
				System.out.print(rs.getString("addr")+"\t");
				System.out.println(rs.getString("regdate").substring(0,10));
				System.out.println("-------------------------------------------------------");
				
			}
			
			rs.close(); pstmt.close(); con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
