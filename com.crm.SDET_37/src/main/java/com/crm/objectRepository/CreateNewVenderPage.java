package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVenderPage {
	
	//Declaration
	@FindBy(name="vendorname")
	private WebElement venderNameTxtEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewVenderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
	//Utilization
	
	public WebElement getVenderNameTxtEdt() {
		return venderNameTxtEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterVenderName(String vender) {
		venderNameTxtEdt.sendKeys(vender);
	}
	
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
}
