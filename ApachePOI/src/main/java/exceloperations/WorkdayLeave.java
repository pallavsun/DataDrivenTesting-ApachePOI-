package exceloperations;

import java.security.Key;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkdayLeave {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {



		String flag1="Yes";

		String	Day1="Monday";
		String	Day2="Tuesday";
		String	Day3="Wednesday";
		String	Day4="Thursday";
		String	Day5="Friday";

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);



		driver.get("https://wd3.myworkday.com/telusinternational/d/home.htmld");
		driver.manage().window().maximize();




		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("pallav.kumar");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Vinodprakash@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();




		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-automation-id='pex-view-all-apps']"))).click();



		driver.findElement(By.xpath("//*[text()='Time']")).click();
		driver.findElement(By.xpath("//button/span[contains(text(),'This Week')]")).click();



		WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(50));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Search\" and  @data-uxi-multiselect-id=\"56$525975\"]"))).click();

		WebDriverWait wait3= new WebDriverWait(driver, Duration.ofSeconds(50));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Search\" and  @data-uxi-multiselect-id=\"56$525975\"]"))).sendKeys("ch");


		WebDriverWait wait4= new WebDriverWait(driver, Duration.ofSeconds(50));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Search\" and  @data-uxi-multiselect-id=\"56$525975\"]"))).sendKeys(Keys.ENTER);



		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'GENERAL AND ADMINISTRATIVE (G&A) > Breaks')])]"))).click();


		//WebElement obj=driver.findElement(By.xpath("//div[contains(text(),'GENERAL AND ADMINISTRATIVE (G&A) > Breaks')]"));
		WebElement ele= driver.findElement(By.xpath("//div[contains(text(),'GENERAL AND ADMINISTRATIVE (G&A) > Breaks')]"));
		
		
				
		
		driver.findElement(By.xpath("//div[@class='WPKF']")).click();

		if(flag1.equalsIgnoreCase("Yes"))
		{	  


			if(Day1.equalsIgnoreCase("Monday"))
			{
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@aria-label='row'][1]/td[7]/div/div/input")).clear();
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@aria-label='row'][1]/td[7]/div/div/input")).sendKeys("8");


			}

		}

		if(flag1.equalsIgnoreCase("Yes"))
		{

			if(Day2.equalsIgnoreCase("Tuesday"))
			{
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@aria-label='row'][1]/td[8]/div/div/input")).clear(); 
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@aria-label='row'][1]/td[8]/div/div/input")).sendKeys("8"); 
			}

		}



		if(flag1.equalsIgnoreCase("No"))
		{

			if(Day3.equalsIgnoreCase("Wednesday"))
			{
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@aria-label='row'][1]/td[9]/div/div/input")).clear();
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@aria-label='row'][1]/td[9]/div/div/input")).sendKeys("8");

			}

		}


		if(flag1.equalsIgnoreCase("Yes"))

			if(Day4.equalsIgnoreCase("Thursday"))
			{

				{
					driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@aria-label='row'][1]/td[10]/div/div/input")).clear();
					driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@aria-label='row'][1]/td[10]/div/div/input")).sendKeys("8");

				}

			}


		if(flag1.equalsIgnoreCase("Yes"))
		{

			if(Day5.equalsIgnoreCase("Friday"))	 

			{
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@aria-label='row'][1]/td[11]/div/div/input")).clear();
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@aria-label='row'][1]/td[11]/div/div/input")).sendKeys("8");

			}

		}



		//============================================================================================

/*
		WebDriverWait wait6= new WebDriverWait(driver, Duration.ofSeconds(50));
		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Add Row']//div[@role='presentation']//*[name()='svg']"))).click();


		WebDriverWait wait7= new WebDriverWait(driver, Duration.ofSeconds(50));
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Search\" and  @data-uxi-multiselect-id=\"56$525975\" and  @class=\"css-130uqpl-InputContainer edt0qdt22\"]"))).click();

		WebDriverWait wait8= new WebDriverWait(driver, Duration.ofSeconds(50));
		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Search\" and  @data-uxi-multiselect-id=\"56$525975\" and   @data-automation-id=\"searchBox\"]"))).sendKeys("ch");


		WebDriverWait wait9= new WebDriverWait(driver, Duration.ofSeconds(50));
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Search\" and  @data-uxi-multiselect-id=\"56$525975\" and    @data-automation-id=\"searchBox\"]"))).sendKeys(Keys.ENTER);


		WebDriverWait wait10= new WebDriverWait(driver, Duration.ofSeconds(60));
		wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'GENERAL AND ADMINISTRATIVE (G&A) > Leave')]"))).click();


//			====================== Do Not Bill====================
	      	WebDriverWait wait66 = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait66.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='mainTable']/tbody//tr[@tabindex=\"0\"][1]/td[5]/div/div/div/input"))).click();




		if(flag1.equalsIgnoreCase("No"))
		{	  


			if(Day1.equalsIgnoreCase("Monday"))
			{
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@tabindex=\"0\"][1]/td[7]/div/div/input")).clear();
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@tabindex=\"0\"][1]/td[7]/div/div/input")).sendKeys("8");

			}

		}

		if(flag1.equalsIgnoreCase("No"))
		{

			if(Day2.equalsIgnoreCase("Tuesday"))
			{
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@tabindex=\"0\"][1]/td[8]/div/div/input")).clear();
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@tabindex=\"0\"][1]/td[8]/div/div/input")).sendKeys("8");
			}

		}



		if(flag1.equalsIgnoreCase("Yes"))
		{

			if(Day3.equalsIgnoreCase("Wednesday"))
			{


				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@tabindex=\"0\"][1]/td[9]/div/div/input")).clear();
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@tabindex=\"0\"][1]/td[9]/div/div/input")).sendKeys("8");

			}

		}




		if(flag1.equalsIgnoreCase("No"))

			if(Day4.equalsIgnoreCase("Thursday"))
			{

				{
					driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@tabindex=\"0\"][1]/td[10]/div/div/input")).clear();
					driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@tabindex=\"0\"][1]/td[10]/div/div/input")).sendKeys("8");

				}

			}


		if(flag1.equalsIgnoreCase("No"))
		{

			if(Day5.equalsIgnoreCase("Friday"))	 

			{
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@tabindex=\"0\"][1]/td[11]/div/div/input")).clear();
				driver.findElement(By.xpath("//table[@class='mainTable']/tbody//tr[@tabindex=\"0\"][1]/td[11]/div/div/input")).sendKeys("8");

			}

		}





*/

	}



}




