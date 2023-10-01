package exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class DataDrivenTesting {

	public static void main(String[] args) throws IOException {
		
		
		
		FileInputStream file=new FileInputStream(".\\datafiles\\countries.xlsx");   // Open the file in stream mode
	    XSSFWorkbook workbook=new XSSFWorkbook(file);
	    
	    XSSFSheet sheet=workbook.getSheet("Sheet1");   //providing sheet name
	    
	    
	    int rowcount= sheet.getLastRowNum();             // Total no of rows in a sheet
		 int colcount=sheet.getRow(0).getLastCellNum();
	    
	    
	     for(int i=0;i<rowcount;i++)
	     {
	    	 XSSFRow currentrow=sheet.getRow(i);   
	    	 
	    	 
	    	for(int j=0;j<colcount;j++)
	    	{
	    		
	    		String value=currentrow.getCell(j).toString();    // read the value from a cell
	    		System.out.print("   " +value);
	    		
	    	}
	    	
	    	    System.out.println();
				
	     }
	    
	    
	    
	}

}
