package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPopUpWindowPage {
	//Declaration
		@FindBy(name="search_text")
		private WebElement ContactSearchTxtEdt;
		
		@FindBy(name="search")
		private WebElement SearchNowBtn;
		
		@FindBy(id="1")
		private WebElement ContactNameTxt;
		
		//Initialization
		public ContactPopUpWindowPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getOrgSearchTxtEdt() {
			return ContactSearchTxtEdt;
		}

		public WebElement getSearchNowBtn() {
			return SearchNowBtn;
		}

		public WebElement getOrgNameTxt() {
			return ContactNameTxt;
		}
		
		public void enterOrgNameForSearch(String ContName) {
			ContactSearchTxtEdt.sendKeys(ContName);
		}
		public void clickOnSearchNowBtn() {
			SearchNowBtn.click();
		}
		public void clickOnSearchedOrg() {
			ContactNameTxt.click();
		}
}
