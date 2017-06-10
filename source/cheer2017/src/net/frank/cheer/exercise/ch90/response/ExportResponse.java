package net.frank.cheer.exercise.ch90.response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import net.frank.cheer.exercise.ch90.TaiShan;
import net.frank.cheer.exercise.ch90.define.Request;
import net.frank.cheer.exercise.ch90.define.Response;
import net.frank.cheer.exercise.ch90.request.ExportRequest;

public class ExportResponse implements Response {

	@Override
	public void render(Request request) {
		ExportRequest _request = (ExportRequest)request;
		String storeFilePath = _request.getStoreFilePath();		
		ObjectOutputStream objectOut = null;
		FileOutputStream fout = null;
		try{
			fout = new  FileOutputStream (storeFilePath);
			objectOut = new ObjectOutputStream(fout);
			objectOut.writeObject(TaiShan.data);
		}catch(IOException e){
			
		}finally{
			try{
				if(objectOut!=null){
					objectOut.close();
				}
				if(fout!=null){
					fout.close();
				}
			}catch(IOException e){
				
			}
		}
		System.out.println("数据保存成功！");
		TaiShan.commandMap.get(TaiShan.DEFAULT_COMMAND).handle();
	}

}
