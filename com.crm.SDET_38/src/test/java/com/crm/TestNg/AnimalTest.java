package com.crm.TestNg;




import org.testng.Reporter;
import org.testng.annotations.Test;

public class AnimalTest {
	@Test()
	public void elephanteTest() {
		Reporter.log("Big",true);
		
	
	}
	@Test(dependsOnMethods = "elephanteTest")
	public void dogTest() {
		Reporter.log("Medium",true);
		
	}
	
	@Test()
	public void ratTest() {
		Reporter.log("Small",true);
		
	}
}


