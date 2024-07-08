package ORANGEHRM_PAGE;
import ORANGEHRM_TESTCASES.LOGIN_ORANGEHRM;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.sr_latn.I;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


import java.io.File;
import java.io.IOException;

public class LOGIN_PAGE extends LOGIN_ORANGEHRM{

    public LOGIN_PAGE(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.CSS, using = "input[placeholder='Username']")
    private static WebElement username;
    @FindBy(how = How.CSS, using = "input[placeholder='Password']")
    private static WebElement password;
    @FindBy(how =How.XPATH,using ="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private static WebElement button;
    public static void LOGIN_PAGE(String Username, String Password) {
        username.sendKeys(Username);
        password.sendKeys(Password);
        button.click();
    }
    public static String capture(WebDriver driver,String screenshotname) throws IOException {
        screenshotname = screenshotname + ".png";
        String path = "C://Users//asus//Desktop//ORANGEHRM_QA//screenshot//";
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File(path + screenshotname));
        return path + screenshotname;
    }


    }


