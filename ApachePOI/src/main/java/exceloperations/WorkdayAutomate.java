package exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkdayAutomate {

	public static void main(String[] args) throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("https://wd3.myworkday.com/telusinternational/d/home.htmld");
		driver.manage().window().maximize();
		
		

		FileInputStream file=new FileInputStream(".\\datafiles\\WorkdayObjSheetFinal.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("object1");
		
		

		int noOfRows= sheet.getLastRowNum();                          // Total no of rows in a sheet
		System.out.println("No of Records in Excel Sheet "+noOfRows);

		 for(int row=1;row<=noOfRows;row++)
	  {	
			 String objname=sheet.getRow(row).getCell(0).getStringCellValue();	
			 String path=sheet.getRow(row).getCell(1).getStringCellValue();              
 
			 
	   List<String[][]> listOfString= new ArrayList(); 
	   {
	   listOfString.add(new String[][] {{objname,path}});
	   }	
	  
	   
	   for(String[][] data: listOfString)
	   {
	   System.out.println(data);
	   }
	   
	  }
		 
		
			 
	  }
		 
	
	

	}

