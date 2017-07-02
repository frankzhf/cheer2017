package net.frank.cheer.demo.ch20;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcMetaTest {

	public static void main(String[] args) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.err.println(e.getMessage());
		}
		String jdbcUrl = "jdbc:mysql://localhost:3306/yangtes";
		Connection conn = null;
		DatabaseMetaData metaData = null;
		ResultSet rs = null;
		try{
			conn = DriverManager.getConnection(
				jdbcUrl, "frank", "A1j86618825");
			metaData = conn.getMetaData();
			rs = metaData.getTables(null,null, null, null);
			for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
				String columnName = rs.getMetaData().getColumnName(i);
				//String columnType = rs.getMetaData().getColumnTypeName(i);
				System.out.print(columnName+"\t");
				
			}
			System.out.println();
			List<String> tablesName = new ArrayList<String>();
			while(rs.next()){
				for(int index=1;index<rs.getMetaData().getColumnCount();index++){
					String value = (String)rs.getObject(index);
					System.out.print(value +"\t"); 
					if(index == 3){
						tablesName.add(value);
					}
				}
				System.out.println();
			}
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(metaData!=null){
					metaData = null;
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
