package exceloperations;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wday {

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

		//String s1[]= new String[noOfRows];
		
		
		 for(int row=1;row<=noOfRows;row++)
		{	
              
			String objname=sheet.getRow(row).getCell(0).getStringCellValue();	
			String path=sheet.getRow(row).getCell(1).getStringCellValue();         // store the Xpath in a variable        

			
		     String s1[]=path.split("NA,xpath,");
		     String dir="C:\\Users\\Lenovo\\eclipse-workspace\\ApachePOI\\File\\"+objname ;
		
			
	        // Print all the Xpath		
			for(String k:s1)
			{
				System.out.println(k);
				
				
			}
			

			if(objname.equals("Username"))
			{
				
				driver.findElement(By.xpath(s1[1])).sendKeys("pallav.kumar");
				FileWriter writer1 = new FileWriter(dir);
				 BufferedWriter	out1 = new BufferedWriter(writer1);
				 out1.write(s1[1]);
					out1.newLine();
					out1.close();
			}



			else if(objname.equals("Button"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				FileWriter writer2 = new FileWriter(dir);
				BufferedWriter	out2 = new BufferedWriter(writer2);
				 out2.write(s1[1]);
					out2.newLine();
					out2.close();
			}



			else if(objname.equals("Password"))
			{
				driver.findElement(By.xpath(s1[1])).sendKeys("Vermaarun@123");
				
				
				FileWriter writer3 = new FileWriter(dir);
				BufferedWriter	out3 = new BufferedWriter(writer3);
				 out3.write(s1[1]);
					out3.newLine();
					out3.close();
			}



			else if(objname.equals("Button1"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				
	           FileWriter writer4 = new FileWriter(dir);
				BufferedWriter	out4 = new BufferedWriter(writer4);
				 out4.write(s1[1]);
					out4.newLine();
					out4.close();
				
				//Thread.sleep(1000);
			}
			

			//=============================Home Page objects========================	   



			else if(objname.equals("ViewAllApps"))
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s1[1])));
				
				WebElement ViewApps=driver.findElement(By.xpath(s1[1]));
				ViewApps.isDisplayed();
				ViewApps.click();
				
				
				FileWriter writer5 = new FileWriter(dir);
				BufferedWriter	out5 = new BufferedWriter(writer5);
				 out5.write(s1[1]);
					out5.newLine();
					out5.close();
				
			}

			else if(objname.equals("Time"))
			{

				WebElement TimeIcon=driver.findElement(By.xpath(s1[1]));
				TimeIcon.isDisplayed();
				TimeIcon.click();
				
				
				FileWriter writer6 = new FileWriter(dir);
				BufferedWriter	out6 = new BufferedWriter(writer6);
				 out6.write(s1[1]);
					out6.newLine();
					out6.close();
				
			}



			else if(objname.equals("MyCalendar"))
			{
				WebElement MyCalendarIcon= driver.findElement(By.xpath(s1[1]));
				MyCalendarIcon.isDisplayed();
				MyCalendarIcon.click();
				
				
			    FileWriter writer7 = new FileWriter(dir);
				BufferedWriter	out7 = new BufferedWriter(writer7);
				 out7.write(s1[1]);
					out7.newLine();
					out7.close();
				
			} 


			//=================Workday Entry Page===================================  

			else if(objname.equals("Actions"))
			{
				WebElement ActionIcon=driver.findElement(By.xpath(s1[1]));
				ActionIcon.isDisplayed();
				ActionIcon.click();
				
				
				FileWriter writer8 = new FileWriter(dir);
				BufferedWriter	out8 = new BufferedWriter(writer8);
				 out8.write(s1[1]);
					out8.newLine();
					out8.close();
				
				
				Thread.sleep(2000);
				
			} 


			else if(objname.equals("EnterTimeByType"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				
				FileWriter writer9 = new FileWriter(dir);
				BufferedWriter	out9 = new BufferedWriter(writer9);
				 out9.write(s1[1]);
					out9.newLine();
					out9.close();
				
			} 


			else if(objname.equals("TimeType"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				
				FileWriter writer10 = new FileWriter(dir);
				BufferedWriter	out10 = new BufferedWriter(writer10);
				 out10.write(s1[1]);
					out10.newLine();
					out10.close();
			} 


			else if(objname.equals("MostRecentUsed"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				
				FileWriter writer11 = new FileWriter(dir);
				BufferedWriter	out11 = new BufferedWriter(writer11);
				 out11.write(s1[1]);
					out11.newLine();
					out11.close();
			} 



			else if(objname.equals("ProjectName"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				
				FileWriter writer12 = new FileWriter(dir);
				BufferedWriter	out12 = new BufferedWriter(writer12);
				 out12.write(s1[1]);
					out12.newLine();
					out12.close();
				
				Thread.sleep(2000);
			} 


			else if(objname.equals("DoNotBill"))
			{
				driver.findElement(By.xpath(s1[1])).click();
				
				FileWriter writer13 = new FileWriter(dir);
				BufferedWriter	out13 = new BufferedWriter(writer13);
				 out13.write(s1[1]);
					out13.newLine();
					out13.close();
				
				Thread.sleep(2000);
			} 



			//==========================Enter Time(hrs)================================= 


			else if(objname.equals("Monday"))
			{
				driver.findElement(By.xpath(s1[1])).clear();
				driver.findElement(By.xpath(s1[1])).sendKeys("8");
				
				FileWriter writer14 = new FileWriter(dir);
				BufferedWriter	out14 = new BufferedWriter(writer14);
				 out14.write(s1[1]);
					out14.newLine();
					out14.close();
				
				Thread.sleep(1000);
			} 


			else if(objname.equals("Tuesday"))
			{
				driver.findElement(By.xpath(s1[1])).clear();
				driver.findElement(By.xpath(s1[1])).sendKeys("8");
				
				FileWriter writer15 = new FileWriter(dir);
				BufferedWriter	out15 = new BufferedWriter(writer15);
				 out15.write(s1[1]);
					out15.newLine();
					out15.close();
				

			} 


			else if(objname.equals("Wednesday"))
			{
				driver.findElement(By.xpath(s1[1])).clear();
				driver.findElement(By.xpath(s1[1])).sendKeys("8");
				
				
				FileWriter writer16 = new FileWriter(dir);
				BufferedWriter	out16 = new BufferedWriter(writer16);
				 out16.write(s1[1]);
					out16.newLine();
					out16.close();

			} 


			else if(objname.equals("Thursday"))
			{
				driver.findElement(By.xpath(s1[1])).clear();
				driver.findElement(By.xpath(s1[1])).sendKeys("8");
				
				FileWriter writer17 = new FileWriter(dir);
				BufferedWriter	out17 = new BufferedWriter(writer17);
				 out17.write(s1[1]);
					out17.newLine();
					out17.close();
				
			} 

			else if(objname.equals("Friday"))
			{
				driver.findElement(By.xpath(s1[1])).clear();
				driver.findElement(By.xpath(s1[1])).sendKeys("8");
				
				
				FileWriter writer18 = new FileWriter(dir);
				BufferedWriter	out18 = new BufferedWriter(writer18);
				 out18.write(s1[1]);
					out18.newLine();
					out18.close();
				

			} 


			else if(objname.equals("Ok"))
			{

				driver.findElement(By.xpath(s1[1])).click();
				
				FileWriter writer19 = new FileWriter(dir);
				BufferedWriter	out19 = new BufferedWriter(writer19);
				 out19.write(s1[1]);
					out19.newLine();
					out19.close();

			} 

			
        }

		

	}

}
