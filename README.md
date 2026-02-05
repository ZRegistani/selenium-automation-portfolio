# Selenium Testing Framework (Java + TestNG + Maven)


A clean Selenium UI automation framework built with Java, Maven, and TestNG,
following the Page Object Model (POM). Designed for readability, stability,
and scalability.
=======
A clean Selenium UI automation framework built with Java, Maven, and TestNG, following the Page Object Model (POM).  
Designed for readability, stability, and scalability.


## Tech Stack
- Java 17
- Selenium WebDriver
- TestNG
- Maven

## Project Structure

- src/main/java/pages → Page Objects (Google/DuckDuckGo pages + QA Demo page)
- src/main/java/utils → Utilities (Waits)
- src/test/java/base → Base test + driver helpers
- src/test/java/tests → Test suite (TestNG)
- src/test/resources/site/index.html → Local demo page for UI testing

## Test Suite (What's Covered)
### Google / Search Validation
- GoogleResultsLinksTest → validates search returns result titles/links
- GoogleSearchResultsTest → validates search results load reliably
- GoogleTitleTest → validates page title after navigation

### QA Demo (Local HTML page)
- QADemoTests
  - Validates login success/error messaging
  - Validates newsletter subscription success/error messaging
  - Validates header visibility on page load
 
## BDD (Cucumber)
Implemented a BDD layer using Cucumber (Gherkin) with TestNG, enabling business-readable scenarios, 
reusable step definitions, centralized hooks, tag-based execution, and HTML reporting for smoke and negative test coverage.



## How to Run
```bash
mvn clean test

