package com.google.eshopping.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.eshopping.generic.WebActionUtil;

public class ProductDetailsPage extends BasePage {

	//-----WebElements-----
	@FindBy(xpath="//i[@class='icon-plus']") 			private WebElement plusIcon ;
	@FindBy(className="icon-minus") 					private WebElement minusIcon ;
	@FindBy(id="group_1") 								private WebElement sizeListBox ;
	@FindBy(xpath="//ul[@id='color_to_pick_list']//a") 	private List<WebElement> colorPickerList ;
	@FindBy(name="Submit") 								private WebElement addToCartButton ;
	@FindBy(linkText="Proceed to checkout") 			private WebElement proceedToCheckOutButton ;
	@FindBy(xpath="//span[@title='Continue shopping']") private WebElement continueToShoppinButton ;
	@FindBy(className="cross") 							private List<WebElement> closeIcon ;
	
	//----------Getters----------
	public WebElement getPlusIcon() {
		return plusIcon;
	}
	public WebElement getMinusIcon() {
		return minusIcon;
	}
	public WebElement getSizeListBox() {
		return sizeListBox;
	}
	public List<WebElement> getColorPickerList() {
		return colorPickerList;
	}	
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	public WebElement getproceedToCheckOutButton() {
		return proceedToCheckOutButton;
	}
	public WebElement getContinueToShoppinButton() {
		return continueToShoppinButton;
	}
	public List<WebElement> getCloseIcon() {
		return closeIcon;
	}
	
	//----------Constructor----------
	public ProductDetailsPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}

	//----------Action Methods----------
	public void changeQuantity (int quantity , boolean increase) {
		WebElement ele ;
		
//		if(increase) {
			ele=getPlusIcon();
//		} else {
//			ele=getMinusIcon();
//		}
//		
		for(int i=1;i<=quantity;i++) {
			webActionUtil.elementClickUsingJS(ele);
		}
	}
	
	public void clickOnColor(String colorName) {
		for (WebElement ele : getColorPickerList()) {
			if (ele.getAttribute("name").equalsIgnoreCase(colorName)) {
				webActionUtil.elementClick(ele);
				break;
			}			
		}
	}
	
	public OrderDetailsPage addItemToCart(int quantity , boolean increase , String sizeText , String colorName) {
		changeQuantity(quantity,increase);
		webActionUtil.selectVisibleText(getSizeListBox(), sizeText);
		clickOnColor(colorName);
		webActionUtil.elementClick(getAddToCartButton());
		webActionUtil.elementClick(getproceedToCheckOutButton());
		return new OrderDetailsPage(driver, webActionUtil);
	}
}
