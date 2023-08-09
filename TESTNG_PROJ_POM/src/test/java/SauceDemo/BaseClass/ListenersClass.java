package SauceDemo.BaseClass;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import SauceDemo.DriverFactory.BaseDriver;
import io.qameta.allure.Allure;

public class ListenersClass implements  ITestListener {
	
	String dest;
	@Override
	public void onTestStart(ITestResult result) {
System.out.println("on test start test");
		//BaseClass.report = new ExtentReports(System.getProperty("user.dir")+"//target//" +result.getName()+".html");
		 BaseClass.test =BaseClass.report.startTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot sc = (TakesScreenshot)BaseDriver.driver;
		File srcFile = sc.getScreenshotAs(OutputType.FILE);
		String dest=".//screenshot//"+result.getName() + ".png";
		try {
			FileUtils.copyFile(srcFile,
					new File(".//screenshot//"
							+ result.getName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String screenshot = result.getName().replaceAll(" ", "_");
		//Add sc shot Allure report
		byte[] srcfile = ((TakesScreenshot)BaseDriver.driver).getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment(result.getName()+"Test skipped", new ByteArrayInputStream(((TakesScreenshot)BaseDriver.driver).getScreenshotAs(OutputType.BYTES)));
		//Add sc shot in ExtentReport
		BaseClass.test.log(LogStatus.FAIL, BaseClass.test.addScreenCapture(dest));
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Allure.addAttachment(result.getName()+"Test skipped", new ByteArrayInputStream(((TakesScreenshot)BaseDriver.driver).getScreenshotAs(OutputType.BYTES)));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		Allure.addAttachment(context.getName()+"Test skipped", new ByteArrayInputStream(((TakesScreenshot)BaseDriver.driver).getScreenshotAs(OutputType.BYTES)));
	
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
