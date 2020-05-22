package ita.framework.model;

import java.sql.*;
import java.util.*;
import ita.framework.entity.*;

public class DeptDAO {
	public DeptEntity getDept(int deptID) {
		DeptEntity dept = null;
		DBUtil db = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, dept_name FROM department WHERE id = ?";
		
		try {
			db = new DBUtil();
			stmt = db.prepareStatement(sql);
			stmt.setInt(1, deptID);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				dept = new DeptEntity();
				dept.setId(rs.getInt("id"));
				dept.setDeptName(rs.getString("dept_name"));
			}
		} catch(SQLException e) {
			System.out.println("[DeptDAO.getDept]" + e.getMessage());
		} finally {
			db.close();
		}
		
		return dept;
	}
	
	public ArrayList<DeptEntity> getAllDept() {
		DBUtil db = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<DeptEntity> list = new ArrayList<DeptEntity>();
		String sql = "SELECT id, dept_name FROM department ORDER BY id";
		
		try {
			db = new DBUtil();
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				DeptEntity dept = new DeptEntity();
				
				dept = new DeptEntity();
				dept.setId(rs.getInt("id"));
				dept.setDeptName(rs.getString("dept_name"));
				
				list.add(dept);
			}
		} catch(SQLException e) {
			System.out.println("[DeptDAO.getAllDep]" + e.getMessage());
		} finally {
			db.close();
		}
		
		return list;
	}
}
