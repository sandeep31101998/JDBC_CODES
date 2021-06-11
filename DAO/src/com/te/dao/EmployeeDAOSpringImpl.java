package com.te.dao;

import com.te.bean.EmployeeDetails;

public class EmployeeDAOSpringImpl implements  EmployeeDAO{

	@Override
	public EmployeeDetails getSingleRecord(int eid) {
		System.out.println("SPRING GETTING SINGLE RECORD");
		return null;
	}

	@Override
	public void getAllRecords() {
		System.out.println("SPRING GETTING ALL RECORD");
		
	}

	@Override
	public void insertRecord(EmployeeDetails a) {
		System.out.println("SPRING INSERTING SINGLE RECORD");
		
	}

}
