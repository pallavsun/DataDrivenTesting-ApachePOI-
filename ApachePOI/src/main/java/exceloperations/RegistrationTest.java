package exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		FileInputStream file=new FileInputStream(".\\datafiles\\regs.xlsx");
		
        XSSFWorkbook workbook=new XSSFWorkbook(file);
	    
	    XSSFSheet sheet=workbook.getSheet("Sheet2");
	    
	  
	    
		   
	    int noOfRows= sheet.getLastRowNum();             // Total no of rows in a sheet
	    System.out.println("No of Records in Excel Sheet "+noOfRows);
	  
	    for(int row=0;row<=noOfRows;row++)          // row
	    {	
	    	
	    	 XSSFRow current_row=sheet.getRow(row);    // Get the current row
	    	
	    	
	     String First_name=current_row.getCell(0).getStringCellValue();
	    String Last_name=current_row.getCell(1).getStringCellValue();	  
	    String Email=current_row.getCell(2).getStringCellValue();
	    String Password=current_row.getCell(3).getStringCellValue();
	    String CnPassword=current_row.getCell(4).getStringCellValue();
	    String Comp=current_row.getCell(5).getStringCellValue();
	    
	    	 
	    	
	    //System.out.println(First_name);
	   // System.out.println(Last_name);
	    
	     
	   
	    
	  
   	       driver.findElement(By.id("FirstName")).sendKeys(First_name);
 	       driver.findElement(By.name("LastName")).sendKeys(Last_name);
   	       driver.findElement(By.name("Email")).sendKeys(Email);
   	       driver.findElement(By.name("Password")).sendKeys(Password);
  	      driver.findElement(By.id("ConfirmPassword")).sendKeys(CnPassword);
   	    driver.findElement(By.name("Company")).sendKeys(Comp);
   	     
 	  	Thread.sleep(4000);
 	  	
 	    driver.findElement(By.id("FirstName")).clear();
   	   driver.findElement(By.name("LastName")).clear();
   	   driver.findElement(By.name("Email")).clear();
   	   driver.findElement(By.name("Password")).clear();
   	   driver.findElement(By.name("Company")).clear();
   	  
   	   //driver.findElement(By.id("ConfirmPassword")).clear();
   
   	   
	    	 }
	    	
	   
	    
  	     
  	     //driver.close();
  	    // driver.quit();
  	    // file.close();
	    
		
	    	 }  	 
	    	 
		
	}

	


