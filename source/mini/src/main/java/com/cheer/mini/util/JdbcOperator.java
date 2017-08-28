package com.cheer.mini.util;

import java.sql.Statement;
import java.sql.SQLException;

public interface JdbcOperator {
	public int callback(Statement stmt)throws SQLException;
}
