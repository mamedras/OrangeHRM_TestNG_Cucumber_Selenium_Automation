package ORANGEHRM_TESTCASES;

import ORANGEHRM_PAGE.ADD_EMP;
import ORANGEHRM_PAGE.EMPLOYEE_DETAILS;
import ORANGEHRM_PAGE.EMPLOYEE_PAGE;
import ORANGEHRM_PAGE.LOGIN_PAGE;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
//@Test(groups = {"NEW PIM USER"})
public class NEW_USER implements ITestListener {
    public static WebDriver driver;
    private ADD_EMP users;
    private EMPLOYEE_PAGE info;
    public static Logger loggerj = LogManager.getLogger(NEW_USER.class.getName());
    private ExtentReports extent;
    private ExtentTest test;
    //private utiltyreports reporting;
    //private List<ITestResult> failedTests = new ArrayList<>();
    private EMPLOYEE_DETAILS contacts;
    @Given("LAUNCHING BROWSER WE`RE AT THE DASHBOARD PAGE")
    @BeforeClass
    public void setup() throws Exception{
        ExtentSparkReporter htmlReporter = new  ExtentSparkReporter("C://Users//asus//Desktop//ORANGEHRM_QA//src//main//java//REPORT_DOCUMENTATION//EXTENT//newuser.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        loggerj.info("report file created");
        //System.setProperty("webdriver.chrome.driver", "C://Users//asus//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        users=new ADD_EMP(driver);
        users.LOGIN_PAGE("admin","admin123");
        ExtentTest test1 = extent.createTest("LOGIN");
        test1.log(Status.INFO, "Type VALID CREEDS");
        test1.log(Status.PASS, "LOGIN SUCCESSFUL");
        loggerj.info("LOGIN PAGE");
        loggerj.info("ENTER THE USERNAME AND PASSWORD THAT ARE SHOWN ON THE SCREEN ");
        loggerj.info("LOGIN SUCCESSFUL");
    }
    public void writeDataToCSV() throws IOException {
        String filePath = "C://Users//asus//Desktop//ORANGEHRM_QA//CSVFILE//user.csv";
        // Define column headers
        String[] headers = {"username","fname", "mname", "lname", "employeeid","password","confirm"};
        Object[][] testData ={
                {"AERO1234@","ahmed","said","hassan","01234","ensakh14@","ensakh14@"},
                {"YUSFHD66@","youssef","","hadfi","02454","ensakh25@","ensakh25@"},
                {"YUSFHD63@","aziz","","ifrane","03254","ensakh126@","ensakh126@"},
                {"YUSFHD43@","imad","","hafidi","06254","Usmsc69@","Usmsc69@"}
        };
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();
        // Create a new sheet
        Sheet sheet = workbook.createSheet("Sheet1");
        // Create a font with bold style for headers
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        // Create a cell style with border and font for headers
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setFont(headerFont);
        // Create a row for column headers
        Row headerRow = sheet.createRow(0);
        // Write column headers
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }
        // Create a cell style with border for data cells
        CellStyle dataCellStyle = workbook.createCellStyle();
        dataCellStyle.setBorderBottom(BorderStyle.THIN);
        dataCellStyle.setBorderTop(BorderStyle.THIN);
        dataCellStyle.setBorderRight(BorderStyle.THIN);
        dataCellStyle.setBorderLeft(BorderStyle.THIN);
        // Write data into subsequent rows
        for (int i = 0; i < testData.length; i++) {
            Row row = sheet.createRow(i + 1); // Start from row 1
            Object[] rowData = testData[i];
            for (int j = 0; j < rowData.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(String.valueOf(rowData[j]));
                cell.setCellStyle(dataCellStyle); // Apply border style to data cells
            }
        }
        // Autosize columns to fit content
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
        // Write the workbook content to a file
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
        // Close the workbook
        workbook.close();
        System.out.println("CSV file with borders created successfully.");
    }
    @DataProvider(name = "create")
    public Object[][] dataset() throws IOException {
        Object[][] data = new Object[1][7];
        data[0][0] = "AERO1234@"; // username
        data[0][1] = "ahmed"; // fname
        data[0][2] = "said"; // mname
        data[0][3] = "hassan"; // lname
        data[0][4] ="01234"; //ide
        data[0][5] = "ensakh14@"; //password
        data[0][6] = "ensakh14@"; //password
        return data;
    }
    @Test(dataProvider = "create",groups = {"Personal Employee info"})
    public void employeeInfo2(String username,String fname,String mname,String lname,String id,String password,String password_confirm  ){
        System.out.println("USERNAME: " + username);
        System.out.println("FNAME: " + fname);
        System.out.println("MANAME:" + mname);
        System.out.println("lname:"+lname);
        System.out.println("id:" +id);
        System.out.println("password:"+ password);
        System.out.println("password_confirm:"+password_confirm);
    }
    @And("AFTER LOGIN HEAD TO PIM EMPLOYEE PAGE")
    @Test(priority = 1,description = "heading to pim")
    public void pim_page() throws InterruptedException {
        WebElement dash = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
        dash.getAttribute("h6");
        dash.isDisplayed();
        String dashboard = dash.getText();
        System.out.println("Dashboard Title: " + dashboard);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement pic=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/img"));
        pic.isDisplayed();
        pic.getAttribute("src");
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        List<WebElement> elements = users.EMPLOYEE_INFO();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        elements.get(1).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExtentTest test2 = extent.createTest("HEADING TO PIM");
        test2.log(Status.INFO, "TO PIM PAGE");
        test2.log(Status.PASS, "HEADING TO PIM SUCCESSFUL");
        loggerj.info("REDIRECTION TO PIM PAGE");
    }
    @When("ADD A USERNAME AND PASSWORD AND ADD THE FULL NAME")
    @Test(priority = 2,description = "adding a new user")
    public void use_new() throws InterruptedException {
        users.users("AERO1234@","ahmed","said","hassan","012345","ensakh14@","ensakh14@");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        info= new EMPLOYEE_PAGE(driver);
        ExtentTest test3 = extent.createTest("TYPING NEW USER");
        test3.log(Status.INFO, "Type SERNAME PASSWORD FIRST NAME AND LAST NAME");
        test3.log(Status.PASS, "ADDING A NEW USER SUCCESSFUL");
        loggerj.info("ADDING A NEW USER");
        loggerj.info("ADD A USERNAME AND PASSWORD  AND OTHER INFO LIKE EMPLOYEE FULL NAME");
        loggerj.info("USER ADDED");
    }
    @And("ADD HIS PERSONAL CREDENTIALS")
    @Test(priority = 3,description = "MODIFY PERSONAL INFO")
    public void login_newuser()throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        info.EMPLOYEE_NAME("amine","allali","moahmed");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        info.EMPLOYEE_ID("012345","A1234568","2028-09-12");
        info.scrollDown();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        info.EMPLOYEE_INFORMATION();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        info.selectMartialStatus();
        info.scrollDown();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        info.Birthdate_info("1999-05-12");
        info.emp_gender();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        info.selectbloodtype();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        info.upload("C://Users//asus//download.jpg");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().refresh();
        info.picture("C://Users//asus//download.jpg");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExtentTest test4 = extent.createTest("ADDING PERSONAL INFO");
        test4.log(Status.INFO, "ADDING THE PERSONAL INFO SUCH AS DRIVING LICENSE AND BLOOD TYPE AND ETC");
        test4.log(Status.PASS, "PERSONAL INFO ADDED SUCCESSFULLY");
        loggerj.info("MODIFIY HIS PERSONAL INFORMATION");
        loggerj.info("MODIFIY HIS PERSONAL INFORMATION SUCH AS DRIVING LICENSE AND BLOOD TYPE");
        loggerj.info("UPLOAD THE ATTACHMENT AND UPLOAD THE PROFILE PICTURE ");
        loggerj.info("INFO ADDED AND PICTURE UPDATED");
    }
    @Then("ADD HIS CONTACT AND ATTACHMENT FILE AND PRESS SAVE")
    @Test(priority = 4, description = "modifying user contact info")
    public void contact() throws InterruptedException {
        WebElement contactInfo = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/a"));
        contactInfo.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        contacts=new EMPLOYEE_DETAILS(driver);
        contacts.addresse_employee("sid khadir","big belt","casablanca");
        info.EMPLOYEE_INFORMATION();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        contacts.addresse_employee2("casablanca","20000");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        contacts.telephone_phone("08234567438","03244566449","01234537438");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        contacts.mail("hitori1999dakeno@gmail.com","ibmnoreply@gmail.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExtentTest test5 = extent.createTest("ADDING THE NEW EMPLOYEE CONTACT");
        test5.log(Status.INFO, "ADD INFO SUCH AS STREET POSTAL CITY AND EMAIL ADDRESS ");
        test5.log(Status.PASS, "ADDING INFO SUCCESSFUL");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement SEARCH_USER=driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > header:nth-child(2) > div:nth-child(2) > nav:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)"));
        SEARCH_USER.click();
        WebElement Search_id=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input"));
        Search_id.sendKeys("012345");
        Search_id.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        users.scrolldown_bottom();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExtentTest test6 = extent.createTest("searching the added employee user ");
        test6.log(Status.INFO, "search by id ");
        test6.log(Status.PASS, "record found");
        loggerj.info("modifying user contact info");
        loggerj.info("modifying user contact info such as street postal and email and etc...");
        loggerj.info("seraching the added employee by id");
        loggerj.info("record found");
        users.logout();
    }
    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                String screenshotPath = ADD_EMP.capture(driver, "adduser");
                //screenshot(result);
                test.log(Status.FAIL, "Test Case Failed: " + result.getThrowable());
                test.log(Status.FAIL, "See the screenshot below:" + test.addScreenCaptureFromPath(screenshotPath));
                System.out.println("Screenshot captured: " + screenshotPath);
            }
            loggerj.info("capture failed testcases");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @AfterClass
    public void s1(){
        extent.flush();
        if (driver != null) {
            driver.quit();
        };
    }
}
