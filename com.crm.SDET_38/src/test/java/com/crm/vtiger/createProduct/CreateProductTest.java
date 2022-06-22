package com.crm.vtiger.createProduct;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateProductTest {
static {
	System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys("Iphone");
		WebElement manLoc = driver.findElement(By.name("manufacturer"));
		Select s=new Select(manLoc);
		s.selectByValue("LexPon Inc.");
		driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		WebElement Handler = driver.findElement(By.name("assigned_group_id"));
		Select s1=new Select(Handler);
		s1.selectByVisibleText("Support Group");
		File f=new File("./src/test/resources/TestFile.jpg");
		String path=f.getAbsolutePath();
		driver.findElement(By.id("my_file_element")).sendKeys(path);
		driver.findElement(By.name("button")).click();
		String pName = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
       if(pName.contains("Iphone")) {
    	   System.out.println("Product is Created Sucessfully");
       }
       else {
    	   System.out.println("Product is not Created ");
       }
       Actions a=new Actions(driver);
       a.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
       driver.close();
	}

}
