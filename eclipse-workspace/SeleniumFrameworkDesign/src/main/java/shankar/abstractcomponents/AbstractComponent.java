package shankar.abstractcomponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shankar.pageobjects.CartPage;
import shankar.pageobjects.OrdersPage;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "button[routerlink*='cart']")
	WebElement cartHeader;

	@FindBy(css = "button[routerlink*='myorders']")
	WebElement orderHeader;

	By cartPageLoad = By.cssSelector(".cartSection h3");

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void waitForListWebElementToAppear(List<WebElement> findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(findBy));

	}

	public void waitForElementToDisAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(findBy));
	}

	public CartPage goToCartPage() {
		waitForWebElementToAppear(cartHeader);
		cartHeader.click();
		waitForElementToAppear(cartPageLoad);
		CartPage cartPage = new CartPage(driver);
		return cartPage;

	}

	public OrdersPage goToOrdersPage() {
		waitForWebElementToAppear(orderHeader);
		orderHeader.click();
		OrdersPage orderPage = new OrdersPage(driver);
		return orderPage;

	}
}
