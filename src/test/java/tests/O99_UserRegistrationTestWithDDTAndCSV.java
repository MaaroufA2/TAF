package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;

public class O99_UserRegistrationTestWithDDTAndCSV extends O1_TestBase {

	/*
	 * 1- add dependency for csv which is opencsv 2- copy the file to the data
	 * package
	 */

	O3_HomePage homeObject;
	O2_UserRegistrationPage registerObject;
	O3_Login_Page loginObject;

	CSVReader reader;

//----------------------------------------------------------------------------------------------------

	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccssfully() throws CsvValidationException, IOException, InterruptedException {

		// get path of CSV file
		String CSV_file = System.getProperty("user.dir") + "/src/test/java/data/UserData.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		String[] csvCell;

		// ----------------------------------------------------------------------------------------------

		// while loop will be executed till the lastvalue in CSV file .
		while ((csvCell = reader.readNext()) != null) {
			String firstname = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];

			homeObject = new O3_HomePage(driver);
			homeObject.openRegistrationPage();
			registerObject = new O2_UserRegistrationPage(driver);
			registerObject.userRegistration(firstname, lastName, email, password);
			Thread.sleep(2000);
			homeObject.openLoginPage();
			loginObject = new O3_Login_Page(driver);
			loginObject.UserLogin(email, password);
			Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
			registerObject.userLogout();

		}

	}

}
