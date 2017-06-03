package net.frank.cheer.demo.ch16;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class PoiTest {
	public static void main(String[] args)throws Exception{
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("POI Test");
		
		HSSFRow row = sheet.createRow(1);
		HSSFCell cell = row.createCell(1);
		cell.setCellValue("Hello POI");
		
		workbook.write(new FileOutputStream("E:/zhaofeng/test/testExcel.xls"));
		
	}
}