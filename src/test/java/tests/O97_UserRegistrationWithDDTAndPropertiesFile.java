package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.O1_LoadProperties;
import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;

public class O97_UserRegistrationWithDDTAndPropertiesFile extends O1_TestBase {

	/*
	 * 1- Create data package the O1_LoadProperties class 2- Create properties then
	 * userdata.properties package then in properties
	 */

	O3_HomePage homeObject;
	O2_UserRegistrationPage registerObject;
	O3_Login_Page loginObject;

	String firtname = O1_LoadProperties.userData.getProperty("firstname");
	String lastname = O1_LoadProperties.userData.getProperty("lastname");
	String email = O1_LoadProperties.userData.getProperty("email");
	String Password = O1_LoadProperties.userData.getProperty("password");

	// ------------------------------------------------------------------------------------------------

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws InterruptedException {
		homeObject = new O3_HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new O2_UserRegistrationPage(driver);
		registerObject.userRegistration(firtname, lastname, email, Password);
		Thread.sleep(2000);

	}

	// ------------------------------------------------------------------------------------------------

	@Test(priority = 2, alwaysRun = true)
	public void RegisteredUserCanLogin() {
		homeObject = new O3_HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new O3_Login_Page(driver);
		loginObject.UserLogin(email, Password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

}
