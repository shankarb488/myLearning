package p2;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PS {

	public void doThis() {
		System.out.println("I am Here");

	}

	@BeforeTest
	public void before() {
		System.out.println("Before Test");
	}

	@AfterTest
	public void after() {
		System.out.println("After Test");
	}

}
