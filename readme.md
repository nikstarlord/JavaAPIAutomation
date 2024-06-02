# API Automation Framework
A robust, reusable, and maintainable API automation framework built with industry-standard tools:
- Java 17
- RestAssured
- Cucumber
- Allure Reporting
- TestNG

This framework is designed to streamline API testing, ensuring efficiency, readability, & comprehensive reporting.
## Pre-requisite
Before you begin, ensure you have the following installed:
- Java 17
- Maven 4.0.0

## 🚀 Getting Started
Follow these steps to set up the project on your local machine:

1. Clone the repository
```shell
git clone https://github.com/nikstarlord/JavaAPIAutomation.git 
```
2. Open the project in your favourite IDE
3. Build the project to install all the required dependencies & plugins:
```shell
mvn clean install
```

## Running the Tests 
#### Option 1: Run via Maven
Execute tests directly from the command line:

```shell
mvn clean verify -Pallure-report
```
This command: 
1. Cleans the project
2. Runs all tests
3. Generate Allure reports

#### Option 2: Run via IDE
1. Navigate to src/test/java/org.example.restAssuredFramework.steps
2. Find the Test runner file named ``UserValidationTest``
3. Right-click & select `Run` or `Debug`

### 📈 Generating Allure Reports
Allure Framework provides clear, concise, and visually appealing test reports. After running tests:
1. Generate the report:
```shell
mvn allure:report
```
This creates the report in target/allure-results
2. Serve the report(opens in your default browser):

```shell
allure serve target/allure-results
```

## 🏗️ Architecture
The framework is meticulously organized into specialized packages, each serving a unique purpose
```html
.
├── 📜 .gitignore
├── 📦 pom.xml
└── 📂 src
├── 📂 main
│   ├── 📂 java
│   │   └── 📂 org
│   │       └── 📂 example
│   │           └── 📂 restAssuredFramework
│   │               ├── 📂 api
│   │               │   ├── 📄 BaseApi.java
│   │               │   ├── 📄 TodoApi.java
│   │               │   └── 📄 UserApi.java
│   │               ├── 📂 config
│   │               │   ├── 📄 Config.java
│   │               │   ├── 📄 Constants.java
│   │               │   └── 📄 Endpoints.java
│   │               ├── 📂 models
│   │               │   ├── 📄 Todo.java
│   │               │   └── 📄 User.java
│   │               └── 📂 utils
│   │                   ├── 📄 JsonUtils.java
│   │                   └── 📄 LoggerUtils.java
│   └── 📂 resources
│       ├── 📄 config.properties
│       └── 📄 log4j2.xml
└── 📂 test
|   ├── 📂 java
│   |   └── 📂 org
│   |       └── 📂 example
│   |           └── 📂 restAssuredFramework
│   |               ├── 📂 steps
│   |               │   └── 📄 UserSteps.java
│   |               └── 📂 runner
│   |                   └── 📄 UserValidationTest.java
    └── 📂 resources
        └── 📂 features
        |   └── 📄 user_validation.feature
        |── 📄testng.xml 
```
### 🌐 API Package
The heart of our framework, housing all API-related files:
- `BaseApi.java`: The foundation, providing core request methods.
- `TodoApi.java` & `UserApi.java`: Specialized classes for Todo & User endpoints, inheriting from `BaseApi.java`.

### ⚙️ Config Package
Central hub for all configurations:
- `Config.java`: Reads `config.properties`, making settings globally accessible.
- `Constants.java`: Single source of truth for all constants.
- `Endpoint.java`: Repository of all API endpoints, ensuring easy updates.

### 📦 Models Package
House of our system's entities:
- `User.java` & `Todo.java`: Mirror backend entities, preventing JSON key mishaps.

### 🛠️ Utils Package
A toolbox of reusable utilities:
- `JsonUtils.java` : Maps JSON responses to entities using JacksonDatabind.
- `LoggerUtils.java` : Offers `getLogger` for console & file logging via Log4j.

### 📚 main/resources
Core resources for the main package:
- `config.properties` : Stores configs like API base URLs.
- `log4j2.xml` : Configures Log4j logger settings.

### 🥒 Steps Package
The Cucumber heart of the framework:
- `UserSteps.java` : Holds all steps for `user_validation.feature`, enhancing maintainability.

### 🏃‍♂️ Runner Package
Orchestrates our Cucumber tests:
- `UserValidationTest.java` : Maps features to step methods, integrates Allure reporting.

### 🗄 test/resources
Assets for our test suite: 
- `features/` : Home to our Cucumber `.feature` files.
- `testng.xml` : Defines test suites and configurations.
