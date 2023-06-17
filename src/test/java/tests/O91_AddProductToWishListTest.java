package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O5_SearchPage;
import pages.O6_ProductDetailsPage;
import pages.O90_WishlistPage;

public class O91_AddProductToWishListTest extends O1_TestBase
{
	O5_SearchPage searchPage;
	O6_ProductDetailsPage productDetails;
	O90_WishlistPage wishlistObject;
	String productName = "Apple MacBook Pro 13-inch";

	@Test(priority=1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
		searchPage = new O5_SearchPage(driver);
		searchPage.ProductSearchUsingAutoSuggest("MacB");
		productDetails = new O6_ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));
	}

	@Test(priority=2)
	public void UserCanAddProductToWishlist() throws InterruptedException {
		productDetails = new O6_ProductDetailsPage(driver);
		productDetails.AddProductToWishlist();
		driver.navigate().to("http://demo.nopcommerce.com" + "/wishlist");
		wishlistObject = new O90_WishlistPage(driver); 
		Assert.assertTrue(wishlistObject.wishlistHeader.isDisplayed());
		Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
	}

	@Test(priority=3)
	public void UserCanRemoveProductFromCart() {
		wishlistObject = new O90_WishlistPage(driver); 
		wishlistObject.removeProductFromWishlist();
		Assert.assertTrue(wishlistObject.EmptyCartLbl.getText().contains("The wishlist is empty!"));
	}

}
