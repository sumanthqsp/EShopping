package com.google.eshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.google.eshopping.generic.WebActionUtil;

public class BasePage {
	public WebDriver driver ;
	public WebActionUtil webActionUtil;
	
	public BasePage(WebDriver driver , WebActionUtil webActionUtil) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.webActionUtil=webActionUtil;
	}

}
