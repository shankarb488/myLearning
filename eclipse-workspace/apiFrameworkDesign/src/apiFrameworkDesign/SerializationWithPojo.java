package apiFrameworkDesign;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class SerializationWithPojo {

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

		RequestSpecification addPlaceSpecReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").addHeader("Content-Type", "application/json").build();

		ResponseSpecification addPlaceSpecRes = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();

		RequestSpecification addPlaceRequestSpec = given().spec(addPlaceSpecReq).body(p);

		Response response = addPlaceRequestSpec.when().post("maps/api/place/add/json").then().log().all()
				.spec(addPlaceSpecRes).extract().response();

		String addPlaceResponse = response.asString();

		System.out.println(addPlaceResponse);

	}

}
