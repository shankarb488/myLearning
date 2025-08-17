package apiFrameworkDesign;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourseDetails;
import pojo.WebAutomation;

public class OAuthTestWithPojo {
	@Test

	public void endtoend() {
		int sum = 0;
		String resp = given()
				.formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParams("grant_type", "client_credentials")
				.formParams("scope", "trust").when().log().all()
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		JsonPath js = reUseableMethods.rawToJson(resp);
		String token = js.get("access_token");

		GetCourseDetails gc = given().queryParam("access_token", token).when().log().all()
				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourseDetails.class);
		// System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

		List<Api> apiCourses = gc.getCourses().getApi();

		for (int i = 0; i < apiCourses.size(); i++) {
			if (gc.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println(gc.getCourses().getApi().get(i).getPrice());

			}

		}
		List<WebAutomation> webAutomationCourses = gc.getCourses().getWebAutomation();

		for (int j = 0; j < webAutomationCourses.size(); j++) {

			int price = Integer.parseInt(webAutomationCourses.get(j).getPrice());
			sum = sum + price;
			

		}
		System.out.println(sum);

	}

}
