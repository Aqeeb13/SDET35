package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductRelatToVenderPopUpWindow {

	
	//Declaration
			@FindBy(name="search_text")
			private WebElement productNameSearchTxtEdt;
			
			@FindBy(name="search")
			private WebElement SearchNowBtn;
			
			@FindBy(id="popup_product_48")
			private WebElement productNameTxt;
			
			
			
			//Initialization
			public ProductRelatToVenderPopUpWindow(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}

			//Utilization
			public WebElement getProductNameSearchTxtEdt() {
				return productNameSearchTxtEdt;
			}

			public WebElement getSearchNowBtn() {
				return SearchNowBtn;
			}

			public WebElement getProductNameTxt() {
				return productNameTxt;
			}
			
			
			public void enterProductNameForSearch(String VenderName) {
				productNameSearchTxtEdt.sendKeys(VenderName);
			}
			

			public void clickOnSearchNowBtn() {
				SearchNowBtn.click();
			}
			public void clickOnSearchedProduct() {
				productNameTxt.click();
			}
}
