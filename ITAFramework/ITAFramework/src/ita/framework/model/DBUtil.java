package ita.framework.model;

import java.sql.*;

public class DBUtil {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "scott";
	private static final String password = "tiger";
	private Connection conn;
	private Statement stmt;

	/**
	 * Oracle ����̹��� �޸𸮷� �ε�(loading)�Ѵ�.
	 */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * ��� �ɹ��� ������ ���Ṯ�ڿ��� ����� ����, ��й�ȣ�� ����Ͽ� Oracle DB�� �����Ѵ�.
	 */
	public DBUtil() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * ���ο��� ���� Statement ��ü�� Connection ��ü�� �ݴ´�.
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
	 * ���ο� �ִ� Connection ��ü�� ����Ͽ� PreparedStatement ��ü�� �����Ͽ� �����Ѵ�. 
	 * @param sql ������ ����(Query)��
	 * @return ������ PreparedStatement ��ü
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
	 * ���ο� �ִ� Connection ��ü�� ����Ͽ� Statement ��ü�� �����Ͽ� �����Ѵ�.
	 * @return ������ Statement ��
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