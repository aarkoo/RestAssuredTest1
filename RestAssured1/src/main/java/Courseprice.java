import Files.Payload;
import io.restassured.path.json.JsonPath;

public class Courseprice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js= new JsonPath(Payload.Courseprice());
	    int size=	js.getInt("courses.size()");
	    System.out.println(size);
	    
	 System.out.println(js.getInt("dashboard.purchaseAmount"));
	 
	 System.out.println(js.getString("dashboard.website"));
	 
     System.out.println(js.getString("courses[0].title"));	 
     
     System.out.println();
     
     //
     for(int i=0;i<size;i++)
     {
    	String title= js.get("courses["+i+"].title");
    	System.out.println(title);
    	
    	if(title.equalsIgnoreCase("RPA"))
    	{
    		int copies=js.get("courses["+i+"].copies");
    		System.out.println(copies);
    		break;
    	}
     }
     
     
	

	}

}
