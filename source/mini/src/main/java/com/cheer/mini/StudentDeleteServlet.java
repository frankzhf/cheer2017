package com.cheer.mini;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cheer.mini.util.DataBaseUtil;
import com.cheer.mini.util.JdbcOperator;

public class StudentDeleteServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7893321760092428618L;
	private transient Log log = LogFactory.getLog(getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String id = req.getParameter("id");
		
		DataBaseUtil.execute(new JdbcOperator(){
			@Override
			public int callback(Statement stmt) throws SQLException {
				String executeSql =  "delete from sys_student where id='"+id+"'";
				log.debug("execute SQl : " + executeSql);
				stmt.execute(executeSql);
				return 0;
			}
		});
		resp.sendRedirect(req.getContextPath() + "/student/list");
	}
	
}
