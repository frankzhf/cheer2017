package com.cheer.mini;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentSaveServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5903273630481555372L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		
		System.out.println("Varible [id] -> " +id );
		System.out.println("Varible [name] -> " +name );
		System.out.println("Varible [age] -> " +age );
		System.out.println("Varible [height] -> " +height );
		System.out.println("Varible [weight] -> " +weight );

		Student item  = new Student();
		item.setId(id);
		item.setName(name);
		item.setAge(Integer.parseInt(age));
		item.setHeigth(Integer.parseInt(height));
		item.setWeight(Integer.parseInt(weight));
		
		StudentListServlet.store.add(item);
		
		resp.sendRedirect(req.getContextPath() + "/student/list");
		
		
	}
}
