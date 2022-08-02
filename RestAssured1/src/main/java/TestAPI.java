import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;

import Files.Payload;
import Files.Reusable;


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
	
	
	JsonPath js1= Reusable.rawtoJson(response);// for pasing json
	
	String placeid=js1.getString("place_id");
	
	System.out.println(placeid);
	Assert.assertEquals(placeid,"26ca20a30804e94b3f5e23daba7c9f83c02871a38061eff003f7b0ad40b59c72");
	
     JsonPath js2 = Reusable.rawtoJson(response);
	String OK=js2.getString("status");
	System.out.println(OK);
	
	//update place
	//PUT
	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body("{\"place_id\":\""+placeid+"\",\"address\":\"70Summerwalk,USA\",\"key\":\"qaclick123\"}")
	.when().put("maps/api/place/add/json")
	.then().assertThat().statusCode(200).log().all();
	
	//GET
	
	String getres=given().log().all().queryParam("key", "qaclick123")
	.queryParam("placeid=", placeid)
	.when().get("maps/api/place/get/json")
	.then().assertThat().log().all().statusCode(200).extract().asString();
	System.out.println("The res is"+getres);
	

	
	
		
		

	}

	private static JsonPath rawtoJson(String response) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
