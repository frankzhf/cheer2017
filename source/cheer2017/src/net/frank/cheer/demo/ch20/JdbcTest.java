package net.frank.cheer.demo.ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class JdbcTest {
	public static void main(String[] args)throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		//Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/yangtes";
		//String jdbcUrl = "jjdbc:oracle:thin:@192.168.48.149:1521:IPEUAT";
		Connection connection = DriverManager.getConnection(
				jdbcUrl, "frank", "A1j86618825");
		System.out.println(connection.getClass());
		Statement stmt = connection.createStatement();
		System.out.println(stmt.getClass());
		ResultSet rs = stmt.executeQuery("select * from sys_log");
		System.out.println(rs.getClass());
		while(rs.next()){
			String id = rs.getString("id");
			//String id = rs.getString(1);
			String type = rs.getString("type");
			String title = rs.getString("title");
			Timestamp createDate = rs.getTimestamp("create_date");
			System.out.println(id + "\t" + type +"\t" + title +"\t" + createDate);
		}
		
		rs.close();
		stmt.close();
		connection.close();
	}
}
