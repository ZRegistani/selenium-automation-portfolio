# Selenium Automation Framework (Java + TestNG + Maven)

A clean Selenium UI automation framework built with Java, Maven, and TestNG,
following the Page Object Model (POM) design pattern.

Designed for readability, stability, and scalability — similar to real-world
SDET team frameworks.

---

## Tech Stack
- Java 17
- Selenium WebDriver
- TestNG
- Maven

---

## Key Framework Features
- **Page Object Model (POM)**  
  UI locators and actions live in `src/main/java/pages`

- **Explicit Waits Utility**  
  `utils/Waits` wraps `WebDriverWait` for stable tests (no hard sleeps)

- **Driver Lifecycle Management**  
  Setup/teardown handled in `src/test/java/base/BaseTest`

- **Clean Maven Structure**  
  Clear separation between framework code and test code

---

## Project Structure
