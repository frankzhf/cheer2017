package net.frank.cheer.demo.ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class JdbcPreparedTest {

	public static void main(String[] args) {
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
			ps = conn.prepareStatement("select * from sys_log limit ?,?");
			for(int i=1;i<7;i++){
				ps.setInt(1, (i-1)*10 +1 );
				ps.setInt(2, 10);
				System.out.println("第" +i + "页的记录");
				rs = ps.executeQuery();
				while(rs.next()){
					String id = rs.getString("id");
					String type = rs.getString("type");
					String title = rs.getString("title");
					Timestamp createDate = rs.getTimestamp("create_date");
					System.out.println(id +"\t" + type+"\t" + title + "\t" + createDate);
				}
			}
		}catch(SQLException e){
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
