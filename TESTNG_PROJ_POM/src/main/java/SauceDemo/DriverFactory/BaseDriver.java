package SauceDemo.DriverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	public static WebDriver driver;
	public static WebDriver Driver_Launch() {
		WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  return driver;
	}
}
