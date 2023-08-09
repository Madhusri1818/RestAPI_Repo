package SauceDemo.Webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SauceDemo.DriverFactory.BaseDriver;
import SauceDemo.Utilites.CommonMethods;

public class LoginPage {
	WebDriver driver;
	CommonMethods ele;
	//CommonMethods ele=new CommonMethods();
	public  LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	By UserName_txt=By.id("user-name");
	By Password_txt=By.name("password");
	By Login_btn=By.id("login-button");
	By Add_cart_btn=By.id("add-to-cart-sauce-labs-backpack");
	By Shopping_cat_lnk=By.xpath("//a[@class='shopping_cart_link']");
	By Remove_prod=By.id("remove-sauce-labs-backpack");
	By Continue_shopping_btn=By.id("continue-shopping");
By Drop_Filter=By.xpath("//select[@class='product_sort_container']");
By Menu_btn=By.id("react-burger-menu-btn");
By About_lnk=By.xpath("//a[text()='About']");
By Solution_aboutLnk=By.xpath("//span[text()='Solutions']");

public void Click_aboutLnk() {
	ele.Click_function(driver, Menu_btn);
	ele.Click_function(driver, About_lnk);
}
public void click_movetoSolution() throws Exception {
	ele.move_to_element(driver, Solution_aboutLnk);
	
	ele.NavigateBack(driver);
}
	public void LoginFun(String UName,String pwd) {
		 ele=new CommonMethods();
		//driver.findElement(UserName_txt).sendKeys("");
		ele.Sent_txt_box(driver, UserName_txt, UName);
		ele.Sent_txt_box(driver, Password_txt, pwd);
		ele.Click_function(driver, Login_btn);
		
	}
	
	public void Click_Add_cart_btn() {
		ele.Click_function(driver, Add_cart_btn);
	}
	public void Click_ShoppingCart_btn() {
		ele.Click_function(driver, Shopping_cat_lnk);
	}
	public void Remove_Product() {
		ele.Click_function(driver, Remove_prod);
	}
	public void click_continue_shopping() {
		ele.Click_function(driver, Continue_shopping_btn);
	}
	public void SelectDropDownByselectValue() {
		ele.selectBytext(driver, Drop_Filter, "Price (low to high)");
	}
	
	
}
