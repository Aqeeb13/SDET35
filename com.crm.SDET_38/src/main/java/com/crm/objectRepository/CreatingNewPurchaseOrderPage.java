package com.crm.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.IPathConstant;

public class CreatingNewPurchaseOrderPage extends ExcelUtility {
	
	//Declaration
	@FindBy(name="subject")
	private WebElement subjectTxtEdt;
	
	@FindBy(xpath="//tr[4]//img[@align='absmiddle']")
	private WebElement venderNameLkUpImg;
	
	@FindBy(id="tracking_no")
	private WebElement trackingNoTxtEdt;
	
	@FindBy(name="duedate")
	private WebElement dueDateCalenderTxt;
	
	@FindBy(id="salescommission")
	private WebElement salesCommTxtEdt;
	
	@FindBy(name="postatus")
	private WebElement statusDropdown;
	
	@FindBy(id="requisition_no")
	private WebElement requisitionNoTxtEdt;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement userRadioBtn;
	
	@FindBy(name="bill_street")
	private WebElement billingAddressTxtEdt;
	
	@FindBy(name="bill_city")
	private WebElement billingCityTxtEdt;
	
	@FindBy(name="bill_state")
	private WebElement billingStateTxtEdt;
	
	@FindBy(name="bill_code")
	private WebElement billingCodeTxtEdt;
	
	@FindBy(name="bill_country")
	private WebElement billingCountryTxtEdt;
	
	@FindBy(xpath="//input[@onclick=\"return copyAddressRight(EditView)\"]")
	private WebElement copyBillAdsRadioBtn;
	
	@FindBy(id="searchIcon1")
	private WebElement itemNameLkUpImg;
	
	@FindBy(id="qty1")
	private WebElement quantityTxtEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	
	
	
	//Initialization
	public CreatingNewPurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	public WebElement getSubjectTxtEdt() {
		return subjectTxtEdt;
	}
	
	public WebElement getStatusDropDown() {
		return statusDropdown;
	}


	public WebElement getStatusDropdown() {
		return statusDropdown;
	}


	public WebElement getRequisitionNoTxtEdt() {
		return requisitionNoTxtEdt;
	}


	public WebElement getUserRadioBtn() {
		return userRadioBtn;
	}


	public WebElement getVenderNameLkUpImg() {
		return venderNameLkUpImg;
	}

	public WebElement getTrackingNoTxtEdt() {
		return trackingNoTxtEdt;
	}


	public WebElement getDueDateCalenderTxt() {
		return dueDateCalenderTxt;
	}


	public WebElement getSalesCommTxtEdt() {
		return salesCommTxtEdt;
	}


	public void enterOnsubjectTxtEdt(String subject) {
		subjectTxtEdt.sendKeys(subject);
	}
	
    public void clickOnVenderNameLkUpImg() {
	    venderNameLkUpImg.click();
    }
    
    public void enterOnTrackingNoTxtEdt(String trkNo) {
    	trackingNoTxtEdt.sendKeys(trkNo);
	}
	
    public void enterOndueDateCalenderTxt(String dueDate) {
    	dueDateCalenderTxt.sendKeys(dueDate);
	}
    public void enterOnsalesCommTxtEdt(String salesComm) {
    	salesCommTxtEdt.sendKeys(salesComm);
	}
    
    public void enterOnrequisitionNoTxtEdt(String requisitionNo) {
    	requisitionNoTxtEdt.sendKeys(requisitionNo);
    }
    
    public void clickOnuserRadioBtn() {
    	userRadioBtn.click();
    }
    
    public void enterBillingAddress(String address) {
		billingAddressTxtEdt.sendKeys(address);
	}
	
	public void enterBillingCity(String city) {
		billingCityTxtEdt.sendKeys(city);
	}
	
	public void enterBillingState(String state) {
		billingStateTxtEdt.sendKeys(state);
	}
	
	public void enterBillingCode(String code) {
		billingCodeTxtEdt.sendKeys(code);
	}
	
	public void enterBillingCountry(String country) {
		billingCountryTxtEdt.sendKeys(country);
	}
	
	public void clickOnCopyBillAdsRadioBtn() {
		copyBillAdsRadioBtn.click();
	}
    
	public void clickOnitemNameLkUpImg() {
		itemNameLkUpImg.click();
	}
	
	public void enterProductQuantity(String qty) {
		quantityTxtEdt.sendKeys(qty);
	}
	
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
    
    public void writeElementsInExcel(List<WebElement> allOption,int cell,int BRowNum) throws Throwable {
		int count=allOption.size();
		int k=BRowNum;
		for(int i=0;i<count;i++) {
			String OptName=allOption.get(i).getText();
			writeDataFromExcelSheet(IPathConstant.excelPath, "PurchaseOrderSheet", k, cell, OptName);
			k++;
		}
    }
    public String checkStatusIsDisplayedOrNot(String statusType) {
    	
    	Select s=new Select(statusDropdown);
		String selectElement = s.getFirstSelectedOption().getText();
		
		 
		if(selectElement.equals(statusType)) {
			return  statusType+" Status  is Display";
		}
		
		else {
			return statusType+" Status  is not Display";
		}
    }

}
