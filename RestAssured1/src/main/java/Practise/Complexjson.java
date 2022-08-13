package Practise;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;

import Files.Payload;
import Files.Reusable;

public class Complexjson 
{

	
	public static JsonPath rawjson1(String json)
	{
		JsonPath js =new JsonPath(json);
		
		
		return js;
	}
}
