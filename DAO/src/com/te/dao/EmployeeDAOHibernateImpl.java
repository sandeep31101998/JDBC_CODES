package com.te.dao;

import com.te.bean.EmployeeDetails;

public class EmployeeDAOHibernateImpl implements EmployeeDAO{

	@Override
	public EmployeeDetails getSingleRecord(int eid) {
		System.out.println("HIBERNATE GETTING SINGLE RECORD");
		return null;
	}

	@Override
	public void getAllRecords() {
		System.out.println("HIBERNATE GETTING ALL RECORD");
		
	}

	@Override
	public void insertRecord(EmployeeDetails a) {
		System.out.println("HIBERNATE INSERTING SINGLE RECORD");
		
	}

}
