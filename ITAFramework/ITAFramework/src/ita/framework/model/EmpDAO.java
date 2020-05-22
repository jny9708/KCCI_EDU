package ita.framework.model;

import java.sql.*;
import java.util.*;
import ita.framework.entity.*;

public class EmpDAO {
	public EmpEntity getEmp(int empID) {
		EmpEntity emp = null;
	
		DBUtil db = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, dept_id, phone_no, email, TO_CHAR(hire_date, 'YYYY-MM-DD') AS hire_date " +
		             "FROM employee WHERE id = ?";
		
		try {
			db = new DBUtil();
			stmt = db.prepareStatement(sql);
			stmt.setInt(1, empID);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				emp = new EmpEntity();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPhoneNo(rs.getString("phone_no"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				
				DeptDAO deptDB = new DeptDAO();
				
				emp.setDept(deptDB.getDept(rs.getInt("dept_id")));
				
			}
		} catch(SQLException e) {
			System.out.println("[EmpDAO.getEmp]" + e.getMessage());
		} finally {
			if (db != null) 
				db.close();
		}
		
		return emp;
	}
	
	public ArrayList<EmpEntity> getAllEmp() {
		ArrayList<EmpEntity> list = new ArrayList<EmpEntity>();
		DBUtil db = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT e.id, name, dept_id, dept_name, phone_no, email, hire_date " +
		             "FROM employee e INNER JOIN department d ON e.dept_id = d.id " +
		             "ORDER BY e.id";
		
		try {
			db = new DBUtil();
			stmt = db.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				EmpEntity emp = new EmpEntity();
				DeptEntity dept = new DeptEntity();
				
				dept.setId(rs.getInt("dept_id"));
				dept.setDeptName(rs.getString("dept_name"));
				
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPhoneNo(rs.getString("phone_no"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setDept(dept);
				
				list.add(emp);
			}
		} catch(SQLException e) {
			System.out.println("[EmpDAO.getAllEmp]" + e.getMessage());
		} finally {
			if (db != null)
				db.close();
		}
		
		return list;
	}
	
	public int insertEmp(EmpEntity emp) {
		int affectedRow = 0;
		DBUtil db = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO employee(id, name, dept_id, phone_no, email, hire_date) " +
		             "VALUES(?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'))";
		
		try {
			db = new DBUtil();
			stmt = db.prepareStatement(sql);
			stmt.setInt(1, emp.getId());
			stmt.setString(2, emp.getName());
			stmt.setInt(3, emp.getDept().getId());
			stmt.setString(4, emp.getPhoneNo());
			stmt.setString(5, emp.getEmail());
			stmt.setString(6, emp.getHireDate());
			affectedRow = stmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("[EmpDAO.insertEmp]" + e.getMessage());
		}		
		
		return affectedRow;
	}
	
	public int updateEmp(EmpEntity emp) {
		int affectedRow = 0;
		DBUtil db = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE employee SET name=?, dept_id=?, phone_no=?, email=?, hire_date=TO_DATE(?, 'YYYY-MM-DD') " +
		             "WHERE id=?";
		
		try {
			db = new DBUtil();
			stmt = db.prepareStatement(sql);
			stmt.setString(1, emp.getName());
			stmt.setInt(2, emp.getDept().getId());
			stmt.setString(3, emp.getPhoneNo());
			stmt.setString(4, emp.getEmail());
			stmt.setString(5, emp.getHireDate());
			stmt.setInt(6, emp.getId());
			affectedRow = stmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("[EmpDAO.updateEmp]" + e.getMessage());
		} finally {
			if (db != null)
				db.close();
		}
		
		return affectedRow;
	}
	
	public int deleteEmp(int empNo) {
		int affectedRow = 0;
		DBUtil db = null;
		PreparedStatement stmt = null;
		String sql = "DELETE employee WHERE id = ?";
		
		try {
			db = new DBUtil();
			stmt = db.prepareStatement(sql);
			stmt.setInt(1, empNo);
			affectedRow = stmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("[EmpDAO.deleteEmp]" + e.getMessage());
		} finally {
			if (db != null)
				db.close();
		}
		
		return affectedRow;
	}
}
