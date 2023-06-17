package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;
import pages.O4_MyAccount;

public class O3_MyAccountTest extends O1_TestBase {

	O3_HomePage homeObject;
	O2_UserRegistrationPage registerObject;
	O3_Login_Page loginObject;
	O4_MyAccount myAccountObject;
	String oldPassword = "12345678";
	String newPassword = "123456";
	String firstName = "Moataz";
	String lastName = "Nabil";
	String email = "tAtest399@gmail.com";

	@Test(priority = 1)
	public void UserCanRegisterSuccssfully() {
		homeObject = new O3_HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new O2_UserRegistrationPage(driver);
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		// Assert.assertTrue(registerObject.successMessage.getText().contains("Your
		// registration completed"));
	}

	@Test(priority = 2, alwaysRun = true)
	public void RegisteredUserCanLogin() {
		homeObject = new O3_HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new O3_Login_Page(driver);
		loginObject.UserLogin(email, oldPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

	@Test(priority = 3)
	public void RegisteredUserCanChangePassword() throws InterruptedException {
		myAccountObject = new O4_MyAccount(driver);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		// Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was
		// changed"));
	}
	/*
	 * 
	 * 
	 * 
	 * @Test(priority = 3) public void RegisteredUserCanLogout() {
	 * registerObject.userLogout(); }
	 * 
	 * @Test(priority = 4) public void RegisteredUserCanLogin() {
	 * homeObject.openLoginPage(); loginObject = new LoginPage(driver);
	 * loginObject.UserLogin(email, newPassword);
	 * Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out")); }
	 * 
	 * @Test(priority = 5) public void UserLogout() { registerObject.userLogout(); }
	 */

}
