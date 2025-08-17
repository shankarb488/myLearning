package apiFrameworkDesign;

import org.testng.annotations.Test;

import files.payLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJasonParse1 {

	@Test
	public void getName() {
		JsonPath js = new JsonPath(payLoad.CoursePrice());
		int size = js.getInt("courses.size()");
		for (int i = 0; i < size; i++) {
			String courseTitle = js.get("courses[" + i + "].title");
			if (courseTitle.equalsIgnoreCase("RPA")) {
				int copies = js.getInt("courses[" + i + "].copies");
				System.out.println(copies);
				break;

			}

		}

	}

}
