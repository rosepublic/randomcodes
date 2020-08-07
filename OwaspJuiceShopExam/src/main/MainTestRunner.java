package main;

import base.BaseClass;
import tests.TestSuccessOrderViaCC;
import tests.TestSuccessOrderViaWallet;

public class MainTestRunner extends BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//TestLoginPage tlp = new TestLoginPage();
		//tlp.testloginpage();
		
		MainTestRunner mtr = new MainTestRunner();
		mtr.setupReports();
		mtr.test = mtr.reports.startTest("TestSuccessOrderViaCC","Verify that able to order via cc");
		TestSuccessOrderViaCC sovcc = new TestSuccessOrderViaCC();
		sovcc.testSuccessOrderViaCC(mtr);
		mtr.reports.endTest(mtr.test);
		mtr.reports.flush();
		
		
		
		mtr.test = mtr.reports.startTest("TestSuccessOrderViaWallet","Verify that able to order via Wallet");
		TestSuccessOrderViaWallet sovw = new TestSuccessOrderViaWallet();
		sovw.testsuccessorderviawallet(mtr);
		mtr.reports.endTest(mtr.test);
		mtr.reports.flush();
	}
	
	

}
