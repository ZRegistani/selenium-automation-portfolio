package com.zeba.automation.tests;

import com.zeba.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void verifyGoogleTitle() {
        driver.get("https://www.google.com");

        Assert.assertTrue(
                driver.getTitle().toLowerCase().contains("google"),
                "Title did not contain 'google'"
        );
    }
}
