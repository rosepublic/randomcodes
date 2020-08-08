package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class PaymentOptionPage extends BaseClass {
	
	//Locators

	By cc1 = By.xpath("//*[@id=\"mat-radio-46\"]/label/div[1]/div[1]");
	By proceedToOrderSummaryBtn = By.xpath(
			"/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-payment/mat-card/div/div[2]/button[2]");
	By wallet = By.xpath(
			"/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-payment/mat-card/div/div[1]/div/div[3]/button");
	By couponExpandBtn = By.xpath("//*[@id=\"mat-expansion-panel-header-1\"]/span[1]");

	By couponInput = By.xpath("//*[@id=\"coupon\"]");
	By redeemBtn = By.xpath("//*[@id=\"applyCouponButton\"]");
	By invalidCouponMessage = By.xpath("//*[@id=\"cdk-accordion-child-1\"]/div/div");
	
	//Operations
	public void clickOnFirstCCOption() {

		clickOnElement(driver.findElement(cc1));
	}

	public void clickOnProceedToOrderSummary() {
		driver.findElement(proceedToOrderSummaryBtn).click();
	}
	
	public void clickOnWallet() {
		clickOnElement(driver.findElement(wallet));
	}
	
	public void clickOnCouponExpandBtn() {
		clickOnElement(driver.findElement(couponExpandBtn));
	}
	
	public void sendkeysCouponInput() {
		driver.findElement(couponInput).sendKeys("dfadfssdfd");
	}
	
	public void clickOnRedeemBtn() {
		clickOnElement(driver.findElement(redeemBtn));
	}
	
	public String getInvalidCouponMessage() {
		return driver.findElement(invalidCouponMessage).getText();
	}
}
