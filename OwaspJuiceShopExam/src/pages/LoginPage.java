package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	 
	 By closeModalButton = By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]");
	 By email = By.xpath("//*[@id=\"email\"]");
	 By password = By.xpath("//*[@id=\"password\"]");
	 By loginButton = By.xpath("//*[@id=\"loginButton\"]");
	 By dismissCookieBtn = By.xpath("/html/body/div[1]/div/a");
	 
	 public void clickCloseModalButton() {
		 //driver.findElement(closeModalButton).click();
		 clickOnElement(driver.findElement(closeModalButton));
	 }
	 
	 public void sendKeysToEmail() {
		 driver.findElement(email).sendKeys("test@test.com");
	 }
	 
	 public void sendKeysTopassword() {
		 driver.findElement(password).sendKeys("abcd1234");
	 }
	 
	 public void clickOnLoginButton() {
		 clickOnElement(driver.findElement(loginButton));
	 }
	 
	 public void clickOnDismissCookieBtn() {
		 clickOnElement(driver.findElement(dismissCookieBtn));
	 }
}
