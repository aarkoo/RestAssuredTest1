import org.junit.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidate {

	
	@Test
	public void sumofcourses() {
		
		JsonPath js= new JsonPath(Payload.Courseprice());
		 int size=	js.getInt("courses.size()");
		 
		 for(int i=0;i<size;i++)
	     {
			int price= js.get("courses["+i+"].price");
			
			int copies= js.get("courses["+i+"].copies");
			
			int amount= price*copies;
			
			System.out.println(amount);
			
				
	     }
	     
	}
}
