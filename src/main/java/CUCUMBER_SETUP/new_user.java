package CUCUMBER_SETUP;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
        features = "src/main/resources/featurebdd/NEW_EMPLOYEE.feature",
        glue = "ORANGEHRM_TESTCASES",
        tags = "@SmokeTest",
        plugin = {"pretty","html:target/newuser-reports.html","json:target/new_user.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class new_user extends AbstractTestNGCucumberTests {
}
