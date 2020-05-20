package day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCEx1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. 오라클 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. 연결 객체 생성
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		String sql = "select * from dept";
		
		//3. 명령 객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//4. 쿼리를 전송하고 결과 집합 획득
		ResultSet rs = pstmt.executeQuery();
		
		//5. 결과 집합에 대한 탐색
		while(rs.next()) {
			System.out.println("id : " + rs.getInt(1));
			System.out.println("name : " + rs.getString(2));
			System.out.println("locid : " + rs.getInt(3));	
		}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
}
