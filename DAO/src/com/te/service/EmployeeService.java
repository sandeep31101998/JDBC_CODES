package com.te.service;

import com.te.bean.EmployeeDetails;

public interface EmployeeService {

	public EmployeeDetails getSingleRecord(int eid);
	public void getAllRecords();
	public void insertRecord(EmployeeDetails a);
}
