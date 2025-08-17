package apiFrameworkDesign;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Basics {
	static String newAddress = "70 summer walk, USA";

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payLoad.addPlace()).when().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)").extract()
				.response().asString();

		// System.out.println(response);
		JsonPath js = new JsonPath(response);// for parsing jason
		String placeid = js.get("place_id");
		System.out.println(placeid);

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "    \"place_id\": \"" + placeid + "\",\r\n" + "    \"address\": \"" + newAddress
						+ "\",\r\n" + "    \"key\": \"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
				.when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract()
				.response().asString();

		JsonPath js1 = reUseableMethods.rawToJson(getPlaceResponse);
		String actualAddress = js1.get("address");
		System.out.println("upated address: " + actualAddress);
		Assert.assertEquals(actualAddress, newAddress);

	}

}
