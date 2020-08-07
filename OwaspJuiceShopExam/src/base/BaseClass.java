package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	
	public WebDriver driver;
	File file;
	FileInputStream fis;
	public ExtentReports reports;
	public ExtentTest test;
	public String sspath;
	
	public BaseClass() {
		
	}
	
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://139.99.96.214:3000/#/login");
		
		reports = new ExtentReports(System.getProperty("user.dir") + "\\HtmlReport\\index.html", true);
		System.out.println("reports location: " + System.getProperty("user.dir") + "\\HtmlReport\\index.html");
		
		//sspath = System.getProperty("user.dir") + "\\HtmlReport\\pass.png";
		sspath = System.getProperty("user.dir") + "\\HtmlReport";
		
	}
	
	public void propertySetup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void implicitWait20() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void waituntilElementisVisible(WebElement el) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	
	public void pause5seconds() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setupReports() {
		reports = new ExtentReports(System.getProperty("user.dir") + "\\HtmlReport\\index.html", true);
		System.out.println("reports location: " + System.getProperty("user.dir") + "\\HtmlReport\\index.html");
		
		//sspath = System.getProperty("user.dir") + "\\HtmlReport\\pass.png";
		sspath = System.getProperty("user.dir") + "\\HtmlReport";
	}
	
	public void waitfornextpagetoload() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlMatches("http://139.99.96.214:3000/#/search"));
	
	}
	
	public void checknextpageloaded() {
		String homepagesearch = "http://139.99.96.214:3000/#/search";
	}
	
	
	public void quit() {
		driver.quit();
	}
	
	static JavascriptExecutor ex ;
	static Actions actions;
	
	public  void clickOnElement(WebElement elem) {
		ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();",elem);
	}
	
	public  void clickOnElementWithActions(WebElement elem) {
		
		actions = new Actions(driver);
		actions.moveToElement(elem).click().build().perform();
		
	}
	
	public void takeScreenShot( WebDriver driver, String sspath) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(sspath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

}
