package shankar.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import shankar.TestComponents.Basetest;
import shankar.TestComponents.Retry;
import shankar.pageobjects.CartPage;
import shankar.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends Basetest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = Retry.class)

	public void loginErrorValidation() {

		landingPage.loginApplication("shankar.b@gmail.com", "12345");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

	@Test

	public void productErrorValidation() {
		String productName = "ADIDAS ORIGINAL";
		ProductCatalogue productCatalogue = landingPage.loginApplication("shankar.b1@gmail.com", "123456Aa");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean match = cartPage.verifyProductDisplay("ADIDAS ORIGINAL1");
		Assert.assertFalse(match);
	}

}
