package apiFrameworkDesign;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import pojo.GetCourseDetails;
import pojo.WebAutomation;

public class OAuthTestWithPojoWithArrayList {
	@Test

	public void endtoend() {
		String[] a = { "Selenium Webdriver Java", "Cypress", "Protractor" };
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
		List<String> actualCourses = new ArrayList<String>();
		List<String> expectedCourses = Arrays.asList(a);

		List<WebAutomation> webAutomationCourses = gc.getCourses().getWebAutomation();

		for (int i = 0; i < webAutomationCourses.size(); i++) {
			actualCourses.add(webAutomationCourses.get(i).getCourseTitle());

		}
		Assert.assertTrue(expectedCourses.equals(actualCourses));

	}

}