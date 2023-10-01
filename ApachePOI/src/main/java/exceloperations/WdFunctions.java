package exceloperations;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WdFunctions {
	
	static WebDriver driver;
	
	public  static void WORKDAYLOGIN(String objname, String s1) throws IOException, InterruptedException {
       
		
       if(objname.equals("WorkdayUsername"))
		{
			
			driver.findElement(By.xpath(s1)).sendKeys("pallav.kumar");

		}

		else if(objname.equals("WorkdayButton"))
		{
			driver.findElement(By.xpath(s1)).click();
			
		}

		else if(objname.equals("WorkdayPassword"))
		{
			driver.findElement(By.xpath(s1)).sendKeys("Vermaarun@123");
			
		}

		else if(objname.equals("WorkdaySubmitButton"))
		{
			driver.findElement(By.xpath(s1)).click();
			
		}
		

	}


	public static void main(String[] args) throws IOException, InterruptedException {
		
		

		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://wd3.myworkday.com/telusinternational/d/home.htmld");
		driver.manage().window().maximize();

        String excelPath=".\\\\datafiles\\\\WdFunc.xlsx";
		FileInputStream file=new FileInputStream(excelPath);
		

		XSSFWorkbook excel=new XSSFWorkbook(file);
		
		XSSFSheet sheet = excel.getSheetAt(0);
	

		int noOfRows= sheet.getLastRowNum();                          // Total no of rows in a sheet
		//System.out.println("No of Records in Excel Sheet "+noOfRows);
		
		String objname;
		String xpath;
		for(int row=1;row<=noOfRows;row++){	
		
			objname = new String (sheet.getRow(row).getCell(0).getStringCellValue());
			String path=sheet.getRow(row).getCell(1).getStringCellValue();         // store the Xpath in a variable        
			
			xpath = new String(path.substring(9));
			
				
				System.out.println(xpath);
				
				WORKDAYLOGIN(objname,xpath);
				
			}

		
		
		

	}

}
