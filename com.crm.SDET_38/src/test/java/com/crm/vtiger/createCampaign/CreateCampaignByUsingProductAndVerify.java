package com.crm.vtiger.createCampaign;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignByUsingProductAndVerify {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		
		//Creating object of JavaUtility Class
		JavaUtility jLib = new JavaUtility();
		
		//Creating object of ExcelUtility Class
		ExcelUtility eLib = new ExcelUtility();
		
		//Creating object of FileUtility Class
		FileUtility fLib = new FileUtility();
		
		//Creating object of WebDriverUtility Class
		WebDriverUtility wLib = new WebDriverUtility();
		
		
		//Fetch data from Property File
		String URL=fLib.getPropertyKeyValue("./src\\test\\resources\\Data.properties", "url");
		String UN=fLib.getPropertyKeyValue("./src\\test\\resources\\Data.properties", "un");
		String PWD=fLib.getPropertyKeyValue("./src\\test\\resources\\Data.properties", "pwd");;
		String BROWSER=fLib.getPropertyKeyValue("./src\\test\\resources\\Data.properties", "browser");
		
		
		//Fetch data From ExcelFile
		String Campaign=eLib.getDataFromExcelSheet("./src\\test\\resources\\TestData.xlsx","CampaignSheet",1,2);
		
		//generate Random Number
		int RandNum=jLib.getRandomNumber(100);
		
		//Generate Random Name
		String CampaignName = Campaign+RandNum;
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		//Synchronization by using implicity wait
		wLib.waitForPageToLoad(driver, 10);
		
		//Page Maximize
		driver.manage().window().maximize();
		//Enter URL
		driver.get(URL);
		//Enter User Name
		driver.findElement(By.name("user_name")).sendKeys(UN);
		//Enter PassWord
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		//Click on Login Button
		driver.findElement(By.id("submitButton")).click();
		
		//Select More Option
		WebElement element = driver.findElement(By.xpath("//a[text()='More']"));
		wLib.mouseOverAnElement(driver,element);
		
		//Click Campaign
		driver.findElement(By.name("Campaigns")).click();
		//Create new Campaign
		driver.findElement(By.xpath("//img[@title=\"Create Campaign...\"]")).click();
		//Write Campaign name
		driver.findElement(By.name("campaignname")).sendKeys(CampaignName);
		driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		
		//Select marketing group in dropdown menu
		WebElement AssignedTo = driver.findElement(By.name("assigned_group_id"));
		wLib.selectDropDownByVText(AssignedTo,"Marketing Group");
		
		//Select Advertisement in dropdown menu
		WebElement CampaignType = driver.findElement(By.name("campaigntype"));
		wLib.selectDropDown(CampaignType, "Advertisement");
		
		//Enter Target Audience
		driver.findElement(By.id("targetaudience")).sendKeys("2000");
		//Enter Numsent
		driver.findElement(By.id("numsent")).sendKeys("70");
		
		//Select Active in dropdown menu
		WebElement CampaignStatus = driver.findElement(By.name("campaignstatus"));
		wLib.selectDropDown(CampaignStatus, "Active");
	
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		
		//Transfer control from one window to another
		wLib.switchToSpecificWindow(driver,"Products&action" );
		
		driver.findElement(By.id("search_txt")).sendKeys("Iphone");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.id("1")).click();
		wLib.switchToSpecificWindow(driver,"Campaigns&action" );
		
		driver.findElement(By.name("closingdate")).clear();
		driver.findElement(By.name("closingdate")).sendKeys("2022-07-20");
		driver.findElement(By.id("targetsize")).sendKeys("1000");
		driver.findElement(By.name("button")).click();
		//Check Campaign is created or not
		String CreatedCampaignName = driver.findElement(By.xpath("//span[contains(text(),'Campaign Information')]")).getText();
		if(CreatedCampaignName.contains(CampaignName)) {
			System.out.println("Campaign is Created");
		}
		else {
			System.out.println("Campaign is not Created");
		}
		//Click on Logout Link
		WebElement element1 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		wLib.mouseOverAnElement(driver,element1);
		
		Thread.sleep(4000);
		//Close Driver
        driver.close();

	}

}
