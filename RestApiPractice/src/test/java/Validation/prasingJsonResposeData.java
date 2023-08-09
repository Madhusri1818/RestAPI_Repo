package Validation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class prasingJsonResposeData {
	@Test(enabled=false)
	void MyData() {
		given()
		.when().get("http://localhost:3000/Employ")
		.then().statusCode(200)
		.contentType("application/json; charset=utf-8")
		.body("x.Employ[2].job",equalTo("Madhusri"))
		.log().all();
	}
	@Test(enabled=true)
	void Approch2() {
		//storing Response in variable
		Response data=given()
				.contentType("application/json; charset=utf-8")
		.when().get("http://localhost:3000/Employ");
		//validate status code
		Assert.assertEquals(data.getStatusCode(), 200);
		//Validate Header
		Assert.assertEquals(data.header("Content-Type"),"application/json; charset=utf-8");
		
		System.out.println(data.asString());
	    String Job_title=data.jsonPath().get("job[2]").toString();
	    System.out.println(Job_title);
	}

}
