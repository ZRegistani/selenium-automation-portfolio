package tests;

import base.BaseTest;
import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomeSearchPage;
import pages.GoogleResultsPage;

public class GoogleSearchResultsTest extends BaseTest {

    @Test
    public void searchShouldLoadResultsPage() {

        DriverManager.getDriver().get("https://www.google.com");

        GoogleHomeSearchPage searchPage = new GoogleHomeSearchPage();
        GoogleResultsPage resultsPage = searchPage.searchFor("Selenium WebDriver");

        String title = resultsPage.getResultsTitle();

        Assert.assertTrue(
                title.toLowerCase().contains("selenium"),
                "Expected results page title to contain the search term, but title was: " + title
        );
    }
}
