package com.cheer.mini.ajax;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheer.mini.Student;
import com.cheer.mini.ajax.bean.MiniPackage;
import com.cheer.mini.ajax.bean.PageInfo;
import com.cheer.mini.ajax.bean.StudentView;
import com.cheer.mini.util.DataBaseUtil;
import com.cheer.mini.util.RowMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class StudentListServlet extends AjaxServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6073988565246098334L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String pageNo = req.getParameter("pageNo");
		final String pageSize = req.getParameter("pageSize");
		log.debug("Varible [pageNo] -> " + pageNo);
		log.debug("Varible [pageSize] -> " + pageSize);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNo(Integer.parseInt(pageNo));
		pageInfo.setPageSize(Integer.parseInt(pageSize));
		int count =  DataBaseUtil.getCount("select * from sys_student");
		
		pageInfo.setTotal(count);
		pageInfo.setCount(pageInfo.getTotal()%pageInfo.getPageSize()==0? 
				pageInfo.getTotal()/pageInfo.getPageSize():
				pageInfo.getTotal()/pageInfo.getPageSize() + 1 );
		
		StudentView view = new StudentView();
		view.setPageInfo(pageInfo);
		List<Student> store = DataBaseUtil.pageQuery("select * from sys_student", 
				pageInfo.getPageNo(), pageInfo.getPageSize(), 
				new RowMapper<Student>(){
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
		view.setRecords(store);
		MiniPackage miniPackage = new MiniPackage();
		miniPackage.setData(view);
		
		log.debug("Varible [miniPackage] -> " + miniPackage);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = null;
		try {
			json = mapper.writeValueAsString(miniPackage);
		} catch (JsonProcessingException e) {
			
		}
		log.debug("Varible [json] -> " + json);
		resp.setContentType("applcation/json");
		resp.getWriter().print(json);
		resp.getWriter().flush();
	}
}