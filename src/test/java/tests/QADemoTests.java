package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QADemoPage;

public class QADemoTests extends BaseTest {

    @Test
    public void login_withValidCredentials_shouldSucceed() {
        QADemoPage page = new QADemoPage();
        page.openLocal();

        page.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(page.isLoginSuccessVisible(), "Expected login success message.");
    }

    @Test
    public void login_withInvalidCredentials_shouldShowError() {
        QADemoPage page = new QADemoPage();
        page.openLocal();

        page.login("wrongUser", "wrongPass");
        Assert.assertTrue(page.isLoginErrorVisible(), "Expected login error message.");
    }

    @Test
    public void subscribe_withValidEmail_shouldSucceed() {
        QADemoPage page = new QADemoPage();
        page.openLocal();

        page.subscribe("test@example.com");
        Assert.assertTrue(page.isEmailSuccessVisible(), "Expected email success message.");
    }

    @Test
    public void subscribe_withInvalidEmail_shouldShowError() {
        QADemoPage page = new QADemoPage();
        page.openLocal();

        page.subscribe("not-an-email");
        Assert.assertTrue(page.isEmailErrorVisible(), "Expected email error message.");
    }

    @Test
    public void demoHeader_shouldBeVisible() {
        QADemoPage page = new QADemoPage();
        page.openLocal();

        Assert.assertEquals(page.getHeaderText().trim(), "QA Demo App", "Header text mismatch.");
    }
}
