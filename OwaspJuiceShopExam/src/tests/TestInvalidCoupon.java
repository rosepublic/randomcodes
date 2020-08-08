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

public class TestInvalidCoupon extends BaseClass {

	LoginPage loginpage;
	ShopPage shoppage;
	BasketPage basketpage;
	AddressPage addpage;
	DeliveryMethodPage deliverypage;
	PaymentOptionPage payoptionpage;

	public ExtentTest testInvalidCoupon(MainTestRunner mtr) {

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
		mtr.test.log(LogStatus.PASS, "Login Successful");

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
		mtr.test.log(LogStatus.PASS, "Check Out Successful");

		addpage = new AddressPage();
		addpage.driver = basketpage.driver;
		addpage.clickOnAddressRadioBtn1();
		addpage.pause5seconds();
		addpage.clickOnProceedToDeliveryOption();
		addpage.pause5seconds();
		mtr.test.log(LogStatus.PASS, "Delivery Address Confirmation, Successful");

		DeliveryMethodPage deliverypage = new DeliveryMethodPage();
		deliverypage.driver = addpage.driver;
		deliverypage.clickOnOneDayDel();
		deliverypage.pause5seconds();
		deliverypage.clickOnProceedToPayBtn();
		deliverypage.pause5seconds();
		mtr.test.log(LogStatus.PASS, "Delivery Speed Confirmation, Successful");

		PaymentOptionPage payoptionpage = new PaymentOptionPage();
		payoptionpage.driver = deliverypage.driver;
		payoptionpage.clickOnCouponExpandBtn();
		payoptionpage.pause5seconds();
		payoptionpage.sendkeysCouponInput();
		payoptionpage.pause5seconds();
		payoptionpage.clickOnRedeemBtn();
		payoptionpage.pause5seconds();
		
		if (payoptionpage.getInvalidCouponMessage().trim().equalsIgnoreCase("Invalid coupon.")) {
			mtr.test.log(LogStatus.PASS, "Method of Payment: Invalid Coupon. Confirmed Invalid");
			mtr.takeScreenShot(payoptionpage.driver, mtr.sspath + "\\passInvalidCoupon.png");
			mtr.test.log(LogStatus.INFO,
					"Snapshot below: " + mtr.test.addScreenCapture(mtr.sspath + "\\passInvalidCoupon.png"));
		}else {
			mtr.test.log(LogStatus.FAIL, "Method of Payment: Invalid Coupon. Redeem Processed.");
			mtr.takeScreenShot(payoptionpage.driver, mtr.sspath + "\\failInvalidCoupon.png");
			mtr.test.log(LogStatus.INFO,
					"Snapshot below: " + mtr.test.addScreenCapture(mtr.sspath + "\\failInvalidCoupon.png"));
		}
			
		payoptionpage.driver.quit();

		return mtr.test;
	}
}
