package ita.framework.model;

import java.sql.*;

public class DBUtil {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "scott";
	private static final String password = "tiger";
	private Connection conn;
	private Statement stmt;

	/**
	 * Oracle 드라이버를 메모리로 로딩(loading)한다.
	 */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 상수 맴버에 설정된 연결문자열과 사용자 계정, 비밀번호를 사용하여 Oracle DB에 연결한다.
	 */
	public DBUtil() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 내부에서 사용된 Statement 개체와 Connection 개체를 닫는다.
	 */
	public void close() {
		try {
			if (stmt != null)
				stmt.close();
			
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			stmt = null;
			conn = null;
		}
	}

	/**
	 * 내부에 있는 Connection 개체를 사용하여 PreparedStatement 개체를 생성하여 리턴한다. 
	 * @param sql 실행할 쿼리(Query)문
	 * @return 생성된 PreparedStatement 개체
	 */
	public PreparedStatement prepareStatement(String sql) {
		try {
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return (PreparedStatement)stmt;
	}

	/**
	 * 내부에 있는 Connection 개체를 사용하여 Statement 개체를 생성하여 리턴한다.
	 * @return 생성된 Statement 개
	 */
	public Statement createStatement() {
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return stmt;
	}
}