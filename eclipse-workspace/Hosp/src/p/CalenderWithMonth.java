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

public class CalenderWithMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		String[] rawItemsNeeded = { "Beans", "Pumpkin", "Banana" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='product-action']/button")));
		ItemsList(driver,rawItemsNeeded);
		
	}

	public static void ItemsList(WebDriver driver, String[] rawItemsNeeded) {
		List<WebElement> allVeggies = driver.findElements(By.cssSelector(".product-name"));
		List<String> itemsNeeded = Arrays.asList(rawItemsNeeded);
		for (int i = 0; i < allVeggies.size() - 2; i++) {
			String rawVeggiesName = allVeggies.get(i).getText();
			String realVegName = rawVeggiesName.split("-")[0].trim();
			int j = 0;
			if (itemsNeeded.contains(realVegName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == rawItemsNeeded.length) {
					break;
				}
			}

		}

	}

}
