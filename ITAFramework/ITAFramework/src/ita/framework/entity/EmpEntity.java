package ita.framework.entity;

public class EmpEntity {
	private int id;
	private String name;
	private DeptEntity dept;
	private String phoneNo;
	private String email;
	private String hireDate;
	
	public DeptEntity getDept() {
		return dept;
	}
	public void setDept(DeptEntity dept) {
		this.dept = dept;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phone) {
		this.phoneNo = phone;
	}
}
