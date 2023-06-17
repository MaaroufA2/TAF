package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;
import pages.O5_SearchPage;
import pages.O6_ProductDetailsPage;
import pages.O8_EmailPage;

public class O7_EmailFriendTest extends O1_TestBase {
	O3_HomePage homeObject;
	O2_UserRegistrationPage registerObject;
	O3_Login_Page loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	O5_SearchPage searchObject;
	O6_ProductDetailsPage detailsObject;
	O8_EmailPage emailObject;

	// ----------------------------------------------------------------------------------------

	// 1- User Registration
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() {
		homeObject = new O3_HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new O2_UserRegistrationPage(driver);
		registerObject.userRegistration("Moataz", "Nabil", "test7846@gmail.com", "12345678");
		// Assert.assertTrue(registerObject.successMessage.getText().contains("Your
		// registration completed"));
	}

	// 2- User Login

	@Test(priority = 2, alwaysRun = true)
	public void RegisteredUserCanLogin() {
		homeObject = new O3_HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new O3_Login_Page(driver);
		loginObject.UserLogin("test7846@gmail.com", "12345678");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

	// 3- Search For Product
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

	// 4- Email to Friend
	@Test(priority = 4)
	public void RegisteredUserCanSendProductToFriend() {
		detailsObject.openSendEmail();
		emailObject = new O8_EmailPage(driver);
		emailObject.SendEmailToFriend("aaa@tte.com", "Hello my friend , check this product");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
	}

	// 4- User Lgoout
	@Test(priority = 5)
	public void RegisteredUserCanLogout() {
		registerObject.userLogout();
	}

}
