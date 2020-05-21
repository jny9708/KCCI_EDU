package day4.ooad;

public class MyBean {

	private int id;
	private String deptName;
	private int locId;
	
	public String getInfo() {
		return id + " , " + deptName + " , " + locId;
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
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	
}
