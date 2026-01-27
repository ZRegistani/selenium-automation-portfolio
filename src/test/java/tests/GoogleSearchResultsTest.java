package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverManager;
import pages.GoogleHomeSearchPage;
import pages.GoogleResultsPage;

public class GoogleSearchResultsTest extends BaseTest {

    @Test
    public void searchShouldLoadResultsPage() {
        GoogleHomeSearchPage searchPage = new GoogleHomeSearchPage(DriverManager.getDriver());
        searchPage.open();

        GoogleResultsPage resultsPage = searchPage.searchFor("Selenium WebDriver");
        String title = resultsPage.getResultsTitle();

        Assert.assertTrue(title.toLowerCase().contains("selenium"),

                "Expected results page title to contain the search term, but title was: " + title);
    }
}
