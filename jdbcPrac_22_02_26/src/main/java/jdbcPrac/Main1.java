package jdbcPrac;
import java.sql.*;

public class Main1 {
public static void main(String[] args) throws Exception {
	String url="jdbc:postgresql://localhost:5432/college";
	String un="postgres";
	String pwd="root";
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection(url,un,pwd);
	Statement stmt=con.createStatement();
	
	ResultSet rs=stmt.executeQuery("Select * from life");
//	while(rs.next()) {
//		System.out.println(rs.getInt(1)+" "+rs.getString(2));
//	}
	rs.next();
	System.out.println(rs.getInt(1));
	System.out.println(rs.getString(2));
	
	rs.next();
	System.out.println(rs.getInt(1));
	System.out.println(rs.getString(2));
	
	stmt.close();
	con.close();
	
	
}
}
