package day2.entity;

import com.sun.org.apache.xml.internal.security.Init;

public class Dept {
	private int id;
	private String deptName;
	
	public Dept(int id, String deptName) {
		super();
		this.id = id;
		this.deptName = deptName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
