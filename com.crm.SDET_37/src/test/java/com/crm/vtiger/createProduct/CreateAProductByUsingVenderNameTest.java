package com.crm.vtiger.createProduct;






import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.IPathConstant;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.objectRepository.CreateNewVenderPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.VenderPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAProductByUsingVenderNameTest {

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
		 String URL=fLib.getPropertyKeyValue(IPathConstant.filePath, "url");
		 String UN=fLib.getPropertyKeyValue(IPathConstant.filePath, "un");
		 String PWD=fLib.getPropertyKeyValue(IPathConstant.filePath, "pwd");;
		 String BROWSER=fLib.getPropertyKeyValue(IPathConstant.filePath, "browser");
		
		//Fetch data from Excel file
		String product=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"ProductSheet", 1, 2);
				
		//Create Random Number
		int RandNum=jLib.getRandomNumber(100);
		
		//Create Random Product Name
		String productName = product+RandNum;
		
		//Select Browser
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
		
		//Synchronization using implicity wait
		wLib.waitForPageToLoad(driver, 10);
		
		//Page Maximize
		driver.manage().window().maximize();
		//Enter Url
		driver.get(URL);
		
		//Enter UserName,password and click on login button
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToVtiger(UN, PWD);
		
		//Select on More Option
		HomePage homePage = new HomePage(driver);
		 WebElement moreOption = homePage.getMoreLink();
		 wLib.mouseOverAnElement(driver, moreOption);
				
		//Click on Vender
		 homePage.clickOnVenderLink();
		
		//Click on Create new Vender
		 VenderPage vender = new VenderPage(driver);
		 vender.clickOnCreateVenderLkUpImg();
		 
		//Enter Vender Name
		 CreateNewVenderPage createNewVender = new CreateNewVenderPage(driver);
		 createNewVender.enterVenderName("TestYantra");
		 
		//Enter save Button
		 createNewVender.clickOnSaveBtn();
		/*
		
		
		//Verify Vender 
		String vender1 = driver.findElement(By.xpath("//span[text()='TestYantra -  Vendor Information']")).getText();
		if(vender1.contains("TestYantra")) {
			System.out.println("Vender is Created");
		}
		else {
			System.out.println("Vender is not Created");
		}
		//Click on Product
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		//Click on Create new Product
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//Enter product Name
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		
		//Switch control from one window to another
		wLib.switchToSpecificWindow(driver,"Vendors&action");
		
		driver.findElement(By.id("search_txt")).sendKeys("TestYantra");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='TestYantra']")).click();
		
		//Switch control from one window to another
		 wLib.switchToSpecificWindow(driver,"Products&action");
		
		driver.findElement(By.name("button")).click();
		String PTitle = driver.findElement(By.xpath("//span[contains(text(),' Product Information')]")).getText();
		//Verify Product
		if(PTitle.contains(productName)) {
			System.out.println("Product is Created");
		}
		else {
			System.out.println("Product is not Created");
		}
		//Click on SignOut Link
		 WebElement element = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		 wLib.mouseOverAnElement(driver, element);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(4000);
		//Close Driver
       driver.close();*/
	}

}
