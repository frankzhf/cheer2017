package net.frank.cheer.exercise.ch90.define;

import net.frank.cheer.exercise.ch90.TaiShan;

public class Processor {
	
	private Request request;
	private Response response;
	
	public Processor(
			Request request, Response response){
		this.request = request;
		this.response = response;
	}
	
	
	public void handle(){
		if(request.input()){
			response.render();
		}else{
			System.out.println("按回车返回主菜单！");
			while(TaiShan.scanner.hasNextLine()){
				try{
					TaiShan.cleanConsole();
				}catch(Exception e){
					
				}
				TaiShan.commandMap.get(TaiShan.DEFAULT_COMMAND).handle();
				return;
			}
			
		}
	}
}
