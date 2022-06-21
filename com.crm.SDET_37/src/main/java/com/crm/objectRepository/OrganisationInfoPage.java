package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	

	//Declaration
		@FindBy(xpath="//span[contains(text(), 'Organization Information')]")
		private WebElement organisationHeaderTxt;
		
		//Initialization
		public OrganisationInfoPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Utilization
		public WebElement getContactHeaderTxt() {
			return organisationHeaderTxt;
		}
		
		public String checkOrganisationIsCreatedOrNot(String EText) {
			String AText = organisationHeaderTxt.getText();
			if(AText.contains(EText)) {
				return "Organisation is Created";
				
			}
			else {
				return "Organisation is  not Created";
			}
		}
}
