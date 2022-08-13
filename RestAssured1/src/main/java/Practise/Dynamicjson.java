
package Practise;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import Files.Reusable;

public class Dynamicjson {
	
	
	@Test
	public void addbook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		
String res=		given()
		.header("Content-Type", "application/json")
		.body("{\"name\":\"LearnAppiumAutomationwithJava\",\"isbn\":\"bced\",\"aisle\":\"2929\",\"author\":\"Johnfoe\"}")
		.when()
		.post("/Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();

System.out.println(res);
		
	}

}
