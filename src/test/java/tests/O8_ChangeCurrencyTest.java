package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O3_HomePage;
import pages.O5_SearchPage;
import pages.O6_ProductDetailsPage;

public class O8_ChangeCurrencyTest extends O1_TestBase
{
	O3_HomePage homeObject;
	O6_ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch"; 
	O5_SearchPage searchObject;

	@Test(priority=1)
	public void UserCanCanChangeCurrency() 
	{
		homeObject = new O3_HomePage(driver);
		homeObject.changeCurrency();
	}
	
	@Test(priority=2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try {
			searchObject = new O5_SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new O6_ProductDetailsPage(driver);

			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
			Assert.assertTrue(detailsObject.productPricelbl.getText().contains("€"));
			System.out.println(detailsObject.productPricelbl.getText());

		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}
	
	
}
