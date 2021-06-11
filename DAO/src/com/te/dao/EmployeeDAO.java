package com.te.dao;

import com.te.bean.EmployeeDetails;

public interface EmployeeDAO {

	public EmployeeDetails getSingleRecord(int eid);
	public void getAllRecords();
	public void insertRecord(EmployeeDetails a);
}
