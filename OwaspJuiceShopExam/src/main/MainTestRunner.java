package main;

import base.BaseClass;
import tests.TestSuccessOrderViaCC;
import tests.TestSuccessOrderViaWallet;

public class MainTestRunner extends BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//TestLoginPage tlp = new TestLoginPage();
		//tlp.testloginpage();
		
		TestSuccessOrderViaCC sovcc = new TestSuccessOrderViaCC();
		sovcc.testSuccessOrderViaCC();
		
		TestSuccessOrderViaWallet sovw = new TestSuccessOrderViaWallet();
		sovw.testsuccessorderviawallet();
	}
	
	

}
