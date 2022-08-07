package JIRA;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;

import Files.Payload;
import Files.Reusable;

public class CreateIssue 
{

	public static void main(String[] args) {
		
		
		
		
		
		RestAssured.baseURI="http://localhost:8080/";
		
		SessionFilter session =new SessionFilter();
		//login JIRA
	     String response=given().header("Content-Type","application/json")
		.body("{\"username\":\"aakashh92\",\"password\":\"Abcdefgh1@\"}").log().all().filter(session).when()
		.post("rest/auth/1/session").then().extract().response().asString();
	
		
		 given().pathParam("key", 10005).log().all().header("Content-Type","application/json")
		.body("{\"body\":\"Akashcomment.\",\"visibility\":{\"type\":\"role\",\"value\":\"Administrators\"}}").filter(session).when()
		.post("rest/api/2/issue/{key}/comment").then().assertThat().statusCode(201)
		.log().all();
		
		
		
	}
}
