package banking_System;

import java.sql.*;


public class Jdbc_conn {
	 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		String url="jdbc:mysql://localhost:3306/bankdb";
		String user="root";
		String password="root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("Connection created");
		//create statement
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from accounts");
		System.out.println("ID\\tNAME\\t\\tBALANCE");
		while(rs.next())
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			double balance = rs.getDouble("balance");

			System.out.println(id + "\t" + name + "\t\t" + balance);
		}
		rs.close();
		stmt.close();
		con.close();
		
		
 
	}
 
}
 