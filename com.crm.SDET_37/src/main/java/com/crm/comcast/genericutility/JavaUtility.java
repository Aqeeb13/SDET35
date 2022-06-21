package com.crm.comcast.genericutility;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author SAGAR NAYAK
 *
 */

public class JavaUtility {
/**
 *  it is used to generate random Number
 * @return
 */
		
public int getRandomNumber(int maxLimit) {
	Random random=new Random();
	int RandNum=random.nextInt(maxLimit);
	return RandNum;
  }
/**
 * It is used to get system date and time in IST formate
 * @return
 */
public String getSystemDateAndTimeInISTFormate() {
	Date date=new Date();
	return date.toString();
}
/**
 * It is used to get system date and time in Standard formate
 * @return
 */
public String getSystemDateInStandardFormate() {
	Date date=new Date();
	String value = date.toString();
	String year = value.split(" ")[5];
	Format f = new SimpleDateFormat("M");
    String month = f.format(date);
	String day = value.split(" ")[2];
	return year+"/"+day+"/"+month;
}
		

	

}
