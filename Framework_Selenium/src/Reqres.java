package tyss.reqres.project;

import org.codehaus.groovy.transform.sc.StaticCompilationMetadataKeys;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

public class Reqres {
	@Test
	public void getAllUsers() {
		RestAssured.given().when().get("https://reqres.in/api/users?page=2").then().assertThat().statusCode(200).log()
				.all().extract().toString();
	}

	@Test
	public void createUser() {
		RestAssured.given().body("{\r\n" + "    \"name\": \"MDA\",\r\n" + "    \"job\": \"leader\"\r\n" + "}")
		.when().post("https://reqres.in/api/users")
		.then().assertThat().statusCode(201).body("id", equalTo("1")).log()
				.all();
	}
	//JsonPath js= new JsonPath();

}
