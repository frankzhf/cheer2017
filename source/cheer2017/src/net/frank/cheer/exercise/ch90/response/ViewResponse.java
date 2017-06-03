package net.frank.cheer.exercise.ch90.response;

import net.frank.cheer.exercise.ch90.TaiShan;
import net.frank.cheer.exercise.ch90.define.Request;
import net.frank.cheer.exercise.ch90.define.Response;
import net.frank.cheer.exercise.ch90.entity.Student;

public class ViewResponse implements Response {

	@Override
	public void render(Request request) {
		System.out.println("当前总共有" +TaiShan.data.size()+"条学生记录");
		System.out.println("id\t\t\tname\t\tsex\t\tbirthday\t\theight\t\tweight");
		System.out.println("------------------------------------------------------------------------------------");
		for(int i=0;i<TaiShan.data.size();i++){
			Student student = TaiShan.data.get(i);
			System.out.println(student);
		}
		
	}

}
