package ORANGEHRM_TESTCASES;

import ORANGEHRM_PAGE.EMPLOYEE_DETAILS;
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
//@Test(groups = {"contact info"})
public class CONTACT_EMP implements ITestListener {
    public static WebDriver driver;
    private EMPLOYEE_DETAILS CONTACT_EMPLOYEE;

    private ExtentReports extent;
    private ExtentTest test;
    public static Logger loggerj = LogManager.getLogger(CONTACT_EMP.class.getName());
    //private List<ITestResult> failedTests = new ArrayList<>();

    @Given("LOGIN PAGE")
    @BeforeClass
    public void setup() throws InterruptedException {
        Configurator.setLevel("java", Level.DEBUG);
        Configurator.setRootLevel(Level.DEBUG);
        System.out.println("starting test scenario");
        ExtentSparkReporter htmlReporter = new  ExtentSparkReporter("C://Users//asus//Desktop//ORANGEHRM_QA//src//main//java//REPORT_DOCUMENTATION//EXTENT//contact.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        loggerj.info("report file created");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //System.setProperty("webdriver.chrome.driver", "C://Users//asus//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loggerj.info("browser opened");

        //String expectedTitle = "OrangeHRM";
        //String originalTitle = driver.getTitle();
        //Assert.assertEquals(originalTitle, expectedTitle);
        CONTACT_EMPLOYEE = new EMPLOYEE_DETAILS(driver);
        CONTACT_EMPLOYEE.login("Admin", "admin123");
        loggerj.info("username and password entered");
        ExtentTest test1 = extent.createTest("login dashboard");
        test1.log(Status.INFO, "Type valid username and password");
        test1.log(Status.PASS, "login successful");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void writeDataToCSV() throws IOException {
        String filePath = "C://Users//asus//Desktop//ORANGEHRM_QA//CSVFILE//test1.csv";
        // Define column headers
        String[] headers = {"s1", "s2", "city", "state","postal","nationality","home","mobile","work","email","other"};
        Object[][] testData = {
                {"choiab al dokali", "al mowahidine", "ouedzem", "khouribga", "125600","moroccan", "08234567438", "03244566449", "01234537438", "micheal@hotmail.com", "IBMTEAM@gmail.com"},
                {"2 maras", "sidi maarof", "casablanca", "casablanca-settat", "20000","moroccan", "07854931238", "03342153567", "03546778912", "haj98@gmail.com", "ENSAKH23@gmail.com"},
                {"abdelmomen", "almaarif", "casablanca", "casablanca-grand", "20000", "moroccan","06532521238", "02441153567", "02316778911", "maacha@gmail.com", "DELOITTE24@gmail.com"},
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
    @DataProvider(name = "test")
    public Object[][] provideTestData2() {
        return new Object[][] {
                { new String[] {"choiab al dokali", "al mowahidine","ouedzem", "khouribga","125600","moroccan","08234567438","03244566449", "01234537438","micheal@hotmail.com", "IBMTEAM@gmail.com"} },
        };
    }
    @Test(dataProvider = "test",groups = {"Personal Employee info"})
    public void employeeInfo2(String [] data){
        String s1 = data[0];
        String s2 = data[1];
        String city = data[2];
        String province=data[3];
        String postal = data[4];
        String country = data[5];
        String home = data[6];
        String mobile = data[7];
        String work= data[8];
        String email = data[9];
        String other = data[10];
        System.out.println(" S1: " + s1 + " S2:" + s2 + " CITY:" + city + " PROVINCE: " + province + " POSTAL: " + postal + " COUNTRY:  " +country + "HOME:" + home +  " MOBILE: " + mobile + " WORK: " + work + " EMAIL:" + email + " OTHER:" + other);
    }
    @And("HEADING TO EMPLOYEE`S CONTACTS")
    @Test(priority=1,groups = {"sanity"})
    public void emp() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement dash = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
        dash.getAttribute("h6");
        dash.isDisplayed();
        String dashboard =dash.getText();
        System.out.println("Dashboard Title: " + dashboard);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        List<WebElement> elements = CONTACT_EMPLOYEE.addresse_info();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        for(WebElement e : elements){
            e.getAttribute("li");
            e.click();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loggerj.info("heading to info page");
        ExtentTest test2 = extent.createTest("dashboard page");
        test2.log(Status.INFO, "HEAD TO INFO PAGE AND THEN HEAD TO CONTACT");
        test2.log(Status.PASS, "heading to CONTACT page");
    }
    @When("MODIFYING THE MAIN INFORMATION LIKE POSTAL CODE AND CITY AND ETC..")
    @Test(priority=2,groups = {"regression"})
    public void emp_contact() throws InterruptedException {
        CONTACT_EMPLOYEE.empContact();
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
        //WebElement contactInfo = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/a"));
        //contactInfo.click();
        //contact_info.getAttribute("a");
        //contact_info.isSelected();
        //..contact_info.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        CONTACT_EMPLOYEE.addresse_employee("choiab al dokali","al mowahidine","ouedzem");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        CONTACT_EMPLOYEE.addresse_employee2("khouribga","125600");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        CONTACT_EMPLOYEE.telephone_phone("08234567438","03244566449","01234537438");
        CONTACT_EMPLOYEE.mail("IBMTEAM@gmail.com","micheal@hotmail.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        CONTACT_EMPLOYEE.attchement_uploading("C://Users//asus//download.jpg");
        loggerj.info("public contact info saved");
        ExtentTest test3 = extent.createTest("contact page");
        test3.log(Status.INFO, "modify the information of the contact employee");
        test3.log(Status.PASS, "modification successful");
    }
    @Then("UPLOAD ATTACHEMENT AND SAVE THE INFO")
    @Test(priority=3,groups = {"sanity"})
    public void upload(){
        loggerj.info("attachment uploaded");
        CONTACT_EMPLOYEE.attchement_uploading("C://Users//asus//download.jpg");
        loggerj.info("public contact info saved");
        ExtentTest test4 = extent.createTest("UPLOAD ATTACHMENT");
        test4.log(Status.INFO, "upload attachment");
        test4.log(Status.PASS, "modification successful and attachment saved");
    }
    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        try {
            if (testResult.getStatus() == ITestResult.FAILURE) {
                String screenshotPath = EMPLOYEE_DETAILS.capture(driver, "contact");
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
    public void quit(){
        // Quit the WebDriver instance
        extent.flush();
        if (driver != null) {
            driver.quit();
        }
    }
}

