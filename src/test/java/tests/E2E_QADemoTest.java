package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.HomePage;

import java.nio.file.Paths;
import java.time.Duration;

public class E2E_QADemoTest extends BaseTest {

    @Test
    public void e2e_login_and_subscribe_success() {

        // Open local QA Demo page (index.html)
        String localDemoUrl = Paths.get(System.getProperty("user.dir"),
                "src", "test", "resources", "site", "index.html")
                .toUri()
                .toString();

        driver.get(localDemoUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        HomePage homePage = new HomePage(driver);

        // Valid credentials from your index.html script:
        // u === "tomsmith" && p === "SuperSecretPassword!"
        homePage.login("tomsmith", "SuperSecretPassword!");

        // Wait for either login success OR login error (fail fast)
        wait.until(d ->
                d.findElements(By.id("loginSuccess")).size() > 0 ||
                d.findElements(By.id("loginError")).size() > 0
        );

        // If login error is shown, fail with message
        if (driver.findElements(By.id("loginError")).size() > 0
                && driver.findElement(By.id("loginError")).isDisplayed()) {
            String err = driver.findElement(By.id("loginError")).getText();
            Assert.fail("Login failed. Page showed: " + err);
        }

        DashboardPage dashboardPage = new DashboardPage(driver);

        // Assert login success message is displayed
        wait.until(d -> dashboardPage.isLoginSuccessDisplayed());
        Assert.assertTrue(dashboardPage.isLoginSuccessDisplayed(),
                "Expected loginSuccess message to be displayed after valid login.");

        String loginSuccess = dashboardPage.getLoginSuccessText();
        Assert.assertTrue(loginSuccess.toLowerCase().contains("success"),
                "Expected a login success message, but got: " + loginSuccess);

        // Subscribe with a valid email (your HTML checks regex)
        dashboardPage.enterNewsletterEmail("zeba.test@example.com");
        dashboardPage.clickSubscribe();

        // Wait for either email success or email error
        wait.until(d ->
                d.findElements(By.id("emailSuccess")).size() > 0 ||
                d.findElements(By.id("emailError")).size() > 0
        );

        // Assert email subscription success
        Assert.assertTrue(dashboardPage.isEmailSuccessDisplayed(),
                "Expected emailSuccess message after subscribing with a valid email.");

        String emailSuccess = dashboardPage.getEmailSuccessText();
        Assert.assertTrue(emailSuccess.toLowerCase().contains("subscribed"),
                "Expected 'Subscribed' success message, but got: " + emailSuccess);
    }
}
