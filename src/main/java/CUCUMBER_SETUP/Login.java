package CUCUMBER_SETUP;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/main/resources/featurebdd/login.feature",
        glue = "ORANGEHRM_TESTCASES",
        tags = "@SmokeTest",
        plugin = {"pretty", "html:target/login-reports.html","json:target/login-reports.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Login extends AbstractTestNGCucumberTests {
}

