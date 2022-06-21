package com.crm.vtiger.createOrganisation;



import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.IPathConstant;
import com.crm.objectRepository.CreatingNewOrganisationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.OrgPopUpWindowPage;
import com.crm.objectRepository.OrganisationInfoPage;
import com.crm.objectRepository.OrganisationPage;
@Listeners(com.crm.comcast.genericutility.ListenerImplementationClass.class)
public class CreateOrganisationByUsingMemberOfAndVerifyTest extends BaseClass {

	@Test(groups = "RegressionTest",retryAnalyzer = com.crm.comcast.genericutility.ReTryTestAnalyser.class)
	public void createOrganisationByUsingMemberOfAndVerifyTest() throws Throwable {
		
		//Fetch data from Excel file
		String Organisation=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"OrganisationSheet", 11, 2);
				
		//Generate Random Number
		int RandNum=jLib.getRandomNumber(100);
		
		//Generate Random Name
		String OrganisationName = Organisation+RandNum;
				
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
		
		//Click On MemberOf LookUp Img
		creatingNewOrganisation.clickOnMemberOfLkUpImg();
		
		//Transfer control from one window to another
		wLib.switchToSpecificWindow(driver,"Popup&popuptype");
		
		//Enter details on Organisation Popup Window
		OrgPopUpWindowPage orgPopUpWind = new OrgPopUpWindowPage(driver);
		//Enter Organisation name for Search
		orgPopUpWind.enterOrgNameForSearch("SONY");
		//Enter Search now Button
		orgPopUpWind.clickOnSearchNowBtn();
		//Select Searched Organisation
		Thread.sleep(2000);
		orgPopUpWind.clickOnSearchedOrg();
				
		
		
		
		//Handle Alert PopUp
		wLib.switchToAlertPopUpAndDismiss(driver);
		
		//Transfer control from one window to another
		wLib.switchToSpecificWindow(driver,"Accounts&action");
		
		
		//Retrive the Locator Of IndustryDromDown
		WebElement industry=creatingNewOrganisation.getIndustryDropDown();
		
		//Write all the option from Industry dropdown to Excel File
		List<WebElement> allOptionOfIndustry = wLib.getAllOptionFromDropDown(industry);
		creatingNewOrganisation.writeElementsInExcel(allOptionOfIndustry,5,11);
				
		//select Electronics from DropDown
		 String IndustryType = eLib.getDataFromExcelSheet(IPathConstant.excelPath, "OrganisationSheet", 20, 5);
		 wLib.selectDropDownByVText(industry,IndustryType);
		 
		//Retrive the Locator Of  TypeDromDown
		WebElement type = creatingNewOrganisation.getTypeDropDown();
			
		//Write all the option from Type dropdown to Excel File
		List<WebElement> allOptionOfType = wLib.getAllOptionFromDropDown(type);
		creatingNewOrganisation.writeElementsInExcel(allOptionOfType,6,11);
					
		//select Partner  from Type DropDown
		 String accountType = eLib.getDataFromExcelSheet(IPathConstant.excelPath, "OrganisationSheet", 17, 6);
		 wLib.selectDropDown(type,accountType);
		 
		//Retrive the Locator Of  RatingDromDown
		WebElement rating = creatingNewOrganisation.getRatingDropDown();
				
		//Write all the option from Rating dropdown to Excel File
		List<WebElement> allOptionOfRating = wLib.getAllOptionFromDropDown(rating);
		creatingNewOrganisation.writeElementsInExcel(allOptionOfRating,7,11);
						
		//select Active  from Rating DropDown
		 String ratingType = eLib.getDataFromExcelSheet(IPathConstant.excelPath, "OrganisationSheet", 13, 7);
		wLib.selectDropDown(rating,ratingType);
		 
		 
		//Click On Group Radio Button
		creatingNewOrganisation.clickOnGroupRadioButton();
				
		//Retrive the Locator Of AssignedTo DropDown
		WebElement assignedTo=creatingNewOrganisation.getAssignedToDropDown();
						
		//Write all the option from assignedTo dropdown to Excel File
		List<WebElement> allOptionOfAss = wLib.getAllOptionFromDropDown(assignedTo);
		creatingNewOrganisation.writeElementsInExcel(allOptionOfAss,4,11);
						
		//select eam Selling  from AssignedTo DropDown
		 String AssTitle = eLib.getDataFromExcelSheet(IPathConstant.excelPath, "OrganisationSheet", 13, 4);
		 wLib.selectDropDownByVText(assignedTo,AssTitle);
		 
		//Enter Billing Address
		 creatingNewOrganisation.enterBillingAddress("KATRIGUPPE");
		//Enter Billing City
		 creatingNewOrganisation.enterBillingCity("BANGALORE");
		//Enter Billing State
		 creatingNewOrganisation.enterBillingState("KARNATAK");
		//Enter Billing Code
		 creatingNewOrganisation.enterBillingCode("60085");
		//Enter Billing Country
		 creatingNewOrganisation.enterBillingCountry("INDIA");
		 
		 //Click On CopyBillAdsRadioBtn
		 creatingNewOrganisation.clickOnCopyBillAdsRadioBtn();
		 
		//Click on save Button
		 creatingNewOrganisation.clickOnSaveBtn();
		 
		//Check Contact is Created or not
		 OrganisationInfoPage OrgInfo = new OrganisationInfoPage(driver);		
		String Orgnstn =OrgInfo.checkOrganisationIsCreatedOrNot(OrganisationName);
		System.out.println(Orgnstn);
		
         
	}

}
