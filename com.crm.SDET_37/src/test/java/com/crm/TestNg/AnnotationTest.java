package com.crm.TestNg;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationTest {
	
 @BeforeSuite
 public void beforeSuite() {
	 
 }
 @BeforeTest
 public void beforeTest() {
		 
  }
 @BeforeClass
public void beforeClass() {
	 
	  }
	 
  @BeforeMethod
  public void beforeMethod() {
	Reporter.log("BeforeMethod",true); 
  }

  @AfterMethod
  public void afterMethod() {
  }

 

  @AfterClass
  public void afterClass() {
  }

 

  @AfterTest
  public void afterTest() {
  }

 

  @AfterSuite
  public void afterSuite() {
  }

}
