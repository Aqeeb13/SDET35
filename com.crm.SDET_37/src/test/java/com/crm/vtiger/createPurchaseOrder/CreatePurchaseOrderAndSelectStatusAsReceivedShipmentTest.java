package com.crm.vtiger.createPurchaseOrder;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.IPathConstant;
import com.crm.objectRepository.CreatingNewPurchaseOrderPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.ProductRelatToVenderPopUpWindow;
import com.crm.objectRepository.PurchaseOrderPage;
import com.crm.objectRepository.VenderPopUpWindowPage;

public class CreatePurchaseOrderAndSelectStatusAsReceivedShipmentTest extends BaseClass {

	@Test
	public void createPurchaseOrderAndSelectStatusAsReceivedShipmentTest() throws Throwable {
		
		//Fetch data from Excel file
		String Subject=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"PurchaseOrderSheet",1, 2);
		String TrackingNumber=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"PurchaseOrderSheet",1, 3);
		String DueDate=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"PurchaseOrderSheet",1, 4);
		String SalesCommision=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"PurchaseOrderSheet",1, 5);
		String RequisitionNo=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"PurchaseOrderSheet",1, 6);
		String BillingAddress=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"PurchaseOrderSheet",1, 7);
		String BillingCity=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"PurchaseOrderSheet",1, 8);
		String BillingState=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"PurchaseOrderSheet",1, 9);
		String BillingPostalCode=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"PurchaseOrderSheet",1, 10);
		String BillingCountry=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"PurchaseOrderSheet",1, 11);
		String Quantity=eLib.getDataFromExcelSheet(IPathConstant.excelPath,"PurchaseOrderSheet",1, 12);
		//Create Random Number
		int RandNum=jLib.getRandomNumber(500);
		
		//Create Random Product Name
		String SubjectName = Subject+RandNum;
				
		//Take Home Page ScreenShot
		wLib.takeScreenShot(driver,"HomeScreenTC4");
		
		//Verify Home Page is Displayed Or Not
		HomePage homePage = new HomePage(driver);
		String homePageStatus = homePage.checkHomePageIsDisplayOrNot();
		System.out.println(homePageStatus);
				
		//Select on More Option
		 WebElement moreOption = homePage.getMoreLink();
		 wLib.mouseOverAnElement(driver, moreOption);
		 
		//click on Purchase order
		 homePage.clickOnpurchaseOrder(driver);
		 
		//click on Create Purchase order
		 PurchaseOrderPage purchaseOrder = new PurchaseOrderPage(driver);
		 purchaseOrder.clickOnCreatePurchaseOrdLkUpImg();
		  
		//Enter Product
		 CreatingNewPurchaseOrderPage NewPurchaseOrd = new CreatingNewPurchaseOrderPage(driver);
		 NewPurchaseOrd.enterOnsubjectTxtEdt(SubjectName);
		 
		 //Click On VenderName LookUp Img
		 NewPurchaseOrd.clickOnVenderNameLkUpImg();
		 
		//switch control from one window to another
		 wLib.switchToSpecificWindow(driver,"Vendors&action");
		 
		 
		//enter TestYantra in Search Box
		 VenderPopUpWindowPage venderPopUpWindow = new VenderPopUpWindowPage(driver);
		 venderPopUpWindow.enterVenderNameForSearch("TestYantra");
		 
		//Click on Search Button
		 venderPopUpWindow.clickOnSearchNowBtn();
		 //Click on Searched Vender
		 venderPopUpWindow.clickOnSearchedVender();
		 
		//switch control from one window to another
		 wLib.switchToSpecificWindow(driver,"PurchaseOrder&action");
		  
		//Enter Tracking Number
		 NewPurchaseOrd.enterOnTrackingNoTxtEdt(TrackingNumber);
		 
		//Enter Due Date
		 NewPurchaseOrd.enterOndueDateCalenderTxt(DueDate);
		 
		//Enter Sales Commission
		 NewPurchaseOrd.enterOnsalesCommTxtEdt(SalesCommision);
		 
		 
		//Retrive the Locator Of Status DromDown
		WebElement status=NewPurchaseOrd.getStatusDropDown();
			
		//Write all the option from Industry dropdown to Excel File
		List<WebElement> allOptionOfIndustry = wLib.getAllOptionFromDropDown(status);
		NewPurchaseOrd.writeElementsInExcel(allOptionOfIndustry,13,1);
					
		//select Received Shipment from DropDown
	     String statusType = eLib.getDataFromExcelSheet(IPathConstant.excelPath, "PurchaseOrderSheet", 5, 13);
		 wLib.selectDropDownByVText(status,statusType);
		 
		//Take Purchase Page ScreenShot
		 wLib.takeScreenShot(driver,statusType);
		 
		//Verify Received Shipment Status is Displayed or notReceived Shipment
		 String selectElement=NewPurchaseOrd.checkStatusIsDisplayedOrNot(statusType);
		  System.out.println(selectElement);
		
		//Enter Requisition_no
		  NewPurchaseOrd.enterOnrequisitionNoTxtEdt(RequisitionNo);
		  
		//Click on User Radio Button
		  NewPurchaseOrd.clickOnuserRadioBtn();
		  
		//Enter Billing Address
		  NewPurchaseOrd.enterBillingAddress(BillingAddress);
		//Enter Billing City
		 NewPurchaseOrd.enterBillingCity(BillingCity);
		//Enter Billing State
		 NewPurchaseOrd.enterBillingState(BillingState);
		//Enter Billing Code
		 NewPurchaseOrd.enterBillingCode(BillingPostalCode);
	     //Enter Billing Country
		 NewPurchaseOrd.enterBillingCountry(BillingCountry);
			 
		//Click On CopyBillAdsRadioBtn
		 NewPurchaseOrd.clickOnCopyBillAdsRadioBtn();
		 
		 //Click On Item Name LookUp Img
		 NewPurchaseOrd.clickOnitemNameLkUpImg();
		
		//switch control from one window to another
		 wLib.switchToSpecificWindow(driver,"Products&action");
		 
		 //Enter Product Name in ProductNameSearch Text Edit
		  ProductRelatToVenderPopUpWindow ProdRltToVndrPopUpWindow = new ProductRelatToVenderPopUpWindow(driver);
		  ProdRltToVndrPopUpWindow.enterProductNameForSearch("RealmeNote");
		  
		  //Click On Search Now Button
		  ProdRltToVndrPopUpWindow.clickOnSearchNowBtn();
		  
		  //Click On Searched Product
		  ProdRltToVndrPopUpWindow.clickOnSearchedProduct();
		  
		//switch control from one window to another
		 wLib.switchToSpecificWindow(driver,"PurchaseOrder&action");
		 
		//Enter Quantity
		 NewPurchaseOrd.enterProductQuantity(Quantity);
		 
		 //click on Save button
		 NewPurchaseOrd.clickOnSaveBtn();
		 
	}

}
