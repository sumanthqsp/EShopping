package com.google.eshopping.testscripts;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.eshopping.generic.ExcelLibrary;
import com.google.eshopping.generic.ProjectUtility;
import com.google.eshopping.pages.OrderDetailsPage;
import com.google.eshopping.pages.ProductDetailsPage;
import com.google.eshopping.pages.ProductsListPage;

public class TC001 extends BaseTest {

	@Test(description="to verify whether the product addded is displayed in ODP")
	public void testProductIsDisplayedInODP () {
		String sheetName = "TC001";
		File absPath = new File(XL_PATH);
		
		String menuName = ExcelLibrary.getStringData(absPath, sheetName, 1, 0);
		int productId = (int) Double.parseDouble(ExcelLibrary.getStringData(absPath, sheetName, 1, 1));
		int increaseQty = (int) Double.parseDouble(ExcelLibrary.getStringData(absPath, sheetName, 1, 2));
//		int decreaseQty = (int) Double.parseDouble(ExcelLibrary.getStringData(absPath, sheetName, 1, 3));
		String sizeText = ExcelLibrary.getStringData(absPath, sheetName, 1, 4);
		String colorName = ExcelLibrary.getStringData(absPath, sheetName, 1, 5);
		
		ProductsListPage productsListPage = homePage.clickOnMenu(menuName);
		ProductDetailsPage productDetailsPage = productsListPage.clickOnProduct(productId);
		ProjectUtility.sleepInSeconds(10);
		OrderDetailsPage orderDetailsPage = productDetailsPage.addItemToCart(increaseQty, true, sizeText, colorName);
		Assert.assertEquals(orderDetailsPage.clickOnProduct(productId) , true);
	}
}
