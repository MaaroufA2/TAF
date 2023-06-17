package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class O4_MyAccount extends O1_PageBase {

	public O4_MyAccount(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Change password")
	WebElement changePasswordLink ;

	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxt;

	@FindBy(id = "NewPassword")
	WebElement newPasswordTxt;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmPasswordTxt;

	@FindBy(css = "button.button-1.change-password-button")
	WebElement ChangePasswordBtn;
	/*
	 * @FindBy(css = "div.result") public WebElement resultLbl;
	 * 
	 * public void openChangePasswordPage() { clickButton(changePasswordLink); }
	 */

	// ------------------------------------------------------------------------------------------------------
	// //

	public void ChangePassword(String oldpassword, String newpassword) throws InterruptedException {
		setTextElementText(oldPasswordTxt, oldpassword);
		setTextElementText(newPasswordTxt, newpassword);
		setTextElementText(confirmPasswordTxt, newpassword);
		clickButton(ChangePasswordBtn);
		Thread.sleep(2000);
	}

	public void openChangePasswordPage() 
	{ clickButton(changePasswordLink);
	}
	}


