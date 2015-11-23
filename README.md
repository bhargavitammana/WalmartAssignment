# WalmartAssignment
Softwares required to run this application:
git
eclipse
selenium webdriver
chrome
chromedriver

Steps to run the tests
--
1. extract code using "git clone https://github.com/bhargavitammana/WalmartAssignment.git"
2. import project as a java project in eclipse workspace
3. provide the downloaded chromedriver path in /WMTAssignment/src/com/walmart/ecommerce/tests/config/TestConfiguration.java file
4. Move to TestWalmart.java and run that as a JUnit test

Improvements need to be done if an additional time provided
- All the configurations for UI elements and test data can be moved to a config/data file where we can read and update the configurations
- Data driven test implementation With an additional code, we can invoke the test scripts using different test data by reading from an excel/csv file to cover all scenarios
