package p;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ECommarce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] itemsNeeded = { "Tomato", "Cucumber", "Beans", "Brocolli" };
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		getItems(driver, itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promocode")));
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
	}

	public static void getItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> allVeggiesName = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < allVeggiesName.size(); i++) {
			String vegetableName = allVeggiesName.get(i).getText();
			String vegetableRealName = vegetableName.split("-")[0].trim();
			List<String> itemsAddToCart = Arrays.asList(itemsNeeded);
			int j = 0;
			if (itemsAddToCart.contains(vegetableRealName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				driver.findElements(By.cssSelector(".increment")).get(i).click();

				j++;

				if (j == itemsNeeded.length) {
					break;
				}

			}

		}
	}

}
