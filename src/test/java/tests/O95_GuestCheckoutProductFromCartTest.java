package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O3_HomePage;
import pages.O5_SearchPage;
import pages.O6_ProductDetailsPage;
import pages.O92_ShoppingCartPage;
import pages.O93_CheckoutPage;
import pages.O94_OrderDetailsPage;

public class O95_GuestCheckoutProductFromCartTest extends O1_TestBase {
	O5_SearchPage searchObject;
	O3_HomePage homeObject;
	O6_ProductDetailsPage productDetails;
	O92_ShoppingCartPage cartObject;
	O93_CheckoutPage checkoutObject;
	O94_OrderDetailsPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
		searchObject = new O5_SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		productDetails = new O6_ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));
	}

	@Test(priority = 2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		cartObject = new O92_ShoppingCartPage(driver);
		productDetails.AddToCart();
		Thread.sleep(2000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
		cartObject = new O92_ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.totalLbl.getText().contains("3,600"));
	}

	@Test(priority = 3)
	public void UserCanCheckoutProduct() throws InterruptedException {
		checkoutObject = new O93_CheckoutPage(driver);
		cartObject.openCheckoutPageAsGuest();
		checkoutObject.CheckoutProduct("test", "user", "Egypt", "testuser1@test.com", "test address", "123456",
				"32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Thread.sleep(3000);
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
	}

	@Test(priority = 4)
	public void UserCanViewOrderDetails() throws InterruptedException {
		orderObject = new O94_OrderDetailsPage(driver);
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject.DownloadPDFInvoice();
		Thread.sleep(3000);
		orderObject.PrintOrderDetails();
	}

}
