package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;

public class O992_UserRegistrationTestWithJavaFaker extends O1_TestBase {

	/*
	 * 1- install JAVA FAKER POM
	 */
	O3_HomePage homeObject;
	O2_UserRegistrationPage registerObject;
	O3_Login_Page loginObject;
	Faker fakeData = new Faker();
	String firstname = fakeData.name().firstName();
	String lastname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();

	// ----------------------------------------------------------------------------------

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws InterruptedException {
		homeObject = new O3_HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new O2_UserRegistrationPage(driver);
		registerObject.userRegistration(firstname, lastname, email, password);
		System.out.println("The Userr Data is : " + firstname + " " + lastname + " " + email + " " + password);
		Thread.sleep(2000);
		homeObject.openLoginPage();
		loginObject = new O3_Login_Page(driver);
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}


}
