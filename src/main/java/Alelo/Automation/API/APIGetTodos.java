package Alelo.Automation.API;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class APIGetTodos {

	String baseURI;
	
	public APIGetTodos() {
		baseURI = "https://jsonplaceholder.typicode.com/todos/1";
	}
	
	@Test
	public void test() {
		
		given().when().get(baseURI).then().body(containsString("delectus aut autem"));
	}
	
	@Test
	public void testStatusCode() {
		given().when().get(baseURI).then().statusCode(200);
	}
}
