package TestPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class cookiesDemo {
//@Test
	void test_Cookies() {
		given()
		.when() 
		   .get("https://www.google.com/")
		.then()
		 .cookie("AEC", "Ad49MVFbKQWprP3tBl6kzQHbcadaKZG4IZ_W55S1nWKkOf0SgrlIATvIgRs")
		 
		.log().all();
		
	}
public class Get_cookiesInfo {
@Test
	void test_Cookies() {
		Response res=given()
		.when() 
		   .get("https://www.google.com/");
		//ending request and stored response in res
		//to store response of request ,we cant use then if we usen then() it go to next step..so response is not stoed
		//to get signle cookie value
		String Cookie_value=res.getCookie("AEC");//AEC is the cookie Name
		   System.out.println("The value of cookie is ===>"+Cookie_value);
		
		   //Get All Cookies INFO
		  Map<String,String> ListOfCookies= res.getCookies();
		  
		  System.out.println("fetch only Key values"+ListOfCookies.keySet());
		  //To get Values of keys use for loop
		  for(String k:ListOfCookies.keySet()) {
			  String CookieValue=res.getCookie(k);
			  System.out.println(k +"-->"+CookieValue);
		  }
	}
}
}
