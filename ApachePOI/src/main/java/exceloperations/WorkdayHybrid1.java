package exceloperations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
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

public class WorkdayHybrid1 {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

				
		HashMap<Integer,String> hmap_variable_name=new HashMap<Integer,String>();

		HashMap<Integer,String> hmap_variable_value=new HashMap<Integer,String>();

		HashMap<Integer,String> hmap_cobj_name=new HashMap<Integer,String>();

		FileInputStream file1=new FileInputStream(".\\datafiles\\WorkdayObjSheetFinal.xlsx");
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

	// ================ Extract the data from Component sheet=========================	
		
		FileInputStream cfile=new FileInputStream(".\\datafiles\\Workday Component sheet Final.xlsx");
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

		LaunchBrowser();

		String curr_variable_name="";
		String curr_variable_value="";

		if(hmap_cobj_name.containsValue("WORKDAYLOGIN_WriteLogHeader"))
		{
			for(int i=1;i<=5;i++) 
			{
				curr_variable_name = hmap_variable_name.get(i);
				if (curr_variable_name.equals("WorkdayUsername"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYLOGIN(curr_variable_name ,curr_variable_value);
				}

				else if (curr_variable_name.equals("WorkdaySubmitButton1"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYLOGIN(curr_variable_name ,curr_variable_value);
				}

				else if (curr_variable_name.equals("WorkdayPassword"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYLOGIN(curr_variable_name ,curr_variable_value);
				}

				else if (curr_variable_name.equals("WorkdaySubmitButton"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYLOGIN(curr_variable_name ,curr_variable_value);
				}
			}
		}

		if(hmap_cobj_name.containsValue("WORKDAYTIMEENTRY_WriteLogHeader")) 
		{
			for(int i=6;i<=22;i++) 
			{
				curr_variable_name = hmap_variable_name.get(i);
				if (curr_variable_name.equals("WorkdayGlobalNavigation"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}

				else if (curr_variable_name.equals("WorkdayTime"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}

				else if (curr_variable_name.equals("WorkdayEnterTimeThisWeek"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}

				else if (curr_variable_name.equals("WorkdayEnterTimeByTypeSearch"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}

				else if (curr_variable_name.equals("WorkdayProjectNameG&AIdleTime"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}

				else if (curr_variable_name.equals("WorkdayCustomer"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}
				else if (curr_variable_name.equals("WorkdayDnbCheckbox"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}
				else if (curr_variable_name.equals("WorkdayWeekdayMonday"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}
				else if (curr_variable_name.equals("WorkdayWeekdayTuesday"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}
				else if (curr_variable_name.equals("WorkdayWeekdayWednesday"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}
				else if (curr_variable_name.equals("WorkdayWeekdayThursday"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}
				else if (curr_variable_name.equals("WorkdayWeekdayFriday"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}
				else if (curr_variable_name.equals("WorkdayTimesheetOkBtn"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}
				else if (curr_variable_name.equals("WorkdayTimesheetReviewBtn"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}

				else if (curr_variable_name.equals("WorkdayTotalProjectHours"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}
				else if (curr_variable_name.equals("WorkdayEnterYourComment"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}

				else if (curr_variable_name.equals("WorkdayFinalSubmitButton"))
				{
					curr_variable_name = hmap_variable_name.get(i);
					curr_variable_value = hmap_variable_value.get(i);
					WORKDAYTIMEENTRY(curr_variable_name ,curr_variable_value);
				}
			}
		}
	}

	
	
	//=========This Function is used get credentials from .properties file=================
		static String FileRead(String url,String user,String pass) {
			File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\ApachePOI\\File\\Environment.properties");

			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			//creating instance of properties file
			Properties prop = new Properties();

			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if("url".equals(url)) 
			{
				return prop.getProperty("url");
			}
			else if("username".equals(user)) 
			{
				return prop.getProperty("username");
			}
			else if("pass".equals(pass)) 
			{
				return prop.getProperty("pass");
			}
			return null;
		}
	
	
	
	

	@SuppressWarnings("deprecation")
	static void LaunchBrowser() {
		
		//It will get url from properties file by calling its method
	  String URL=FileRead("url",null,null); 
		//System property for the msedge driver
	  WebDriverManager.chromedriver().setup();

		//Creating instance of chrome driver
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://wd3.myworkday.com/telusinternational/d/home.htmld");
		driver.manage().window().maximize();
	}

	static void QuitBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	static int CheckForElementExixtence(String objectName,String objectValue) {
		WebElement obv = driver.findElement(By.xpath(objectValue));
		int flag=0;
		if(obv.isDisplayed()) 
		{
			System.out.println(objectName+" is Displayed");
			if(obv.isEnabled())
			{
				System.out.println(objectName+" is Enabled");
				return flag=1;
			}
		}
		else 
		{
			System.out.println("For "+objectName+" Element Do not Exist");	
		}
		return flag;
	}

	public static void ClickButton(String objectValue) {
		driver.findElement(By.xpath(objectValue)).click();
	}

	public static void ClickandEnterData(String objectValue, String data) {
		driver.findElement(By.xpath(objectValue)).click();
		driver.findElement(By.xpath(objectValue)).sendKeys(data);
	}

	public static void ClearandEnterData(String objectValue, String data) {
		driver.findElement(By.xpath(objectValue)).clear();
		driver.findElement(By.xpath(objectValue)).sendKeys(data);
	}

	public static void SendEnter(String objectValue) {
		driver.findElement(By.xpath(objectValue)).sendKeys(Keys.ENTER);	
	}

	public static void SendTab(String objectValue) {
		driver.findElement(By.xpath(objectValue)).sendKeys(Keys.TAB);	
	}

	public static void GetText(String objectValue) {
		String a=driver.findElement(By.xpath(objectValue)).getText();
		System.out.println(a);
	}

	
	//=================== WorkdayLogin Methods====================================
	static void WORKDAYLOGIN(String objectName,String objectValue) 
	{
		
		String user=FileRead(null,"username",null);// it will get username from properties file
		String pass=FileRead(null,null,"pass");// it will get password from properties file

		int flag=0;
		if(objectName.equals("WorkdayUsername"))
		{
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickandEnterData(objectValue,user);
			}		
		}

		else if(objectName.equals("WorkdaySubmitButton1"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickButton(objectValue);
			}
		}

		else if(objectName.equals("WorkdayPassword"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickandEnterData(objectValue,pass);
			}
		}

		else if(objectName.equals("WorkdaySubmitButton"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickButton(objectValue);
			}
		}
	}

	//================= WorkdayTimeEntry Method================================
	
	static void WORKDAYTIMEENTRY(String objectName,String objectValue) throws InterruptedException 
	{
		
		
		int flag=0;
		if(objectName.equals("WorkdayGlobalNavigation"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickButton(objectValue);
			}
		}

		else if(objectName.equals("WorkdayTime"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickButton(objectValue);
			}
		}

		else if(objectName.equals("WorkdayEnterTimeThisWeek"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickButton(objectValue);
			}	
		} 

		else if(objectName.equals("WorkdayEnterTimeByTypeSearch"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickButton(objectValue);
				ClickandEnterData(objectValue,"chr");
				SendEnter(objectValue);
				Thread.sleep(5000);
			}
		} 

		else if(objectName.equals("WorkdayProjectNameG&AIdleTime"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickButton(objectValue);
				Thread.sleep(2000);
			}
		} 

		else if(objectName.equals("WorkdayCustomer"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				GetText(objectValue);
			}
		} 

		else if(objectName.equals("WorkdayDnbCheckbox"))
		{
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickButton(objectValue);
			}
		} 		

		else if(objectName.equals("WorkdayWeekdayMonday"))
		{
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClearandEnterData(objectValue,"8");
				SendTab(objectValue);
			}
		} 

		else if(objectName.equals("WorkdayWeekdayTuesday"))
		{
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClearandEnterData(objectValue,"8");
				SendTab(objectValue);
			}
		} 			 

		else if(objectName.equals("WorkdayWeekdayWednesday"))
		{
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClearandEnterData(objectValue,"8");
				SendTab(objectValue);
			}

		} 

		else if(objectName.equals("WorkdayWeekdayThursday"))
		{
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClearandEnterData(objectValue,"8");
				SendTab(objectValue);
			}
		} 

		else if(objectName.equals("WorkdayWeekdayFriday"))
		{
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClearandEnterData(objectValue,"8");
				SendTab(objectValue);
				QuitBrowser();
			}
		} 
		
		
		else if(objectName.equals("WorkdayTimesheetOkBtn"))
		{
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickButton(objectValue);
				Thread.sleep(2000);
			}
		} 		

		
		
		else if(objectName.equals("WorkdayTimesheetReviewBtn"))
		{
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickButton(objectValue);
				Thread.sleep(2000);
			}
		} 

	/*
		else if(objectName.equals("WorkdayTotalProjectHours"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objectValue)));
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				GetText(objectValue);
				Thread.sleep(2000);
			}
		}
		
		
   
		else if(objectName.equals("WorkdayEnterYourComment"))
		{
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickandEnterData(objectValue,"Done");
				Thread.sleep(2000);
			}

		}
		

		else if(objectName.equals("WorkdayFinalSubmitButton"))
		{
			flag=CheckForElementExixtence(objectName,objectValue);
			if (flag==1) 
			{
				ClickButton(objectValue);
				Thread.sleep(2000);
			}
		}
		*/ 
		
	}
}