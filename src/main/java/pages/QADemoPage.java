package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.DriverManager;
import utils.Waits;


public class QADemoPage {

    private final WebDriver driver;
    private final Waits waits;

    // Header
    private final By header = By.tagName("h1");

    // Login
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.id("loginBtn");
    private final By loginSuccess = By.id("loginSuccess");
    private final By loginError = By.id("loginError");

    // Newsletter
    private final By emailInput = By.id("email");
    private final By subscribeBtn = By.id("subscribeBtn");
    private final By emailSuccess = By.id("emailSuccess");
    private final By emailError = By.id("emailError");

    public QADemoPage() {
    	
    	this.driver = DriverManager.getDriver();
        this.waits = new Waits(driver, 10);
    }

    /** Opens the local demo HTML page from src/test/resources/site/index.html */
    public void openLocal() {
        String path = System.getProperty("user.dir")
                + "/src/test/resources/site/index.html";
        driver.get("file:///" + path);
        waits.visible(header); // ensures page is loaded
    }


    public String getHeaderText() {
        return waits.visible(header).getText();
    }

    public void login(String username, String password) {
        waits.visible(usernameInput).clear();
        waits.visible(usernameInput).sendKeys(username);

        waits.visible(passwordInput).clear();
        waits.visible(passwordInput).sendKeys(password);

        waits.clickable(loginBtn).click();
    }

    public boolean isLoginSuccessVisible() {
        return waits.visible(loginSuccess).isDisplayed();
    }

    public boolean isLoginErrorVisible() {
        return waits.visible(loginError).isDisplayed();
    }

    public void subscribe(String email) {
        waits.visible(emailInput).clear();
        waits.visible(emailInput).sendKeys(email);

        waits.clickable(subscribeBtn).click();
    }

    public boolean isEmailSuccessVisible() {
        return waits.visible(emailSuccess).isDisplayed();
    }

    public boolean isEmailErrorVisible() {
        return waits.visible(emailError).isDisplayed();
    }
}
