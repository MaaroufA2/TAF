package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class O9_ProductReviewPage extends O1_PageBase {

	public O9_ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;

	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewText;

	@FindBy(id = "addproductrating_4")
	WebElement rating4RdoBtn;

	@FindBy(name = "add-review")
	WebElement submitReviewBtn;

	@FindBy(css = "div.result")
	public WebElement reviewNotification;

	public void AddProductReview(String reviewTitle, String reviewMessage) {
		setTextElementText(reviewTitleTxt, reviewTitle);
		setTextElementText(reviewText, reviewMessage);
		clickButton(rating4RdoBtn);
		clickButton(submitReviewBtn);
	}
}
