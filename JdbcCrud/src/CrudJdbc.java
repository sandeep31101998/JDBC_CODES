import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class CrudJdbc {

	static public void insert() throws IOException {
		
		FileReader fr = new FileReader("E:\\jdbc\\JdbcCrud\\dbDetails.properties");
		Properties p = new Properties();
		p.load(fr);
		String url = p.getProperty("url");
		String un = p.getProperty("un");
		String pw = p.getProperty("pw");

		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println("ENTER THE EMPLOYEE EID:");
		int eid = sc.nextInt();
		System.out.println("ENTER THE EMPLOYEE NAME:");
		String ename = sc.next();
		System.out.println("ENTER THE EMPLOYEE SALARY");
		int sal = sc.nextInt();
		System.out.println("ENTER THE DATE OF JOINING (DD/MM/YYYY)");
		String date = sc.next();

		EmployeeDetails employeeDetails = new EmployeeDetails(eid, ename, sal, date);

		String qry = "insert into employeedetails.employee values(?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,un,pw);
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, employeeDetails.getEid());
			pstmt.setString(2, employeeDetails.getEname());
			pstmt.setInt(3, employeeDetails.getSal());
			pstmt.setString(4, employeeDetails.getDoj());
			pstmt.execute();
			System.err.println("EMPLOYEE DETAILS INSERTED SUCCESSFULLY");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void delete() throws IOException {
		
		FileReader fr = new FileReader("E:\\jdbc\\JdbcCrud\\dbDetails.properties");
		Properties p = new Properties();
		p.load(fr);
		String url = p.getProperty("url");
		String un = p.getProperty("un");
		String pw = p.getProperty("pw");
		
		Scanner sc = new Scanner(System.in);

		System.out.println("ENTER THE EID TO DELETE: ");
		int eid = sc.nextInt();

		EmployeeDetails employeeDetails = new EmployeeDetails();

		employeeDetails.setEid(eid);

		Connection con = null;
		PreparedStatement pstmt = null;

		String qry = "delete from employeedetails.employee where eid=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,un,pw);
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, employeeDetails.getEid());
			pstmt.executeUpdate();
			System.err.println("Employee data deleted successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void updateSal() throws IOException {
		
		FileReader fr = new FileReader("E:\\jdbc\\JdbcCrud\\dbDetails.properties");
		Properties p = new Properties();
		p.load(fr);
		String url = p.getProperty("url");
		String un = p.getProperty("un");
		String pw = p.getProperty("pw");

		Scanner sc = new Scanner(System.in);
		EmployeeDetails employeeDetails = new EmployeeDetails();
		Connection con = null;
		PreparedStatement pstmt = null;

		display();
		String qry = "update employeedetails.employee set sal=? where eid=?";

		System.out.println("ENTER THE EID TO SELECT RECORD");
		int eid = sc.nextInt();
		System.out.println("ENTER THE NEW SALARY TO UPDATE");
		int sal = sc.nextInt();
		employeeDetails.setEid(eid);
		employeeDetails.setSal(sal);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,un,pw);
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, employeeDetails.getSal());
			pstmt.setInt(2, employeeDetails.getEid());
			pstmt.executeUpdate();
			System.err.println("RECORD UPDATED SUCCESSFULLY");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static public void display() throws IOException {
		
		FileReader fr = new FileReader("E:\\jdbc\\JdbcCrud\\dbDetails.properties");
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,un,pw);
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

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		boolean b = true;

		while (b) {
			System.out.println("ENTER THE CHOICE\n1.INSERT\n2.DELETE\n3.UPDATE_SALARY\n4.DISPLAY\n5.EXIT");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				insert();
				break;
			case 2:
				delete();
				break;
			case 3:
				updateSal();
				break;
			case 4:
				display();
				break;
			case 5:
				b = false;
				break;
			default:
				System.out.println("Try again");
			}
		}

		if (b == false) {
			System.out.println("EXIT SUCCESSFUL");
		}
	}

}
