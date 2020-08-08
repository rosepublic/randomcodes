package tests;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import main.MainTestRunner;
import pages.AddressPage;
import pages.BasketPage;
import pages.DeliveryMethodPage;
import pages.LoginPage;
import pages.OrderSummaryPage;
import pages.PaymentOptionPage;
import pages.ShopPage;

public class TestOrderViaFastDelivery extends BaseClass{

	LoginPage loginpage;
	ShopPage shoppage;
	BasketPage basketpage;
	AddressPage addpage;
	DeliveryMethodPage deliverypage;
	PaymentOptionPage payoptionpage;
	OrderSummaryPage ordsumpage;
	
public ExtentTest testorderviafastdelivery(MainTestRunner mtr) {
		
		loginpage = new LoginPage();
		loginpage.driver = mtr.driver;
		loginpage.setup();
		loginpage.setupReports();
		loginpage.clickCloseModalButton();
		loginpage.clickOnDismissCookieBtn();
		loginpage.sendKeysToEmail();
		loginpage.sendKeysTopassword();
		loginpage.clickOnLoginButton();
		loginpage.waitfornextpagetoload();
		mtr.test.log(LogStatus.PASS,"Login Successful");
     

		shoppage = new ShopPage();
		shoppage.driver = loginpage.driver;
		shoppage.clickOnFruitPressAddCartBtn();
		mtr.test.log(LogStatus.PASS, "Add item to Cart Successful");
		shoppage.pause5seconds();
		shoppage.clickOnBasketBtn();
		shoppage.pause5seconds();
		
		basketpage = new BasketPage();
		basketpage.driver = shoppage.driver;
		basketpage.clickOnCheckOutBtn();
		basketpage.pause5seconds();
		mtr.test.log(LogStatus.PASS,"Check Out Successful");
		
		addpage = new AddressPage();
		addpage.driver = basketpage.driver;
		addpage.clickOnAddressRadioBtn1();
		addpage.pause5seconds();
		addpage.clickOnProceedToDeliveryOption();	
		addpage.pause5seconds();
		mtr.test.log(LogStatus.PASS,"Delivery Address Confirmation, Successful");
		
		DeliveryMethodPage deliverypage = new DeliveryMethodPage();
		deliverypage.driver = addpage.driver;
		deliverypage.pause5seconds();
		deliverypage.clickOnfastDelivery();
		deliverypage.pause5seconds();	
		deliverypage.clickOnProceedToPayBtn();
		deliverypage.pause5seconds();
		mtr.test.log(LogStatus.PASS,"Delivery Speed: Fast Delivery. Confirmed Successful");
		
		PaymentOptionPage payoptionpage = new PaymentOptionPage();
		payoptionpage.driver = deliverypage.driver;
		payoptionpage.clickOnFirstCCOption();
		payoptionpage.pause5seconds();
		payoptionpage.clickOnProceedToOrderSummary();
		payoptionpage.pause5seconds();
		mtr.test.log(LogStatus.PASS,"Method of Payment: Credit Card. Confirmed Successful");
		
		OrderSummaryPage ordsumpage = new OrderSummaryPage();
		ordsumpage.driver = payoptionpage.driver;
		//ordsumpage.clickOnPlaceOrderBtn();
		mtr.test.log(LogStatus.PASS,"Order Placement Successful");
		pause5seconds();
        mtr.takeScreenShot(loginpage.driver,mtr.sspath + "\\passFastDelivery.png"); 
        mtr.test.log(LogStatus.INFO, "Snapshot below: " + mtr.test.addScreenCapture(mtr.sspath + "\\passFastDelivery.png"));
		ordsumpage.driver.quit();
		return mtr.test;		
}
}
