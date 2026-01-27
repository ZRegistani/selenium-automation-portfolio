package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Waits;

public class GoogleResultsPage {

    private final WebDriver driver;
    private final Waits waits;

    private final By resultsTitle = By.cssSelector("a[data-testid='result-title-a']");

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver, 10);
    }

    public String getResultsTitle() {
        waits.visible(resultsTitle);
        return driver.getTitle();
    }

    public int getResultTitleCount() {
        waits.visible(resultsTitle);
        List<WebElement> titles = driver.findElements(resultsTitle);
        return titles.size();
    }
}
