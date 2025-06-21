package p;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@data-testid='one-way-radio-button']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		driver.findElement(By.xpath("//div[text()='International']")).click();
		driver.findElement(By.xpath("//div[text()='BKK']")).click();

		driver.findElement(By.xpath("//div[text()='International']")).click();
		driver.findElement(By.xpath("//div[text()='DAC']")).click();
		driver.findElement(By.cssSelector(
				".css-1dbjc4n.r-1awozwy.r-19m6qjp.r-156aje7.r-y47klf.r-1phboty.r-1d6rzhh.r-1pi2tsx.r-1777fci.r-13qz1uu"))
				.click();
		if (driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']"))
				.getDomAttribute("style").contains("238")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		}
		for (int i = 1; i < 2; i++) {
			driver.findElement(By.xpath("//div[@data-testid='Children-testID-plus-one-cta']")).click();
		}
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']")).click();
		String text = driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).getText();
		String actualText = text.split("Passengers")[1];
		String actualText1 = actualText.trim();
		Assert.assertEquals(actualText1, "5 Adults, 1 Child");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Family & Friends']")).click();
		driver.findElement(By.xpath("//div[@id='main-container']/div/div/div[3]/div[2]/div[5]/div[2]/div")).click();
		driver.findElement(By.xpath("//div[text()='AED']")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
	}
}
