package com.te.dao;

public class GetDaoImpl {

	String type = "jdbc";

	public EmployeeDAO getDaoImpl() {
		if (type.equalsIgnoreCase("jdbc")) {
			return new EmployeeDAOJDBCImpl();
		} else if (type.equalsIgnoreCase("spring")) {
			return new EmployeeDAOSpringImpl();
		} else if (type.equalsIgnoreCase("hibernate")) {
			return new EmployeeDAOHibernateImpl();
		}
		return null;
	}
}
