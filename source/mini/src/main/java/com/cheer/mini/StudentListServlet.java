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
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6073988565246098334L;
	public static List<Student> store = new ArrayList<Student>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("<meta charset=\"utf-8\">");
		out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">");
		out.println("<title>Servlet -- 学生列表</title>");
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
		out.println("		<div class=\"col-md-12\">");
		out.println("		<form action=\""+req.getContextPath()+"/student/save\" method=\"post\" class=\"form-horizontal\">");
		
		out.println("			<div class=\"form-group\">");
		out.println("			<label class=\"control-label\">标识</label>");
		out.println("			<input type=\"text\" name=\"id\" class=\"form-control\"");
		out.println("				placeholder=\"输入学生的标识\">");
		out.println("			</div>");
		
		out.println("			<div class=\"form-group\">");
		out.println("			<label class=\"control-label\">姓名</label>");
		out.println("			<input type=\"text\" name=\"name\" class=\"form-control\"");
		out.println("				placeholder=\"输入学生的姓名\">");
		out.println("			</div>");
		
		out.println("			<div class=\"form-group\">");
		out.println("			<label class=\"control-label\">年龄</label>");
		out.println("			<input type=\"text\" name=\"age\" class=\"form-control\"");
		out.println("				placeholder=\"输入学生的年龄\">");
		out.println("			</div>");
		
		out.println("			<div class=\"form-group\">");
		out.println("			<label class=\"control-label\">身高</label>");
		out.println("			<input type=\"text\" name=\"height\" class=\"form-control\"");
		out.println("				placeholder=\"输入学生的身高\">");
		out.println("			</div>");

		out.println("			<div class=\"form-group\">");
		out.println("			<label class=\"control-label\">体重</label>");
		out.println("			<input type=\"text\" name=\"weight\" class=\"form-control\"");
		out.println("				placeholder=\"输入学生的体重\">");
		out.println("			</div>");
		out.println("			<div class=\"form-group\">");
		
		out.println("			<input type=\"submit\" class=\"btn btn-primary\"");
		out.println("				value=\"保存\">");
		out.println("			</div>");
		out.println("		</form>");
		out.println("		</div>");
		out.println("		</div>");
		out.println("		<div class=\"row\">");
		out.println("			<div class=\"col-md-12\">");		
		out.println("			<table class=\"table table-striped\">");
		out.println("					<tr>");
		out.println("						<th>标识</th>");
		out.println("						<th>姓名</th>");
		out.println("						<th>年龄</th>");
		out.println("						<th>身高</th>");
		out.println("						<th>体重</th>");
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
