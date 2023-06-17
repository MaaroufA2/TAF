package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class O6_ProductDetailsPage extends O1_PageBase {
	public O6_ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "strong.current-item")
	public WebElement productNamebreadCrumb;

	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;

	public void openSendEmail() {
		clickButton(emailFriendBtn);
	}

	@FindBy(css = "span.price-value-4")
	public WebElement productPricelbl; // Euros or dollars sign

	@FindBy(linkText = "Add your review")
	WebElement addReviewLink;

	public void openAddReviewPage() {
		clickButton(addReviewLink);
	}

	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishlistBtn;

	public void AddProductToWishlist() {
		clickButton(addToWishlistBtn);
	}

	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;

	public void AddProductToCompare() {
		clickButton(addToCompareBtn);
	}

	@FindBy(id = "add-to-cart-button-4")
	WebElement addToCartBtn;

	public void AddToCart() {
		clickButton(addToCartBtn);
	}

}
