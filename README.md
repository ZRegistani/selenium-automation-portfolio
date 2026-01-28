# Selenium Testing Framework (Java + TestNG + Maven)

A clean Selenium UI automation framework built with Java, Maven, and TestNG, following the Page Object Model (POM).  
Designed for readability, stability, and scalability—similar to real-world SDET team frameworks.

## Tech Stack
- Java 17
- Selenium WebDriver
- TestNG
- Maven

## Key Framework Features
- **Page Object Model (POM):** UI locators + actions live in `src/main/java/pages`
- **Explicit Waits Utility:** `utils/Waits` wraps WebDriverWait for stable tests (no hard sleeps)
- **Driver Lifecycle Management:** setup/teardown handled in `src/test/java/base/BaseTest`
- **Clean Maven Structure:** separation between framework code and test code

## Project Structure
- `src/main/java/pages` → Page Objects (Google/DuckDuckGo pages + QA Demo page)
- `src/main/java/utils` → Utilities (Waits)
- `src/test/java/base` → Base test + driver helpers
- `src/test/java/tests` → Test suite (TestNG)

## Test Suite (What’s Covered)
### Google / Search Validation
- **GoogleResultsLinksTest**: validates a real search returns result titles/links (basic search results verification)
- **GoogleSearchResultsTest**: validates search results load and can be asserted reliably
- **GoogleTitleTest**: validates page title behavior after search/navigation

### QA Demo
- **QADemoTests**
  - `demoFormSubmit_shouldShowSuccessMessage`: validates demo form submission returns a success message
  - `demoHeader_shouldBeVisible`: validates the page header is present and readable

## How to Run
### Run all tests
```bash
mvn clean test
## CI / GitHub Actions

This project includes a GitHub Actions workflow that automatically runs the UI test suite on every push and pull request to `main`.

- Uses Java 17 (Temurin)
- Runs Maven tests with TestNG
- Executes in a headless Linux environment

Workflow file:
.github/workflows/ui-tests.yml
