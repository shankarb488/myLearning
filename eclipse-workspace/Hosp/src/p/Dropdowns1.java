package p;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Dropdowns1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='paxinfo']")).click();
		int i = 1;
		while(i<5)
		{
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
			i++;
		}
		for(int i1=1;i1<5;i1++) 
		{
			driver.findElement(By.id("hrefIncChd")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertFalse(false);
	
	}

}
