package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;
import pages.O5_SearchPage;
import pages.O6_ProductDetailsPage;
import pages.O92_ShoppingCartPage;
import pages.O93_CheckoutPage;
import pages.O94_OrderDetailsPage;

public class O94_RegisteredUserCheckoutProductTest extends O1_TestBase {
	/*
	 * 1- Register User 2- Search for product 3- Add to Cart 4- Checkout 5- Logout
	 */

	O3_HomePage homeObject;
	O2_UserRegistrationPage registerObject;
	O3_Login_Page loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	O5_SearchPage searchObject;
	O6_ProductDetailsPage detailsObject;
	O92_ShoppingCartPage cartPage;
	O93_CheckoutPage checkoutObject;
	O94_OrderDetailsPage orderObject;

// -------------------------------------------------------------------------------------------------
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() {
		homeObject = new O3_HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new O2_UserRegistrationPage(driver);
		registerObject.userRegistration("Moataz", "Nabil", "ahm@hot.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

// -------------------------------------------------------------------------------------------------

	@Test(priority = 2, alwaysRun = true)
	public void RegisteredUserCanLogin() {
		homeObject = new O3_HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new O3_Login_Page(driver);
		loginObject.UserLogin("ahm@hot.com", "12345678");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

// -------------------------------------------------------------------------------------------------

	@Test(priority = 3)
	public void UserCanSearchWithAutoSuggest() {
		try {
			searchObject = new O5_SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new O6_ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}

// -------------------------------------------------------------------------------------------------

	@Test(priority = 4)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		detailsObject = new O6_ProductDetailsPage(driver);
		detailsObject.AddToCart();
		Thread.sleep(1000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
		cartPage = new O92_ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.totalLbl.getText().contains("3,600"));
	}

// -------------------------------------------------------------------------------------------------

	@Test(priority = 5)
	public void UserCanCheckoutProduct() throws InterruptedException {
		checkoutObject = new O93_CheckoutPage(driver);
		cartPage.openCheckoutPage();
		checkoutObject.RegisteredUserCheckoutProduct("Egypt", "test address", "123456", "32445566677", "Cairo",
				productName);
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));

		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
		Thread.sleep(3000);
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject = new O94_OrderDetailsPage(driver);
		orderObject.DownloadPDFInvoice();
		// orderObject.PrintOrderDetails();
	}

// -------------------------------------------------------------------------------------------------

	@Test(priority = 6)
	public void RegisteredUserCanLogout() {
		registerObject.userLogout();
	}
}
