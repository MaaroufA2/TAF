package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;

public class O96_UserRegistrationWithDDTAndDataProvider extends O1_TestBase {

	O3_HomePage homeObject;
	O2_UserRegistrationPage registerObject;
	O3_Login_Page loginObject;

	@DataProvider(name = "testData")
	public static Object[][] userData() {
		return new Object[][] { { "Moataz", "Nabil", "attestxxx996@gmail.com", "123456" },
				{ "Ahmed", "Ali", "attestuser1270073@gmail.com", "12345678" } };
	}

	// ------------------------------------------------------------------------------------------------

	@Test(priority = 1, alwaysRun = true, dataProvider = "testData")
	public void UserCanRegisterSuccssfully(String fname, String lname, String email, String password)
			throws InterruptedException {

		homeObject = new O3_HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new O2_UserRegistrationPage(driver);
		registerObject.userRegistration(fname, lname, email, password);
		Thread.sleep(2000);
		homeObject.openLoginPage();
		loginObject = new O3_Login_Page(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
		// Assert.assertTrue(registerObject.successMessage.getText().contains("Your
		// registration completed"));
	}

}
