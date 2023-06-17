package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O3_HomePage;

public class O90_ProductHoverMenuTest extends O1_TestBase
{
	O3_HomePage homeObject;
	
	@Test
	public void UserCanSelectSubCategoryFromMainMenu() throws InterruptedException
	{
		homeObject = new O3_HomePage(driver);
		homeObject.selectNotebooksMenu();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
