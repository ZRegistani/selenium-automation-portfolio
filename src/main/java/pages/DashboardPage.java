package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * DashboardPage represents the page shown after successful login.
 */
public class DashboardPage {

    private WebDriver driver;

    // ===== Locators =====
    private By headerTitle = By.id("header");
    private By logoutButton = By.id("logoutBtn");
    private By newsletterInput = By.id("newsletterEmail");
    private By subscribeButton = By.id("subscribeBtn");
    private By successMessage = By.id("successMessage");

    // ===== Constructor =====
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Validations =====
    public boolean isHeaderDisplayed() {
        return driver.findElement(headerTitle).isDisplayed();
    }

    public String getHeaderText() {
        return driver.findElement(headerTitle).getText();
    }

    // ===== Newsletter Actions =====
    public void enterNewsletterEmail(String email) {
        driver.findElement(newsletterInput).clear();
        driver.findElement(newsletterInput).sendKeys(email);
    }

    public void clickSubscribe() {
        driver.findElement(subscribeButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    // ===== Logout =====
    public void logout() {
        driver.findElement(logoutButton).click();
    }
}

