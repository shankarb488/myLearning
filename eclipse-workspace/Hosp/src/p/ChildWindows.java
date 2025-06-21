package p;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String paretntId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		// String emailUrl =
		// driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4];
		String emailUrl1 = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];
		// System.out.println(emailUrl);
		// String email = emailUrl.split(" ")[4];
		driver.switchTo().window(paretntId);
		driver.findElement(By.id("username")).sendKeys(emailUrl1);

	}

}
