package com.google.eshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.eshopping.generic.WebActionUtil;

public class LoginPage extends BasePage{

	//-----WebElements-----
	@FindBy(linkText="Sign in") 		private WebElement signInLink ;				
	@FindBy(id="email")					private WebElement usernameTextField ;	
	@FindBy(id="passwd") 				private WebElement passwordTextField;
	@FindBy(id="SubmitLogin") 			private WebElement signInButton ;
	
	//----------Getters----------
	public WebElement getSignInLink() {
		return signInLink;
	}	
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public WebElement getSignInButton() {
		return signInButton;
	}

	//----------Constructor----------
	public LoginPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}
	
	//----------Action Methods----------
	public HomePage login(String username , String password) {
		webActionUtil.elementClick(getSignInLink());
		webActionUtil.enterData(getUsernameTextField(), username);
		webActionUtil.enterData(getPasswordTextField(), password);
		webActionUtil.elementClick(getSignInButton());
		return new HomePage(driver,webActionUtil);
	}
}
