package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class O3_HomePage extends O1_PageBase {

	public O3_HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(css = "a.ico-login")
	WebElement loginLink;

	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;

	@FindBy(id = "customerCurrency")
	WebElement currencydrl;

	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement NotbooksMenu;

	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement ComputerMenu;



	// ------------------------------------------------------------------------------------------------------
	// //

	public void openRegistrationPage() {
		// clickButton(registerLink);
		registerLink.click();
	}

	public void openLoginPage() {
		clickButton(loginLink);
	}

	public void openContactUsPage()

	{
		scrollToBottom();
		clickButton(contactUsLink);
	}

	public void changeCurrency() {
		select = new Select(currencydrl);
		select.selectByVisibleText("Euro");
	}

	public void selectNotebooksMenu() {
		action.moveToElement(ComputerMenu).moveToElement(NotbooksMenu).click().build().perform();
	}


}
