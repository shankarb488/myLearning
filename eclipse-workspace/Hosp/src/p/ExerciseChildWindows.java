package p;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ExerciseChildWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div/div/a")).click();
		Set<String> w =  driver.getWindowHandles();
		Iterator<String> window= w.iterator();
		String parent = window.next();
		String child = window.next();
		driver.switchTo().window(child);
		String childWindowText = driver.findElement(By.xpath("//html/body/div/h3")).getText();
		System.out.println(childWindowText);
		Assert.assertEquals(childWindowText, "New Window");
		driver.switchTo().window(parent);
		String parentWindowText = driver.findElement(By.xpath("//html/body/div[2]/div/div/h3")).getText();
		System.out.println(parentWindowText);
		Assert.assertEquals(parentWindowText, "Opening a new window");
		driver.quit();

	}

}
