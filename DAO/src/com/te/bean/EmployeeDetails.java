package com.te.bean;

public class EmployeeDetails {

	private int eid;
	private String ename;
	private int sal;
	private String doj;

	public EmployeeDetails() {
		super();
	}

	public EmployeeDetails(int eid, String ename, int sal, String doj) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.doj = doj;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}
}
