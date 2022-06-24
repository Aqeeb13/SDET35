package com.crm.vtiger.createContact;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.IPathConstant;
import com.crm.objectRepository.ContactInfoPage;
import com.crm.objectRepository.ContactPage;
import com.crm.objectRepository.CreatingNewContactPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrgPopUpWindowPage;
@Listeners(com.crm.comcast.genericutility.ListenerImplementationClass.class)
public class CreateContactsAndVerifyTest extends BaseClass {
	
@Test(groups = "SmokeTest",retryAnalyzer = com.crm.comcast.genericutility.ReTryTestAnalyser.class)
	public void createContactsAndVerifyTest() throws Throwable {
		
		//Fetch data From Excel File
		String FirstName=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"ContactSheet", 1, 2);
		String LastName=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"ContactSheet", 1, 3);
		String Title=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"ContactSheet", 1, 5);
				
		//Generate Random Number
		int RandNum=jLib.getRandomNumber(100);
		
		//Generate Random Name
		String ContactName = FirstName+RandNum;
		
		//Click on Contacts
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContacts();
		
		//Click on Create new Contact
		ContactPage contactPage = new ContactPage(driver);
		contactPage.clickOnCreateContactImg();
		
		//Find FirstName DropDown Locator
		CreatingNewContactPage createNewContact=new CreatingNewContactPage(driver);
		WebElement firstName=createNewContact.getFirstNameTitleTxtEdt();
		//Assert.fail();
		 
		//select all the Option in FirstnameDropdown
		List<WebElement> allOption = wLib.getAllOptionFromDropDown(firstName);
		
		//Write all the Option present in FirstnameDropdown to Excel File
		createNewContact.writeElementsInExcel(allOption,6,1);
		
		//select Mr. From drop down
		String nameTitle = eLib.getDataFromExcelSheet(IPathConstant.excelPath, "ContactSheet", 2, 6);
		wLib.selectDropDown(firstName,nameTitle);
		
		//Enter First name
		createNewContact.enterFirstName(ContactName);
		
		//Enter Last Name
		createNewContact.enterLastName(LastName);
		
		//Click Organisation LookUp Image
		createNewContact.clickOnOrganisationLookUpImg();
		
		
		//Transfer control from one Window to another
		wLib.switchToSpecificWindow(driver,"Accounts&action");
		
		//Enter details on Organisation Popup Window
		OrgPopUpWindowPage orgPopUpWind = new OrgPopUpWindowPage(driver);
		//Enter Organisation name for Search
		orgPopUpWind.enterOrgNameForSearch("SONY");
		//Enter Search now Button
		orgPopUpWind.clickOnSearchNowBtn();
		//Select Searched Organisation
		orgPopUpWind.clickOnSearchedOrg();
		
	
		//Transfer control from one Window to another
		wLib.switchToSpecificWindow(driver,"Contacts&action");
		
		//Enter Title
		createNewContact.enterTitle(Title);
		
		//Click on GroupRadioButton
		createNewContact.clickOnGroupRadioButton();
		
		//select marketing Group from DropDown
		WebElement assignedTo=createNewContact.getAssignedToDropDown();
		
		//Write all the option from assignedTo dropdown to Excel File
		List<WebElement> allOptionOfAss = wLib.getAllOptionFromDropDown(assignedTo);
		createNewContact.writeElementsInExcel(allOptionOfAss,8,1);
		
		//select marketing Group from DropDown
	    String AssTitle = eLib.getDataFromExcelSheet(IPathConstant.excelPath, "ContactSheet", 1, 8);
		wLib.selectDropDownByVText(assignedTo,AssTitle);
		
	    //Click on Save Button
		createNewContact.clickOnSaveButton();
		
		//Check Contact is Created or not
		ContactInfoPage contactInfo = new ContactInfoPage(driver);		
		String Contact =contactInfo.checkContactIsCreatedOrNot();
		SoftAssert Assert = new SoftAssert();
		Assert.assertTrue(Contact.contains(ContactName));
		Reporter.log("createContactsAndVerifyTest is pass",true);
		Assert.assertAll();
	}

}
