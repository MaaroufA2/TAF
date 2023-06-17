package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;

public class O2_UserRegistrationtest extends O1_TestBase {

	O3_HomePage homeObject;
	O2_UserRegistrationPage registerObject;
	O3_Login_Page loginObject;

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws InterruptedException {
		homeObject = new O3_HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new O2_UserRegistrationPage(driver);
		registerObject.userRegistration("Moataz", "Nabil", "oomaar@gmail.com", "12345678");
		System.out.println("Headless is working ");
		// Assert.assertTrue(registerObject.successMessage.getText().contains("Your
		// registration completed"));
	}


	@Test(priority = 2, alwaysRun = true)
	public void RegisteredUserCanLogin() {
		homeObject = new O3_HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new O3_Login_Page(driver);
		loginObject.UserLogin("oomaar@gmail.com", "12345678");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		System.out.println("Headless is working ");

	}

}
