package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class O8_EmailPage extends O1_PageBase {

	public O8_EmailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
    private WebElement emailFriendTxt;

    @FindBy(id = "PersonalMessage")
    private WebElement personalMessageTxt;

    @FindBy(name = "send-email")
    private WebElement sendEmailBtn;
    
    @FindBy(css = "div.result")
    public WebElement messageNotification;
    
    public void SendEmailToFriend(String friendEmail, String personalMessage) {
        setTextElementText(emailFriendTxt, friendEmail);
        setTextElementText(personalMessageTxt, personalMessage);
        clickButton(sendEmailBtn);
    }
}