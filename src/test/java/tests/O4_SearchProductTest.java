package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.O5_SearchPage;
import pages.O6_ProductDetailsPage;

public class O4_SearchProductTest extends O1_TestBase {
	String productName = "Apple MacBook Pro 13-inch";
	O5_SearchPage searchObject;
	O6_ProductDetailsPage detailsObject;

	@Test
	public void UserCanSearchForProducts() throws InterruptedException {
		searchObject = new O5_SearchPage(driver);
		detailsObject = new O6_ProductDetailsPage(driver);
		searchObject.ProductSearch(productName);
		Thread.sleep(2000);
		searchObject.OpenProductDetailsPage();
		// Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(),
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		// productName);
	}

}
