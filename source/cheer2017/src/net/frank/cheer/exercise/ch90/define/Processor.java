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
			response.render(request);
		}else{
			TaiShan.commandMap.get(TaiShan.DEFAULT_COMMAND).handle();
		}
	}
}
