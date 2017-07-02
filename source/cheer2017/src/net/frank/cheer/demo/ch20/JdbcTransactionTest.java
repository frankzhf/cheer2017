package net.frank.cheer.demo.ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTransactionTest {
	
	public static void main(String[] args){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.err.println(e.getMessage());
		}
		String jdbcUrl = "jdbc:mysql://localhost:3306/yangtes";
		String user = "frank";
		String password = "A1j86618825";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DriverManager.getConnection(
					jdbcUrl, user, password);
			conn.setAutoCommit(false);
			conn.setSavepoint();
			ps = conn.prepareStatement("update sys_account set amost=? where id = ?");
			ps.setInt(1, 50000);
			ps.setInt(2, 1);
			boolean executed = ps.execute(); // if execute success, executed is true, otherwise false
			System.out.println("execute result -> " + executed);
			ps.setInt(1, 550000);
			ps.setInt(2, 2);
			executed = ps.execute();
			conn.commit();
		}catch(SQLException e){
			try{
				conn.rollback();
			}catch(SQLException ee){
				System.err.println(ee.getMessage());
			}
			System.err.println(e.getMessage());
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException e){
					System.err.println(e.getMessage());
				
			}
		}
	}
}
