package com.connectdatabase;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class StepToConnectDatabase {
public static void main(String[] args) {
	//step1: load the driver class-thrird party inside jvm
	String url="jdbc:postgresql://localhost:5432/college";
	String un="postgres";
	String pwd="root";
	
	
	try {
		//forName method is from lang package remaining all from sql package
		Class.forName("org.postgresql.Driver"); //becomes optional 
		
		//To establish Connection
		//drivermanager class in prsnt in sql package
		
		Connection connect= DriverManager.getConnection(url,un,pwd);
		
		String sql="insert into student values(2,'Miller','CSE')";
		String sql1="update student set id=3 where id=2 ";
		String sql2="delete from student where id=3";
		String sql3="insert into student values(2,'Avi','MCA')";
		String sql4="update student set id=4 where id=2";
		//create statement
		Statement stmt=connect.createStatement();
		//statement interface take query to database
		
//		stmt.execute(sql3);
//		stmt.execute(sql4);
		
		
		String create="Create table teacher(tid integer primary key check (tid>0),tname varchar(20),tdept varchar(40))";
//		stmt.execute(create);
		String ins1="insert into teacher values(1,'Aswin','HR')";
		String ins2="insert into teacher values(2,'Priti','HR')";
		//now close the connect
		stmt.execute(ins1);
		stmt.execute(ins2);
		connect.close();
		
		System.out.println("data done");
		
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
