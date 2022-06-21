package com.crm.comcast.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {
	
	public static WebDriver sdriver;
	public  WebDriver driver;
	
	//Creating object of JavaUtility Class
	public JavaUtility jLib = new JavaUtility();
			
	//Creating object of ExcelUtility Class
	public ExcelUtility eLib = new ExcelUtility();
			
	//Creating object of FileUtility Class
	public FileUtility fLib = new FileUtility();
	 
	//Creating object of WebDriverUtility Class
	public WebDriverUtility wLib = new WebDriverUtility();
	
	//Creating object of DataBaseUtility Class
	public DataBaseUtility dLib=new DataBaseUtility();

	
    @BeforeSuite(groups = {"SmokeTest","RegressionTest"})
    public void connectToDataBase() {
    dLib.dataBaseConfiguration();
    }
   // @Parameters("BROWSER")/*This One for Cross Browser Execution*/
    @BeforeClass(groups = {"SmokeTest","RegressionTest"})
    //	 public void launchThebrowser(String BROWSER) throws Throwable {/*This One for Cross Browser Execution*/
    	  public void launchThebrowser() throws Throwable {
    	System.out.println("Launch the Browser");
	//Fetch data from Property File
    	String URL=fLib.getPropertyKeyValue(IPathConstant.filePath, "url");
    	//String URL=System.getProperty("url");
	 String BROWSER=fLib.getPropertyKeyValue(IPathConstant.filePath, "browser");
	 //String BROWSER=System.getProperty("browser");
	
			
	if(BROWSER.equalsIgnoreCase("chrome")) {
	    WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
			}
	else if(BROWSER.equalsIgnoreCase("Firefox")){
		WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		}
	else {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	  }
	 //Enter Url
	sdriver=driver;
	 sdriver.get(URL);
	
	 //Synchronize Through implicit wait
	 wLib.waitForPageToLoad(driver, 10);
	
	 //Maximize Browser
	 driver.manage().window().maximize();
     }
   @BeforeMethod(groups = {"SmokeTest","RegressionTest"})
   public void loginToApplication() throws Throwable {
	   System.out.println("Login To the Application");
   String UN=fLib.getPropertyKeyValue(IPathConstant.filePath, "un");
   String PWD=fLib.getPropertyKeyValue(IPathConstant.filePath, "pwd");
  
  //Enter UserName,password and click on login button
   LoginPage loginPage = new LoginPage(driver);
  //Take Login Page ScreenShot
   wLib.takeScreenShot(driver,"LoginScreenIn");
   //Verify Login Page id Displayed or Not
	String LoginPageStatus = loginPage.checkLoginPageIsDisplayOrNot();
	System.out.println(LoginPageStatus);
   loginPage.loginToVtiger(UN, PWD);
   
   }

  @AfterMethod(groups = {"SmokeTest","RegressionTest"})
  public void signOutTheApplication() throws Throwable {
	  System.out.println("LogOut To the Application");
   HomePage homePage = new HomePage(driver);
   Thread.sleep(2000);
   homePage.clickOnLogOutBtn(driver);
   //Verify Login Page id Displayed or Not
   LoginPage loginPage = new LoginPage(driver);
	String LoginPageStatus1 = loginPage.checkLoginPageIsDisplayOrNot();
	System.out.println(LoginPageStatus1);
  //Take Login Page ScreenShot
	wLib.takeScreenShot(driver,"LoginPageOut");
  }

 @AfterClass(groups = {"SmokeTest","RegressionTest"})
 public void closeTheBrowser() {
 System.out.println("Close the Browser");
 driver.close();
 }

 @AfterSuite(groups = {"SmokeTest","RegressionTest"})
 public void closeDataBaseConnection() {
  dLib.dataBaseClosed();
 }
}
