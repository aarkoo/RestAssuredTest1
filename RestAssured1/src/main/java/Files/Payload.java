package Files;

public class Payload 
{
   public static String AddPlace()
   {
	   
	   
	   return "{\"location\":{\"lat\":-38.383494,\"lng\":33.427362},\"accuracy\":50,\"name\":\"Frontlinehouse\",\"phone_number\":\"(+91)9838933937\",\"address\":\"29,sidelayout,cohen09\",\"types\":[\"shoepark\",\"shop\"],\"website\":\"http://google.com\",\"language\":\"French-IN\"}";
   }
   
   
   public static  String Courseprice()
   {
	   return "{\"dashboard\":{\"purchaseAmount\":910,\"website\":\"rahulshettyacademy.com\"},\"courses\":[{\"title\":\"SeleniumPython\",\"price\":50,\"copies\":6},{\"title\":\"Cypress\",\"price\":40,\"copies\":4},{\"title\":\"RPA\",\"price\":45,\"copies\":10}]}";
   }
   
   public static String addBook(String aisle, String isbn)
   {
	    String payload="{\"name\":\"LearnAppiumAutomationwithJava\",\"isbn\":\""+isbn+"\",\"aisle\":\""+aisle+"\",\"author\":\"Johnfoe\"}";
	    
	    return payload;
   }
}
