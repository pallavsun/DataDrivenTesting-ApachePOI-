package exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkDay {

	private static final Object Username = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);



		driver.get("https://wd3.myworkday.com/telusinternational/d/home.htmld");
		driver.manage().window().maximize();

		FileInputStream file=new FileInputStream(".\\datafiles\\wd.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");



		int noOfRows= sheet.getLastRowNum();                          // Total no of rows in a sheet
		System.out.println("No of Records in Excel Sheet "+noOfRows);

		
		for(int row=1;row<=noOfRows;row++)
		{	
               

		//	XSSFRow current_row=sheet.getRow(row);    // Get the current row

			String objname=sheet.getRow(row).getCell(0).getStringCellValue();	
			String path=sheet.getRow(row).getCell(1).getStringCellValue();         // store the Xpath in a variable        

			
			String s1[]=path.split("NA,xpath,");
			
			
	        // Print all the Xpath		
			for(String k:s1)
			{
				System.out.println(k);
			}
			

			if(objname.equals("Username"))
			{
				driver.findElement(By.xpath(s1[1])).sendKeys("pallav.kumar");
				

			}



			else if(objname.equals("Button"))
			{
				driver.findElement(By.xpath(s1[1])).click();
			}



			else if(objname.equals("Password"))
			{
				driver.findElement(By.xpath(s1[1])).sendKeys("Vermaarun@123");
				
			}



			else if(objname.equals("Button1"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				//Thread.sleep(1000);
			}


			//=============================Home Page objects========================	   



			else if(objname.equals("ViewAllApps"))
			{
				WebElement ViewApps=driver.findElement(By.xpath(s1[1]));
				ViewApps.isDisplayed();
				ViewApps.click();
				
			}

			else if(objname.equals("Time"))
			{

				WebElement TimeIcon=driver.findElement(By.xpath(s1[1]));
				TimeIcon.isDisplayed();
				TimeIcon.click();
				
			}



			else if(objname.equals("MyCalendar"))
			{
				WebElement MyCalendarIcon= driver.findElement(By.xpath(s1[1]));
				MyCalendarIcon.isDisplayed();
				MyCalendarIcon.click();
				
			} 


			//=================Workday Entry Page===================================  

			else if(objname.equals("Actions"))
			{
				WebElement ActionIcon=driver.findElement(By.xpath(s1[1]));
				ActionIcon.isDisplayed();
				ActionIcon.click();
				Thread.sleep(2000);
				
			} 


			else if(objname.equals("EnterTimeByType"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				
			} 


			else if(objname.equals("TimeType"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				
			} 


			else if(objname.equals("MostRecentUsed"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				
			} 



			else if(objname.equals("ProjectName"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				Thread.sleep(2000);
			} 


			else if(objname.equals("DoNotBill"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				Thread.sleep(2000);
			} 



			//==========================Enter Time(hrs)================================= 


			else if(objname.equals("Monday"))
			{
				driver.findElement(By.xpath(s1[1])).clear();
				driver.findElement(By.xpath(s1[1])).sendKeys("8");
				Thread.sleep(1000);
			} 


			else if(objname.equals("Tuesday"))
			{
				driver.findElement(By.xpath(s1[1])).clear();
				driver.findElement(By.xpath(s1[1])).sendKeys("8");

			} 


			else if(objname.equals("Wednesday"))
			{
				driver.findElement(By.xpath(s1[1])).clear();
				driver.findElement(By.xpath(s1[1])).sendKeys("8");

			} 


			else if(objname.equals("Thursday"))
			{
				driver.findElement(By.xpath(s1[1])).clear();
				driver.findElement(By.xpath(s1[1])).sendKeys("8");

			} 

			else if(objname.equals("Friday"))
			{
				driver.findElement(By.xpath(s1[1])).clear();
				driver.findElement(By.xpath(s1[1])).sendKeys("8");

			} 


			else if(objname.equals("Ok"))
			{

				driver.findElement(By.xpath(s1[1])).click();

			} 


        }


	}

}
