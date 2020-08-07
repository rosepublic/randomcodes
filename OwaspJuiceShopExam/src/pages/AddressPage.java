package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class AddressPage extends BaseClass{

	By addressRadioBtn1 = By.xpath("//*[@id=\"mat-radio-40\"]/label/div[1]/div[1]");
	By proceedtoDeliveryOptionBtn = By.xpath("//*[@id=\"card\"]/app-address/mat-card/button");
	
	public void clickOnAddressRadioBtn1() {
		clickOnElement(driver.findElement(addressRadioBtn1));
	}
	
	public void clickOnProceedToDeliveryOption() {
		driver.findElement(proceedtoDeliveryOptionBtn).click();
	}
}
