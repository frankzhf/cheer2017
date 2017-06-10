package net.frank.cheer.exercise.ch90.request;

import net.frank.cheer.exercise.ch90.TaiShan;
import net.frank.cheer.exercise.ch90.define.Request;

public class ImportRequest implements Request {
	
	private String storeFilePath;
	
	public String getStoreFilePath(){
		return storeFilePath;
	}
	
	@Override
	public boolean input() {
		System.out.print("请输入保存文件的路径:");
		storeFilePath = TaiShan.scanner.nextLine();
		
		return true;
	}

}
