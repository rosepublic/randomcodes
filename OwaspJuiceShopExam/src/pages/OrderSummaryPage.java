package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class OrderSummaryPage extends BaseClass{

	By placeOrderBtn = By.xpath("//*[@id=\"checkoutButton\"]");
	
	public void clickOnPlaceOrderBtn() {
		driver.findElement(placeOrderBtn).click();
	}
}
