package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ShopPage extends BaseClass {
	
	By greenSmoothieAddCartBtn = By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[7]/figure/mat-card/div[2]/button");
	By basketBtn = By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[4]");
	
	public void clickOnGreenSmoothieAddCart() {
		driver.findElement(greenSmoothieAddCartBtn).click();
	}
	
	public void clickOnBasketBtn() {
		driver.findElement(basketBtn).click();
	}
	
	


}
