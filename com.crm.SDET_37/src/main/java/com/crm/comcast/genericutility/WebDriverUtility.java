package com.crm.comcast.genericutility;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * contains all reusable Actions of Webdriver 
 * @author SAGAR NAYAK
 *
 */
public class WebDriverUtility {
	/**
	 * it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * Implicity Wait
	 * @param driver
	 * @param Time
	 */
	public void waitForPageToLoad(WebDriver driver,int Time) {
		driver.manage().timeouts().implicitlyWait(Time,TimeUnit.SECONDS);
	}
	/**
	 * It will wait for JS element
	 * Implicity Wait
	 * @param driver
	 * @param Time
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver,int Time) {
		driver.manage().timeouts().setScriptTimeout(Time, TimeUnit.SECONDS);
	}
	/**
	 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * Explicity wait
	 * @param driver
	 * @param element
	 * @param Time
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element,int Time) {
		WebDriverWait wait=new WebDriverWait(driver, Time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * Explicity wait
	 * @param driver
	 * @param Title
	 * @param Time
	 */
	public void waitForTitleContains(WebDriver driver,String Title,int Time) {
		WebDriverWait wait=new WebDriverWait(driver, Time);
		wait.until(ExpectedConditions.titleContains(Title));
	}
	/**
	 * Here we can change the polling time from 500ms(default) to any polling time
	 * Fluent Wait
	 * @param driver
	 * @param pollingTime
	 * @param element
	 */
	public void waitForElementToCustom(WebDriver driver,int pollingTime,WebElement element) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * Here wee are giving Custome timeOut
	 * CustomeWait 
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable {
		int count=0;
		while(count<10) {
			try {
				element.click(); 
			}
			catch(Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * used to Switch to Any Window based on Window Url
	 * @param driver
	 * @param specific_window
	 */
	public void switchToSpecificWindow(WebDriver driver,String specific_window) {
		Set<String> windowList = driver.getWindowHandles();
		Iterator<String> it = windowList.iterator();
		while(it.hasNext()) {
			String wTitle = it.next();
			driver.switchTo().window(wTitle);
			String ActualWindow = driver.getCurrentUrl();
			if(ActualWindow.contains(specific_window)) {
				break;
			}
		}
	}
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToChildFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);	
	}
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_Attribute
	 */
	public void switchToChildFrame(WebDriver driver,String id_Attribute) {
		driver.switchTo().frame(id_Attribute);	
		}
	/**
	 * Switch control from one frame to another frame by using Xpath
	 * @param driver
	 * @param element
	 */
	public void switchToChildFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);	
		}
	/**
	 * Switch control from  Childframe to  Mainframe
	 * @param driver
	 */
	public void switchBackToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 *  Switch control from  Childframe to  Parentframe
	 * @param driver
	 */
	public void switchBackToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	public void switchToAlertPopUpAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void switchToAlertPopUpAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();;
	}
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param Value
	 */
	public void selectDropDown(WebElement element,String Value) {
		Select select = new Select(element);
		select.selectByValue(Value);
	}
	/**
	 * It is used to select an element inside the dropdow by using Visual_Text
	 * @param element
	 * @param visual_Text
	 */
	public void selectDropDownByVText(WebElement element,String visual_Text) {
		Select select = new Select(element);
		select.selectByVisibleText(visual_Text);
	}
	/**
	 * It is used to retrive all the elements inside the dropdow 
	 * @param element
	 * @return
	 */
	public List<WebElement> getAllOptionFromDropDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allOption = select.getOptions();
		return allOption;
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAnElement(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * used to right click  on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * pass enter Key appertain in to Browser
	 * @param driver
	 */
	public void clickOnEnterButton(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
	}
	/**
	 * It is used to take ScreenShot
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable
	 */
	public static String takeScreenShot(WebDriver driver,String screenShotName) throws Throwable {
		TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
		File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShot/"+screenShotName+".PNG");
		Files.copy(src, dst);
		return screenShotName;
	}

}
