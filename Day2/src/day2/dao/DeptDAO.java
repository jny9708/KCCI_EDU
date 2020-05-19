package day2.dao;

import java.util.ArrayList;

import day2.entity.Dept;

public class DeptDAO {
	private static ArrayList<Dept> deptList;
	static {
		deptList = new ArrayList<Dept>();
		deptList.add(new Dept(1,"총무팀"));
		deptList.add(new Dept(2,"경영팀"));
		deptList.add(new Dept(3,"생산팀"));
		deptList.add(new Dept(4,"홍보팀"));
	}
	
	public ArrayList<Dept> getAll(){
		
		return deptList;
	} 
	
	public void add(Dept dept) {
		deptList.add(dept);
	}
	
}
