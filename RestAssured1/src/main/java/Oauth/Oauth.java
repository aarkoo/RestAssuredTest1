package Oauth;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.Reusable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class Oauth {
	
	
	
	
	@Test
	public void test1()
	{
		
		RestAssured.baseURI="http://coop.apps.symfonycasts.com";
		
		String res1=
				 given()
				
				.formParam("client_id", "oauth1")
				.formParam("client_secret", "05ad175684ba110f9c90b7cfa5e57a43")
				.formParam("grant_type", "client_credentials")
				.when()
				.post("/token")
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		
		System.out.println("the res is"+" "+res1);
		
		JsonPath js= new JsonPath(res1);
	    String accesstoken=	js.get("access_token");
	    System.out.println();
	    System.out.println(accesstoken);
		
		
		/*	
	Response res=	RestAssured
		.given()
		.formParam("client_id", "oauth1")
		.formParam("client_secret", "05ad175684ba110f9c90b7cfa5e57a43")
		.formParam("grant_type", "client_credentials")
		.post("http://coop.apps.symfonycasts.com/token");
		
	System.out.println(res.jsonPath().prettify());
	
	System.out.println(res.getStatusCode());
	
	*/
		
	}

}
