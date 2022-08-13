package Practise;

import io.restassured.path.json.JsonPath;

public class ComplexOutputJSON {

	public static void main(String[] args) 
	
	{
		
		
		JsonPath out = Complexjson.rawjson1(Complexjsonpayload.courseprice());
		
		int count = out.getInt("courses.size()");
		
		System.out.println(count);
		
		
		System.out.println(out.get("dashboard.purchaseAmount"));
		
		for(int i=0;i<count;i++)
		{
			System.out.println(out.get("courses["+i+"].title"));
		}
		
		
		
		

	}

}
