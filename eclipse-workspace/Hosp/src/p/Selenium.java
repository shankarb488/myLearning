package p;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:/Users/sbelavalakoni/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		//driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("shankarb488@gmail.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
	}

}
