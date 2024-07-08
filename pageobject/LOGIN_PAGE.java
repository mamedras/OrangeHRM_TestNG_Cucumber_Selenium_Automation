package ORANGEHRM_PAGE;
import ORANGEHRM_TESTCASES.LOGIN_ORANGEHRM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class LOGIN_PAGE extends LOGIN_ORANGEHRM {

    public LOGIN_PAGE(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.CSS, using = "input[placeholder='Username']")
    private WebElement username;
    @FindBy(how = How.CSS, using = "input[placeholder='Password']")
    private WebElement password;
    @FindBy(how =How.XPATH,using ="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement button;
    public void LOGIN_PAGE(String Username, String Password) {
        username.sendKeys(Username);
        password.sendKeys(Password);
        button.click();
    }


    }


