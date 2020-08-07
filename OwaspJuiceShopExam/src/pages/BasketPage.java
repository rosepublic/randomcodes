package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class BasketPage extends BaseClass {

	By ckOutBtn = By.xpath("//*[@id=\"checkoutButton\"]");
	
	public void clickOnCheckOutBtn() {
		//driver.findElement(ckOutBtn).click();
		clickOnElement(driver.findElement(ckOutBtn));
	}
}
