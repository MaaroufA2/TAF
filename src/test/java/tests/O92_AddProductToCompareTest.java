package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.O3_HomePage;
import pages.O5_SearchPage;
import pages.O6_ProductDetailsPage;
import pages.O91_ComparePage;

public class O92_AddProductToCompareTest extends O1_TestBase
{
    String firstProductName = "Apple MacBook Pro 13-inch";
    String secondProductName = "Asus N551JK-XO076H Laptop"; 

	// 1- Search for product number 1
	// 2- Search for product number 2 
	// 3- Add to compare 
	// 4- Clear list

	O6_ProductDetailsPage detailsObject;
	O3_HomePage homeObject;
	O91_ComparePage compareObject ; 
	O5_SearchPage searchObject;

	@Test(priority = 1)
	public void UserCanCompareProducts() throws InterruptedException {
		searchObject = new O5_SearchPage(driver);
		detailsObject = new O6_ProductDetailsPage(driver);
		compareObject = new O91_ComparePage(driver);

		searchObject.ProductSearchUsingAutoSuggest("MacB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(firstProductName));
		detailsObject.AddProductToCompare();

		searchObject.ProductSearchUsingAutoSuggest("Asus");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().contains(secondProductName));
		detailsObject.AddProductToCompare();
		Thread.sleep(1000);

		driver.navigate().to("http://demo.nopcommerce.com" + "/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.getText().equals("Asus N551JK-XO076H Laptop"));
		Assert.assertTrue(compareObject.secodProductName.getText().equals("Apple MacBook Pro 13-inch"));
		compareObject.CompareProducts();	
	}

	@Test(priority=2)
	public void UserCanClearCompareList() {
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
	}
}
