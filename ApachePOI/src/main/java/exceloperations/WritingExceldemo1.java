package exceloperations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExceldemo1 {

	public static void main(String[] args) throws IOException {
		
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Emp Info");
		
		
		Object empdata[][]= { {"EmpID","Name","Job"},
				              {101,"David","Engineer"},
				              {102,"Smith","Manager"},
				              {103,"Scott","Analyst"}
		
	                         };
		
	//============Using For loop==========
		
		int rows=empdata.length;
		int cols=empdata[0].length;
		
		
		for(int r=0;r<rows;r++)                     
		{
			XSSFRow row=sheet.createRow(r);
			
			for(int c=0;c<cols;c++)
			{
				
				XSSFCell cell=row.createCell(c);
				Object value=empdata[r][c];
				
			if(value instanceof String)
				cell.setCellValue((String)value);
			if(value instanceof Integer)
				cell.setCellValue((Integer)value);
			if(value instanceof Boolean)
				cell.setCellValue((Boolean)value);
				
		   }
		}
		
		
		/*   Using For each loop
		 * int rowCount=0;  
		 * 
		 * for(Object emp[]:empdata)                   // Store first row value
		 * {
		 *     XSSFRow row=sheet.createRow(rowCount++);
		 *      int columnCount=0;
		 *      
		 *      for(Object value:emp)
		 *      {
		 *      
		 *      XSSFCell cell=row.createCell(columnCount++);
		 *      
		 *    if(value instanceof String)
				cell.setCellValue((String)value);
			if(value instanceof Integer)
				cell.setCellValue((Integer)value);
			if(value instanceof Boolean)
				cell.setCellValue((Boolean)value);
		 *      
		 *      }
		 * }
		 * 
		 * 
		 * 
		 */
		
		
		
		
		
		
		
		
		
		String filePath=".\\datafiles\\employee.xlsx";
		FileOutputStream outstream=new FileOutputStream(filePath);
		workbook.write(outstream);
		
		outstream.close();
		
		System.out.println("File written successfully");
		
		
	}
	

}
