package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class O7_ContactUsPage extends O1_PageBase
{
	public O7_ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
    private WebElement fullNameTxt;
	
    @FindBy(id = "Email")
    private WebElement emailTxt;
    
    @FindBy(id = "Enquiry")
    private WebElement enquiryTxt;
    
    @FindBy(name = "send-email")
    private WebElement submitBtn;
    
    @FindBy(css = "div.result")
    public WebElement successMessage;

    public void ContactUs(String fullName , String email , String message) 
    {
    	 setTextElementText(fullNameTxt, fullName);
         setTextElementText(emailTxt, email);
         setTextElementText(enquiryTxt, message);
         clickButton(submitBtn);
    }
	
}
