package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utils.Waits;

public class GoogleHomeSearchPage {

    private final WebDriver driver;
    private final Waits waits;

    private final By searchBox = By.id("searchbox_input");

    public GoogleHomeSearchPage(WebDriver driver) {
        this.driver = driver;
        this.waits = new Waits(driver, 10);
    }

    public void open() {
        driver.get("https://duckduckgo.com/");
        waits.visible(searchBox);
    }

    public GoogleResultsPage searchFor(String query) {
        waits.visible(searchBox).sendKeys(query + Keys.ENTER);
        return new GoogleResultsPage(driver);

    }
}
