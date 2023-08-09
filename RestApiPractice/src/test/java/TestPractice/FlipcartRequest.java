package TestPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class FlipcartRequest {
	@Test
 public void getReq() {
	 given()
	 .when().get("https://rukminim1.flixcart.com/image/312/312/l2jcccw0/mobile/g/l/5/-original-imagdu8j9k3ejjc3.jpeg?q=70")
	 .then().statusCode(200).log().all();
 }
}
