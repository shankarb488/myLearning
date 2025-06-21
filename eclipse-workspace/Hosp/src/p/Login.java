package p;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:/Users/sbelavalakoni/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/");
		driver.findElement(By.className("register-btn")).click();
		driver.findElement(By.id("email")).sendKeys("shankarb488@gmail.com");
		driver.findElement(By.name("rememberMeCheckbox")).click();
		driver.findElement(By.cssSelector("button.mguTu")).click();
		System.out.println(driver.findElement(By.cssSelector("p.fxKdB")).getText());
		driver.findElement(By.cssSelector("button.Y4agH")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"otp-login\"]/div/div[1]/div[2]/div[2]")).getText());
		driver.findElement(By.linkText("Login with password instead")).click();
		//driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shankarb488@gmail.com");
		//driver.findElement(By.id("password")).sendKeys("123456Aa");
		//driver.findElement(By.cssSelector("input[name='commit']")).click();
		//System.out.println(driver.findElement(By.className("text-with-icon")).getText());
		driver.findElement(By.linkText("Forgot Password")).click();
		driver.findElement(By.xpath("//input[@autofocus='autofocus']")).sendKeys("shankarb488@gmail.com");
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@autofocus='autofocus']")).sendKeys("shankarb488899@gmail.com");
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		driver.close();
	}

}
