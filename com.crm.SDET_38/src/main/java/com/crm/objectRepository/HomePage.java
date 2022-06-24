package com.crm.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.comcast.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organisationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(name="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(name="Purchase Order")
	private WebElement purchaseLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(xpath = "//a[@href='index.php?action=index&module=Home']")
	private WebElement homePageLogo;
	
	@FindBy(name="Vendors")
	private WebElement venderLink;
	
	
	
	
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization

	public WebElement getOrganisationLink() {
		return organisationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getHomePageLogo() {
		return homePageLogo;
	}


	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getCampaignLink() {
		return campaignLink;
	}


	public WebElement getPurchaseLink() {
		return purchaseLink;
	}
	
	public WebElement getAdministratorLink() {
		return administratorLink;
	}


	public void clickOnOrganisation() {
		organisationLink.click();
	}
	public void clickOnContacts() {
		contactsLink.click();
	}
	public void clickOnProducts() {
		productsLink.click();
	}
	public void clickOnDocuments() {
		documentsLink.click();
	}
	public void clickOnCampaign(WebDriver driver) {
		mouseOverAnElement(driver, moreLink);
		campaignLink.click();
		
	}
	public void clickOnpurchaseOrder(WebDriver driver) {
		mouseOverAnElement(driver, moreLink);
		purchaseLink.click();
		
	}
	public void clickOnLogOutBtn(WebDriver driver) {
		mouseOverAnElement(driver, administratorLink);
		signOutLink.click();
		
	}
	public void clickOnVenderLink() {
		venderLink.click();
	}
	
	public String checkHomePageIsDisplayOrNot() {
		boolean HomePage=homePageLogo.isDisplayed();
		if(HomePage) {
				return "HomePage is Display";
			}
			else {
				return "HomePage is not Display";
			}
	}
	
	

}
