package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O3_HomePage;
import pages.O7_ContactUsPage;

public class O6_ContactUsTest extends O1_TestBase
{
	O3_HomePage home;
	O7_ContactUsPage contactPage;

	String email = "test@test.com";
	String fullName = "Test User";
	String enquiry = "Hello Admin , this is for test";

	@Test
	public void UserCanUseContactUs() {
		home = new O3_HomePage(driver);
		home.openContactUsPage();
		contactPage = new O7_ContactUsPage(driver);
		contactPage.ContactUs(fullName, email, enquiry);

		 Assert.assertTrue(contactPage.successMessage.getText()
				 .contains("Your enquiry has been successfully sent to the store owner."));
	}

}
