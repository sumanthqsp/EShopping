package com.google.eshopping.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.eshopping.generic.WebActionUtil;

public class OrderDetailsPage extends BasePage{

	//-----WebElements-----
	@FindBy(xpath="//td[@class='cart_product']/a")		private List<WebElement> productsList ;
	
	//----------Getters----------
	public List<WebElement> getProductsList() {
		return productsList;
	}

	//----------Constructor----------
	public OrderDetailsPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}
	
	//----------Action Methods----------
	public boolean clickOnProduct(int productId) {
		String pid = "id_product="+productId;
		for(WebElement ele : getProductsList()) {												//Same method is present
			if(ele.getAttribute("href").contains(pid)) {										// in productsListPage ??
				return true;
			}
		}
		return false;
		
	}
}
