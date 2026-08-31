# AutomationCICD 🚀

## 📌 Project Overview

A robust and maintainable **Selenium Test Automation Framework** built using **Java, Selenium WebDriver, and TestNG**, with a focus on parallel execution, targeted test-suite execution, retry handling, reporting, and CI/CD readiness.

## 🛠 Tech Stack

* **Language:** Java 17
* **Automation Tool:** Selenium WebDriver
* **Testing Framework:** TestNG
* **Design Pattern:** Page Object Model (POM)
* **Build Tool:** Maven
* **Test Data:** JSON + Jackson Databind
* **Reporting:** ExtentReports
* **Driver Management:** WebDriverManager
* **Version Control:** Git

## 🏗 Framework Architecture

The framework is structured to support modular and efficient test execution:

* **src/main/java:** Contains Page Objects, Abstract Components, and framework resources.
* **src/test/java:** Contains Test Classes, Test Components, Test Data, and test execution configuration.
* **Page Object Model:** Separates test logic from page-specific locators and business actions.
* **Abstract Components:** Contains reusable Selenium operations and common framework functionality.
* **TestNG Suites:** Organizes tests into Regression, Purchase, and Error Validation suites.
* **Maven Profiles:** Enables targeted execution of specific test suites.
* **Parallel Execution:** Configured through `testng.xml` with 5 threads.
* **Reporting:** ExtentReports integrated through custom TestNG Listeners.

## ✨ Key Features

* **Page Object Model:** Modular design for maintainability and reusability.
* **Reusable Components:** Common Selenium operations centralized in Abstract Components.
* **Parallel Execution:** TestNG configured for parallel execution using 5 threads.
* **Maven Profiles:** Supports separate execution of Regression, Purchase, and Error Validation suites.
* **Flaky Test Management:** Custom **Retry Analyzer** to re-run failed tests.
* **Custom Listener:** Handles test execution events, reporting, and failure handling.
* **Thread-Safe Reporting:** Uses `ThreadLocal<ExtentTest>` to maintain separate reports during parallel execution.
* **Failure Handling:** Automatically captures screenshots on test failure and attaches them to ExtentReports.
* **Data Handling:** Jackson Databind used for JSON-based test data.
* **CI/CD Ready:** Maven-based command-line execution allows integration with CI/CD pipelines.

## 🧪 Test Suites

* **Regression:** Executes the configured regression test suite.
* **Purchase:** Executes purchase/order-related scenarios.
* **Error Validation:** Executes negative and error-validation scenarios.

## ⚡ Maven Profile Execution

Run specific suites without modifying the test code:

`mvn clean test -PRegression`

`mvn clean test -PPurchase`

`mvn clean test -PErrorValidation`

## 🚀 How to Run

1. Clone the repository:
   `git clone https://github.com/Deepamattur11/AutomationCICD.git`
2. Navigate to the project folder.
3. Run the default suite:
   `mvn clean test`
4. Or execute a specific Maven profile using the commands above.
