package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPopUpWindowPage {

	//Declaration
	@FindBy(name="search_text")
	private WebElement OrgSearchTxtEdt;
	
	@FindBy(name="search")
	private WebElement SearchNowBtn;
	
	@FindBy(id="1")
	private WebElement OrgNameTxt;
	
	//Initialization
	public OrgPopUpWindowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgSearchTxtEdt() {
		return OrgSearchTxtEdt;
	}

	public WebElement getSearchNowBtn() {
		return SearchNowBtn;
	}

	public WebElement getOrgNameTxt() {
		return OrgNameTxt;
	}
	
	public void enterOrgNameForSearch(String OrgName) {
		OrgSearchTxtEdt.sendKeys(OrgName);
	}
	public void clickOnSearchNowBtn() {
		SearchNowBtn.click();
	}
	public void clickOnSearchedOrg() {
		OrgNameTxt.click();
	}
	
	
}
