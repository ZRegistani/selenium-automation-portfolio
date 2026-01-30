package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * DashboardPage represents the area shown after successful login.
 * In your local index.html, this is indicated by #loginSuccess being shown.
 */
public class DashboardPage {

    private WebDriver driver;

    // ===== Locators (based on index.html) =====
    private By loginSuccessMessage = By.id("loginSuccess");

    private By newsletterEmailInput = By.id("email");
    private By subscribeButton      = By.id("subscribeBtn");
    private By emailSuccessMessage  = By.id("emailSuccess");
    private By emailErrorMessage    = By.id("emailError");

    // ===== Constructor =====
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Login Success (acts like "dashboard loaded") =====
    public boolean isLoginSuccessDisplayed() {
        return driver.findElement(loginSuccessMessage).isDisplayed();
    }

    public String getLoginSuccessText() {
        return driver.findElement(loginSuccessMessage).getText();
    }

    // ===== Newsletter =====
    public void enterNewsletterEmail(String email) {
        driver.findElement(newsletterEmailInput).clear();
        driver.findElement(newsletterEmailInput).sendKeys(email);
    }

    public void clickSubscribe() {
        driver.findElement(subscribeButton).click();
    }

    public boolean isEmailSuccessDisplayed() {
        return driver.findElement(emailSuccessMessage).isDisplayed();
    }

    public String getEmailSuccessText() {
        return driver.findElement(emailSuccessMessage).getText();
    }

    public boolean isEmailErrorDisplayed() {
        return driver.findElement(emailErrorMessage).isDisplayed();
    }

    public String getEmailErrorText() {
        return driver.findElement(emailErrorMessage).getText();
    }
}
