package com.te.service;

import com.te.bean.EmployeeDetails;
import com.te.dao.EmployeeDAO;
import com.te.dao.GetDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{

	GetDaoImpl daoImpl = new GetDaoImpl();
	EmployeeDAO dao = daoImpl.getDaoImpl();
	
	EmployeeDetails emp = new EmployeeDetails();
	
	@Override
	public EmployeeDetails getSingleRecord(int eid) {
		System.out.println("SERVICE GETTING SINGLE RECORD");
		//validation
		return dao.getSingleRecord(eid);
	}

	@Override
	public void getAllRecords() {
//		System.out.println("SERVICE GETTING ALL RECORD");
		//dao.getAllRecords();
		
		
	}

	@Override
	public void insertRecord(EmployeeDetails a) {
		System.out.println("SERVICE INSERTING SINGLE RECORD");
		
	}

}
