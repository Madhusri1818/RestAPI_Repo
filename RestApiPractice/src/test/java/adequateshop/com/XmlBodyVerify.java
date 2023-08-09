package adequateshop.com;

import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class XmlBodyVerify {
	//@Test
	public void testXmlBody() {
		given()
		.when().get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		//Response(payload) in the form of xml
		.contentType(ContentType.XML)
		.header("Content-Type", "application/xml; charset=utf-8")
		.statusCode(200)
		.body("TravelerinformationResponse.page", equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].email", equalTo("Developer12@gmail.com"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[1].name", equalTo("AS"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[1].email", equalTo("qweqw@mail.ru"))
		.log().all();
	}

	@Test
	public void Approch2() {
		Response data=given()
		.when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
		Assert.assertEquals(data.statusCode(),200);
		Assert.assertEquals(data.header("Content-Type"),"application/xml; charset=utf-8");
	String page=data.xmlPath().get("TravelerinformationResponse.page").toString();
	Assert.assertEquals(page, "1");
	String email=data.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].email").toString();
	Assert.assertEquals(email, "Developer12@gmail.com");
	}

}
