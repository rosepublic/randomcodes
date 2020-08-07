package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ShopPage extends BaseClass {
	
	By greenSmoothieAddCartBtn = By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[7]/figure/mat-card/div[2]/button");
	By addtoCartSuccessMsg = By.xpath("//*[@id=\"cdk-overlay-11\"]/snack-bar-container");
	By basketBtn = By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]");
	By basketItem1 = By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-basket/mat-card/app-purchase-basket/mat-table/mat-row/mat-cell[2]");
	By basketItemCount = By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]/span/span[2]");
	//By ckOutBtn = By.xpath("//*[@id=\"checkoutButton\"]");
	By addressRadioBtn1 = By.xpath("//*[@id=\"mat-radio-40\"]/label/div[1]/div[1]");
	By proceedtoDeliveryOptionBtn = By.xpath("//*[@id=\"card\"]/app-address/mat-card/button");
	By oneDayDeliveryRadioBtn = By.xpath("//*[@id=\"mat-radio-43\"]/label/div[1]/div[1]");
	By proceedtoPayBtn = By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-delivery-method/mat-card/div[4]/button[2]");
	By cc1 = By.xpath("//*[@id=\"mat-radio-46\"]/label/div[1]/div[1]");
	By proceedToOrderSummaryBtn = By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-payment/mat-card/div/div[2]/button[2]");
	By placeOrderBtn = By.xpath("//*[@id=\"checkoutButton\"]");
	public void clickOnGreenSmoothieAddCart() {
		driver.findElement(greenSmoothieAddCartBtn).click();
	}
	
	public void clickOnBasketBtn() {
		driver.findElement(basketBtn).click();
	}
	
//	public void clickOnCheckOutBtn() {
//		//driver.findElement(ckOutBtn).click();
//		clickOnElement(driver.findElement(ckOutBtn));
//	}
	
	public void clickOnAddressRadioBtn1() {
		//driver.findElement(addressRadioBtn1).click();
		clickOnElement(driver.findElement(addressRadioBtn1));
	}
	
	public void clickOnOneDayDel() {
		clickOnElement(driver.findElement(oneDayDeliveryRadioBtn));
	}
	
	public void waitOnItemBasketListDisplay() {
		WebElement el = driver.findElement(basketItem1);
		waituntilElementisVisible(el);
		System.out.println("element is visible: ");
	}
	
	public int getBasketItemCount() {
		return Integer.parseInt(driver.findElement(basketItemCount).getText()); 
	}
	
	public void waitUntilItemAddedinBasket() {
		WebElement el = driver.findElement(addtoCartSuccessMsg);
		waituntilElementisVisible(el);
		System.out.println("element added");
	}
	
	public void clickOnProceedToDeliveryOption() {
		driver.findElement(proceedtoDeliveryOptionBtn).click();
	}
	
	public void clickOnProceedToOrderSummary() {
		driver.findElement(proceedToOrderSummaryBtn).click();
	}
	
	public void clickOnProceedToPayBtn() {
		//driver.findElement(proceedtoPayBtn).click();
		clickOnElement(driver.findElement(proceedtoPayBtn));
	}
	
	public void clickOnFirstCCOption() {
		
		clickOnElement(driver.findElement(cc1));
	}
	
	public void clickOnPlaceOrderBtn() {
		driver.findElement(placeOrderBtn).click();
	}

}
