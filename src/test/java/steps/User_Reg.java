package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.CucumberOptions;
import pages.O2_UserRegistrationPage;
import pages.O3_HomePage;
import pages.O3_Login_Page;
import tests.O1_TestBase;

@CucumberOptions
public class User_Reg extends O1_TestBase {
	O3_HomePage homee;
	O2_UserRegistrationPage userReg;
	O3_Login_Page loginObject;

	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homee = new O3_HomePage(driver);
		homee.openRegistrationPage();
	}

	@When("I click on register link")
	public void i_click_on_register_link() {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	@When("I entered the user data")
	public void i_entered_the_user_data() throws InterruptedException {
		userReg = new O2_UserRegistrationPage(driver);
		userReg.userRegistration("Ahmed", "Maarouf", "ah1d@vf.com", "123456");
		homee.openLoginPage();
		loginObject = new O3_Login_Page(driver);
		loginObject.UserLogin("ah1d@vf.com", "123456");
		Thread.sleep(2000);
		// Assert.assertTrue(userReg.logoutLink.getText().contains("Log out"));

	}

	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		Assert.assertTrue(userReg.logoutLink.getText().contains("Log out"));
		userReg.userLogout();

	}

}
