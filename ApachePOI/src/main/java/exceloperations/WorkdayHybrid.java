package exceloperations;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkdayHybrid {
	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		
	/*	
		FileWriter file = new FileWriter("C:\\Users\\Lenovo\\eclipse-workspace\\ApachePOI\\File\\WorkdayHybrid.txt");

		// Creates a BufferedWriter
		BufferedWriter output = new BufferedWriter(file);

		PrintWriter pw = new PrintWriter(output);

		//Add timestamp
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
		//get current date time with Date()
		Date dt = new Date();

		// Now format the date
		String dt1= df.format(dt);
		
		int step=1;
		String status="Passed";
		pw.println("Step:" + step++ +" - " +status + " - " + "Launch Workday UI"+" - "+"Chrome"+ " \t" +dt1);
		
	*/
		LaunchBrowser();
		HashMap<Integer,String> hmap_variable_name=new HashMap<Integer,String>();

		HashMap<Integer,String> hmap_variable_value=new HashMap<Integer,String>();

		HashMap<Integer,String> hmap_cobj_name=new HashMap<Integer,String>();

		FileInputStream file1=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\ApachePOI\\datafiles\\WorkdayObjSheetFinal.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file1);
		XSSFSheet sheet=workbook.getSheetAt(0);


		int noOfRows= sheet.getPhysicalNumberOfRows();      
		int x=1,y=1;
		for(int row=2;row<=noOfRows;row++)
		{	

			String objname=sheet.getRow(row).getCell(0).getStringCellValue();	
			String path=sheet.getRow(row).getCell(1).getStringCellValue();              


			String s1[]=path.split("NA,xpath,");
			hmap_variable_name.put(x, objname);
			hmap_variable_value.put(y, s1[1]);
			x++;
			y++;
			if(row==23)
				break;
		}	
		workbook.close();
		
		FileInputStream cfile=new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\ApachePOI\\datafiles\\Workday Component sheet Final.xlsx");
		XSSFWorkbook cworkbook=new XSSFWorkbook(cfile);
		XSSFSheet csheet=cworkbook.getSheetAt(0);


		int cnoOfRows= csheet.getPhysicalNumberOfRows();                          
		int keycount=1;
		for(int crow=2;crow<=cnoOfRows;crow++)
		{	

			//String eventname=csheet.getRow(crow).getCell(0).getStringCellValue();	
			String cnobj=csheet.getRow(crow).getCell(1).getStringCellValue();          
			//String ctestdta= csheet.getRow(2).getCell(2).getStringCellValue(); 
			
			hmap_cobj_name.put(keycount, cnobj);
			keycount++;
			if(crow==46)
				break;
		}

		cworkbook.close();
		String curr_variable_name="";
		String curr_variable_value="";

		if(hmap_cobj_name.containsValue("WORKDAYLOGIN_WriteLogHeader"))
		{
			for(int i=1;i<=5;i++) 
			{
				int flag=0;
				curr_variable_name = hmap_variable_name.get(i);
				if (curr_variable_name.equals("WorkdayUsername"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1)
					{
						WORKDAYLOGIN(curr_variable_name ,curr_variable_value);
					}
				}

				else if (curr_variable_name.equals("WorkdaySubmitButton1"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1)
					{
						WORKDAYLOGIN(curr_variable_name ,curr_variable_value);
					}
				}

				else if (curr_variable_name.equals("WorkdayPassword"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1)
					{
						WORKDAYLOGIN(curr_variable_name ,curr_variable_value);
					}
				}

				else if (curr_variable_name.equals("WorkdaySubmitButton"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1)
					{
						WORKDAYLOGIN(curr_variable_name ,curr_variable_value);
					}
				}
			}
		}
		if(hmap_cobj_name.containsValue("WORKDAYTIMEENTRY_WriteLogHeader")) 
		{
			for(int i=6;i<=22;i++) 
			{
				int flag=0;
				curr_variable_name = hmap_variable_name.get(i);
				if (curr_variable_name.equals("WorkdayGlobalNavigation"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}

				else if (curr_variable_name.equals("WorkdayTime"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}

				else if (curr_variable_name.equals("WorkdayEnterTimeThisWeek"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}

				else if (curr_variable_name.equals("WorkdayEnterTimeByTypeSearch"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}

				else if (curr_variable_name.equals("WorkdayProjectNameG&AIdleTime"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}

				else if (curr_variable_name.equals("WorkdayCustomer"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}
				else if (curr_variable_name.equals("WorkdayDnbCheckbox"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}
				else if (curr_variable_name.equals("WorkdayWeekdayMonday"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}
				else if (curr_variable_name.equals("WorkdayWeekdayTuesday"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}
				else if (curr_variable_name.equals("WorkdayWeekdayWednesday"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}
				else if (curr_variable_name.equals("WorkdayWeekdayThursday"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}
				else if (curr_variable_name.equals("WorkdayWeekdayFriday"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
					//Thread.sleep(5000);
					//QuitBrowser();
				}
				else if (curr_variable_name.equals("WorkdayTimesheetOkBtn"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}
				else if (curr_variable_name.equals("WorkdayTimesheetReviewBtn"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}
				
				else if (curr_variable_name.equals("WorkdayTotalProjectHours"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}
				else if (curr_variable_name.equals("WorkdayEnterYourComment"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}
				
				else if (curr_variable_name.equals("WorkdayFinalSubmitButton"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					flag=CheckForElementExixtence(curr_variable_name,curr_variable_value);
					if(flag==1) 
					{
						WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
					}
				}
			}
		}
	}
	@SuppressWarnings("deprecation")
	static void LaunchBrowser() {
		//System property for the msedge driver
		//System.setProperty("webdriver.chrome.driver", ".\\Drivers\\msedgedriver.exe");
		
		WebDriverManager.chromedriver().setup();

		//Creating instance of msedge driver
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://wd3.myworkday.com/telusinternational/d/home.htmld");
		driver.manage().window().maximize();
	}

	static void QuitBrowser() {
		driver.quit();
	}
	
	static int CheckForElementExixtence(String objectName,String objectValue) {
		WebElement obv = driver.findElement(By.xpath(objectValue));
		int flag=0;
		if(obv.isDisplayed()) 
		{
			System.out.println(objectName+"is Displayed");
			if(obv.isEnabled())
			{
				System.out.println(objectName+"is Enabled");
				return flag=1;
			}
		}
		return flag;
	}

	static void WORKDAYLOGIN(String objectName,String objectValue) {

		if(objectName.equals("WorkdayUsername"))
		{
			driver.findElement(By.xpath(objectValue)).sendKeys("pallav.kumar");

		}

		else if(objectName.equals("WorkdaySubmitButton1"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			driver.findElement(By.xpath(objectValue)).click();

		}

		else if(objectName.equals("WorkdayPassword"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			driver.findElement(By.xpath(objectValue)).sendKeys("Vermaarun@123");

		}

		else if(objectName.equals("WorkdaySubmitButton"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			driver.findElement(By.xpath(objectValue)).click();
		}
	}
	
	static void WORKDAYTIMEENTRY(String objectName,String objectValue) throws InterruptedException {
		
		if(objectName.equals("WorkdayGlobalNavigation"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			WebElement ViewApps=driver.findElement(By.xpath(objectValue));
			ViewApps.click();
		}

		else if(objectName.equals("WorkdayTime"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			
			WebElement TimeIcon=driver.findElement(By.xpath(objectValue));
			TimeIcon.click();
		}



		else if(objectName.equals("WorkdayEnterTimeThisWeek"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			
			WebElement ThisWeekBtn= driver.findElement(By.xpath(objectValue));
			ThisWeekBtn.click();

		} 


		
		else if(objectName.equals("WorkdayEnterTimeByTypeSearch"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			
			driver.findElement(By.xpath(objectValue)).click();
			driver.findElement(By.xpath(objectValue)).sendKeys("chr");
			driver.findElement(By.xpath(objectValue)).sendKeys(Keys.ENTER);
			Thread.sleep(2000);

		} 



		else if(objectName.equals("WorkdayProjectNameG&AIdleTime"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			driver.findElement(By.xpath(objectValue)).click();
			Thread.sleep(2000);

		} 


		else if(objectName.equals("WorkdayCustomer"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			driver.findElement(By.xpath(objectValue));
		} 


		else if(objectName.equals("WorkdayDnbCheckbox"))
		{
			driver.findElement(By.xpath(objectValue)).click();
		} 

		

		else if(objectName.equals("WorkdayWeekdayMonday"))
		{
			driver.findElement(By.xpath(objectValue)).clear();
			driver.findElement(By.xpath(objectValue)).sendKeys("8");
			driver.findElement(By.xpath(objectValue)).sendKeys(Keys.ENTER);

		} 


		else if(objectName.equals("WorkdayWeekdayTuesday"))
		{
			driver.findElement(By.xpath(objectValue)).clear();
			driver.findElement(By.xpath(objectValue)).sendKeys("8");
			driver.findElement(By.xpath(objectValue)).sendKeys(Keys.ENTER);
		} 			 


		else if(objectName.equals("WorkdayWeekdayWednesday"))
		{
			driver.findElement(By.xpath(objectValue)).clear();
			driver.findElement(By.xpath(objectValue)).sendKeys("8");
			driver.findElement(By.xpath(objectValue)).sendKeys(Keys.ENTER);

		} 


		else if(objectName.equals("WorkdayWeekdayThursday"))
		{
			driver.findElement(By.xpath(objectValue)).clear();
			driver.findElement(By.xpath(objectValue)).sendKeys("8");
			driver.findElement(By.xpath(objectValue)).sendKeys(Keys.ENTER);
		} 


		else if(objectName.equals("WorkdayWeekdayFriday"))
		{
			driver.findElement(By.xpath(objectValue)).clear();
			driver.findElement(By.xpath(objectValue)).sendKeys("8");
			driver.findElement(By.xpath(objectValue)).sendKeys(Keys.ENTER);
		} 

		
		else if(objectName.equals("WorkdayTimesheetOkBtn"))
		{
			driver.findElement(By.xpath(objectValue)).click();
		} 
		
	/*	

		else if(objectName.equals("WorkdayTimesheetReviewBtn"))
		{
			driver.findElement(By.xpath(objectValue)).click();
		} 
		
		else if(objectName.equals("WorkdayTotalProjectHours"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			WebElement TotalHours = driver.findElement(By.xpath(objectValue));
			System.out.println(TotalHours);
			Thread.sleep(2000);
		}
		
		
		else if(objectName.equals("WorkdayEnterYourComment"))
		{
		
			driver.findElement(By.xpath(objectValue)).sendKeys("Done");
			Thread.sleep(2000);
		}
		
		else if(objectName.equals("WorkdayFinalSubmitButton"))
		{
			driver.findElement(By.xpath(objectValue)).click();
		}
		
		*/
		
	}
}