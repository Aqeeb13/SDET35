package com.crm.vtiger.contacts;

import static org.testng.Assert.assertEquals;

import java.io.File;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.genericUtilities.Baseclass;
import com.crm.vtiger.genericUtilities.JavaUtility;
import com.crm.vtiger.objectRepository.ContactInfoPage;
import com.crm.vtiger.objectRepository.ContactsPage;
import com.crm.vtiger.objectRepository.CreatingNewContact;
import com.crm.vtiger.objectRepository.HomePage;

//@Listeners(com.crm.vtiger.genericUtilities.ITestListenerImp.class)
public class ContactsTest extends Baseclass{
@Test
public void TocontactsTest() throws Throwable {
	//JavaUtility jLib=new JavaUtility();
	
	String contact=eLib.getExcelFilevalues("Sheet1",1,2);
	
	int randnum = jLib.getRandomNumber();
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
			HomePage hp1=new HomePage(driver);
			hp1.getSavebtn().click();
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			//verify title.......................................;
			
			ContactInfoPage cip=new ContactInfoPage(driver);
			String contacts = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			Assert.assertTrue(contacts.contains("sagar"));
		    	//Reporter.log("contact created",true);
	}
}

