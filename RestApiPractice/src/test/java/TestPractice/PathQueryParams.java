package TestPractice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathQueryParams {
	@Test
	void TestQueryPathPram() {
		
		//https://reqres.in/api/users?page=2&id=5
		given()
		 .pathParam("MyPath", "users")
		 .queryParam("page", 2)
		 .queryParam("id", 5)
		.when()
		 .get("https://reqres.in/api/{MyPath}")
		.then()
		 .statusCode(200)
		 .log().all();
	}

}
