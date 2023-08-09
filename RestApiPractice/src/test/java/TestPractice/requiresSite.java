package TestPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class requiresSite {

	
	 @Test(priority=1,enabled=false) 
	public void getUserpage2() {
	  given().when().get("https://reqres.in/api/users?page=2")
	  .then().statusCode(200) .body("page", equalTo(2)) .log() .all(); }
	 
	 // @Test
	  public void getUserPage1() {
		  given().when().get("https://reqres.in/api/users?page=1")
		  .then().statusCode(200) .body("page", equalTo(1)) .log() .all(); }
		 
	// @Test(enabled=true)
	  public void getsingleUser() {
		  given().when().get("https://reqres.in/api/users/1")
		  .then().statusCode(200)
		  .header("Content-Type", "application/json; charset=utf-8")
		  .body("x.data.email", equalTo("george.bluth@reqres.in"))
		  .body("x.data.first_name", equalTo("George"))
		  .log() .all(); 
		  }
	  
	 // @Test
	  public void getsingleUserNOT_Found() {
		  given().when().get("https://reqres.in/api/users/23")
		  .then().statusCode(404) .log() .all(); }
		 
	  
	@Test
	public void CreateReqPOST() {

		HashMap data = new HashMap();
		data.put("email", "Harry@gmail.com");
		data.put("first_name", "Harry");

		Response res=given()
		   .contentType("application/json")
		    .body(data)
		.when()
		    .post("https://reqres.in/api/users");
		System.out.println(res.asString());
		   String email= res.jsonPath().get("email").toString();
		   Assert.assertEquals(email, "Harry@gmail.com");
	}
	//@Test
	public void UpdateReqID2() {

		HashMap data = new HashMap();
		data.put("email", "HarryPotter@gmail.com");
		data.put("first_name", "Harry");

		given()
		   .contentType("application/json")
		    .body(data)
		.when()
		    .put("https://reqres.in/api/users/2")
		.then()
				.statusCode(200).log().all();
	}
	//@Test
	public void UpdateReqID2Using_Patch() {

		HashMap data = new HashMap();
		data.put("email", "madhu123@gmail.com");
		data.put("first_name", "Madhu");

		given()
		   .contentType("application/json")
		    .body(data)
		.when()
		    .patch("https://reqres.in/api/users/2")
		.then()
				.statusCode(200).log().all();
	}
	
	//@Test
	public void DeleteUser2() {

		
		given()
		   .contentType("application/json")
		.when()
		    .delete("https://reqres.in/api/users/2")
		.then()
				.statusCode(204).log().all();
	}
	//@Test
		public void RegesterUser_Valid() {

			HashMap data = new HashMap();
			data.put("email", "eve.holt@reqres.in");
			data.put("password", "pistol");

			given()
			   .contentType("application/json")
			    .body(data)
			.when()
			    .post("https://reqres.in/api/register")
			.then()
					.statusCode(200).log().all();
		}
	
	//@Test
	public void RegesterUser_InValid() {

		HashMap data = new HashMap();
		data.put("email", "madhu@gmail");
		data.put("password", "pistol");

		given()
		   .contentType("application/json")
		    .body(data)
		.when()
		    .post("https://reqres.in/api/register")
		.then()
				.statusCode(400).log().all();
	}
	
	//@Test
	public void RegesterUser_WithOut_PWD_InValid() {

		HashMap data = new HashMap();
		data.put("email", "madhu@gmail");

		given()
		   .contentType("application/json")
		    .body(data)
		.when()
		    .post("https://reqres.in/api/register")
		.then()
				.statusCode(400).log().all();
	}
	//@Test
	public void ValidUser_Login() {

		HashMap data = new HashMap();
		data.put("email", "eve.holt@reqres.in");
		data.put("password", "cityslicka");

		given()
		   .contentType("application/json")
		    .body(data)
		.when()
		    .post("https://reqres.in/api/login")
		.then()
				.statusCode(200).log().all();
	}
	//@Test
	public void InValidUser_Login() {

		HashMap data = new HashMap();
		data.put("email", "madhu@reqres.in");

		given()
		   .contentType("application/json")
		    .body(data)
		.when()
		    .post("https://reqres.in/api/login")
		.then()
				.statusCode(400).log().all();
	}
	//@Test
	public void provideDelay_toLogin() {

		HashMap data = new HashMap();
		data.put("email", "eve.holt@reqres.in");
		data.put("password", "cityslicka");

		given()
		   .contentType("application/json")
		    .body(data)
		.when()
		    .post("https://reqres.in/api/login?delay=3")
		.then()
				.statusCode(200).log().all();
	}
	//@Test
	public void provideDelay_ListUser() {

		given()
		   .contentType("application/json")
		.when()
		    .get("https://reqres.in/api/users?delay=3")
		.then()
				.statusCode(200).log().all();
	}
	
	

}
