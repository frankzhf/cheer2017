package com.cheer.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cheer.ssm.domain.Student;
import com.cheer.ssm.module.impl.StudentView;

@Controller
@RequestMapping("student")
public class StudentController {
	private transient Log log = LogFactory.getLog(getClass());
	
	private static List<Student> store = new ArrayList<Student>();
	
	static{
		{
			Student item = new Student();
			item.setId(1L);
			item.setName("张三");
			item.setStuNo("100001");
			store.add(item);
		}
		{
			Student item = new Student();
			item.setId(2L);
			item.setName("李四");
			item.setStuNo("100002");
			store.add(item);
		}
		{
			Student item = new Student();
			item.setId(3L);
			item.setName("王五");
			item.setStuNo("100003");
			store.add(item);
		}
		{
			Student item = new Student();
			item.setId(4L);
			item.setName("赵六");
			item.setStuNo("100004");
			store.add(item);
		}
		{
			Student item = new Student();
			item.setId(5L);
			item.setName("田七");
			item.setStuNo("100005");
			store.add(item);
		}

	}
	
	
	
	@RequestMapping("list")
	public String list(@ModelAttribute StudentView view, Model model){
		log.debug("Input Param [view] -> " + view);
		if(view == null){
			view = new StudentView();
		}
		view.setData(store);
		model.addAttribute("view",view);
		return "student/list";
	}
	
	
	@RequestMapping(value="form", method=RequestMethod.POST)
	public String form(@ModelAttribute StudentView view, Model model){
		log.debug("Input Param [view] -> " + view);
		if(view.getEditor().getId() == null){
			log.debug("Add new Student");
			Student newStudent = new Student();
			newStudent.setName("新增学生");
			view.setEditor(newStudent);
		}else{
			log.debug("edit exits Student");
			for(int i=0;i<store.size();i++){
				Student item = store.get(i);
				if(item.getId().equals(view.getEditor().getId())){
					view.setEditor(item);
					break;
				}
				
			}	
		}
		model.addAttribute("view",view);
		return "student/form";
	}
	
	@RequestMapping("save")
	public String save(@ModelAttribute StudentView view){
		
		
		return "student/form";
	}
	
	@RequestMapping("delete")
	public String delete(@ModelAttribute StudentView view){
		
		
		return "student/form";
	}
}