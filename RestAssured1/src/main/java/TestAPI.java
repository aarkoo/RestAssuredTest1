import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class TestAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		given().queryParam("key", "qaclick123")
	   .header("Content-Type","application/json")
	   .body("{\"location\":{\"lat\":-38.383494,\"lng\":33.427362},\"accuracy\":50,\"name\":\"Frontlinehouse\",\"phone_number\":\"(+91)9838933937\",\"address\":\"29,sidelayout,cohen09\",\"types\":[\"shoepark\",\"shop\"],\"website\":\"http://google.com\",\"language\":\"French-IN\"}")
	   .when().post("maps/api/place/add/json")
	   .then().log().all().assertThat().statusCode(200);
		
		

	}

}
