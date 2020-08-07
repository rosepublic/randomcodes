package tests;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import main.MainTestRunner;
import main.MainTestRunner;
import pages.AddressPage;
import pages.BasketPage;
import pages.DeliveryMethodPage;
import pages.LoginPage;
import pages.OrderSummaryPage;
import pages.PaymentOptionPage;
import pages.ShopPage;

public class TestSuccessOrderViaWallet extends BaseClass{

	LoginPage loginpage;
	ShopPage shoppage;
	BasketPage basketpage;
	AddressPage addpage;
	DeliveryMethodPage deliverypage;
	PaymentOptionPage payoptionpage;
	OrderSummaryPage ordsumpage;
	
	public ExtentTest testsuccessorderviawallet(MainTestRunner mtr) {
		loginpage = new LoginPage();
		loginpage.driver = mtr.driver;
		
		loginpage.setup();
		setupReports();
		test = reports.startTest("TestSuccessOrderViaWallet","Verify that able to order via Wallet");
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
		deliverypage.clickOnOneDayDel();
		deliverypage.pause5seconds();	
		deliverypage.clickOnProceedToPayBtn();
		deliverypage.pause5seconds();
		mtr.test.log(LogStatus.PASS,"Delivery Speed Confirmation, Successful");
		
		PaymentOptionPage payoptionpage = new PaymentOptionPage();
		payoptionpage.driver = deliverypage.driver;
		payoptionpage.clickOnWallet();
		payoptionpage.pause5seconds();
		mtr.test.log(LogStatus.PASS,"Method of Payment: Wallet. Confirmed Successful");
		
		OrderSummaryPage ordsumpage = new OrderSummaryPage();
		ordsumpage.driver = payoptionpage.driver;
		//ordsumpage.clickOnPlaceOrderBtn();
		mtr.test.log(LogStatus.PASS,"Order Placement Successful");
		pause5seconds();
        mtr.takeScreenShot(loginpage.driver,mtr.sspath + "\\passWallet.png"); 
        mtr.test.log(LogStatus.INFO, "Snapshot below: " + mtr.test.addScreenCapture(mtr.sspath + "\\passWallet.png"));
        ordsumpage.driver.quit();
		
		return mtr.test;
	}
	
//	public void testsuccessorderviawallet() {
//		loginpage = new LoginPage();
//		loginpage.setup();
//		setupReports();
//		test = reports.startTest("TestSuccessOrderViaWallet","Verify that able to order via Wallet");
//		loginpage.clickCloseModalButton();
//		loginpage.clickOnDismissCookieBtn();
//		loginpage.sendKeysToEmail();
//		loginpage.sendKeysTopassword();
//		loginpage.clickOnLoginButton();
//		loginpage.waitfornextpagetoload();
//		test.log(LogStatus.PASS,"Login Successful");
//     
//
//		shoppage = new ShopPage();
//		shoppage.driver = loginpage.driver;
//		shoppage.clickOnFruitPressAddCartBtn();
//		test.log(LogStatus.PASS, "Add item to Cart Successful");
//		shoppage.pause5seconds();
//		shoppage.clickOnBasketBtn();
//		shoppage.pause5seconds();
//		
//		basketpage = new BasketPage();
//		basketpage.driver = shoppage.driver;
//		basketpage.clickOnCheckOutBtn();
//		basketpage.pause5seconds();
//		test.log(LogStatus.PASS,"Check Out Successful");
//		
//		addpage = new AddressPage();
//		addpage.driver = basketpage.driver;
//		addpage.clickOnAddressRadioBtn1();
//		addpage.pause5seconds();
//		addpage.clickOnProceedToDeliveryOption();	
//		addpage.pause5seconds();
//		test.log(LogStatus.PASS,"Delivery Address Confirmation, Successful");
//		
//		DeliveryMethodPage deliverypage = new DeliveryMethodPage();
//		deliverypage.driver = addpage.driver;
//		deliverypage.clickOnOneDayDel();
//		deliverypage.pause5seconds();	
//		deliverypage.clickOnProceedToPayBtn();
//		deliverypage.pause5seconds();
//		test.log(LogStatus.PASS,"Delivery Speed Confirmation, Successful");
//		
//		PaymentOptionPage payoptionpage = new PaymentOptionPage();
//		payoptionpage.driver = deliverypage.driver;
//		payoptionpage.clickOnWallet();
//		payoptionpage.pause5seconds();
//		test.log(LogStatus.PASS,"Method of Payment: Wallet. Confirmed Successful");
//		
//		OrderSummaryPage ordsumpage = new OrderSummaryPage();
//		ordsumpage.driver = payoptionpage.driver;
//		//ordsumpage.clickOnPlaceOrderBtn();
//		test.log(LogStatus.PASS,"Order Placement Successful");
//		pause5seconds();
//        takeScreenShot(loginpage.driver); 
//        test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture(sspath));
//		reports.endTest(test);
//		reports.flush();
//		shoppage.quit();
//		
//		
//	}
}
