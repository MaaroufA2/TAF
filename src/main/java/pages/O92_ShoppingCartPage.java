package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class O92_ShoppingCartPage extends O1_PageBase
{
	public O92_ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "button.remove-btn")
	WebElement removeCheck;

	@FindBy(name = "updatecart")
	WebElement updateCartBtn;

	@FindBy(css = "input.qty-input")
	public WebElement quantityTxt;

	@FindBy(css = "td.subtotal")
	public WebElement totalLbl;

	
	@FindBy(id="checkout")
	WebElement checkoutBtn ; 
	
	@FindBy(id="termsofservice")
	WebElement agreeCheckbox; 
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")
	WebElement guestCheckoutBtn ; 

	public void RemoveProductFromCart() {
		clickButton(removeCheck);
		// clickButton(updateCartBtn);
	}

	public void UpdateProductQuantityInCart(String quantity) {
		//clear quantity textbox
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(updateCartBtn);
	}

	public void openCheckoutPage() 
	{
		clickButton(agreeCheckbox);
		clickButton(checkoutBtn);
	}
	
	public void openCheckoutPageAsGuest() 
	{
		clickButton(agreeCheckbox);
		clickButton(checkoutBtn);
		clickButton(guestCheckoutBtn);
	}
}

