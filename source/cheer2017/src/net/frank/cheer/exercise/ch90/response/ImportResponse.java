package net.frank.cheer.exercise.ch90.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import net.frank.cheer.exercise.ch90.TaiShan;
import net.frank.cheer.exercise.ch90.define.Request;
import net.frank.cheer.exercise.ch90.define.Response;
import net.frank.cheer.exercise.ch90.entity.Student;
import net.frank.cheer.exercise.ch90.request.ImportRequest;

public class ImportResponse implements Response {

	@Override
	public void render(Request request) {
		ImportRequest _request = (ImportRequest)request;
		String storeFilePath = _request.getStoreFilePath();
		
		ObjectInputStream oin = null;
		FileInputStream fin = null;
		try{
			fin = new FileInputStream(storeFilePath);
			oin = new ObjectInputStream(fin);
			Object content = oin.readObject();
			if(content instanceof List){
				List<?> fileData = (List<?>) content;
				for(int i = 0;i<fileData.size();i++){
					Object item = fileData.get(i);
					if(item instanceof Student){
						Student student = (Student) item;
						TaiShan.data.add(student);
					}
				}
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(oin!=null){
					oin.close();
				}
				if(fin!=null){
					fin.close();
				}
			}catch(IOException e){
				
			}
		}
		System.out.println("数据导入成功！");
		TaiShan.commandMap.get(TaiShan.DEFAULT_COMMAND).handle();
	}

}
