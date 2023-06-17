package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class O2_UserRegistrationPage extends O1_PageBase {

	public O2_UserRegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;

	@FindBy(id = "FirstName")
	WebElement fnTxtBox;

	@FindBy(id = "LastName")
	WebElement lnTxtBox;

	@FindBy(id = "Email")
	WebElement emailTxtBox;

	@FindBy(id = "Password")
	WebElement passwordTxtBox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;

	@FindBy(id = "register-button")
	WebElement registerBtn;

	@FindBy(css = "a.ico-logout")
	public WebElement logoutLink;

	@FindBy(css = "a.ico-account")
	WebElement myAccountLink;

	@FindBy(css = "div.result")
	public WebElement successMessage;
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	// ------------------------------------------------------------------------------------------------------ // 

	public void userRegistration(String firstName, String lastName, String email, String password) {
		clickButton(genderRdoBtn);
		// genderRdoBtn.click();
		setTextElementText(fnTxtBox, firstName);
		// fnTxtBox.sendKeys(firstName);
		setTextElementText(lnTxtBox, lastName);
		/// lnTxtBox.sendKeys(lastName);
		setTextElementText(emailTxtBox, email);
		/// emailTxtBox.sendKeys(email);
		setTextElementText(passwordTxtBox, password);
		// passwordTxtBox.sendKeys(password);
		setTextElementText(confirmPasswordTxtBox, password);
		// confirmPasswordTxtBox.sendKeys(password);
		// clickButton(registerBtn);
		registerBtn.click();
	}
	
		
	public void userLogout() {
		clickButton(logoutLink);
	}
		
	public void openMyAccountPage() 
		{
		clickButton(myAccountLink);

		}
	
	}

