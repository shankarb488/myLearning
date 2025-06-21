package p;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdowns3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				driver.manage().window().maximize();
				driver.findElement(By.id("autosuggest")).sendKeys("ind");
				List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
				for(WebElement option : options)
				{
					if(option.getText().equalsIgnoreCase("India")) 
					{
						option.click();
						break;
					}
				}
				driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	}

}
