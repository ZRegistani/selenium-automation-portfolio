package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * HomePage represents the landing page of the QA Demo application.
 * It contains elements and actions available before login.
 */
public class HomePage {

    private WebDriver driver;

    // ===== Locators (based on index.html) =====
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton   = By.id("loginBtn");
    private By loginError    = By.id("loginError");

    // ===== Constructor =====
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Actions =====
    public void enterUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    /**
     * Convenience method for login flow
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // ===== Validations =====
    public boolean isLoginErrorDisplayed() {
        return driver.findElement(loginError).isDisplayed();
    }

    public String getLoginErrorText() {
        return driver.findElement(loginError).getText();
    }
}
