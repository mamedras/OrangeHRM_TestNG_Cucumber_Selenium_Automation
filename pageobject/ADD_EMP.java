package ORANGEHRM_PAGE;
import ORANGEHRM_TESTCASES.NEW_USER;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.util.List;

public class ADD_EMP extends NEW_USER {

    public ADD_EMP(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.CSS, using = "input[placeholder='Username']")
    private WebElement username;
    @FindBy(how = How.CSS, using = "input[placeholder='Password']")
    private WebElement password;
    @FindBy(how =How.XPATH,using ="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement button;
    @FindBy(how = How.CLASS_NAME,using = "oxd-main-menu-item-wrapper")
    private List<WebElement> menu;
    @FindBy(how = How.CSS,using = "input[type='file']")
    private WebElement photo;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    private WebElement add_user;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")
    private WebElement name;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input")
    private WebElement middle_name;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")
    private WebElement last_name;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    private WebElement id_user;
    @FindBy(how = How.CSS,using = "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div.oxd-form-row.user-form-header > div" )
    private WebElement checkbox;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
    private WebElement username_emp;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input" )
    private WebElement password_emp;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")
    private WebElement confirm_password;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
    private WebElement Click;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")
    private WebElement Logout ;
    @FindBy(how = How.CLASS_NAME,using = "oxd-userdropdown")
    private WebElement dropdown;
    @FindBy(how = How.CSS,using = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(3) > div:nth-child(5) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
    private WebElement checkbox_gender;
    public void LOGIN_PAGE(String Username,String Password) {
        username.sendKeys(Username);
        password.sendKeys(Password);
        button.click();
    }
    public List<WebElement> EMPLOYEE_INFO(){
        return menu;
    }
    public void upload(String img){
        photo.sendKeys(img);
    }
    public void users(String username, String fname, String mname, String lname, String id, String password, String confirm){
        //pim.click();
        add_user.click();
        name.sendKeys(fname);
        middle_name.sendKeys(mname);
        last_name.sendKeys(lname);
        id_user.sendKeys(Keys.CONTROL + "a");
        id_user.sendKeys(Keys.BACK_SPACE);
        id_user.sendKeys(id);
        checkbox.click();
        username_emp.sendKeys(username);
        password_emp.sendKeys(password);
        confirm_password.sendKeys(confirm);
        Click.click();
    }
    public void emp_gender(){
        checkbox_gender.click();
    }
    public void scrollDown(){
        JavascriptExecutor nationality = (JavascriptExecutor) driver;
        // Scroll down by a specific pixel value. Adjust as needed.
        nationality.executeScript("window.scrollBy(0, 120)");
    }
    public void scrolldown_bottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void logout(){
        dropdown.click();
        Logout.click();
    }

}
