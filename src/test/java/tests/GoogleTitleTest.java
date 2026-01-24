package tests;

import base.BaseTest;
import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTitleTest extends BaseTest {

    @Test
    public void googleTitleShouldContainGoogle() {

        DriverManager.getDriver().get("https://www.google.com");

        String title = DriverManager.getDriver().getTitle();
        Assert.assertTrue(title.toLowerCase().contains("google"),
                "Expected title to contain 'google' but was: " + title);
    }
}
