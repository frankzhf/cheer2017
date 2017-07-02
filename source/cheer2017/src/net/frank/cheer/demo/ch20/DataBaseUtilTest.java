package net.frank.cheer.demo.ch20;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseUtilTest {

	public static void main(String[] args) {
		
		DataBaseUtil.execute(new JdbcOperator() {
			@Override
			public int callback(Connection conn) throws SQLException {
				boolean rt = conn.createStatement()
						.execute("insert into sys_account(id,account_no,account_name,amost) values(3,'6454-82328-3222','wangwu',150000)");
				if(rt)
					return 0;
				else
					return -1;
			}
		});
		
		DataBaseUtil.execute(new JdbcOperator() {
			@Override
			public int callback(Connection conn) throws SQLException {
				boolean rt = conn.createStatement()
						.execute("update sys_account set amost=200000 where id=3");
				if(rt)
					return 0;
				else
					return -1;
			}
		});
		
		
	}

}
