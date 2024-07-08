package ORANGEHRM_PAGE;


import ORANGEHRM_TESTCASES.INFO_EMP;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;

import java.util.List;
public class EMPLOYEE_PAGE extends INFO_EMP {

    public EMPLOYEE_PAGE(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.CSS, using = "input[placeholder='Username']")
    private WebElement username;
    @FindBy(how = How.CSS, using = "input[placeholder='Password']")
    private WebElement password;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement submit;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/img")
    private WebElement profile_pic;
    @FindBy(how = How.XPATH,using="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6" )
    private WebElement pim_user ;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]")
    private List <WebElement> MYINFO;
    @FindBy(how = How.CSS,using = "input[placeholder='First Name']")
    private WebElement firstname;
    @FindBy(how = How.CSS, using = "input[placeholder='Last Name']")
    private WebElement secondname;
    @FindBy(how = How.CSS, using = "input[placeholder='Middle Name']")
    private WebElement lastname;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input")
    private WebElement id_employee;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input")
    private WebElement license_driving;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input")
    private WebElement license_expiry;

    @FindBy(how =How.CLASS_NAME,using = "oxd-select-text-input")
    private List<WebElement>nation;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input")
    private WebElement birthdate;
    @FindBy(how = How.CSS,using = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(3) > div:nth-child(5) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
    private WebElement checkbox_gender;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button")
    private WebElement save_button;
    @FindBy(how=How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[2]/button")
    private WebElement save_button2;
    @FindBy(how=How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[1]/div/button")
    private WebElement add_attachement;
    @FindBy(how = How.CSS,using = "input[type='file']")
    private WebElement uploadfile;
    @FindBy(how =How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]")
    private WebElement  save_file;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[3]/div/div[2]/div/div/div[8]/div/button[2]")
    private WebElement delete_img;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    private WebElement delete_confirmation;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[2]/div/img")
    private WebElement profile_user;
    @FindBy(how = How.CSS,using = "input[type='file']")
    private WebElement upload_profile;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[2]/button")
    private WebElement save_pic;
    public void login(String usernames, String passwords) {
        username.sendKeys(usernames);
        password.sendKeys(passwords);
        submit.click();
    }
    public List<WebElement> EMPLOYEE_INFO(){
        return MYINFO;
    }
    public void contact_info(){
    }
    public void EMPLOYEE_NAME(String FNAME,String MNAME,String LNAME){
        firstname.sendKeys(Keys.CONTROL + "a");
        firstname.sendKeys(Keys.BACK_SPACE);
        firstname.sendKeys(Keys.DELETE);
        firstname.clear();
        firstname.sendKeys(FNAME);
        secondname.sendKeys(Keys.CONTROL + "a");
        secondname.sendKeys(Keys.DELETE);
        secondname.sendKeys(MNAME);
        lastname.sendKeys(Keys.CONTROL + "a");
        lastname.sendKeys(Keys.DELETE);
        lastname.sendKeys(LNAME);
    }
    public void EMPLOYEE_ID(String ID,String Driving_license,String Driving_expiry){
        id_employee.sendKeys(Keys.CONTROL + "a");
        id_employee.sendKeys(Keys.BACK_SPACE);
        id_employee.sendKeys(Keys.DELETE);
        id_employee.sendKeys(ID);
        license_expiry.sendKeys(Keys.CONTROL + "a");
        license_expiry.sendKeys(Keys.BACK_SPACE);
        license_expiry.sendKeys(Keys.DELETE);
        license_expiry.sendKeys(Driving_expiry);
        license_driving.sendKeys(Driving_license);
    }
    public void scrollDown(){
        JavascriptExecutor nationality = (JavascriptExecutor) driver;
        // Scroll down by a specific pixel value. Adjust as needed.
        nationality.executeScript("window.scrollBy(0, 120)");
    }
    public void EMPLOYEE_INFORMATION(){
        WebElement nationalityButton =  nation.get(0);
        nationalityButton.sendKeys("m");
        nationalityButton.sendKeys(Keys.ARROW_DOWN);
        nationalityButton.sendKeys(Keys.ARROW_DOWN);
        nationalityButton.sendKeys(Keys.ENTER);
    }
    public void selectMartialStatus() {
        WebElement status = nation.get(1);
        status.sendKeys(Keys.ARROW_DOWN);
        status.sendKeys(Keys.ENTER);
        JavascriptExecutor nationality = (JavascriptExecutor) driver;
        // Scroll down by a specific pixel value. Adjust as needed.
        nationality.executeScript("window.scrollBy(0, 74)");
    }
    public void emp_gender(){
        checkbox_gender.click();
    }
    public void selectbloodtype(){
        WebElement blood=nation.get(2);
        blood.sendKeys(Keys.ARROW_DOWN);
        blood.sendKeys(Keys.ENTER);
    }
    public void upload(String file){
        add_attachement.click();
        uploadfile.sendKeys(file);
        save_file.click();
        delete_img.click();
        delete_confirmation.click();
        save_button2.click();
    }
    public void Birthdate_info(String Birthday){
        birthdate.sendKeys(Keys.CONTROL + "a");
        birthdate.sendKeys(Keys.BACK_SPACE);
        birthdate.sendKeys(Keys.DELETE);
        birthdate.sendKeys(Birthday);
        save_button.click();
    }
    public void profile_picture() {
        profile_pic.isDisplayed();
        profile_pic.getAttribute("src");
    };
    public void PIM_TITLE(){
        pim_user.getAttribute("h6");
        pim_user.isDisplayed();
        String pim_info=pim_user.getText();
        System.out.println("pim title :"+pim_info);
    }
    public void picture(String pic){
        profile_user.click();
        upload_profile.sendKeys(pic);
        save_pic.click();
    }
    }
