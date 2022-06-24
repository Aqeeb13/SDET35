package com.crm.vtiger.createContact;

import java.io.File;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.IPathConstant;
import com.crm.objectRepository.ContactInfoPage;
import com.crm.objectRepository.ContactPage;
import com.crm.objectRepository.ContactPopUpWindowPage;
import com.crm.objectRepository.CreatingNewContactPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrgPopUpWindowPage;

@Listeners(com.crm.comcast.genericutility.ListenerImplementationClass.class)
public class CreateContactsByUsingReportsToAndVerifyTest extends BaseClass {
	
   @Test(groups = "RegressionTest",retryAnalyzer = com.crm.comcast.genericutility.ReTryTestAnalyser.class)
	public void createContactsByUsingReportsToAndVerifyTest() throws Throwable {
		
		
		//Fetch data from Excel File
		String FirstName=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"ContactSheet", 9, 2);
		String LastName=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"ContactSheet", 9, 3);
		String Title=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"ContactSheet", 9, 5);
		//Generate Random Name
		int RandNum=jLib.getRandomNumber(100);
		
		//Generate Random Name
		String ContactName = FirstName+RandNum;
		
		
		//Click on Contact
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContacts();
		
		//Click on Create Contact
		ContactPage contactPage = new ContactPage(driver);
		contactPage.clickOnCreateContactImg();
		
		//Find FirstName DropDown Locator
		CreatingNewContactPage createNewContact=new CreatingNewContactPage(driver);
		WebElement firstName=createNewContact.getFirstNameTitleTxtEdt();
		
		//select all the Option in FirstnameDropdown
		List<WebElement> allOption = wLib.getAllOptionFromDropDown(firstName);
		
		//Write all the Option present in FirstnameDropdown to Excel File
		createNewContact.writeElementsInExcel(allOption,6,9);
		
		//select Mr. From drop down
		String nameTitle = eLib.getDataFromExcelSheet(IPathConstant.excelPath, "ContactSheet", 2, 6);
		wLib.selectDropDown(firstName,nameTitle);
		
		//Enter First name
		createNewContact.enterFirstName(ContactName);
				
		//Enter Last Name
		createNewContact.enterLastName(LastName);
		
		//Click Organisation LookUp Image
		createNewContact.clickOnOrganisationLookUpImg();
		
		//transfer control from one window to another
		wLib.switchToSpecificWindow(driver,"Accounts&action");
		
		//Enter details on Organisation Popup Window
		OrgPopUpWindowPage orgPopUpWind = new OrgPopUpWindowPage(driver);
		//Enter Organisation name for Search
		orgPopUpWind.enterOrgNameForSearch("SAMSUNG");
		//Enter Search now Button
		orgPopUpWind.clickOnSearchNowBtn();
		//Select Searched Organisation
		Thread.sleep(2000);
		orgPopUpWind.clickOnSearchedOrg();
		
		
		//transfer control from one window to another
		wLib.switchToSpecificWindow(driver,"Contacts&action");
		
		//Find LeadSource DropDown Locator
		WebElement leadSource=createNewContact.getLeadSourceDropDown();
		
		//select all the Option in LeadSourceDropdown
		List<WebElement> allOption1 = wLib.getAllOptionFromDropDown(leadSource);
				
		//Write all the Option present in LeadDropdown to Excel File
		createNewContact.writeElementsInExcel(allOption1,7,9);
		
		//Select Public Relation from DropDown
		 String leadSourceName = eLib.getDataFromExcelSheet(IPathConstant.excelPath, "ContactSheet", 15,7);
		wLib.selectDropDown(leadSource,leadSourceName);
		
		//Enter Title
		 createNewContact.enterTitle(Title);
		 
		//Enter DOB
		 createNewContact.enterDOB("1994-02-16");
		 
		 //Click on ReportTo LookUp Image
		 createNewContact.clickOnReportToLookUpImg();
		
		//transfer control from one window to another
		wLib.switchToSpecificWindow(driver,"Contacts&action=Popup&html");
		
		//Fill the details on Contact PopUp Window
		ContactPopUpWindowPage contactPopUpWind = new ContactPopUpWindowPage(driver);
		//Enter Last Name Of Searched Contact
		contactPopUpWind.enterOrgNameForSearch("Nayak");
		//Click On Search Now Buttom
		contactPopUpWind.clickOnSearchNowBtn();
		//Clicked On Searched Option
		contactPopUpWind.clickOnSearchedOrg();
		
		//transfer control from one window to another
		wLib.switchToSpecificWindow(driver,"Contacts&action=EditView&return_action");
		
		//Click on GroupRadioButton
		createNewContact.clickOnGroupRadioButton();		
		//select marketing Group from DropDown
		WebElement assignedTo=createNewContact.getAssignedToDropDown();
				
		//Write all the option from assignedTo dropdown to Excel File
		List<WebElement> allOptionOfAss = wLib.getAllOptionFromDropDown(assignedTo);
		createNewContact.writeElementsInExcel(allOptionOfAss,8,9);
				
		//select marketing Group from DropDown
		 String AssTitle = eLib.getDataFromExcelSheet(IPathConstant.excelPath, "ContactSheet", 9, 8);
		wLib.selectDropDownByVText(assignedTo,AssTitle);
		
		//Upload the File
		File f=new File("./src\\test\\resources\\TestFile.jpg");
		String path = f.getAbsolutePath();
		createNewContact.fileUploadInContactImg(path);
		
		//Click on Save Button
		createNewContact.clickOnSaveButton();
		
		//Check Contact is Created or not
		ContactInfoPage contactInfo = new ContactInfoPage(driver);		
		String Contact =contactInfo.checkContactIsCreatedOrNot();
		SoftAssert Assert = new SoftAssert();
		Assert.assertTrue(Contact.contains(ContactName));
		System.out.println("createContactsAndVerifyTest is pass");
		Assert.assertAll();
				
	}

}
