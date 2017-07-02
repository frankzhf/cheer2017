package net.frank.cheer.demo.ch20;

import java.sql.Connection;
import java.sql.SQLException;

public interface JdbcOperator {
	public int callback(Connection conn)throws SQLException;
}
