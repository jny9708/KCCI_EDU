package day3.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import day3.model.entity.Dept;
import day3.model.entity.Emp;

public class EmpDAO {

	private static EmpDAO dao;
	// 싱글톤 패턴
	public static EmpDAO getInstance() {
		if(dao == null) {
			dao = new EmpDAO();		
		}
		return dao;
	}
	
	// 이렇게하면 new를 사용할 수 없다고 한다
	private EmpDAO() {
		
	}
	
	public Emp getEmp(int empNo) {
		Emp emp = new Emp();
		String sql = "select * from emp where emp_no = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DBUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setName(rs.getString("name"));
				emp.setHire(rs.getDate("hire"));
				emp.setTitle(rs.getString("title"));
				int salary = rs.getInt("salary");
				emp.setSalary(rs.wasNull() ? null : salary);
				int bonus = rs.getInt("bonus");
				emp.setBonus(rs.wasNull() ? null : bonus);
				int mgr = rs.getInt("mgr");
				emp.setMgr(rs.wasNull() ? null : mgr);
				int deptId = rs.getInt("dept_id");
				emp.setDeptId(rs.wasNull() ? null : deptId);
				
			}
		
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	
}
