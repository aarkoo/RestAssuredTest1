package Library;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.Reusable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class DynamicJSON {
	
	

	public class NewTest 
	{
		
		
	  @Test(dataProvider = "data1")
	  public void addBook(String aisle, String isbn) 
	  
	  {
		  
		  RestAssured.baseURI="http://216.10.245.166";
	String res=	  given().header("Content-Type","application/json")
		  .body(Payload.addBook(aisle, isbn))
		  .when()
		  .post("/Library/Addbook.php")
		  .then().assertThat().statusCode(200)
		  .extract().response().asString();
	
	System.out.println(res);
	
	 JsonPath js= Reusable.rawtoJson(res);
	 
	String id= js.get("ID");
	System.out.println(id);
	
	
	  }
	  
	  @DataProvider(name="data1")
	  public Object[][] getdata()
	  {
	     return  new Object[][] 
	    		 
	       {
			  
			  {"adsa1saf", "64814"},
			  {"adsa21sf", "64814"}
		  };
	  }
	}


}
