package exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.*;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		String excelFilePath=".\\datafiles\\countries.xlsx";      // Location of Excel file
		FileInputStream inputStream=new FileInputStream(excelFilePath);   // Open the file in stream mode
		
		
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
	// =====Using For loop=========
		
  		
		 int rows= sheet.getLastRowNum();             // Total no of rows in a sheet
		 int cols=sheet.getRow(1).getLastCellNum();     // Get no of columns in row 1
		
		
		 for(int r=0;r<=rows;r++)             // Represent row
		 {
			XSSFRow row=sheet.getRow(r);         
			
			 for(int c=0;c<cols;c++)                 // Represents Cell in a row
			 {
			XSSFCell cell=row.getCell(c);
			
			    switch(cell.getCellType())
			 {
			    
			    case STRING: System.out.print(cell.getStringCellValue());break;
			    case NUMERIC:System.out.print(cell.getNumericCellValue());break;
			    case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;
			 }
			
			   System.out.print(" |  "); 
				 
			 }
			 
			 System.out.println();
		 }
		 
	
		
	
	//===========Using Iterator==========
		
	/*	  
		Iterator iterator=sheet.iterator();           // Using this iterator we get all the rows and columns
		
		while(iterator.hasNext())
		{
			XSSFRow row=(XSSFRow) iterator.next();
			Iterator celliterator=row.cellIterator();
			
			while(celliterator.hasNext())
			{
				
				XSSFCell cell=(XSSFCell) celliterator.next();
				
				   switch(cell.getCellType())
					 {
					    
					    case STRING: System.out.print(cell.getStringCellValue());break;
					    case NUMERIC:System.out.print(cell.getNumericCellValue());break;
					    case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;
					 }
				   
				  System.out.print("  | "); 
			  	
			}
			
			System.out.println();
			
		}
		
		*/
		
	
		 
		
	}

}
