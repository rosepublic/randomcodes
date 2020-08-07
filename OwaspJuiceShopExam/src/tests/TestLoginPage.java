package tests;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.LoginPage;

public class TestLoginPage extends BaseClass {
LoginPage loginpage;
	public void testloginpage() {
        
        
		loginpage = new LoginPage();
		loginpage.setup();
		loginpage.test = loginpage.reports.startTest("TestLoginPage","Validate Login Page");
		loginpage.clickCloseModalButton();
		loginpage.sendKeysToEmail();
		loginpage.sendKeysTopassword();
		loginpage.clickOnLoginButton();
		loginpage.waitfornextpagetoload();
		loginpage.test.log(LogStatus.PASS,"Pass");
        loginpage.takeScreenShot(loginpage.driver); 
        loginpage.test.log(LogStatus.INFO, "Snapshot below: " + loginpage.test.addScreenCapture(loginpage.sspath));
		loginpage.reports.endTest(loginpage.test);
		loginpage.reports.flush();
		loginpage.quit();
	
	}
}
