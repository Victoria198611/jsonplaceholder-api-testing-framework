JSONPlaceholder API Testing Framework

General Description:
This project represents an automated testing framework for the JSONPlaceholder API, built in Java using RestAssured, TestNG, and Allure Reports. The framework covers both positive and negative scenarios, validates status codes and payloads, and generates Allure reports with Behaviors, Epic, Feature, and Story.

🛠️ Technologies Used:
•	Java 17
•	Maven
•	RestAssured
•	TestNG
•	Allure Reports 2.23.0
•	JSONPlaceholder API
•	IntelliJ IDEA
•	GitHub Actions (CI)

Project Structure:
src
 ├── main
 │    └── java
 │         └── com.jsonplaceholder.api.api
 │              └── App.java
 └── test
      ├── java
      │    ├── config
      │    ├── models
      │    ├── services
      │    └── tests
      └── resources
           ├── allure.properties
           ├── config.properties
           └── environment.properties

Explanation:
•	config – reading configuration values (URL, timeout, etc.)
•	models – DTO objects for request/response
•	services – request logic (GET/POST/PUT/DELETE)
•	tests – actual test cases, grouped by endpoints and scenarios.

How to Run the Tests:
Run TestNG tests:
mvn clean test

Generate the Allure report:
allure serve target/allure-results

The report includes:
•	Overview
•	Suites
•	Behaviors (Epic, Feature, Story)
•	Timeline
•	Graphs

 Covered Scenarios:
•	GET valid post
•	GET invalid post
•	POST create valid post
•	POST create invalid post
•	PUT update valid
•	PUT update invalid
•	DELETE valid
•	DELETE invalid

Each test includes:
•	Status code validation
•	Body validation
•	Allure steps
•	Allure labels (Epic, Feature, Story, Severity)

 Allure Behaviors Integration:
The framework uses:
•	@Epic("JSONPlaceholder API")
•	@Feature("Posts API")
•	@Story("Create Post"), etc.
These annotations allow clear grouping of tests inside the Allure report.

 CI/CD Integration with GitHub Actions:
The project includes a CI pipeline configured with GitHub Actions, which automatically runs the tests on every push or pull request. The workflow performs:
•	Maven dependency installation
•	Running TestNG tests
•	Generating Allure results
•	Archiving allure-results as an artifact
This integration ensures continuous verification of project stability and provides visibility into test results directly in GitHub.

Conclusion:
This framework demonstrates:
•	good practices in API testing
•	complete Allure reporting
•	positive and negative scenarios
•	CI/CD integration with GitHub Actions

Author:
Victoria — QA Automation Tester, created for professional portfolio and continuous development.
