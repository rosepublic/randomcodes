package main;

import base.BaseClass;
import tests.TestInvalidCoupon;
import tests.TestOrderViaFastDelivery;
import tests.TestSuccessOrderViaCC;
import tests.TestSuccessOrderViaWallet;

public class MainTestRunner extends BaseClass {

	public static void main(String[] args) {
		
		MainTestRunner mtr = new MainTestRunner();
		mtr.setupReports();
		
		
		//** Test 1**//		
		mtr.test = mtr.reports.startTest("TestSuccessOrderViaCC","Verify that able to order via cc");
		TestSuccessOrderViaCC sovcc = new TestSuccessOrderViaCC();
		sovcc.testSuccessOrderViaCC(mtr);
		mtr.reports.endTest(mtr.test);
		mtr.reports.flush();
		
		
		//** Test 2**//
		mtr.test = mtr.reports.startTest("TestSuccessOrderViaWallet","Verify that able to order via Wallet");
		TestSuccessOrderViaWallet sovw = new TestSuccessOrderViaWallet();
		sovw.testsuccessorderviawallet(mtr);
		mtr.reports.endTest(mtr.test);
		mtr.reports.flush();
		
		//**Test 3**//
		mtr.test = mtr.reports.startTest("TestOrderViaFastDelivery","Verify that able to order using Fast Delivery method");
		TestOrderViaFastDelivery ovfd = new TestOrderViaFastDelivery();
		ovfd.testorderviafastdelivery(mtr);
		mtr.reports.endTest(mtr.test);
		mtr.reports.flush();
		
		//**Test 4**//
		mtr.test = mtr.reports.startTest("TestInvalidCoupon","Verify that invalid coupons will not be redeemed");
		TestInvalidCoupon tic = new TestInvalidCoupon();
		tic.testInvalidCoupon(mtr);
		mtr.reports.endTest(mtr.test);
		mtr.reports.flush();
	}
	
	

}
