package tests;

import base.BaseTest;
import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomeSearchPage;
import pages.GoogleResultsPage;

public class GoogleResultsLinksTest extends BaseTest {

    @Test
    public void resultsShouldContainLinksOrTitles() {

        DriverManager.getDriver().get("https://www.google.com");

        GoogleHomeSearchPage searchPage = new GoogleHomeSearchPage();
        GoogleResultsPage resultsPage = searchPage.searchFor("Selenium WebDriver");

        int count = resultsPage.getResultTitleCount();
        Assert.assertTrue(count > 0, "Expected at least 1 search result title, but found: " + count);
    }
}

