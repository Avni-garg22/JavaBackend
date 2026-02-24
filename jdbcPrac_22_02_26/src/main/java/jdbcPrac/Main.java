package jdbcPrac;
import java.sql.*;

public class Main {
public static void main(String[] args) throws Exception {
	String url="jdbc:postgresql://localhost:5432/college";
	String un="postgres";
	String pwd="root";
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection(url,un,pwd);
	Statement stmt=con.createStatement();
	String s="create table life(id int,name varchar(20))";
	stmt.execute(s);
	String s1="insert into life values(1,'Avi'),(2,'Shubhi'),(3,'Palaki')";
	stmt.execute(s1);
	stmt.close();
	con.close();
}
}
