# OrangeHRM Automation QA Project
The testing type for the OrangeHRM Automation QA Project involves several methodologies and frameworks, primarily focusing on Behavior-Driven Development (BDD), Test-Driven Development (TDD), and functional testing. Here's a breakdown based on the technologies and approaches mentioned:
##  Behavior-Driven Development (BDD) with Cucumber:
Cucumber is a BDD tool that allows developers to write acceptance tests in plain text using Gherkin syntax. This approach makes the tests easily understandable by both technical and non-technical stakeholders, facilitating communication and collaboration during the development process.
##  Test-Driven Development (TDD) with TestNG:
TestNG is a testing framework inspired by JUnit and NUnit introducing some new functionalities that make it more powerful and easier to use. While TestNG itself does not enforce TDD, it supports the practice by allowing developers to write tests before implementing the functionality they test. This ensures that every piece of code has corresponding tests, promoting a robust and reliable codebase.
Functional Testing with Selenium WebDriver:
Selenium WebDriver is a collection of open-source APIs that are used to automate the testing of a web application. It allows for simulating user interactions with the web application, such as clicking buttons, filling out forms, and navigating through pages. This form of testing is crucial for validating the functionality of the web application against the expected outcomes.
##  Integration Testing:
The project also involves integration testing, where individual units are combined and tested as a group. This is evident in the scenario where different functionalities like logging in, creating and modifying employee records, and testing the functioning of different modules are automated. This ensures that the components of the system work together as expected.
## Reporting with Extent Reports and Log4j:
Extent Reports are used for generating detailed HTML reports of the test execution, including pass/fail status, screenshots, and logs. This aids in analyzing the test results and identifying areas for improvement. Log4j is utilized for logging trace information, which is essential for debugging and monitoring the application's behavior during testing.
In summary, the OrangeHRM Automation QA Project employs a combination of BDD, TDD, functional testing, and integration testing methodologies, leveraging tools like Cucumber, TestNG, Selenium WebDriver, Extent Reports, and Log4j. This comprehensive approach ensures thorough validation of the application's features and functionalities, contributing to the overall quality assurance of the system.
# Technologies Used
We utilize the following technologies in our project:
- **POM (Page Object Model Pattern)**: Organizes web elements and actions for efficient test maintenance.
- **TestNG**: Supports Test-Driven Development (TDD) by structuring test suites and executing tests.
- **Cucumber BDD with Gherkin Syntax**: Implements Behavior-Driven Development (BDD) for clear, human-readable tests.
- **Selenium Web Automation Framework**: Automates web browsers for end-to-end testing.
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

# FAILED TEST CASES SCREENSHOT
1. ADD A NEW USER LINK:![adduser](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/bb86fa52-8b3b-4f6a-ba68-6163b8b34678)

2. MODIFY EMPLOYEE INFO LINK:![info](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/5fc03d87-8eff-4d73-9d3c-b574c90edf97)

3. LOGIN INTERFACE V1 LINK:![login](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/441b365b-9979-4a7b-b133-0eb3dff867fa)

4. LOGIN INTERFACE V2 LINK:![screenshotinfo](https://github.com/mamedras/OrangeHRM_TestNG_Cucumber_Selenium_Automation/assets/71017688/0d736541-b379-4884-846b-e9af3bd66632) 

# manual test case 
[ORANGEHRM_TESTCASE_AUTOMATION.xlsx] https://docs.google.com/spreadsheets/d/1w15Q6GqJDq8cq4sfOElV3Hoyeg-l-pDbHlytAd862z8/edit#gid=0

# Conclusion

This project exemplifies the application of modern testing methodologies and tools to ensure the reliability and functionality of the OrangeHRM application. By automating QA processes, we aim to streamline testing efforts and enhance the overall quality of the application.


