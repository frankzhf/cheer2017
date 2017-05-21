package net.frank.cheer.demo.ch15;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		//System.out.print("\n");
		//System.out.print("\t");
		File f = new File("E:/zhaofeng/software/PuTTY_0.67.0.0.exe");
		//File f0 = new File("E:\\zhaofeng\\test");
		//"/" "\\"
		if(f.exists()){
			if(f.isDirectory()){
				System.out.println("is folder");
			}else{
				System.out.println("is file");
				System.out.println("The file size is "+f.length() + " bytes" );
				
			}
			System.out.println(f.getName());
			System.out.println(f.getAbsolutePath());
		}else{
			System.out.println("The Folder or File not exits!");
			boolean created = f.mkdir();
			System.out.println("File is created ? " + created);
		}
	}

}
