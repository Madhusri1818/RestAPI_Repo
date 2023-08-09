package SauceDemo.BaseClass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import SauceDemo.DriverFactory.BaseDriver;

public class BaseClass extends BaseDriver{
	public static ExtentTest test;
	public  static ExtentReports report;
	@BeforeSuite
	public void Launch_Browser() {
		 report = new ExtentReports(System.getProperty("user.dir")+"//target//sauceDemo.html");
		BaseDriver.Driver_Launch();
	}
@BeforeMethod
	public void UrL_Launch() {

	// test = report.startTest("ExtentDemo");
		driver.get("https://www.saucedemo.com/");
		System.out.println("before method"+ test);
	}

@AfterSuite
public void tearDown_Browser() {
	
	test.log(LogStatus.PASS, "TearDown bowser Successfully");
	report.endTest(test);
	report.flush();
	driver.quit();
}
}
