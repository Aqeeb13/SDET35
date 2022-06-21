package com.crm.objectRepository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.IPathConstant;

public class CreatingNewContactPage extends ExcelUtility  {
	
	//Declaration
	@FindBy(name="salutationtype")
	private WebElement firstNameTitleTxtEdt;
	
	@FindBy(name="firstname")
	private WebElement firstNameTxtEdt;
	
	@FindBy(name="lastname")
	private WebElement lastNameTxtEdt;
	
	@FindBy(name="title")
	private WebElement titleTxtEdt;
	
	@FindBy(xpath="//input[@value=\"T\"]")
	private WebElement groupRadioButton;
	
	@FindBy(name="assigned_group_id")
	private WebElement assignedToDropDown;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	@FindBy(xpath="//tr[10]//img")
	private WebElement reportToLookUpIMG ;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(name="birthday")
	private WebElement DOBCalenderPopup;
	
	@FindBy(xpath="//tr[5]//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement organisationLookUpIMG ;
	
	@FindBy(name="imagename")
	private WebElement ContactImgFileUploadPopup;
	
	
	
	
	//Initialization
	public  CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//Utilization
	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}


	public WebElement getReportToLookUpIMG() {
		return reportToLookUpIMG;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}


	public WebElement getOrganisationLookUpIMG() {
		return organisationLookUpIMG;
	}


	public WebElement getContactImgFileUploadPopup() {
		return ContactImgFileUploadPopup;
	}


	public WebElement getDOBCalenderPopup() {
		return DOBCalenderPopup;
	}


	public WebElement getFirstNameTitleTxtEdt() {
		return firstNameTitleTxtEdt;
	}


	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}


	public WebElement getFirstNameTxtEdt() {
		return firstNameTxtEdt;
	}



	public WebElement getLastNameTxtEdt() {
		return lastNameTxtEdt;
	}



	public WebElement getTitleTxtEdt() {
		return titleTxtEdt;
	}



	public WebElement getAssignedToDropDown() {
		return assignedToDropDown;
	}
	
	
	public void clickOnOrganisationLookUpImg() {
		organisationLookUpIMG.click();
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public void enterFirstName(String firstName) {
		firstNameTxtEdt.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameTxtEdt.sendKeys(lastName);
	}
	
	public void enterTitle(String title) {
		titleTxtEdt.sendKeys(title);
	}
	
	public void clickOnGroupRadioButton() {
		groupRadioButton.click();
	}
	public void enterDOB(String dob) {
		DOBCalenderPopup.sendKeys(dob);
	}
	public void clickOnReportToLookUpImg() {
		reportToLookUpIMG.click();
	}
	public void fileUploadInContactImg(String path) {
		ContactImgFileUploadPopup.sendKeys(path);
	}
	
	public void writeElementsInExcel(List<WebElement> allOption,int cell,int BRowNum) throws Throwable {
		int count=allOption.size();
		int k=BRowNum;
		for(int i=0;i<count;i++) {
			String OptName=allOption.get(i).getText();
			writeDataFromExcelSheet(IPathConstant.excelPath, "ContactSheet", k, cell, OptName);
			k++;
		}
	}
	
	
	
	
	
	
	
	
}
