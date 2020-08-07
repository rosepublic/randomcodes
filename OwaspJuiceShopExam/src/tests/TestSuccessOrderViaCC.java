package tests;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.BasketPage;
import pages.LoginPage;
import pages.ShopPage;

public class TestSuccessOrderViaCC extends BaseClass{

	LoginPage loginpage;
	ShopPage shoppage;
	BasketPage basketpage;
	
	public void testSuccessOrderViaCC() {
		
		loginpage = new LoginPage();
		loginpage.setup();
		setupReports();
		test = reports.startTest("TestSuccessOrderViaCC","Verify that able to order via cc");
		loginpage.clickCloseModalButton();
		loginpage.clickOnDismissCookieBtn();
		loginpage.sendKeysToEmail();
		loginpage.sendKeysTopassword();
		loginpage.clickOnLoginButton();
		loginpage.waitfornextpagetoload();
		test.log(LogStatus.PASS,"Login Successful");
     
		
		
		shoppage = new ShopPage();
		shoppage.driver = loginpage.driver;
		shoppage.clickOnGreenSmoothieAddCart();
		test.log(LogStatus.PASS, "Add item to Cart Successful");
		shoppage.pause5seconds();
		if (shoppage.getBasketItemCount()  > 0) {
				shoppage.clickOnBasketBtn();
			}
		shoppage.pause5seconds();
		
		basketpage = new BasketPage();
		basketpage.driver = shoppage.driver;
		basketpage.clickOnCheckOutBtn();
		basketpage.pause5seconds();
		test.log(LogStatus.PASS,"Check Out Successful");
		shoppage.clickOnAddressRadioBtn1();
		shoppage.pause5seconds();
		shoppage.clickOnProceedToDeliveryOption();
		shoppage.pause5seconds();
		test.log(LogStatus.PASS,"Delivery Address Confirmation, Successful");
		shoppage.clickOnOneDayDel();
		shoppage.pause5seconds();
		test.log(LogStatus.PASS,"Delivery Speed Confirmation, Successful");
		shoppage.clickOnProceedToPayBtn();
		shoppage.pause5seconds();
		shoppage.clickOnFirstCCOption();
		shoppage.pause5seconds();
		shoppage.clickOnProceedToOrderSummary();
		test.log(LogStatus.PASS,"Method of Payment Confirmation, Successful");
		shoppage.pause5seconds();
		shoppage.clickOnPlaceOrderBtn();
		test.log(LogStatus.PASS,"Order Placement Successful");
		pause5seconds();
        takeScreenShot(loginpage.driver); 
        test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(sspath));
		reports.endTest(test);
		reports.flush();
		shoppage.quit();
		
		
	}
}
