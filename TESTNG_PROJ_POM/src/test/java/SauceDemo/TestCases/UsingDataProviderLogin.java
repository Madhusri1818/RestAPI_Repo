package SauceDemo.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SauceDemo.BaseClass.BaseClass;
import SauceDemo.DriverFactory.BaseDriver;
import SauceDemo.Utilites.ExcelDataRead;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(SauceDemo.BaseClass.ListenersClass.class)
public class UsingDataProviderLogin extends BaseClass {
	WebDriver driver;
	@Test(dataProvider = "LoginData")
	public void login(String username,String password) {
		
		driver=BaseDriver.driver;
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		test.log(LogStatus.PASS, "User fetch data from Excel"+username +"and" +password);
		driver.findElement(By.id("login-button")).click();
		test.log(LogStatus.PASS, "Click on login");
	}
	
	@DataProvider(name="LoginData")
	public Object[][] DataSet() throws FileNotFoundException {
		//taking data from excel
		ExcelDataRead path=new ExcelDataRead(".//TestData//LoginDataSauceDemo.xlsx");
		int rows=path.getRowcount(0);
		Object[][] Data=new Object[rows][2];
		
		for(int i=1;i<rows;i++) {
			//Applicable only for 2 dimensions
			Data[i][0]=path.getData(0, i, 0);
			Data[i][1]=path.getData(0, i, 1);
		}
		return Data;
		
		
	//taking data set directly	
	/*	//Array of 3 rows and 2 columns
		Object[][] data=new Object[3][2];
		//first row first column
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		data[1][0]="problem_user";
		data[1][1]="secret_sauce";
		data[2][0]="locked_out_user";
		data[2][1]="secret_sauce";
		//return the array of object (data)to test script
		return data;
		*/
	}

}
