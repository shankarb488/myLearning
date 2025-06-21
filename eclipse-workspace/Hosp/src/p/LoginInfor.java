package p;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginInfor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://hmsweb-release.hms.dev.inforcloudsuite.com/web/base/logindisp?tenant=HMS_RELEASE");
		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys("R5");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("HMSr5U$ER");
		driver.findElement(By.id("button-1034-btnIconEl")).click();
		driver.findElement(By.id("button-1042-btnIconEl")).click();
		driver.findElement(By.xpath("//span[@id='menuitem-1091-textEl']")).click();
		driver.findElement(By.name("accountname")).sendKeys("TEST AR");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div/div/div[4]/div/div/div[2]/div/div/div/span/div/div[1]/span/div/div/div/table/tbody/tr[1]/td[2]/div/span/div/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/div")).click();
		//driver.findElement(By.id("ext-gen2575")).click();
		Thread.sleep(1000);
	}

}
