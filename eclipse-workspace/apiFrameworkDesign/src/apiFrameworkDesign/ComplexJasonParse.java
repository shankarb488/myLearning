package apiFrameworkDesign;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.payLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJasonParse {
	@Test
	public void totalAmount() {
		int totalPrice = 0;
		JsonPath js = new JsonPath(payLoad.CoursePrice());
		// Print No of courses returned by API
		int coursesCount = js.getInt("courses.size()");
		System.out.println(coursesCount);
		// Print Purchase Amount
		System.out.println(js.getInt("dashboard.purchaseAmount"));
		// Print Title of the first course
		String courseTitleFirst = js.get("courses[0].title");
		System.out.println(courseTitleFirst);
		for (int i = 0; i < coursesCount; i++) {
			String eachCourseName = js.get("courses[" + i + "].title");
			int eachCoursePrice = js.getInt("courses[" + i + "].price");
			int eachCourseCopies = js.getInt("courses[" + i + "].copies");
			// System.out.println(allCourses);
			int totalCoursePrice = eachCoursePrice * eachCourseCopies;
			// System.out.println(eachCoursePrice);
			System.out.println(
					eachCourseName + " with " + eachCourseCopies + " copies with total amount = " + totalCoursePrice);
			totalPrice = totalPrice + totalCoursePrice;
		}
		System.out.println("Total amount for all courses = " + totalPrice);
		Assert.assertEquals(totalPrice, js.getInt("dashboard.purchaseAmount"));
	}
}
