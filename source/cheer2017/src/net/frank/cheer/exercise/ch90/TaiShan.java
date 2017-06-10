package net.frank.cheer.exercise.ch90;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import net.frank.cheer.exercise.ch90.define.Processor;
import net.frank.cheer.exercise.ch90.define.Request;
import net.frank.cheer.exercise.ch90.define.Response;
import net.frank.cheer.exercise.ch90.entity.Student;
import net.frank.cheer.exercise.ch90.request.AddRequest;
import net.frank.cheer.exercise.ch90.request.ExitRequest;
import net.frank.cheer.exercise.ch90.request.ExportRequest;
import net.frank.cheer.exercise.ch90.request.ImportRequest;
import net.frank.cheer.exercise.ch90.request.ViewRequest;
import net.frank.cheer.exercise.ch90.response.AddResponse;
import net.frank.cheer.exercise.ch90.response.ExitResponse;
import net.frank.cheer.exercise.ch90.response.ExportResponse;
import net.frank.cheer.exercise.ch90.response.ImportResponse;
import net.frank.cheer.exercise.ch90.response.ViewResponse;

public class TaiShan {
	
	public static List<Student> data = new ArrayList<Student>();
	
	public final static Map<String,Processor> commandMap = new HashMap<String,Processor>();
	
	public final static String DEFAULT_COMMAND = "M";
	
	public final static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		init();
		Processor processor = new Processor(
			new Request(){
				@Override
				public boolean input() {
					return true;
				}
			},
			new Response(){
				@Override
				public void render(Request request) {
					System.out.println("在这里你可以输入以下命令");
					System.out.println("V - 查看学生信息");
					System.out.println("A - 增加一个学生信息");
					System.out.println("O - 导出学生信息");
					System.out.println("I - 导入学生信息");
					System.out.println("E - 退出系统");
					while(scanner.hasNextLine()){
						String command = scanner.nextLine();
						Processor _p = commandMap.get(command.toUpperCase());
						if(_p!=null){
							_p.handle();
						}else{
							System.out.println("命令不存在！退到主菜单");
							Processor _m = commandMap.get(DEFAULT_COMMAND);
							_m.handle();
							return;
						}
					}
					
				}				
			}
		);
		commandMap.put(DEFAULT_COMMAND, processor);
		System.out.println("------------------");
		System.out.println("|欢迎来到泰山系统！  |");
		System.out.println("------------------");
		processor.handle();
	}
	
	public static void init(){
		Processor v = new Processor(new ViewRequest(),new ViewResponse());
		commandMap.put("V", v);
		Processor a = new Processor(new AddRequest(),new AddResponse());
		commandMap.put("A", a);
		Processor e = new Processor(new ExportRequest(),new ExportResponse());
		commandMap.put("E", e);
		Processor i = new Processor(new ImportRequest(),new ImportResponse());
		commandMap.put("I", i);
		Processor x = new Processor(new ExitRequest(),new ExitResponse());
		commandMap.put("X", x);
	}

}
