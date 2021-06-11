package com.te.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.te.bean.EmployeeDetails;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {

	@Override
	public EmployeeDetails getSingleRecord(int eid) {
		EmployeeDetails employeeDetails = new EmployeeDetails();
		System.out.println("JDBC reteriving all record");
		FileReader fr;
		try {
			fr = new FileReader("E:\\jdbc\\JdbcCrud\\dbDetails.properties");

			Properties p = new Properties();
			p.load(fr);
			String url = p.getProperty("url");
			String un = p.getProperty("un");
			String pw = p.getProperty("pw");

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			String qry = "select * from employeedetails.employee where eid="+eid+";";

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, un, pw);
			pstmt = con.prepareStatement(qry);
			rs = pstmt.executeQuery();
			System.err.println("DATA FETCHED");
			System.out.println("EID\t" + "ENAME\t" + "SALARY\t" + "DATE_OF_JOIN\t");
			while (rs.next()) {
				employeeDetails.setEid(rs.getInt("eid"));
				employeeDetails.setEname(rs.getString("ename"));
				employeeDetails.setSal(rs.getInt("sal"));
				employeeDetails.setDoj(rs.getString("doj"));

				System.out.println(employeeDetails.getEid() + "\t" + employeeDetails.getEname() + "\t"
						+ employeeDetails.getSal() + "\t" + employeeDetails.getDoj());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeDetails;
	}

	@Override
	public void getAllRecords() {
		System.out.println("JDBC reteriving all record");
		FileReader fr;
		try {
			fr = new FileReader("E:\\jdbc\\JdbcCrud\\dbDetails.properties");

			Properties p = new Properties();
			p.load(fr);
			String url = p.getProperty("url");
			String un = p.getProperty("un");
			String pw = p.getProperty("pw");

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			EmployeeDetails employeeDetails = new EmployeeDetails();
			String qry = "select * from employeedetails.employee";

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, un, pw);
			pstmt = con.prepareStatement(qry);
			rs = pstmt.executeQuery();
			System.err.println("DATA FETCHED");
			System.out.println("EID\t" + "ENAME\t" + "SALARY\t" + "DATE_OF_JOIN\t");
			while (rs.next()) {
				employeeDetails.setEid(rs.getInt("eid"));
				employeeDetails.setEname(rs.getString("ename"));
				employeeDetails.setSal(rs.getInt("sal"));
				employeeDetails.setDoj(rs.getString("doj"));

				System.out.println(employeeDetails.getEid() + "\t" + employeeDetails.getEname() + "\t"
						+ employeeDetails.getSal() + "\t" + employeeDetails.getDoj());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertRecord(EmployeeDetails a) {
		System.out.println("JDBC INSERT RECORD");

	}

}
