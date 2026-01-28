# Selenium Testing Framework (Java + TestNG + Maven)

<<<<<<< HEAD
A clean Selenium UI automation framework built with Java, Maven, and TestNG,
following the Page Object Model (POM). Designed for readability, stability,
and scalability.
=======
A clean Selenium UI automation framework built with Java, Maven, and TestNG, following the Page Object Model (POM).  
Designed for readability, stability, and scalability.
>>>>>>> 7388c79 (chore: trigger CI run)

## Tech Stack
- Java 17
- Selenium WebDriver
- TestNG
- Maven

## Project Structure
<<<<<<< HEAD
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

## How to Run
```bash
mvn clean test

