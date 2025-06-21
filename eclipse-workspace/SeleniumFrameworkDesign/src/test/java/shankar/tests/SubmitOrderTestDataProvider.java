package shankar.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shankar.TestComponents.Basetest;
import shankar.pageobjects.CartPage;
import shankar.pageobjects.CheckOutPage;
import shankar.pageobjects.ConfirmationPage;
import shankar.pageobjects.OrdersPage;
import shankar.pageobjects.ProductCatalogue;

public class SubmitOrderTestDataProvider extends Basetest {

	String productName = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData", groups= "Purchase1")
	public void submitOrder(String email, String password, String productName) throws InterruptedException, IOException {

		String countryName = "india";
		ProductCatalogue productCatalogue = landingPage.loginApplication(email, password);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckout();
		checkOutPage.selectCountry(countryName);
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.loginApplication("shankar.b@gmail.com", "123456Aa");
		OrdersPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "shankar.b@gmail.com", "123456Aa", "ADIDAS ORIGINAL" },
				{ "shankar.b1@gmail.com", "123456Aa", "IPHONE 13 PRO" } };
	}
}