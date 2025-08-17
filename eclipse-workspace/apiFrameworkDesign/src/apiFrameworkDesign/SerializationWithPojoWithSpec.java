package apiFrameworkDesign;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

public class SerializationWithPojoWithSpec {

	@Test

	public void addPlace() {
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Frontline house");
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		ArrayList<String> t = new ArrayList<String>();
		t.add("shoe park");
		t.add("shop");
		p.setTypes(t);

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String res = given().log().all().queryParam("key", "qaclick123").headers("Content-Type", "application/json")
				.body(p).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.extract().response().asString();

		// JsonPath js = new JsonPath(res);
		System.out.println(res);

	}

}
