package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VenderPopUpWindowPage {

	//Declaration
		@FindBy(name="search_text")
		private WebElement VenderSearchTxtEdt;
		
		@FindBy(name="search")
		private WebElement SearchNowBtn;
		
		@FindBy(id="1")
		private WebElement VenderNameTxt;
		
		
		//Initialization
		public VenderPopUpWindowPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getOrgSearchTxtEdt() {
			return VenderSearchTxtEdt;
		}

		public WebElement getSearchNowBtn() {
			return SearchNowBtn;
		}

		public WebElement getOrgNameTxt() {
			return VenderNameTxt;
		}
		
		public void enterVenderNameForSearch(String VenderName) {
			VenderSearchTxtEdt.sendKeys(VenderName);
		}
		public void clickOnSearchNowBtn() {
			SearchNowBtn.click();
		}
		public void clickOnSearchedVender() {
			VenderNameTxt.click();
		}
	
}
