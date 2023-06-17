package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;

public class O1_TestBase extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

	@BeforeSuite
	@Parameters({ "browser" })
	public void start_driver(@Optional("chrome") String browser_name) throws InterruptedException {

		if (browser_name.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.navigate().to("https://demo.nopcommerce.com/");
			Thread.sleep(2000);
		}

		else if (browser_name.equalsIgnoreCase("chrome_headless")) {

			ChromeOptions co = new ChromeOptions();
			// co.setHeadless(true); I clicked on setHeadless and I found that my chrome
			// version is high so I used the below method for headless testing
			co.addArguments("--headless=new");
			driver = new ChromeDriver(co);
			driver.manage().window().maximize();
			driver.navigate().to("https://demo.nopcommerce.com/");

		}

		// It is a phantom method and it was out dated

		/*
		 * 
		 * else if (browser_name.equalsIgnoreCase("headless")) { DesiredCapabilities
		 * caps = new DesiredCapabilities(); caps.setJavascriptEnabled(true); // String
		 * filePath = System.getProperty("user.dir") + "/drivers/phantomjs.exe"; String
		 * filepath2 = System.getProperty("user.dir") + "\\drivers\\phantomjs.exe";
		 * System.out.println(filepath2);
		 * caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
		 * filepath2); String[] phantomJSarg = { "--web-security=no",
		 * "--ignore-ssl-errors=yes" };
		 * caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJSarg);
		 * driver = new PhantomJSDriver(caps); }
		 */


	}

// ----------------------------------------------------------------------------------------
	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}

// ---------------------------------------------------------------------------------------- // 

	// take screenshot when test case fail and add it in the Screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}
