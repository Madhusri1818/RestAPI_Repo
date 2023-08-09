package SauceDemo.Utilites;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import SauceDemo.DriverFactory.BaseDriver;

public class CommonMethods {
	public static String mainwindow_id;
	public static ArrayList<String> copeyall;
	
	public void Sent_txt_box(WebDriver driver,By element, String data) {
		
		//driver.findElement(element).clear();
		driver.findElement(element).sendKeys(data);

	}
	public void Click_function(WebDriver driver, By element) {
		
		driver.findElement(element).click();
	}
	public void Enter_with_Sendkeys(WebElement element, String s, WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
		element.sendKeys(s, Keys.ENTER);
	}

	public void keysclass(WebDriver driver,By element, Keys key) {
		driver.findElement(element).sendKeys(key);
	}

	public void move_to_element(WebDriver driver, By ele) {
		Actions act = new Actions(driver);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid yellow'", driver.findElement(ele));
		act.moveToElement(driver.findElement(ele)).perform();
	}

	public void Rightclick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid green'", element);
		act.contextClick(element).build().perform();
	}

	public void doubleclick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
		act.doubleClick(element).perform();
	}

	public void drag_drop(WebDriver driver, By drag, By drop) {
		Actions act = new Actions(driver);
		act.dragAndDrop(driver.findElement(drag), driver.findElement(drop)).perform();
	}

	public void selectByindex(WebDriver driver,By element, int index) {
		Select select = new Select(driver.findElement(element));
		select.selectByIndex(index);
	}

	public void selectByvalue(WebDriver driver,By element, String calue) {
		Select select = new Select(driver.findElement(element));
		select.selectByValue(calue);
	}

	public void selectBytext(WebDriver driver,By element, String text) {
		Select select = new Select(driver.findElement(element));
		select.selectByVisibleText(text);
	}

	public void desselectByindex(WebDriver driver,By element, int index) {
		Select select = new Select(driver.findElement(element));
		select.deselectByIndex(index);
	}

	public void desselectByvalue(WebDriver driver,By element, String calue) {
		Select select = new Select(driver.findElement(element));
		select.deselectByValue(calue);
	}

	public void deselectBytext(WebDriver driver,By element, String text) {
		Select select = new Select(driver.findElement(element));
		select.deselectByVisibleText(text);
	}

	public void switch_to_frame_by_Locator(WebDriver driver, By element) {
		driver.switchTo().frame(driver.findElement(element));
	}

	public void switch_to_frame_by_index(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void Switch_out_from_frame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void clcik_with_javascript(WebDriver driver, By element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].style.background='yellow'", driver.findElement(element));
		executor.executeScript("arguments[0].click();", driver.findElement(element));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Findwindowsids(WebDriver driver) {
		mainwindow_id = driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();
		copeyall = new ArrayList<>(allids);

	}

	public WebDriver switch_to_window(WebDriver driver, int index) {
		driver.switchTo().window(copeyall.get(index));
		return driver;
	}

	public void alert_accept(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}

	public void alert_dismiss(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}

	public void alert_sendkeys(WebDriver driver, String text) {
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(text);
	}

	public void Drag_and_drop_with_axis(WebDriver driver, By slide, int x_axis, int y_axis) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(driver.findElement(slide), x_axis, y_axis).build().perform();
	}
	
	public void NavigateBack(WebDriver driver) throws Exception {
		Thread.sleep(2000);
		driver.navigate().back();
	}

}
