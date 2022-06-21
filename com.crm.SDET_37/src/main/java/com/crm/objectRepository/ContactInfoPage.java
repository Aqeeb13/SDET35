package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	//Declaration
	@FindBy(xpath="//span[contains(text(),'Contact Information')]")
	private WebElement contactHeaderTxt;
	
	//Initialization
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getContactHeaderTxt() {
		return contactHeaderTxt;
	}
	
	public String checkContactIsCreatedOrNot() {
		String AText = contactHeaderTxt.getText();
		return AText;
	}	
	
}
