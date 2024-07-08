package ORANGEHRM_TESTCASES;
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
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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
//@Test(groups = {"modify the main user info"})
public class INFO_EMP implements ITestListener {
    public static Logger loggerj = LogManager.getLogger(INFO_EMP.class.getName());
    public static WebDriver driver;
    private EMPLOYEE_PAGE Myinfo;
    private ExtentReports extent;
    private ExtentTest test;


    @Given("WE ARE ON THE LOGIN DASHBOARD PAGE")
    @BeforeClass
    public void beforetest() throws InterruptedException {
        Configurator.setLevel("java", Level.DEBUG);
        Configurator.setRootLevel(Level.DEBUG);
        System.out.println("starting test scenario");
        ExtentSparkReporter htmlReporter = new  ExtentSparkReporter("C://Users//asus//Desktop//ORANGEHRM_QA//src//main//java//REPORT_DOCUMENTATION//EXTENT//info.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        loggerj.info("report file created");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Myinfo = new EMPLOYEE_PAGE(driver);
        Myinfo.login("Admin", "admin123");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExtentTest test1 = extent.createTest("login page");
        test1.log(Status.INFO, "Type USERNAME AND THE PASSWORD");
        test1.log(Status.PASS, "LOGIN SUCCESSFUL");
        loggerj.info("login dashboard");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }
    public void writeDataToCSV() throws IOException {
        String filePath = "C://Users//asus//Desktop//ORANGEHRM_QA//CSVFILE//user2.csv";
        // Define column headers
        String[] headers = {"fname","mname","lname","Employee Id", "Driver's License Number","License Expiry Date","Nationality","Marital Status","Date of Birth","Gender","blood type"};
        Object[][] testData={

                {"MOHAMED","AMINE","ROUADI","K-012356","978545321398","2025-06-01","moroccan","Single","1990-11-12","male","A+"},
                {"SAMY","AMEZIANE","HASSANI","A-024566","587447321398","2023-03-11","moroccan","SINGLE","2001-01-22","male","AB+"},
                {"JADE","","SMITH","M-064586","1234567892","2027-02-01","AMERICAN","DIVORCED","1988-08-12","female","O-"},
                {"MOAHMED","","AGAMY","l-023596","09234567892","2029-12-11","EGYPTIAN","Married","2002-09-13","male","B+"}
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
    //"MOHAMED","AMINE","ROUADI","K-012356","978545321398","2025-06-01","moroccan","Single","1990-11-12","male","A+"
    @DataProvider(name = "create")
    public Object[][] dataset() {
        return new Object[][]{
                {"MOHAMED", "AMINE", "ROUADI","K-01235", "978545321398", "2025-06-01", "moroccan", "single", "1990-11-12", "male", "A+"}

        };
    }
    @Test(dataProvider = "create",groups = {"modify the main user info"})
    public void employeeInfo2(Object[] employeeData) {
        String FNAME = (String) employeeData[0];
        String MNAME = (String) employeeData[1];
        String LNAME = (String) employeeData[2];
        String ID = (String) employeeData[3];
        String LICENSE= (String) employeeData[4];
        String DRIVINGL_NUM= (String) employeeData[5];
        String DRIVING_EXPIRY= (String) employeeData[6];
        String NATION= (String) employeeData[7];
        String MARTIAL_STATUS= (String) employeeData[8];
        String Birthdate=(String) employeeData[9];
        String Sex=(String) employeeData[10];
        System.out.println(FNAME+" : "+MNAME+" : "+LNAME+" : "+ID+" :"+LICENSE+" :"+DRIVINGL_NUM+" :"+DRIVING_EXPIRY+" : "+NATION+" : "+MARTIAL_STATUS+" : "+Birthdate+" :  "+Sex);

        // Rest of the method implementation here
    }
    @Then("HEADING TO EMPLOYEE`S INFO")
    @Test(priority = 1, description = "dashboard page")
    public void info() throws Exception{
        Thread.sleep(5000);
        WebElement dash = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
        dash.getAttribute("h6");
        dash.isDisplayed();
        String dashboard =dash.getText();
        System.out.println("Dashboard Title: " + dashboard);
        Myinfo.profile_picture();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> elements = Myinfo.EMPLOYEE_INFO();
        for(WebElement e : elements){
            e.getAttribute("li");
            e.click();
        }
        loggerj.info("heading to info page");
    }
    @When("MODIFYING MAIN EMPLOYEE INFORMATION SUCH AS NAME DRIVING LICENSE BIRTHDATE AND ETC")
    @Test(priority = 2, description = "modifying employee info")
    public void user_page() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Myinfo.PIM_TITLE();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Myinfo.EMPLOYEE_NAME("MOHAMED","AMINE","ROUADI");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Myinfo.EMPLOYEE_ID("K-012356","978545321358","2025-06-01");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Myinfo.scrollDown();
        Myinfo.EMPLOYEE_INFORMATION();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Myinfo.selectMartialStatus();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Myinfo.Birthdate_info("1990-11-12");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Myinfo.emp_gender();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loggerj.info("modify the personal info");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Myinfo.selectbloodtype();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExtentTest test2 = extent.createTest("modify info like name bithdate and etc");
        test2.log(Status.INFO, "modify his name driving license and his birthdate");
        test2.log(Status.PASS, "other info like nationality blood type martial status and upload attachemnt and finally update his profile picture ");
    }
    @And("UPLOAD EMPLOYEE FILE")
    @Test(priority = 3, description = "upload attachement")
    public void user_attachement() throws InterruptedException {
        Myinfo.upload("C://Users//asus//Downloads//hrm.jpeg");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loggerj.info("upload the file");
    }
    @Then("UPDATE PROFILE PICTURE SAVE AND APPLY THE MODIFICATION")
    @Test(priority = 4, description = "change profile picture")
    public void check_update() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExtentTest test3 = extent.createTest("upload picture");
        test3.log(Status.INFO, "modify his name driving license and his birthdate");
        test3.log(Status.PASS, "other info like nationality blood type martial status and upload attachemnt and finally update his profile picture ");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().refresh();
        Myinfo.picture("C://Users//asus//Downloads//hrm.jpeg");
        loggerj.info("upadte the profile picture");
    }
    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        try {
            if (testResult.getStatus() == ITestResult.FAILURE) {
                String screenshotPath = EMPLOYEE_PAGE.capture(driver, "info");
                test.log(Status.FAIL, "Test Case Failed: " + testResult.getThrowable());
                test.log(Status.FAIL, "See the screenshot below:" + test.addScreenCaptureFromPath(screenshotPath));
                System.out.println("Screenshot captured: " + screenshotPath);
            }
            loggerj.info("capture failed testcases");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @AfterClass
    public void quit_browser() {
        extent.flush();
        if (driver != null) {
            driver.quit();
        }
    }

}

