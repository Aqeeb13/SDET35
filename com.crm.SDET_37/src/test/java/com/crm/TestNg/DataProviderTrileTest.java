package com.crm.TestNg;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.IPathConstant;

public class DataProviderTrileTest {

	@Test(dataProvider = "bookBusTicketTest")
	public void bookTicketTest(String src,String Dst) {
		Reporter.log("from "+src+" to "+Dst,true);
	}
	@DataProvider
	public Object[][] bookBusTicketTest() throws Throwable{
		ExcelUtility eLib=new ExcelUtility();
		//two dimension array
		Object[][] obj=new Object[3][2];
	
		for(int i=0;i<obj.length;i++) {
			
			for(int j=0;j<obj[i].length;j++) {
				
			    obj[i][j]=eLib.getDataFromExcelSheet(IPathConstant.excelPathTstNg, "Sheet1", i+1, j+1);
			}
		}
	
		/*
		//obj[0][0]="Banglore";
		obj[0][0]=eLib.getDataFromExcelSheet(IPathConstant.excelPathTstNg, "Sheet1", 1, 1);
		//obj[0][1]="Goa";
		obj[0][1]=eLib.getDataFromExcelSheet(IPathConstant.excelPathTstNg, "Sheet1", 1, 2);
		//obj[1][0]="Banglore";
		obj[1][0]=eLib.getDataFromExcelSheet(IPathConstant.excelPathTstNg, "Sheet1", 2, 1);
		//obj[1][1]="Maysore";
		obj[1][1]=eLib.getDataFromExcelSheet(IPathConstant.excelPathTstNg, "Sheet1", 2, 2);
		//obj[2][0]="Banglore";
		obj[2][0]=eLib.getDataFromExcelSheet(IPathConstant.excelPathTstNg, "Sheet1", 3, 1);
		//obj[2][1]="Mumbai";
		obj[2][1]=eLib.getDataFromExcelSheet(IPathConstant.excelPathTstNg, "Sheet1", 3, 2); */
		return obj;
	}
}
