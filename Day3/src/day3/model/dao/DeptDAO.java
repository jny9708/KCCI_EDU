package day3.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import day3.model.entity.Dept;

public class DeptDAO {
	
	private static DeptDAO dao;
	// 싱글톤 패턴
	public static DeptDAO getInstance() {
		if(dao == null) {
			dao = new DeptDAO();		
		}
		return dao;
	}
	
	// 이렇게하면 new를 사용할 수 없다고 한다
	private DeptDAO() {
		
	}

	public Dept getDept(int id) {
		Dept dept = new Dept();
		String sql = "select * from dept where id = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DBUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				dept = new Dept();
				dept.setId(rs.getInt("id"));
				dept.setDeptName(rs.getString("dept_name"));
				dept.setLocId(rs.getInt("loc_id"));
			}
		
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}
	
	public ArrayList<Dept> getAll(){
		ArrayList<Dept> deptList = new ArrayList<>();
		String sql = "select * from dept";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn = DBUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Dept dept = new Dept();
				dept.setId(rs.getInt("id"));
				dept.setDeptName(rs.getString("dept_name"));
				int locId = rs.getInt("loc_id");
				dept.setLocId(rs.wasNull() ? null : locId);
				deptList.add(dept);
			}
		
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return deptList;
	}
	
	public void Add(Dept dept) {
		String sql = "insert into dept values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getId());
			pstmt.setString(2, dept.getDeptName());
			pstmt.setInt(3, dept.getLocId());
			pstmt.executeUpdate();

			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Update(Dept dept) {
		String sql = "update dept set dept_name = ?, loc_id = ? where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDeptName());
			pstmt.setInt(2, dept.getLocId());
			pstmt.setInt(3, dept.getId());
			pstmt.executeUpdate();

			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Delete(int id) {
		String sql = "delete from dept where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBUtill.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
