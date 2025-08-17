package apiFrameworkDesign;

import io.restassured.path.json.JsonPath;

public class reUseableMethods {

	public static JsonPath rawToJson(String response) {

		JsonPath js = new JsonPath(response);
		return js;
	}

}
