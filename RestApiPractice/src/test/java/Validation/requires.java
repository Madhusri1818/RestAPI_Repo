package Validation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class requires {
	 @Test(priority=1,enabled=true) 
		public void getUserpage2() {
		 Response data= given().when().get("http://localhost:3000/Title");
		  
		  JSONObject JO=new JSONObject(data.asString());
			//using for loop to get all titles form json response
			
			for(int i=0;i<JO.getJSONArray("Books").length();i++)
			{
				String Book_title=JO.getJSONArray("Books").getJSONObject(i).get("title").toString();
				System.out.println(Book_title);
			}
					
		  }
		 
}
