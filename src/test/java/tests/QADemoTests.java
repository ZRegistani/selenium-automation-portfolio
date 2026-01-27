package tests;

import base.BaseTest;                 // ✅ ADD THIS
import base.DriverManager;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QADemoPage;

public class QADemoTests extends BaseTest {
   
    @Test
    public void demoFormSubmit_shouldShowSuccessMessage() {
        QADemoPage page = new QADemoPage(DriverManager.getDriver());

        // If you have a URL for your demo page, open it here:
        // driver.get("file:///C:/path/to/index.html");
        // or page.open() if you later add an open() method.

        page.submitDemoForm("hello world");

        String msg = page.getSuccessMessage();
        Assert.assertTrue(msg != null && !msg.trim().isEmpty(),
                "Expected a non-empty success message after submission.");
    }

    @Test
    public void demoHeader_shouldBeVisible() {
    	 QADemoPage page = new QADemoPage(DriverManager.getDriver());

        String header = page.getHeaderText();
        Assert.assertTrue(header != null && !header.trim().isEmpty(),
                "Expected a non-empty header on the QA Demo page.");
    }
}
