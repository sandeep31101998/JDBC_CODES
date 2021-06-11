package com.te.service;

import com.te.bean.EmployeeDetails;

public class MainService {

	public static void main(String[] args) {
		EmployeeServiceImpl esl = new EmployeeServiceImpl();
		EmployeeDetails emp = esl.getSingleRecord(1);

		//	System.out.println(emp.getEname() + " " + emp.getSal() + " " + emp.getDoj());
		// printing in jdbc code so 
	}

}
