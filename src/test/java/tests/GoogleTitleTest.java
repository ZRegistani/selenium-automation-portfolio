package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverManager;
import pages.GoogleHomePage;

public class GoogleTitleTest extends BaseTest {

    @Test
    public void googleTitleShouldContainGoogle() {
        GoogleHomePage home = new GoogleHomePage(DriverManager.getDriver());
        home.open();

        String title = base.DriverManager.getDriver().getTitle();

        Assert.assertTrue(title.toLowerCase().contains("google"),
                "Expected title to contain 'google' but was: " + title);
    }
}
