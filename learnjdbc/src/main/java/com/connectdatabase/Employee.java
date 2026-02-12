package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Employee {
	static String url="jdbc:postgresql://localhost:5432/college";
	static String un="postgres";
	static String pwd="root";
	static Scanner sc=new Scanner(System.in);
public static void main(String[] args) {

	addEmployee();
	deleteById();
}

public static void addEmployee() {
	try {
	String sql="insert into Employee values(?,?,?,?)";
	Connection connect=DriverManager.getConnection(url,un,pwd);
	PreparedStatement pstm=connect.prepareStatement(sql);
	System.out.println("enter id");
	int id=sc.nextInt();
	pstm.setInt(1, id);
	
	System.out.println("enter name");
	String name=sc.next();
	pstm.setString(2, name);
	
	System.out.println("enter branch");
	String b=sc.next();
	pstm.setString(3, b);
	
	System.out.println("enter salary");
	int sal=sc.nextInt();
	pstm.setInt(4, sal);
	pstm.execute();
	connect.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public static void deleteById() {
	try {
		System.out.println("Enter id: ");
	
	Connection connect=DriverManager.getConnection(url,un,pwd);
	
	String sql="delete from Employee where id=?";
	PreparedStatement pstm=connect.prepareStatement(sql);
	int i=sc.nextInt();
	pstm.setInt(1, i);
	pstm.execute();
	connect.close();
	
	}catch(Exception e) {
		e.printStackTrace();
	}
}


}
