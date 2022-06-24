package com.crm.vtiger.createOrganisation;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.IPathConstant;
import com.crm.objectRepository.CreatingNewOrganisationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrganisationInfoPage;
import com.crm.objectRepository.OrganisationPage;
@Listeners(com.crm.comcast.genericutility.ListenerImplementationClass.class)
public class CreateOrganisationAndVerifyTest extends BaseClass {

	@Test(groups = "SmokeTest",retryAnalyzer = com.crm.comcast.genericutility.ReTryTestAnalyser.class)
	public void createOrganisationAndVerifyTest() throws Throwable {
		
		
		//fetching data from Excel File
		String Organisation=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"OrganisationSheet", 1, 2);
				
		//Generate Random Number
		int RandNum=jLib.getRandomNumber(100);
		
		//Generate Random Name
		String OrganisationName = Organisation+RandNum;
		System.out.println(OrganisationName);
		
		//Click on Organisation
		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrganisation();
		
		//Click on Create Organisation
		OrganisationPage organisation = new OrganisationPage(driver);
		organisation.clickOnCreateOrganisationLkUpImg();
		
		//Enter Organisation Name
		CreatingNewOrganisationPage creatingNewOrganisation = new CreatingNewOrganisationPage(driver);
		creatingNewOrganisation.enterOrgName(OrganisationName);
		
		//Enter Website
		creatingNewOrganisation.enterOrgWebsite("www.SONY.com");
		
		//Click On Group Radio Button
		creatingNewOrganisation.clickOnGroupRadioButton();
		
		//select marketing Group from DropDown
		WebElement assignedTo=creatingNewOrganisation.getAssignedToDropDown();
				
		//Write all the option from assignedTo dropdown to Excel File
		List<WebElement> allOptionOfAss = wLib.getAllOptionFromDropDown(assignedTo);
		creatingNewOrganisation.writeElementsInExcel(allOptionOfAss,4,1);
				
		//select marketing Group from DropDown
		 String AssTitle = eLib.getDataFromExcelSheet(IPathConstant.excelPath, "OrganisationSheet", 3, 4);
		 wLib.selectDropDownByVText(assignedTo,AssTitle);
		 
		//Enter Billing Address
		 creatingNewOrganisation.enterBillingAddress("BTM 2ND STAGE");
		//Enter Billing City
		 creatingNewOrganisation.enterBillingCity("BANGALORE");
		//Enter Billing State
		 creatingNewOrganisation.enterBillingState("KARNATAK");
		//Enter Billing Code
		 creatingNewOrganisation.enterBillingCode("560076");
		//Enter Billing Country
		 creatingNewOrganisation.enterBillingCountry("INDIA");
		 
		 //Click On CopyBillAdsRadioBtn
		 creatingNewOrganisation.clickOnCopyBillAdsRadioBtn();
		
		//Click on save Button
		 creatingNewOrganisation.clickOnSaveBtn();
		 
	 
		//Check Organization is Created or not
		 OrganisationInfoPage OrgInfo = new OrganisationInfoPage(driver);		
		String Orgnstn =OrgInfo.checkOrganisationIsCreatedOrNot(OrganisationName);
		System.out.println(Orgnstn);
	
	}

}
