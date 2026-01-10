package com.zeba.automation.tests;

import com.zeba.automation.base.BaseTest;
import com.zeba.automation.pages.GoogleHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void verifyGoogleTitle() {
        GoogleHomePage google = new GoogleHomePage(driver).open();

        Assert.assertTrue(
                google.getTitle().toLowerCase().contains("google"),
                "Title did not contain 'google'"
        );
    }
}
