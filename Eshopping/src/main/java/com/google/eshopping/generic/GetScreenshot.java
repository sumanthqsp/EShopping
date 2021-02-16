package com.google.eshopping.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetScreenshot {
	/**
	 * To take Page Screenshot
	 * @param driver provide webdriver reference 
	 * @param testCaseName provide test case name/test method (@Test) 
	 * @return returns the screenshot path
	 */
	public static String getImage(WebDriver driver, String testCaseName) {
		
		String timeStamp = LocalDateTime.now().toString().replace(':','-');
		String filePath = IAutoConstants.IMAGE_PATH+timeStamp+testCaseName+".png" ;
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);
		try {
			FileUtils.copyFile(tempFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
	/**
	 * To take Element Screenshot
	 * @param driver provide target web element 
	 * @param testCaseName provide test case name/test method (@Test) 
	 * @return returns the screenshot path
	 */
	public static String getImage(WebElement targetElement, String testCaseName) {
		
		String timeStamp = LocalDateTime.now().toString().replace(':','-');
		String filePath = IAutoConstants.IMAGE_PATH+timeStamp+testCaseName+".png" ;
		
		File tempFile = targetElement.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);
		try {
			FileUtils.copyFile(tempFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
}
