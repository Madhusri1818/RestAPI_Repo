package TestPractice;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersValidate {
	public class Get_HeaderInfo_Validate {
		@Test
			void test_Headers() {
				given()
				.when() 
				   .get("https://www.google.com/")
				.then()
				//header validation header value and expected value
				 .header("Content-Type", "text/html; charset=ISO-8859-1")
				//Not mandatory but used for further of then()
				 .and()
				 .header("Content-Encoding", "gzip")
				.and()
				 .header("Server", "gws")
				//get only headers in console
				   .log().headers();
				
				
				 
			}
		//@Test
		void Get_SinleHeader() {
			Response headerRes=given()
			.when() 
			   .get("https://www.google.com/");
			
			headerRes.getHeader("Content-Type");
			System.out.println(headerRes.getHeader("Date"));
			String headerValues=headerRes.getHeader("Content-Type");
			System.out.println("Get single header value of Content-type is : "+ headerValues);
			
			}
		//@Test
		void Get_ListOf_Header() {
			Response headerRes=given()
			.when() 
			   .get("https://www.google.com/");
			Headers listofHeaders=headerRes.getHeaders();  
			//headers return type is Header-each headers having its own name and value
			//Header->Single Name and Value
			//Headers->Multiple Names and Values
			for(Header hd:listofHeaders) {
				System.out.println(hd.getName()+"   "+hd.getValue());
				
			}
			}
}
}
