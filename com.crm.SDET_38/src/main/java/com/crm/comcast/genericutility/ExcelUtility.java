package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 * @author SAGAR NAYAK
 *
 */
public class ExcelUtility {
	/**
	 * its used to read the data from Excel-Workbook based on below 
	 * @param path
	 * @param Sheet
	 * @param CellNum
	 * @param RowNum
	 * @return
	 * @throws Throwable
	 */
public String getDataFromExcelSheet(String path,String Sheet,int RowNum,int CellNum) throws Throwable {
	FileInputStream fis=new FileInputStream(path);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(Sheet);
	Row row = sheet.getRow(RowNum);
	Cell cell = row.getCell(CellNum);
	//For Reading both Numeric and String value
    DataFormatter format = new DataFormatter();
    String data = format.formatCellValue(cell);
	return data;
}
/**
 * It is used to update data from Excel Sheet
 * @param path
 * @param Sheet
 * @param CellNum
 * @param RowNum
 * @param NewValue
 * @throws Throwable
 */
public void setDataFromExcelSheet(String path,String Sheet,int RowNum,int CellNum,String NewValue) throws Throwable {
	FileInputStream fis=new FileInputStream(path);
	Workbook wb=WorkbookFactory.create(fis);
	wb.getSheet(Sheet).getRow(RowNum).getCell(CellNum).setCellValue(NewValue);
	FileOutputStream fos=new FileOutputStream(path);
	wb.write(fos);
	wb.close();
}
/**
 * used to write data back to Excel based on below parameter
 * @param path
 * @param Sheet
 * @param CellNum
 * @param RowNum
 * @param NewValue
 * @throws Throwable
 */
public void writeDataFromExcelSheet(String path,String Sheet,int RowNum,int CellNum,String NewValue) throws Throwable {
	FileInputStream fis=new FileInputStream(path);
	Workbook wb=WorkbookFactory.create(fis);
	wb.getSheet(Sheet).getRow(RowNum).createCell(CellNum).setCellValue(NewValue);
	FileOutputStream fos=new FileOutputStream(path);
	wb.write(fos);
	wb.close();
}
/**
 * 
 * used to get the last used row number on specified Sheet
 * @param path
 * @param sheetName
 * @return
 * @throws Throwable
 */
public int getRowCount(String path,String sheetName) throws Throwable {
	FileInputStream fis  = new FileInputStream(path);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	wb.close();
	return sh.getLastRowNum();
}

}
