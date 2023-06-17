package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class O3_Login_Page extends O1_PageBase {

	public O3_Login_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Email")
	WebElement emailTxtBox;

	@FindBy(id = "Password")
	WebElement passwordTxtBox;

	@FindBy(css = "button.button-1.login-button")
	WebElement loginBtn;

	// ------------------------------------------------------------------------------------------------------ // 

	public void UserLogin(String email, String password) {
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}


}
