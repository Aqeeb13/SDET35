package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * 
 * it is contains External File specific libraries
 * @author SAGAR NAYAK
 *
 */
public class FileUtility {
	/**
	 * its used return the value from the property file based on key
	 * @return
	 * @throws Throwable 
	 */
public String getPropertyKeyValue(String path,String key) throws Throwable {
	FileInputStream fis=new FileInputStream(path);
	Properties p=new Properties();
	p.load(fis);
	String data = p.getProperty(key);
	return data;
}
/**
 * It is used to Update the data from property file
 * @param path
 * @param key
 * @param NewValue
 * @throws Throwable
 */
public void setPropertyKeyValue(String path,String key,String NewValue) throws Throwable{
	FileInputStream fis=new FileInputStream(path);
	Properties p=new Properties();
	p.load(fis);
	p.setProperty(key, NewValue);
	FileOutputStream fos=new FileOutputStream(path);
	p.store(fos, NewValue);
	
}
}
