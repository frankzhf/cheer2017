package com.cheer.mini;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cheer.mini.util.DataBaseUtil;
import com.cheer.mini.util.JdbcOperator;
import com.cheer.mini.util.RowMapper;

public class TestJdbcutil {
	private static transient Log log = LogFactory.getLog(TestJdbcutil.class);
	
	public static void main(String[] args) {
		
		int count = DataBaseUtil.getCount("select * from sys_student");
		log.info("Varible[count] -> " + count);
		
		List<Student> rt = DataBaseUtil.pageQuery("select * from sys_student" ,1,3, new RowMapper<Student>(){
			@Override
			public Student mapper(ResultSet rs) throws SQLException{
				Student student = new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setHeigth(rs.getInt(4));
				student.setWeight(rs.getInt(5));
				return student;
			}
		});
		log.info("Varible [rt] -> " + rt);
		
		rt = DataBaseUtil.pageQuery("select * from sys_student" ,2,3, new RowMapper<Student>(){
			@Override
			public Student mapper(ResultSet rs) throws SQLException{
				Student student = new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setHeigth(rs.getInt(4));
				student.setWeight(rs.getInt(5));
				return student;
			}
		});
		log.info("Varible [rt] -> " + rt);
		
		
		/***
		DataBaseUtil.execute(new JdbcOperator() {
			@Override
			public int callback(Statement stmt) throws SQLException {
				String executeSql = "delete from sys_area";
				stmt.execute(executeSql);
				return 0;
			}
		});
	
		
		List<Student> rt = DataBaseUtil.query("select * from sys_student", new RowMapper<Student>(){
			@Override
			public Student mapper(ResultSet rs) throws SQLException{
				Student student = new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setHeigth(rs.getInt(4));
				student.setWeight(rs.getInt(5));
				return student;
			}
		});
		log.info("Varible [rt] -> " + rt);
			
		
		List<Area> rt0 = DataBaseUtil.query("select name,full_name from sys_area", new RowMapper<Area>(){

			@Override
			public Area mapper(ResultSet rs) throws SQLException {
				Area item = new Area();
				item.setAreaName(rs.getString(1));
				item.setAreaFullName(rs.getString(2));
				return item;
			}
			
		});
		log.info("Varible [rt0] -> " + rt0);
		**/
	}

}

class Area{
	private String areaName;
	private String areaFullName;
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaFullName() {
		return areaFullName;
	}
	public void setAreaFullName(String areaFullName) {
		this.areaFullName = areaFullName;
	}
	@Override
	public String toString() {
		return "Area [areaName=" + areaName + ", areaFullName=" + areaFullName + "]";
	}
	
}
