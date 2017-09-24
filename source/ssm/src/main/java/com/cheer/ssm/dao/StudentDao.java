package com.cheer.ssm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
}