package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O5_SearchPage;
import pages.O6_ProductDetailsPage;

public class O5_SearchProductUsingAutoSuggestTest extends O1_TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	O5_SearchPage searchObject;
	O6_ProductDetailsPage detailsObject;

	@Test
	public void UserCanSearchWithAutoSuggest() {
		try {
			searchObject = new O5_SearchPage(driver);
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new O6_ProductDetailsPage(driver);
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}
}
