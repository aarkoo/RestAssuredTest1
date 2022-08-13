package Practise;

import io.restassured.path.json.JsonPath;

public class JsonPaths {
	
	
	public static JsonPath rawjson(String json)
	{
		JsonPath js =new JsonPath(json);
		
		
		return js;
	}

}
