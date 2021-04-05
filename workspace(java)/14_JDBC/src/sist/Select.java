package sist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web";
		String password = "1234";
		
		Connection con = null; // DB와 연결 객체
		PreparedStatement pstmt = null; // sql문을 전송하는 객체
		ResultSet rs = null; // sql 실행 결과를 가지고 있는 객체
		
		try {
			// 1. 오라클 드라이버 로딩
			// 형식) Class .forName("oracle.jdbc.driver.OracleDriver");
			// ==> 동적으로 로딩 : 프로그램 실행 시에 드라이버를 로딩한다는 뜻
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!!");
			
			// 2. 데이터 베이스와 연결
			con = DriverManager.getConnection(url, user, password);
			
			if(con != null) {
				System.out.println("데이터 베이스와 연결 성공");
			}
			
			// 3. 데이터베이스에 SQL문을 전송하기 위한 쿼리문 작성.
			String sql = "select * from memo order by bunho desc";
			
			pstmt = con.prepareStatement(sql);
			
			// 4. 데이터베이스에 SQL문을 전송
			rs = pstmt.executeQuery();
			
			// 5. 데이터를 가져와서 출력
			while(rs.next()) {
				int bunho = rs.getInt("bunho");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String regdate = rs.getString("regdate").substring(0, 10);
				
				System.out.println(bunho+"\t"+
								   title+"\t"+
								   writer+"\t"+
								   content+"\t"+
								   regdate+"\t");
				System.out.println("=========================================");
			}
			
			// 6. 연결된 객체 종료
			rs.close(); pstmt.close(); con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
