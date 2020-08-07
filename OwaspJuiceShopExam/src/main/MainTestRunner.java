package main;

import base.BaseClass;
import tests.TestLoginPage;
import tests.TestSuccessOrderViaCC;

public class MainTestRunner extends BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//TestLoginPage tlp = new TestLoginPage();
		//tlp.testloginpage();
		
		TestSuccessOrderViaCC sovcc = new TestSuccessOrderViaCC();
		sovcc.testSuccessOrderViaCC();
	}
	
	

}
