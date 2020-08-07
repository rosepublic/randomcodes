package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class DeliveryMethodPage extends BaseClass {

	By oneDayDeliveryRadioBtn = By.xpath("//*[@id=\"mat-radio-43\"]/label/div[1]/div[1]");
	By proceedtoPayBtn = By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-delivery-method/mat-card/div[4]/button[2]");
	
	
	public void clickOnOneDayDel() {
		clickOnElement(driver.findElement(oneDayDeliveryRadioBtn));
	}
	
	public void clickOnProceedToPayBtn() {
		//driver.findElement(proceedtoPayBtn).click();
		clickOnElement(driver.findElement(proceedtoPayBtn));
	}
	
}
