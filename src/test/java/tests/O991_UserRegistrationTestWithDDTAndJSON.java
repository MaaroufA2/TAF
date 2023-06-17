package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.O3_JsonDataReader;
import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;

public class O991_UserRegistrationTestWithDDTAndJSON extends O1_TestBase {

	/*
	 * 1- install JSON from marketplace 2- import Dependency for JSON 
	 */
	O3_HomePage homeObject;
	O2_UserRegistrationPage registerObject;
	O3_Login_Page loginObject;


	// ------------------------------------------------------------------------------------------------

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws InterruptedException, IOException, ParseException {

		O3_JsonDataReader jsonReader = new O3_JsonDataReader();
		jsonReader.JsonReader();

		// ---------------------------------------------------------------------------

		homeObject = new O3_HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new O2_UserRegistrationPage(driver);
		registerObject.userRegistration(jsonReader.firstname, jsonReader.lastname, jsonReader.email,
				jsonReader.password);
		Thread.sleep(2000);
		homeObject.openLoginPage();
		loginObject = new O3_Login_Page(driver);
		loginObject.UserLogin(jsonReader.email, jsonReader.password);
		Thread.sleep(5000);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}


}
