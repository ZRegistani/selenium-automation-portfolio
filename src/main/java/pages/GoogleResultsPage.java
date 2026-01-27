package pages;

import base.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleResultsPage {

    private final WebDriverWait wait;

    private final By resultsContainer = By.id("search");
    private final By resultTitles = By.cssSelector("h3");

    public GoogleResultsPage() {
        this.wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
    }

    public void waitForResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsContainer));
    }

    public int getResultTitleCount() {
        waitForResults();
        List<WebElement> titles = DriverManager.getDriver().findElements(resultTitles);
        return titles.size();
    }

    public String getResultsTitle() {
        waitForResults();
        return DriverManager.getDriver().getTitle();
    }
}

