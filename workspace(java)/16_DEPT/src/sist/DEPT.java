package sist;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class DEPT extends JFrame{

	Connection con = null; //DB연동 결과를 저장하는 객체
	PreparedStatement pstmt = null; //쿼리문 전송객체
	ResultSet rs = null; //쿼리문 실행 결과를 저장하고 있는 객체
	
	DefaultTableModel model;
	JTable table;
	
	JTextField jtf1,jtf2,jtf3;
	
	public DEPT() {
		setTitle("부서 테이블");
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		
		JLabel jl1 = new JLabel("부서번호 : ");
		jtf1 = new JTextField(3);
		
		JLabel jl2 = new JLabel("부서명 : ");
		jtf2 = new JTextField(10);
		
		JLabel jl3 = new JLabel("근무지 : ");
		jtf3 = new JTextField(10);
		
		String[] header = {"부서번호","부서명","근무지"};
		
		model = new DefaultTableModel(header, 0);
		
		table = new JTable(model);
		
		JScrollPane jsp = new JScrollPane
				(table,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jb1 = new JButton("전체목록");
		JButton jb2 = new JButton("부서추가");
		JButton jb3 = new JButton("부서삭제");
		
		jp1.add(jl1); jp1.add(jtf1);
		jp1.add(jl2); jp1.add(jtf2);
		jp1.add(jl3); jp1.add(jtf3);
		
		jp2.add(jb1); jp2.add(jb2); jp2.add(jb3);
		
		add(jp1, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(jp2, BorderLayout.SOUTH);
		
		setBounds(200,200,500,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//이벤트 처리
		//전체리스트 버튼을 클릭했을 때 부서테이블의 전체 리스트가 출력됨
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 데이터베이스 연동 메서드 호출
				connect();
				select();
			}
		});
		
		//부서 추가 버튼을 눌렀을 때 각각의 텍스트 필드에 입력된 정보를 DB에 추가한 후
		//추가된 전체리스트를 JTable에 다시 보여줌.
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				insert();
				
				// 입력 텍스트 필드 영역 초기화
				jtf1.setText(""); jtf2.setText(""); jtf3.setText("");
				jtf1.requestFocus(); //커서이동
				
				model.setRowCount(0); //전체 화면 지워줌
				select();
				
			}
		});
		
		//JTable의 특정 행을 클릭한 상태로 부서 삭제 버튼을 눌렀을 때
		//클릭된 행을 DB에서 삭제시키는 이벤트.
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog
				(null, "정말로 삭제 하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
				
				if(result ==JOptionPane.CLOSED_OPTION) { //창의 X버튼
					JOptionPane.showMessageDialog(null, "취소를 클릭하였습니다.");
				} else if(result == JOptionPane.YES_OPTION) { //확인 버튼
					connect();
					delete();
				} else {
					JOptionPane.showMessageDialog(null, "취소를 클릭하였습니다.");
				}
				
			}
		});
		
	} //생성자 end
	
	//DB 연동 메서드
	private void connect() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "web";
		String password = "1234";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void select() {
		
		try {
			String sql = "select * from dept order by deptno";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				Object[] data = {deptno, dname, loc};
				
				model.addRow(data);
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 부서 추가 메서드
	private void insert() {
		try {
			String sql = "insert into dept values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(jtf1.getText()));
			pstmt.setString(2, jtf2.getText());
			pstmt.setString(3, jtf3.getText());
			
			pstmt.executeUpdate();
			
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 부서 삭제 메서드
	private void delete() {
		try {
			String sql = "delete from dept where deptno=?";
			pstmt = con.prepareStatement(sql);
			
			int row = table.getSelectedRow(); //테이블에서 선택한 Row
			
			pstmt.setInt(1, (int) model.getValueAt(row, 0)); //선택한 row의 0번째 열(부서번호)
			
			pstmt.executeUpdate();
			
			model.removeRow(row); //테이블에서도 해당 row 삭제
			
			pstmt.close(); con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		new DEPT();
	}
}
