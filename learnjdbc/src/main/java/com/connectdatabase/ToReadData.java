package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ToReadData {
public static void main(String[] args) {
	String url="jdbc:postgresql://localhost:5432/college";
	String un="postgres";
	String pwd="root";
	
	Scanner scan=new Scanner(System.in);
	try {
		Class.forName("org.postgresql.Driver");
		Connection connect = DriverManager.getConnection(url,un,pwd);
		String sql="insert into student values(?,?,?)";
		PreparedStatement pstm=connect.prepareStatement(sql);
		
		System.out.println("Enter id: ");
		int id=scan.nextInt();	
		pstm.setInt(1, id);
		
		System.out.println("Enter name: ");
		String name=scan.next();
		pstm.setString(2,name);
		
		//from user
		System.out.println("Enter dept: ");
		String dept=scan.next();
		pstm.setString(3,dept);
		
		pstm.execute();
		connect.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
