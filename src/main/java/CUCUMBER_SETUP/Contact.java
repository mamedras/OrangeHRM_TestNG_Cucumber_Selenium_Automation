package CUCUMBER_SETUP;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
@CucumberOptions(
        features = "src/main/resources/featurebdd/User_Details.feature",
        glue = "ORANGEHRM_TESTCASES",
        tags = "@SmokeTest",
        plugin = {"pretty", "html:target/contact-reports.html","json:target/contact-reports.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Contact extends AbstractTestNGCucumberTests {
}
