package p;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseInteractions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		//MouseHover
		a.moveToElement(driver.findElement(By.cssSelector(".H6-NpN._3N4_BX"))).build().perform();
		//Entering in caps and double clicking
		a.moveToElement(driver.findElement(By.cssSelector(".Pke_EE"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//rightclick
		a.moveToElement(driver.findElement(By.xpath("//a[text()='Become a Seller']"))).contextClick().build().perform();
		
		

	}

}
