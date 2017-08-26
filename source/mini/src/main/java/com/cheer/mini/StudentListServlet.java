package com.cheer.mini;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentListServlet extends HttpServlet {
	
	
	public static List<Student> store = new ArrayList<Student>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">");
		out.println("<title>Bootstrap - Student List</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\""+req.getContextPath()+"/resources/bootstrap-3.3.6/css/bootstrap.css\">");
		out.println("<!--[if lt IE 9]");
		out.println("<script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>	");
		out.println("<script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>");
		out.println("<![endif]-->");
		out.println("<script src=\""+req.getContextPath()+"/resources/jquery-1.11.1/jquery.js\"></script>");
		out.println("<script src=\""+req.getContextPath()+"/resources/bootstrap-3.3.6/js/bootstrap.js\"></script>");
		out.println("<style type=\"text/css\">");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("		<div class=\"row\">");
		
		out.println("		<form action=\""+req.getContextPath()+"/student/save\" method=\"post\" class=\"form-horizontal\">");
		
		out.println("			<div class=\"form-group\">");
		out.println("			<label class=\"control-label\">ID</label>");
		out.println("			<input type=\"text\" name=\"id\" class=\"form-control\"");
		out.println("				placeholder=\"Enter Student's ID\">");
		out.println("			</div>");
		
		out.println("			<div class=\"form-group\">");
		out.println("			<label class=\"control-label\">Name</label>");
		out.println("			<input type=\"text\" name=\"name\" class=\"form-control\"");
		out.println("				placeholder=\"Enter Student's Name\">");
		out.println("			</div>");
		
		out.println("			<div class=\"form-group\">");
		out.println("			<label class=\"control-label\">Age</label>");
		out.println("			<input type=\"text\" name=\"age\" class=\"form-control\"");
		out.println("				placeholder=\"Enter Student's Age\">");
		out.println("			</div>");
		
		out.println("			<div class=\"form-group\">");
		out.println("			<label class=\"control-label\">Height</label>");
		out.println("			<input type=\"text\" name=\"height\" class=\"form-control\"");
		out.println("				placeholder=\"Enter Student's Height\">");
		out.println("			</div>");

		out.println("			<div class=\"form-group\">");
		out.println("			<label class=\"control-label\">Weight</label>");
		out.println("			<input type=\"text\" name=\"weight\" class=\"form-control\"");
		out.println("				placeholder=\"Enter Student's Weight\">");
		out.println("			</div>");
		out.println("			<div class=\"form-group\">");
		
		out.println("			<input type=\"submit\" class=\"btn btn-primary\"");
		out.println("				value=\"Save\">");
		out.println("			</div>");
		out.println("		</form>");
		
		out.println("		</div>");
		out.println("		<div class=\"row\">");
		out.println("			<div class=\"col-md-12\">");		
		out.println("			<table class=\"table table-striped\">");
		out.println("					<tr>");
		out.println("						<th>ID</th>");
		out.println("						<th>Name</th>");
		out.println("						<th>Age</th>");
		out.println("						<th>Height</th>");
		out.println("						<th>Weight</th>");
		out.println("					</tr>");
		for(int i=0;i<store.size();i++){
			Student item = store.get(i);
			out.println("					<tr>");
			out.println("						<td>"+item.getId()+"</td>");
			out.println("						<td>"+item.getName()+"</td>");
			out.println("						<td>"+item.getAge()+"</td>");
			out.println("						<td>"+item.getHeigth()+"</td>");
			out.println("						<td>"+item.getWeight()+"</td>");
			out.println("					</tr>");
		}
		out.println("				</table>");
		out.println("			</div>");
		out.println("		</div>");
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		{
			Student student = new Student();
			student.setId("1");
			student.setName("zhangsan");
			student.setAge(21);
			student.setHeigth(167);
			student.setWeight(55);
			store.add(student);
		}
		
		{
			Student student = new Student();
			student.setId("2");
			student.setName("lisi");
			student.setAge(21);
			student.setHeigth(167);
			student.setWeight(55);
			store.add(student);
		}
		
		{
			Student student = new Student();
			student.setId("3");
			student.setName("wangwu");
			student.setAge(21);
			student.setHeigth(167);
			student.setWeight(55);
			store.add(student);
		}
		
		{
			Student student = new Student();
			student.setId("4");
			student.setName("zhaoliu");
			student.setAge(21);
			student.setHeigth(167);
			student.setWeight(55);
			store.add(student);
		}
		
		
		
	}
	
	
	
}
