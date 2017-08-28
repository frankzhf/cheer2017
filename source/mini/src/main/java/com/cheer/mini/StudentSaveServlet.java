package com.cheer.mini;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cheer.mini.util.DataBaseUtil;
import com.cheer.mini.util.JdbcOperator;

public class StudentSaveServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5903273630481555372L;
	private transient Log log = LogFactory.getLog(getClass());
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//String id = req.getParameter("id");
		final String name = req.getParameter("name");
		final String age = req.getParameter("age");
		final String height = req.getParameter("height");
		final String weight = req.getParameter("weight");
		
		//log.debug("Varible [id] -> " +id );
		log.debug("Varible [name] -> " +name );
		log.debug("Varible [age] -> " +age );
		log.debug("Varible [height] -> " +height );
		log.debug("Varible [weight] -> " +weight );

		DataBaseUtil.execute(new JdbcOperator(){
			@Override
			public int callback(Statement stmt) throws SQLException {
				String executeSql = "insert into sys_student(id,name,age,height,weight)values('" +
						UUID.randomUUID().toString().replaceAll("-","") + "','" +
						name + "'," +
						age +"," +
						height +"," +
						weight + ")";
				log.debug("execute sql -> " + executeSql);
				stmt.execute(executeSql);
				return 0;
			}
		});
		resp.sendRedirect(req.getContextPath() + "/student/list");
	}
}
