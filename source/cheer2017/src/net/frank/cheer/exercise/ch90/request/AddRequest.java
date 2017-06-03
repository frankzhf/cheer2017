package net.frank.cheer.exercise.ch90.request;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.UUID;

import net.frank.cheer.exercise.ch90.TaiShan;
import net.frank.cheer.exercise.ch90.define.Request;
import net.frank.cheer.exercise.ch90.entity.Student;

public class AddRequest implements Request {
	
	private Student fill;
	
	
	
	public Student getFill(){
		return fill;
	}
	
	@Override
	public boolean input() {
		fill = new Student();
		String [] fields = new String[]{
			"姓名",
			"性别",
			"出生日期",
			"身高",
			"体重"
		};
		String [] reflectFields = {
			"name",
			"sex",
			"birthday",
			"height",
			"weight"
		};
		
		for(int i=0;i<fields.length;i++){
			System.out.print("请输入学生的"+fields[i]+":");
			String value = TaiShan.scanner.nextLine();
			try {
				Field field = Student.class.getDeclaredField(reflectFields[i]);
				field.setAccessible(true);
				if("birthday".equals(reflectFields[i])){
					try {
						field.set(fill,Student.df.parse(value));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					field.set(fill,value);
				}
				field.setAccessible(false);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		fill.setId(UUID.randomUUID().toString());
		return true;
	}
	
	
}
