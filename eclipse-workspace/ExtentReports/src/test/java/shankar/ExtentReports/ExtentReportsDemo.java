package shankar.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	ExtentReports extent;

	@BeforeTest
	public void config() {
		// ExtentReports, ExtentSpakReporter, ExtentTest
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shankar B");

	}

	@Test
	public void initialDemo() {
		ExtentTest test = extent.createTest("initialDemo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		test.fail("Results Do Not Match");
		extent.flush();
		driver.quit();
	}

}
