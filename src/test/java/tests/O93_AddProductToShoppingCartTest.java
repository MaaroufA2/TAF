package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O5_SearchPage;
import pages.O6_ProductDetailsPage;
import pages.O92_ShoppingCartPage;

public class O93_AddProductToShoppingCartTest extends O1_TestBase {
	O5_SearchPage searchPage;
	O6_ProductDetailsPage productDetails;
	O92_ShoppingCartPage cartPage;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority = 1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
		searchPage = new O5_SearchPage(driver);
		searchPage.ProductSearchUsingAutoSuggest("MacB");
		productDetails = new O6_ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));
	}

	@Test(priority = 2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		productDetails = new O6_ProductDetailsPage(driver);
		productDetails.AddToCart();
		Thread.sleep(2000);
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");
		Thread.sleep(2000);
		cartPage = new O92_ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.totalLbl.getText().contains("3,600"));
	}

	@Test(priority = 3)
	public void update_quantity() throws InterruptedException {
		cartPage = new O92_ShoppingCartPage(driver);
		Thread.sleep(2000);
		cartPage.UpdateProductQuantityInCart("4");
		Thread.sleep(2000);
	}
	/*
	 * @Test(priority = 4) public void UserCanRemoveProductFromCart() throws
	 * InterruptedException { cartPage = new O92_ShoppingCartPage(driver);
	 * Thread.sleep(2000); cartPage.RemoveProductFromCart(); Thread.sleep(2000); }
	 */
}
