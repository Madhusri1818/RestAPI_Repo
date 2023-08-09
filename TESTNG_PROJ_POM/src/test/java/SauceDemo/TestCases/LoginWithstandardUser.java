package SauceDemo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import SauceDemo.BaseClass.BaseClass;
import SauceDemo.Webelements.LoginPage;
@Listeners(SauceDemo.BaseClass.ListenersClass.class)
public class LoginWithstandardUser extends BaseClass{
	LoginPage data;
@Test
	public void Standard_user() throws Exception {
	test.log(LogStatus.PASS, "Lauch url");
	test.log(LogStatus.PASS, "Enter user name and password");
	 data=new LoginPage(driver);
		
	data.LoginFun("standard_user", "secret_sauce");
	test.log(LogStatus.PASS, "click on login");
	Thread.sleep(2000);
	data.SelectDropDownByselectValue();
		Thread.sleep(3000);
		data.Click_Add_cart_btn();
		Thread.sleep(3000);
		data.Click_ShoppingCart_btn();
		data.Remove_Product();
		data.click_continue_shopping();
		data.Click_aboutLnk();
		data.click_movetoSolution();
		
		}
@Test

public void problem_user() {
	 data=new LoginPage(driver);
	 data.LoginFun("problem_user", "secret_sauce");
	 
	 test.log(LogStatus.PASS, "Login with Problem user");
	//Assert.fail();
	//test.log(LogStatus.FAIL, "Login with Problem user");
}
}
