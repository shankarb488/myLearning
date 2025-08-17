package apiFrameworkDesign;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class OAuthTest {
	@Test
	
	public void endtoend() {
		String resp = given().formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParams("grant_type", "client_credentials")
				.formParams("scope", "trust").when().log().all()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		JsonPath js = reUseableMethods.rawToJson(resp);
		String token = js.get("access_token");
		
		String resp1 = given().queryParam("access_token", token)
		.when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
		System.out.println("======================================");
		System.out.println("CourseDetails :"+resp1);

	}

}
