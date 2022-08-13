package GooglemapAPIserialize;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.Reusable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class Serialize {

	public static void main(String[] args) 
	{
	
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Addplace add= new Addplace();
		add.setAccuracy(50);
		add.setAddress("29, side layout, cohen 09");
		add.setLanguage("hindi");
		add.setPhone_number("(+91) 983 893 3937");
		add.setWebsite("29, side layout, cohen 09");
		add.setName("Frontline house");
		
		List<String> mylist =new ArrayList<>();
		mylist.add("shoe park");
		mylist.add("shop");
		add.setTypes(mylist);
		
		location loc =new location();
		loc.setLng(-38.383494);
		loc.setLat(33.427362);
		add.setLocation(loc);
		
		
	String res=	given().queryParam("key", "qaclick123")
		.body(add)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
	
	System.out.println(res);
	
	
		

	}

}
