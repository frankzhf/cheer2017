package net.frank.cheer.demo.ch15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class ZipUtil {
	
	private ZipUtil(){}
	
	public static void zip(String zipFileName, File inputFile) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		zip(out, inputFile, "");
		System.out.println("—πÀı÷–...");
		out.close();
	}

	private static void zip(ZipOutputStream out, File f, String base) throws Exception {
		if (f.isDirectory()) {
			File[] fileList = f.listFiles();
			if(base!=null && base.length()!=0){
				out.putNextEntry(new ZipEntry(base + File.separator));
			}
			for(int i=0;i<fileList.length;i++){
				zip(out,fileList[i],base + fileList[i]);
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int flag;
			while((flag = in.read())!=-1){
				out.write(flag);
			}
			in.close();

		}
	}
	
	
	public static void main(String[] args)throws Exception{
		ZipUtil.zip("e:/monkey_backup.zip", new File("E:/zhaofeng/monkey"));
	}
	
}
