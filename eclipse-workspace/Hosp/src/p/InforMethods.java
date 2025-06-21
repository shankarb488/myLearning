package p;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InforMethods {
	
	public static void login()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://hmsweb-release.hms.dev.inforcloudsuite.com/web/base/logindisp?tenant=HMS_RELEASE");
		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys("R5");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("HMSr5U$ER");
		driver.findElement(By.id("button-1034-btnIconEl")).click();	
	}

}
