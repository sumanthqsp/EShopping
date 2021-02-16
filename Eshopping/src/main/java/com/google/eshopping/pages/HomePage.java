package com.google.eshopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.eshopping.generic.WebActionUtil;

public class HomePage extends BasePage {

	//-----WebElements-----
	@FindBy(linkText="Women") 																private WebElement womenMenuLink ;				
	@FindBy(xpath="//a[text()='Women']/../following-sibling::li/a[text()='Dresses']")		private WebElement dressesMenuLink ;	
	@FindBy(xpath="//a[text()='Women']/../following-sibling::li/a[text()='T-shirts']") 		private WebElement tshirtsMenuLink;
	
	//----------Getters----------
	public WebElement getWomenMenuLink() {
		return womenMenuLink;
	}
	public WebElement getDressesMenuLink() {
		return dressesMenuLink;
	}
	public WebElement getTshirtsMenuLink() {
		return tshirtsMenuLink;
	}
	
	//----------Constructor----------
	public HomePage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}

	//----------Action Methods----------
	public ProductsListPage clickOnMenu(String menuName) {
		menuName = menuName.toLowerCase();
		switch (menuName) {
		case "women": webActionUtil.elementClick(getWomenMenuLink());
						break;
		case "dresses": webActionUtil.elementClick(getDressesMenuLink());
						break;
		case "tshirts": webActionUtil.elementClick(getTshirtsMenuLink());
						break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + menuName);
		}
		return new ProductsListPage(driver,webActionUtil);
	}
	public void signOut() {
		// TODO Auto-generated method stub
		
	}
}
