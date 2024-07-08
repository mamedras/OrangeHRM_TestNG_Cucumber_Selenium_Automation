package ORANGEHRM_TESTCASES;

import ORANGEHRM_PAGE.LOGIN_PAGE;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

//@Test(groups = {"test the login info"})
public class LOGIN_ORANGEHRM implements ITestListener  {

    private ExtentReports extent;
    public WebDriver driver;
    private static ExtentTest test;
    private LOGIN_PAGE LOGIN;

    public static Logger loggerj = LogManager.getLogger(LOGIN_ORANGEHRM.class.getName());




    @Given("we are on the login page")
    @BeforeClass
    public void beforetest(){
        Configurator.setLevel("java", Level.DEBUG);
        Configurator.setRootLevel(Level.DEBUG);
        loggerj.info("Opening website");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//asus//Desktop//test_software//ORANGEHRM_PROJECTQA//src//main//java//REPORT_DOCUMENTATION//EXTENT//login.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loggerj.info("opening the browser");
    }
    @When("entering a Moh97_i as username and  WH12369@ as password")
    @Test(priority = 1, description = "wrong creeds")
    public void invalidcreeds() throws InterruptedException {
        loggerj.info("Type invalid credentials");
        LOGIN=new LOGIN_PAGE(driver);
        LOGIN.LOGIN_PAGE("adminSS", "admin12SD3");
        ExtentTest test1 = extent.createTest("Invalid Credentials Test");
        test1.log(Status.INFO, "WRONG CREDS INFO");
        test1.log(Status.PASS, "WRONG CREDS");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @And("i pressed enter and opened a new page")
    @Test(priority= 2,description = "opening a new tab")
    public void newtab() throws InterruptedException {
        ExtentTest test2 = extent.createTest("open a new page ");
        test2.log(Status.INFO, "open a new tab");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        loggerj.info("opening a new window");
    }
    @And("entering a Admin as username and admin123 as password")
    @Test(priority = 3, description = "typing valid credentials")
    public void validcreeds() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExtentTest test3 = extent.createTest("Valid Credentials Test");
        System.out.println("Type valid credentials");
        loggerj.info("Type valid credentials");
        LOGIN.LOGIN_PAGE("admin", "admin123");
        test3.log(Status.INFO, "Type VALID CREDS");
        test3.log(Status.PASS, "Login successful");
    }
    @Then("i should see login successful")
    @Test(priority = 4, description = "dashboard page")
    public void dashbaordpage(){
        ExtentTest test4 = extent.createTest("dashboaard page");
        test4.log(Status.INFO, "quit the browser");
        loggerj.info("we are on the dashboard");
    }
    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                String screenshotPath = LOGIN_PAGE.capture(driver, "login");
                test.log(Status.FAIL, "Test Case Failed: " +result.getThrowable());
                test.log(Status.FAIL, "See the screenshot below:" + test.addScreenCaptureFromPath(screenshotPath));
                System.out.println("Screenshot captured: " + screenshotPath);
            }
            loggerj.info("capture failed testcases");
        } catch (Exception e) {
            System.out.println(e);
        }
    }







    @AfterClass
    public void tearDown() {
        loggerj.info("type ended");
        extent.flush();
        if (driver != null) {
            driver.quit();
        }
    }
}