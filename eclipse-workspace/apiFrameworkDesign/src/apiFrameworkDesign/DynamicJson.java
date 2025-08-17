package apiFrameworkDesign;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	@Test(dataProvider="BooksData")
	public void addBook(String aisle,String isbn) {
		RestAssured.baseURI = "http://216.10.245.166";
		String resp = given().log().all().header("Content-Type", "application/json")
				.body(payLoad.addBook(aisle, isbn)).when().post("Library/Addbook.php").then().assertThat()
				.statusCode(200).extract().response().asString();
		JsonPath js = reUseableMethods.rawToJson(resp);
		String id = js.getString("ID");
		System.out.println(id);
	}

	@DataProvider(name = "BooksData")
	public Object[][] getData() {

		Object object[][] = { { "123", "wer" }, { "234", "ert" }, { "456", "rty" } };
		return object;

	}

}
