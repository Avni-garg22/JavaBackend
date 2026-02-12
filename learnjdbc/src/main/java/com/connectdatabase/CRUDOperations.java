package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDOperations {
	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/college";
		String un="postgres";
		String pwd="root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect= DriverManager.getConnection(url,un,pwd);
			Statement stmt=connect.createStatement();
			stmt.execute(updateTable());
			stmt.execute(deleteRow());
			stmt.execute(insertData());
			System.out.println("done successfully");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
public static String updateTable() {
	String sql="update teacher set tid=101 where tname='Aswin'";
	return sql;
	
}
public static String deleteRow() {
	String sql="delete from teacher where tname='Aswin'";
	return sql;
	
}
public static String insertData() {
	String sql="insert into teacher values(102,'gugus','Management')";
	return sql;
	
}
}
