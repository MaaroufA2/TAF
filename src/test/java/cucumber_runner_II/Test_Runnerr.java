package cucumber_runner_II;

import io.cucumber.testng.CucumberOptions;
import tests.O1_TestBase;

@CucumberOptions(features = "src\\test\\java\\cucumber_feature_II", glue = { "steps_II" }, plugin = { "pretty",
		"html:target/cucumber-html-report" })
public class Test_Runnerr extends O1_TestBase {

	
}
