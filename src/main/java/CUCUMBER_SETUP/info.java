package CUCUMBER_SETUP;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/main/resources/featurebdd/employee.feature",
        glue = "ORANGEHRM_TESTCASES",
        tags = "@SmokeTest",
        plugin = {"pretty", "html:target/info-reports.html","json:target/info-reports.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class info extends AbstractTestNGCucumberTests{
}
