// QADemoPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QADemoPage {

    private WebDriver driver;

    // Locators (update these IDs if your app uses different ones)
    private By pageHeader = By.tagName("h1");
    private By sampleInput = By.id("sampleInput");
    private By submitButton = By.id("submitBtn");
    private By successMessage = By.id("successMessage");

    public QADemoPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns the main header text of the QA Demo page.
     */
    public String getHeaderText() {
        return driver.findElement(pageHeader).getText();
    }

    /**
     * Enters text into the sample input field.
     */
    public void enterSampleText(String text) {
        driver.findElement(sampleInput).clear();
        driver.findElement(sampleInput).sendKeys(text);
    }

    /**
     * Clicks the submit button on the QA Demo page.
     */
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    /**
     * Performs a complete demo form submission flow.
     */
    public void submitDemoForm(String text) {
        enterSampleText(text);
        clickSubmit();
    }

    /**
     * Returns the success message text after form submission.
     */
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
