package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.O2_ExcelReader;
import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;

public class O98_UserRegistrationTestWithDDTAndExcel extends O1_TestBase {

	/*
	 * 1- Create an excel file and move it to the data package 2- You need to add
	 * dependency for excel file in POM file .. POI Appache maven
	 */
	O3_HomePage homeObject;
	O2_UserRegistrationPage registerObject;
	O3_Login_Page loginObject;

	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterData() throws IOException {
		// get data from Excel Reader class
		O2_ExcelReader ER = new O2_ExcelReader();
		return ER.getExcelData();
	}

	// ------------------------------------------------------------------------------------------------

	@Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
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
	}


}
