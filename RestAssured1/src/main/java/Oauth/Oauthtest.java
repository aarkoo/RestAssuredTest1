package Oauth;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.Reusable;
import Serialization.Getcourse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class Oauthtest {

	
	public static void main(String[] args) {
		
		
	String accesstokenres=	given().
		 queryParam("code", "")
	    .queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	    .queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
	    .queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
	    .queryParam("grant_type", "https://rahulshettyacademy.com/getCourse.php")
	    .when().log().all().post("https://www.googleapis.com/oauth2/v4/token")
	    .asString();
	
	JsonPath js =new JsonPath(accesstokenres);
	String accesstoken=js.getString("access_token");

		
		
		
	Getcourse res=	given().queryParam("access_token", accesstoken)
			   .when().get("https://rahulshettyacademy.com/getCourse.php")
		
		       .then().assertThat().statusCode(200)
		       .extract().response().as(Getcourse.class);
	
	res.getCourses();
		
	}
}
