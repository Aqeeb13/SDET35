package com.crm.vtiger.contacts;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.vtiger.genericUtilities.ExcelUtility;
import com.crm.vtiger.genericUtilities.IPathConstant;
import com.crm.vtiger.genericUtilities.JavaUtility;
import com.crm.vtiger.genericUtilities.PropertyUtility;
import com.crm.vtiger.genericUtilities.WebDriverUtility;
import com.crm.vtiger.objectRepository.ContactInfoPage;
import com.crm.vtiger.objectRepository.ContactsPage;
import com.crm.vtiger.objectRepository.CreatingNewContact;
import com.crm.vtiger.objectRepository.HomePage;
import com.crm.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;




public class ContactTest {

	public static void main(String[] args) throws Throwable {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//WebDriver driver=null;
		//Create object for java utility...........
				JavaUtility jLib=new JavaUtility();
				//Create object for excel utility......
				ExcelUtility eLib=new ExcelUtility();
				//create object for property file........
				PropertyUtility pLib=new PropertyUtility();
				//Create object for Driver utility...................
				WebDriverUtility wLib=new WebDriverUtility();
		
		//Fetching data from property file..........
		 String URL = pLib.getPropertyFileValues(IPathConstant.file1Path,"url");
		    String USERNAME = pLib.getPropertyFileValues(IPathConstant.file1Path,"username");
		    String PASSWORD = pLib.getPropertyFileValues(IPathConstant.file1Path,"password");
		    String BROWSER = pLib.getPropertyFileValues(IPathConstant.file1Path,"browser");
		
		//random number generation........
		int randnum = jLib.getRandomNumber();
		
		if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();			
		}
		else {
			driver=new ChromeDriver();
		}
		
		
		//Fetching data from excel file
		String contact=eLib.getExcelFilevalues("Sheet1",1,2);
		
		//Enter Url.........
		driver.get(URL);
		//wait for page timeout......................
		wLib.waitToPageToLoad(driver);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//maximize the window........................
		driver.manage().window().maximize();
		//Enter user name and password............
		LoginPage l=new LoginPage(driver);
		l.logininto(USERNAME, PASSWORD);
		//Click on contact link.....................
		HomePage hp=new HomePage(driver);
		hp.getContactslnk().click();
		//Click on create new contact look up image................
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCtslkpImg();
		//Enter last name.........................
		CreatingNewContact cn=new CreatingNewContact(driver);
		cn.EnterLastName(contact+randnum);
		//Select First name....................
		WebElement  Firstname= driver.findElement(By.name("salutationtype"));
		wLib.selectDropDownVisibletext(Firstname,"Mr.");
		//Click on add and search for Test yantra Pvt Ltd and click.......... 
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		wLib.switchTowindow(driver,"Accounts&action");
			driver.findElement(By.name("search_text")).sendKeys("Test yantra Pvt Ltd");
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text()='Test yantra Pvt Ltd']")).click();
			wLib.switchTowindow(driver,"Contacts&action");
			//Select Direct Mail................
			WebElement marketing1 = driver.findElement(By.name("leadsource"));
			wLib.selectDropDownVisibletext(marketing1,"Direct Mail");
			//Enter hello in the title text box.......... 
			driver.findElement(By.id("title")).sendKeys("hello");
			File f=new File("./src/test/resources/intel.png");
			String path = f.getAbsolutePath();		
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(path);
			//save contacts..............................
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			//verify title.......................................;
			ContactInfoPage cip=new ContactInfoPage(driver);
			String contacts = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		    if(contacts.contains("Sagar")){
		    	System.out.println("contact created");
		    }
		    else
		    {
		    	System.out.println("contact not created");
		    }
		    //close the browser.....................................
		    driver.close();

	}

}
