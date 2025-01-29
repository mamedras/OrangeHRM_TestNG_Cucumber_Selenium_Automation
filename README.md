# 🧑‍💻 OrangeHRM Automation QA Framework
# 📌 Project Overview
The OrangeHRM Automation QA Project focuses on automating acceptance and integration testing for the OrangeHRM web application. By leveraging Behavior-Driven Development (BDD) with Cucumber and Test-Driven Development (TDD) with TestNG, the project ensures the reliability, scalability, and seamless functionality of the platform. The automation tests streamline key workflows such as user authentication, employee management, and administrative operations, reducing manual effort and delivering high-quality outcomes.
# 🌟 Key Features
- **Functional Testing with Selenium WebDriver:**
Automates critical workflows, including user interactions and system validations, to ensure application reliability.

- **Behavior-Driven Development (BDD):**
Implements Cucumber and Gherkin syntax to create human-readable test scenarios, fostering collaboration among stakeholders.

- **Test-Driven Development (TDD):**
Adopts TDD practices with TestNG for robust unit and integration testing, ensuring a high-quality codebase.

- **Comprehensive Reporting and Logging:**
Generates detailed test reports with Extent Reports and leverages Log4j for effective debugging and monitoring.
# 🔧 Technologies Used
We utilize the following technologies in our project:
- **Java**: Core programming language utilizing OOP principles.
- **POM (Page Object Model Pattern)**: Organizes web elements and actions for efficient test maintenance.
- **TestNG**: Supports Test-Driven Development (TDD) by structuring test suites and executing tests.
- **Cucumber BDD with Gherkin Syntax**: Implements Behavior-Driven Development (BDD) for clear, human-readable tests.
- **Selenium Webdriver**: Automates web browsers for end-to-end testing.
- **Extent Report**: Generates detailed test reports for easy analysis.
- **Log4j**: Creates trace log files for debugging and monitoring.
- **Apache POI**: Handles CSV file operations for data storage and manipulation.
- **Maven**: Manages project dependencies and builds.

# 📝 Automation QA Steps

Follow these steps to perform automated QA testing on the OrangeHRM application:

1. Visit the website: [https://opensource-demo.orangehrmlive.com/](https://opensource-demo.orangehrmlive.com/)
2. Attempt to log in as admin with incorrect credentials.
3. Log in successfully as Admin with the correct credentials.
4. Log out successfully as admin.
5. Log in again as admin.
6. Navigate to the admin info page modify personal and contact information, and then save changes.
7. Upload a file update the profile picture, and then save modifications.
8. Access the PIM page (available only to admins).
9. Add a new employee with a user account, add their information and contact details, and then save the changes.
10. Go to the employee list, type the new employee's ID, and press Enter.
11. After locating the record, log out as admin.
#  🛠️ Project Setup
# 1️⃣ Prerequisites
Ensure the following are installed on your machine:
- **Java** (JDK 8 or later)
- **Maven** (for project dependency management)
# 2️⃣ Clone the Repository
```sh
git clone https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation.git
cd OrangeHRM_TestNG_Cucumber_Selenium_Automation
```
# 3️⃣ Install Dependencies
Run the following Maven command to install required dependencies:
```sh
mvn install
```
# 4️⃣ Configuration
Update the configuration files with the necessary data such as:
- **Credentials:** (username, password)
- **Environment details:** (staging/production URL)
# 5️⃣ Running the Tests
You can run the tests using Maven or directly from the IDE:

```sh
mvn test
```

# 📸 Failed Test Cases Screenshots
1. Add new user:![adduser](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/bb86fa52-8b3b-4f6a-ba68-6163b8b34678)

2. Modify the employee`s info:![info](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/5fc03d87-8eff-4d73-9d3c-b574c90edf97)

3. Login screenshot 1:![login](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/441b365b-9979-4a7b-b133-0eb3dff867fa)

4. Login screenshot 2:![screenshotlogin](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/7c6c044d-72b8-424a-8cd0-87cc2df81a5e)

# 📝 Manual Test Case Documentation
[ORANGEHRM_TESTCASE_AUTOMATION.xlsx] https://docs.google.com/spreadsheets/d/1w15Q6GqJDq8cq4sfOElV3Hoyeg-l-pDbHlytAd862z8/edit#gid=0
# 🏁 Conclusion
This project automates testing for key OrangeHRM workflows, ensuring high reliability and a reduced manual testing effort. It demonstrates the effective use of BDD and TDD methodologies, combined with detailed reporting and robust test automation. This framework can be further extended to accommodate new features and requirements for the OrangeHRM platform.



