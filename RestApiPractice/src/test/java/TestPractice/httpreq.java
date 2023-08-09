package TestPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class httpreq {
@org.testng.annotations.Test
	public void httpRequest() {
	given()
	.when().get("http://localhost:3000/Employ")
	.then().statusCode(200)
	 .header("Content-Type", "application/json; charset=utf-8")
	.log().headers();//print all response
	
	//log().cookies();//print only cookies in console
	
	//log().body();  //print only Response body
	
	//log().header();//print headers from response

}
}
