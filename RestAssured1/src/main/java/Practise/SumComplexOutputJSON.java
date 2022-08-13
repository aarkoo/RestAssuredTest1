package Practise;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumComplexOutputJSON {

	int sum=0;
	
		
		@Test
		public void validate()
		{

			JsonPath out = Complexjson.rawjson1(Complexjsonpayload.courseprice());
		

			int count = out.getInt("courses.size()");
			
			for(int i=0;i< count;i++)
			{
				int prices=out.get("courses["+i+"].price");
				sum+=prices;
				
				
			}
			
			System.out.println(sum);
		}

	

}
