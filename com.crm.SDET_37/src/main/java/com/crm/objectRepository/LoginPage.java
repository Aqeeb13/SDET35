package com.crm.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
//Declaration
@FindBy(name="user_name")
private WebElement userNameTxtEdt;

@FindBy(name="user_password")
private WebElement passwordTxtEdt;

@FindBy(id="submitButton")
private WebElement loginBtn;

@FindBy(xpath="//div[@class='loginForm']")
private WebElement loginFormImg;


//Intitialization
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

//Utilization
public WebElement getUserNameTxtEdt() {
	return userNameTxtEdt;
}

public WebElement getLoginFormImg() {
	return loginFormImg;
}

public WebElement getpasswordTxtEdt() {
	return passwordTxtEdt;
}
public String checkLoginPageIsDisplayOrNot() {
	boolean LoginPage=loginFormImg.isDisplayed();
	if(LoginPage) {
			return "LoginPage is Display";
		}
		else {
			return "LoginPage is not Display";
		}
}

public void loginToVtiger(String UserName,String PassWord) {
	userNameTxtEdt.sendKeys(UserName);
	passwordTxtEdt.sendKeys(PassWord);
	loginBtn.click();
}
	
}
