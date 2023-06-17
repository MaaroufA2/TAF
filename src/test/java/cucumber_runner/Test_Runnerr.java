package cucumber_runner;

import io.cucumber.testng.CucumberOptions;
import tests.O1_TestBase;

@CucumberOptions(features = "src\\test\\java\\cucumber_feature", glue = { "steps" }, plugin = { "pretty",
		"html:target/cucumber-html-report" })
public class Test_Runnerr extends O1_TestBase {

	
}
