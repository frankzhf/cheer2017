package com.cheer.mini.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataBaseUtil {
	
	private static transient Log log = LogFactory.getLog(DataBaseUtil.class);
	
	public static int execute(JdbcOperator jdbcOperator){
		Properties configuration = 
			PropertiesUtil.getProperties("jdbc");
		try{
			Class.forName(configuration.getProperty("jdbc.class.driver"));
		}catch(ClassNotFoundException e){
			System.err.println(e.getMessage());
		}
		String jdbcUrl = configuration.getProperty("jdbc.url");
		String user = configuration.getProperty("jdbc.user");
		String password = configuration.getProperty("jdbc.password");
		Connection conn = null;
		Statement stmt = null;
		int rt = -1;
		try{
			conn = DriverManager.getConnection(
					jdbcUrl, user, password);
			conn.setAutoCommit(false);
			conn.setSavepoint();
			stmt = conn.createStatement();
			rt = jdbcOperator.callback(stmt);
			conn.commit();
		}catch(SQLException e){
			try{
				conn.rollback();
			}catch(SQLException ee){
				log.error(ee.getMessage());
			}
			log.error(e.getMessage());
		}finally{
			try{
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException e){
				log.error(e.getMessage());
			}
		}
		return rt;
	}
		
	public static <T> List<T> query(String querySql,RowMapper<T> rowMapper){
		Properties configuration = 
				PropertiesUtil.getProperties("jdbc");
		try{
			Class.forName(configuration.getProperty("jdbc.class.driver"));
		}catch(ClassNotFoundException e){
			System.err.println(e.getMessage());
		}
		String jdbcUrl = configuration.getProperty("jdbc.url");
		String user = configuration.getProperty("jdbc.user");
		String password = configuration.getProperty("jdbc.password");
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DriverManager.getConnection(
					jdbcUrl, user, password);
			ResultSet rs = conn.createStatement().executeQuery(querySql);
			List<T> rt = new ArrayList<T>();
			while(rs.next()){
				T t = rowMapper.mapper(rs);
				rt.add(t);
			}
			return rt;
		}catch(SQLException e){
			log.error(e.getMessage());
		}finally{
			try{
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException e){
				log.error(e.getMessage());
			}
		}
		return null;
	}
}
