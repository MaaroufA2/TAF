package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class O90_WishlistPage extends O1_PageBase
{
	public O90_WishlistPage(WebDriver driver) {
		super(driver);
	}
	
	// product name
	@FindBy(css = "td.product")
    public WebElement productCell;
    
    @FindBy(css = "h1")
    public WebElement wishlistHeader;
   
    @FindBy(name = "updatecart")
    private WebElement updateWishlistBtn;
    
	@FindBy(css = "button.remove-btn")
    private WebElement removefromCartCheck;
   
	// To check that the item was removed
    @FindBy(css = "div.no-data")
    public WebElement EmptyCartLbl;
   
    public void removeProductFromWishlist() {
        clickButton(removefromCartCheck);
		// clickButton(updateWishlistBtn);
    }
}
