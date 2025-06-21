package p;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Login1 {

	public static void main(String[] args) throws InterruptedException {
		String Email = "shankar";
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:/Users/sbelavalakoni/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String password = getPassword(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//driver.findElement(By.cssSelector("button[class='go-to-login-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys(Email);
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//form/button")).click();
		Thread.sleep(2000);
		String user = driver.findElement(By.xpath("//div/h2")).getText();
		//String academy = driver.findElement(By.xpath("//div/h1")).getText();
		//String welCome = driver.findElement(By.xpath("//div/p")).getText();
		//Hello shankar,
		String actualUser= user.split(" ")[1];
		Assert.assertEquals(actualUser, Email+",");
		Assert.assertEquals(driver.findElement(By.xpath("//div/p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//div/h1")).getText(), "Welcome to Rahul Shetty Academy");
		logoutApplication(driver);
		driver.quit();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException 
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.className("infoMsg")).getText();
		//--------Please use temporary password 'rahulshettyacademy' to Login.--------//
		String[] passwordText1= passwordText.split("'");
		String[] passwordText2 = passwordText1[1].split("'");//rahulshettyacademy' to Login.
		String password = passwordText2[0];//rahulshettyacademy
		//return password;
		//String[] passwordArray= passwordText.split("'");
		//String password = passwordArray[1].split("'")[0];
		return password;
	}
	
	public static void logoutApplication(WebDriver driver)
	{
		driver.findElement(By.className("logout-btn")).click();
	}
}
