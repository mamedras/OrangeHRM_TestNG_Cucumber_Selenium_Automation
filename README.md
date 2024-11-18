# OrangeHRM Automation QA Framework
The OrangeHRM Automation QA Project focuses on automating acceptance and integration testing for the OrangeHRM web application. By leveraging Behavior-Driven Development (BDD) with Cucumber and Test-Driven Development (TDD) with TestNG, the project ensures the reliability, scalability, and seamless functionality of the platform. The automation tests streamline key workflows such as user authentication, employee management, and administrative operations, reducing manual effort and delivering high-quality outcomes.
# Key Features
Functional testing of critical workflows using Selenium WebDriver.
BDD implementation with Cucumber and Gherkin syntax for human-readable test scenarios.
TDD adoption to ensure robust unit and integration testing with TestNG.
Detailed test reporting using Extent Reports and logging with Log4j.
# Technologies Used
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

# Requirements

Before starting, make sure you have the latest version of Java installed on your computer.

# Automation QA Steps

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
# Project Setup
1. Ensure Java is installed on your machine.
2. Clone this repository.
3. Install Maven and use it to download the project dependencies: mvn install.
4. Update configuration files with required data (e.g., credentials, environment)
# FAILED TEST CASES SCREENSHOT
1. ADD A NEW USER LINK:![adduser](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/bb86fa52-8b3b-4f6a-ba68-6163b8b34678)

2. MODIFY EMPLOYEE INFO LINK:![info](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/5fc03d87-8eff-4d73-9d3c-b574c90edf97)

3. LOGIN INTERFACE V1 LINK:![login](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/441b365b-9979-4a7b-b133-0eb3dff867fa)

4. LOGIN INTERFACE V2 LINK:![screenshotlogin](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/7c6c044d-72b8-424a-8cd0-87cc2df81a5e)

# manual test case 
[ORANGEHRM_TESTCASE_AUTOMATION.xlsx] https://docs.google.com/spreadsheets/d/1w15Q6GqJDq8cq4sfOElV3Hoyeg-l-pDbHlytAd862z8/edit#gid=0

# Conclusion

This project automates testing for key OrangeHRM workflows, ensuring high reliability and a reduced manual testing effort. It demonstrates effective use of BDD and TDD methodologies, combined with detailed reporting and robust test automation.



