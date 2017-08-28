package com.cheer.mini.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
	
	
	public T mapper(ResultSet rs)throws SQLException;

}
