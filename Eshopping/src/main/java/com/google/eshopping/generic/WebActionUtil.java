package com.google.eshopping.generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil {

	WebDriver driver ;
	JavascriptExecutor js ;
	Actions actions ;
	WebDriverWait wait ;
	
	public WebActionUtil(WebDriver driver , long ETO) {
		this.driver=driver;
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, ETO);
	}
	
	public void enterData(WebElement targetElement , String dataToEnter) {
		targetElement.clear();
		targetElement.sendKeys(dataToEnter);
	}
	
	public void enterDataUsingJS(WebElement targetElement , String dataToEnter) {
		js.executeScript("arguments[0].value'';", targetElement);
		js.executeScript("arguments[0].value'"+dataToEnter+"';", targetElement);
	}
	
	public void elementClick(WebElement targetElement) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(targetElement));
		targetElement.click();
	}
	
	public void elementClickUsingJS(WebElement targetElement) {
		js.executeScript("arguments[0].click();", targetElement);
	}
	
	public void moveToElement(WebElement targetElement) {
		actions.moveToElement(targetElement).perform();
	}
	
	public void moveToElementByCoordinates(WebElement targetElement, int xOffset , int yOffset) {
		actions.moveToElement(targetElement, xOffset, yOffset).perform();
	}
	
	public void moveByOffset(int xOffset , int yOffset) {
		actions.moveByOffset(xOffset, yOffset).perform();
	}
	
	public void click() {
		actions.click().perform();
	} 
	
	public void click(WebElement targetElement) {
		actions.click(targetElement).perform();
	}

	public void doubleClick() {
		actions.doubleClick().perform();
	} 
	
	public void doubleClick(WebElement targetElement) {
		actions.doubleClick(targetElement).perform();
	}
	
	public void contextClick() {
		actions.contextClick().perform();
	} 
	
	public void contextClick(WebElement targetElement) {
		actions.contextClick(targetElement).perform();
	}
	
	public void dragAndDrop(WebElement sourcetElement , WebElement destElement) {
		actions.dragAndDrop(sourcetElement, destElement);
	}
	
	public void dragAndDropBy(WebElement sourcetElement , int xOffset , int yOffset) {
		actions.dragAndDropBy(sourcetElement, xOffset , yOffset);
	}
	
	public void selectVisibleText(WebElement targetListBoxElement , String text) {
		Select s = new Select(targetListBoxElement);
		s.selectByVisibleText(text);
	}
	
	public void switchToFrame(String indexNameOrId) {
		try {
			int index = Integer.parseInt(indexNameOrId);
			driver.switchTo().frame(index);
		} catch(NumberFormatException e) {
			driver.switchTo().frame(indexNameOrId);
		}
	}
}
