package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;
import pages.O5_SearchPage;
import pages.O6_ProductDetailsPage;
import pages.O9_ProductReviewPage;

public class O9_AddProductReviewTest extends O1_TestBase {

	/*
	 * 1- User registration Then you need to login 2- Search for product 3- Add
	 * reivew 4- Logout
	 */

	O3_HomePage homeObject;
	O2_UserRegistrationPage registerObject;
	O3_Login_Page loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	O5_SearchPage searchObject;
	O6_ProductDetailsPage detailsObject;
	O9_ProductReviewPage reviewObject;

/// -------------------------------------------------------------------------------------------------------------'

	// 1- User Registration
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() {
		homeObject = new O3_HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new O2_UserRegistrationPage(driver);
		registerObject.userRegistration("Moataz", "Nabil", "ahmed@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(priority = 2, alwaysRun = true)
	public void RegisteredUserCanLogin() {
		homeObject = new O3_HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new O3_Login_Page(driver);
		loginObject.UserLogin("ahmed@gmail.com", "12345678");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

	// 2- Search For Product
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

	// 3- Add review
	@Test(priority = 4)
	public void RegisteredUserCanReviewProduct() {
		detailsObject.openAddReviewPage();
		reviewObject = new O9_ProductReviewPage(driver);
		reviewObject.AddProductReview("new reivew", "the product is very good");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("Product review is successfully added."));
	}

	// 4- User Logout
	@Test(priority = 5)
	public void RegisteredUserCanLogout() {
		registerObject.userLogout();
	}

}
