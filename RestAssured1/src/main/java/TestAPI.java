import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import Files.Payload;


public class TestAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	String response=	given().queryParam("key", "qaclick123")
	   .header("Content-Type","application/json")
	   .body(Payload.AddPlace())
	   .when().post("maps/api/place/add/json")
	   .then().statusCode(200).header("Content-Type", "application/json;charset=UTF-8")
	   .extract().response().asString();
	System.out.println();
	System.out.println(response);
	
	
		
		

	}

}
