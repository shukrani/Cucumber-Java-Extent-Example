
package com.example.ui.runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.example.ui.helper.BaseWeb;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestResult;
import org.testng.annotations.*;

@CucumberOptions(features = { "src/test/resources/features" }, glue = {
		"com/example/ui/stepdefinitions" }, tags = "@LoginTest", plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-report.json" })
public class TestRunner {

	private TestNGCucumberRunner cucumberRunner;
	ExtentReports extent;
	ExtentTest test;

	@BeforeSuite
	public void setupEnvironment() {


	}

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		cucumberRunner = new TestNGCucumberRunner(TestRunner.class);

	}

	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
		cucumberRunner.runScenario(pickle.getPickle());
	}

	@BeforeTest
	public void geturl() {
		BaseWeb.getDriver();
	}

	@AfterTest
	public void tearDown() {
		BaseWeb.closeBrowser();
	}

	@AfterMethod
	public void cleanup(ITestResult result) {
		BaseWeb.takeScreenshot(result.getName());

	}

	@DataProvider
	public Object[][] scenarios() {
		return cucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		cucumberRunner.finish();
	}

}
