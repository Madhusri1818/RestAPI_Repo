package Validation;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ValidateResponse {
	// @Test
	void Approch2() {
		// storing Response in variable
		Response data = given().contentType("application/json; charset=utf-8").when().get("http://localhost:3000/Book");
		// validate status code
		Assert.assertEquals(data.getStatusCode(), 200);
		// Validate Header
		Assert.assertEquals(data.header("Content-Type"), "application/json; charset=utf-8");

		System.out.println(data.asString());
		String title = data.jsonPath().get("title[1]").toString();
		System.out.println(title);
		Assert.assertEquals(title, "Hidden love");
	}

	// @Test
	void GetAllTitles() {
		Response data = given().contentType(ContentType.JSON).when().get("http://localhost:3000/Title");

		// By using JSONObject Class

		JSONObject JO = new JSONObject(data.asString());
		// using for loop to get all titles form json response
		for (int i = 0; i < JO.getJSONArray("Books").length(); i++) {
			String Book_title = JO.getJSONArray("Books").getJSONObject(i).get("title").toString();
			System.out.println(Book_title);
		}
	}

	@Test
	void ValidateSingleTitle() {
		Response data = given().contentType(ContentType.JSON).when().get("http://localhost:3000/Title");
//validate title of book is present or not
		boolean status = false;
		JSONObject JO = new JSONObject(data.asString());
		for (int i = 0; i < JO.getJSONArray("Books").length(); i++) {
			String Book_title = JO.getJSONArray("Books").getJSONObject(i).get("title").toString();
			System.out.println(Book_title);
			if (Book_title.equals("The lord of the kings")) {
				status = true;
				break;
			}
			
		}
		Assert.assertEquals(status, true);
		
		//check price
		double totalprice=0;
		for (int i = 0; i < JO.getJSONArray("Books").length(); i++) {
			String price = JO.getJSONArray("Books").getJSONObject(i).get("price").toString();
			System.out.println(price);
			//totalprice= totalprice +price;
			
		
	}

}
}
