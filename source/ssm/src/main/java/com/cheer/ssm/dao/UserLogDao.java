package com.cheer.ssm.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.cheer.ssm.domain.UserLog;



public class UserLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(final UserLog userLog){
		jdbcTemplate.execute("insert into tbl_user_log(user_id,ip,last_login)values(?,?,?)",
				new PreparedStatementCallback<Void>(){

			@Override
			public Void doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setLong(1, userLog.getUserId());
				ps.setString(2, userLog.getIp());
				ps.setTimestamp(3, new Timestamp(userLog.getLastLogin().getTime()));
				ps.execute();
				return null;
			}
			
		});
	}
	
}
