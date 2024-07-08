package ORANGEHRM_PAGE;
import ORANGEHRM_TESTCASES.CONTACT_EMP;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class EMPLOYEE_DETAILS extends CONTACT_EMP {

    public EMPLOYEE_DETAILS(WebDriver driver) {
       this.driver=driver;
       PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.CSS, using = "input[placeholder='Username']")
    private WebElement username;
    @FindBy(how = How.CSS, using = "input[placeholder='Password']")
    private WebElement password;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement submit;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]")
    private List <WebElement> MYINFO;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]")
    private  WebElement INFO;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input")
    private WebElement first_street;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/a")
    private WebElement contact;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input")
    private WebElement second_street;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[3]/div/div[2]/input")
    private WebElement city;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[4]/div/div[2]/input")
    private WebElement State_province;
    @FindBy(how = How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/input")
    private WebElement zip_postal;
    @FindBy(how = How.CLASS_NAME,using="oxd-select-text-input")
    private List<WebElement> country;
    @FindBy(how = How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div[2]/input")
    private WebElement home;
    @FindBy(how = How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input")
    private WebElement mobile;
    @FindBy(how = How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[3]/div/div[2]/input")
    private static WebElement work;
    @FindBy(how = How.XPATH,using="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[1]/div/div[2]/input")
    private WebElement workemail;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[2]/div/div[2]/input")
    private WebElement otheremail;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button")
    private WebElement btn_save;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/button")
    private WebElement btn_attachement;
    @FindBy(how = How.CSS,using = "input[type='file']")
    private WebElement upload_attachement;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[3]/button[2]")
    private WebElement save_attachement;

    public void login(String Username,String Password){
        username.sendKeys(Username);
        password.sendKeys(Password);
        submit.click();
    }
    public List<WebElement> addresse_info(){
        return MYINFO;
    }
    public void empContact() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
        WebElement contactInfo = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/a"));
        contactInfo.getAttribute("a");
        contactInfo.click();
    }
    public void addresse_employee(String s1, String s2, String city_emp){
        first_street.sendKeys(s1);
        second_street.sendKeys(s2);
        city.sendKeys(city_emp);
        JavascriptExecutor addresse = (JavascriptExecutor) driver;
        // Scroll down by a specific pixel value. Adjust as needed.
        addresse.executeScript("window.scrollBy(0, 65)");

        WebElement nationalityButton=country.get(0);
        nationalityButton.sendKeys("m");
        nationalityButton.sendKeys(Keys.ARROW_DOWN);
        nationalityButton.sendKeys(Keys.ARROW_DOWN);
        nationalityButton.sendKeys(Keys.ENTER);
    }
    public void addresse_employee2(String state, String zipcode){
        State_province.sendKeys(state);
        zip_postal.sendKeys(zipcode);
        JavascriptExecutor addresse = (JavascriptExecutor) driver;
        // Scroll down by a specific pixel value. Adjust as needed.
        addresse.executeScript("window.scrollBy(0, 98)");
    }
    public void telephone_phone(String home_emp, String mobile_emp, String work_number){
        //home.sendKeys(Keys.CONTROL+"a");
        //home.sendKeys(Keys.DELETE);
        home.sendKeys(home_emp);
        mobile.sendKeys(mobile_emp);
        work.sendKeys(Keys.CONTROL + "a");
        work.sendKeys(Keys.DELETE);
        work.sendKeys(work_number);
    }
    public void mail(String email_emp, String email){
        otheremail.sendKeys(email);
        workemail.sendKeys(Keys.CONTROL+"a");
        workemail.sendKeys(Keys.DELETE);
        workemail.sendKeys(email_emp);
        btn_save.click();
    }
    public void attchement_uploading(String path){
        btn_attachement.click();
        upload_attachement.sendKeys(path);
        save_attachement.click();
    }

}
