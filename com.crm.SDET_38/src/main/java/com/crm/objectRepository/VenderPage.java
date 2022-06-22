package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VenderPage {

	
	//Declaration
		@FindBy(xpath="//img[@alt='Create Vendor...']")
		private WebElement createVenderLkUpImg;

		
		//Initialization
		public VenderPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
			
		//Utilization
		public void clickOnCreateVenderLkUpImg() {
			createVenderLkUpImg.click();
		}
			
}
