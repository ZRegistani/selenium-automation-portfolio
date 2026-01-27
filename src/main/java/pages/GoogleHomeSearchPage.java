package pages;

import base.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * Page object focused on Google search actions.
 */
public class GoogleHomeSearchPage {

    // Locator for the Google search input field
    private final By searchBox = By.name("q");

    public GoogleHomeSearchPage() {
        // No driver needed in constructor when using DriverManager (ThreadLocal)
    }

    public void typeSearch(String text) {
        WebElement box = DriverManager.getDriver().findElement(searchBox);
        box.clear();
        box.sendKeys(text);
    }

    public void submitSearch() {
        DriverManager.getDriver().findElement(searchBox).sendKeys(Keys.ENTER);
    }

    public GoogleResultsPage searchFor(String text) {
        typeSearch(text);
        submitSearch();
        return new GoogleResultsPage(); // update this page class the same way
    }
}
