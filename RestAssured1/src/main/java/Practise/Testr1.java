package Practise;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Assert;

import Files.Payload;
import Files.Reusable;

public class Testr1 {
	
	public static String placeid;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
	String response=	given().
		queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(Practise.Payload.addplace())
		
		.when()
		.post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).header("Server", "Apache/2.4.41 (Ubuntu)").
		extract().response().asString();
	System.out.println();
	System.out.println(response);
		
		//Extract the output response from json body
	
	JsonPath json =new JsonPath(response);
	
 placeid=	json.get("place_id");
System.out.println("The placeid is"+ " "+placeid);

//update
String out=given().
queryParam("key", "qaclick123")
.header("Content-Type", "application/json")
.body("{\"place_id\":\""+placeid+"\",\"address\":\"70Summerwalk,USA\",\"key\":\"qaclick123\"}")
.when()
.put("/maps/api/place/update/json").then().assertThat().statusCode(200).header("Server", "Apache/2.4.41 (Ubuntu)").
extract().response().asString();

System.out.println(out);

	//get request

String get=given().
queryParam("key", "qaclick123")
.queryParam("place_id", placeid)
.header("Content-Type", "application/json")
.when()
.get("/maps/api/place/get/json")
.then().assertThat().statusCode(200).
extract().response().asString();
System.out.println();
System.out.println("get req is: "+get);

JsonPath j = JsonPaths.rawjson(get);
String address=j.getString("address");
System.out.println(address);
Assert.assertEquals(address, "70Summerwalk,USA");

		
		

	}

}
