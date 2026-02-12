package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindStudentData {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/college";
			String un="postgres";
			String pwd="root";
			
		try {
			Class.forName("org.postgresql.Driver");		
			Connection connect=DriverManager.getConnection(url,un,pwd);
			
			Statement stmt=connect.createStatement();
			String sql="select * from student";
			
			ResultSet res= stmt.executeQuery(sql);
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" ");
			}
			
		}catch(ClassNotFoundException e){
			
			e.printStackTrace();		
		}catch(SQLException e) {
			
			e.printStackTrace();			
		}
}
}
