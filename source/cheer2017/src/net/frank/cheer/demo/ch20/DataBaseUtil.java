package net.frank.cheer.demo.ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.util.PropertiesUtil;

public class DataBaseUtil {
	
	public static int execute(JdbcOperator jdbcOperator){
		//Properties configuration = 
		//	PropertiesUtil.getProperties("jdbc");
		try{
			//Class.forName(configuration.getProperty("jdbc.class.driver"));
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.err.println(e.getMessage());
		}
		//String jdbcUrl = configuration.getProperty("jdbc.url");
		//String user = configuration.getProperty("jdbc.user");
		//String password = configuration.getProperty("jdbc.password");
		String jdbcUrl = "jdbc:mysql://localhost:3306/yangtes";
		String user = "frank";
		String password = "j86618825A1";
		Connection conn = null;
		PreparedStatement ps = null;
		int rt = -1;
		try{
			conn = DriverManager.getConnection(
					jdbcUrl, user, password);
			conn.setAutoCommit(false);
			conn.setSavepoint();
			//TODO 
			rt = jdbcOperator.callback(conn);
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
		return rt;
	}
	
}
