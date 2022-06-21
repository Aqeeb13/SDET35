package com.crm.objectRepository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.IPathConstant;


public class CreatingNewOrganisationPage extends ExcelUtility {
	
	//Declaration
	@FindBy(name="accountname")
	private WebElement orgNameTxtEdt;

	@FindBy(name="website")
	private WebElement webSiteTxtEdt;
	
	@FindBy(xpath="//input[@value=\"T\"]")
	private WebElement groupRadioButton;
	
	@FindBy(name="assigned_group_id")
	private WebElement assignedToDropDown;
	
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
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@alt=\"Select\"]")
	private WebElement memberOfLkUpImg;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(name="rating")
	private WebElement ratingDropDown;
	
	
	
	//Initialisation
	public CreatingNewOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	
	public WebElement getOrgNameTxtEdt() {
		return orgNameTxtEdt;
	}
	
	
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getRatingDropDown() {
		return ratingDropDown;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getMemberOfLkUpImg() {
		return memberOfLkUpImg;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCopyBillAdsRadioBtn() {
		return copyBillAdsRadioBtn;
	}

	public WebElement getBillingAddressTxtEdt() {
		return billingAddressTxtEdt;
	}

	public WebElement getBillingCityTxtEdt() {
		return billingCityTxtEdt;
	}

	public WebElement getBillingStateTxtEdt() {
		return billingStateTxtEdt;
	}

	public WebElement getBillingCodeTxtEdt() {
		return billingCodeTxtEdt;
	}

	public WebElement getBillingCountryTxtEdt() {
		return billingCountryTxtEdt;
	}

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}

	public WebElement getAssignedToDropDown() {
		return assignedToDropDown;
	}

	public WebElement getWebSiteTxtEdt() {
		return webSiteTxtEdt;
	}

	public void enterOrgName(String orgName) {
		orgNameTxtEdt.sendKeys(orgName);
	}
	
	public void enterOrgWebsite(String orgWebsite) {
		webSiteTxtEdt.sendKeys(orgWebsite);
	}
	
	public void clickOnGroupRadioButton() {
		groupRadioButton.click();
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
	
	public void clickOnSaveBtn() {
		saveButton.click();
	}
	
	public void clickOnMemberOfLkUpImg() {
		memberOfLkUpImg.click();
	}
	public void writeElementsInExcel(List<WebElement> allOption,int cell,int BRowNum) throws Throwable {
		int count=allOption.size();
		int k=BRowNum;
		for(int i=0;i<count;i++) {
			String OptName=allOption.get(i).getText();
			writeDataFromExcelSheet(IPathConstant.excelPath, "OrganisationSheet", k, cell, OptName);
			k++;
		}
	}
	
	
	
	
	
	
	
	
	

}
